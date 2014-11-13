package com.scripts.agility.objects;

/**
 * Created by Jeremy on 11/10/2014.
 */
public enum Burthorpe {
    LOG_BEAM(-1),
    WALL(-1),
    BALANCING_LEDGE(-1),
    LOW_WALL(-1),
    ROPE_SWING(-1),
    MONKEY_BARS(-1),
    LEDGE(-1);

    private final int id;

    private Burthorpe(int objectID) {
        this.id = objectID;
    }

    public int getObjectID() {
        return id;
    }
}
