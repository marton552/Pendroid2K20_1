package com.pindurpendurok.puszedli.Screens.Favago;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.SzurkecuccBarhovaActor;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class FavagoStage extends SimpleWorldStage {

    public final static String BACKGROUND = "ui_textures/sliderknob.png";
    public final static String FONT = "Bosk.otf";
    public final static String TUSKO = "elemek/tusko.png";
    public final static String BALTA = "elemek/balta.png";


    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);
        assetList.addTexture(TUSKO);
        assetList.addTexture(BALTA);
    }

    TickTimer h;
    OneSpriteStaticActor tusko1;
    OneSpriteStaticActor fejsze;
    OneSpriteStaticActor zold1;
    MyLabel felirat;
    MyLabel felirat2;
    MyLabel feliratasd;
    MyLabel feliratasd2;
    SimpleButton back1;
    public static boolean atad = false;
    public static int gotmoney;
    boolean kettevagva = false;

    public FavagoStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;
        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                atad=true;
                game.setScreen(new GameScreen(game));
            }
        });

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        tusko1 = new OneSpriteStaticActor(game, TUSKO);
        tusko1.setSize(getWidth(),getWidth());
        tusko1.setPosition(getWidth()/2-tusko1.getWidth()/2,getHeight()/5);
        addActor(tusko1,10);

        zold1 = new OneSpriteStaticActor(game, BACKGROUND);
        zold1.setSize(getWidth(),getWidth());
        zold1.setPosition(getWidth()/2-zold1.getWidth()/2,getHeight()/5);
        addActor(zold1,11);
        zold1.setVisible(false);


        fejsze = new OneSpriteStaticActor(game, BALTA);
        fejsze.setSize(getWidth()/10,getHeight()/2);
        //fejsze.setSize(getWidth()/2-fejsze.getWidth()/2,getHeight());
        addActor(fejsze,100);

        SzurkecuccBarhovaActor hatter = new SzurkecuccBarhovaActor(game,world,0,0,getWidth(),getHeight());
        addActor(hatter,1000);
        hatter.setColor(0,0,0,0);
        hatter.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(kettevagva){
                    zold1.setVisible(false);
                    felirat.setVisible(false);
                    feliratasd.setVisible(false);
                    feliratasd2.setVisible(false);
                    felirat2.setVisible(false);
                    back1.setVisible(false);
                    h.start();
                    float rnd = MathUtils.random(0,getViewport().getWorldWidth());
                    fejsze.setX(rnd);
                    kettevagva = false;
                }
                else kettevagas();

            }
        });

        felirat = new MyLabel(game, "50% - 50%!", ls) {
            @Override
            public void init() {

            }
        };
        felirat.setPosition(getWidth()/4,getViewport().getWorldHeight()-felirat.getHeight()*1.5f);
        felirat.setFontScale(2);
        felirat.setColor(Color.BLACK);
        addActor(felirat,900);
        feliratasd = new MyLabel(game, "50% - 50%!", ls) {
            @Override
            public void init() {

            }
        };
        feliratasd.setPosition(getWidth()/2.5f,getViewport().getWorldHeight()-felirat.getHeight()*3f);
        feliratasd.setFontScale(2);
        feliratasd.setColor(Color.BLACK);
        addActor(feliratasd,900);
        feliratasd2 = new MyLabel(game, "50% - 50%!", ls) {
            @Override
            public void init() {

            }
        };
        feliratasd2.setPosition(getWidth()/3f,getViewport().getWorldHeight()-felirat.getHeight()*4.5f);
        feliratasd2.setFontScale(2);
        feliratasd2.setColor(Color.BLACK);
        addActor(feliratasd2,900);

        felirat2 = new MyLabel(game, "Újrakezdéshez kattintson bárhova", ls) {
            @Override
            public void init() {

            }
        };
        felirat2.setPosition(getWidth()/23,getViewport().getWorldHeight()-felirat.getHeight()*6f);
        felirat2.setFontScale(1.3f);
        felirat2.setColor(Color.BLACK);
        addActor(felirat2,900);

        back1 = new SimpleButton(game, "Vissza");
        back1.setSize(getWidth()/3,getHeight()/15);
        back1.setPosition(getWidth()/2-back1.getWidth()/2,100);
        back1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                atad=true;
                game.setScreen(new GameScreen(game));
            }
        });
        addActor(back1,1002);

        felirat.setVisible(false);
        feliratasd.setVisible(false);
        feliratasd2.setVisible(false);
        felirat2.setVisible(false);
        back1.setVisible(false);

        h = new TickTimer(0, true, new TickTimerListener() {
            boolean bal = true;
            float speed = 20;
            @Override
            public void onTick(Timer sender, float correction) {
                if(bal){
                    fejsze.setX(fejsze.getX()-speed);
                    if(fejsze.getX()<20){bal=false;speed+=0.5;}
                }
                else{
                    fejsze.setX(fejsze.getX()+speed);
                    if(fejsze.getX()>(getViewport().getWorldWidth()-fejsze.getWidth()-20)){bal=true;speed+=0.5;}
                }
            }
        });
        addTimer(h);
    }

    void kettevagas(){
        kettevagva = true;
        h.stop();
        float x= fejsze.getX();
        zold1.setVisible(true);
        zold1.setX(x+fejsze.getWidth()/4);
        zold1.setWidth(fejsze.getWidth()/2);
        felirat.setVisible(true);
        feliratasd.setVisible(true);
        feliratasd2.setVisible(true);
        felirat2.setVisible(true);
        back1.setVisible(true);
        int csillag = 0;
        int szazalek = (int)((x/getViewport().getWorldWidth())*100);
        if(szazalek > 48 && szazalek < 52)csillag = 10;
        else if(szazalek > 45 && szazalek < 55)csillag = 9;
        else if(szazalek > 42 && szazalek < 58)csillag = 8;
        else if(szazalek > 37 && szazalek < 63)csillag = 7;
        else if(szazalek > 34 && szazalek < 67)csillag = 6;
        else if(szazalek > 30 && szazalek < 70)csillag = 5;
        else if(szazalek > 27 && szazalek < 73)csillag = 4;
        else if(szazalek > 24 && szazalek < 77)csillag = 3;
        else if(szazalek > 20 && szazalek < 80)csillag = 2;
        else if(szazalek > 10 && szazalek < 90)csillag = 1;
        else csillag = 0;
        int penz = MathUtils.random(csillag,csillag*2);
        gotmoney+=penz;
        felirat.setText(szazalek+"% - "+(100-szazalek)+"%");
        feliratasd.setText("10/"+csillag);
        feliratasd2.setText("+"+penz+" penz");
    }
}
