package com.pindurpendurok.puszedli.Puzzle;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class PuzzleScreen extends MyScreen {
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(PuzzleStage.class, list);
    }

    public PuzzleScreen(MyGame game) {
        super(game);
    }

    @Override
    protected void afterAssetsLoaded() {
        PuzzleStage stage = new PuzzleStage(game);
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
