package com.scripts.runespan.data;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Creatures {

    FLOATING_ESSENCE(1, 15402),
    AIR_ESSLING(1, 15403),
    MIND_ESSLING(1, 15404),
    WATER_ESSLING(5, 15405),
    EARTH_ESSLING(9, 15406),
    FIRE_ESSLING(14, 15407),
    BODY_ESSHOUND(20, 15408),
    COSMIC_ESSHOUND(27, 15409),
    CHAOS_ESSHOUND(35, 15410),
    ASTRAL_ESSHOUND(40, 15411),
    NATURE_ESSHOUND(44, 15412),
    LAW_ESSHOUND(54, 15413),
    DEATH_ESSWRAITH(65, 15414),
    BLOOD_ESSWRAITH(77, 15415),
    SOUL_ESSWRAITH(90, 15416);

    private Creatures(int levelRequired, int creatureID) {
        this.levelRequired = levelRequired;
        this.creatureID = creatureID;
    }

    public int getLevel() {
        return levelRequired;
    }

    public int getCreatureID() {
        return creatureID;
    }

    private int levelRequired;
    private int creatureID;
}
