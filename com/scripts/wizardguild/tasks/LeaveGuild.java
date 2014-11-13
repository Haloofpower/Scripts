package com.scripts.wizardguild.tasks;

import com.scripts.utils.Task;
import org.powerbot.script.rt6.ClientContext;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class LeaveGuild extends Task<ClientContext> {

    public LeaveGuild(ClientContext ctx) {
        super(ctx);
    }
    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public void execute() {

    }
}
