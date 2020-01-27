package com.pindurpendurok.puszedli.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.StatusBarActor;
import com.pindurpendurok.puszedli.Screens.Actors.changeMenuActor;
import com.pindurpendurok.puszedli.Screens.Classes.Border;
import com.pindurpendurok.puszedli.Screens.Classes.Borderhuzogato;
import com.pindurpendurok.puszedli.Screens.Classes.Date;
import com.pindurpendurok.puszedli.Screens.Favago.FavagoScreen;
import com.pindurpendurok.puszedli.Screens.Foci.FociScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapWorldScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PszichiaterScreen;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameScreen;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathMenuStage;
import com.pindurpendurok.puszedli.Screens.Rocking.RockingScreen;
import com.pindurpendurok.puszedli.Screens.Shake.ShakeScreen;
import com.pindurpendurok.puszedli.Screens.Trash.TrashScreen;

import java.util.ArrayList;
import java.util.List;

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

    public final static String FONT = "Bosk.otf";
    static final String[][] HATTEREK = new String[][]{{"elemek/szoba/szoba1.png","elemek/szoba/szoba2.png","elemek/szoba/szoba3.png","elemek/szoba/szoba4.png","elemek/szoba/szoba5.png"},
            {"elemek/szoba/szoba1_konyha.png","elemek/szoba/szoba2_konyha.png","elemek/szoba/szoba3_konyha.png","elemek/szoba/szoba4_konyha.png","elemek/szoba/szoba5_konyha.png"},
            {"elemek/szoba/szoba1_munka.png","elemek/szoba/szoba2_munka.png","elemek/szoba/szoba3_munka.png","elemek/szoba/szoba4_munka.png","elemek/szoba/szoba5_munka.png"},
            {"elemek/szoba/szoba1_ures.png","elemek/szoba/szoba2_ures.png","elemek/szoba/szoba3_ures.png","elemek/szoba/szoba4_ures.png","elemek/szoba/szoba5_ures.png"},
    };


    static final String[] BENDZSIK = new String[]{"elemek/dave/Davey.png","elemek/dave/DaveyAlaMexican.png","elemek/dave/DaveyIgen.png","elemek/dave/DaveyVaják.png","elemek/dave/gangsterDavey.png",
            "elemek/dave/jasonDavey.png","elemek/dave/kawaiiDavey.png","elemek/dave/MarioDavey.png","elemek/dave/NudiDavey.png","elemek/dave/papDavey.png",
            "elemek/dave/rendőrDavey.png","elemek/dave/tündérDavey.png","elemek/dave/zacseszDavey.png","elemek/dave/ZoldDavey.png","elemek/dave/matrixDavey.png"};
    public final static String ETELEK = "elemek/etelek.png";
    public final static String ITALOK = "elemek/italok.png";
    public final static String SZOBAK = "elemek/szobak.png";
    public final static String RUHAK = "elemek/ruhak.png";
    public final static String JATEKOK = "elemek/games.png";
    public final static String MUNKAK = "elemek/storyk.png";
    public final static String SAND = "ui_textures/sand.png";
    public final static String VISSZA = "back.png";

    public boolean timer_able_to_count = true;
    public int ticks = 0;
    public int count = 0;
    public int ora = 0;
    public int perc = 0;
    public String ora2 ="";
    public String perc2 ="";
    MyLabel naptar;
    Date datum = new Date(this);
    public static Preferences save;
    changeMenuActor detect;
    int melyik_hatter = 0;
    OneSpriteStaticActor sand;
    OneSpriteStaticActor vissza;
    Borderhuzogato inline;
    boolean detectOn = true;
    public static List<Border> gombok = new ArrayList<>();


    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(ETELEK);
        assetList.addTexture(ITALOK);
        assetList.addTexture(RUHAK);
        assetList.addTexture(SZOBAK);
        assetList.addTexture(VISSZA);
        assetList.addTexture(JATEKOK);
        assetList.addTexture(MUNKAK);

        for (int i = 0; i < HATTEREK.length; i++) {
            for (int k = 0; k < HATTEREK[i].length; k++) {
                assetList.addTexture(HATTEREK[i][k]).protect = true;
            }
        }
        for (int i = 0; i < BENDZSIK.length; i++) {
            assetList.addTexture(BENDZSIK[i]).protect = true;
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
            save.putInteger("ev",2030);
            save.putInteger("honap",7);
            save.putInteger("nap",22); //23.-án született csak egyből léptet

            //Pap minigame
            save.putInteger("papkell",0);
            save.putInteger("papmegvan",0);
            save.putInteger("hatter",0);
            save.putInteger("dave",0);
        }
        save.flush();
        datum.leptetes();

        detect = new changeMenuActor(game,this);
        detect.setVisible(false);


        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, HATTEREK[0][save.getInteger("hatter")]);
        BackGround.setSize(getWidth(),getHeight());
        BackGround.setX(0);
        addActor(BackGround);

        OneSpriteStaticActor BackGround_konyha = new OneSpriteStaticActor(game, HATTEREK[1][save.getInteger("hatter")]);
        BackGround_konyha.setSize(getWidth(),getHeight());
        BackGround_konyha.setX(getWidth());
        addActor(BackGround_konyha);

        OneSpriteStaticActor BackGround_munka = new OneSpriteStaticActor(game, HATTEREK[2][save.getInteger("hatter")]);
        BackGround_munka.setSize(getWidth(),getHeight());
        BackGround_munka.setX(0-getWidth());
        addActor(BackGround_munka);

        OneSpriteStaticActor BackGround_radio = new OneSpriteStaticActor(game, HATTEREK[3][save.getInteger("hatter")]);
        BackGround_radio.setSize(getWidth(),getHeight());
        BackGround_radio.setX(getWidth()*2);
        addActor(BackGround_radio);

        OneSpriteStaticActor BackGround_radio2 = new OneSpriteStaticActor(game, HATTEREK[3][save.getInteger("hatter")]);
        BackGround_radio2.setSize(getWidth(),getHeight());
        BackGround_radio2.setX(0-getWidth()*2);
        addActor(BackGround_radio2);

        OneSpriteStaticActor Dave = new OneSpriteStaticActor(game, BENDZSIK[save.getInteger("dave")]);
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

        OneSpriteStaticActor munkak = new OneSpriteStaticActor(game, MUNKAK);
        munkak.setSize(getWidth()/4,getWidth()/4);
        munkak.setPosition(-getWidth()+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(munkak);

        OneSpriteStaticActor szobak = new OneSpriteStaticActor(game, SZOBAK);
        szobak.setSize(getWidth()/4,getWidth()/4);
        szobak.setPosition(getWidth()*2+ getWidth()/2-etelek.getWidth()*1.5f,etelek.getHeight()/2);
        addActor(szobak);

        OneSpriteStaticActor ruhak = new OneSpriteStaticActor(game, RUHAK);
        ruhak.setSize(getWidth()/4,getWidth()/4);
        ruhak.setPosition(getWidth()*2+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(ruhak);

        OneSpriteStaticActor szobak1 = new OneSpriteStaticActor(game, SZOBAK);
        szobak1.setSize(getWidth()/4,getWidth()/4);
        szobak1.setPosition(getWidth()*-2+ getWidth()/2-etelek.getWidth()*1.5f,etelek.getHeight()/2);
        addActor(szobak1);

        OneSpriteStaticActor ruhak1 = new OneSpriteStaticActor(game, RUHAK);
        ruhak1.setSize(getWidth()/4,getWidth()/4);
        ruhak1.setPosition(getWidth()*-2+ getWidth()/2 +etelek.getWidth()*0.5f,italok.getHeight()/2);
        addActor(ruhak1);

        vissza = new OneSpriteStaticActor(game, VISSZA);
        vissza.setSize(getWidth()/5,getWidth()/10);
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

        StatusBarActor bar = new StatusBarActor(game,this,"red",getWidth()/1.5f,getHeight()/30,100,100,2.5f,"Éhség");
        StatusBarActor bar2 = new StatusBarActor(game,this,"green",getWidth()/1.5f,getHeight()/30,100,100,4,"Szomjúság");
        StatusBarActor bar3 = new StatusBarActor(game,this,"blue",getWidth()/1.5f,getHeight()/30,100,100,5.5f,"Stressz");
        StatusBarActor bar4 = new StatusBarActor(game,this,"gold",getWidth()/1.5f,getHeight()/30,100,100,7,"Véralkohol szint");


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

                if(detect.get && detectOn){
                    if(detect.iranyX==-1)jobbra();
                    else if(detect.iranyX==1)balra();
                    detect.del();
                    detect.get = false;
                }
        }}
        }));

        SimpleButton shakeBtn = new SimpleButton(game, "Rázd");
        shakeBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new ShakeScreen(game));
            }
        });
        addActor(shakeBtn);

        SimpleButton pop = new SimpleButton(game, "paps");
        pop.setX(50);
        pop.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PapWorldScreen(game));
            }
        });
        addActor(pop);

        SimpleButton pszic = new SimpleButton(game, "Pszichiáter");
        pszic.setX(100);
        pszic.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new PszichiaterScreen(game));
            }
        });
        addActor(pszic);

        SimpleButton matek = new SimpleButton(game, "matek");
        matek.setX(150);
        matek.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new MathGameScreen(game));
            }
        });
        addActor(matek);

        SimpleButton trash = new SimpleButton(game, "kukás");
        trash.setX(200);
        trash.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new TrashScreen(game));
            }
        });
        addActor(trash);

        SimpleButton foci = new SimpleButton(game, "fociii");
        foci.setX(250);
        foci.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new FociScreen(game));
            }
        });
        addActor(foci);

        SimpleButton favagas = new SimpleButton(game, "favagas");
        favagas.setX(300);
        favagas.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new FavagoScreen(game));
            }
        });
        addActor(favagas);

        SimpleButton rock = new SimpleButton(game, "ringatas");
        rock.setX(350);
        rock.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.setScreen(new RockingScreen(game));
            }
        });
        addActor(rock);

        //getCamera().position.set(0,getViewport().getWorldHeight()/2,0);
    }

    public void etelclicked(){
        for (int i = 0; i < Border.KAJA.length; i++) {
            System.out.println("asd");
            Border asd = new Border(game,this,i,0,getViewport().getWorldWidth());
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
        for (int i = 0; i < Border.ITAL.length; i++) {
            Border asd = new Border(game,this,i,1,getViewport().getWorldWidth());
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


    TickTimer a;
    void balra(){
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
        addTimer(a);
    }

    void jobbra(){
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
    }

    void stop(){
        a.stop();
    }

}
