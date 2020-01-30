package com.pindurpendurok.puszedli.Screens.Guess;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.Arrays;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;

public class GuessStage extends MyStage {

    public static final String SZAVAK = "szavak.atlas";

    public static AssetList list = new AssetList();
    static {
        list.addTextureAtlas(SZAVAK);
    }

    public ArrayList<String> worldList = new ArrayList<>();
    OneSpriteAnimatedActor word;

    SimpleButton[] btns = new SimpleButton[3];
    int randomID;
    int randomBtn;

    SimpleLabel scoreLabel;


    int SCORE = 0;
    int finalScore = MathUtils.random(5, 8);

    public GuessStage(MyGame game) {
        super(new ResponseViewport(720), game);
        worldList.addAll(Arrays.asList(new String[] {"kacsa","egér","szervermechanizmus","pink","sajt","flushed","brácsa","szabadság","szerelem","szalicil","kv","dob","láb","szőrös","valami","cukor","téboly","sóskifli","alma","rigó","cici","buzi","kocka","koala","lajhár","panda","kevin","help","oklevél","gép"}));

        randomID = MathUtils.random(0, 29);
        randomBtn = MathUtils.random(0, 2);

        word = new OneSpriteAnimatedActor(getGame(), SZAVAK);
        word.stop();
        word.setFrame(randomID);
        word.setSize(word.getWidth() * 2, word.getHeight() * 2);
        word.setPosition(getViewport().getWorldWidth() / 2 - word.getWidth() / 2, getViewport().getWorldHeight() / 2 + word.getHeight());
        addActor(word);

        System.out.printf(worldList.get(randomID));

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new SimpleButton(getGame(), worldList.get(randomID));
            btns[i].setWidth(getViewport().getWorldWidth() - 100);
            btns[i].setPosition(getViewport().getWorldWidth() / 2 - btns[i].getWidth() / 2, 100 + (i*(btns[i].getHeight() + 20)));
            final int finalI = i;
            btns[i].addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);

                    pressedButton(finalI);
                }
            });
            addActor(btns[i]);
        }

        nextPicture();

        scoreLabel = new SimpleLabel(game, "");
        scoreLabel.setPosition(getViewport().getWorldWidth() / 2 - scoreLabel.getWidth() / 2, word.getY() - scoreLabel.getHeight() - 50);
        scoreLabel.setAlignment(Align.center);
        updateLabel();
        addActor(scoreLabel);

    }

    public void nextPicture() {
        stopThat = false;
        randomID = MathUtils.random(0, 29);
        randomBtn = MathUtils.random(0, btns.length - 1);

        String answer = worldList.get(randomID);

        ArrayList<String> listWithoutAnswer = (ArrayList<String>) worldList.clone();
        listWithoutAnswer.remove(randomID);

        btns[randomBtn].setText(answer);

        for(int i = 0; i < btns.length; i++) {
            if(i != randomBtn) {
                int index = MathUtils.random(0, listWithoutAnswer.size() - 1);
                btns[i].setText(listWithoutAnswer.get(index));
                listWithoutAnswer.remove(index);
            }
        }

        word.setFrame(randomID);

    }

    boolean stopThat = false;

    public void wrongAnswer(final int btn) {
        SCORE--;
        if(SCORE < 0) SCORE = 0;

        stopThat = true;

        updateLabel();

        btns[btn].setColor(Color.RED);
        addTimer(new TickTimer(0.5f, false, new TickTimerListener(){
            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);

                btns[btn].setColor(Color.WHITE);
                nextPicture();
            }
        }));
    }

    public void okAnswer(final int btn) {
        SCORE++;
        updateLabel();
        stopThat = true;

        if(SCORE == finalScore) {
            game.setScreen(new GameScreen(game));
        }else {

            btns[btn].setColor(Color.GREEN);
            addTimer(new TickTimer(0.5f, false, new TickTimerListener(){
                @Override
                public void onStop(Timer sender) {
                    super.onStop(sender);
                    btns[btn].setColor(Color.WHITE);
                    nextPicture();
                }
            }));
        }
    }

    public void updateLabel() {
        scoreLabel.setText(finalScore+"/"+SCORE);
    }


    public void pressedButton(int btnid) {
        if(stopThat) return;
        if(btnid == randomBtn) {
            okAnswer(btnid);
        }else {
            wrongAnswer(btnid);
        }
    }
}
