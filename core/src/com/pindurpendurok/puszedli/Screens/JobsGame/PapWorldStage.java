package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Screens.Actors.JelkepActor;
import com.pindurpendurok.puszedli.Screens.Actors.PapJesusActor;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameScreen;
import com.pindurpendurok.puszedli.Screens.Shake.ShakeScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PapWorldStage extends SimpleWorldStage {
    public final static String BACKGROUND = "elemek/pap_minigame/map.png";
    public final static String POINTER = "elemek/pap_minigame/satan_pointer.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND);
        assetList.addTexture(POINTER);
        assetList.addFont(GameStage.FONT, 60, Color.WHITE).protect = true;
    }

    OneSpriteStaticActor pointer;
    int r;

    public PapWorldStage(final MyGame game) {
        super(new ResponseViewport(720f), game);
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(GameStage.FONT);
        ls.fontColor = Color.WHITE;
        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        MyLabel felirat = new MyLabel(game, "m", ls) {
            @Override
            public void init() {

            }
        };
        felirat.setFontScale(0.9f);
        felirat.setColor(Color.BLACK);
        felirat.setPosition(0,getViewport().getWorldHeight()-felirat.getHeight()*1.5f);
        addActor(felirat);

        int k = MathUtils.random(2,2+((GameStage.save.getInteger("ev")-2025)/3));
        if(GameStage.save.getInteger("papkell") == GameStage.save.getInteger("papmegvan"))GameStage.save.putInteger("papkell",k);
        felirat.setText("Szükséges munka a fizettséghez:"+GameStage.save.getInteger("papkell")+"\r\nEből kész van:"+GameStage.save.getInteger("papmegvan"));

        pointer = new OneSpriteStaticActor(game, POINTER);
        pointer.setSize(getWidth()/8,getWidth()/5);
        addActor(pointer);
        pointer.setVisible(false);
        pointer.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                clk();
            }
        });

        //pointer.setPosition(getWidth()/2.2f,getHeight()/1.35f);  //sikoly
        //pointer.setPosition(getWidth()/1.95f,getHeight()/5.2f);  //ádám teremtése
        //pointer.setPosition(getWidth()/2.5f,getHeight()/3.6f);  //utolsó vacsora
        //pointer.setPosition(getWidth()/1.365f,getHeight()/2.87f);   //egri nők
        //pointer.setPosition(getWidth()/3.5f,getHeight()/2);   //éjjeli őrjárat
        //pointer.setPosition(0,getHeight()/6.5f);   //valami madrid
        //pointer.setPosition(getWidth()/5.4f,getHeight()/2.6f);   //móna líza
        //pointer.setPosition(getWidth()/1.5f,getHeight()/3.05f); //kanizsa
        //pointer.setPosition(getWidth()/2.07f,getHeight()/4.3f); //vénusz szexy cuki pikcsör
        //pointer.setPosition(getWidth()/6,getHeight()/2.55f); //vizililiomok

        int rnd = MathUtils.random(1,5);

        TickTimer t = new TickTimer(rnd, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                    addpointer();

            }
        });
        addTimer(t);
    }

    void clk(){
        PapJesusActor j = new PapJesusActor(game,world,this);
        addActor(j);
        TickTimer t = new TickTimer(1.4f, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                addpointer();
                game.setScreen(new PapScreen(game,r));
            }
        });
        addTimer(t);
    }

    void addpointer(){
        r = MathUtils.random(0,9);
        if(r == 0) pointer.setPosition(getWidth()/2.2f,getHeight()/1.35f);
        else if(r == 1) pointer.setPosition(getWidth()/1.95f,getHeight()/5.2f);
        else if(r == 2) pointer.setPosition(getWidth()/2.5f,getHeight()/3.6f);
        else if(r == 3) pointer.setPosition(getWidth()/1.365f,getHeight()/2.87f);
        else if(r == 4) pointer.setPosition(getWidth()/3.5f,getHeight()/2);
        else if(r == 5) pointer.setPosition(0,getHeight()/6.5f);
        else if(r == 6) pointer.setPosition(getWidth()/5.4f,getHeight()/2.6f);
        else if(r == 7) pointer.setPosition(getWidth()/1.5f,getHeight()/3.05f);
        else if(r == 8) pointer.setPosition(getWidth()/2.07f,getHeight()/4.3f);
        else if(r == 9) pointer.setPosition(getWidth()/6,getHeight()/2.55f);
        pointer.setVisible(true);
    }

}
