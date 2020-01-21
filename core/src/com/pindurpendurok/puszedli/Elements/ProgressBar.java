package com.pindurpendurok.puszedli.Elements;

import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class ProgressBar {

    OneSpriteStaticActor bar;
    public float currStep = 100;
    private float stepW;

    public ProgressBar(float x, float y, float w, float h, String bgHash, String barHash, MyGame game, MyStage stage) {
        OneSpriteStaticActor bg = new OneSpriteStaticActor(game, bgHash);
        bg.setPosition(x, y);
        bg.setSize(w, h);

        stage.addActor(bg);

        bar = new OneSpriteStaticActor(game, barHash);
        bar.setPosition(x + 2, y + 2);
        bar.setSize(w - 4, h - 4);

        stepW = bar.getWidth() / 100.0f;

        stage.addActor(bar);

    }

    public void setBarStep(float percent) {
        bar.setWidth(stepW * percent);
        currStep = percent;
    }
}
