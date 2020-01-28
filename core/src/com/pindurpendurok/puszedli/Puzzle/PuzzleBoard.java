package com.pindurpendurok.puszedli.Puzzle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyGroup;

public class PuzzleBoard extends MyGroup {
    PuzzleActor[][] actors = new PuzzleActor[5][5];

    public PuzzleBoard(MyGame game, String puzzleAtlasHash) {
        super(game);
        setSize(500, 500);
        setPosition(getX() + 10, getY() + 10);

        int id = 0;
        float theX = 0;
        float theY = 400;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                PuzzleActor pa = new PuzzleActor(game, puzzleAtlasHash);
                pa.setFrameSprite(id);

                System.out.println(id+": "+pa.getActualFrame());
                final int finalJ = j;
                final int finalI = i;

                /*final PuzzleActor a = pa;
                pa.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        clickedPuzzle(a);
                    }
                });*/
                pa.setSize(100, 100);
                pa.setPosition(theX, theY);

                actors[i][j] = pa;
                addActor(pa);

                theX += 110;
                id++;
            }

            theX = 0;
            theY -= 100;
        }


    }

    /*private PuzzleActor getPActor(String hash) {

    }*/

    public void clickedPuzzle(PuzzleActor actor) {

    }
}
