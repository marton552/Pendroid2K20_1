package com.pindurpendurok.puszedli.Screens.Actors;

import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;

public class CircleAtBackgroundActor extends OneSpriteStaticActor {

    public static final String CIRCLE = "circleatback.png";
    public static AssetList list = new AssetList();
    Random rand = new Random();
    int x = rand.nextInt(4);
    int y = rand.nextInt(4);
    int scale = rand.nextInt(400)+100;
    int speed;
    SimpleWorldHelper sw;
    boolean megymar = false;


    static {
        list.addTexture(CIRCLE);
    }

    public CircleAtBackgroundActor(MyGame game, SimpleWorld world){
        super(game, CIRCLE);

        setWidth(scale);
        setHeight(scale);
        gen();
        megymar = true;
        sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        sw.body.setPosition(x,y);
        setActorWorldHelper(sw);

        gen();

        //sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);

        //setPosition(getStage().getViewport().getWorldWidth() / 2  - getWidth() / 2, getStage().getViewport().getWorldHeight() / 2 - getHeight() / 2);

        TickTimer t = new TickTimer(2, true, new TickTimerListener() {
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);
                if((rnd == 0 && x < 0-scale)||(rnd == 1 && x > 1080+scale)||(rnd == 2 && y > 1920+scale)||(rnd == 3 && y < 0-scale))gen();
            }
        });

        addTimer(t);

    }
    int rnd;

    void gen(){
        rnd = rand.nextInt(4);
        if(rnd == 0){
            x=0-scale-10;
            y= rand.nextInt(1920);
        }
        else if(rnd == 1){
            x=1080+scale+10;
            y= rand.nextInt(1920);
        }
        else if(rnd == 2){
            y=1920+scale+10;
            x= rand.nextInt(1080);
        }
        else if(rnd == 3){
            y=0-scale-10;
            x= rand.nextInt(1080);
        }
        if(megymar){
            speed = rand.nextInt(40)+40;
            sw.body.moveToFixSpeed(x,y,speed,PositionRule.Center);
        }
    }

}
