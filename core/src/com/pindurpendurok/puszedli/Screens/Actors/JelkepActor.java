package com.pindurpendurok.puszedli.Screens.Actors;

import com.badlogic.gdx.math.MathUtils;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapStage;

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
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.WorldHelper.WorldHelper;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class JelkepActor extends OneSpriteStaticActor {
    //public static final String CIRCLE = "circleatback.png";


    Random rnd = new Random();
    static final String[] texturak = new String[]{"elemek/Pap_minigame/symbol1.png","elemek/Pap_minigame/symbol2.png","elemek/Pap_minigame/symbol3.png"};
    static AssetList list = new AssetList();
    public int kepSzelleseg = 200;
    public int kepMagassag = 200;
    private SimpleWorldHelper item;
    private int nehezseg;
    private static int pontok = 0;
    public float x;
    public float y;

    static {
        for (int i = 0; i < texturak.length ; i++) {
            list.addTexture(texturak[i]);
        }
    }
    public JelkepActor(final MyGame game, final SimpleWorld world, int jelSzama, SimpleWorldStage gs) {
        super(game, texturak[jelSzama]);
        kepSzelleseg = MathUtils.random((int)gs.getViewport().getWorldWidth()/15,(int)gs.getViewport().getWorldWidth()/5);
        kepMagassag = kepSzelleseg;
        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        item.body.setSize(kepSzelleseg,kepMagassag);
        x = rnd.nextInt((int)gs.getViewport().getWorldWidth()+1-kepSzelleseg);
        y = rnd.nextInt((int)gs.getViewport().getWorldHeight()+1-kepMagassag);
        item.body.setPosition(x,y);
        setActorWorldHelper(item);
    }


    public void torles(){
        //kell egy normális törlés
        item.remove();
    }
}
