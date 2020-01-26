package com.pindurpendurok.puszedli.Screens.Trash;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.Direction;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;

public class TrashActor extends OneSpriteStaticActor {

    int speed = MathUtils.random(10, 20);
    SimpleWorldHelper sw;
    public boolean goodTrash;

    public TrashActor(MyGame game, String hash, SimpleWorld world, boolean goodTrash) {
        super(game, hash);
        this.goodTrash = goodTrash;


        setSize(getWidth() / 4, getHeight() / 4);
        sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setActorWorldHelper(sw);

        addTimer(new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);

                setY(getY() - speed);

                if(getY() + getHeight() < 0) trashFellDown();
            }
        }));

        addTimer(new TickTimer(1f, true, new TickTimerListener(){
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);
                Direction d;
                int rand = MathUtils.random(0, 1);

                if(rand == 0) d = Direction.ClockWise;
                else d = Direction.CounterClockWise;


                sw.body.rotateToFixTime(MathUtils.random(0, 360), 1, d);
            }
        }));
    }

    public void trashFellDown() {
        remove();
        if(goodTrash) ((TrashStage)getStage()).trashCollectError();
    }
}
