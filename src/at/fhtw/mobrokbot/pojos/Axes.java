package at.fhtw.mobrokbot.pojos;

import java.util.HashMap;
import java.util.function.DoubleToLongFunction;

public class Axes {

    public Double rot_Z1;
    public Double rot_Z2;
    public Double trans_Z;
    public Double l4_Z_rot;
    public Axes (Double trans_Z, Double rot_Z1, Double rot_Z2, Double l4_Z_rot){
        this.rot_Z1 = rot_Z1;
        this.rot_Z2 =rot_Z2;
        this.trans_Z = trans_Z;
        this.l4_Z_rot = l4_Z_rot;
    }
}
