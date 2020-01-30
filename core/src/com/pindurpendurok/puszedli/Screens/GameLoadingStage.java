package com.pindurpendurok.puszedli.Screens;

import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Assets.LoadingStage;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GameLoadingStage extends LoadingStage {
    public final static String FONTOCSKA = "alegreyaregular.otf";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONTOCSKA, 80).protect = true;
    }
    SimpleLabel dolog;


    public GameLoadingStage(MyGame game) {
        super(new ResponseViewport(720), game);

        dolog = new SimpleLabel(game, "SZIA", FONTOCSKA);
        dolog.setAlignment(Align.center);
        dolog.setPosition(getViewport().getWorldWidth() / 2 - dolog.getWidth() / 2, getViewport().getWorldHeight() / 2 - dolog.getHeight() / 2);
        addActor(dolog);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        dolog.setText(getPercent()+"%");
    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }
}
