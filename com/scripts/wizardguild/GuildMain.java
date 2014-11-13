package com.scripts.wizardguild;

import com.scripts.utils.Task;
import com.scripts.wizardguild.tasks.*;
import org.powerbot.script.MessageEvent;
import org.powerbot.script.MessageListener;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.rt6.ClientContext;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Jeremy on 11/3/2014.
 */
public class GuildMain extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private List<Task> taskList = new ArrayList<Task>();

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new TeleportToYanille(ctx), new WalkToYanille(ctx), new WalkToGuild(ctx), new Bank(ctx),
                new EnterGuild(ctx), new TeleGrabLoot(ctx), new GoDownLadder(ctx), new GoUpLadder(ctx), new Zombie(ctx), new LeaveGuild(ctx)));
    }

    @Override
    public void poll() {

    }

    @Override
    public void messaged(MessageEvent messageEvent) {

    }

    @Override
    public void repaint(Graphics graphics) {

    }
}
