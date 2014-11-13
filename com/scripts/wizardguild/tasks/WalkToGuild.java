package com.scripts.wizardguild.tasks;

import com.scripts.utils.Task;
import com.scripts.wizardguild.stuff.Required;
import org.powerbot.script.Area;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Player;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class WalkToGuild extends Task<ClientContext> {

    private final Player p = ctx.players.local();
    private final Area YANILLE = Required.locations.YANILLE.getLocation();

    public WalkToGuild(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return YANILLE.contains(p);
    }

    @Override
    public void execute() {

    }
}
