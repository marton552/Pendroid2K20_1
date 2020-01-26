package com.pindurpendurok.puszedli.Screens.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.Elements.SimpleButton;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Actors.StatusBarActor;
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
    public final static String FONT = "Bosk.otf";
    static final String[] HATTEREK = new String[]{"elemek/szoba/szoba1.png","elemek/szoba/szoba2.png","elemek/szoba/szoba3.png","elemek/szoba/szoba4.png","elemek/szoba/szoba5.png"};
    static final String[] BENDZSIK = new String[]{"elemek/dave/Davey.png","elemek/dave/DaveyAlaMexican.png","elemek/dave/DaveyIgen.png","elemek/dave/DaveyVaják.png","elemek/dave/gangsterDavey.png",
            "elemek/dave/jasonDavey.png","elemek/dave/kawaiiDavey.png","elemek/dave/marioDavey.png","elemek/dave/NudiDavey.png","elemek/dave/papDavey.png",
            "elemek/dave/rendőrDavey.png","elemek/dave/tündérDavey.png","elemek/dave/zacseszDavey.png","elemek/dave/ZoldDavey.png","elemek/dave/matrixDavey.png"};
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


    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACKGROUND);
        for (int i = 0; i < HATTEREK.length; i++) {
            assetList.addTexture(HATTEREK[i]).protect = true;
        }
        for (int i = 0; i < BENDZSIK.length; i++) {
            assetList.addTexture(BENDZSIK[i]).protect = true;
        }
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


        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, HATTEREK[save.getInteger("hatter")]);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        OneSpriteStaticActor Dave = new OneSpriteStaticActor(game, BENDZSIK[save.getInteger("dave")]);
        Dave.setSize(getWidth()/1.5f,getHeight()/1.5f);
        Dave.setPosition(getWidth()/2-Dave.getWidth()/2,getHeight()/40);
        addActor(Dave);

        naptar = new MyLabel(game, "Ez itt a datum", ls) {
            @Override
            public void init() {

            }
        };
        naptar.setPosition(0,getHeight()-naptar.getHeight());
        naptar.setColor(Color.BLACK);
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
    }
}
