package at.fhtw.mobrokbot;

import org.eclipse.paho.client.mqttv3.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String BASETOPIC = "MoBrokbot/";

    public static int i_poscount = 0;

    public static void main(String[] args) {
        String publisherId = "EngMaA2";
        IMqttClient publisher;
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        try {
            publisher = new MqttClient("tcp://engine.ie.technikum-wien.at:1883",publisherId);
            publisher.connect(options);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();

            MqttMessage msg = new MqttMessage(String.format(formatter.format(date)).getBytes());
            msg.setQos(2);
            msg.setRetained(false);
            publisher.publish(BASETOPIC+publisherId+"/lastmsg",msg);

        } catch (MqttException e) {
            throw new RuntimeException(e);
            // proper error handling please
        }

        Runnable newDataSet = new Runnable() {
            public void run() {

                System.out.println("Hello world " + i_poscount);
                if (i_poscount<15) i_poscount++; else i_poscount=0;;
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(newDataSet, 0, 5, TimeUnit.SECONDS);

    }


}
