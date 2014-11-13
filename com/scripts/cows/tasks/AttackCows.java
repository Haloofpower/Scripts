package com.scripts.cows.tasks;

import com.scripts.utils.Task;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Npc;
import org.powerbot.script.rt6.Player;

import java.util.concurrent.Callable;

/**
 * Created by Jeremy on 10/30/2014.
 */
public class AttackCows extends Task<ClientContext> {

    private int[] targetNPCS = {};
    private int[] itemIDS = {};

    private final Player player = ctx.players.local();

    public AttackCows(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !ctx.npcs.select().id(targetNPCS).within(10).isEmpty() && !ctx.groundItems.select().within(2).isEmpty() && !player.inCombat() && ctx.backpack.select().count() < 28;
    }

    @Override
    public void execute() {
        final Npc target = ctx.npcs.select().id(targetNPCS).poll();

        ctx.camera.turnTo(target);
        if (player.tile().distanceTo(target.tile()) > 3) {
            ctx.movement.step(target.tile());
            Condition.wait(new Callable<Boolean>() {

                @Override
                public Boolean call() throws Exception {
                    return player.tile() == target.tile();
                }
            });
        }

    }

    public int[] getTargetNPCS() {
        return targetNPCS;
    }

    public void setTargetNPCS(int[] targetNPCS) {
        this.targetNPCS = targetNPCS;
    }

    public int[] getItemIDS() {
        return itemIDS;
    }

    public void setItemIDS(int[] itemIDS) {
        this.itemIDS = itemIDS;
    }


}
