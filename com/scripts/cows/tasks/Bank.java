package com.scripts.cows.tasks;

import com.scripts.utils.Task;
import org.powerbot.script.rt6.ClientContext;

/**
 * Created by Jeremy on 10/30/2014.
 */
public class Bank extends Task<ClientContext> {

    public Bank(ClientContext ctx) {
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
