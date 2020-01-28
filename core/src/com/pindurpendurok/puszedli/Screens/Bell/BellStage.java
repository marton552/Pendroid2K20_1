package com.pindurpendurok.puszedli.Screens.Bell;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class BellStage extends MyStage {

    SimpleLabel bell;
    private final float GRAVITY_EARTH = 9.807f;
    float lastForce = 2.0f;

    public BellStage(MyGame game) {
        super(new ResponseViewport(720), game);


        bell = new SimpleLabel(game, "Csengő!");
        bell.setAlignment(Align.center);
        bell.setPosition(getViewport().getWorldWidth() / 2 - bell.getWidth() / 2, getViewport().getWorldHeight() / 2 - bell.getHeight() / 2);
        bell.setVisible(false);

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
