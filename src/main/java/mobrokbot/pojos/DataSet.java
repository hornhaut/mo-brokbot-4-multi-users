package mobrokbot.pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * DataSet initialsing and populating puplic HashMaps containting axes values (dataMap) and their errors (errorMap), can only be initialised once
 */
public class DataSet {
    private static DataSet instance;
    /*
    HashMap containing i_poscount and Axes
     */
    public HashMap<Integer, Axes> axesMap = new HashMap<>();
    public Map<Integer,Errors> errorMap = new HashMap<>();

    private DataSet() {
        axesMap.put(0, new Axes(114.690105, 98.83218384, 86.5335083, -88.71868896));
        axesMap.put(1, new Axes(114.690105, 82.79907419, 81.36700034, -77.9744914));
        axesMap.put(2, new Axes(114.690105, 75.05328012, 52.96480029, -72.71319708));
        axesMap.put(3, new Axes(114.690105, 87.44140625, 5.922607422, -85.35467529));
        axesMap.put(4, new Axes(114.690105, 87.44140625, 5.922607422, -85.35467529));
        axesMap.put(5, new Axes(118.6381327, 78.48120366, 23.76919777, -81.49984221));
        axesMap.put(6, new Axes(149.7207581, 48.31771798, 66.7771732, -108.268578));
        axesMap.put(7, new Axes(180.9550079, 25.468396, 84.05515137, -153.6463806));
        axesMap.put(8, new Axes(188.0, 20.68371582, 85.96646118, -165.49823));
        axesMap.put(9, new Axes(188.0, 20.68371582, 85.96646118, -165.49823));
        axesMap.put(10, new Axes(178.8972659, 11.27568232, 88.84777444, -150.6488455));
        axesMap.put(11, new Axes(157.6060055, -7.039199773, 85.08445556, -122.7284702));
        axesMap.put(12, new Axes(136.3188445, -16.29914551, 65.85761414, -101.2262878));
        axesMap.put(13, new Axes(115.8137507, -7.430787665, 16.13730842, -93.92580402));
        axesMap.put(14, new Axes(114.690105, -3.6640625, 6.116119385, -97.54159546));
        axesMap.put(15, new Axes(114.690105, -3.6640625, 6.116119385, -97.54159546));

        errorMap.put(0, new Errors(
                0.0, false,
                1.26, true,
                0.0, false,
                -1.08, false));
        errorMap.put(1, new Errors(
                2.01, true,
                3.71, false,
                0.0, false,
                0.0, false));
        errorMap.put(2, new Errors(
                0.0, false,
                0.0, false,
                -0.81, false,
                2.91, true));
        errorMap.put(3, new Errors(
                1.39, false,
                0.0, false,
                3.54, true,
                0.0, false));
        errorMap.put(4, new Errors(
                -0.93, false,
                0.0, false,
                0.0, false,
                1.41, true));
        errorMap.put(5, new Errors(
                0.55, true,
                -3.75, false,
                0.0, false,
                0.0, false));
        errorMap.put(6, new Errors(
                0.0, false,
                2.91, true,
                -3.09, false,
                0.0, false));
        errorMap.put(7, new Errors(
                0.0, false,
                0.76, false,
                0.0, false,
                2.82, true));
        errorMap.put(8, new Errors(
                -2.01, false,
                0.0, false,
                3.28, true,
                0.0, false));
        errorMap.put(9, new Errors(
                0.0, false,
                0.0, false,
                2.18, true,
                -0.63, false));
        errorMap.put(10, new Errors(
                3.24, true,
                0.0, false,
                0.0, false,
                -1.75, false));
        errorMap.put(11, new Errors(
                0.0, false,
                0.0, false,
                -2.84, false,
                3.31, true));
        errorMap.put(12, new Errors(
                0.0, false,
                1.02, true,
                0.0, false,
                -2.16, false));
        errorMap.put(13, new Errors(
                0.59, true,
                2.07, false,
                0.0, false,
                0.0, false));
        errorMap.put(14, new Errors(
                -1.01, false,
                0.0, false,
                1.99, true,
                0.0, false));
        errorMap.put(15, new Errors(
                0.0, false,
                2.89, true,
                0.0, false,
                -3.20, false));

    }

    public static DataSet getInstance(){
        if (instance == null){
            instance = new DataSet();
        }
        return instance;
    }
}
