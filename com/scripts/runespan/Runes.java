package com.scripts.runespan;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Runes {
    AIR(.1),
    MIND(.2),
    WATER(.3),
    EARTH(.4),
    FIRE(.5),
    BODY(.7),
    COSMIC(.9),
    CHAOS(1.1),
    ASTRAL(1.3),
    NATURE(1.5),
    LAW(1.7),
    DEATH(2.5),
    BLOOD(3),
    SOUL(3.5);

    private Runes(double pointValue) {
        this.pointValue = pointValue;
    }

    public double getPointValue() {
        return pointValue;
    }

    private double pointValue;
}
