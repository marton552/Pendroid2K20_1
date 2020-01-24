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

public class JelkepActor extends OneSpriteStaticActor {

    public static final String CIRCLE = "circleatback.png";
    public static AssetList list = new AssetList();


    static {
        list.addTexture(CIRCLE);
    }

    public JelkepActor(MyGame game, SimpleWorld world) {
        super(game, CIRCLE);

        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        sw.body.setPosition(0,0);
        setActorWorldHelper(sw);

        //sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);
        //sw.body.sizeToFixTime(1000,1000,2, PositionRule.Center);

    }
}
