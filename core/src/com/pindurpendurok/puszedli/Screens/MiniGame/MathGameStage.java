package com.pindurpendurok.puszedli.Screens.MiniGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class MathGameStage extends SimpleWorldStage {


    //List<CircleAtBackgroundActor> korok = new ArrayList<>();
    public final static String BACKGROUND = "math_back.png";
    public final static String FONT = "MrGrieves-Regular.otf";
    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);
    }

    public MathGameStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
        setCameraResetToLeftBottomOfScreen();

        for (int i = 0;i<15;i++){
            //korok.add(new CircleAtBackgroundActor(game,world));
        }

    }
}
