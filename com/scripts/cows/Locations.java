package com.scripts.cows;

import org.powerbot.script.Tile;

public enum Locations {

    BURTHORPE_COWS_ENTRANCE(new Tile(2884, 3492)),
    BANK(new Tile(1, 1, 0)),
    JACK_OVAL(new Tile(2887, 3502));

    private Locations(Tile tile) {
        this.tile = tile;
    }

    private final Tile tile;

    public Tile getTile() {
        return tile;
    }
}