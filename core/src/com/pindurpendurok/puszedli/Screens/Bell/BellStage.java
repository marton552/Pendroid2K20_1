package com.pindurpendurok.puszedli.Screens.Bell;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class BellStage extends MyStage {

    OneSpriteStaticActor bell;
    SimpleLabel felirat;
    SimpleLabel felirat2;
    public static int penz = 0;
    public static int stressz = 0;
    public static boolean volt = false;
    private final float GRAVITY_EARTH = 9.807f;
    public final static String CS = "elemek/baba_davey/csorog.png";
    float lastForce = 2.0f;

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(CS);

    }

    public BellStage(final MyGame game) {
        super(new ResponseViewport(720), game);

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreenWithPreloadAssets(GameScreen.class, new LoadingCsakJobbScreen(game));
            }
        });

        bell = new OneSpriteStaticActor(game, CS);
        bell.setPosition(getViewport().getWorldWidth() / 2 - bell.getWidth() / 2, getViewport().getWorldHeight() / 2 - bell.getHeight() / 2);
        bell.setVisible(false);

        felirat = new SimpleLabel(game, "Szerzett pénz:");
        felirat.setPosition(0, getViewport().getWorldHeight() - felirat.getHeight()*1.5f);
        addActor(felirat);

        felirat2 = new SimpleLabel(game, "Levezetett stressz: ");
        felirat2.setPosition(0, getViewport().getWorldHeight() - felirat.getHeight()*3.2f);
        addActor(felirat2);

        addActor(bell);

        addTimer(new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);

                //if(gameEnded) return;

                float xGrav = Gdx.input.getAccelerometerX() / GRAVITY_EARTH;
                float yGrav = Gdx.input.getAccelerometerY() / GRAVITY_EARTH;
                float zGrav = Gdx.input.getAccelerometerZ() / GRAVITY_EARTH;

                // gForce will be close to 1 when there is no movement.
                float gForce = (float) Math.sqrt((xGrav * xGrav) + (yGrav * yGrav) + (zGrav * zGrav));

                float difference = Math.abs(gForce - lastForce);

                if(difference > 1.0f) {
                    System.out.println("diff: "+difference);
                    bell.setVisible(true);
                    volt = true;
                    penz+=5;
                    if(MathUtils.random(1,2) == 2) stressz-=1f;
                    felirat.setText("Szerzett pénz: "+penz);
                    felirat2.setText("Levezetett stressz: "+stressz);
                    addTimer(new TickTimer(0.5f, false, new TickTimerListener() {
                        @Override
                        public void onTick(Timer sender, float correction) {
                            super.onTick(sender, correction);
                            bell.setVisible(false);
                        }
                    }));
                }

                lastForce = gForce;
            }
        }));

    }
}
