package com.scripts.spinner.tasks;

import com.scripts.spinner.Lumbridge;
import com.scripts.utils.Task;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt6.*;

import java.util.concurrent.Callable;

/**
 * Created by Jeremy on 11/11/2014.
 */
public class Spin extends Task<ClientContext> {

    private final Player player = ctx.players.local();

    private int lastExp = ctx.skills.experience(12);

    public Spin(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return player.animation() != 1563 && !ctx.backpack.select().id(1779).isEmpty();
    }

    @Override
    public void execute() {
        final State state = state();
        final GameObject spinningWheel = ctx.objects.select().id(36970).poll();
        final GameObject topStair = ctx.objects.select().id(36775).poll();

        switch (state) {
            case DOWN_STAIRS:
                Lumbridge.currentTask = "Going Down";
                final Widget bank = ctx.widgets.widget(Constants.BANK_WIDGET);
                if (bank.valid()) {
                    ctx.bank.close();
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !bank.valid();
                        }
                    }, 120, 50);
                }
                ctx.camera.turnTo(topStair);
                if (ctx.movement.step(new Tile(3205, 3209, 2))) {
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return !player.inMotion();
                        }
                    }, 120, 50);
                    topStair.interact("Climb-down", "Staircase");
                }
                break;
            case SPINNING:
                Lumbridge.currentTask = "Spinning";
                final Widget spinning = ctx.widgets.widget(1370);
                if (!spinning.valid()) {
                    if (spinningWheel.interact("Spin", "Spinning Wheel")) {
                        Condition.wait(new Callable<Boolean>() {
                            @Override
                            public Boolean call() throws Exception {
                                return !player.inMotion();
                            }
                        }, 120, 50);
                    }
                } else {
                    spinning.component(38).click();
                }
                do {
                    if (Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return ctx.skills.experience(12) > lastExp;
                        }
                    }, 120, 50)) {
                        Lumbridge.amountSpun += 1;
                        lastExp += 15;
                    }
                } while(player.animation() == 1563 && !ctx.backpack.select().id(1779).isEmpty());
                break;
        }
    }

    public State state() {
       if (player.tile().floor() == 2) {
           return State.DOWN_STAIRS;
       }
       return State.SPINNING;
    }

    public enum State {
        SPINNING, DOWN_STAIRS
    }
}
