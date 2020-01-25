package com.pindurpendurok.puszedli.Screens.Shake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pindurpendurok.puszedli.Elements.ProgressBar;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class ShakeStage extends MyStage {
    public static final String DAVEY = "elemek/dave/NudiDavey.png";
    public static final String WBG = "ui_textures/black.png";

    public static AssetList assetList = new AssetList();

    static {
        assetList.addTexture(DAVEY);
        assetList.addTexture(WBG);
    }

    private final float GRAVITY_EARTH = 9.807f;

    float shakeStep = 100 / 10;
    float percent = 0;

    ProgressBar bar;

    boolean minigameEnded = false;
    OneSpriteStaticActor endBg;
    SimpleLabel endLabel;
    SimpleButton endBtn;

    SimpleLabel debugLabel;


    public ShakeStage(final MyGame game) {
        super(new ResponseViewport(720), game);

        bar = new ProgressBar(400, 20, ProgressBar.BG, ProgressBar.BAR, game);
        bar.setPosition(getViewport().getWorldWidth() / 2 - bar.getWidth() / 2, getViewport().getWorldHeight() - bar.getHeight() - 20);
        addActor(bar);

        addTimer(new TickTimer(0.5f, true, new TickTimerListener(){
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);

                if(minigameEnded) return;

                float xGrav = Gdx.input.getAccelerometerX() / GRAVITY_EARTH;
                float yGrav = Gdx.input.getAccelerometerY() / GRAVITY_EARTH;
                float zGrav = Gdx.input.getAccelerometerZ() / GRAVITY_EARTH;

                // gForce will be close to 1 when there is no movement.
                float gForce = (float)Math.sqrt((xGrav * xGrav) + (yGrav * yGrav) + (zGrav * zGrav));

                debugLabel.setText("DEBUG: "+gForce);

                if(gForce > 1.7) {
                    percent += shakeStep;
                    bar.setBarStep(percent);


                    if(percent >= 100) {
                        endMiniGame();
                    }
                }

            }
        }));


        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setVisible(false);
        endBg.setSize(getViewport().getWorldWidth(), 500);
        endBg.setPosition(0, getViewport().getWorldHeight() / 2 - endBg.getHeight() / 2);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Sikeresen kiráztad!");
        endLabel.setVisible(false);
        endLabel.setPosition(endLabel.getWidth() / 2, endBg.getY() + endBg.getHeight() - 50);
        endLabel.setAlignment(Align.center);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Vissza");
        endBtn.setVisible(false);
        endBtn.setPosition(endBtn.getWidth() / 2, endBg.getY() + 50);
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        addActor(endBtn);

        debugLabel = new SimpleLabel(game, "DEBUG: ");
        debugLabel.setColor(Color.RED);
        addActor(debugLabel);

    }

    private void endMiniGame() {
        minigameEnded = true;

        endBg.setVisible(true);
        endLabel.setVisible(true);
        endBtn.setVisible(true);
    }
}
