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
import sun.java2d.pipe.SpanShapeRenderer;

public class RockingStage extends MyStage {

    public static final String WBG = "ui_textures/black.png";
    public static final String RED = "ui_textures/red.png";
    public static final String DAVE1 = "elemek/baba_davey/babadavey.png";
    public static final String DAVE2 = "elemek/baba_davey/babadavey_alszik_shhh.png";
    public static final String DAVE3 = "elemek/baba_davey/sir_a_babadavey.png";


    public static AssetList list = new AssetList();
    static {
        list.addTexture(WBG);
        list.addTexture(RED);
        list.addTexture(DAVE1);
        list.addTexture(DAVE2);
        list.addTexture(DAVE3);
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
    public static boolean volt = false;

    SimpleLabel debug;
    OneSpriteStaticActor davey1;
    OneSpriteStaticActor davey2;
    OneSpriteStaticActor davey3;

    public RockingStage(final MyGame game) {
        super(new ResponseViewport(720), game);

        setCameraResetToLeftBottomOfScreen();

        bar = new ProgressBar(getViewport().getWorldWidth() - 100, 40, ProgressBar.BG, ProgressBar.BAR, game);
        bar.setPosition(getViewport().getWorldWidth() / 2 - bar.getWidth() / 2, getViewport().getWorldHeight() - bar.getHeight() - 20);
        bar.setBarStep(0);
        bar.addZone(RED, goodPercentStart, goodPercentSize);
        addActor(bar);


        secLabel = new SimpleLabel(game, sec+"");
        secLabel.setAlignment(Align.center);
        secLabel.setPosition(getViewport().getWorldWidth() / 2 - secLabel.getWidth() / 2, bar.getY() - bar.getHeight() - secLabel.getHeight());
        addActor(secLabel);

        davey1 = new OneSpriteStaticActor(game, DAVE1);
        davey1.setPosition(getViewport().getWorldWidth() / 2 - davey1.getWidth() / 2, getViewport().getWorldHeight() / 2 - davey1.getHeight() / 2);
        addActor(davey1);

        davey2 = new OneSpriteStaticActor(game, DAVE2);
        davey2.setPosition(getViewport().getWorldWidth() / 2 - davey2.getWidth() / 2, getViewport().getWorldHeight() / 2 - davey2.getHeight() / 2);
        addActor(davey2);

        davey3 = new OneSpriteStaticActor(game, DAVE3);
        davey3.setPosition(getViewport().getWorldWidth() / 2 - davey3.getWidth() / 2, getViewport().getWorldHeight() / 2 - davey3.getHeight() / 2);
        addActor(davey3);
        davey2.setVisible(false);
        davey3.setVisible(false);


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


                if(gForce > 1.8f) currPercent += 10;
                if(currPercent > 100) currPercent = 100;
                bar.setBarStep(currPercent);


            }
        }));

        addTimer(new TickTimer(0.1f, true, new TickTimerListener(){
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);
                currPercent--;
                if(currPercent < 0) currPercent = 0;
                bar.setBarStep(currPercent);
            }
        }));


        addTimer(new TickTimer(1, true, new TickTimerListener(){
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);

                if (gameEnded) return;

                if(currPercent >= goodPercentStart && currPercent <= goodPercentStart + goodPercentSize) {
                    davey1.setVisible(false);
                    davey2.setVisible(true);
                    davey3.setVisible(false);
                    sec--;
                    updateLabel();

                    if(sec <= 0) {
                        endGame();
                    }
                }
                if(currPercent > goodPercentSize+goodPercentSize){
                    davey1.setVisible(false);
                    davey2.setVisible(false);
                    davey3.setVisible(true);
                }
                if(currPercent< goodPercentStart){
                    davey3.setVisible(false);
                    davey2.setVisible(false);
                    davey1.setVisible(true);
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
                volt = true;
                game.setScreen(new GameScreen(game));
            }
        });
        addActor(endBtn);


    }

    private float mapValue (float value, float fromSource, float toSource, float fromTarget, float toTarget)
    {
        return (value - fromSource) / (toSource - fromSource) * (toTarget - fromTarget) + fromTarget;
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
