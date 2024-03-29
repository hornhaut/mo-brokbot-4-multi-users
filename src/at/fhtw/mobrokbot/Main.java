package at.fhtw.mobrokbot;

import at.fhtw.mobrokbot.pojos.Axes;
import at.fhtw.mobrokbot.pojos.DataSet;
import org.eclipse.paho.client.mqttv3.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String BASETOPIC = "MoBrokbot/";
    private static final String PUBLISHER_ID = "EngMaA2";

    public static int i_poscount = 0;

    public static IMqttClient publisher;

    public static void main(String[] args) {

        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        try {
            publisher = new MqttClient("tcp://engine.ie.technikum-wien.at:1883", PUBLISHER_ID);
            publisher.connect(options);
            sendTimeStamp();

        } catch (MqttException e) {
            throw new RuntimeException(e);
            // proper error handling please
        }
        DataSet ds = DataSet.getInstance();
        
        Runnable newDataSet = () -> {
            Axes axes = ds.dataMap.get(i_poscount);
            prepAndSendMsg("rot_Z1",axes.rot_Z1);
            prepAndSendMsg("rot_Z2",axes.rot_Z2 + Math.random() * 2.52 - 1.26);// random error +-1.26
            prepAndSendMsg("l4_Z_rot", axes.l4_Z_rot);
            prepAndSendMsg("trans_ZA2", axes.trans_Z - 1.08); //systematic error -1.08
            prepAndSendMsg("i_poscount", i_poscount);
            if (i_poscount < 15) i_poscount++;
            else i_poscount = 0;

            sendTimeStamp();
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(newDataSet, 0, 5, TimeUnit.SECONDS);


    }

    private static void sendTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String dateStr = String.format(formatter.format(date));
        System.out.println(dateStr);
        MqttMessage msg = new MqttMessage(dateStr.getBytes());
        msg.setQos(2);
        msg.setRetained(false);
        try {
            publisher.publish(BASETOPIC + PUBLISHER_ID + "/lastmsg", msg);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }

    private static void prepAndSendMsg(String topic, Double value){
        MqttMessage msg = new MqttMessage(Double.toString(value).getBytes());
        sendMsg(topic, msg);
    }

    private static void prepAndSendMsg(String topic, int value){
        MqttMessage msg = new MqttMessage(Integer.toString(value).getBytes());
        sendMsg(topic, msg);
    }

    private static void sendMsg(String topic, MqttMessage msg){
        msg.setQos(2);
        msg.setRetained(false);
        try {
            publisher.publish(BASETOPIC + PUBLISHER_ID + "/" + topic, msg);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }


}
