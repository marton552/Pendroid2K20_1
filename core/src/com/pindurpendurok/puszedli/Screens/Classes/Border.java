package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Border {

    public static final String LABDA = "null.png";
    public final static String FONT = "Bosk.otf";
    public final static String BACK = "elemek/border.png";
    public final static String COIN = "penz.png";
    public static final String[] KAJA = new String[]{"elemek/etel/alma.png","elemek/etel/alma2.png","elemek/etel/barack.png","elemek/etel/chips.png","elemek/etel/csike.png",
            "elemek/etel/hamburger.png","elemek/etel/hamburger2.png","elemek/etel/popcorn.png","elemek/etel/spaggeti.png","elemek/etel/steak.png"};
           static final int[] penz = new int[]{20,25,30,150,300,250,270,120,300,400};

    public static final int[] etel = new int[]{10,12,13,20,25,25,26,15,30,35};
    public static final int[] stressz = new int[]{0,0,0,-10,-5,-3,-4,-2,0,0};

    public static final String[] ITAL = new String[]{"elemek/ital/cola.png","elemek/ital/cola2.png","elemek/ital/gyumile.png","elemek/ital/gyumile2.png","elemek/ital/kv2.png",
            "elemek/ital/sorike.png","elemek/ital/sorike_2l_javitott.png","elemek/ital/viz.png","elemek/ital/viz2.png",};
    public static final int[] penz2 = new int[]{100,60,200,190,120,250,450,100,50};
    public static final int[] ital =     new int[]{15,10,20,19,5,-10,-5,20,10};
    public static final int[] stressz2 = new int[]{-2,0,0,0,-10,-20,-30,0,0};
    public static final int[] alkohol =  new int[]{0,0,0,0,0,20,30,0,0};


    public static final int[] penz3 = new int[]{0,2000,1500,1800,1900,1500,3000,2800,1000,1000,1400,1700,3100,2000,5000};

    public static final int[] penz4 = new int[]{0,1000,1200,2000,2200};


    public static final String[] MINIGAME = new String[]{"elemek/icon/minigame1.png","elemek/icon/minigame2.png","elemek/icon/minigame3.png","elemek/icon/minigame4.png","elemek/icon/minigame5.png",
            "elemek/icon/minigame6.png","elemek/icon/minigame7.png","elemek/icon/minigame8.png","elemek/icon/minigame9.png"};

    public static final String[] WORK = new String[]{"elemek/icon/munka1.png","elemek/icon/munka2.png","elemek/icon/munka3.png","elemek/icon/munka4.png","elemek/icon/munka5.png"};
    public static final String[] szoveg = new String[]{"Ringatás","Csorgo","Puzzle","Matek","Betűk","Önkielégítés","Foci",
    "WoW","Favágás"};
    public static final String[] szoveg2 = new String[]{"Kukás","Pornó rendező","Pszichiáter","Gamer","Pap"};

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACK).protect = true;
        assetList.addTexture(COIN).protect = true;
        assetList.addTexture(LABDA).protect = true;
        for (int i = 0; i < KAJA.length; i++) {
            assetList.addTexture(KAJA[i]).protect = true;
        }
        for (int i = 0; i < ITAL.length; i++) {
            assetList.addTexture(ITAL[i]).protect = true;
        }
        for (int i = 0; i < MINIGAME.length; i++) {
            assetList.addTexture(MINIGAME[i]).protect = true;
        }
        for (int i = 0; i < WORK.length; i++) {
            assetList.addTexture(WORK[i]).protect = true;
        }
    }

    GratulaloKep ize = new GratulaloKep();
    OneSpriteStaticActor back;
    OneSpriteStaticActor kep;
    MyLabel text;
    OneSpriteStaticActor coin;
    OneSpriteStaticActor click;
    boolean ondrag = true;

    public Border(final MyGame game, final SimpleWorldStage gs, final int hanyadik, final int type, float screen){
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
        else if(type == 4) kep = new OneSpriteStaticActor(game, MINIGAME[hanyadik]);
        else if(type == 5) kep = new OneSpriteStaticActor(game, WORK[hanyadik]);
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
        else if(type == 4){
            text = new MyLabel(game, szoveg[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 5){
            text = new MyLabel(game, szoveg2[hanyadik]+"", ls) {
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

        click = new OneSpriteStaticActor(game, LABDA);
        click.setSize(gs.getWidth()/3,gs.getWidth()/3);
        if(hanyadik%2==0 || hanyadik == 0)click.setPosition(screen + gs.getViewport().getWorldWidth()/2-click.getWidth()*1.1f,gs.getViewport().getWorldHeight()-(click.getHeight()*1.1f)*(hanyadik+2)/2);
        else click.setPosition(screen+ gs.getViewport().getWorldWidth()/2+(click.getWidth()*1.1f-click.getWidth()),gs.getViewport().getWorldHeight()-(click.getHeight()*1.1f)*(hanyadik+1)/2);
        gs.addActor(click,19999);

        click.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if(ondrag){
                //System.out.printf("asd");
                if (type==0)ize.letrehoz(game,gs,"Jó étvágyat!",penz[hanyadik]*-1,etel[hanyadik],0,stressz[0],0,gs.getViewport().getWorldWidth());
                else if (type==1)ize.letrehoz(game,gs,"Egészségedre!",penz2[hanyadik]*-1,0,ital[hanyadik],stressz2[0],alkohol[hanyadik],gs.getViewport().getWorldWidth());

                }
            ondrag = true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                ondrag = false;
            }
        });
    }


    public void mozgat(float y){
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
        click.remove();
    }
}
