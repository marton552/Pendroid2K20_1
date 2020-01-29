package com.pindurpendurok.puszedli.Puzzle;

import com.badlogic.gdx.graphics.g2d.Sprite;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

public class PuzzleActor extends OneSpriteAnimatedActor {

    public PuzzleActor(MyGame game, String hash) {
        super(game, hash);
        stop();

        System.out.println(textureAtlas.getRegions().size+" ennyi van");

    }

    @Override
    public void setFrame(int frame) {
        super.setFrame(frame);
    }
/*
    public void setFrameSprite(int id) {
        System.out.println("SET ID: "+id);
        sprite = new Sprite(textureAtlas.getRegions().get(id).getTexture());
        sprite.setRegion(textureAtlas.getRegions().get(id));
        //sprite.setSize(100, 100);
        sprite.setSize(textureAtlas.getRegions().get(id).getRegionWidth(), textureAtlas.getRegions().get(id).getRegionHeight());
        //setFrame(id);

    }
*/
    @Override
    public void act(float delta) {
        super.act(delta);
        //System.out.println(getActualFrame());
    }
}
