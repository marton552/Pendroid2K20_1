package com.pindurpendurok.puszedli.Screens.Wow;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;

public class Goblin extends OneSpriteStaticActor {

    static final String[] mobok = new String[]{"goblins/goblin1.png","goblins/goblin2.png","goblins/goblin3.png","goblins/goblin4.png"};

    public static AssetList list = new AssetList();
    static {
        for (int i = 0; i < mobok.length ; i++) {
            list.addTexture(mobok[i]);
        }
    }

    float finalW = 0;
    float finalH = 0;
    float zoomSpeed = 20;
    float angry = 1f;

    WowStage stage;

    public Goblin(MyGame game, int type, WowStage stage) {
        super(game, mobok[type]);

        this.stage = stage;

        finalW = getWidth() / (2 * (type+1));
        finalH = getHeight() / (2 * (type+1));

        setSize(0, 0);

        setOrigin(getX() + getWidth() / 2, getY() +getHeight() / 2);
        setRotation(-20f);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                goblinDeath();
            }
        });

        //Hangokat nem tudom hogy akarjuk úgyhogy kivettem de utt a régi.
        /*
        int randSound = MathUtils.random(0, 2);
        if(randSound == 0) Assets.manager.get(Assets.GOBLIN_SOUND1).play(1);
        else if(randSound == 1) Assets.manager.get(Assets.GOBLIN_SOUND2).play(1);
        else Assets.manager.get(Assets.GOBLIN_SOUND3).play(1);
         */
    }

    public void goblinDeath() {
        ((WowStage)getStage()).onGoblinKill(this);
        counter = 0;
    }

    public static int getRandomGoblinType() {
        return MathUtils.random(0, mobok.length-1);
    }

    @Override
    protected void positionChanged() {
        super.positionChanged();
        setOrigin(getWidth() / 2, getHeight() / 2);

    }

    int counter = 0;

    @Override
    public void act(float delta) {
        super.act(delta);

        counter++;

        if(finalW > getWidth())
            setWidth(getWidth() + (finalW / zoomSpeed));


        if(finalH > getHeight())
            setHeight(getHeight() + (finalH / zoomSpeed));


        setOrigin(getWidth() / 2, getHeight() / 2);
        setRotation(getRotation() + ((float)Math.sin(counter / 4f) * angry));


        if(counter % stage.difficulty == 0) {

            if(angry >= 5f)  {
                //if(counter % 100 == 0) {
                    stage.hitPlayer();
                    counter = 0;
                //}
            }else angry++;
        }

    }
}
