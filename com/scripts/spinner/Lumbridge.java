package com.scripts.spinner;

import com.scripts.utils.Task;
import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.*;
import com.scripts.spinner.tasks.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Jeremy on 11/11/2014.
 */
@Script.Manifest(name = "Lumbridge Flax Spinner", description = "Spins flax at Lumbridge Castle")
public class Lumbridge extends PollingScript<ClientContext> implements PaintListener{

    private List<Task> taskList = new ArrayList<Task>();
    private long startTime = System.currentTimeMillis();

    private final Font font = new Font("Calibri", Font.PLAIN, 14);
    private final Font mainFont = new Font("Calibri", Font.PLAIN, 12);

    public static String currentTask = "";
    public static int amountSpun = 0;

    @Override
    public void start() {
        taskList.addAll(Arrays.asList(new GoBank(ctx), new Spin(ctx)));
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
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        String time = "Time run: " + com.scripts.practice.Timer.format(ctx.controller.script().getRuntime());
        String task = "Current Task: " + currentTask;
        String strings = "Bowstring Spun: " + amountSpun;
        String spun = "Spun/Hr: " + perHour(amountSpun);
        String exp = "Experience Gained: " + (amountSpun * 15);
        String expHr = "Experience/Hr: " + perHour(amountSpun * 15);
        int tWidth = getTextWidth(strings, g);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(5, 5, tWidth + 40, 100);
        g.setColor(Color.WHITE);
        g.drawRect(5, 5, tWidth + 40, 100);
        g.setFont(mainFont);
        g.drawString(time, 10, 20);
        g.drawString(task, 10, 35);
        g.drawString(strings,10, 50);
        g.drawString(spun, 10, 65);
        g.drawString(exp, 10, 80);
        g.drawString(expHr, 10, 95);
    }

    public int getTextWidth(String string, Graphics2D g) {
        return g.getFontMetrics().stringWidth(string);
    }

    public int getTextHeight(Graphics2D g) {
        return g.getFontMetrics().getHeight();
    }

    public int perHour(int value) {
        return (int) ((value) * 3600000D / (System.currentTimeMillis() - startTime));
    }
}
