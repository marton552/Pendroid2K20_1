package com.pindurpendurok.puszedli.Screens.MiniGame;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class MathGameScreen extends MyScreen {
    public MathGameScreen(MyGame game) {
        super(game);
    }

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(MathGameStage.class, assetList);
    }

    @Override
    protected void afterAssetsLoaded() {
        MathGameStage stage = new MathGameStage(game);
        addStage(stage, 2, true);
    }

    @Override
    public AssetList getAssetList() {
        return null;
    }

    @Override
    public void init() {

    }
}
