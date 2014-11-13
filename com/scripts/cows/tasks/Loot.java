package com.scripts.cows.tasks;

import com.scripts.utils.Task;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GroundItem;

/**
 * Created by Jeremy on 10/30/2014.
 */
public class Loot extends Task<ClientContext> {

    private int[] itemIDS = {};

    public Loot(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public void execute() {
     final GroundItem item = ctx.groundItems.select().id(itemIDS).poll();
    }
}
