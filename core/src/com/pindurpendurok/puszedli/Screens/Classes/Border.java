package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Border {

    public final static String FONT = "Bosk.otf";
    public final static String BACK = "elemek/border.png";
    public final static String COIN = "penz.png";
    public static final String[] KAJA = new String[]{"elemek/etel/alma.png","elemek/etel/alma2.png","elemek/etel/barack.png","elemek/etel/chips.png","elemek/etel/csike.png",
            "elemek/etel/hamburger.png","elemek/etel/hamburger2.png","elemek/etel/popcorn.png","elemek/etel/spaggeti.png","elemek/etel/steak.png"};
    static final int[] penz = new int[]{20,25,30,150,300,250,270,120,300,400};

    public static final String[] ITAL = new String[]{"elemek/ital/cola.png","elemek/ital/cola2.png","elemek/ital/gyumile.png","elemek/ital/gyumile2.png","elemek/ital/kv2.png",
            "elemek/ital/sorike.png","elemek/ital/sorike_2l_javitott.png","elemek/ital/viz.png","elemek/ital/viz2.png",};
    static final int[] penz2 = new int[]{100,60,200,190,120,250,450,100,50};

    static final int[] penz3 = new int[]{0,2000,1500,1800,1900,1500,3000,2800,1000,1000,1400,1700,3100,2000,5000};

    static final int[] penz4 = new int[]{0,1000,1200,2000,2200};

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACK).protect = true;
        assetList.addTexture(COIN).protect = true;
        for (int i = 0; i < KAJA.length; i++) {
            assetList.addTexture(KAJA[i]).protect = true;
        }
        for (int i = 0; i < ITAL.length; i++) {
            assetList.addTexture(ITAL[i]).protect = true;
        }
    }

    OneSpriteStaticActor back;
    OneSpriteStaticActor kep;
    MyLabel text;
    OneSpriteStaticActor coin;

    public Border(MyGame game, SimpleWorldStage gs,int hanyadik,int type,float screen){
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;

        back = new OneSpriteStaticActor(game, BACK);
        back.setSize(gs.getWidth()/3,gs.getWidth()/3);
        if(hanyadik%2==0 || hanyadik == 0)back.setPosition(screen + gs.getViewport().getWorldWidth()/2-back.getWidth()*1.1f,gs.getViewport().getWorldHeight()-(back.getHeight()*1.1f)*(hanyadik+2)/2);
        else back.setPosition(screen+ gs.getViewport().getWorldWidth()/2+(back.getWidth()*1.1f-back.getWidth()),gs.getViewport().getWorldHeight()-(back.getHeight()*1.1f)*(hanyadik+1)/2);
        gs.addActor(back,19999);

        if(type == 0) kep = new OneSpriteStaticActor(game, KAJA[hanyadik]);
        else if(type == 1) kep = new OneSpriteStaticActor(game, ITAL[hanyadik]);
        else if(type == 2) kep = new OneSpriteStaticActor(game, GameStage.BENDZSIK[hanyadik]);
        else if(type == 3) kep = new OneSpriteStaticActor(game, GameStage.HATTEREK[0][hanyadik]);
        kep.setSize(back.getWidth()/1.5f,back.getWidth()/1.5f);
        kep.setPosition(back.getX()+back.getWidth()/2-kep.getWidth()/2,back.getY()+back.getHeight()/3.2f);
        gs.addActor(kep,19999);

        if(type == 0){
        text = new MyLabel(game, penz[hanyadik]+"", ls) {
            @Override
            public void init() {

            }
        };}
        else if(type == 1){
            text = new MyLabel(game, penz2[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 2){
            text = new MyLabel(game, penz3[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 3){
            text = new MyLabel(game, penz4[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
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
        System.out.println("asd");
        back.setY(back.getY()+y);
        kep.setPosition(back.getX()+back.getWidth()/2-kep.getWidth()/2,back.getY()+back.getHeight()/3.2f);
        text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/30);
        coin.setPosition(back.getX()+back.getWidth()/2+((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/12);
    }
    public void remove(){
        back.remove();
        kep.remove();
        text.remove();
        coin.remove();
    }
}
