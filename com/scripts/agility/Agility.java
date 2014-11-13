package com.scripts.agility;

import com.scripts.utils.Task;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;
import com.scripts.agility.tasks.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeremy on 11/10/2014.
 */
public class Agility extends PollingScript<ClientContext> {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new Gnome(ctx), new Barbarian(ctx)));
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
