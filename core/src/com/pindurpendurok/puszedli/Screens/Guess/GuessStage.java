package com.pindurpendurok.puszedli.Screens.Guess;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;

import java.util.ArrayList;
import java.util.Arrays;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class GuessStage extends MyStage {

    public static final String SZAVAK = "szavak.atlas";

    public static AssetList list = new AssetList();
    static {
        list.addTextureAtlas(SZAVAK);
    }

    public ArrayList<String> worldList = new ArrayList<>();
    OneSpriteAnimatedActor word;

    SimpleButton[] btns = new SimpleButton[3];

    public GuessStage(MyGame game) {
        super(new ResponseViewport(720), game);
        worldList.addAll(Arrays.asList(new String[] {"kacsa","egér","szervermechanizmus","pink","sajt","flushed","brácsa","szabadság","szerelem","szalicil","kv","dob","láb","szőrös","valami","cukor","téboly","sóskifli","alma","rigó","cici","buzi","kocka","koala","lajhár","panda","kevin","help","oklevél","gép"}));

        int randomID = MathUtils.random(0, 29);


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



    }


    public void pressedButton(int btnid) {

    }
}
