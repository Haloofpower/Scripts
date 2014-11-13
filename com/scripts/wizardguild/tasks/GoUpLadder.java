package com.scripts.wizardguild.tasks;

import com.scripts.utils.Task;
import org.powerbot.script.rt6.ClientContext;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class GoUpLadder extends Task<ClientContext> {

    public GoUpLadder(ClientContext ctx) {
        super(ctx);
    }
    @Override
    public boolean activate() {
        return ctx.backpack.select().count() == 28;
    }

    @Override
    public void execute() {

    }
}
