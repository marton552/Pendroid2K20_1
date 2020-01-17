package com.pindurpendurok.puszedli.Screens.Game;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GameScreen extends MyScreen {
    static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(GameScreen.class, assetList);
    }


    public GameScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        GameStage stage = new GameStage(game);
        addStage(stage, 1, true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(GameStage.class, assetList);
        return assetList;
    }

    @Override
    public void init() {

    }
}
