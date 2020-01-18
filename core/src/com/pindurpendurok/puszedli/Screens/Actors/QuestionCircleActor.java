package com.pindurpendurok.puszedli.Screens.Actors;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.Direction;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class QuestionCircleActor extends OneSpriteStaticActor {

    public static final String CIRCLE = "questioncircle.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(CIRCLE);
    }

    int hanyvan = 5;
    TickTimer t;
    SimpleWorldHelper kor1;
    SimpleWorldHelper kor2;

    public QuestionCircleActor(MyGame game, SimpleWorld world, SimpleWorldStage gs, float size, boolean jobbvagybal, final int hanyadik){
        super(game, CIRCLE);

        kor1 = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setActorWorldHelper(kor1);
        setSizeByOrigin(gs.getViewport().getWorldWidth()/(size*2),gs.getViewport().getWorldWidth()/size);
        kor1.body.setOriginFixedPosition(this.getWidth(),this.getHeight()/2);
        setPosition(gs.getViewport().getWorldWidth()/2-kor1.body.getWidth(), gs.getViewport().getWorldHeight()/5f+(hanyadik/size*gs.getViewport().getWorldHeight()/18));

        if(!jobbvagybal){
            setRotation(+90);
        }
        else setRotation(-90);
        hanyvan=hanyadik;

        t = new TickTimer(1f, false, new TickTimerListener() {

            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                kor1.body.rotateToFixTime(kor1.body.getRotation()+180,1f, Direction.Longer);
                if(hanyvan>0)st();
                hanyvan--;
            }
        });
        addTimer(t);

    }

    void st(){

        t.start();

    }
}
