package com.pindurpendurok.puszedli.Screens.Guess;

import com.pindurpendurok.puszedli.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class GuessScreen extends MyScreen {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(GuessStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);

    }
    public GuessScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        GuessStage stage = new GuessStage(game);
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
