package com.pindurpendurok.puszedli.Screens.Porno;

import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class PornoScreen extends MyScreen {
    public PornoScreen(MyGame game) {
        super(game);
    }

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(PornoStage.class, assetList);
    }

    @Override
    protected void afterAssetsLoaded() {
        PornoStage stage = new PornoStage(game);
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
