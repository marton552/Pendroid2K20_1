package com.pindurpendurok.puszedli.Screens.MiniGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.QuestionCircleActor;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class MathGameStage extends SimpleWorldStage {


    List<CircleAtBackgroundActor> korok = new ArrayList<>();
    public final static String BACKGROUND = "math_back.png";
    public final static String FONT = "MrGrieves-Regular.otf";
    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        AssetList.collectAssetDescriptor(QuestionCircleActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);
    }


    public MathGameStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
        setCameraResetToLeftBottomOfScreen();

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        //addActor(BackGround);

        for (int i = 0;i<20;i++){
            CircleAtBackgroundActor asd = new CircleAtBackgroundActor(game,world);
            korok.add(asd);
            addActor(asd);
        }

        QuestionCircleActor n = new QuestionCircleActor(game, world);
        addActor(n);

    }
}
