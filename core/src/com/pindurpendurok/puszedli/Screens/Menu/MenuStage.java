package com.pindurpendurok.puszedli.Screens.Menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.Direction;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class MenuStage extends SimpleWorldStage {

    public final static String FONT = "alegreyaregular.otf";
    public final static String BADLOGIC = "badlogic.jpg";

    public final static String BTN_BACK = "ui_textures/btn_back.png";
    public final static String BTN_HOVER = "ui_textures/btn_hover.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BADLOGIC);
        assetList.addTexture(BTN_BACK).protect = true;
        assetList.addTexture(BTN_HOVER).protect = true;
    }

    public MenuStage(final MyGame game) {
        super(new ResponseViewport(720f), game);

        MyLabel l = new MyLabel(game, "Ez egy teszt", getLabelStyle()) {
            @Override
            public void init() {

            }
        };
        l.setPosition(getViewport().getWorldWidth() / 2 - l.getWidth() / 2, getViewport().getWorldHeight() / 2 - l.getHeight());
        addActor(l);



        MyButton btn = new MyButton(game, "Gomb", getButtonStyle()) {
            @Override
            public void init() {

            }
        };


        OneSpriteStaticActor actor = new OneSpriteStaticActor(game, BADLOGIC) {
            @Override
            public void init() {
                super.init();
                setX(getViewport().getWorldWidth() /2 - getWidth() / 2);
                setY(getHeight() + 10);

                SimpleWorldHelper sw = new SimpleWorldHelper(world, this, ShapeType.Rectangle, SimpleBodyType.Sensor);
                setActorWorldHelper(sw);

                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);

                        ((SimpleWorldHelper)getActorWorldHelper()).body.rotateToFixTime(getRotation() - 90, 2, Direction.ClockWise);
                    }
                });

            }
        };

        addActor(actor);

        btn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                game.setScreen(new GameScreen(game), true);
            }
        });

        addActor(btn);

    }


    //Ezeket, majd át kell vinni a MyButton-t és a MyLabel-t örököltetett osztályokba.
    public TextButton.TextButtonStyle getButtonStyle(){
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = game.getMyAssetManager().getFont(FONT);
        buttonStyle.fontColor = new Color(1, 1, 1, 1);
        buttonStyle.overFontColor = new Color(0, 0, 0, 1);
        buttonStyle.downFontColor = new Color(0, 0, 0, 1);

        buttonStyle.up = new TextureRegionDrawable(new TextureRegion(game.getMyAssetManager().getTexture(BTN_BACK)));
        buttonStyle.down = new TextureRegionDrawable(new TextureRegion(game.getMyAssetManager().getTexture(BTN_HOVER)));
        buttonStyle.over = new TextureRegionDrawable(new TextureRegion(game.getMyAssetManager().getTexture(BTN_HOVER)));

        return buttonStyle;
    }

    public Label.LabelStyle getLabelStyle() {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = game.getMyAssetManager().getFont(FONT);
        style.fontColor = Color.WHITE;
        return style;
    }

}
