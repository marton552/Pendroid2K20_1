package com.pindurpendurok.puszedli.Screens.JobsGame;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class PapScreen extends MyScreen {
    public PapScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new PapStage(game,10,0), 1, true);
    }

    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(PapStage.class, assetList);
        return assetList;
    }

    @Override
    public void init() {

    }
}
