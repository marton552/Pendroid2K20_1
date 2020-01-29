package com.pindurpendurok.puszedli.Screens.Porno;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class NyilActor extends OneSpriteStaticActor {
    public SimpleWorldHelper sw;

    public static final String CIRCLE = "elemek/pori/arrow.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(CIRCLE);
    }

    SimpleWorldStage gs2;

    public NyilActor(MyGame game, SimpleWorld world, SimpleWorldStage gs) {
        super(game, CIRCLE);

        gs2 = gs;
        sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        sw.body.setSize(gs.getViewport().getWorldWidth()/4,gs.getViewport().getWorldWidth()/4);
        sw.body.setPosition(gs.getViewport().getWorldWidth()/2-sw.body.getWidth()/2,gs.getViewport().getWorldHeight());
        setActorWorldHelper(sw);

    }

    public void zuhanas(int irany){

        if(irany == 0)sw.body.setRotation(-90);
        else if(irany == 1)sw.body.setRotation(0);
        else if(irany == 2)sw.body.setRotation(90);
        else if(irany == 3)sw.body.setRotation(180);

        sw.body.setPosition(gs2.getViewport().getWorldWidth()/2-sw.body.getWidth()/2,gs2.getViewport().getWorldHeight());
        sw.body.moveToFixTime(gs2.getViewport().getWorldWidth()/2,0-sw.body.getHeight(),0.8f, PositionRule.Center);

        TickTimer r = new TickTimer(0.8f, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                if(PornoStage.waitfor){
                PornoStage.missed = true;
                System.out.println("missed");}
            }

        });
        addTimer(r);

    }
    public void set(){
        sw.body.setPosition(gs2.getViewport().getWorldWidth()/2,0-sw.body.getHeight());
    }
}
