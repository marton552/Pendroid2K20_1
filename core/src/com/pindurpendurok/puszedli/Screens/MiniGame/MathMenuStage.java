package com.pindurpendurok.puszedli.Screens.MiniGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.QuestionCircleActor;
import com.pindurpendurok.puszedli.Screens.Actors.SzurkecuccBarhovaActor;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;

public class MathMenuStage extends SimpleWorldStage {

    public static AssetList assetList = new AssetList();
    public final static String BACKGROUND = "math_back.png";
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
        assetList.addTexture(BACKGROUND);
    }

    List<SimpleButton> gombok = new ArrayList<>();
    String[] sz = new String[]{"Gyokvonas","Melyik a nagyobb?","Osszeadas","Kivonas","Szorzas","Osztas","Negyzetre emeles"};

    public MathMenuStage(MyGame game, int status) {     //0 = paused 1 = elvesztett 2 = menu
        super(new ResponseViewport(720), game);

        float width = getViewport().getWorldWidth()/1.5f;
        float height = getViewport().getWorldHeight()/7;
        float x = getViewport().getWorldWidth()/2-width/2;
        float y = getViewport().getWorldHeight();

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        for(int i = 0; i < sz.length;i++) {
            final int s = i;
            SimpleButton osszeadas = new SimpleButton(game, sz[i]);
            osszeadas.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    ((MathGameScreen) getScreen()).changeStage(0,s);
                }
            });
            osszeadas.setPosition(x, y - (height*i));
            osszeadas.setWidth(width);
            addActor(osszeadas);
            gombok.add(osszeadas);
        }

        SimpleButton vissza = new SimpleButton(game, "Vissza");
        vissza.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MathGameScreen) getScreen()).changeStage(0,0);
            }
        });
        vissza.setPosition(x, y - (height*5));
        vissza.setWidth(width);
        addActor(vissza);

        if(status == 0){
            for (int i = 0; i < 7;i++){
                    gombok.get(i).setVisible(false);
            }
        }
    }
}
