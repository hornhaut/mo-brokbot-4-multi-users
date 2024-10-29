package mobrokbot.pojos;

public class Errors {
    private final Double rot_Z1;
    private final Double rot_Z2;
    private final Double trans_Z;
    private final Double l4_Z_rot;

    private final boolean rot_Z1isRandom;
    private final boolean rot_Z2isRandom;
    private final boolean trans_ZisRandom;
    private final boolean l4_Z_rotisRandom;

    public Errors(Double rot_Z1, boolean rot_Z1isRandom, Double rot_Z2, boolean rot_Z2isRandom, Double l4_Z_rot, boolean l4_Z_rotisRandom, Double trans_Z, boolean trans_ZisRandom) {
        this.l4_Z_rot = l4_Z_rot;
        this.l4_Z_rotisRandom = l4_Z_rotisRandom;
        this.trans_Z = trans_Z;
        this.trans_ZisRandom = trans_ZisRandom;
        this.rot_Z2 = rot_Z2;
        this.rot_Z2isRandom = rot_Z2isRandom;
        this.rot_Z1 = rot_Z1;
        this.rot_Z1isRandom = rot_Z1isRandom;
    }
    public Double getRot_Z1() {
        if (rot_Z1isRandom){
            return Math.random() * (rot_Z1 * 2) - rot_Z1;
        } else {
            return rot_Z1;
        }
    }

    public Double getRot_Z2() {
        if (rot_Z2isRandom){
            return Math.random() * (rot_Z2 * 2) - rot_Z2;
        } else {
            return rot_Z2;
        }
    }

    public Double getTrans_Z() {
        if (trans_ZisRandom){
            return Math.random() * (trans_Z * 2) - trans_Z;
        } else {
            return trans_Z;
        }
    }

    public Double getL4_Z_rot() {
        if (l4_Z_rotisRandom){
            return Math.random() * (l4_Z_rot * 2) - l4_Z_rot;
        } else {
            return l4_Z_rot;
        }
    }
}
