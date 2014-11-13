package com.scripts.runespan.data;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Runes {

    ESSENCE(0, 24227),
    AIR(.1, 24215),
    MIND(.2, 24217),
    WATER(.3, 24214),
    EARTH(.4, 24216),
    FIRE(.5, 24213),
    BODY(.7, 24218),
    COSMIC(.9, 24223),
    CHAOS(1.1, 24221),
    ASTRAL(1.3, 24224),
    NATURE(1.5, 24220),
    LAW(1.7, 24222),
    DEATH(2.5, 24219),
    BLOOD(3, 24225),
    SOUL(3.5, 24226);

    private Runes(double pointValue, int runeID) {
        this.pointValue = pointValue;
        this.runeID = runeID;
    }

    public double getPointValue() {
        return pointValue;
    }

    public int getRuneID() {
        return runeID;
    }

    private double pointValue;
    private int runeID;
}
