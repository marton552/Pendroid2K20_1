package com.pindurpendurok.puszedli.Screens.Wow;

import java.util.concurrent.atomic.AtomicBoolean;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class Blood extends OneSpriteAnimatedActor {

    public static final String ATLAS = "atlas/blood.atlas";

    public static AssetList list = new AssetList();
    static {
        list.addTextureAtlas(ATLAS);
    }

    public Blood(MyGame game) {
        super(game, ATLAS);

        setSize(getWidth() / 1.5f, getHeight() / 1.5f);
        setLooping(false);
        setFps(15);
    }


    @Override
    public void setFrame(int frame) {
        super.setFrame(frame);

        if(frame == getFrameCount() - 1) getStage().getActors().removeValue(this, false);
    }


}
