package com.scripts.wizardguild.tasks;

import com.scripts.utils.Task;
import com.scripts.wizardguild.stuff.Required;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Player;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class Bank extends Task<ClientContext> {

    private final Player p = ctx.players.local();

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28 && Required.locations.WIZARD_GUILD.getLocation().contains(p);
    }

    @Override
    public void execute() {

    }
}
