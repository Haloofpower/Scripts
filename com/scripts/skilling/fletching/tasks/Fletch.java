package com.scripts.skilling.fletching.tasks;

import com.scripts.utils.Task;
import org.powerbot.script.rt6.ClientContext;

/**
 * Created by Jeremy on 11/12/2014.
 */
public class Fletch extends Task<ClientContext> {

    public Fletch(ClientContext ctx) {
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
