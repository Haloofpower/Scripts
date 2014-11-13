package com.scripts.runespan;

import com.scripts.utils.Task;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import java.util.*;

/**
 * Created by Jeremy on 11/12/2014.
 */
public class RuneSpan extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {

    }

    @Override
    public void poll() {
        for (Task task : taskList) {
            if (task.activate()) {
                task.execute();
            }
        }
    }
}
