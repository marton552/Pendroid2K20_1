package com.pindurpendurok.puszedli.Screens.Actors;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class changeMenuActor {
    public static final String LABDA = "null.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(LABDA);
    }

    float kezdX;
    float vegeX;
    public float iranyX;
    public boolean get = false;
    boolean elsokattint = true;

    public OneSpriteStaticActor kocka;
    public changeMenuActor(MyGame game, SimpleWorldStage gs){
        kocka = new OneSpriteStaticActor(game,LABDA);
        kocka.setPosition(0,0);
        kocka.setSize(gs.getViewport().getWorldWidth(), gs.getViewport().getWorldHeight());
        gs.addActor(kocka,10000);


        //A stagere rakjuk a listenert mert ha kockára rakod bugool
        gs.addListener(new ClickListener() {
            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                if(elsokattint) {kezdX = x;elsokattint=false;}
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
                if(vegeX > kezdX) iranyX = 1;
                else iranyX = -1;
                get = true;
                elsokattint = true;
            }
        });
    }

    public void del(){
        kocka.setPosition(0,0);
    }
}
