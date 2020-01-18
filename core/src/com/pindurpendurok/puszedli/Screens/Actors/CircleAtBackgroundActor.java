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

    public static final String CIRCLE = "badlogic.jpg";
    public static AssetList list = new AssetList();

    Random rand = new Random();

    static {
        list.addTexture(CIRCLE);
    }

    public CircleAtBackgroundActor(MyGame game, SimpleWorld world){
        super(game, CIRCLE);

        int scale = rand.nextInt(100);
        int x = rand.nextInt((int)getWidth());
        int y = rand.nextInt((int)getHeight());

        setScale(scale, scale);
        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setPosition(x,y);
        setActorWorldHelper(sw);

        //sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);

        //setPosition(getStage().getViewport().getWorldWidth() / 2  - getWidth() / 2, getStage().getViewport().getWorldHeight() / 2 - getHeight() / 2);

    }

}
