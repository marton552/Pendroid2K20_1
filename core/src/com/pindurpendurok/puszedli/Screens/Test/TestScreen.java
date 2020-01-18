package com.pindurpendurok.puszedli.Screens.Test;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class TestScreen extends MyScreen {
    static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(TestStage.class, assetList);
    }


    public TestScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        TestStage stage = new TestStage(game);
        addStage(stage, 1, true);
    }

    @Override
    public AssetList getAssetList() {

        return assetList;
    }

    @Override
    public void init() {

    }
}
