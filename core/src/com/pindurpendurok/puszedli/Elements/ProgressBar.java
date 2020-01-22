package com.pindurpendurok.puszedli.Elements;

import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ProgressBar extends MyGroup {

    public static final String BG = "ui_textures/black.png";
    public static final String BAR = "ui_textures/thisiswhite.png";


    public static AssetList list = new AssetList();
    static {
        list.addTexture(BG);
        list.addTexture(BAR);
    }

    OneSpriteStaticActor bar;
    public float currStep = 100;
    private float stepW;

    public ProgressBar(float w, float h, String bgHash, String barHash, MyGame game) {
        super(game);
        float x = 0;
        float y = 0;

        setSize(w, h);

        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, bgHash);
        bg.setPosition(x, y);
        bg.setSize(w, h);

        addActor(bg);

        bar = new OneSpriteStaticActor(game, barHash);
        bar.setPosition(x + 2, y + 2);
        bar.setSize(w - 4, h - 4);

        stepW = bar.getWidth() / 100.0f;

        addActor(bar);

    }

    public void setBarStep(float percent) {
        if(percent > 100) percent = 100.0f;
        if(percent < 0) percent = 0;

        bar.setWidth(stepW * percent);
        currStep = percent;
    }

    public float getPercent() {
        return currStep;
    }
}
