package com.pindurpendurok.puszedli.Screens.Actors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class badJelkepActor extends OneSpriteStaticActor {
    //public static final String CIRCLE = "circleatback.png";


    Random rnd = new Random();
    static final List<String> texturak2 = new ArrayList<String>();
    static AssetList list = new AssetList();
    private static int kepSzelleseg = 200;
    private static int kepMagassag = 200;
    private SimpleWorldHelper item;
    private int nehezseg;
    private static int pontok = 0;

    static {
        texturak2.add("elemek/Pap_minigame/symbol1two.png");
        texturak2.add("elemek/Pap_minigame/symbol2two.png");
        texturak2.add("elemek/Pap_minigame/symbol3two.png");
        for (int i = 0; i < texturak2.size() ; i++) {
            list.addTexture(texturak2.get(i));
        }
    }
    public badJelkepActor(MyGame game, SimpleWorld world, int jelSzama, float x, float y, float w, float h) {
        super(game, texturak2.get(jelSzama));
        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        item.body.setPosition(x,y);
        item.body.setSize(w,h);
        setActorWorldHelper(item);
    }
}
