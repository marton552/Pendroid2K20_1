package com.pindurpendurok.puszedli.Screens.Foci;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.labdaActor;
import com.pindurpendurok.puszedli.Screens.Classes.Date;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
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


    public FociStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
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
                if(asd.get){loves(asd.iranyX,asd.iranyY);}
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
            System.out.println("mellé!");
        }
        else if(kapus.getX()+kapus.getWidth()/3<labda.getX()+labda.getWidth() && kapus.getX()+(kapus.getWidth()/1.5f)>labda.getX()){
            System.out.println("kivédve!");}
        else System.out.println("goal!");
    }
}
