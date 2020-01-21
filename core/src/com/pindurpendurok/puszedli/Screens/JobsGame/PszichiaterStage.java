package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.TextLoader;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class PszichiaterStage extends SimpleWorldStage {

    public final static String BACKGROUND = "elemek/Pszhiatraiszolgaltatonyujtoszobakomplexumketdarabfotelalisegysurmovalakinemtudjamiaz.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND);
    }

    public PszichiaterStage(final MyGame game) {
        super(new ResponseViewport(720f), game);

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

    }
}
