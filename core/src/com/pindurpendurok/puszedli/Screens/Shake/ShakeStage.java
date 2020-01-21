package com.pindurpendurok.puszedli.Screens.Shake;

import com.badlogic.gdx.Gdx;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyStage;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;

public class ShakeStage extends MyStage {
    public static final String DAVEY = "elemek/dave/NudiDavey.png";

    public static AssetList assetList = new AssetList();

    static {
        assetList.addTexture(DAVEY);
    }

    private final float GRAVITY_EARTH = 9.807f;

    public ShakeStage(MyGame game) {
        super(new ResponseViewport(720), game);

        float xGrav = Gdx.input.getAccelerometerX() / GRAVITY_EARTH;
        float yGrav = Gdx.input.getAccelerometerY() / GRAVITY_EARTH;
        float zGrav = Gdx.input.getAccelerometerZ() / GRAVITY_EARTH;

        // gForce will be close to 1 when there is no movement.
        float gForce = (float)Math.sqrt((xGrav * xGrav) + (yGrav * yGrav) + (zGrav * zGrav));





    }
}
