package com.scripts.wizardguild.tasks;

import com.scripts.utils.Task;
import com.scripts.wizardguild.stuff.Required;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.GameObject;
import org.powerbot.script.rt6.Player;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class EnterGuild extends Task<ClientContext> {

    private final Player p = ctx.players.local();

    private final GameObject[] GUILD_DOORS = {};

    public EnterGuild(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Required.locations.YANILLE.getLocation().contains(p) && ctx.objects.select().id(GUILD_DOORS).nearest().poll().tile().distanceTo(p) <= 2;
    }

    @Override
    public void execute() {

    }
}
