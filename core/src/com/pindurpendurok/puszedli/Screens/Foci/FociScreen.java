package com.pindurpendurok.puszedli.Screens.Foci;

import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class FociScreen extends MyScreen {
    public FociScreen(MyGame game) {
        super(game);
    }
    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(FociStage.class, assetList);
    }

    @Override
    protected void afterAssetsLoaded() {
        FociStage stage = new FociStage(game);
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
