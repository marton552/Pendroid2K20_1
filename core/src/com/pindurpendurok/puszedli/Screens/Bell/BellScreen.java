package com.pindurpendurok.puszedli.Screens.Bell;

import com.pindurpendurok.puszedli.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class BellScreen extends MyScreen {
    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, assetList);
        AssetList.collectAssetDescriptor(BellStage.class, assetList);
    }

    public BellScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        BellStage stage = new BellStage(game);
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
