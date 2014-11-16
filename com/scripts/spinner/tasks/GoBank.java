package com.scripts.spinner.tasks;

import com.scripts.spinner.Lumbridge;
import com.scripts.utils.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.Bank;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Player;

import java.util.concurrent.Callable;

/**
 * Created by Jeremy on 11/11/2014.
 */
public class GoBank extends Task<ClientContext> {

    private final Player player = ctx.players.local();

    public GoBank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.backpack.select().id(1779).isEmpty();
    }

    @Override
    public void execute() {
        final State state = state();
        final GameObject stairMid = ctx.objects.select().id(36774).poll();
        final GameObject bank = ctx.objects.select().id(36786).poll();
        switch (state) {
            case UP_STAIRS:
                Lumbridge.currentTask = "Going Up";
                ctx.camera.turnTo(stairMid);
                if (ctx.movement.step(new Tile(3205, 3209, 1))) {
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !player.inMotion();
                        }
                    }, 120, 50);
                    stairMid.interact("Climb-up", "Staircase");
                }
                break;
            case DO_BANK:
                Lumbridge.currentTask = "Banking";
                if (ctx.bank.opened()) {
                    ctx.bank.depositInventory();
                }
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.backpack.isEmpty();
                    }
                }, 150, 20);
                if (ctx.bank.select().id(1779).count() > 0) {
                    ctx.bank.withdraw(1779, Bank.Amount.ALL);
                } else {
                    ctx.controller.stop();
                }
                break;
            case OPEN_BANK:
                Lumbridge.currentTask = "Banking";
                if (ctx.movement.step(new Tile(3208, 3220, 2))) {
                    ctx.camera.turnTo(bank);
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !player.inMotion() || player.tile() == new Tile(3208, 3220, 2);
                        }
                    }, 120, 50);
                    bank.interact("Bank", "Bank booth");
                }
                break;
        }
    }

    public State state() {
        if (player.tile().floor() == 1) {
            return State.UP_STAIRS;
        }
        if (ctx.bank.open()) {
            return State.DO_BANK;
        }
        return State.OPEN_BANK;
    }
    public enum State {
        UP_STAIRS, OPEN_BANK, DO_BANK
    }
}
