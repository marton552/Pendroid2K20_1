package com.pindurpendurok.puszedli.Screens.Story;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

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

    OneSpriteStaticActor bg;
    Music music;

    public StoryStage(MyGame game, String[] imageHashes, String[] musicHashes) {
        super(new ResponseViewport(720), game);

        setCameraResetToLeftBottomOfScreen();

        this.imageHashes = imageHashes;
        this.musicHashes = musicHashes;

        nextStory();

    }

    public void storyEnded() {

    }

    public void nextStory() {
        ittTart++;

        if(ittTart > imageHashes.length) {
            storyEnded();
            return;
        }

        bg.remove();
        bg = null;

        bg = new OneSpriteStaticActor(game, imageHashes[ittTart]);
        bg.setSize(getViewport().getWorldWidth(), getViewport().getWorldHeight());
        addActor(bg);

        music = game.getMyAssetManager().getMusic(musicHashes[ittTart]);
        music.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                nextStory();
            }
        });

        music.play();
        music.setLooping(false);
        music.setVolume(1);
    }

}
