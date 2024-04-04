package mobrokbot.pojos;

import java.util.HashMap;

/**
 * DataSet initialsing and populating a puplic HashMap, can only be initialised once
 */
public class DataSet {
    private static DataSet instance;
    /*
    HashMap containing i_poscount and Axes
     */
    public HashMap<Integer, Axes> dataMap = new HashMap<>();

    private DataSet() {
        dataMap.put(0, new Axes(114.690105, 98.83218384, 86.5335083, -88.71868896));
        dataMap.put(1, new Axes(114.690105, 82.79907419, 81.36700034, -77.9744914));
        dataMap.put(2, new Axes(114.690105, 75.05328012, 52.96480029, -72.71319708));
        dataMap.put(3, new Axes(114.690105, 87.44140625, 5.922607422, -85.35467529));
        dataMap.put(4, new Axes(114.690105, 87.44140625, 5.922607422, -85.35467529));
        dataMap.put(5, new Axes(118.6381327, 78.48120366, 23.76919777, -81.49984221));
        dataMap.put(6, new Axes(149.7207581, 48.31771798, 66.7771732, -108.268578));
        dataMap.put(7, new Axes(180.9550079, 25.468396, 84.05515137, -153.6463806));
        dataMap.put(8, new Axes(188.0, 20.68371582, 85.96646118, -165.49823));
        dataMap.put(9, new Axes(188.0, 20.68371582, 85.96646118, -165.49823));
        dataMap.put(10, new Axes(178.8972659, 11.27568232, 88.84777444, -150.6488455));
        dataMap.put(11, new Axes(157.6060055, -7.039199773, 85.08445556, -122.7284702));
        dataMap.put(12, new Axes(136.3188445, -16.29914551, 65.85761414, -101.2262878));
        dataMap.put(13, new Axes(115.8137507, -7.430787665, 16.13730842, -93.92580402));
        dataMap.put(14, new Axes(114.690105, -3.6640625, 6.116119385, -97.54159546));
        dataMap.put(15, new Axes(114.690105, -3.6640625, 6.116119385, -97.54159546));

    }

    public static DataSet getInstance(){
        if (instance == null){
            instance = new DataSet();
        }
        return instance;
    }
}
