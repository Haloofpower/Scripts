package com.scripts;

import org.powerbot.script.Condition;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt6.Action;
import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Constants;

import java.awt.*;
import java.util.concurrent.Callable;

/**
 * Created by Jeremy on 11/9/2014.
 */
//52: 1, 65: 2, 78: 3, 91: 4, 104: 5, 117: 6, 130: 7, 143: 8, 156: 9, 169: 0, 182: -, 195: =, 208: blank, 221: blank
//Magic Abilities: 1461, 0 (Asphyxiate: 7, Wrack: 1, Omnipower: 12, Dragon Breath: 6, Sonic Wave: 165, Impact: 3, Concentrated Blast: 166, Deep Impact: 171,
//Combust: 5, Surge: 2, Detonate: 8, Chain: 4, Wild Magic: 9, Metamorphosis: 10, Tsunami: 11)
@Script.Manifest(name = "Test Script", description = "Testing")
public class Test extends PollingScript<ClientContext> {

    @Override
    public void poll() {
        final Point point = ctx.widgets.select().id(1461).poll().component(0).component(9).centerPoint();
        /*ctx.input.move(ctx.backpack.select().id(15707).poll().nextPoint());
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.input.getLocation() == ctx.backpack.select().id(15707).poll().nextPoint();
            }
        });
        ctx.input.move(point);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.input.getLocation() == point;
            }
        });

        ctx.input.drag(ctx.widgets.select().id(Constants.COMBATBAR_WIDGET).poll().component(195).centerPoint(), true);*/
        for (Action i : ctx.combatBar.actions()) {
            System.out.println("Component: " + i.component() + ", ID: "+i.id());
        }
    }
}
