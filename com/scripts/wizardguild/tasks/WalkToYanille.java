package com.scripts.wizardguild.tasks;

import com.scripts.utils.Lodestones;
import com.scripts.utils.Task;
import com.scripts.wizardguild.stuff.Required;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Player;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class WalkToYanille extends Task<ClientContext> {


    private final Player p = ctx.players.local();

    public WalkToYanille(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return !Lodestones.YANILLE.canUse(ctx) && !Required.locations.YANILLE.getLocation().contains(p);
    }

    @Override
    public void execute() {

    }
}
