package com.pindurpendurok.puszedli;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class LoadingCsakJobbScreen extends LoadingStage {

    public final static String BACKGROUND = "ui_textures/loading1.png";
    public final static String BACKGROUND1 = "ui_textures/loading1.png";
    public final static String BACKGROUND2 = "ui_textures/loading1.png";

    public static AssetList list = new AssetList();
    static {
        list.addTexture(BACKGROUND).protect = true;
        list.addTexture(BACKGROUND1).protect = true;
        list.addTexture(BACKGROUND2).protect = true;

    }

    public LoadingCsakJobbScreen(MyGame game) {
        super(new ResponseViewport(1080f), game);
        int rnd = MathUtils.random(0,2);
        final OneSpriteStaticActor BackGround;
        if(rnd == 0) BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        else if(rnd == 1) BackGround = new OneSpriteStaticActor(game, BACKGROUND1);
        else  BackGround = new OneSpriteStaticActor(game, BACKGROUND2);
        BackGround.setSize(getWidth()/3,getWidth()/3);
        BackGround.setPosition(getWidth()/2-BackGround.getWidth()/2,getHeight()/2-BackGround.getHeight());
        addActor(BackGround);

        TickTimer h = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                BackGround.setRotation(BackGround.getRotation()-5);
            }
        });
        addTimer(h);
    }

    @Override
    public AssetList getAssetList() {
        return list;
    }
}
