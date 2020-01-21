package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.pindurpendurok.puszedli.Screens.Menu.MenuStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class PszichiaterScreen extends MyScreen {
    public PszichiaterScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        addStage(new PszichiaterStage(game), 1, true);
    }



    @Override
    public AssetList getAssetList() {
        AssetList assetList = new AssetList();
        AssetList.collectAssetDescriptor(PszichiaterStage.class, assetList);
        return assetList;
    }

    @Override
    public void init() {

    }
}
