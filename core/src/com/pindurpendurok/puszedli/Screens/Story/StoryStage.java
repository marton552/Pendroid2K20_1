package com.pindurpendurok.puszedli.Screens.Story;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class StoryStage extends MyStage {


    static {
    }
    String[] imageHashes;
    String[] musicHashes;

    int ittTart = -1;

    Music music;

    public StoryStage(MyGame game, String[] imageHashes, String[] musicHashes) {
        super(new ResponseViewport(720), game);

        setCameraResetToLeftBottomOfScreen();

        this.imageHashes = imageHashes;
        this.musicHashes = musicHashes;

        nextStory();

    }

    public void storyEnded(StoryStage sender) {

    }

    public void nextStory() {
        ittTart++;
        System.out.printf("NEXT STORY LINE");

        if(ittTart > imageHashes.length-1) {
            storyEnded(this);
            GameStage.tutorial = true;
            return;
        }

        addActor(new OneSpriteStaticActor(game, imageHashes[ittTart]) {
            @Override
            public void init() {
                super.init();
                setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
            }
        });

        music = game.getMyAssetManager().getMusic(musicHashes[ittTart]);
        music.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                nextStory();
            }
        });

        music.setLooping(false);
        music.setVolume(1);
        music.play();
    }

}
