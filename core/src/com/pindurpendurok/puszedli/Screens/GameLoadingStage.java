package com.pindurpendurok.puszedli.Screens;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameLoadingStage extends LoadingStage {
    public static AssetList assetList = new AssetList();

    public GameLoadingStage(MyGame game) {
        super(new ResponseViewport(720), game);

    }



    @Override
    public AssetList getAssetList() {
        return assetList;
    }
}
