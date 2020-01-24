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

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class JelkepActor extends OneSpriteStaticActor {
    Random rnd = new Random();
    //public static final String CIRCLE = "circleatback.png";
    public static final List<String> texturak = new ArrayList<String>();
    public static AssetList list = new AssetList();
    private SimpleWorldHelper item;

    static {
        texturak.add("circleatback.png");
        for (int i = 0; i < texturak.size() ; i++) {
            list.addTexture(texturak.get(i));
        }
        //list.addTexture(CIRCLE);
    }

    public JelkepActor(MyGame game, SimpleWorld world, int jelSzama) {
        super(game, texturak.get(jelSzama));
        item = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        //1280 - 720
        //MathUtils.random(0,1280);
        int x = rnd.nextInt((int)getViewport().width+1);
        int y = rnd.nextInt((int)getViewport().height+1);
        item.body.setPosition(x,y);
        setActorWorldHelper(item);

        //sw.body.sizeToFixTime(500, 500, 10, PositionRule.Center);
        //sw.body.sizeToFixTime(1000,1000,2, PositionRule.Center);
    }
    public void Mozgat(int x, int y){
        item.body.setPosition(x,y);
    }
}
