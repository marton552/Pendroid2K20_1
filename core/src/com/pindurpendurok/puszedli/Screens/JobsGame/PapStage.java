package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.JelkepActor;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

import static com.badlogic.gdx.scenes.scene2d.utils.ScissorStack.getViewport;

public class PapStage extends SimpleWorldStage {

    public final static String BACKGROUND = "elemek/munkahatter/Pszhiatraiszolgaltatonyujtoszobakomplexumketdarabfotelalisegysurmovalakinemtudjamiaz.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND);
        AssetList.collectAssetDescriptor(JelkepActor.class, assetList);
    }
    public static int pontok = 0;
    static public JelkepActor jelkep;
    static public int nehezseg;


    public PapStage(final MyGame game, int jelekSzama, int nehezseg) {
        super(new ResponseViewport(720f), game);
        PapStage.nehezseg = nehezseg;
        final OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getViewport().getWorldWidth(),getViewport().getWorldHeight());
        addActor(BackGround);

        /*
        BackGround.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                BackGround.setPositionCenter();
            }
        });
        TickTimer ido = new TickTimer(2,true, new TickTimerListener(){
            @Override
            public void onTick(Timer sender, float correction) {
                super.onTick(sender, correction);
                Random rnd = new Random();

            }
        });
        addTimer(ido);
        */
;
        for (int i = 0; i < jelekSzama; i++) {
            TickTimer jelekFeltunnek = new TickTimer((4f-nehezseg*0.025f)*i,false, new TickTimerListener(){
                @Override
                public void onStop(Timer sender) {
                    int skin = MathUtils.random(0,0);
                    jelkep =  new JelkepActor(game,world, skin,PapStage.nehezseg);
                    addActor(jelkep);
                    super.onStop(sender);
                    jelkep.addListener( new ClickListener(){
                        @Override
                        public void clicked (InputEvent event, float x, float y){
                            super.clicked(event, x, y);
                            PapStage.pontok++;
                            jelkep.torles();
                        }
                    });
                }
            });
            addTimer(jelekFeltunnek);
        }
        TickTimer pontKiiras = new TickTimer((4f-nehezseg*0.025f)*jelekSzama,false, new TickTimerListener(){
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                System.out.println("pontjaid:"+pontok);
            }
        });
        addTimer(pontKiiras);
    }

}
