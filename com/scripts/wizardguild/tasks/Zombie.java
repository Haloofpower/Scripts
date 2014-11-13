package com.scripts.wizardguild.tasks;

import com.scripts.utils.Task;
import com.scripts.wizardguild.stuff.Required;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Player;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class Zombie extends Task<ClientContext> {

    private Player player = ctx.players.local();

    public Zombie(ClientContext ctx) {
        super(ctx);
    }
    @Override
    public boolean activate() {
        return Required.locations.WGUILD_ZOMBIES.getLocation().contains(ctx.players.local());
    }

    @Override
    public void execute() {
        State state = state();
        switch (state) {
            case FIGHT:
                break;
            case ENGAGE:
                break;
            case LOOT:
                break;
        }
    }

    public State state() {
        if (!player.inCombat()) {
            return State.ENGAGE;
        }
        return State.FIGHT;
    }

    public enum State {
        ENGAGE, FIGHT, LOOT;
    }
}
