package com.pindurpendurok.puszedli.Screens.Shake;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class ShakeScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ShakeStage.class, list);
    }

    public ShakeScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {

    }

    @Override
    public AssetList getAssetList() {
        return list;
    }

    @Override
    public void init() {

    }
}
