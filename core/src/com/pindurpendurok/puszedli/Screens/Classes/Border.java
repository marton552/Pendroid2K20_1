package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Border {

    public final static String FONT = "Bosk.otf";
    public final static String BACK = "elemek/border.png";
    public final static String COIN = "penz.png";
    static final String[] KAJA = new String[]{"elemek/etel/alma.png","elemek/etel/alma2.png","elemek/etel/barack.png","elemek/etel/chips.png","elemek/etel/csike.png",
            "elemek/etel/hamburger.png","elemek/etel/hamburger2.png","elemek/etel/popcorn.png","elemek/etel/spaggeti.png","elemek/etel/steak.png"};
    static final int[] penz = new int[]{20,25,30,150,300,250,270,120,300,400};

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACK).protect = true;
        assetList.addTexture(COIN).protect = true;
        for (int i = 0; i < KAJA.length; i++) {
            assetList.addTexture(KAJA[i]).protect = true;
        }
    }

    OneSpriteStaticActor back;
    OneSpriteStaticActor kep;
    MyLabel text;
    OneSpriteStaticActor coin;

    public Border(MyGame game, SimpleWorldStage gs,int hanyadik){
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;

        back = new OneSpriteStaticActor(game, BACK);
        back.setSize(gs.getWidth()/3,gs.getWidth()/3);
        if(hanyadik%2==0 || hanyadik == 0)back.setPosition(gs.getViewport().getWorldWidth()/2-back.getWidth()*1.1f,gs.getViewport().getWorldHeight()-(back.getHeight()*1.1f)*(hanyadik+2)/2);
        else back.setPosition(gs.getViewport().getWorldWidth()/2+(back.getWidth()*1.1f-back.getWidth()),gs.getViewport().getWorldHeight()-(back.getHeight()*1.1f)*(hanyadik+1)/2);
        gs.addActor(back,19999);

        kep = new OneSpriteStaticActor(game, KAJA[hanyadik]);
        kep.setSize(back.getWidth()/1.5f,back.getWidth()/1.5f);
        kep.setPosition(back.getX()+back.getWidth()/2-kep.getWidth()/2,back.getY()+back.getHeight()/3.2f);
        gs.addActor(kep,19999);

        text = new MyLabel(game, penz[hanyadik]+"", ls) {
            @Override
            public void init() {

            }
        };
        text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/30);
        text.setColor(Color.BLACK);
        text.setFontScale(0.8f);
        gs.addActor(text,19999);

        coin = new OneSpriteStaticActor(game, COIN);
        coin.setSize(gs.getWidth()/23,gs.getWidth()/23);
        coin.setPosition(back.getX()+back.getWidth()/2+((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/12);
        gs.addActor(coin,19999);
    }

    public void mozgat(float y){
        back.setY(back.getY()+y);
        kep.setPosition(back.getX()+back.getWidth()/2-kep.getWidth()/2,back.getY()+back.getHeight()/3.2f);
        text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/30);
        coin.setPosition(back.getX()+back.getWidth()/2+((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/12);
    }
}
