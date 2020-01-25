package com.pindurpendurok.puszedli.Screens.Trash;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.sun.corba.se.impl.protocol.giopmsgheaders.TargetAddress;

import java.util.ArrayList;
import java.util.Arrays;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class TrashStage extends SimpleWorldStage {

    public static final String GLASS1 = "elemek/trash/glass/glass_1.png";
    public static final String GLASS2 = "elemek/trash/glass/glass_2.png";
    public static final String GLASS3 = "elemek/trash/glass/glass_3.png";
    public static final String GLASS4 = "elemek/trash/glass/glass_4.png";
    public static final String GLASS_BIN = "elemek/trash/glass/glass_bin.png";
    public static ArrayList<String> glassTrash = new ArrayList<>();


    public static final String METAL1 = "elemek/trash/metal/metal_1.png";
    public static final String METAL2 = "elemek/trash/metal/metal_2.png";
    public static final String METAL3 = "elemek/trash/metal/metal_3.png";
    public static final String METAL4 = "elemek/trash/metal/metal_4.png";
    public static final String METAL_BIN = "elemek/trash/metal/metal_bin.png";
    public static ArrayList<String> metalTrash = new ArrayList<>();


    public static final String PAPER1 = "elemek/trash/paper/paper_1.png";
    public static final String PAPER2 = "elemek/trash/paper/paper_2.png";
    public static final String PAPER3 = "elemek/trash/paper/paper_3.png";
    public static final String PAPER4 = "elemek/trash/paper/paper_4.png";
    public static final String PAPER_BIN = "elemek/trash/paper/paper_bin.png";
    public static ArrayList<String> paperTrash = new ArrayList<>();


    public static final String PLASTIC1 = "elemek/trash/plastic/plastic_1.png";
    public static final String PLASTIC2 = "elemek/trash/plastic/plastic_2.png";
    public static final String PLASTIC3 = "elemek/trash/plastic/plastic_3.png";
    public static final String PLASTIC4 = "elemek/trash/plastic/plastic_4.png";
    public static final String PLASTIC_BIN = "elemek/trash/plastic/plastic_bin.png";
    public static ArrayList<String> plasticTrash = new ArrayList<>();

    public static final String WBG = "ui_textures/black.png";


    public static AssetList list = new AssetList();
    static {
        list.addTexture(GLASS1);
        list.addTexture(GLASS2);
        list.addTexture(GLASS3);
        list.addTexture(GLASS4);
        list.addTexture(GLASS_BIN);
        glassTrash.addAll(Arrays.asList(new String[] {GLASS1, GLASS2, GLASS3, GLASS4}));


        list.addTexture(METAL1);
        list.addTexture(METAL2);
        list.addTexture(METAL3);
        list.addTexture(METAL4);
        list.addTexture(METAL_BIN);
        metalTrash.addAll(Arrays.asList(new String[] {METAL1, METAL2, METAL3, METAL4}));


        list.addTexture(PAPER1);
        list.addTexture(PAPER2);
        list.addTexture(PAPER3);
        list.addTexture(PAPER4);
        list.addTexture(PAPER_BIN);
        paperTrash.addAll(Arrays.asList(new String[] {PAPER1, PAPER2, PAPER3, PAPER4}));



        list.addTexture(PLASTIC1);
        list.addTexture(PLASTIC2);
        list.addTexture(PLASTIC3);
        list.addTexture(PLASTIC4);
        list.addTexture(PLASTIC_BIN);
        plasticTrash.addAll(Arrays.asList(new String[] {PLASTIC1, PLASTIC2, PLASTIC3, PLASTIC4}));

        list.addTexture(WBG);


    }

    boolean gameEnded = false;

    public int score = 0;
    public int finalScore = MathUtils.random(10, 20);
    public int collectingTrashID = MathUtils.random(0, 3);


    SimpleLabel scoreLabel;
    TrashBin bin;

    OneSpriteStaticActor endBg;
    SimpleLabel endLabel;
    SimpleButton endBtn;

    public TrashStage(final MyGame game) {
        super(new ResponseViewport(720), game);
        setCameraResetToLeftBottomOfScreen();
        
        scoreLabel = new SimpleLabel(game, "");
        scoreLabel.setPosition(getViewport().getWorldWidth() / 2, getViewport().getWorldHeight() - scoreLabel.getHeight() - 10);
        scoreLabel.setAlignment(Align.center);
        updateScoreLabel();
        addActor(scoreLabel);

        bin = new TrashBin(game, getBinTextureHash(collectingTrashID), world);
        addListener(new ClickListener() {

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if(gameEnded == false) {
                    bin.setX(x - bin.getWidth() / 2);
                    if(bin.getX() < 0) bin.setX(0);
                    if(bin.getX() > getViewport().getWorldWidth()) bin.setX(getViewport().getWorldWidth() - bin.getWidth());
                }
                super.touchDragged(event, x, y, pointer);
            }
        });
        addActor(bin);

        addTimer(new TickTimer(MathUtils.random(1), true, new TickTimerListener(){
            @Override
            public void onRepeat(TickTimer sender) {
                super.onRepeat(sender);
                spawnActor();
                sender.setInterval(MathUtils.random(1f, 3f));
            }
        }));


        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setVisible(false);
        endBg.setSize(getViewport().getWorldWidth(), 500);
        endBg.setPosition(0, getViewport().getWorldHeight() / 2 - endBg.getHeight() / 2);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Sikeresen kiráztad!");
        endLabel.setVisible(false);
        endLabel.setPosition(endLabel.getWidth() / 2 - 30, endBg.getY() - endBg.getHeight() - 50);
        endLabel.setAlignment(Align.center);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Vissza");
        endBtn.setVisible(false);
        endBtn.setPosition(getViewport().getWorldWidth() / 2 - endBtn.getWidth() / 2, endBg.getY() + 50);
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        addActor(endBtn);

    }

    public void spawnActor() {
        if(gameEnded) return;
        boolean good = false;
        if(MathUtils.random(1, 100) < 40) good = true;

        TrashActor actor = new TrashActor(game, good == true ? getRandomTrashHash(collectingTrashID) : getRandomBadTrashHash(collectingTrashID), world, good);
        actor.setPosition(MathUtils.random(0, getViewport().getWorldWidth() - actor.getWidth()), getViewport().getWorldHeight() + MathUtils.random(0, 50));
        addActor(actor);

    }

    public String getBinTextureHash(int binid) {
        if(binid == 0) return GLASS_BIN;
        if(binid == 1) return METAL_BIN;
        if(binid == 2) return PAPER_BIN;
        if(binid == 3) return PLASTIC_BIN;

        return GLASS_BIN;
    }


    public String getRandomTrashHash(int trashID) {
        if(trashID == 0)
            return glassTrash.get(MathUtils.random(0, glassTrash.size() - 1));
        else if(trashID == 1)
            return metalTrash.get(MathUtils.random(0, metalTrash.size() - 1));
        else if(trashID == 2)
            return paperTrash.get(MathUtils.random(0, paperTrash.size() - 1));
        else if(trashID == 3)
            return plasticTrash.get(MathUtils.random(0, plasticTrash.size() - 1));

        return GLASS1;
    }


    public String getRandomBadTrashHash(int goodTrashID)  {
        int rand = goodTrashID;
        while (rand == goodTrashID) rand = MathUtils.random(0, 3);

        return getRandomTrashHash(rand);
    }

    public void trashCollectError() {
        if(gameEnded) return;
        if(score > 0) score--;

        updateScoreLabel();
    }

    public void goodTrashCollected() {
        if(gameEnded) return;

        score++;
        updateScoreLabel();

        if(score >= finalScore) {
            endGame();
        }
    }

    public void endGame() {
        endBg.setVisible(true);
        endLabel.setVisible(true);
        endBtn.setVisible(true);

        gameEnded = true;

    }

    public void updateScoreLabel() {
        scoreLabel.setText(finalScore + "/" + score);
    }


}
