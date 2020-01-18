package com.pindurpendurok.puszedli.Screens.MiniGame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.pindurpendurok.puszedli.Elements.ElementAssets;
import com.pindurpendurok.puszedli.Elements.SimpleButton;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyButton;

public class MathMenuStage extends SimpleWorldStage {

    public static AssetList list = new AssetList();
    static {
        AssetList.collectAssetDescriptor(ElementAssets.class, list);
    }

    public MathMenuStage(MyGame game) {
        super(new ResponseViewport(720), game);

        SimpleButton btn = new SimpleButton(game, "ÁT A GAME STAGRE");
        btn.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);

                ((MathGameScreen)getScreen()).changeStage(0);
            }
        });
        addActor(btn);

    }
}
