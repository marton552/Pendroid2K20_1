package com.pindurpendurok.puszedli.Screens.Test;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyContactListener;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleContact;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.IntervalTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class BadlogicActor extends OneSpriteStaticActor {
    public static final String BADLOGIC = "badlogic.jpg";
    public static AssetList list = new AssetList();

    static {
        list.addTexture(BADLOGIC);
    }

    public BadlogicActor(MyGame game, SimpleWorld world) {
        super(game, BADLOGIC);

        setScale(10, 10);
        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Rectangle, SimpleBodyType.Sensor);
        setActorWorldHelper(sw);

        sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);

        //setPosition(getStage().getViewport().getWorldWidth() / 2  - getWidth() / 2, getStage().getViewport().getWorldHeight() / 2 - getHeight() / 2);

       TickTimer t = new TickTimer(2, true, new TickTimerListener() {
           @Override
           public void onRepeat(TickTimer sender) {
               super.onRepeat(sender);
               System.out.println("asdsadasasdd");
           }
       });

       addTimer(t);

       sw.addContactListener(new SimpleBodyContactListener() {
           @Override
           public void beginContact(SimpleContact contact, SimpleWorldHelper myHelper, SimpleWorldHelper otherHelper) {
               super.beginContact(contact, myHelper, otherHelper);

                if(otherHelper.actor instanceof RosszActor) {
                    otherHelper.remove();
                }
           }

           @Override
           public void endContact(SimpleContact contact, SimpleWorldHelper myHelper, SimpleWorldHelper otherHelper) {
               super.endContact(contact, myHelper, otherHelper);
           }
       });
    }

}
