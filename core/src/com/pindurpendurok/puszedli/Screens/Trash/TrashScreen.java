package com.pindurpendurok.puszedli.Screens.Trash;

import com.pindurpendurok.puszedli.Elements.ElementAssets;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class TrashScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(TrashStage.class, list);
        AssetList.collectAssetDescriptor(ElementAssets.class, list);

    }

    public TrashScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        TrashStage stage = new TrashStage(game);
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
