package com.pindurpendurok.puszedli.Puzzle;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Elements.SimpleLabel;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;

import hu.csanyzeg.master.Demos.FlappyBird.PipeActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class PuzzleStage extends MyStage {
    public static final String PUZZLE1 = "puzzle/puzzle1.atlas";
    public static final String WBG = "ui_textures/black.png";


    public static AssetList list = new AssetList();
    static {
        list.addTextureAtlas(PUZZLE1);
        list.addTexture(WBG);
    }


    OneSpriteStaticActor endBg;
    SimpleLabel endLabel;
    SimpleButton endBtn;

    public PuzzleStage(MyGame game) {
        super(new ResponseViewport(720), game);

        PuzzleBoard b = new PuzzleBoard(game, PUZZLE1) {
            @Override
            public void winPuzzle() {
                super.winPuzzle();

                endBg.setVisible(true);
                endLabel.setVisible(true);
                endBtn.setVisible(true);

            }
        };
        b.setPosition(getViewport().getWorldWidth() / 2 -  b.getWidth() / 2 - 10, getViewport().getWorldHeight() / 2 - b.getHeight() / 2 - 10);
        addActor(b);


        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setVisible(false);
        endBg.setSize(getViewport().getWorldWidth(), 500);
        endBg.setPosition(0, getViewport().getWorldHeight() / 2 - endBg.getHeight() / 2);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Sikeresen kiraktad a puzzlet!");
        endLabel.setVisible(false);
        endLabel.setPosition(getViewport().getWorldWidth() / 2 - endLabel.getWidth() / 2 - 15, endBg.getY() + endBg.getHeight() - 150);
        endLabel.setAlignment(Align.center);
        addActor(endLabel);

        endBtn = new SimpleButton(game, "Vissza");
        endBtn.setVisible(false);
        endBtn.setPosition(getViewport().getWorldWidth() / 2 - endBtn.getWidth() / 2, endBg.getY() + 50);
        endBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getGame().setScreen(new GameScreen(getGame()));
            }
        });
        addActor(endBtn);



    }
}
