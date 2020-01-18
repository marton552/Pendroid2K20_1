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

public class CircleAtBackgroundActor extends OneSpriteStaticActor {

    public static final String CIRCLE = "circleatback.png";
    public static AssetList list = new AssetList();

    Random rand = new Random();

    static {
        list.addTexture(CIRCLE);
    }

    public CircleAtBackgroundActor(MyGame game, SimpleWorld world){
        super(game, CIRCLE);

        int scale = rand.nextInt(500);
        int x = rand.nextInt(1080);
        int y = rand.nextInt(1920);

        setWidth(scale);
        setHeight(scale);
        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        sw.body.setPosition(x,y);
        setActorWorldHelper(sw);

        int rnd = rand.nextInt(4);
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
        sw.body.moveTo(30,x,y);

        //sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);

        //setPosition(getStage().getViewport().getWorldWidth() / 2  - getWidth() / 2, getStage().getViewport().getWorldHeight() / 2 - getHeight() / 2);

    }

}
