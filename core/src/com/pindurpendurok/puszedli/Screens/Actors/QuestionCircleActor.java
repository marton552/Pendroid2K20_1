package com.pindurpendurok.puszedli.Screens.Actors;

import com.badlogic.gdx.scenes.scene2d.Stage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class QuestionCircleActor extends OneSpriteStaticActor {

    public static final String CIRCLE = "questioncircle.png";
    public static AssetList list = new AssetList();
    static {
        list.addTexture(CIRCLE);
    }
    SimpleWorldHelper kor1;
    SimpleWorldHelper kor2;

    public QuestionCircleActor(MyGame game, SimpleWorld world){
        super(game, CIRCLE);

        //kor1 = new SimpleWorldHelper(world, this, ShapeType.Circle, SimpleBodyType.Sensor);
        //setActorWorldHelper(kor1);

/////////!!!!!!!!!!!!!! Csak akkor leht a stage értékét lekérdezni, ha már hozzá lett adva, ezért ennek a  protected void setStage(Stage stage)-ben van a helye.

        //float x = getStage().getViewport().getWorldWidth() / 2;
        //System.out.println(x);

        //setPosition(100, 100);
    }

    @Override
    protected void setStage(Stage stage) {
        super.setStage(stage);
        if (stage!=null){
            float x = getStage().getViewport().getWorldWidth() / 2;
            System.out.println(x);
        }
    }
}
