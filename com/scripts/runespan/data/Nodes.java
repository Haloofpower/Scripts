package com.scripts.runespan.data;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Nodes {

    CYCLONE(1, 70455),
    MIND_STORM(1, 40456),
    WATER_POOL(5, 40457),
    ROCK_FRAGMENT(9, 70458),
    FIREBALL(14, 70459),
    VINE(17, 40460),
    FLESHY_GROWTH(20, 40461),
    FIRE_STORM(27, 40462),
    CHAOTIC_CLOUD(35, 40463),
    NEBULA(40, 40464),
    SHIFTER(44, 40465),
    JUMPER(54, 40466),
    SKULLS(65, 40467),
    BLOOD_POOL(77, 40468),
    BLOODY_SKULLS(83, 40469),
    LIVING_SOUL(90, 40470),
    UNDEAD_SOUL(95, 40471);

    private Nodes(int levelRequired, int nodeID) {
        this.levelRequired = levelRequired;
        this.nodeID = nodeID;
    }

    private int levelRequired;
    private int nodeID;
}
