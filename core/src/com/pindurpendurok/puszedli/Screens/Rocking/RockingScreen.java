package com.pindurpendurok.puszedli.Screens.Rocking;

import com.pindurpendurok.puszedli.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class RockingScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(RockingStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
    }

    public RockingScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        RockingStage stage = new RockingStage(game);
        addStage(stage, 1, true);
    }

    @Override
    public AssetList getAssetList() {
        return list;
    }

    @Override
    public void init() {

    }
}
