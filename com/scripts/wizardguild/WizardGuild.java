package com.scripts.wizardguild;

import com.scripts.utils.Lodestones;
import com.scripts.utils.Timer;
import org.powerbot.script.*;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Player;
import org.powerbot.script.rt6.TilePath;

import java.awt.*;
import java.util.concurrent.Callable;

/**
 * Created by Jeremy on 11/1/2014.
 */
@Script.Manifest(name = "Wizard Guild Zombies", description = "Kill Zombies in the basement of the Wizard's Guild, req 66 magic")
public class WizardGuild extends PollingScript<ClientContext> implements MessageListener, PaintListener {

    private long startTime = System.currentTimeMillis();
    private final Font font = new Font("Calibri", Font.PLAIN, 14);
    private final Font mainFont = new Font("Calibri", Font.PLAIN, 12);

    private final Tile[] pathToYanille = new Tile[] {
            new Tile(2872, 3437, 0),
            new Tile(2865, 3443, 0),
            new Tile(2865, 3450, 0),
            new Tile(2863, 3458, 0),
            new Tile(2854, 3471, 0),
            new Tile(2852, 3479, 0),
            new Tile(2857, 3496, 0),
            new Tile(2855, 3510, 0),
            new Tile(2839, 3509, 0),
            new Tile(2838, 3501, 0),
            new Tile(2840, 3492, 0),
            new Tile(2844, 3487, 0),
            new Tile(2847, 3478, 0),
            new Tile(2846, 3473, 0),
            new Tile(2843, 3468, 0),
            new Tile(2842, 3464, 0),
            new Tile(2846, 3460, 0),
            new Tile(2849, 3454, 0),
            new Tile(2851, 3446, 0),
            new Tile(2857, 3444, 0),
            new Tile(2853, 3439, 0),
            new Tile(2848, 3436, 0),
            new Tile(2840, 3434, 0),
            new Tile(2835, 3435, 0),
            new Tile(2827, 3438, 0),
            new Tile(2812, 3436, 0),
            new Tile(2809, 3434, 0),
            new Tile(2801, 3434, 0),
            new Tile(2798, 3434, 0),
            new Tile(2793, 3434, 0),
            new Tile(2784, 3431, 0),
            new Tile(2771, 3427, 0),
            new Tile(2760, 3424, 0),
            new Tile(2750, 3420, 0),
            new Tile(2737, 3412, 0),
            new Tile(2726, 3404, 0),
            new Tile(2718, 3398, 0),
            new Tile(2705, 3388, 0),
            new Tile(2688, 3380, 0),
            new Tile(2673, 3385, 0),
            new Tile(2659, 3391, 0),
            new Tile(2652, 3388, 0),
            new Tile(2646, 3378, 0),
            new Tile(2639, 3373, 0),
            new Tile(2636, 3370, 0),
            new Tile(2636, 3360, 0),
            new Tile(2637, 3348, 0),
            new Tile(2637, 3339, 0),
            new Tile(2628, 3333, 0),
            new Tile(2624, 3329, 0),
            new Tile(2623, 3297, 0),
            new Tile(2614, 3297, 0),
            new Tile(2609, 3297, 0),
            new Tile(2607, 3292, 0),
            new Tile(2606, 3285, 0),
            new Tile(2600, 3284, 0),
            new Tile(2597, 3282, 0),
            new Tile(2596, 3278, 0),
            new Tile(2596, 3276, 0),
            new Tile(2598, 3272, 0),
            new Tile(2599, 3268, 0),
            new Tile(2599, 3263, 0),
            new Tile(2596, 3257, 0),
            new Tile(2593, 3251, 0),
            new Tile(2601, 3245, 0),
            new Tile(2596, 3232, 0),
            new Tile(2586, 3224, 0),
            new Tile(2578, 3213, 0),
            new Tile(2570, 3204, 0),
            new Tile(2570, 3195, 0),
            new Tile(2576, 3186, 0),
            new Tile(2577, 3171, 0),
            new Tile(2575, 3156, 0),
            new Tile(2576, 3139, 0),
            new Tile(2582, 3132, 0),
            new Tile(2590, 3127, 0),
            new Tile(2603, 3125, 0),
            new Tile(2614, 3123, 0),
            new Tile(2618, 3115, 0),
            new Tile(2617, 3107, 0),
            new Tile(2611, 3103, 0),
            new Tile(2607, 3099, 0),
            new Tile(2603, 3093, 0),
            new Tile(2602, 3087, 0),
            new Tile(2597, 3087, 0)
    };

    private final Tile[] pathToGuild = new Tile[] {
            new Tile(2529, 3092, 0),
            new Tile(2541, 3092, 0),
            new Tile(2558, 3092, 0),
            new Tile(2564, 3090, 0),
            new Tile(2574, 3090, 0),
            new Tile(2579, 3093, 0),
            new Tile(2582, 3096, 0),
            new Tile(2589, 3098, 0),
            new Tile(2597, 3098, 0),
            new Tile(2602, 3095, 0),
            new Tile(2603, 3089, 0),
            new Tile(2597, 3088, 0)
    };

    private final Area yanille = new Area(
            new Tile(2615, 3071, 0),
            new Tile(2622, 3072, 0),
            new Tile(2628, 3089, 0),
            new Tile(2623, 3102, 0),
            new Tile(2615, 3113, 0),
            new Tile(2598, 3114, 0),
            new Tile(2569, 3114, 0),
            new Tile(2557, 3113, 0),
            new Tile(2539, 3113, 0),
            new Tile(2522, 3099, 0),
            new Tile(2525, 3085, 0),
            new Tile(2531, 3075, 0),
            new Tile(2543, 3068, 0),
            new Tile(2569, 3066, 0),
            new Tile(2603, 3067, 0),
            new Tile(2610, 3069, 0)
    );

    private final Area wizardGuild = new Area(
            new Tile(2596, 3090, 0),
            new Tile(2593, 3094, 0),
            new Tile(2589, 3094, 0),
            new Tile(2584, 3089, 0),
            new Tile(2584, 3086, 0),
            new Tile(2589, 3081, 0),
            new Tile(2593, 3081, 0),
            new Tile(2597, 3086, 0)
    );

    private final Area zombieArea = new Area(
            new Tile(2590, 9483, 0),
            new Tile(2595, 9483, 0),
            new Tile(2595, 9494, 0),
            new Tile(2581, 9494, 0),
            new Tile(2581, 9496, 0),
            new Tile(2590, 9487, 0)
    );

    private final Player player = ctx.players.local();

    private TilePath toGuild = ctx.movement.newTilePath(pathToGuild);
    private TilePath toYanille = ctx.movement.newTilePath(pathToYanille);

    @Override
    public void poll() {
        final State state = state();
        switch (state) {
            case TELEPORT_TO_YANILLE:
                Lodestones.YANILLE.teleport(ctx);
                Condition.wait(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        return player.animation() == -1;
                    }
                });
                break;
            case MOVE_TO_YANILLE:
                toYanille.traverse();
                break;
            case MOVE_TO_GUILD:
                toGuild.traverse();
                break;
            case OPEN:
                //1600, 1601
                if (ctx.objects.select().id(1601).nearest().poll().interact("Open")) {
                    System.out.println(player.interacting().name());
                }
                System.out.println("Open door");
                break;
            case GO_DOWN:
                System.out.println("Go downstairs");
                break;
            case ATTACK:
                System.out.println("In zombie area");
                break;
        }
    }

    @Override
    public void messaged(MessageEvent messageEvent) {

    }

    @Override
    public void repaint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        String name = "Wizard Guild";
        String time = "Time run: " + Timer.format(ctx.controller.script().getRuntime());
        /*String task = "Current Task: " + currentTask;
        String cows = "Cows Killed: " + cowsKilled;
        String killed = "Killed/hr: " + perHour(cowsKilled);
        String hide = "Cowhides Looted: " + hidesGathered;
        String looted = "Looted/hr: " + perHour(hidesGathered);
        String tanned = "Tanned/hr: " + perHour(hidesTanned);
        String boots = "Boots Crafted: " + bootsMade;
        String crafted = "Boots/hr: " + perHour(bootsMade);
        String totalMoney = "Gold Made: " + moneyMade;
        String money = "Gold/hr: " + perHour(moneyMade);
        */
        String tan = "Zombies Killed: 210";
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(5, 5, getTextWidth(tan, g) + 30, 206);
        g.setColor(Color.WHITE);
        g.drawRect(5, 5, getTextWidth(tan, g) + 30, 206);
        g.setFont(font);
        g.drawString(name, 74 - (getTextWidth(name, g)/2), 20);
        g.drawLine(15, 25, getTextWidth(tan, g) + 25, 25);
        /*
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
        */
    }

    public int getTextWidth(String string, Graphics2D g) {
        return g.getFontMetrics().stringWidth(string);
    }

    public int perHour(int value) {
        return (int) ((value) * 3600000D / (System.currentTimeMillis() - startTime));
    }

    public State state() {
        if (zombieArea.contains(player)) {
            return State.ATTACK;
        }
        if (!yanille.contains(player) && (Lodestones.YANILLE.canUse(ctx) || ctx.players.local().tile().distanceTo(new Tile(2878, 3442)) > 80)) {
            return State.TELEPORT_TO_YANILLE;
        }
        if (!yanille.contains(player) && ctx.players.local().tile().distanceTo(new Tile(2878, 3442)) > 50 || !Lodestones.YANILLE.canUse(ctx)) {
            return State.MOVE_TO_YANILLE;
        }
        if (yanille.contains(player) && !wizardGuild.contains(player)) {
            return State.MOVE_TO_GUILD;
        }
        if (yanille.contains(player) && !wizardGuild.contains(player) && player.tile().distanceTo(new Tile(2597, 3088, 0)) < 2) {
            return State.OPEN;
        }
        if (wizardGuild.contains(player)) {
            return State.GO_DOWN;
        }
        return null;
    }

    public enum State {
        MOVE_TO_YANILLE, MOVE_TO_GUILD, TELEPORT_TO_YANILLE, ATTACK, LOOT, BANK, OPEN, GO_DOWN;
    }
}
