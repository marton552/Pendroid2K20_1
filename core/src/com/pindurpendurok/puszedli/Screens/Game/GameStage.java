package com.pindurpendurok.puszedli.Screens.Game;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameStage extends MyStage {
    public static AssetList assetList = new AssetList();
    static {

    }
    public GameStage(MyGame game) {
        super(new ResponseViewport(720f), game);

    }
}
