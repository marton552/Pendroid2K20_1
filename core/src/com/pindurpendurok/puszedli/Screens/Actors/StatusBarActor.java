package com.pindurpendurok.puszedli.Screens.Actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class StatusBarActor {

    public static final String BAR = "ui_textures/bar.png";
    public static final String COLOR = "ui_textures/sliderknob.png";
    public static final String COLOR2 = "ui_textures/red.png";
    public static final String COLOR3 = "ui_textures/gold.png";
    public static final String COLOR4 = "ui_textures/blue.png";
    public final static String FONT = "Bosk.otf";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(BAR);

        list.addTexture(COLOR);
        list.addTexture(COLOR2);
        list.addTexture(COLOR3);
        list.addTexture(COLOR4);
        list.addFont(FONT, 60, Color.WHITE);
    }
    OneSpriteStaticActor szin;
    int max;
    public int jelenlegi;
     float ertek;

    public StatusBarActor(MyGame game, SimpleWorldStage gs, String color, float width, float height, int maxsize, int kezdoertek, float positionY,String szoveg) {
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.BLACK;

        OneSpriteStaticActor bar = new OneSpriteStaticActor(game, BAR);
        bar.setSize(width,height);
        bar.setPosition(gs.getViewport().getWorldWidth()/2-bar.getWidth()/2,gs.getViewport().getWorldHeight()-(height*positionY));
        gs.addActor(bar,1001);

        max = maxsize;
        jelenlegi = kezdoertek;
        ertek = width/maxsize;
        if(color=="red")szin = new OneSpriteStaticActor(game, COLOR2);
        else if(color=="green")szin = new OneSpriteStaticActor(game, COLOR);
        else if(color=="gold")szin = new OneSpriteStaticActor(game, COLOR3);
        else if(color=="blue")szin = new OneSpriteStaticActor(game, COLOR4);
        else System.out.println("Nincs ilyen szín beépítve");
        szin.setSize(ertek*kezdoertek,height);
        szin.setPosition(bar.getX(),bar.getY());
        gs.addActor(szin,1000);

        MyLabel text = new MyLabel(game, szoveg, ls) {
            @Override
            public void init() {

            }
        };
        text.setPosition(bar.getX()+bar.getWidth()/2-(bar.getWidth()/60*text.getText().length),bar.getY()+bar.getHeight()/10);
        text.setFontScale(1);
        gs.addActor(text,1003);
    }

    public void changeValue(int value){
        if(jelenlegi <= max-value && value > 1){
            jelenlegi+=value;
            szin.setWidth(ertek*jelenlegi);
        }
        else if(jelenlegi <= max && value > 1){
            jelenlegi=max;
            szin.setWidth(ertek*jelenlegi);
        }
        else if(value < 0 && jelenlegi > 0+value){
            jelenlegi+=value;
            szin.setWidth(ertek*jelenlegi);
        }
        else if(value < 0 && jelenlegi > 0){
            jelenlegi=0;
            szin.setWidth(ertek*jelenlegi);
        }
    }
}
