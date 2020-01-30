package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Puzzle.PuzzleScreen;
import com.pindurpendurok.puszedli.Screens.Actors.CircleAtBackgroundActor;
import com.pindurpendurok.puszedli.Screens.Bell.BellScreen;
import com.pindurpendurok.puszedli.Screens.Favago.FavagoScreen;
import com.pindurpendurok.puszedli.Screens.Foci.FociScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;
import com.pindurpendurok.puszedli.Screens.Guess.GuessScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapWorldScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PszichiaterScreen;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameScreen;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathMenuStage;
import com.pindurpendurok.puszedli.Screens.Porno.PornoScreen;
import com.pindurpendurok.puszedli.Screens.Rocking.RockingScreen;
import com.pindurpendurok.puszedli.Screens.Shake.ShakeScreen;
import com.pindurpendurok.puszedli.Screens.Trash.TrashScreen;
import com.pindurpendurok.puszedli.Screens.Wow.WowScreen;
import com.pindurpendurok.puszedli.Screens.Wow.WowStage;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class Border {

    public static final String LABDA = "null.png";
    public final static String FONT = "Bosk.otf";
    public final static String BACK = "elemek/border.png";
    public final static String COIN = "penz.png";
    public final static String BLOCK = "elemek/LOCKED.png";
    public final static String SEL = "elemek/SELECTED.png";
    public static final String[] KAJA = new String[]{"elemek/etel/alma.png","elemek/etel/alma2.png","elemek/etel/barack.png","elemek/etel/chips.png","elemek/etel/csike.png",
            "elemek/etel/hamburger.png","elemek/etel/hamburger2.png","elemek/etel/popcorn.png","elemek/etel/spaggeti.png","elemek/etel/steak.png"};
           static final int[] penz = new int[]{20,25,30,100,200,200,190,100,230,250};

    public static final int[] etel = new int[]{10,12,13,20,25,25,26,15,30,35};
    public static final int[] stressz = new int[]{0,0,0,-10,-5,-3,-4,-2,0,0};

    public static final String[] ITAL = new String[]{"elemek/ital/cola.png","elemek/ital/cola2.png","elemek/ital/gyumile.png","elemek/ital/gyumile2.png","elemek/ital/kv2.png",
            "elemek/ital/sorike.png","elemek/ital/sorike_2l_javitott.png","elemek/ital/viz.png","elemek/ital/viz2.png",};
    public static final int[] penz2 = new int[]{30,20,45,40,20,120,160,20,30};
    public static final int[] ital =     new int[]{15,10,20,19,5,-10,-5,20,10};
    public static final int[] stressz2 = new int[]{-2,0,0,0,-10,-20,-30,0,0};
    public static final int[] alkohol =  new int[]{0,0,0,0,0,20,30,0,0};


    public static final int[] penz3 = new int[]{0,300,150,350,400,100,600,220,270,120,210,330,400,130,1000};

    public static final int[] penz4 = new int[]{0,500,600,400,450};


    public static final String[] MINIGAME = new String[]{"elemek/icon/minigame1.png","elemek/icon/minigame2.png","elemek/icon/minigame3.png","elemek/icon/minigame4.png","elemek/icon/minigame5.png",
            "elemek/icon/minigame6.png","elemek/icon/minigame7.png","elemek/icon/minigame8.png","elemek/icon/minigame9.png"};

    public static final String[] WORK = new String[]{"elemek/icon/munka1.png","elemek/icon/munka2.png","elemek/icon/munka3.png","elemek/icon/munka4.png","elemek/icon/munka5.png"};
    public static final String[] szoveg = new String[]{"Ringatás","Csorgo","Puzzle","Matek","Betűk","Önkielégítés","Foci",
    "WoW","Favágás"};
    public static final String[] szoveg2 = new String[]{"Kukás","Pornó rendező","Pszichiáter","Gamer","Pap"};

    public static AssetList assetList = new AssetList();
    static {
        AssetList.collectAssetDescriptor(CircleAtBackgroundActor.class, assetList);
        assetList.addFont(FONT, 60, Color.WHITE).protect = true;
        assetList.addTexture(BACK).protect = true;
        assetList.addTexture(COIN).protect = true;
        assetList.addTexture(LABDA);
        assetList.addTexture(BLOCK);
        assetList.addTexture(SEL);
        for (int i = 0; i < KAJA.length; i++) {
            assetList.addTexture(KAJA[i]).protect = true;
        }
        for (int i = 0; i < ITAL.length; i++) {
            assetList.addTexture(ITAL[i]).protect = true;
        }
        for (int i = 0; i < MINIGAME.length; i++) {
            assetList.addTexture(MINIGAME[i]).protect = true;
        }
        for (int i = 0; i < WORK.length; i++) {
            assetList.addTexture(WORK[i]).protect = true;
        }
    }

    GratulaloKep ize = new GratulaloKep();
    OneSpriteStaticActor back;
    OneSpriteStaticActor kep;
    MyLabel text;
    OneSpriteStaticActor coin;
    OneSpriteStaticActor click;
    OneSpriteStaticActor valasztott;
    OneSpriteStaticActor block;
    boolean ondrag = true;
    boolean blocked = false;
    boolean selected = false;
    public int hanyadik1;

    public Border(final MyGame game, final SimpleWorldStage gs, final int hanyadik, final int type, float screen,boolean tiltva,boolean selected1){
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(FONT);
        ls.fontColor = Color.WHITE;
        hanyadik1 = hanyadik;

        blocked = tiltva;
        selected = selected1;
        if(type == 4) back = new OneSpriteStaticActor(game, MINIGAME[hanyadik]);
        else if(type == 5)back = new OneSpriteStaticActor(game, WORK[hanyadik]);
        else back = new OneSpriteStaticActor(game, BACK);
        back.setSize(gs.getWidth()/3,gs.getWidth()/3);
        if(hanyadik%2==0 || hanyadik == 0)back.setPosition(screen + gs.getViewport().getWorldWidth()/2-back.getWidth()*1.1f,gs.getViewport().getWorldHeight()-(back.getHeight()*1.1f)*(hanyadik+2)/2);
        else back.setPosition(screen+ gs.getViewport().getWorldWidth()/2+(back.getWidth()*1.1f-back.getWidth()),gs.getViewport().getWorldHeight()-(back.getHeight()*1.1f)*(hanyadik+1)/2);
        gs.addActor(back,19999);

        if(type == 0) kep = new OneSpriteStaticActor(game, KAJA[hanyadik]);
        else if(type == 1) kep = new OneSpriteStaticActor(game, ITAL[hanyadik]);
        else if(type == 2) kep = new OneSpriteStaticActor(game, GameStage.BENDZSIK[hanyadik]);
        else if(type == 3) kep = new OneSpriteStaticActor(game, GameStage.HATTEREK[0][hanyadik]);
        else if(type == 4) kep = new OneSpriteStaticActor(game, LABDA);
        else if(type == 5) kep = new OneSpriteStaticActor(game, LABDA);
        if(type == 2 || type == 3)kep.setSize(back.getWidth()/3f,back.getWidth()/1.65f);
        else kep.setSize(back.getWidth()/1.65f,back.getWidth()/1.65f);
        kep.setPosition(back.getX()+back.getWidth()/2-kep.getWidth()/2,back.getY()+back.getHeight()/3.2f);
        gs.addActor(kep,19999);

        if(type == 0){
        text = new MyLabel(game, penz[hanyadik]+"", ls) {
            @Override
            public void init() {

            }
        };}
        else if(type == 1){
            text = new MyLabel(game, penz2[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 2){
            text = new MyLabel(game, penz3[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 3){
            text = new MyLabel(game, penz4[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 4){
            text = new MyLabel(game, szoveg[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        else if(type == 5){
            text = new MyLabel(game, szoveg2[hanyadik]+"", ls) {
                @Override
                public void init() {

                }
            };
        }
        if(text.getText().length<7) text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/30);
        else text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/55)*text.getText().length),back.getY()+back.getHeight()/30);
        text.setColor(Color.BLACK);
        text.setFontScale(0.8f);
        gs.addActor(text,19999);

        coin = new OneSpriteStaticActor(game, COIN);
        coin.setSize(gs.getWidth()/23,gs.getWidth()/23);
        coin.setPosition(back.getX()+back.getWidth()/2+((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/12);
        gs.addActor(coin,19999);

        if(type == 4 || type == 5)coin.setVisible(false);

        click = new OneSpriteStaticActor(game, LABDA);
        click.setSize(gs.getWidth()/3,gs.getWidth()/3);
        click.setPosition(back.getX(),back.getY());
        gs.addActor(click,19999);

        block = new OneSpriteStaticActor(game, BLOCK);
        block.setSize(gs.getWidth()/3,gs.getWidth()/3);
        block.setPosition(back.getX(),back.getY());
        gs.addActor(block,21000);
        block.setVisible(false);
        if(blocked) block.setVisible(true);

        valasztott = new OneSpriteStaticActor(game, SEL);
        valasztott.setSize(gs.getWidth()/3,gs.getWidth()/3);
        valasztott.setPosition(back.getX(),back.getY());
        gs.addActor(valasztott,21000);
        valasztott.setVisible(false);
        if(selected) valasztott.setVisible(true);

        click.addListener(new ClickListener() {

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                if(ondrag){
                System.out.printf(type+" ++ "+GameStage.save.getString("daveskin").charAt(hanyadik) +"  és "+GameStage.save.getInteger("penz")+" ja és "+penz3[hanyadik]);
                if (type==0 && GameStage.save.getInteger("penz") >= penz[hanyadik]){ize.letrehoz(game,gs,"Jó étvágyat!",penz[hanyadik]*-1,etel[hanyadik],0,stressz[hanyadik],0,gs.getViewport().getWorldWidth());
                    GameStage.save.putInteger("penz",GameStage.save.getInteger("penz")-penz[hanyadik]);
                    GameStage.bar.changeValue(etel[hanyadik]);
                    GameStage.bar3.changeValue(stressz[hanyadik]);
                }
                else if (type==1 && GameStage.save.getInteger("penz") >= penz2[hanyadik]){ize.letrehoz(game,gs,"Egészségedre!",penz2[hanyadik]*-1,0,ital[hanyadik],stressz2[hanyadik],alkohol[hanyadik],gs.getViewport().getWorldWidth());
                    GameStage.save.putInteger("penz",GameStage.save.getInteger("penz")-penz2[hanyadik]);
                    GameStage.bar2.changeValue(ital[hanyadik]);
                    GameStage.bar3.changeValue(stressz2[hanyadik]);
                    GameStage.bar4.changeValue(alkohol[hanyadik]);
                }
                else if (type==2 && GameStage.save.getString("daveskin").charAt(hanyadik) =='0' && GameStage.save.getInteger("penz") >= penz3[hanyadik]){ize.letrehoz(game,gs,"Új ruhák huhú!!",penz3[hanyadik]*-1,0,0,0,0,gs.getViewport().getWorldWidth()*2);
                    GameStage.save.putInteger("penz",GameStage.save.getInteger("penz")-penz3[hanyadik]);
                    vasarol2();
                    GameStage.save.flush();}
                else if (type==3 && GameStage.save.getString("szobak").charAt(hanyadik) =='0' && GameStage.save.getInteger("penz") >= penz4[hanyadik]){ize.letrehoz(game,gs,"Új szoba huhú!!",penz4[hanyadik]*-1,0,0,0,0,gs.getViewport().getWorldWidth()*2);
                    GameStage.save.putInteger("penz",GameStage.save.getInteger("penz")-penz4[hanyadik]);
                    vasarol();
                    GameStage.save.flush();}
                else if(type==2 && GameStage.save.getString("daveskin").charAt(hanyadik) == '1'){
                    GameStage.gombok.get(GameStage.daveSelected).putSelect(false);
                    StringBuilder s = new StringBuilder(GameStage.save.getString("daveskin"));
                    s.setCharAt(GameStage.daveSelected,'1');
                    GameStage.save.putString("daveskin", s.toString());

                    GameStage.save.flush();

                    putSelect(true);
                    s = new StringBuilder(GameStage.save.getString("daveskin"));
                    s.setCharAt(hanyadik,'2');
                    GameStage.save.putString("daveskin", s.toString());
                    GameStage.daveSelected = hanyadik;
                    selected = true;
                    GameStage.save.flush();
                }
                else if(type==3 && GameStage.save.getString("szobak").charAt(hanyadik) == '1'){
                    GameStage.gombok.get(GameStage.szobaSelected).putSelect(false);
                    char[] s = (GameStage.save.getString("szobak").toCharArray());
                    s[GameStage.szobaSelected] = '1';
                    GameStage.save.putString("szobak", String.valueOf(s));

                    GameStage.save.flush();

                    putSelect(true);
                    s = (GameStage.save.getString("szobak").toCharArray());
                    s[hanyadik] = '2';
                    GameStage.save.putString("szobak", String.valueOf(s));
                    GameStage.szobaSelected = hanyadik;
                    selected = true;
                    GameStage.save.flush();
                }
                else if(type<2) {//ize.letrehoz(game,gs,"Sajnos kevés a pénz :(",0,0,0,0,0,gs.getViewport().getWorldWidth());
                    System.out.println("asd222");}
                else if(type<4){
                    //ize.letrehoz(game,gs,"Sajnos kevés a pénz :(",0,0,0,0,0,gs.getViewport().getWorldWidth()*2);
                    System.out.println("asd");
                }
                else if(type == 4){
                    setgame(hanyadik,game);
                }
                else if(type == 5){
                    setmunka(hanyadik,game);
                }
                GameStage.save.flush();
                }
            ondrag = true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                ondrag = false;
            }
        });
    }

    void vasarol(){
        coin.setVisible(false);
        text.setText("Megvéve");

        GameStage.gombok.get(GameStage.szobaSelected).putSelect(false);
        char[] s = (GameStage.save.getString("szobak").toCharArray());
        s[GameStage.szobaSelected] = '1';
        GameStage.save.putString("szobak", String.valueOf(s));

        GameStage.save.flush();

        putSelect(true);
        s = (GameStage.save.getString("szobak").toCharArray());
        s[hanyadik1] = '2';
        GameStage.save.putString("szobak", String.valueOf(s));
        GameStage.szobaSelected = hanyadik1;
        selected = true;
        GameStage.save.flush();

    }

    void vasarol2(){
        coin.setVisible(false);
        text.setText("Megvéve");

        GameStage.gombok.get(GameStage.daveSelected).putSelect(false);
        StringBuilder s = new StringBuilder(GameStage.save.getString("daveskin"));
        s.setCharAt(GameStage.daveSelected,'1');
        GameStage.save.putString("daveskin", s.toString());

        GameStage.save.flush();

        putSelect(true);
        s = new StringBuilder(GameStage.save.getString("daveskin"));
        s.setCharAt(hanyadik1,'2');
        GameStage.save.putString("daveskin", s.toString());
        GameStage.daveSelected = hanyadik1;
        selected = true;
        GameStage.save.flush();

    }

    public void setmunka(int hanyadik, MyGame game){
        if(hanyadik == 0)game.setScreen(new TrashScreen(game));
        else if(hanyadik == 1) game.setScreenWithPreloadAssets(PornoScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 2) game.setScreenWithPreloadAssets(PszichiaterScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 3){ game.setScreenWithPreloadAssets(WowScreen.class, new LoadingCsakJobbScreen(game));
            WowStage.munkaE = true;
        }
        else if(hanyadik == 4) game.setScreenWithPreloadAssets(PapWorldScreen.class, new LoadingCsakJobbScreen(game));
    }

    public void setgame(int hanyadik, MyGame game){
        if(hanyadik == 0)game.setScreenWithPreloadAssets(RockingScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 1) game.setScreenWithPreloadAssets(BellScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 2) game.setScreenWithPreloadAssets(PuzzleScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 3) game.setScreenWithPreloadAssets(MathGameScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 4) game.setScreenWithPreloadAssets(GuessScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 5) game.setScreenWithPreloadAssets(ShakeScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 6) game.setScreenWithPreloadAssets(FociScreen.class, new LoadingCsakJobbScreen(game));
        else if(hanyadik == 7){
            WowStage.munkaE = false; game.setScreenWithPreloadAssets(WowScreen.class, new LoadingCsakJobbScreen(game));}
        else if(hanyadik == 8) game.setScreenWithPreloadAssets(FavagoScreen.class, new LoadingCsakJobbScreen(game));
    }

    public void mozgat(float y){
        back.setY(back.getY()+y);
        kep.setPosition(back.getX()+back.getWidth()/2-kep.getWidth()/2,back.getY()+back.getHeight()/3.2f);
        text.setPosition(back.getX()+back.getWidth()/2-((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/30);
        coin.setPosition(back.getX()+back.getWidth()/2+((back.getWidth()/25)*text.getText().length),back.getY()+back.getHeight()/12);
        click.setPosition(back.getX(),back.getY());
        if(blocked)block.setPosition(back.getX(),back.getY());
        if(selected)valasztott.setPosition(back.getX(),back.getY());
    }
    public void remove(){
        back.remove();
        kep.remove();
        text.remove();
        coin.remove();
        click.remove();
        if(blocked)block.remove();
        if(selected)valasztott.remove();
    }

    public void delOsszeg(){
        text.setText("Megvéve");
        coin.setVisible(false);
    }

    public void putSelect(boolean x){
        valasztott.setVisible(x);
    }
}
