package com.pindurpendurok.puszedli.Screens.Foci;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.SzurkecuccBarhovaActor;
import com.pindurpendurok.puszedli.Screens.Actors.labdaActor;
import com.pindurpendurok.puszedli.Screens.Classes.Date;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Trash.TrashScreen;
import com.sun.org.apache.bcel.internal.generic.FADD;

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

public class FociStage extends SimpleWorldStage {

    public final static String BACKGROUND = "elemek/foci/kapukapunelkul.png";
    public final static String FONT = "Bosk.otf";
    public final static String KAPUS = "elemek/foci/kapus.png";
    public final static String KAPU = "elemek/foci/kapu.png";
    public final static String LABDA = "elemek/foci/focilabda.png";


    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);
        assetList.addTexture(KAPU);
        assetList.addTexture(KAPUS);
        assetList.addTexture(LABDA);
    }
    OneSpriteStaticActor kapus;
    OneSpriteStaticActor labda;
    TickTimer h;
    MyLabel felirat;
    MyLabel alirat;
    SimpleButton back1;
    SzurkecuccBarhovaActor back;
    public static boolean van = false;
    public static int penzm = 0;


    public FociStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreenWithPreloadAssets(GameScreen.class, new LoadingCsakJobbScreen(game));
            }
        });

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);
        final OneSpriteStaticActor kapu = new OneSpriteStaticActor(game, KAPU);
        kapu.setSize(getWidth(),getHeight());
        addActor(kapu);

        kapus = new OneSpriteStaticActor(game, KAPUS);
        kapus.setSize(getWidth(),getHeight());
        kapus.setPosition(0,0);
        addActor(kapus,10);

        back = new SzurkecuccBarhovaActor(game,world,0,0,getWidth(),getHeight());
        addActor(back,999);
        back.setColor(1,1,1,0.8f);

        felirat = new MyLabel(game, "Kivédve!", ls) {
            @Override
            public void init() {

            }
        };
        felirat.setPosition(10,getViewport().getWorldHeight()/2-felirat.getHeight()/2);
        felirat.setFontScale(6);
        felirat.setColor(Color.WHITE);
        addActor(felirat,1000);
        alirat = new MyLabel(game, "Új játék indul 2 másodperc múlva!", ls) {
            @Override
            public void init() {

            }
        };
        alirat.setPosition(getViewport().getWorldWidth()/30,getViewport().getWorldHeight()/2.7f);
        alirat.setFontScale(1.35f);
        alirat.setColor(Color.WHITE);
        addActor(alirat,1001);

        back1 = new SimpleButton(game, "Vissza");
        back1.setSize(getWidth()/2,getHeight()/8);
        back1.setPosition(getWidth()/2-back1.getWidth()/2,getHeight()/4.4f);
        back1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                penzm = penzm*10;
                game.setScreenWithPreloadAssets(GameScreen.class, new LoadingCsakJobbScreen(game));
            }
        });
        addActor(back1,1002);

        felirat.setVisible(false);
        alirat.setVisible(false);
        back1.setVisible(false);
        back.setVisible(false);

        newlabda();

        h = new TickTimer(0, true, new TickTimerListener() {
            boolean bal = true;
            float speed = 10;
            int rnd = MathUtils.random(30,150);
            int q = 0;
            @Override
            public void onTick(Timer sender, float correction) {
                if(bal){
                    kapus.setX(kapus.getX()-speed);
                    q++;
                    if(q == rnd){q = 0; rnd = MathUtils.random(30,150);bal=false;}
                    if(kapus.getX()<(0-getViewport().getWorldWidth()/3)){bal=false;speed+=0.1;}
                }
                else{
                    kapus.setX(kapus.getX()+speed);
                    q++;
                    if(q == rnd){q = 0; rnd = MathUtils.random(30,150);bal=true;}
                    if(kapus.getX()>(getViewport().getWorldWidth()/2.5f)){bal=true;speed+=0.1;}
                }
            }
        });
        addTimer(h);

    }

    TickTimer z;

    void newlabda(){
        int rnd = MathUtils.random(1,3);
        labda = new OneSpriteStaticActor(game, LABDA);
        labda.setSize(getWidth()/4,getWidth()/4);
        if(rnd == 1)labda.setPosition(getWidth()/2-labda.getWidth()/2,0);
        else if(rnd == 2)labda.setPosition(getWidth()/2-labda.getWidth()*2,0);
        else if(rnd == 3)labda.setPosition(getWidth()/2+labda.getWidth(),0);
        addActor(labda,11);


        final labdaActor asd = new labdaActor(game,this,labda.getX(),labda.getY(),labda.getWidth(),labda.getHeight());
        z = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                if(asd.get){loves(asd.iranyX,asd.iranyY);asd.del();}
            }
        });

        addTimer(z);
    }

    public void loves(float x,float y){
        z.stop();
        final float speedx = 30*x;
        final float speedy = 30*y;
        z = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                labda.setX(labda.getX()+speedx);
                labda.setY(labda.getY()+speedy);
                labda.setSize(labda.getWidth()-labda.getWidth()/250,labda.getWidth()-labda.getWidth()/250);

                if(labda.getY()>getViewport().getWorldHeight()/2.7f)stop();
            }
        });

        addTimer(z);
    }

    void stop(){
        z.stop();
        h.stop();
        System.out.printf(kapus.getX()+kapus.getWidth()/3+" and "+labda.getX()+"      ");
        System.out.println(kapus.getX()+(kapus.getWidth()/1.5f)+" asd "+labda.getX()+labda.getWidth());
        if(labda.getX()<0+labda.getWidth()*0.7f || labda.getX() > getViewport().getWorldWidth()-labda.getWidth()/1.5f){
             vege("Mellé!!!!!");
        }
        else if(kapus.getX()+kapus.getWidth()/3<labda.getX()+labda.getWidth() && kapus.getX()+(kapus.getWidth()/1.5f)>labda.getX()){
             vege("Kivédve!");}
        else{ vege("Goal!!!!!!"); van =true; penzm+=5;}
    }

    void vege(String s){
        felirat.setText(s);
        felirat.setVisible(true);
        alirat.setVisible(true);
        back1.setVisible(true);
        back.setVisible(true);
       TickTimer q = new TickTimer(2, false, new TickTimerListener() {
           @Override
           public void onStop(Timer sender) {
               super.onStop(sender);
               felirat.setVisible(false);
               alirat.setVisible(false);
               back1.setVisible(false);
               back.setVisible(false);
               labda.remove();
               newlabda();
               z.start();
               h.start();
           }
       });

        addTimer(q);
    }
}
