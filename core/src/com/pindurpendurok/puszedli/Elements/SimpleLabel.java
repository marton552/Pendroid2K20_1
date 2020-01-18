package com.pindurpendurok.puszedli.Elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class SimpleLabel extends MyLabel {

    public final static String FONT = "alegreyaregular.otf";

    public static AssetList list = new AssetList();
    static {
        list.addFont(FONT, 60, Color.WHITE);
    }

    public SimpleLabel(MyGame game, CharSequence text) {
        super(game, text, getLabelStyle(game));
    }

    public SimpleLabel(MyGame game, CharSequence text, String fontHash) {
        super(game, text, getLabelStyleByFont(game, fontHash));
    }

    public static Label.LabelStyle getLabelStyle(MyGame game) {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = game.getMyAssetManager().getFont(FONT);
        style.fontColor = Color.WHITE;
        return style;
    }

    public static Label.LabelStyle getLabelStyleByFont(MyGame game, String fontHash) {
        Label.LabelStyle style;
        style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
        style.font = game.getMyAssetManager().getFont(fontHash);
        style.fontColor = Color.WHITE;
        return style;
    }

    @Override
    public void init() {

    }
}
