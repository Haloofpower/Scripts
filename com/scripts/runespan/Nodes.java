package com.scripts.runespan;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Nodes {
    CYCLONE(1, -1),
    MIND_STORM(1, -1),
    WATER_POOL(5, -1),
    ROCK_FRAGMENT(9, -1),
    FIREBALL(14, -1),
    VINE(17, -1),
    FLESHY_GROWTH(20, -1),
    FIRE_STORM(27, -1),
    CHAOTIC_CLOUD(35, -1),
    NEBULA(40, -1),
    SHIFTER(44, -1),
    JUMPER(54, -1),
    SKULLS(65, -1),
    BLOOD_POOL(77, -1),
    BLOODY_SKULLS(83, -1),
    LIVING_SOUL(90, -1),
    UNDEAD_SOUL(95, -1);

    private Nodes(int levelRequired, int nodeID) {
        this.levelRequired = levelRequired;
        this.nodeID = nodeID;
    }

    private int levelRequired;
    private int nodeID;
}
