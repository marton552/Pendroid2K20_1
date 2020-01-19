package com.pindurpendurok.puszedli.Screens.MiniGame;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.QuestionCircleActor;
import com.pindurpendurok.puszedli.Screens.Actors.SzurkecuccBarhovaActor;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MathMenuStage extends SimpleWorldStage {

    public static AssetList assetList = new AssetList();
    public final static String BACKGROUND = "math_back.png";
    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
        assetList.addTexture(BACKGROUND);
    }

    List<SimpleButton> gombok = new ArrayList<>();
    String[] sz = new String[]{"","Melyik a nagyobb?","Osszeadas","Kivonas","Szorzas","Osztas","Negyzetre emeles"};

    public MathMenuStage(final MyGame game, final int status) {     //0 = paused 1 = elvesztett 2 = menu //3+a játékmódók (x-3)
        super(new ResponseViewport(720), game);

        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(GameStage.FONT);
        ls.fontColor = Color.WHITE;

        float width = getViewport().getWorldWidth()/1.5f;
        float height = getViewport().getWorldHeight()/7;
        float x = getViewport().getWorldWidth()/2-width/2;
        float y = getViewport().getWorldHeight();

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        for(int i = 0; i < sz.length;i++) {
            final int s = i+3;
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

        final SimpleButton vissza = new SimpleButton(game, "Vissza a jatekba");
        vissza.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                ((MathGameScreen) getScreen()).changeStage(0,status);
            }
        });
        vissza.setPosition(x, y - (height*3));
        vissza.setWidth(width);
        addActor(vissza);

        final SimpleButton menu = new SimpleButton(game, "Vissza a Bendzsihez");
        menu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new GameScreen(game));
            }
        });
        menu.setPosition(x, y - (height*5));
        menu.setWidth(width);
        addActor(menu);

        final SimpleButton masik = new SimpleButton(game, "Masik jatekmód");
        masik.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                vissza.setVisible(false);
                menu.setVisible(false);
                masik.setVisible(false);
                for (int i = 0; i < sz.length;i++){
                    gombok.get(i).setVisible(true);
                }
            }
        });
        masik.setPosition(x, y - (height*4));
        masik.setWidth(width);
        addActor(masik);


        if(status == 0){
            vissza.setVisible(false);
            menu.setVisible(false);
            masik.setVisible(false);
        }
        else if(status == 1){
            for (int i = 0; i < sz.length;i++){
                gombok.get(i).setVisible(false);
            }
        }
        else{
            for (int i = 0; i < sz.length;i++){
                gombok.get(i).setVisible(false);
            }
        }
    }
}
