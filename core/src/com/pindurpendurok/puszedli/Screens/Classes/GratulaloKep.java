package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class GratulaloKep {

    public final static String FONT = "Bosk.otf";
    public final static String UI = "ui_textures/gold.png";
    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
    }
   static OneSpriteStaticActor back;
    static MyLabel text;
    static MyLabel text0;
    static MyLabel text1;
    static MyLabel text2;
    static MyLabel text3;
    static MyLabel text4;
    static String seged = ";";

    public GratulaloKep(){
    }

    static public void letrehoz(MyGame game, SimpleWorldStage gs,String szoveg,final int penz,final int ehseg,final int szomjusag, final int stressz,final int alkohol, float w){
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;


        System.out.println("asd");
        back = new OneSpriteStaticActor(game, UI);
        float h = gs.getHeight()/30;
        back.setSize(gs.getWidth()/1.5f,h);
        back.setPosition(w+gs.getViewport().getWorldWidth()/2-back.getWidth()/2,gs.getViewport().getWorldHeight()/2-back.getHeight());
        gs.addActor(back,39999);
        float height = back.getHeight()/5;
        int ja = 1;
        text0 = new MyLabel(game, szoveg, ls) {
            @Override
            public void init() {

            }
        };
        text0.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/50)*text0.getText().length),back.getY()-(h*ja));
        text0.setColor(Color.BLACK);
        text0.setFontScale(1);
        gs.addActor(text0,40000);

        if(penz != 0){
            if(penz >0)seged="Penz: +"+penz;
            else seged="Penz: "+penz;
            text = new MyLabel(game, seged, ls) {
                @Override
                public void init() {

                }
            };
            ja++;

            text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/60)*text.getText().length),back.getY()-(h*ja));
            text.setColor(Color.BLACK);
            text.setFontScale(1);
            gs.addActor(text,40000);}

        if(ehseg != 0){
            if(ehseg >0)seged="Jóllakottság: +"+ehseg;
            else seged="Jóllakottság: "+ehseg;
            text1 = new MyLabel(game, seged, ls) {
                @Override
                public void init() {

                }
            };
            ja++;
            text1.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/60)*text1.getText().length),back.getY()-(h*ja));
            text1.setColor(Color.BLACK);
            text1.setFontScale(1);
            gs.addActor(text1,40000);}

        if(szomjusag != 0){
            if(szomjusag >0)seged="Hidratáltság: +"+szomjusag;
            else seged="Hidratáltság: "+szomjusag;
            text2 = new MyLabel(game, seged, ls) {
                @Override
                public void init() {

                }
            };
            ja++;
            text2.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/60)*text2.getText().length),back.getY()-(h*ja));
            text2.setColor(Color.BLACK);
            text2.setFontScale(1);
            gs.addActor(text2,40000);}

        if(stressz != 0){
            if(stressz >0)seged="Nyguodtság: +"+stressz;
            else seged="Nyguodtság: "+stressz;
            text3 = new MyLabel(game, seged, ls) {
                @Override
                public void init() {

                }
            };
            ja++;
            text3.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/60)*text3.getText().length),back.getY()-(h*ja));
            text3.setColor(Color.BLACK);
            text3.setFontScale(1);
            gs.addActor(text3,40000);}

        if(alkohol != 0){
            if(alkohol >0)seged="Alkoholszint: +"+alkohol;
            else seged="Alkoholszint: "+alkohol;
            text4 = new MyLabel(game, seged, ls) {
                @Override
                public void init() {

                }
            };
            ja++;
            text4.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/60)*text4.getText().length),back.getY()-(h*ja));
            text4.setColor(Color.BLACK);
            text4.setFontScale(1);
            gs.addActor(text4,40000);}
        back.setHeight(gs.getHeight()/30*ja);
        if(penz != 0)text.setY(text.getY()+back.getHeight());
        text0.setY(text0.getY()+back.getHeight());
        if(ehseg != 0)text1.setY(text1.getY()+back.getHeight());
        if(szomjusag != 0)text2.setY(text2.getY()+back.getHeight());
        if(stressz != 0)text3.setY(text3.getY()+back.getHeight());
        if(alkohol != 0)text4.setY(text4.getY()+back.getHeight());

        TickTimer t = new TickTimer(1, false, new TickTimerListener() {
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                text0.remove();
                back.remove();
                if(penz != 0)text.remove();
                if(ehseg != 0)text1.remove();
                if(szomjusag != 0)text2.remove();
                if(stressz != 0)text3.remove();
                if(alkohol != 0)text4.remove();
            }
        });
        gs.addTimer(t);
    }
}
