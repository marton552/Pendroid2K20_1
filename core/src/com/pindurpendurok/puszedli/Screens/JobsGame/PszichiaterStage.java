package com.pindurpendurok.puszedli.Screens.JobsGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.pindurpendurok.puszedli.LoadingCsakJobbScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameScreen;

import java.util.ArrayList;

import hu.csanyzeg.master.MyBaseClasses.Assets.AssetList;
import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.csanyzeg.master.MyBaseClasses.Scene2D.ResponseViewport;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.ShapeType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleBodyType;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorld;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldHelper;
import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimer;
import hu.csanyzeg.master.MyBaseClasses.Timers.TickTimerListener;
import hu.csanyzeg.master.MyBaseClasses.Timers.Timer;
import hu.csanyzeg.master.MyBaseClasses.UI.MyLabel;

public class PszichiaterStage extends SimpleWorldStage {

    public final static String BACKGROUND = "elemek/munkahatter/Pszhiatraiszolgaltatonyujtoszobakomplexumketdarabfotelalisegysurmovalakinemtudjamiaz.png";
    public final static String ui = "elemek/table.png";
    public final static String answer = "elemek/table2.png";
    public final static String bal1 = "elemek/jegyzetA.png";
    public final static String jobb1 = "elemek/jegyzetB.png";

    public static AssetList assetList = new AssetList();
    static {
        assetList.addTexture(BACKGROUND);
        assetList.addTexture(ui);
        assetList.addTexture(answer);
        assetList.addTexture(bal1);
        assetList.addTexture(jobb1);
        assetList.addFont(GameStage.FONT, 60, Color.WHITE).protect = true;
    }

    OneSpriteStaticActor table;
    OneSpriteStaticActor answA;
    OneSpriteStaticActor answB;
    OneSpriteStaticActor bal;
    OneSpriteStaticActor jobb;
    String[] text;
    //String[][] actuallyText;
    int hanyadik;
    ArrayList[][] actuallyText = new ArrayList[1000][1000];
    MyLabel kerdes;
    MyLabel val1;
    MyLabel val2;
    MyLabel eredmeny;
    MyLabel eredmeny2;
    String storyline = "START";
    boolean ready;
    MyLabel nev;
    public static int penz;
    public static boolean van;


    public PszichiaterStage(final MyGame game) {
        super(new ResponseViewport(720f), game);
        Label.LabelStyle ls = new Label.LabelStyle();
        ls.font = game.getMyAssetManager().getFont(GameStage.FONT);
        ls.fontColor = Color.WHITE;

        addBackButtonListener(new BackButtonListener() {
            @Override
            public void backKeyDown() {
                game.setScreenWithPreloadAssets(GameScreen.class, new LoadingCsakJobbScreen(game));
            }
        });

        eredmeny = new MyLabel(game, "10/9", ls) {
            @Override
            public void init() {

            }
        };
        eredmeny.setFontScale(2f);
        eredmeny.setPosition(getViewport().getWorldWidth()/2-getViewport().getWorldWidth()/6,getViewport().getWorldHeight()/2);
        addActor(eredmeny,100);

        eredmeny2 = new MyLabel(game, "+20 pénz", ls) {
            @Override
            public void init() {

            }
        };
        eredmeny2.setFontScale(1f);
        eredmeny2.setPosition(getViewport().getWorldWidth()/2-getViewport().getWorldWidth()/6,getViewport().getWorldHeight()/2-eredmeny.getHeight()*1.5f);
        addActor(eredmeny2,100);
        eredmeny2.setVisible(false);
        eredmeny.setVisible(false);

        OneSpriteStaticActor BackGround = new OneSpriteStaticActor(game, BACKGROUND);
        BackGround.setSize(getWidth(),getHeight());
        addActor(BackGround);

        nev = new MyLabel(game, "x", ls) {
            @Override
            public void init() {

            }
        };
        nev.setFontScale(1);
        nev.setPosition(0,getViewport().getWorldHeight()-nev.getHeight());
        addActor(nev);

        table = new OneSpriteStaticActor(game, ui);
        table.setSize(getWidth()/1.3f,getHeight()/18);
        table.setPosition(getViewport().getWorldWidth()/2-table.getWidth()/2,getViewport().getWorldHeight()/1.2f);
        addActor(table);

        answA = new OneSpriteStaticActor(game, answer);
        answA.setSize(getWidth()/1.3f,getHeight()/15);
        answA.setPosition(getViewport().getWorldWidth()/2-(answA.getWidth()/2),table.getY()-answA.getHeight()*2);
        addActor(answA);
        answA.setVisible(false);

        answB = new OneSpriteStaticActor(game, answer);
        answB.setSize(getWidth()/1.3f,getHeight()/15);
        answB.setPosition(getViewport().getWorldWidth()/2-(answB.getWidth()/2),answA.getY()-answB.getHeight()*2);
        addActor(answB);
        answB.setVisible(false);

        FileHandle handle = Gdx.files.internal("text.txt");
        text = handle.readString().split("START#");

        kerdes = new MyLabel(game, "x", ls) {
            @Override
            public void init() {

            }
        };
        kerdes.setFontScale(0.6f);
        kerdes.setPosition(table.getX()*1.4f,table.getY()+table.getHeight()-kerdes.getHeight());
        kerdes.setOrigin(0,kerdes.getHeight());
        addActor(kerdes);

        val1 = new MyLabel(game, "x", ls) {
            @Override
            public void init() {

            }
        };
        val1.setFontScale(0.6f);
        val1.setPosition(answA.getX()*1.4f,answA.getY()+answA.getHeight()-val1.getHeight());
        addActor(val1);
        val1.setVisible(false);

        val2 = new MyLabel(game, "x", ls) {
            @Override
            public void init() {

            }
        };
        val2.setFontScale(0.6f);
        val2.setPosition(answB.getX()*1.4f,answB.getY()+answB.getHeight()-val2.getHeight());
        addActor(val2);
        val2.setVisible(false);

        bal = new OneSpriteStaticActor(game, bal1);
        bal.setSize(getViewport().getWorldWidth()/2,getViewport().getWorldWidth()/2);
        bal.setPosition(getWidth()/2-getWidth()/2.3f,getHeight()/2-getHeight()/2.15f);
        addActor(bal);
        bal.setVisible(false);
        bal.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                storyline = lehetoseg1;
                holtart = hol1;
                reset();
                next();
            }
        });

        jobb = new OneSpriteStaticActor(game, jobb1);
        jobb.setSize(getViewport().getWorldWidth()/2,getViewport().getWorldWidth()/2);
        jobb.setPosition(getWidth()/2+getWidth()/2.3f-getWidth()/2.4f,getHeight()/2-getHeight()/2.15f);
        addActor(jobb);
        jobb.setVisible(false);
        jobb.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                storyline = lehetoseg2;
                holtart = hol2;
                reset();
                next();
            }
        });


        //UTOLSÓ LEGYEN
        ujStory();

    }

    void vege(){
        eredmeny2.setVisible(true);
        eredmeny.setVisible(true);
        eredmeny.setText("10/"+(actuallyText[holtart][3].toString().replace("[","").replace("]","")));
        penz = MathUtils.random(Integer.parseInt(actuallyText[holtart][3].toString().replace("[","").replace("]",""))*10,Integer.parseInt(actuallyText[holtart][3].toString().replace("[","").replace("]",""))*14);
        eredmeny2.setText("+"+penz+" pénz");
        TickTimer g = new TickTimer(1, false, new TickTimerListener() {

            @Override
            public void onStop(Timer sender) {
                super.onStop(sender);
                van = true;
                game.setScreenWithPreloadAssets(GameScreen.class, new LoadingCsakJobbScreen(game));
            }
        });
        addTimer(g);
    }

    int maxkerdes = 27;
    boolean q = false;
    boolean qw1 = false;
    boolean qw2 = false;

    String[] seged1;

    void reset(){
        val1.setVisible(false);
        val2.setVisible(false);
        answA.setVisible(false);
        answB.setVisible(false);
        bal.setVisible(false);
        jobb.setVisible(false);
        kerdes.setText("");
        val2.setText("");
        val1.setText("");
    }

    void ujStory(){

        hanyadik = MathUtils.random(1,text.length-1);
        //hanyadik = 2;
        seged1 = text[hanyadik].split(";");
        for (int i = 0;i<seged1.length-1;i++){
            for (int k = 0;k < 4; k++){
                actuallyText[i][k] = new ArrayList();
                actuallyText[i][k].add((seged1[i].split("#")[k]+""));
            }
        }


        next();
    }

    int holtart=0;
    int hol1 = 0;
    int hol2 = 0;
    String lehetoseg1 = "";
    String lehetoseg2 = "";
    boolean setnev = true;

    void next(){
        answA.setPosition(0-(answA.getWidth()),table.getY()-answA.getHeight()*2);
        if(storyline == "START"){holtart = 0;storyline="";}
        if(setnev){
        String neev = (actuallyText[holtart][0].toString()+"  ("+actuallyText[holtart][1].toString()+")").replace("[","");
        neev = neev.replace("]","");
        nev.setText(neev); setnev = false;}
        table.setSize(getWidth()/1.3f,getHeight()/18);
        table.setPosition(getViewport().getWorldWidth()/2-table.getWidth()/2,getViewport().getWorldHeight()/1.2f);
        answA.setSize(getWidth()/1.3f,getHeight()/15);
        answA.setPosition(getViewport().getWorldWidth()/2-(answA.getWidth()/2),table.getY()-answA.getHeight()*2);
        answB.setSize(getWidth()/1.3f,getHeight()/15);
        answB.setPosition(getViewport().getWorldWidth()/2-(answB.getWidth()/2),answA.getY()-answB.getHeight()*2);
        kerdes.setPosition(table.getX()*1.4f,table.getY()+table.getHeight()-kerdes.getHeight());
        val1.setPosition(answA.getX()*1.4f,answA.getY()+answA.getHeight()-val1.getHeight());
        val2.setPosition(answB.getX()*1.4f,answB.getY()+answB.getHeight()-val2.getHeight());
        kerdesKiir(actuallyText[holtart][2].toString());
    }

    String[] mondat;

    void kerdesKiir(String s){
        s = s.replace("[","");
        s = s.replace("]","");
        mondat = s.split(" ");
        kerdes.setText("");
        q = true;
    }

    void valaszKiir(){
        lehetoseg1 = storyline+"0";
        answA.setPosition(getViewport().getWorldWidth()/2-(answA.getWidth()/2),table.getY()-answA.getHeight()*2);
        val1.setPosition(answA.getX()*1.4f,answA.getY()+answA.getHeight()-val1.getHeight());
        val1.setText("A: ");
        val1.setVisible(true);
        answA.setVisible(true);
        qw1 = true;
        calc(lehetoseg1);
        hol1 = holtart;
        String lol = actuallyText[holtart][1].toString().replace("[","");
        lol = lol.replace("]","");
        mondat = lol.split(" ");
    }

    void valaszKiir2(){
        lehetoseg2 = storyline+"1";
        answB.setPosition(getViewport().getWorldWidth()/2-(answB.getWidth()/2),answA.getY()-answB.getHeight()*2);
        val2.setPosition(answB.getX()*1.4f,answB.getY()+answB.getHeight()-val2.getHeight());
        val2.setText("B: ");
        val2.setVisible(true);
        answB.setVisible(true);
        qw2 = true;
        calc(lehetoseg2);
        hol2 = holtart;
        String lol = actuallyText[holtart][1].toString().replace("[","");
        lol = lol.replace("]","");
        mondat = lol.split(" ");
    }

    void calc(String d){
        d = "xd"+d+"xd";
        String lol = "";
        for(int i = 0; i < seged1.length-1;i++){
            lol = actuallyText[i][0].toString().replace("[","");
            lol = lol.replace("]","");
            lol = lol.replace("\r\n","");
            lol = "xd"+lol+"xd";
            if(lol.contains(d)){
                holtart = i;
            }
        }
    }

    int w = 0;
    int i = 0;
    int k = 0;
    int sor = 0;
    boolean once = true;
    float h2;
    float h1;

    public void act(float delta) {
        if(once){
        h1 = table.getHeight()*0.8f;
        h2 = answA.getHeight()*0.8f;}
        super.act(delta);
        if(q){
            int tomb = mondat.length;
            w++;
            if(w%3==0){
                if(i < tomb){
                    if(k < mondat[i].length()){
                        kerdes.setText(kerdes.getText()+""+mondat[i].toCharArray()[k]);
                        k++;
                        sor++;
                    }
                    else{
                        kerdes.setText(kerdes.getText()+" ");
                        i++;
                        k=0;
                        if (i < tomb){
                        if(sor+mondat[i].length()>maxkerdes){
                            sor=0;
                            kerdes.setText(kerdes.getText()+"\r\n");
                            kerdes.setY(kerdes.getY()-kerdes.getHeight()/4.25f);
                            table.setHeight(table.getHeight()+h1/2);
                            table.setY(table.getY()-h1/2);
                        }}


                    }

                }
                else{
                    i=0;
                    k=0;
                    w=0;
                    sor = 0;
                    q=false;
                    if(actuallyText[holtart][3].toString().contains(".")){
                        valaszKiir();
                    }
                    else {
                        vege();
                    }
                }
            }
        }


        if(qw1){
            int tomb = mondat.length;
            w++;
            if(w%3==0){
                if(i < tomb){
                    if(k < mondat[i].length()){
                        val1.setText(val1.getText()+""+mondat[i].toCharArray()[k]);
                        k++;
                        sor++;
                    }
                    else{
                        val1.setText(val1.getText()+" ");
                        i++;
                        k=0;
                        if (i < tomb){
                            if(sor+mondat[i].length()>maxkerdes){
                                sor=0;
                                val1.setText(val1.getText()+"\r\n");
                                val1.setY(val1.getY()-kerdes.getHeight()/4.25f);
                                answA.setHeight(answA.getHeight()+h2/2);
                                answA.setY(answA.getY()-h2/2);
                            }}


                    }

                }
                else{
                    i=0;
                    k=0;
                    w=0;
                    sor = 0;
                    qw1=false;
                    valaszKiir2();
                }
            }
        }

        if(qw2){
            int tomb = mondat.length;
            w++;
            if(w%3==0){
                if(i < tomb){
                    if(k < mondat[i].length()){
                        val2.setText(val2.getText()+""+mondat[i].toCharArray()[k]);
                        k++;
                        sor++;
                    }
                    else{
                        val2.setText(val2.getText()+" ");
                        i++;
                        k=0;
                        if (i < tomb){
                            if(sor+mondat[i].length()>maxkerdes){
                                sor=0;
                                val2.setText(val2.getText()+"\r\n");
                                val2.setY(val2.getY()-kerdes.getHeight()/4.25f);
                                answB.setHeight(answB.getHeight()+h2/2);
                                answB.setY(answB.getY()-h2/2);
                            }}


                    }

                }
                else{
                    i=0;
                    k=0;
                    w=0;
                    sor = 0;
                    w=0;
                    qw2=false;
                    ready = true;
                    bal.setVisible(true);
                    jobb.setVisible(true);
                }
            }
        }
    }
}
