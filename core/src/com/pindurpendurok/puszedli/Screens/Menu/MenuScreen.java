package com.pindurpendurok.puszedli.Screens.Menu;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class MenuScreen extends MyScreen {
    public MenuScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new MenuStage(game), 1, true);
    }



    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(MenuStage.class, assetList);
        return assetList;
    }

    @Override
    public void init() {

    }
}
