package com.pindurpendurok.puszedli.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.pindurpendurok.puszedli.Screens.Classes.Date;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;


public class GameStage extends SimpleWorldStage {

    public final static String BACKGROUND = "mainback.png";
    public final static String FONT = "MrGrieves-Regular.otf";

    public boolean timer_able_to_count = true;
    public int ticks = 0;
    public int count = 0;
    public int ora = 0;
    public int perc = 0;
    public String ora2 ="";
    public String perc2 ="";
    MyLabel naptar;
    Date datum = new Date(this);
    public Preferences save;


    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);
    }


    public GameStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
        setCameraResetToLeftBottomOfScreen();
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;
        save = Gdx.app.getPreferences("gameSave");
        save.clear();

        if(save.contains("inditas")){
            save.putFloat("inditas",(save.getFloat("inditas")+1));
        }else{
            save.putInteger("ev",2001);
            save.putInteger("honap",7);
            save.putInteger("nap",22); //23.-án született csak egyből léptet
        }
        save.flush();
        datum.leptetes();


        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        naptar = new MyLabel(game, "Ez itt a datum", ls) {
            @Override
            public void init() {

            }
        };
        naptar.setPosition(0,getHeight()-naptar.getHeight());
        naptar.setFontScale(1.5f);
        addActor(naptar);


        addTimer(new TickTimer(0, true, new TickTimerListener() {

            @Override
            public void onTick(Timer sender, float correction) {
                if(timer_able_to_count){
                    ticks++;
                    perc+=10;
                    if(perc == 60){perc = 0; ora++;}
                    if(ora ==25)ora=0;
                    if(perc == 0)perc2="00";
                    else perc2=perc+"";
                    if(ora == 0)ora2="00";
                    else if(ora < 10)ora2="0"+ora;
                    else ora2=ora+"";
                    naptar.setText(datum.ev+"."+datum.getMonth(datum.honap)+"."+datum.nap+"  "+ora2+":"+perc2);
                if(ticks%150==0){count++;
                    datum.leptetes();
                }
            }}
        }));
    }
}
