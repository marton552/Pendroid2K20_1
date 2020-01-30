package com.pindurpendurok.puszedli.Screens.Story;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class TutorialStage extends MyStage {

    String[] pictures;

    int ittVagyok = -1;

    public TutorialStage(MyGame game, String[] pictures) {
        super(new ResponseViewport(720), game);

        this.pictures = pictures;

        nextPicture();
    }

    public void tutorialEnded(TutorialStage stage) {

    }

    public void nextPicture() {
        ittVagyok++;

        if(ittVagyok > pictures.length - 1) {
            tutorialEnded(this);
            return;
        }


        addActor(new OneSpriteStaticActor(game, pictures[ittVagyok]) {
            @Override
            public void init() {
                super.init();
                setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());

                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        nextPicture();
                    }
                });
            }
        });
    }
}
