package com.pindurpendurok.puszedli.Screens.Game;

import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.MyGdxGame;
import com.pindurpendurok.puszedli.Screens.Classes.Date;

import hu.csanyzeg.master.Demos.Menu.BootStage;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;


public class GameStage extends SimpleWorldStage {

    public boolean timer_able_to_count = true;
    public int ticks = 0;
    public int count = 0;
    Date datum;

    public GameStage(final MyGame game) {
        super(new ResponseViewport(720f), game);
        setCameraResetToLeftBottomOfScreen();


        addTimer(new TickTimer(0, true, new TickTimerListener() {

            @Override
            public void onTick(Timer sender, float correction) {
                if(timer_able_to_count){
                    ticks++;
                if(ticks%30==0){count++;
                    datum = new Date(1);
                    System.out.println();
                }
            }}

        }));

    }
}
