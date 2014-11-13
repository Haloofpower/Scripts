package com.scripts.skilling.superheating;

import com.scripts.skilling.superheating.tasks.*;
import com.scripts.utils.Task;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Jeremy on 11/10/2014.
 */
public class SuperHeater extends PollingScript<ClientContext> implements MessageListener, PaintListener {
    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new Banking(ctx), new Heat(ctx)));
    }

    @Override
    public void poll() {
        for (Task task : taskList) {
            if (task.activate()) {
                task.execute();
            }
        }
    }

    @Override
    public void messaged(MessageEvent messageEvent) {

    }

    @Override
    public void repaint(Graphics graphics) {

    }
}
