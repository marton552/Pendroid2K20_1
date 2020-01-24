package com.pindurpendurok.puszedli.Screens.Actors;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class PapJesusActor extends OneSpriteStaticActor {
    public static final String JESUS = "elemek/dave/davey.png";

    static {

        //list.addTexture(JESUS);
    }

    public PapJesusActor(MyGame game, SimpleWorld world, SimpleWorldStage gs) {
        super(game, JESUS);
        SimpleWorldHelper dave = new SimpleWorldHelper(world, this, ShapeType.Rectangle, SimpleBodyType.Sensor);
        dave.body.setSize(gs.getViewport().getWorldWidth()/1.5f,gs.getViewport().getWorldHeight()/1.5f);
        dave.body.setPosition(gs.getViewport().getWorldWidth()/2-dave.body.getWidth()/2,0-gs.getViewport().getWorldHeight()/1.5f);
        //dave.body.setPosition(gs.getViewport().getWorldWidth()/2-dave.body.getWidth()/2,0);
        dave.body.moveToFixTime(gs.getViewport().getWorldWidth()/2-dave.body.getWidth()/2,0,1, PositionRule.LeftBottom);
        setActorWorldHelper(dave);
    }
}
