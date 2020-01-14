package com.pindurpendurok.puszedli.Screens.Test;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class TestStage extends SimpleWorldStage {


    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(BadlogicActor.class, list);
        AssetList.collectAssetDescriptor(RosszActor.class, list);
    }


    public TestStage(MyGame game) {
        super(new ResponseViewport(720f), game);
        setCameraResetToLeftBottomOfScreen();

        BadlogicActor actor = new BadlogicActor(game, world);
        addActor(actor);


        RosszActor rossz = new RosszActor(game, world);
        addActor(rossz);

        rossz.setPosition(actor.getX() + actor.getWidth() + 10, actor.getY() + actor.getHeight() + 10);


    }
}
