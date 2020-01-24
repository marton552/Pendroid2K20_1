package com.pindurpendurok.puszedli.Screens.Actors;

import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.PositionRule;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.WorldHelper.WorldHelper;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class JelkepActor extends OneSpriteStaticActor {
    //public static final String CIRCLE = "circleatback.png";


    Random rnd = new Random();
    static final List<String> texturak = new ArrayList<String>();
    static AssetList list = new AssetList();
    private static int kepSzelleseg = 200;
    private static int kepMagassag = 200;
    private SimpleWorldHelper item;
    private int nehezseg;
    private static int pontok = 0;

    static {
        texturak.add("circleatback.png");
        for (int i = 0; i < texturak.size() ; i++) {
            list.addTexture(texturak.get(i));
        }
    }

    public JelkepActor(MyGame game, SimpleWorld world, int jelSzama, int nehezseg) {
        //jelSzama: 0-tól megy, hányadik textúra
        //nehezseg: nehézség: 0-tól megy 80ig, 1 érték 0.025 másodperccel rövidebb időt ad

        super(game, texturak.get(jelSzama));
        this.nehezseg = nehezseg;
        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);

        int x = rnd.nextInt((int)getViewport().width+1-kepSzelleseg)+(kepSzelleseg/2);
        int y = rnd.nextInt((int)getViewport().height+1-kepMagassag)+(kepMagassag/2);
        item.body.setPosition(x,y);
        TickTimer ido = new TickTimer(4f-nehezseg*0.025f,false, new TickTimerListener(){
            @Override
            public void onStart(Timer sender) {
                super.onStart(sender);
                setActorWorldHelper(item);
            }
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                torles();
            }
        });
        addTimer(ido);

        //sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);
        //sw.body.sizeToFixTime(1000,1000,2, PositionRule.Center);
    }
    public void torles(){
        //kell egy normális törlés
        item.body.setPosition(10000,10000);;
    }
}
