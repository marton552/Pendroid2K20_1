package com.pindurpendurok.puszedli.Screens.MiniGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.QuestionCircleActor;
import com.pindurpendurok.puszedli.Screens.Actors.SzurkecuccBarhovaActor;
import com.pindurpendurok.puszedli.Screens.Classes.MathGeneral;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.Direction;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MathGameStage extends SimpleWorldStage {


    List<CircleAtBackgroundActor> korok = new ArrayList<>();
    List<QuestionCircleActor> qk = new ArrayList<>();
    public final static String BACKGROUND = "math_back.png";
    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        AssetList.collectAssetDescriptor(QuestionCircleActor.class, assetList);
        AssetList.collectAssetDescriptor(SzurkecuccBarhovaActor.class, assetList);
        assetList.addFont(GameStage.FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);

        AssetList.collectAssetDescriptor(ElementAssets.class, assetList);
    }

    MyLabel kerdes1;
    MyLabel val1;
    MyLabel val2;
    MyLabel jovalasz;
    MyLabel timer;
    int tim;
    TickTimer t;
    MathGeneral szamolas = new MathGeneral();
    int gamemode;


    public MathGameStage(final MyGame game, final int jatekmod) {
        super(new ResponseViewport(1080f), game);
        setCameraResetToLeftBottomOfScreen();
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(GameStage.FONT);
        ls.fontColor = Color.WHITE;
        gamemode = jatekmod;
        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        for (int i = 0;i<20;i++){
            CircleAtBackgroundActor asd = new CircleAtBackgroundActor(game,world);
            korok.add(asd);
            addActor(asd);
        }

        jovalasz = new MyLabel(game, "69", ls) {
            @Override
            public void init() {

            }
        };
        jovalasz.setPosition(getWidth()/2-getWidth()/10,getHeight()/2+getHeight()/30);
        jovalasz.setColor(Color.BLACK);
        jovalasz.setFontScale(4f);
        addActor(jovalasz);

        SzurkecuccBarhovaActor kerdes = new SzurkecuccBarhovaActor(game,world,0,getHeight()/1.3f,getWidth(),getHeight()/3f);
        addActor(kerdes);

        SzurkecuccBarhovaActor valasz1 = new SzurkecuccBarhovaActor(game,world,getWidth()/2-getWidth()/2.3f,getHeight()/2-getHeight()/2.15f,getWidth()/2.4f,getHeight()/7);
        addActor(valasz1);

        SzurkecuccBarhovaActor valasz2 = new SzurkecuccBarhovaActor(game,world,getWidth()/2+getWidth()/2.3f-getWidth()/2.4f,getHeight()/2-getHeight()/2.15f,getWidth()/2.4f,getHeight()/7);
        addActor(valasz2);


        kerdes1 = new MyLabel(game, "Ez itt a kerdes?", ls) {
            @Override
            public void init() {

            }
        };
        kerdes1.setPosition(getWidth()/10,getHeight()/1.13f);
        kerdes1.setFontScale(1.5f);
        addActor(kerdes1);

        val1 = new MyLabel(game, "116", ls) {
            @Override
            public void init() {

            }
        };
        val1.setPosition(getWidth()/2-getWidth()/2.7f,getHeight()/2-getHeight()/2.45f);
        val1.setFontScale(4f);
        addActor(val1);

        val2 = new MyLabel(game, "42", ls) {
            @Override
            public void init() {

            }
        };
        val2.setPosition(getWidth()/2+getWidth()/2.7f-getWidth()/3.7f,getHeight()/2-getHeight()/2.45f);
        val2.setFontScale(4f);
        addActor(val2);

        timer = new MyLabel(game, "6", ls) {
            @Override
            public void init() {

            }
        };
        timer.setPosition(getWidth()/2-getWidth()/10,getHeight()/2-getHeight()/10);
        timer.setColor(Color.BLACK);
        timer.setFontScale(4f);
        addActor(timer);

        tim = 0;
        t = new TickTimer(1, true, new TickTimerListener() {


            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                tim++;
                timer.setText(6-tim);
                if(tim==6){t.stop();timer.setVisible(false);}
            }
        });
        addTimer(t);

        System.out.println(jatekmod);

        SimpleButton btn = new SimpleButton(game, "PAUSE");
        btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                ((MathGameScreen)getScreen()).changeStage(1,jatekmod);

                for (int i = 0; i < 20;i++){
                    korok.get(i).remove();
                }
            }
        });
        kerdeskorok();
        addActor(btn);
    }


    void kerdeskorok(){
        szamolas.ujfeladvany(gamemode);
        kerdes1.setText(szamolas.feladvany);
        val1.setText(szamolas.left);
        val2.setText(szamolas.right);
        jovalasz.setText(szamolas.goodanswer);
        boolean x;
        for(int i = 0; i< 5;i++){
            if(i%2==0)x = true;
            else x = false;
            QuestionCircleActor n = new QuestionCircleActor(game, world,this,1+(0.2f*i),x,i);
            qk.add(n);
            addActor(n);
        }
    }
}
