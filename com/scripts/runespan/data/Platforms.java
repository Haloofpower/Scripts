package com.scripts.runespan.data;

/**
 * Created by Jeremy on 11/6/2014.
 */
public enum Platforms {

    FLOAT(1, new double[] {0.1}, new int[] {Runes.AIR.getRuneID()}, new int[] {70472, 70473, 70476, 70477, 70483, 70494}, false),
    EARTH(9, new double[] {0.4}, new int[] {Runes.EARTH.getRuneID()}, new int[] {70474, 70478, 70479, 70484, 70485, 70495}, false),
    ICE(15, new double[] {0.4}, new int[] {Runes.AIR.getRuneID(), Runes.WATER.getRuneID()}, new int[] {70475, 70480, 70486, 70496}, false),
    SMALL_MISSILE(20, new double[] {0.3, 0.5, 0.6, 0.7}, new int[] {Runes.MIND.getRuneID()}, new int[] {70481, 70482, 70488, 70492}, true),
    CONJURATION(25, new double[] {0.9}, new int[] {Runes.ESSENCE.getRuneID(), Runes.MIND.getRuneID(), Runes.BODY.getRuneID()}, new int[] {70488, 70498}, false),
    MISSILE(35, new double[] {1.2, 1.4, 1.5, 1.6}, new int[] {Runes.CHAOS.getRuneID()}, new int[] {70489, 70499}, true),
    VINE(44, new double[] {2.2}, new int[] {Runes.WATER.getRuneID(), Runes.EARTH.getRuneID(), Runes.NATURE.getRuneID()}, new int[] {70490, 70500}, false),
    MIST(50, new double[] {2.5}, new int[] {Runes.WATER.getRuneID(), Runes.BODY.getRuneID(), Runes.NATURE.getRuneID()}, new int[] {70492, 70493, 70502}, false),
    COMET(55, new double[] {3.9}, new int[] {Runes.COSMIC.getRuneID(), Runes.LAW.getRuneID(), Runes.ASTRAL.getRuneID()}, new int[] {70494, 70503}, false),
    SKELETAL(66, new double[] {2.5}, new int[] {Runes.DEATH.getRuneID()}, new int[] {70503}, false),
    GREATER_MISSILE(77, new double[] {3.8, 4.4, 4.1, 4.2}, new int[] {Runes.BLOOD.getRuneID(), Runes.DEATH.getRuneID()}, new int[] {70504, 70505}, true),
    FLESH(85, new double[] {6.2}, new int[] {Runes.BLOOD.getRuneID(), Runes.DEATH.getRuneID(), Runes.BODY.getRuneID()}, new int[] {70506}, false),
    GREATER_CONJURATION(95, new double[] {9.9}, new int[] {Runes.ESSENCE.getRuneID(), Runes.BLOOD.getRuneID(), Runes.DEATH.getRuneID(), Runes.BODY.getRuneID(),
            Runes.MIND.getRuneID(), Runes.SOUL.getRuneID()}, new int[] {70508}, false);

    private Platforms(int requiredLevel, double[] pointCost, int[] runesRequired, int[] platformID, boolean requiresElemental) {
        this.requiredLevel = requiredLevel;
        this.pointCost = pointCost;
        this.runesRequired = runesRequired;
        this.platformID = platformID;
        this.requiresElemental = requiresElemental;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public double[] getPointCost() {
        return pointCost;
    }

    public int[] getRunesRequired() {
        return runesRequired;
    }

    public int[] getPlatformID() {
        return platformID;
    }

    public boolean getRequiresElemental() {
        return requiresElemental;
    }

    private int requiredLevel;
    private double[] pointCost;
    private int[] runesRequired;
    private int[] platformID;
    private boolean requiresElemental;
}
