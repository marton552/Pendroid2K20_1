package com.pindurpendurok.puszedli.Elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;

public class SimpleButton extends MyButton {
    public final static String FONT = "alegreyaregular.otf";

    public final static String BTN_BACK = "ui_textures/btn_back.png";
    public final static String BTN_HOVER = "ui_textures/btn_hover.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONT, 60, Color.WHITE);
        assetList.addTexture(BTN_BACK);
        assetList.addTexture(BTN_HOVER);
    }


    public SimpleButton(MyGame game, String text) {
        super(game, text, getButtonStyle(game));

    }

    public static TextButton.TextButtonStyle getButtonStyle(MyGame game){
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

    @Override
    public void init() {

    }
}
