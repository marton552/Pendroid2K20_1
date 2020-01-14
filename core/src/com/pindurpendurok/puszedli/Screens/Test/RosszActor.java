package com.pindurpendurok.puszedli.Screens.Test;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;

public class RosszActor extends OneSpriteStaticActor {
    public static final String BADLOGIC = "badlogic.jpg";
    public static AssetList list = new AssetList();

    static {
        list.addTexture(BADLOGIC);
    }
    public RosszActor(MyGame game, SimpleWorld world) {
        super(game, BADLOGIC);
        setColor(1, 0, 0, 1);

        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Rectangle, SimpleBodyType.Sensor);
        setActorWorldHelper(sw);

        sw.body.removeBaseCollisionRectangleShape();
        sw.body.addCollisionRectangleShape("valami", 50, 50, 40, 40, 0);
        sw.body.addCollisionRectangleShape("semmi", 0, 0, 40, 40, 0);



    }


}
