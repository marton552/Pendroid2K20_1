package com.pindurpendurok.puszedli.Screens.Wow;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;


public class WowStage extends MyStage {

    public static final String FULLWHITE = "ui_textures/fullwhite.png";
    public static final String GRAY = "ui_textures/gray.png";
    public static final String HP_BAR = "ui_textures/red.png";
    public static final String BLACK = "ui_textures/black.png";


    public static AssetList list = new AssetList();
    static {
        list.addTexture(FULLWHITE);
        list.addTexture(GRAY);
        list.addTexture(HP_BAR);
        list.addTexture(BLACK);

        AssetList.collectAssetDescriptor(ElementAssets.class, list);
        AssetList.collectAssetDescriptor(Goblin.class, list);

    }

    ArrayList<Goblin> goblins = new ArrayList<>();
    int barW = 700;
    int killedGoblins = 0;
    int maxGoblinKill = 0; //MathUtils.random(10, 30);
    int playerHP = 100;

    boolean isGamePlaying = true;

    OneSpriteStaticActor hpBar;

    OneSpriteStaticActor overBg;
    SimpleLabel overLabel;
    SimpleButton overBtn;

    OneSpriteStaticActor victoryBg;
    SimpleLabel victoryLabel;
    SimpleButton victoryBtn;

    public int difficulty;


    SimpleLabel info;

    public WowStage(MyGame game, Boolean munkaE) {
        super(new ResponseViewport(720), game);
        difficulty = 30; //Math.round(game.save.getFloat("gatfal_hp"));
        if(difficulty <= 10) difficulty = 20;
        if(munkaE){
            //munka
            maxGoblinKill = MathUtils.random(25, 30);
        }
        else{
            //hobby
            maxGoblinKill = MathUtils.random(15,20);
        }
        /*OneSpriteStaticActor bg = new OneSpriteStaticActor(Assets.manager.get(Assets.ERDO));
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);
        */

        OneSpriteStaticActor hpBarBG = new OneSpriteStaticActor(getGame(), FULLWHITE);
        hpBarBG.setSize(barW, 30);
        hpBarBG.setPosition(getViewport().getWorldWidth() / 2 - hpBarBG.getWidth() / 2, getViewport().getWorldHeight() - 50);

        OneSpriteStaticActor hpBarOut = new OneSpriteStaticActor(getGame(), GRAY);
        hpBarOut.setSize(barW + 10, 30 + 10);
        hpBarOut.setPosition(hpBarBG.getX() - 5, hpBarBG.getY() - 5);

        addActor(hpBarOut);
        addActor(hpBarBG);

        hpBar = new OneSpriteStaticActor(getGame(), HP_BAR);
        hpBar.setSize((barW/100)*playerHP, hpBarBG.getHeight());
        hpBar.setPosition(hpBarBG.getX(), hpBarBG.getY());

        addActor(hpBar);

        SimpleLabel hpLabel = new SimpleLabel(getGame(), "HP");
        hpLabel.setFontScale(0.6f);
        hpLabel.setPosition(getViewport().getWorldWidth() / 2 - (hpLabel.getWidth()*hpLabel.getFontScaleX()) / 2 + 3, hpBarBG.getY() - 20);

        addActor(hpLabel);

        overBg = new OneSpriteStaticActor(getGame(), BLACK);
        overBg.setSize(getViewport().getWorldWidth(), 500);
        overBg.setY(getViewport().getWorldHeight() / 2 - overBg.getHeight() / 2);
        overBg.setAlpha(0.8f);
        overBg.setVisible(false);

        addActor(overBg);

        overLabel = new SimpleLabel(getGame(), "Meghaltál!");
        overLabel.setFontScale(0.7f);
        overLabel.setColor(Color.RED);
        overLabel.setPosition(getViewport().getWorldWidth() / 2 - (overLabel.getWidth()*overLabel.getFontScaleX()) / 2, overBg.getY() + 300);
        overLabel.setVisible(false);

        addActor(overLabel);

        overBtn = new SimpleButton(getGame(), "Újra");
        overBtn.setWidth(300);
        overBtn.setPosition(getViewport().getWorldWidth() / 2 - overBtn.getWidth() / 2, overBg.getY() + 150);
        overBtn.setVisible(false);
        overBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                restartGame();
            }
        });

        addActor(overBtn);

        victoryBg = new OneSpriteStaticActor(getGame(), BLACK);
        victoryBg.setSize(getViewport().getWorldWidth(), 500);
        victoryBg.setY(getViewport().getWorldHeight() / 2 - victoryBg.getHeight() / 2);
        victoryBg.setAlpha(0.8f);
        victoryBg.setVisible(false);

        addActor(victoryBg);

        victoryLabel = new SimpleLabel(getGame(), "Sikeresen kiírtottad\naz összes mobot!"+"\nJutalmad ");
        victoryLabel.setFontScale(0.7f);
        victoryLabel.setAlignment(Align.center);
        victoryLabel.setColor(Color.WHITE);
        victoryLabel.setPosition(getViewport().getWorldWidth() / 2 - (victoryLabel.getWidth()*victoryLabel.getFontScaleX()) / 2 - 80, victoryBg.getY() + 300);
        victoryLabel.setVisible(false);

        addActor(victoryLabel);

        victoryBtn = new SimpleButton(getGame(), "Vissza");
        victoryBtn.setWidth(300);
        victoryBtn.setPosition(getViewport().getWorldWidth() / 2 - victoryBtn.getWidth() / 2, victoryBg.getY() + 150);
        victoryBtn.setVisible(false);
        victoryBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                //game.save.putFloat("minigamek",game.save.getFloat("minigamek")+1);
                //game.save.flush();
                getGame().setScreen(new GameScreen(getGame()));
            }
        });

        addActor(victoryBtn);


        info = new SimpleLabel(getGame(), maxGoblinKill+"/"+killedGoblins);
        info.setAlignment(Align.center);
        info.setFontScale(0.9f);
        info.setPosition(getViewport().getWorldWidth() / 2 - (info.getWidth()*info.getFontScaleX()) / 2 - 10, getViewport().getWorldHeight() - 130);

        addActor(info);

    }

    public void onGoblinKill(Goblin g) {
        //game.save.putFloat("goblinok",game.save.getFloat("goblinok")+1);

        Blood blood = new Blood(getGame());
        blood.setPosition(g.getX() + g.getWidth() / 2 - blood.getWidth() / 2, g.getY() + g.getHeight() / 2 - blood.getHeight() / 2);
        addActor(blood);

        getActors().removeValue(g, false);
        goblins.remove(g);

        //Assets.manager.get(Assets.GOBLIN_DEATH_SOUND).play(1);

        killedGoblins++;

        if(killedGoblins >= maxGoblinKill) {
            gameVictory();
        }

        info.setText(maxGoblinKill+"/"+killedGoblins);
    }

    public void createRandomGoblin() {
        Goblin g = new Goblin(getGame(), Goblin.getRandomGoblinType(), this);
        g.setPosition(MathUtils.random(10, getViewport().getWorldWidth() - 100), MathUtils.random(10, getViewport().getWorldHeight() - 180));
        goblins.add(g);
        addActor(g);
    }

    public void hitPlayer() {
        if(isGamePlaying == false) return;

        playerHP -= MathUtils.random(1, 3);
        if(playerHP <= 0) {
            playerHP = 0;

            gameOver();

        } else hpBar.setWidth((barW/100)*playerHP);


    }

    public void gameOver() {
        isGamePlaying = false;

        overBg.setVisible(true);
        overLabel.setVisible(true);
        overBtn.setVisible(true);

        hpBar.setWidth((barW/100)*playerHP);

        for (int i = 0; i < goblins.size(); i++) {
            Goblin g = goblins.get(i);
            getActors().removeValue(g, false);
        }

        for (int i = 0; i < goblins.size(); i++) {
            goblins.remove(i);
        }

        //Assets.manager.get(Assets.LOSE_SOUND).play(1);

        goblins.clear();
    }

    public void gameVictory() {
        isGamePlaying = false;

        victoryBg.setVisible(true);
        victoryLabel.setVisible(true);
        victoryBtn.setVisible(true);

        //game.save.putFloat("gatfal_hp", 100.0f);
        //game.save.flush();

        //Assets.manager.get(Assets.VICTORY_SOUND).play(1);
    }

    public void restartGame() {
        playerHP = 100;
        killedGoblins = 0;

        overBg.setVisible(false);
        overLabel.setVisible(false);
        overBtn.setVisible(false);

        //difficulty += 5; // Ez elrontja az egészet, tehát nem fog könnyebb lenni a dolog
        info.setText(maxGoblinKill+"/"+killedGoblins);
        hpBar.setWidth((barW/100)*playerHP);

        isGamePlaying = true;

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreen(new GameScreen(game));
            }
        });
    }

    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);

        if(isGamePlaying) {
            counter++;

            if(counter % difficulty == 0) {
                if(killedGoblins+goblins.size()+1 <= maxGoblinKill) createRandomGoblin();
            }
        }
    }

    @Override
    public void init() {

    }
}
