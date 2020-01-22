package com.pindurpendurok.puszedli.Screens.Shake;

import com.pindurpendurok.puszedli.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class ShakeScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ShakeStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
    }

    public ShakeScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        ShakeStage stage = new ShakeStage(game);
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
