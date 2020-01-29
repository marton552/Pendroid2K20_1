package com.pindurpendurok.puszedli.Puzzle;

import com.badlogic.gdx.math.MathUtils;
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
    //public static final String PUZZLE1 = "puzzle/1.atlas";
    public static final String WBG = "ui_textures/black.png";
    public static final String FONTOCSKA = "alegreyaregular.otf";


    public static AssetList list = new AssetList();
    static {
        for(int i = 1; i < 30; i++) list.addTextureAtlas("puzzle/"+i+".atlas");
        for(int i = 1; i < 30; i++) list.addTexture("puzzle/"+i+".png");

        list.addTexture(WBG);
        list.addFont(FONTOCSKA, 80);
        AssetList.collectAssetDescriptor(PuzzleBoard.class, list);
    }


    OneSpriteStaticActor endBg;
    SimpleLabel endLabel;
    SimpleButton endBtn;

    public PuzzleStage(MyGame game) {
        super(new ResponseViewport(720), game);
        int id = MathUtils.random(1, 29);
        PuzzleBoard b = new PuzzleBoard(game,"puzzle/"+ id +".atlas" ) {
            @Override
            public void winPuzzle() {
                super.winPuzzle();

                endBg.setVisible(true);
                endLabel.setVisible(true);
                endBtn.setVisible(true);

            }
        };
        b.setPosition(getViewport().getWorldWidth() / 2 -  b.getWidth() / 2 - 10, 50);
        addActor(b);

        OneSpriteStaticActor kep = new OneSpriteStaticActor(game, "puzzle/"+id+".png");
        kep.setSize(500, 500);
        kep.setPosition(getViewport().getWorldWidth() / 2 -  kep.getWidth() / 2 - 10, getViewport().getWorldHeight() - kep.getHeight() - 50);
        addActor(kep);

        SimpleLabel label = new SimpleLabel(game, "Rakd ki:", FONTOCSKA);
        label.setAlignment(Align.center);
        label.setPosition(getViewport().getWorldWidth() / 2 - label.getWidth() / 2, getViewport().getWorldHeight() / 2 - label.getHeight() / 2);
        addActor(label);


        endBg = new OneSpriteStaticActor(game, WBG);
        endBg.setVisible(false);
        endBg.setSize(getViewport().getWorldWidth(), 500);
        endBg.setPosition(0, getViewport().getWorldHeight() / 2 - endBg.getHeight() / 2);
        addActor(endBg);

        endLabel = new SimpleLabel(game, "Sikeresen kiraktad\na puzzlet!");
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
