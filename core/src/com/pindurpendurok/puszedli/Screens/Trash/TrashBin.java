package com.pindurpendurok.puszedli.Screens.Trash;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyContactListener;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleContact;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;

public class TrashBin extends OneSpriteStaticActor {
    public TrashBin(MyGame game, String hash, SimpleWorld world) {
        super(game, hash);

        SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        setActorWorldHelper(sw);


        sw.addContactListener(new SimpleBodyContactListener(){
            @Override
            public void beginContact(SimpleContact contact, SimpleWorldHelper myHelper, SimpleWorldHelper otherHelper) {
                super.beginContact(contact, myHelper, otherHelper);

                if(otherHelper.actor instanceof TrashActor) {
                    if(((TrashActor)otherHelper.actor).goodTrash)
                        ((TrashStage)getStage()).goodTrashCollected();
                    else
                        ((TrashStage)getStage()).trashCollectError();

                    otherHelper.remove();
                }
            }
        });
   }
}
