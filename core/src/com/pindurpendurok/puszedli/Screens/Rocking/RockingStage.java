package com.pindurpendurok.puszedli.Screens.Rocking;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.ProgressBar;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;

public class RockingStage extends MyStage {

    public static final String WBG = "ui_textures/black.png";


    public static AssetList list = new AssetList();
    static {
        list.addTexture(WBG);
    }


    SimpleLabel secLabel;
    ProgressBar bar;
    int sec = MathUtils.random(5, 10);
    float goodPercentSize = MathUtils.random(20, 30);
    float goodPercentStart = MathUtils.random(0, 100 - goodPercentSize);
    float currPercent = 0;

    private final float GRAVITY_EARTH = 9.807f;

    private boolean gameEnded = false;

    OneSpriteStaticActor endBg;
    SimpleLabel endLabel;
    SimpleButton endBtn;

    public RockingStage(final MyGame game) {
        super(new ResponseViewport(720), game);

        setCameraResetToLeftBottomOfScreen();

        bar = new ProgressBar(getViewport().getWorldWidth() - 100, 40, ProgressBar.BG, ProgressBar.BAR, game);
        bar.setPosition(getViewport().getWorldWidth() / 2 - bar.getWidth() / 2, getViewport().getWorldHeight() - bar.getHeight() - 20);
        bar.setBarStep(0);
        addActor(bar);

        secLabel = new SimpleLabel(game, sec+"");
        secLabel.setAlignment(Align.center);
        secLabel.setPosition(getViewport().getWorldWidth() / 2 - secLabel.getWidth() / 2, bar.getY() - bar.getHeight() - secLabel.getHeight() - 20);
        addActor(secLabel);


        addTimer(new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);

                if(gameEnded) return;

                float xGrav = Gdx.input.getAccelerometerX() / GRAVITY_EARTH;
                float yGrav = Gdx.input.getAccelerometerY() / GRAVITY_EARTH;
                float zGrav = Gdx.input.getAccelerometerZ() / GRAVITY_EARTH;

                // gForce will be close to 1 when there is no movement.
                float gForce = (float)Math.sqrt((xGrav * xGrav) + (yGrav * yGrav) + (zGrav * zGrav));


                currPercent = gForce * (2 / 100);
                bar.setBarStep(currPercent);


            }
        }));


        addTimer(new TickTimer(1, true, new TickTimerListener(){
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);

                if (gameEnded) return;

                if(currPercent >= goodPercentStart && currPercent <= goodPercentStart + goodPercentSize) {
                    sec--;
                    updateLabel();

                    if(sec <= 0) {
                        endGame();
                    }
                }
            }
        }));


        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setVisible(false);
        endBg.setSize(getViewport().getWorldWidth(), 500);
        endBg.setPosition(0, getViewport().getWorldHeight() / 2 - endBg.getHeight() / 2);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Sikeresen elringattad!");
        endLabel.setVisible(false);
        endLabel.setPosition(getViewport().getWorldWidth() / 2 - endLabel.getWidth() / 2 - 10, endBg.getY() + endBg.getHeight() - 150);
        endLabel.setAlignment(Align.center);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Vissza");
        endBtn.setVisible(false);
        endBtn.setPosition(getViewport().getWorldWidth() / 2 - endBtn.getWidth() / 2, endBg.getY() + 50);
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        addActor(endBtn);


    }

    private void endGame() {
        gameEnded = true;

        endBg.setVisible(true);
        endLabel.setVisible(true);
        endBtn.setVisible(true);
    }

    private void updateLabel() {
        secLabel.setText(sec+"");
    }
}
