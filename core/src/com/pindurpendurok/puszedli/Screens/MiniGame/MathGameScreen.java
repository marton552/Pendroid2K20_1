package com.pindurpendurok.puszedli.Screens.MiniGame;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;

public class MathGameScreen extends MyScreen {
    public MathGameScreen(MyGame game) {
        super(game);
    }

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(MathGameStage.class, assetList);
        AssetList.collectAssetDescriptor(MathMenuStage.class, assetList);

    }

    MathGameStage stage;
    MathMenuStage menuStage;
    int holvan = 2;

    @Override
    protected void afterAssetsLoaded() {
        stage = new MathGameStage(game);
        menuStage = new MathMenuStage(game,holvan); //0 = paused 1 = elvesztett 2 = menu
        
        addStage(menuStage, 1, true);
    }

    int showing = 1;

    public void changeStage(int s,int i) {
        if(showing == s) return;

        if(showing == 0) {
            removeStage(stage);
            stage.dispose();
            stage = null;
        }
        if(showing == 1) {
            removeStage(menuStage);
            menuStage.dispose();
            menuStage = null;
        }

        holvan = i;
        if(s == 0) {
            stage = new MathGameStage(game);
            addStage(stage, 1, true);
        }
        else{
            menuStage = new MathMenuStage(game, holvan);
            addStage(menuStage, 1, true);
        }


        showing = s;

    }

    @Override
    public AssetList getAssetList() {
        return assetList;
    }

    @Override
    public void init() {

    }
}
