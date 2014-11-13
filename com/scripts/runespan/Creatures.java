package com.scripts.runespan;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Creatures {
    AIR_ESSLING(1, -1),
    MIND_ESSLING(1, -1),
    WATER_ESSLING(5, -1),
    EARTH_ESSLING(9, -1),
    FIRE_ESSLING(14, -1),
    BODY_ESSHOUND(20, -1),
    COSMIC_ESSHOUND(27, -1),
    CHAOS_ESSHOUND(35, -1),
    ASTRAL_ESSHOUND(40, -1),
    NATURE_ESSHOUND(44, -1),
    LAW_ESSHOUND(54, -1),
    DEATH_ESSWRAITH(65, -1),
    BLOOD_ESSWRAITH(77, -1),
    SOUL_ESSWRAITH(90, -1);

    private Creatures(int levelRequired, int creatureID) {
        this.levelRequired = levelRequired;
        this.creatureID = creatureID;
    }

    public int getLevel() {
        return levelRequired;
    }

    private int levelRequired;
    private int creatureID;
}
