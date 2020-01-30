package com.pindurpendurok.puszedli.Screens.Wow;

import com.badlogic.gdx.Gdx;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class WowScreen extends MyScreen {
    static boolean munkaE;
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(WowStage.class, list);
    }
    public WowScreen(MyGame game, boolean munka) {
        super(game);
        munkaE = munka;
    }

    @Override
    protected void afterAssetsLoaded() {
        WowStage stage = new WowStage(game, munkaE);
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
