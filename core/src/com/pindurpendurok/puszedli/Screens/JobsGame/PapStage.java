package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.JelkepActor;
import com.pindurpendurok.puszedli.Screens.Actors.badJelkepActor;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class PapStage extends SimpleWorldStage {
    public final static String BACKGROUND0 = "elemek/galéria/1.jpg";
    public final static String BACKGROUND1 = "elemek/galéria/1.jpg";
    public final static String BACKGROUND2 = "elemek/galéria/2.jpg";
    public final static String BACKGROUND3 = "elemek/galéria/3.jpg";
    public final static String BACKGROUND4 = "elemek/galéria/4.jpg";
    public final static String BACKGROUND5 = "elemek/galéria/5.jpg";
    public final static String BACKGROUND6 = "elemek/galéria/6.jpg";
    public final static String BACKGROUND7 = "elemek/galéria/7.jpg";
    public final static String BACKGROUND8 = "elemek/galéria/8.jpg";
    public final static String BACKGROUND9 = "elemek/galéria/9.jpg";
    public final static String CROSS = "elemek/Pap_minigame/cross.png";
    public final static String TOLT = "ui_textures/sliderknob.png";
    public final static String TOLT1 = "ui_textures/gold.png";
    public final static String TOLT2 = "ui_textures/red.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND0);
        assetList.addTexture(BACKGROUND1);
        assetList.addTexture(BACKGROUND2);
        assetList.addTexture(BACKGROUND3);
        assetList.addTexture(BACKGROUND4);
        assetList.addTexture(BACKGROUND5);
        assetList.addTexture(BACKGROUND6);
        assetList.addTexture(BACKGROUND7);
        assetList.addTexture(BACKGROUND8);
        assetList.addTexture(BACKGROUND9);
        assetList.addTexture(CROSS);
        assetList.addTexture(TOLT);
        assetList.addTexture(TOLT1);
        assetList.addTexture(TOLT2);
        AssetList.collectAssetDescriptor(JelkepActor.class, assetList);
        AssetList.collectAssetDescriptor(badJelkepActor.class, assetList);
    }
    public static int pontok = 0;
    static public JelkepActor jelkep;
    badJelkepActor uj;
    OneSpriteStaticActor cross;
    OneSpriteStaticActor w;
    OneSpriteStaticActor h;
    OneSpriteStaticActor wg;
    OneSpriteStaticActor hg;
    OneSpriteStaticActor wr;
    OneSpriteStaticActor hr;
    static public int nehezseg;
    float szelesseg;
    float magassag;
    boolean megy = true;
    MyLabel felirat;

    OneSpriteStaticActor BackGround;
    public PapStage(final MyGame game, int jelekSzama) {
        super(new ResponseViewport(720f), game);

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreenWithPreloadAssets(PapWorldScreen.class, new LoadingCsakJobbScreen(game));
            }
        });

        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(GameStage.FONT);
        ls.fontColor = Color.WHITE;

        if(jelekSzama == 0) BackGround = new OneSpriteStaticActor(game, BACKGROUND0);
        else if(jelekSzama == 1) BackGround = new OneSpriteStaticActor(game, BACKGROUND1);
        else if(jelekSzama == 2) BackGround = new OneSpriteStaticActor(game, BACKGROUND2);
        else if(jelekSzama == 3) BackGround = new OneSpriteStaticActor(game, BACKGROUND3);
        else if(jelekSzama == 4) BackGround = new OneSpriteStaticActor(game, BACKGROUND4);
        else if(jelekSzama == 5) BackGround = new OneSpriteStaticActor(game, BACKGROUND5);
        else if(jelekSzama == 6) BackGround = new OneSpriteStaticActor(game, BACKGROUND6);
        else if(jelekSzama == 7) BackGround = new OneSpriteStaticActor(game, BACKGROUND7);
        else if(jelekSzama == 8) BackGround = new OneSpriteStaticActor(game, BACKGROUND8);
        else if(jelekSzama == 9) BackGround = new OneSpriteStaticActor(game, BACKGROUND9);
        BackGround.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(BackGround,1);

        cross = new OneSpriteStaticActor(game, CROSS);
        cross.setSize(getViewport().getWorldWidth()/2.5f,getViewport().getWorldHeight()/3);
        cross.setPosition(getViewport().getWorldWidth()/2-cross.getWidth()/2,0+getViewport().getWorldHeight()/15);
        addActor(cross,8);


        w = new OneSpriteStaticActor(game, TOLT1);
        w.setSize(getViewport().getWorldWidth()/10,getViewport().getWorldWidth()/10);
        w.setPosition(cross.getX()+cross.getWidth()/2-w.getWidth()/2,cross.getY()+cross.getHeight()/1.85f);
        addActor(w,2);

        h = new OneSpriteStaticActor(game, TOLT1);
        h.setSize(getViewport().getWorldWidth()/10,getViewport().getWorldWidth()/10);
        h.setPosition(cross.getX()+cross.getWidth()/2-w.getWidth()/2,cross.getY()+cross.getHeight()/2-w.getHeight()/2);
        addActor(h,1);

        wg = new OneSpriteStaticActor(game, TOLT);
        wg.setSize(getViewport().getWorldWidth()/10,getViewport().getWorldWidth()/10);
        wg.setPosition(cross.getX()+cross.getWidth()/2-w.getWidth()/2,cross.getY()+cross.getHeight()/1.85f);
        addActor(wg,2);
        wg.setVisible(false);

        hg = new OneSpriteStaticActor(game, TOLT);
        hg.setSize(getViewport().getWorldWidth()/10,getViewport().getWorldWidth()/10);
        hg.setPosition(cross.getX()+cross.getWidth()/2-w.getWidth()/2,cross.getY()+cross.getHeight()/2-w.getHeight()/2);
        addActor(hg,1);
        hg.setVisible(false);

        wr = new OneSpriteStaticActor(game, TOLT2);
        wr.setSize(getViewport().getWorldWidth()/10,getViewport().getWorldWidth()/10);
        wr.setPosition(cross.getX()+cross.getWidth()/2-w.getWidth()/2,cross.getY()+cross.getHeight()/1.85f);
        addActor(wr,2);
        wr.setVisible(false);

        hr = new OneSpriteStaticActor(game, TOLT2);
        hr.setSize(getViewport().getWorldWidth()/10,getViewport().getWorldWidth()/10);
        hr.setPosition(cross.getX()+cross.getWidth()/2-w.getWidth()/2,cross.getY()+cross.getHeight()/2-w.getHeight()/2);
        addActor(hr,1);
        hr.setVisible(false);

        szelesseg = (getViewport().getWorldWidth()/4.5f-getViewport().getWorldWidth()/10)/12;
        magassag = (getViewport().getWorldWidth()/2-getViewport().getWorldWidth()/10)/12;

        felirat = new MyLabel(game, "3", ls) {
            @Override
            public void init() {

            }
        };
        felirat.setPosition(getViewport().getWorldWidth()/2-felirat.getWidth()/2*(felirat.getText().length)*4.5f,getViewport().getWorldHeight()/2-felirat.getHeight()/2);
        felirat.setFontScale(5);
        felirat.setColor(Color.WHITE);

        addActor(felirat,100);


        TickTimer t = new TickTimer(0.75f,false, new TickTimerListener(){
            public void onStop(Timer sender) {
                felirat.setText("2");
                TickTimer t2 = new TickTimer(0.75f,false, new TickTimerListener(){
                    public void onStop(Timer sender) {
                        felirat.setText("1");
                        TickTimer t3 = new TickTimer(0.75f,false, new TickTimerListener(){
                            public void onStop(Timer sender) {
                                felirat.setFontScale(2);
                                felirat.setText("Start!");
                                felirat.setPosition(getViewport().getWorldWidth()/2-felirat.getWidth()/2*(felirat.getText().length)*1.5f,getViewport().getWorldHeight()/2-felirat.getHeight()/2);
                                TickTimer t4 = new TickTimer(0.75f,false, new TickTimerListener(){

                                    public void onStop(Timer sender) {
                                        felirat.setVisible(false);
                                        phuu();
                                    }
                                });
                                addTimer(t4);
                            }
                        });
                        addTimer(t3);
                    }
                });
                addTimer(t2);
            }
        });
        addTimer(t);
    }

    void end(){
        felirat.setVisible(true);
        felirat.setText("Megtisztítva!\r\nTávozz Sátán!");
        felirat.setPosition(0+getViewport().getWorldWidth()/13,getViewport().getWorldHeight()/2-felirat.getHeight()/2);
        TickTimer t4 = new TickTimer(1.5f,false, new TickTimerListener(){

            public void onStop(Timer sender) {
                PapWorldStage.vanpenz = true;
                PapWorldStage.penzm+=100;
                game.setScreen(new PapWorldScreen(game));
            }
        });
        addTimer(t4);
    }

    void xn(boolean novel){

        if(novel){
            w.setVisible(false);
            w.setWidth(w.getWidth()+szelesseg);
            wg.setWidth(wg.getWidth()+szelesseg);
            wr.setWidth(wr.getWidth()+szelesseg);
            w.setX(w.getX()-szelesseg/2);
            wg.setX(wg.getX()-szelesseg/2);
            wr.setX(wr.getX()-szelesseg/2);
            wg.setVisible(true);
        }
        else if(w.getWidth()>getViewport().getWorldWidth()/10){
            w.setVisible(false);
            w.setWidth(w.getWidth()-szelesseg);
            wr.setWidth(w.getWidth()-szelesseg);
            wg.setWidth(w.getWidth()-szelesseg);
            w.setX(w.getX()+szelesseg/2);
            wg.setX(wg.getX()+szelesseg/2);
            wr.setX(wr.getX()+szelesseg/2);
            wr.setVisible(true);
        }
        if(w.getWidth() >= getViewport().getWorldWidth()/4.5f)megy = false;
        TickTimer t = new TickTimer(0.5f,false, new TickTimerListener(){


            public void onStop(Timer sender) {
                w.setVisible(true);
                wg.setVisible(false);
                wr.setVisible(false);
            }

        });
        addTimer(t);
    }

    void yn(boolean novel){
        if(novel){
            h.setVisible(false);
            h.setHeight(h.getHeight()+magassag);
            hg.setHeight(hg.getHeight()+magassag);
            hr.setHeight(hr.getHeight()+magassag);
            h.setY(h.getY()-magassag/2);
            hg.setY(hg.getY()-magassag/2);
            hr.setY(hr.getY()-magassag/2);
            hg.setVisible(true);
        }
        else if(h.getHeight()>getViewport().getWorldWidth()/10){
            h.setVisible(false);
            h.setHeight(h.getHeight()-magassag);
            hr.setHeight(h.getHeight()-magassag);
            hg.setHeight(h.getHeight()-magassag);
            h.setY(h.getY()+magassag/2);
            hg.setY(hg.getY()+magassag/2);
            hr.setY(hr.getY()+magassag/2);
            hr.setVisible(true);
        }
        TickTimer t = new TickTimer(0.5f,false, new TickTimerListener(){


            public void onStop(Timer sender) {
                h.setVisible(true);
                hg.setVisible(false);
                hr.setVisible(false);
            }

        });
        addTimer(t);
    }

    boolean torolve = false;

    public void phuu(){
        final SimpleWorldStage asd = this;
        torolve = false;
        if(megy) {
            int war = MathUtils.random(10, 20);
            TickTimer h = new TickTimer(war / 10, false, new TickTimerListener() {

                public void onStop(Timer sender) {


                    TickTimer jelekFeltunnek = new TickTimer(1.7f,false, new TickTimerListener(){
                        boolean van = true;
                        boolean clickable = true;
                        int skin = MathUtils.random(0,2);
                        @Override

                        public void onStart(Timer sender) {
                            super.onStop(sender);
                            jelkep = new JelkepActor(game,world, skin,asd);
                            addActor(jelkep,-1);
                            TickTimer z = new TickTimer(0.2f,false, new TickTimerListener(){


                                public void onStop(Timer sender) {
                                    jelkep.setZIndex(15);
                                    torolve = false;
                                }

                            });
                            addTimer(z);
                            //jelkep.setZIndex(11);
                            jelkep.addListener( new ClickListener(){
                                @Override
                                public void clicked (InputEvent event, float x, float y){
                                    super.clicked(event, x, y);
                                    if(clickable){
                                    if(!torolve){jelkep.torles();torolve = true;}
                                    van = false;
                                    xn(true);
                                    yn(true);
                                    phuu();}
                                }
                            });
                        }

                        public void onStop(Timer sender) {
                            if(van){
                                uj = new badJelkepActor(game,world,skin,jelkep.x,jelkep.y,jelkep.kepSzelleseg,jelkep.kepMagassag);
                                addActor(uj,-1);
                                clickable=false;
                                TickTimer t = new TickTimer(0.2f,false, new TickTimerListener(){


                                    public void onStop(Timer sender) {
                                        uj.setZIndex(10);
                                        if(!torolve){jelkep.torles();torolve=true;}
                                        phuu();
                                        xn(false);
                                        yn(false);
                                    }

                                });
                                addTimer(t);

                            }}
                    });
                    addTimer(jelekFeltunnek);

                }

            });
            addTimer(h);

        }
        else{
            end();
        }
    }

}
