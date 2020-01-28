package com.pindurpendurok.puszedli.Screens.Favago;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class FavagoScreen extends MyScreen {
    public FavagoScreen(MyGame game) {
        super(game);
    }

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(FavagoStage.class, assetList);
    }

    @Override
    protected void afterAssetsLoaded() {
        FavagoStage stage = new FavagoStage(game);
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
