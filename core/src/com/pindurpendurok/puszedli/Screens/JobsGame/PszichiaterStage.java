package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.math.MathUtils;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class PszichiaterStage extends SimpleWorldStage {

    public final static String BACKGROUND = "elemek/munkahatter/Pszhiatraiszolgaltatonyujtoszobakomplexumketdarabfotelalisegysurmovalakinemtudjamiaz.png";
    public final static String ui = "elemek/table.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND);
        assetList.addTexture(ui);
    }

    OneSpriteStaticActor table;
    String[] text;
    String[] actuallyText;
    int hanyadik;

    public PszichiaterStage(final MyGame game) {
        super(new ResponseViewport(720f), game);

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        table = new OneSpriteStaticActor(game, ui);
        table.setSize(getWidth(),getHeight());
        addActor(table);

        FileHandle handle = Gdx.files.internal("text.txt");
        text = handle.readString().split("START");
    }

    void ujStory(){
        hanyadik = MathUtils.random(1,text.length);
    }
}
