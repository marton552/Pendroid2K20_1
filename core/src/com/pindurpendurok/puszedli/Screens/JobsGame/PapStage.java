package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.graphics.Color;
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

    public PapStage(final MyGame game, int szama) {
        super(new ResponseViewport(720f), game);
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
        //egybe kidob mindent
        List<JelkepActor> jelek = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            jelek.add(new JelkepActor(game,world, 0));
        }
        for (int i = 0; i < jelek.size(); i++) {
            addActor(jelek.get(i));
        }
        //comment hogy commitolni tudjak

    }

}
