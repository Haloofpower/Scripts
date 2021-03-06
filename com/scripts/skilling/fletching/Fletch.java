package com.scripts.skilling.fletching;

import com.scripts.utils.Task;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;
import com.scripts.skilling.fletching.tasks.*;

import java.util.*;

/**
 * Created by Jeremy on 11/12/2014.
 */
public class Fletch extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new DoBank(ctx), new DoFletch(ctx)));
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
