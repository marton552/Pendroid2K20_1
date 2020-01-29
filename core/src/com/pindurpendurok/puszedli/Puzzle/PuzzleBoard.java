package com.pindurpendurok.puszedli.Puzzle;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class PuzzleBoard extends MyGroup {
    public static final String RED = "ui_textures/red.png";

    public static AssetList list = new AssetList();
    static {

    }

    PuzzleActor[][] actors = new PuzzleActor[5][5];
    ArrayList<Integer> ids = new ArrayList<Integer>();

    OneSpriteStaticActor red;


    public PuzzleBoard(MyGame game, String puzzleAtlasHash) {
        super(game);
        setSize(500, 500);
        setPosition(getX() + 10, getY() + 10);

        for(int i = 0; i < 25; i++) ids.add(i);

        red = new OneSpriteStaticActor(game, RED);
        red.setSize(106, 106);
        red.setVisible(false);
        addActor(red);

        float theX = 0;
        float theY = 400;
        PuzzleActor pa = null;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int randomid = MathUtils.random(0, ids.size()-1);
                int id = ids.get(randomid);

                pa = new PuzzleActor(game, puzzleAtlasHash);
                pa.setFrame(id);

                ids.remove(randomid);

                addActor(pa);

                final PuzzleActor a = pa;
                pa.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        clickedPuzzle(a);
                    }
                });
                pa.setSize(100, 100);
                pa.setPosition(theX, theY);

                actors[i][j] = pa;

                theX += (100 + 5);
            }

            theX = 0;
            theY -= (100 + 5);
        }
    }

    /*private PuzzleActor getPActor(String hash) {

    }*/


    public boolean checkIfPuzzleIsCompleted() {
        boolean ok = true;
        int id = 0;
        for (int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(actors[i][j].getActualFrame() != id) {
                    ok = false;
                    break;
                }

                id++;
            }
        }

        return ok;
    }

    public void winPuzzle() {
        System.out.println("KÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉÉSSSSSSSSSSSSSSSSSSSZZZZZZZZZZZZZZZZ");
    }

    PuzzleActor clickedActor = null;

    public void clickedPuzzle(PuzzleActor actor) {
        if(clickedActor == null) {
            clickedActor = actor;
            red.setPosition(clickedActor.getX() - 3, clickedActor.getY() - 3);
            red.setVisible(true);
        }
        else {
            if(clickedActor != actor) {
                int actorFrame = actor.getActualFrame();
                actor.setFrame(clickedActor.getActualFrame());
                clickedActor.setFrame(actorFrame);
                red.setVisible(false);

                if(checkIfPuzzleIsCompleted()) winPuzzle();
            }

            clickedActor = null;

        }
    }
}
