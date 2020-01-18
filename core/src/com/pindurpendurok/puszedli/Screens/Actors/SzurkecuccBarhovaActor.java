package com.pindurpendurok.puszedli.Screens.Actors;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;

public class SzurkecuccBarhovaActor extends OneSpriteStaticActor {

    List<CircleAtBackgroundActor> korok = new ArrayList<>();
    List<QuestionCircleActor> qk = new ArrayList<>();
    public final static String BACKGROUND = "ui_textures/grey.png";
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND);
    }

    public SzurkecuccBarhovaActor(MyGame game, SimpleWorld world, float posX, float posY,float width,float height) {
        super(game, BACKGROUND);

        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        sw.body.setPosition(posX,posY);
        sw.body.setSize(width,height);
        setActorWorldHelper(sw);
    }
}
