package at.fhtw.mobrokbot.pojos;

import java.util.HashMap;
import java.util.function.DoubleToLongFunction;

public class Axes {

    public HashMap<String, Double> axesMap = new HashMap<>();

    public Axes (Double rot_Z1, Double rot_Z2, Double trans_Z, Double l4_Z_rot){
        axesMap.put("rot_Z1",rot_Z1);
        axesMap.put("rot_Z2",rot_Z2);
        axesMap.put("trans_Z",trans_Z);
        axesMap.put("l4_Z_rot",l4_Z_rot);
    }
}
