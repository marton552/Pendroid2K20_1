package com.pindurpendurok.puszedli.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Puzzle.PuzzleStage;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.StatusBarActor;
import com.pindurpendurok.puszedli.Screens.Actors.changeMenuActor;
import com.pindurpendurok.puszedli.Screens.Bell.BellScreen;
import com.pindurpendurok.puszedli.Screens.Bell.BellStage;
import com.pindurpendurok.puszedli.Screens.Classes.Border;
import com.pindurpendurok.puszedli.Screens.Classes.Borderhuzogato;
import com.pindurpendurok.puszedli.Screens.Classes.Date;
import com.pindurpendurok.puszedli.Screens.Classes.GratulaloKep;
import com.pindurpendurok.puszedli.Screens.Favago.FavagoScreen;
import com.pindurpendurok.puszedli.Screens.Favago.FavagoStage;
import com.pindurpendurok.puszedli.Screens.Foci.FociScreen;
import com.pindurpendurok.puszedli.Screens.Foci.FociStage;
import com.pindurpendurok.puszedli.Screens.Guess.GuessStage;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapWorldScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapWorldStage;
import com.pindurpendurok.puszedli.Screens.JobsGame.PszichiaterScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PszichiaterStage;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameScreen;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameStage;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathMenuStage;
import com.pindurpendurok.puszedli.Screens.Porno.PornoStage;
import com.pindurpendurok.puszedli.Screens.Rocking.RockingScreen;
import com.pindurpendurok.puszedli.Screens.Rocking.RockingStage;
import com.pindurpendurok.puszedli.Screens.Shake.ShakeScreen;
import com.pindurpendurok.puszedli.Screens.Shake.ShakeStage;
import com.pindurpendurok.puszedli.Screens.Story.StoryStage;
import com.pindurpendurok.puszedli.Screens.Story.TutorialStage;
import com.pindurpendurok.puszedli.Screens.Trash.TrashScreen;
import com.pindurpendurok.puszedli.Screens.Trash.TrashStage;
import com.pindurpendurok.puszedli.Screens.Wow.WowStage;

import java.util.ArrayList;
import java.util.List;

import hu.csanyzeg.master.Demos.SimpleClock.PointerActor;
import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.MyScreen;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;


public class GameStage extends SimpleWorldStage {

    public final static String FONT = "Bosk.otf";
    public static final String[][] HATTEREK = new String[][]{{"elemek/szoba/szoba1.png","elemek/szoba/szoba2.png","elemek/szoba/szoba3.png","elemek/szoba/szoba4.png","elemek/szoba/szoba5.png"},
            {"elemek/szoba/szoba1_konyha.png","elemek/szoba/szoba2_konyha.png","elemek/szoba/szoba3_konyha.png","elemek/szoba/szoba4_konyha.png","elemek/szoba/szoba5_konyha.png"},
            {"elemek/szoba/szoba1_munka.png","elemek/szoba/szoba2_munka.png","elemek/szoba/szoba3_munka.png","elemek/szoba/szoba4_munka.png","elemek/szoba/szoba5_munka.png"},
            {"elemek/szoba/szoba1_ures.png","elemek/szoba/szoba2_ures.png","elemek/szoba/szoba3_ures.png","elemek/szoba/szoba4_ures.png","elemek/szoba/szoba5_ures.png"},
    };


    public static final String[] BENDZSIK = new String[]{"elemek/dave/Davey.png","elemek/dave/DaveyAlaMexican.png","elemek/dave/DaveyIgen.png","elemek/dave/DaveyVaják.png","elemek/dave/gangsterDavey.png",
            "elemek/dave/jasonDavey.png","elemek/dave/kawaiiDavey.png","elemek/dave/MarioDavey.png","elemek/dave/matrixDavey.png","elemek/dave/NudiDavey.png","elemek/dave/papDavey.png",
            "elemek/dave/rendőrDavey.png","elemek/dave/tündérDavey.png","elemek/dave/zacseszDavey.png","elemek/dave/ZoldDavey.png"};
    public final static String ETELEK = "elemek/etelek.png";
    public final static String ITALOK = "elemek/italok.png";
    public final static String SZOBAK = "elemek/szobak.png";
    public final static String RUHAK = "elemek/ruhak.png";
    public final static String JATEKOK = "elemek/games.png";
    public final static String MUNKAK = "elemek/storyk.png";
    public final static String TUT = "elemek/tutorial.png";
    public final static String NEXT = "elemek/esemeny.png";
    public final static String SAND = "ui_textures/sand.png";
    public final static String VISSZA = "back.png";
    public final static String NYIL = "elemek/pori/arrow.png";
    public final static String COIN = "penz.png";
    public final static String NAPHOLD = "elemek/nap_hol_basszameg.png";
    public final static String OZ = "elemek/hattervazze.png";
    public final static String[] KEPEK = new String[]{"elemek/eletut/eletut1.png","elemek/eletut/eletut2.png","elemek/eletut/eletut3.png","elemek/eletut/eletut4.png","elemek/eletut/eletut5.png","elemek/eletut/eletut6.png",
            "elemek/eletut/eletut9.png","elemek/eletut/eletut10.png","elemek/eletut/eletut11.png","elemek/eletut/eletut12.png","elemek/eletut/eletut13.png","elemek/eletut/eletut14.png"};
    public final static String[] HANGOK = new String[]{"hangok/fostory/2000_1.ogg","hangok/fostory/2000_2.ogg","hangok/fostory/2000_3.ogg",
            "hangok/fostory/2005_1.ogg","hangok/fostory/2005_2.ogg","hangok/fostory/2005_3.ogg",
            "hangok/fostory/2012_1.ogg","hangok/fostory/2012_2.ogg","hangok/fostory/2012_3.ogg",
            "hangok/fostory/2016_1.ogg","hangok/fostory/2016_2.ogg","hangok/fostory/2016_3.ogg",
            "hangok/fostory/2020_1.ogg","hangok/fostory/2020_2.ogg","hangok/fostory/seged.ogg",};

    public final static String[] TUTORIALS = new String[]{"tutorial/Screenshot_1.png","tutorial/Screenshot_20.png","tutorial/Screenshot_2.png","tutorial/Screenshot_3.png","tutorial/Screenshot_4.png",
            "tutorial/Screenshot_5.png","tutorial/Screenshot_6.png","tutorial/Screenshot_7.png","tutorial/Screenshot_8.png","tutorial/Screenshot_9.png","tutorial/Screenshot_15.png",
            "tutorial/Screenshot_10.png","tutorial/Screenshot_11.png","tutorial/Screenshot_12.png","tutorial/Screenshot_13.png","tutorial/Screenshot_14.png"};


    public static boolean timer_able_to_count = true;
    public int ticks = 0;
    public int count = 0;
    public int ora = 0;
    public int perc = 0;
    public String ora2 ="";
    public String perc2 ="";
    MyLabel naptar;
    MyLabel penz0;
    public Date datum = new Date(this);
    public static Preferences save;
    changeMenuActor detect;
    int melyik_hatter = 0;
    OneSpriteStaticActor sand;
    OneSpriteStaticActor vissza;
    Borderhuzogato inline;
    boolean detectOn = true;
    GratulaloKep asd = new GratulaloKep();
    public static StatusBarActor bar;
    public static StatusBarActor bar2;
    public static StatusBarActor bar3;
    public static StatusBarActor bar4;
    OneSpriteStaticActor Dave;
    OneSpriteStaticActor BackGround;
    OneSpriteStaticActor BackGround_konyha;
    OneSpriteStaticActor BackGround_munka;
    OneSpriteStaticActor BackGround_radio;
    OneSpriteStaticActor BackGround_radio2;
    OneSpriteStaticActor hatter;
    OneSpriteStaticActor naphold;
    OneSpriteStaticActor next;
    OneSpriteStaticActor tut;
    int szobaseged = 0;
    public static int szobaSelected = 0;
    int daveseged = 0;
    public static int daveSelected = 0;
    public static boolean kattinthatsz = true;
    boolean canchangescreen = true;
    float fok = 0;
    public int melyikev = 0;
    public static boolean tutorial = false;
    public static boolean gomb = false;

    public static List<Border> gombok = new ArrayList<>();


    public static AssetList assetList = new AssetList();
    static {
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(ETELEK);
        assetList.addTexture(ITALOK);
        assetList.addTexture(RUHAK);
        assetList.addTexture(SZOBAK);
        assetList.addTexture(VISSZA);
        assetList.addTexture(JATEKOK);
        assetList.addTexture(MUNKAK);
        assetList.addTexture(COIN);
        assetList.addTexture(OZ);
        assetList.addTexture(NAPHOLD);
        assetList.addTexture(NEXT);
        assetList.addTexture(TUT);
        assetList.addTexture(NYIL);

        for (int i = 0; i < HATTEREK.length; i++) {
            for (int k = 0; k < HATTEREK[i].length; k++) {
                assetList.addTexture(HATTEREK[i][k]).protect = true;
            }
        }
        for (int i = 0; i < BENDZSIK.length; i++) {
            assetList.addTexture(BENDZSIK[i]).protect = true;
        }
        for (int k = 0; k < KEPEK.length; k++) {
            assetList.addTexture(KEPEK[k]).protect = true;
        }
        for (int k = 0; k < HANGOK.length; k++) {
            assetList.addMusic(HANGOK[k]).protect = true;
        }
        for (int k = 0; k < TUTORIALS.length; k++) {
            assetList.addTexture(TUTORIALS[k]).protect = true;
        }
    }


    public GameStage(final MyGame game) {
        super(new ResponseViewport(1080f), game);
        setCameraResetToCenterOfScreen();
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;
        save = Gdx.app.getPreferences("gameSave");
        save.clear();

        if(save.contains("inditas")){
            save.putFloat("inditas",(save.getFloat("inditas")+1));
        }else{
            save.putFloat("inditas",1);
            save.putInteger("ev",2001);
            save.putInteger("honap",07);
            save.putInteger("nap",23); //23.-án született csak egyből léptet

            //Pap minigame
            save.putInteger("hatter",0);
            save.putInteger("dave",0);
            save.putInteger("penz",200);
            save.putString("munkak","00000");
            save.putString("jatekok","110000000");
            save.putString("szobak","20000");
            save.putString("daveskin","200000000000000");

            save.putInteger("ehseg",100);
            save.putInteger("szomjusag",100);
            save.putInteger("stressz",30);
            save.putInteger("veralkohol",30);

            save.putInteger("story",0);
            save.putInteger("tutorial",0);
            save.putInteger("seged",1);
            save.putInteger("tutorial2",10);
        }
        save.flush();
        datum.leptetes();

        melyikev = save.getInteger("tutorial");

        detect = new changeMenuActor(game,this);
        detect.setVisible(false);

        if(FavagoStage.atad){asd.letrehoz(game,this,"Sikeres favágás!",FavagoStage.gotmoney,0,0,-5,0,0);
        FavagoStage.atad = false; save.putInteger("penz",save.getInteger("penz")+FavagoStage.gotmoney);
            save.putInteger("stressz",save.getInteger("stressz")-5);
            FavagoStage.gotmoney = 0;
            bar3.changeValue(-5);
            save.putInteger("stressz",save.getInteger("stressz")-5);
            save.flush();
        }

        if(FociStage.van){asd.letrehoz(game,this,"Jó meccs volt!",FociStage.penzm,0,0,-5,0,0);
        FociStage.van = false; save.putInteger("penz",save.getInteger("penz")+FociStage.penzm);
            save.putInteger("stressz",save.getInteger("stressz")-5);
            FociStage.penzm = 0;
            bar3.changeValue(-5);
            save.putInteger("stressz",save.getInteger("stressz")-5);
            save.flush();
        }

        if(PapWorldStage.vanpenz){asd.letrehoz(game,this,"Szentatyám fizetése:",PapWorldStage.penzm,0,0,0,0,0);
            PapWorldStage.vanpenz = false; save.putInteger("penz",save.getInteger("penz")+PapWorldStage.penzm);
            PapWorldStage.penzm = 0;
            save.flush();
        }

        if(BellStage.volt){asd.letrehoz(game,this,"Csörgetés:",BellStage.penz,0,0,BellStage.stressz,0,0);
            BellStage.volt = false; save.putInteger("penz",save.getInteger("penz")+BellStage.penz);
            BellStage.penz = 0;
            bar3.changeValue(BellStage.stressz);
            save.putInteger("stressz",save.getInteger("stressz")+BellStage.stressz);
            BellStage.stressz = 0;
            save.flush();
        }

        if(RockingStage.volt){asd.letrehoz(game,this,"Bendzsike aluszikál!",100,0,0,-10,0,0);
            RockingStage.volt = false; save.putInteger("penz",save.getInteger("penz")+100);
            bar3.changeValue(-10);
            save.putInteger("stressz",save.getInteger("stressz")-10);
            save.flush();
        }

        if(ShakeStage.volt){asd.letrehoz(game,this,"Ohh ez jó volt!",50,0,0,-8,0,0);
            ShakeStage.volt = false; save.putInteger("penz",save.getInteger("penz")+50);
            bar3.changeValue(-18);
            save.putInteger("stressz",save.getInteger("stressz")-8);
            save.flush();
        }

        if(MathGameStage.volt){asd.letrehoz(game,this,"Durva feladvány volt!",MathGameStage.penzm,0,0,0,0,0);
            MathGameStage.volt = false; save.putInteger("penz",save.getInteger("penz")+MathGameStage.penzm);
            MathGameStage.penzm = 0;
            save.flush();
        }

        if(PszichiaterStage.van){asd.letrehoz(game,this,"Dr.Bendzsi OMG!",PszichiaterStage.penz,0,0,0,0,0);
            PszichiaterStage.van = false; save.putInteger("penz",save.getInteger("penz")+PszichiaterStage.penz);
            PszichiaterStage.penz = 0;
            save.flush();
        }

        if(TrashStage.van){asd.letrehoz(game,this,"Kukamuki!",TrashStage.penz,0,0,0,0,0);
            TrashStage.van = false; save.putInteger("penz",save.getInteger("penz")+TrashStage.penz);
            TrashStage.penz = 0;
            save.flush();
        }

        if(PornoStage.van){asd.letrehoz(game,this,"Jó film volt!",80,0,0,0,0,0);
            PornoStage.van = false; save.putInteger("penz",save.getInteger("penz")+80);
            save.flush();
        }

        if(PuzzleStage.van){asd.letrehoz(game,this,"Jó film volt!",100,0,0,0,0,0);
            PuzzleStage.van = false; save.putInteger("penz",save.getInteger("penz")+100);
            save.flush();
        }
        if(GuessStage.van){asd.letrehoz(game,this,"Jó film volt!",60,0,0,0,0,0);
            GuessStage.van = false; save.putInteger("penz",save.getInteger("penz")+60);
            save.flush();
        }
        if(WowStage.van){asd.letrehoz(game,this,"Jó játék volt!",50,0,0,0,0,0);
            WowStage.van = false; save.putInteger("penz",save.getInteger("penz")+50);
            save.flush();
        }

        hatter = new OneSpriteStaticActor(game, OZ);
        hatter.setSize(getWidth()/1.6f,getWidth()/1.6f);
        hatter.setPosition(getWidth()/2-hatter.getWidth()/2,getHeight()/2-hatter.getHeight()/2.5f);
        addActor(hatter,-10);

        naphold = new OneSpriteStaticActor(game, NAPHOLD);
        naphold.setSize(getWidth()*2,getWidth()*2);
        naphold.setPosition(getWidth()/2-naphold.getWidth()/2,getHeight()/2-naphold.getHeight()/2.3f);
        naphold.setOrigintoCenter();
        addActor(naphold,-20);
        naphold.setRotation(180);

        BackGround = new OneSpriteStaticActor(game, HATTEREK[0][save.getInteger("hatter")]);
        BackGround.setSize(getWidth(),getHeight());
        BackGround.setX(0);
        addActor(BackGround);

        BackGround_konyha = new OneSpriteStaticActor(game, HATTEREK[1][save.getInteger("hatter")]);
        BackGround_konyha.setSize(getWidth(),getHeight());
        BackGround_konyha.setX(getWidth());
        addActor(BackGround_konyha);

        BackGround_munka = new OneSpriteStaticActor(game, HATTEREK[2][save.getInteger("hatter")]);
        BackGround_munka.setSize(getWidth(),getHeight());
        BackGround_munka.setX(0-getWidth());
        addActor(BackGround_munka);

        BackGround_radio = new OneSpriteStaticActor(game, HATTEREK[3][save.getInteger("hatter")]);
        BackGround_radio.setSize(getWidth(),getHeight());
        BackGround_radio.setX(getWidth()*2);
        addActor(BackGround_radio);

        BackGround_radio2 = new OneSpriteStaticActor(game, HATTEREK[3][save.getInteger("hatter")]);
        BackGround_radio2.setSize(getWidth(),getHeight());
        BackGround_radio2.setX(0-getWidth()*2);
        addActor(BackGround_radio2);

        OneSpriteStaticActor nyil = new OneSpriteStaticActor(game, NYIL);
        nyil.setSize(getWidth()/6,getWidth()/6);
        nyil.setPosition(getWidth() -nyil.getWidth()*1.2f,getHeight()/2);
        addActor(nyil,1000);

        OneSpriteStaticActor nyil2 = new OneSpriteStaticActor(game, NYIL);
        nyil2.setSize(getWidth()/6,getWidth()/6);
        nyil2.setPosition(nyil2.getWidth()*0.2f,getHeight()/2);
        addActor(nyil2,1000);
        nyil2.setRotation(180);

        Dave = new OneSpriteStaticActor(game, BENDZSIK[save.getInteger("dave")]);
        Dave.setSize(getWidth()/1.5f,getHeight()/1.5f);
        Dave.setPosition(getWidth()/2-Dave.getWidth()/2,getHeight()/40);
        addActor(Dave);

        OneSpriteStaticActor etelek = new OneSpriteStaticActor(game, ETELEK);
        etelek.setSize(getWidth()/4,getWidth()/4);
        etelek.setPosition( getWidth()+ getWidth()/2-etelek.getWidth()*1.5f,etelek.getHeight()/2);
        addActor(etelek);
        etelek.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                etelclicked();
            }
        });

        OneSpriteStaticActor italok = new OneSpriteStaticActor(game, ITALOK);
        italok.setSize(getWidth()/4,getWidth()/4);
        italok.setPosition(getWidth()+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(italok);
        italok.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                italclicked();
            }
        });

        OneSpriteStaticActor jatekok = new OneSpriteStaticActor(game, JATEKOK);
        jatekok.setSize(getWidth()/4,getWidth()/4);
        jatekok.setPosition( -getWidth()+ getWidth()/2-etelek.getWidth()*1.5f,etelek.getHeight()/2);
        addActor(jatekok);
        jatekok.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                jatekkclicked();
            }
        });

        OneSpriteStaticActor munkak = new OneSpriteStaticActor(game, MUNKAK);
        munkak.setSize(getWidth()/4,getWidth()/4);
        munkak.setPosition(-getWidth()+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(munkak);
        munkak.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                munkakclicked();
            }
        });

        OneSpriteStaticActor szobak = new OneSpriteStaticActor(game, SZOBAK);
        szobak.setSize(getWidth()/4,getWidth()/4);
        szobak.setPosition(getWidth()*2+ getWidth()/2-etelek.getWidth()*1.5f,etelek.getHeight()/2);
        addActor(szobak);
        szobak.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                szobakclicked();
            }
        });

        OneSpriteStaticActor ruhak = new OneSpriteStaticActor(game, RUHAK);
        ruhak.setSize(getWidth()/4,getWidth()/4);
        ruhak.setPosition(getWidth()*2+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(ruhak);
        ruhak.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                skinekclicked();
            }
        });

        OneSpriteStaticActor szobak1 = new OneSpriteStaticActor(game, SZOBAK);
        szobak1.setSize(getWidth()/4,getWidth()/4);
        szobak1.setPosition(getWidth()*-2+ getWidth()/2-etelek.getWidth()*1.5f,etelek.getHeight()/2f);
        addActor(szobak1);
        szobak1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getCamera().position.set(getCamera().position.x+(getViewport().getWorldWidth()*4),getViewport().getWorldHeight()/2,0);
                melyik_hatter = 2;
                szobakclicked();
            }
        });

        OneSpriteStaticActor ruhak1 = new OneSpriteStaticActor(game, RUHAK);
        ruhak1.setSize(getWidth()/4,getWidth()/4);
        ruhak1.setPosition(getWidth()*-2+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(ruhak1);
        ruhak1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                getCamera().position.set(getCamera().position.x+(getViewport().getWorldWidth()*4),getViewport().getWorldHeight()/2,0);
                melyik_hatter = 2;
                skinekclicked();
            }
        });

        tut = new OneSpriteStaticActor(game, TUT);
        tut.setSize(getWidth()/4,getWidth()/4);
        tut.setPosition(tut.getWidth()*0.5f,tut.getHeight()/2);
        addActor(tut,100000000);
        tut.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                gomb = true;
                tutorial=true;
            }
        });

        next = new OneSpriteStaticActor(game, NEXT);
        next.setSize(getWidth()/4,getWidth()/4);
        next.setPosition(getWidth()-next.getWidth()*1.5f,next.getHeight()/2);
        addActor(next,1000000);
        next.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                melyikev = save.getInteger("story");
                System.out.printf(melyikev+"sadsad");
                melyikev++;
                if(melyikev == 1){
                    save.putInteger("ev",2005);
                    save.putInteger("honap",7);
                    save.putInteger("nap",22);
                    save.flush();
                }
                if(melyikev == 2){
                    save.putInteger("ev",2012);
                    save.putInteger("honap",7);
                    save.putInteger("nap",22);
                    save.flush();
                }
                if(melyikev == 3){
                    save.putInteger("ev",2016);
                    save.putInteger("honap",7);
                    save.putInteger("nap",22);
                    save.flush();
                }
                if(melyikev == 4){
                    save.putInteger("ev",2020);
                    save.putInteger("honap",7);
                    save.putInteger("nap",22);
                    save.flush();
                }
            }
        });
        if(save.getInteger("seged") == 1){
            next.setVisible(true);
        }
        else next.setVisible(false);

        vissza = new OneSpriteStaticActor(game, VISSZA);
        vissza.setSize(getWidth()/4,getWidth()/8);
        vissza.setPosition(getWidth()-vissza.getWidth(),0);
        addActor(vissza,10001);
        vissza.setVisible(false);
        vissza.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                visszaclicked();
            }
        });

        sand = new OneSpriteStaticActor(game, SAND);
        sand.setSize(getWidth(),getHeight());
        sand.setPosition(0,0);
        addActor(sand,10001);
        sand.setVisible(false);

        inline = new Borderhuzogato(game,this);
        inline.setVisible(true);

        naptar = new MyLabel(game, "Ez itt a datum", ls) {
            @Override
            public void init() {

            }
        };
        naptar.setPosition(0,getHeight()-naptar.getHeight());
        naptar.setColor(Color.WHITE);
        naptar.setFontScale(1.5f);
        addActor(naptar);

        final OneSpriteStaticActor penz = new OneSpriteStaticActor(game, COIN);
        penz.setSize(getWidth()/12,getWidth()/12);
        penz.setPosition(0,getHeight()-naptar.getHeight()*2.3f);
        addActor(penz);
        penz0 = new MyLabel(game, "100", ls) {
            @Override
            public void init() {

            }
        };
        penz0.setPosition(getWidth()/12,getHeight()-penz0.getHeight()*2);
        penz0.setColor(Color.BLACK);
        penz0.setFontScale(1.5f);
        addActor(penz0);

        //System.out.println(Math.round(save.getFloat("ehseg")));
        bar = new StatusBarActor(game,this,"red",getWidth()/1.5f,getHeight()/30,100,save.getInteger("ehseg"),3.5f,"Éhség");
        bar2 = new StatusBarActor(game,this,"green",getWidth()/1.5f,getHeight()/30,100,save.getInteger("szomjusag"),5,"Szomjúság");
        bar3 = new StatusBarActor(game,this,"blue",getWidth()/1.5f,getHeight()/30,100,save.getInteger("stressz"),6.5f,"Stressz");
        bar4 = new StatusBarActor(game,this,"gold",getWidth()/1.5f,getHeight()/30,100,save.getInteger("veralkohol"),8,"Véralkohol szint");


        if(save.getInteger("ev")== 2001 && save.getInteger("honap")== 7 && save.getInteger("nap")< 24){
        ((MyScreen)getGame().getScreen()).addStage(new StoryStage(getGame(), new String[]{KEPEK[0],KEPEK[1],KEPEK[1]},new String[]{HANGOK[0],HANGOK[1],HANGOK[2]}){
            @Override
            public void storyEnded(StoryStage sender) {
                super.storyEnded(sender);

                ((MyScreen)getGame().getScreen()).removeStage(sender);
            }
        }, 2, true);

        }


        //TUTORIAL PÉLDA


        addTimer(new TickTimer(0, true, new TickTimerListener() {

            @Override
            public void onTick(Timer sender, float correction) {
                if(timer_able_to_count){
                    ticks++;
                    perc+=20;
                    if(perc == 60){perc = 0; ora++;}
                    if(ora ==25)ora=0;
                    if(perc == 0)perc2="00";
                    else perc2=perc+"";
                    if(ora == 0)ora2="00";
                    else if(ora < 10)ora2="0"+ora;
                    else ora2=ora+"";
                    naptar.setText(datum.ev+"."+datum.getMonth(datum.honap)+"."+datum.nap+"  "+ora2+":"+perc2);
                if(ticks%75==0){count++;
                    datum.leptetes();
                    melyikev = save.getInteger("story");
                    if(datum.ev == 2005 && datum.honap == 7 && datum.nap == 23){
                        melyikev++;
                        datum.nap++;
                        save.putString("jatekok","111110000");
                        save.putInteger("story",melyikev);
                        save.flush();
                        ((MyScreen)getGame().getScreen()).addStage(new StoryStage(getGame(), new String[]{KEPEK[2],KEPEK[3],KEPEK[4]},new String[]{HANGOK[3],HANGOK[4],HANGOK[5]}){
                            @Override
                            public void storyEnded(StoryStage sender) {
                                super.storyEnded(sender);

                                ((MyScreen)getGame().getScreen()).removeStage(sender);
                            }
                        }, 2, true);

                    }

                    if(datum.ev == 2012 && datum.honap == 7 && datum.nap == 23){
                        melyikev++;
                        datum.nap++;
                        save.putString("jatekok","111111111");
                        save.putInteger("story",melyikev);
                        save.flush();
                        ((MyScreen)getGame().getScreen()).addStage(new StoryStage(getGame(), new String[]{KEPEK[5],KEPEK[6],KEPEK[7]},new String[]{HANGOK[6],HANGOK[7],HANGOK[8]}){
                            @Override
                            public void storyEnded(StoryStage sender) {
                                super.storyEnded(sender);

                                ((MyScreen)getGame().getScreen()).removeStage(sender);
                            }
                        }, 2, true);

                    }

                    if(datum.ev == 2016 && datum.honap == 7 && datum.nap == 23){
                        melyikev++;
                        datum.nap++;
                        save.putInteger("story",melyikev);
                        save.flush();
                        ((MyScreen)getGame().getScreen()).addStage(new StoryStage(getGame(), new String[]{KEPEK[8],KEPEK[9],KEPEK[9]},new String[]{HANGOK[9],HANGOK[10],HANGOK[11]}){
                            @Override
                            public void storyEnded(StoryStage sender) {
                                super.storyEnded(sender);

                                ((MyScreen)getGame().getScreen()).removeStage(sender);
                            }
                        }, 2, true);
                    }

                    if(datum.ev == 2020 && datum.honap == 7 && datum.nap == 23){
                        melyikev++;
                        datum.nap++;
                        save.putString("munkak","11111");
                        save.putInteger("story",melyikev);
                        save.putInteger("seged",0);
                        save.flush();
                        next.setVisible(false);
                        ((MyScreen)getGame().getScreen()).addStage(new StoryStage(getGame(), new String[]{KEPEK[10],KEPEK[11],KEPEK[11]},new String[]{HANGOK[12],HANGOK[13],HANGOK[14]}){
                            @Override
                            public void storyEnded(StoryStage sender) {
                                super.storyEnded(sender);

                                ((MyScreen)getGame().getScreen()).removeStage(sender);
                            }
                        }, 2, true);

                    }

                    if(tutorial && gomb){
                        tutorial(save.getInteger("tutorial2"));
                        tutorial =false;
                        gomb = false;
                    }
                    else if(tutorial){
                        tutorial(save.getInteger("tutorial"));
                        tutorial =false;
                    }

                    bar.changeValue(-1);
                    save.putInteger("ehseg",bar.jelenlegi);
                }

                    if(ticks%220==0){
                        bar2.changeValue(-1);
                        save.putInteger("szomjusag",bar2.jelenlegi);
                    }
                    if(ticks%300==0){
                        bar3.changeValue(1);
                        save.putInteger("stressz",bar3.jelenlegi);
                        bar4.changeValue(-1);
                        save.putInteger("veralkohol",bar4.jelenlegi);
                    }

                    for (int i = 0; i < save.getString("daveskin").length(); i++) {
                        if(save.getString("daveskin").charAt(i) == '2')daveSelected = i;
                    }
                    for (int i = 0; i < save.getString("szobak").length(); i++) {
                        if(save.getString("szobak").charAt(i) == '2')szobaSelected = i;
                    }

                    if(szobaSelected != szobaseged){
                        szobaseged = szobaSelected;
                        save.putInteger("hatter",szobaSelected);
                        save.flush();
                        changewallpaper();
                    }

                    if(daveSelected != daveseged){
                        daveseged = daveSelected;
                        Dave.remove();
                        save.putInteger("dave",daveSelected);
                        save.flush();
                        Dave = new OneSpriteStaticActor(game, BENDZSIK[save.getInteger("dave")]);
                        Dave.setSize(getWidth()/1.5f,getHeight()/1.5f);
                        Dave.setPosition(getWidth()/2-Dave.getWidth()/2,getHeight()/40);
                        addActor(Dave);
                    }

                    rotate();

                    if(melyik_hatter == 0){
                        naphold.setPosition(getWidth()/2-naphold.getWidth()/2,getHeight()/2-naphold.getHeight()/2f);
                        hatter.setPosition(getWidth()/2-hatter.getWidth()/2,getHeight()/2-hatter.getHeight()/2.5f);
                    }
                    else if(melyik_hatter == 1){
                        naphold.setPosition(getWidth()+getWidth()/2-naphold.getWidth()/2,getHeight()/2-naphold.getHeight()/2f);
                        hatter.setPosition(getWidth()+getWidth()/2-hatter.getWidth()/2,getHeight()/2-hatter.getHeight()/2.5f);
                    }

                if(detect.get && detectOn){
                    if(detect.iranyX==-1)jobbra();
                    else if(detect.iranyX==1)balra();
                    detect.del();
                    detect.get = false;
                }
                penz0.setText(save.getInteger("penz"));
                save.flush();
        }}
        }));
    }

    public void changewallpaper(){
        BackGround.remove();
        BackGround_konyha.remove();
        BackGround_munka.remove();
        BackGround_radio.remove();
        BackGround_radio2.remove();

        BackGround = new OneSpriteStaticActor(game, HATTEREK[0][save.getInteger("hatter")]);
        BackGround.setSize(getWidth(),getHeight());
        BackGround.setX(0);
        addActor(BackGround,1);

        BackGround_konyha = new OneSpriteStaticActor(game, HATTEREK[1][save.getInteger("hatter")]);
        BackGround_konyha.setSize(getWidth(),getHeight());
        BackGround_konyha.setX(getWidth());
        addActor(BackGround_konyha,1);

        BackGround_munka = new OneSpriteStaticActor(game, HATTEREK[2][save.getInteger("hatter")]);
        BackGround_munka.setSize(getWidth(),getHeight());
        BackGround_munka.setX(0-getWidth());
        addActor(BackGround_munka,1);

        BackGround_radio = new OneSpriteStaticActor(game, HATTEREK[3][save.getInteger("hatter")]);
        BackGround_radio.setSize(getWidth(),getHeight());
        BackGround_radio.setX(getWidth()*2);
        addActor(BackGround_radio,1);

        BackGround_radio2 = new OneSpriteStaticActor(game, HATTEREK[3][save.getInteger("hatter")]);
        BackGround_radio2.setSize(getWidth(),getHeight());
        BackGround_radio2.setX(0-getWidth()*2);
        addActor(BackGround_radio2,1);
    }

    public void tutorial(int hany){
        System.out.println("asdsad");
        if(hany == 0){
        ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[0],TUTORIALS[1],TUTORIALS[2],TUTORIALS[3]}) {
            @Override
            public void tutorialEnded(TutorialStage stage) {
                super.tutorialEnded(stage);
                ((MyScreen)getGame().getScreen()).removeStage(stage);

            }
        }, 10000000, true);
            save.putInteger("tutorial2",10);
            save.putInteger("tutorial",1);
            save.flush();
    }
    else if(hany == 1){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[4],TUTORIALS[5],TUTORIALS[6]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
            save.putInteger("tutorial",2);
            save.putInteger("tutorial2",11);
            save.flush();
        }
        else if(hany == 2){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[7],TUTORIALS[8],TUTORIALS[9],TUTORIALS[10]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
            save.putInteger("tutorial2",12);
            save.putInteger("tutorial",3);
            save.flush();
        }
        else if(hany == 3){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[11],TUTORIALS[12],TUTORIALS[13],TUTORIALS[14],TUTORIALS[15]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
            save.putInteger("tutorial2",13);
            save.flush();
        }
        else if(hany == 10){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[0],TUTORIALS[1],TUTORIALS[2],TUTORIALS[3]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
        }
        else if(hany == 11){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[0],TUTORIALS[1],TUTORIALS[2],TUTORIALS[3],TUTORIALS[4],TUTORIALS[5],TUTORIALS[6]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
        }
        else if(hany == 12){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[0],TUTORIALS[1],TUTORIALS[2],TUTORIALS[3],TUTORIALS[5],TUTORIALS[6],TUTORIALS[7],TUTORIALS[8],TUTORIALS[9],TUTORIALS[10]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
        }
        else if(hany == 13){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[0],TUTORIALS[1],TUTORIALS[2],TUTORIALS[3],TUTORIALS[5],TUTORIALS[6],TUTORIALS[7],TUTORIALS[8],TUTORIALS[9],TUTORIALS[10],TUTORIALS[11],TUTORIALS[12],TUTORIALS[13],TUTORIALS[14],TUTORIALS[15]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
        }
        else if(hany == 14){
            ((MyScreen)getGame().getScreen()).addStage(new TutorialStage(game, new String[]{TUTORIALS[0],TUTORIALS[1],TUTORIALS[2],TUTORIALS[3]}) {
                @Override
                public void tutorialEnded(TutorialStage stage) {
                    super.tutorialEnded(stage);
                    ((MyScreen)getGame().getScreen()).removeStage(stage);

                }
            }, 10000000, true);
        }
    }

    public void etelclicked(){
        inline.one=1;
        for (int i = 0; i < Border.KAJA.length; i++) {
            final Border asd = new Border(game,this,i,0,getViewport().getWorldWidth(),false,false);
            gombok.add(asd);
        }
        sand.setVisible(true);
        sand.setX(getWidth());
        inline.setVisible(true);
        detectOn=false;
        vissza.setVisible(true);
        vissza.setX((getWidth())*2-vissza.getWidth());
        vissza.setZIndex(29000);
    }

    public void italclicked(){
        inline.one=1;
        for (int i = 0; i < Border.ITAL.length; i++) {
            Border asd = new Border(game,this,i,1,getViewport().getWorldWidth(),false,false);
            gombok.add(asd);
        }
        sand.setVisible(true);
        sand.setX(getWidth());
        inline.setVisible(true);
        detectOn=false;
        vissza.setVisible(true);
        vissza.setX((getWidth())*2-vissza.getWidth());
        vissza.setZIndex(29000);
    }

    public void skinekclicked(){
        inline.one=melyik_hatter;
        String munkak = save.getString("daveskin");
        for (int i = 0; i < BENDZSIK.length; i++) {
            Border asd;
            if(munkak.charAt(i) == '0') asd = new Border(game,this,i,2,getViewport().getWorldWidth()*melyik_hatter,false,false);
            else if(munkak.charAt(i) == '1'){asd = new Border(game,this,i,2,getViewport().getWorldWidth()*melyik_hatter,false,false); asd.delOsszeg();}
            else{asd = new Border(game,this,i,2,getViewport().getWorldWidth()*melyik_hatter,false,true); daveSelected = i; asd.delOsszeg();}
            gombok.add(asd);
        }
        sand.setVisible(true);
        sand.setX(getWidth()*melyik_hatter);
        inline.setVisible(true);
        detectOn=false;
        vissza.setVisible(true);
        if(melyik_hatter>0) vissza.setX((getWidth()*(melyik_hatter+1))-vissza.getWidth());
        else vissza.setX((getWidth()*(melyik_hatter-1))-vissza.getWidth());
        vissza.setZIndex(29000);
    }

    public void szobakclicked(){
        inline.one=melyik_hatter;
        String munkak = save.getString("szobak");
        for (int i = 0; i < HATTEREK.length; i++) {
            Border asd;
            if(munkak.charAt(i) == '0') asd = new Border(game,this,i,3,getViewport().getWorldWidth()*melyik_hatter,false,false);
            else if(munkak.charAt(i) == '1'){asd = new Border(game,this,i,3,getViewport().getWorldWidth()*melyik_hatter,false,false); asd.delOsszeg();}
            else{ asd = new Border(game,this,i,3,getViewport().getWorldWidth()*melyik_hatter,false,true); szobaSelected = i; asd.delOsszeg();}
            gombok.add(asd);
        }
        sand.setVisible(true);
        sand.setX(getWidth()*melyik_hatter);
        inline.setVisible(true);
        detectOn=false;
        vissza.setVisible(true);
        if(melyik_hatter>0) vissza.setX((getWidth()*(melyik_hatter+1))-vissza.getWidth());
        else vissza.setX((getWidth()*(melyik_hatter-1))-vissza.getWidth());
        vissza.setZIndex(29000);
    }

    public void munkakclicked(){
        inline.one=melyik_hatter;
        String munkak = save.getString("munkak");
        for (int i = 0; i < Border.WORK.length; i++) {
            Border asd;
            //System.out.println(munkak[i]);
            if(munkak.charAt(i) == '0') asd= new Border(game,this,i,5,getViewport().getWorldWidth()*melyik_hatter,true,false);
            else asd = new Border(game,this,i,5,getViewport().getWorldWidth()*melyik_hatter,false,false);
            gombok.add(asd);
        }
        sand.setVisible(true);
        sand.setX(getWidth()*melyik_hatter);
        inline.setVisible(true);
        detectOn=false;
        vissza.setVisible(true);
        vissza.setX(0-vissza.getWidth());
        vissza.setZIndex(29000);
    }

    public void jatekkclicked(){
        inline.one=melyik_hatter;
        String munkak = save.getString("jatekok");
        for (int i = 0; i < Border.MINIGAME.length; i++) {
            Border asd;
            if(munkak.charAt(i) == '0') asd = new Border(game,this,i,4,getViewport().getWorldWidth()*melyik_hatter,true,false);
            else asd = new Border(game,this,i,4,getViewport().getWorldWidth()*melyik_hatter,false,false);
            gombok.add(asd);
        }
        sand.setVisible(true);
        sand.setX(getWidth()*melyik_hatter);
        inline.setVisible(true);
        detectOn=false;
        vissza.setVisible(true);
        vissza.setX(0-vissza.getWidth());
        vissza.setZIndex(29000);
    }

    void visszaclicked(){
        for (int i = 0; i < gombok.size(); i++) {
            gombok.get(i).remove();
        }
        gombok.clear();
        sand.setVisible(false);
        inline.setVisible(false);
        detect.setVisible(true);
        vissza.setVisible(false);
        detectOn = true;
    }

    void rotate(){
        naphold.setRotation(fok);
        fok+=5f;
    }

    TickTimer a;
    void balra(){if(canchangescreen){
        canchangescreen = false;
        melyik_hatter--;
        if(melyik_hatter == -3){
            melyik_hatter = 1;
            getCamera().position.set(getCamera().position.x+(getViewport().getWorldWidth()*4),getViewport().getWorldHeight()/2,0);
        }
        final float nu = getCamera().position.x;
        final float ize = getViewport().getWorldWidth()/20;
        final float finish = nu-getViewport().getWorldWidth();
        int x = 0;
        a = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                if(getCamera().position.x <= finish)stop();
                else getCamera().position.set(getCamera().position.x-ize,getViewport().getWorldHeight()/2,0);
            }
        });
        addTimer(a);}
    }

    void jobbra(){
        if(canchangescreen){
        canchangescreen = false;
        melyik_hatter++;
        if(melyik_hatter == 3){
            melyik_hatter = -1;
            getCamera().position.set(getCamera().position.x-(getViewport().getWorldWidth()*4),getViewport().getWorldHeight()/2,0);
        }
        final float nu = getCamera().position.x;
        final float ize = getViewport().getWorldWidth()/20;
        a = new TickTimer(0, true, new TickTimerListener() {
            @Override
            public void onTick(Timer sender, float correction) {
                getCamera().position.set(getCamera().position.x+ize,getViewport().getWorldHeight()/2,0);

                if(getCamera().position.x >= nu+getViewport().getWorldWidth())stop();
            }
        });
        addTimer(a);
    }}

    void stop(){
        a.stop();canchangescreen = true;
    }

}
