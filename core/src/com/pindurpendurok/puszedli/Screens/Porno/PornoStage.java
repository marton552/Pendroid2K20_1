package com.pindurpendurok.puszedli.Screens.Porno;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Wow.WowScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PornoStage extends SimpleWorldStage {
    public final static String FONT = "Bosk.otf";
    public static final String BLACK = "ui_textures/black.png";
    public static final String BACK = "elemek/pori/bakc.jpg";

    public static final String[] FIU = new String[]{"elemek/pori/PoreszCsavesz1.png","elemek/pori/PoreszCsavesz2.png","elemek/pori/PoreszCsavesz3.png"};
    public static final String[] LANY = new String[]{"elemek/pori/PoreszWaman1.png","elemek/pori/PoreszWaman2.png","elemek/pori/PoreszWaman3.png","elemek/pori/PoreszWaman4.png",
            "elemek/pori/PoreszWaman5.png","elemek/pori/PoreszWaman6.png","elemek/pori/PoreszWaman7.png","elemek/pori/PoreszWaman8.png"};
    public static final String CEN = "elemek/pori/censored.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(CEN);
        assetList.addTexture(BLACK);
        assetList.addTexture(BACK);
        for (int i = 0; i < FIU.length; i++) {
            assetList.addTexture(FIU[i]);
        }
        for (int i = 0; i < LANY.length; i++) {
            assetList.addTexture(LANY[i]);
        }

    }

    public static boolean waitfor = false;
    public static int irany = 0;
    public static MyLabel text;
    MyLabel vict;
    static boolean jo = false;
    static boolean rossz = false;
    TickTimer z;
    int f1 = 0;
    int l1 = 0;
    float fiudistance = 0;
    float lanydistance = 0;
    OneSpriteStaticActor fiu;
    OneSpriteStaticActor lany;
    int holtart = 1;
    final NyilActor nyil;
    public static boolean missed = false;
    public static boolean van = false;

    public PornoStage(final MyGame game) {
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

        OneSpriteStaticActor back = new OneSpriteStaticActor(game,BACK);
        back.setSize(getWidth(),getHeight());
        back.setPosition(0,0);
        addActor(back);

        text = new MyLabel(game, "", ls) {
            @Override
            public void init() {

            }
        };
        text.setPosition(getViewport().getWorldWidth()/2-(getViewport().getWorldWidth()/20),getHeight()*0.9f);
        text.setColor(Color.WHITE);
        text.setFontScale(1.5f);
        addActor(text);

        vict = new MyLabel(game, "Sikeresen elkészült a film!", ls) {
            @Override
            public void init() {

            }
        };
        vict.setPosition(0,getHeight()*0.3f);
        vict.setColor(Color.WHITE);
        vict.setFontScale(1.9f);
        addActor(vict,1000);
        vict.setVisible(false);

        f1 = MathUtils.random(0,FIU.length-1);
        l1 = MathUtils.random(0,LANY.length-1);
        fiu = new OneSpriteStaticActor(game,FIU[f1]);
        fiu.setSize(getWidth()/3,getHeight()/3);
        fiu.setPosition(0,getViewport().getWorldHeight()/2-fiu.getHeight()/2);
        addActor(fiu);
        lany = new OneSpriteStaticActor(game,LANY[l1]);
        lany.setSize(getWidth()/3,getHeight()/3);
        lany.setPosition(getWidth()-lany.getWidth(),getViewport().getWorldHeight()/2-fiu.getHeight()/2);
        addActor(lany);

        fiudistance = (getWidth()/2-fiu.getX())/10;
        lanydistance = (lany.getX()-getWidth()/2)/8;

        final PoriClass asd = new PoriClass(game,this);

        nyil = new NyilActor(game,world,this);
        addActor(nyil);

        TickTimer h = new TickTimer(1.5f, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                irany = MathUtils.random(0,3);
                waitfor = true;
                nyil.zuhanas(irany);
            }
        });
        addTimer(h);

        TickTimer inf = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                if(asd.check != 5){
                if(asd.check == irany && waitfor == true){System.out.println("jóó");
                    text.setText("Jó");
                    text.setColor(Color.GREEN);
                    asd.check = 5;
                    waitfor = false;
                    nyil.set();
                    TickTimer r = new TickTimer(1, false, new TickTimerListener() {
                        @Override
                        public void onStop(Timer sender) {
                            super.onStop(sender);
                            text.setText("");
                            mozgas();
                        }
                    });
                    addTimer(r);
                }
                else if(waitfor == true){ System.out.println("rossz");

                    text.setText("Rossz");
                    text.setColor(Color.RED);
                    asd.check = 5;
                    waitfor = false;
                    nyil.set();
                    TickTimer r = new TickTimer(1, false, new TickTimerListener() {
                        @Override
                        public void onStop(Timer sender) {
                            super.onStop(sender);
                            text.setText("");
                            minusz();
                        }
                    });
                    addTimer(r);
                }
                }
                if(missed){
                    text.setText("Elvétve");
                    text.setColor(Color.RED);
                    asd.check = 5;
                    missed = false;
                    waitfor = false;
                    TickTimer r = new TickTimer(1, false, new TickTimerListener() {
                        @Override
                        public void onStop(Timer sender) {
                            super.onStop(sender);
                            text.setText("");
                            minusz();
                        }
                    });
                    addTimer(r);
                }
            }
        });
        addTimer(inf);
    }

    void victory(){
        OneSpriteStaticActor cen = new OneSpriteStaticActor(game,CEN);
        cen.setSize(getWidth(),getHeight()/2);
        cen.setPosition(0,getViewport().getWorldHeight()/4);
        addActor(cen);
        vict.setVisible(true);
        TickTimer r = new TickTimer(1, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                van = true;
                game.setScreenWithPreloadAssets(GameScreen.class, new LoadingCsakJobbScreen(game));
            }
        });
        addTimer(r);
    }

    void mozgas(){
        lany.setX(lany.getX()-lanydistance);
        fiu.setX(fiu.getX()+fiudistance);
        holtart++;
        if(holtart == 10) victory();
        else kovi();
    }

    void minusz(){
        if(holtart > 1) {
            lany.setX(lany.getX() + lanydistance);
            fiu.setX(fiu.getX() - fiudistance);
            holtart--;
        }
        kovi();
    }

    public void kovi(){
        irany = MathUtils.random(0,3);
        waitfor = true;
        nyil.zuhanas(irany);
    }
}
