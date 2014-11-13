package com.scripts.runespan;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Platforms {

    FLOAT(1, new double[] {0.1}, new int[] {-1}, -1),
    EARTH(9, new double[] {0.4}, new int[] {-1}, -1),
    ICE(15, new double[] {0.4}, new int[] {-1}, -1),
    SMALL_MISSILE(20, new double[] {0.3, 0.5, 0.6, 0.7}, new int[] {-1}, -1),
    CONJURATION(25, new double[] {0.9}, new int[] {-1}, -1),
    MISSILE(35, new double[] {1.2, 1.4, 1.5, 1.6}, new int[] {-1}, -1),
    VINE(44, new double[] {2.2}, new int[] {-1}, -1),
    MIST(50, new double[] {2.5}, new int[] {-1}, -1),
    COMET(55, new double[] {3.9}, new int[] {-1}, -1),
    SKELETAL(66, new double[] {2.5}, new int[] {-1}, -1),
    GREATER_MISSILE(77, new double[] {3.8, 4.4, 4.1, 4.2}, new int[] {-1}, -1),
    FLESH(85, new double[] {6.2}, new int[] {-1}, -1),
    GREATER_CONJURATION(95, new double[] {9.9}, new int[] {-1}, -1);

    private Platforms(int requiredLevel, double[] pointCost, int[] runesRequired, int platformID) {
        this.requiredLevel = requiredLevel;
        this.pointCost = pointCost;
        this.runesRequired = runesRequired;
        this.platformID = platformID;
    }

    private int requiredLevel;
    private double[] pointCost;
    private int[] runesRequired;
    private int platformID;
}
