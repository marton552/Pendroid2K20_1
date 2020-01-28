package com.pindurpendurok.puszedli.Puzzle;

import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.Demos.FlappyBird.PipeActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class PuzzleStage extends MyStage {
    public static final String PUZZLE1 = "puzzle/puzzle1.atlas";

    public static AssetList list = new AssetList();
    static {
        list.addTextureAtlas(PUZZLE1);
    }
    public PuzzleStage(MyGame game) {
        super(new ResponseViewport(720), game);

        PuzzleBoard b = new PuzzleBoard(game, PUZZLE1);
        addActor(b);

    }
}
