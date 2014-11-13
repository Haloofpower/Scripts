package com.scripts.wizardguild.tasks;

import com.scripts.utils.Lodestones;
import com.scripts.utils.Task;
import com.scripts.wizardguild.stuff.Required;
import org.powerbot.script.Area;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Player;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class TeleportToYanille extends Task<ClientContext> {

    private final Player p = ctx.players.local();
    private final Area YANILLE = Required.locations.YANILLE.getLocation();
    private final Area ZOMBIES = Required.locations.WGUILD_ZOMBIES.getLocation();

    public TeleportToYanille(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Lodestones.YANILLE.canUse(ctx) && !ZOMBIES.contains(p) && !YANILLE.contains(p) && YANILLE.getCentralTile().distanceTo(p) > 150;
    }

    @Override
    public void execute() {

    }
}
