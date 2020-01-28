package com.pindurpendurok.puszedli.Screens;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GameLoadingStage extends LoadingStage {
    public final static String BACK = "loading.jpg";
    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACK).protect = true;
    }

    public GameLoadingStage(MyGame game) {
        super(new ResponseViewport(720), game);
        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACK);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }
}
