package com.scripts.combat.types;

/**
 * Created by Jeremy on 11/9/2014.
 */
public enum Magic {

    WRACK(1, 0, false, false),
    SURGE(2, 0, false, false),
    IMPACT(3, 0, false, false),
    CHAIN(4, 0, false, false),
    COMBUST(5, 0, false, false),
    DRAGON_BREATH(6, 0, false, false),
    ASPHYXIATE(7, 50, false, false),
    DETONATE(8, 50, false, false),
    WILD_MAGIC(9, 50, false, false),
    METAMORPHOSIS(10, 100, false, false),
    TSUNAMI(11, 100, false, false),
    OMNIPOWER(12, 100, false, false),
    SONIC_WAVE(165, 0, false, true),
    CONCENTRATED_BLAST(166, 0, true, false),
    DEEP_IMPACT(171, 50, false, false);

    private final int componentID;
    private final int adrenalineRequired;
    private final boolean dualWeapons;
    private final boolean twoHanded;

    private Magic(int componentID, int adrenalineRequired, boolean dualWeapons, boolean twoHanded) {
        this.componentID = componentID;
        this.adrenalineRequired = adrenalineRequired;
        this.dualWeapons = dualWeapons;
        this.twoHanded = twoHanded;
    }

    public int getComponentID() {
        return componentID;
    }

    public int getAdrenalineRequired() {
        return adrenalineRequired;
    }

    public boolean getRequiresDual() {
        return dualWeapons;
    }

    public boolean requiresTwoHanded() {
        return twoHanded;
    }
}
