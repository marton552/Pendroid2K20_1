package com.pindurpendurok.puszedli.Screens.Actors;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.Screens.Foci.FociStage;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.awt.Label;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class labdaActor {
    public static final String LABDA = "null.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(LABDA);
    }

    float kezdX;
    float kezdY;
    float vegeX;
    float vegeY;
    public float iranyX;
    public float iranyY;
    public boolean get = false;

    public OneSpriteStaticActor kocka;
    public labdaActor(MyGame game, SimpleWorldStage gs, Float x, Float y,float w,float h){
        kocka = new OneSpriteStaticActor(game,LABDA);
        kocka.setPosition(x,y);
        kocka.setSize(w, h);
        gs.addActor(kocka);
        kezdX = x;
        kezdY = y;

        //A stagere rakjuk a listenert mert ha kockára rakod bugool
        gs.addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);

                //megnézzük hogy a kockára kattintintunk-e (opcionális)
                if(x >= kocka.getX() && x <= kocka.getX() + kocka.getWidth()) {
                    if(y >= kocka.getY() && y <= kocka.getY() + kocka.getHeight()) {

                        //Itt pedig középre pozícionáljuk a kockát rá az x,y koordinátára
                        kocka.setPosition(x - kocka.getWidth() / 2, y - kocka.getHeight() / 2);
                    }
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                    vegeX = x;
                    vegeY = y;
                    iranyX = (vegeX-kezdX)/1000;
                    iranyY = (vegeY-kezdY)/1000;
                    get = true;
            }
        });
    }
}
