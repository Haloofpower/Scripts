package com.scripts.practice;

import org.powerbot.script.*;
import org.powerbot.script.Random;
import org.powerbot.script.rt6.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Component;


import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.concurrent.Callable;
import java.util.*;


/**
 * Created by Haloofpower on 10/22/2014.
 */
@Script.Manifest(name = "Burthorpe Money Making", description = "Kill cows, pick up and tan the hides, then craft and sell the stuff")
public class DoStuff extends PollingScript<ClientContext> implements PaintListener, MessageListener {

    private int[] cowIds = { 14997, 14998, 14999 };
    private Tile[] pathToCows = { new Tile(2891, 3502), new Tile(2891, 3494), new Tile(2885, 3494), new Tile(2885, 3495), new Tile(2884, 3495), new Tile(2884, 3492) };
    private Tile[] pathToJack = { new Tile(2884, 3492), new Tile(2884, 3495), new Tile(2885, 3495), new Tile(2885, 3494), new Tile(2891, 3494), new Tile(2891, 3502), new Tile(2887, 3502) };

    private int cowsKilled = 0;
    private int hidesGathered = 0;
    private int hidesTanned = 0;
    private int bootsMade = 0;
    private int moneyMade = 0;
    private long startTime = System.currentTimeMillis();
    private String currentTask = "";

    private TilePath path_ToCows = ctx.movement.newTilePath(pathToCows);
    private TilePath path_ToJack = ctx.movement.newTilePath(pathToJack);

    private final Player player = ctx.players.local();
    private BurthorpeGUI gui;

    @Override
    public void start() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new BurthorpeGUI(ctx);
            }
        });
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                return !gui.isVisible();
            }
        });
    }

    @Override
    public void poll() {
        final Npc target = ctx.npcs.select().id(cowIds).nearest().poll();
        final Npc jackOval = ctx.npcs.select().id(14877).poll();
        final GroundItem item = ctx.groundItems.select().id(1739).nearest().poll();
        final State state = state();
        switch (state) {
            case ATTACK:
                moveTo(ctx, pathToCows[4], null, false);
                    currentTask = "Selecting";
                    Tile targetTile = target.tile();
                    if (targetTile.distanceTo(player) > 3) {
                        ctx.movement.step(targetTile);
                        Condition.wait(new Callable<Boolean>() {
                            @Override
                            public Boolean call() throws Exception {
                                return player.tile() == target.tile();
                            }
                        });
                    }
                    ctx.camera.turnTo(target);
                    target.interact("Attack");
                    //System.out.print("Attacking cow, ");
                    Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            //System.out.print("waiting for cow to die, ");
                            currentTask = "Fighting";
                            return target.animation() == 23571 || target.animation() == 23566 || !target.valid();
                        }
                    });
                    //System.out.println("COW IS DEAD.");
                    cowsKilled += 1;
                break;
            case LOOT:
                Tile itemTile = item.tile();
                moveTo(ctx, itemTile, null, false);
                ctx.camera.turnTo(item);
                item.interact("Take", "Cowhide");
                Condition.wait(new Callable<Boolean>() {
                     @Override
                     public Boolean call() throws Exception {
                        return !item.valid();
                    }
                });
                hidesGathered += 1;
                break;
            case TAN:
                final Widget widget = ctx.widgets.select().id(1371).poll();
                currentTask = "Moving";
                if (player.tile() != pathToJack[6]) {
                    moveTo(ctx, null, path_ToJack, true);
                }
                //System.out.print("Moving to Jack Oval to tan Cowhides, ");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                       // System.out.print("waiting for player to stop moving, ");
                        return !player.inMotion();
                    }
                });
                //System.out.print("PLAYER HAS STOPPED MOVING, ");
                currentTask = "Interacting";
                jackOval.interact("Tan hide", "Jack Oval");
                //System.out.print("interacting with Jack Oval, ");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {

                        return widget.valid();
                    }
                });
                //System.out.println("PLAYER HAS INTERACTED WITH JACK.");
                currentTask = "Tanning";
                widget.component(44).component(6).interact("Select");
                Condition.sleep(500);
                widget.component(5).interact("Make "+ ctx.backpack.select().id(1739).count() +" Hard leather");
                Condition.sleep(500);
                ctx.widgets.widget(1370).component(30).interact("Close");
                hidesTanned += ctx.backpack.select().id(1743).count();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !ctx.widgets.widget(1370).component(30).valid();
                    }
                });
                break;
            case CRAFT:
                final Item i = ctx.backpack.select().id(1743).peek();
                final Component c1 = ctx.widgets.widget(1179).component(16);
                final Component c2 = ctx.widgets.widget(1371).component(44).component(32);
                final Component c3 = ctx.widgets.widget(1371).component(5);
                if (player.tile() != new Tile(2887, 3502, 0)) {
                    //path_ToJack.traverse();
                    moveTo(ctx, null, path_ToJack, true);
                }
                currentTask = "Crafting";
                i.interact("Craft");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return c1.valid();
                    }
                });
                c1.interact("Select");
                Condition.wait(new Callable<Boolean>() {
                        @Override
                        public Boolean call() throws Exception {
                            return c2.valid();
                        }
                });
                c2.interact("Select");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return c3.valid();
                    }
                });
                c3.interact("Make " + ctx.backpack.select().id(1743).count() + " Hard leather boots");
                Condition.sleep(1700 * ctx.backpack.select().id(1743).count());
                break;
            case SELL:
                final Component c4 = ctx.widgets.widget(1265).component(29);
                final Component c5 = ctx.widgets.widget(1265).component(20).component(1);
                if (player.tile() != new Tile(2887, 3502, 0)) {
                    //path_ToJack.traverse();
                    moveTo(ctx, null, path_ToJack, true);
                }
                currentTask = "Selling";
                jackOval.interact("Trade", "Jack Oval");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return c4.valid();
                    }
                });
                c4.interact("Sell");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return c5.valid();
                    }
                });
                moneyMade += ctx.backpack.select().id(25821).count() * 300;
                c5.interact("Sell 50");
                Condition.sleep(500);
                ctx.widgets.widget(1265).component(88).interact("Close");
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !ctx.widgets.widget(1265).component(88).valid();
                    }
                });
                if (ctx.backpack.select().id(1734).poll().stackSize() <= 5) {
                    currentTask = "Shutting down";
                    System.out.println("State.SELL");
                    Condition.sleep(2000);
                    ctx.controller.stop();
                }
                currentTask = "Moving";
                path_ToCows.traverse();
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return !player.inMotion();
                    }
                });
                break;
            case STOP:
                currentTask = "Shutting down";
                Condition.sleep(2000);
                ctx.controller.stop();
                break;
        }
    }

    public int perHour(int value) {
        return (int) ((value) * 3600000D / (System.currentTimeMillis() - startTime));
    }

    private final Font font = new Font("Calibri", Font.PLAIN, 14);
    private final Font mainFont = new Font("Calibri", Font.PLAIN, 12);

    @Override
    public void repaint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        String name = "Burthorpe AIO";
        String time = "Time run: " + Timer.format(ctx.controller.script().getRuntime());
        String task = "Current Task: " + currentTask;
        String cows = "Cows Killed: " + cowsKilled;
        String killed = "Killed/hr: " + perHour(cowsKilled);
        String hide = "Cowhides Looted: " + hidesGathered;
        String looted = "Looted/hr: " + perHour(hidesGathered);
        String tan = "Cowhides Tanned: " + perHour(hidesTanned);
        String tanned = "Tanned/hr: " + perHour(hidesTanned);
        String boots = "Boots Crafted: " + bootsMade;
        String crafted = "Boots/hr: " + perHour(bootsMade);
        String totalMoney = "Gold Made: " + moneyMade;
        String money = "Gold/hr: " + perHour(moneyMade);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(5, 5, getTextWidth(tan, g) + 30, 206);
        g.setColor(Color.WHITE);
        g.drawRect(5, 5, getTextWidth(tan, g) + 30, 206);
        g.setFont(font);
        g.drawString(name, 74 - (getTextWidth(name, g)/2), 20);
        g.drawLine(15, 25, getTextWidth(tan, g) + 25, 25);
        g.setFont(mainFont);
        g.drawString(time, 10, 40);
        g.drawString(task, 10, 55);
        g.drawString(cows,10, 70);
        g.drawString(killed, 10, 85);
        g.drawString(hide, 10, 100);
        g.drawString(looted, 10, 115);
        g.drawString(tan, 10, 130);
        g.drawString(tanned, 10, 145);
        g.drawString(boots, 10, 160);
        g.drawString(crafted, 10, 175);
        g.drawString(totalMoney, 10, 190);
        g.drawString(money, 10, 205);
    }

    public int getTextWidth(String string, Graphics2D g) {
        return g.getFontMetrics().stringWidth(string);
    }

    public int getTextHeight(Graphics2D g) {
        return g.getFontMetrics().getHeight();
    }

    public void moveTo(final ClientContext ctx, final Tile moveTo, TilePath pathTo, boolean hasPath) {
        currentTask = "Moving";
        if (hasPath) {
            pathTo.traverse();
        } else {
            if (moveTo.distanceTo(ctx.players.local().tile()) > 2) {
                ctx.movement.step(moveTo);
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return ctx.players.local().tile() == moveTo;
                    }
                });
            }
        }
    }

    @Override
    public void messaged(MessageEvent mes) {
        if (mes.text().equalsIgnoreCase("You make this item.")) {
            bootsMade += 1;
        }
        if (mes.text().contains("The Tanner tans")) {
            hidesTanned += ctx.backpack.select().id(1743).count();
        }
    }


    public State state() {
        if (!ctx.groundItems.id(1739).isEmpty() && ctx.backpack.select().count() < 28 && !player.interacting().valid()) {
            return State.LOOT;
        }
        if (ctx.backpack.select().count() == 28 && ctx.backpack.select().id(1739).count() > 0) {
            return State.TAN;
        }
        if (ctx.backpack.select().count() == 28 && !(ctx.backpack.select().id(1734).poll().stackSize() <= 5) && ctx.backpack.select().id(1743).count() > 0) {
            return State.CRAFT;
        }
        if (ctx.backpack.select().count() == 28 && ctx.backpack.select().id(25821).count() > 0) {
            return State.SELL;
        }
        if (ctx.backpack.select().id(1734).poll().stackSize() <= 5) {
            return State.STOP;
        }
        return State.ATTACK;
    }

    public enum State {
        ATTACK, LOOT,  TAN, CRAFT, SELL, STOP;
    }
}
