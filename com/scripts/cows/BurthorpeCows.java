package com.scripts.cows;

import com.scripts.utils.Task;
import com.scripts.cows.tasks.*;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;

import java.util.*;

import java.awt.*;
import java.util.List;

/**
 * Created by Jeremy on 10/30/2014.
 */
public class BurthorpeCows extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new AttackCows(ctx), new Loot(ctx), new TanHides(ctx), new Bank(ctx), new SellHides(ctx)));
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
