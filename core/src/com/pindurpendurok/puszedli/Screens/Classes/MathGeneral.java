package com.pindurpendurok.puszedli.Screens.Classes;

import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.Random;

public class MathGeneral {

    public String feladvany;
    float egyik;
    float egyik2;
    float masik;
    float masik2;
    float jomegoldas;
    Random rnd = new Random();

    public String left = "";
    public String right = "";
    public String goodanswer = "";

    public MathGeneral(){

    }
    int megismelyik;
    int x = 2;
    public void ujfeladvany(int verzio){
        //x = GameStage.save.getInteger("ev")-2000;
        x = 2;

        if(verzio == 4){
            feladvany = "Melyik a nagyobb?";
            //megismelyik = rnd.nextInt(6); //0 sima || 1 osszeadas || 2 kivonas || 3 szorzas || 4 osztas || 5 negyzet || 6 gyok
            megismelyik = 2;
            if(megismelyik == 0){
                egyik = rnd.nextInt(15*x)+1;
                megismelyik = rnd.nextInt(1);
                if(megismelyik == 0){masik = egyik + (rnd.nextInt(2*x)+1); jomegoldas = masik;}
                else {masik = egyik - (rnd.nextInt(2*x)+1); jomegoldas = egyik;}
                left = egyik+"";
                right = masik+"";
                goodanswer = jomegoldas+"";
            }
            else if(megismelyik == 1){
                nagyobb_osszeadas();
            }
            else if(megismelyik == 2){
                nagyobb_kivonas();
            }
            else if(megismelyik == 3){
                nagyobb_szorzas();
            }
            else if(megismelyik == 4){
                nagyobb_osztas();
            }
            else if(megismelyik == 5){
                nagyobb_negyzet();
            }
        }
        left = left.replace(".0","");
        right = right.replace(".0","");
        goodanswer = goodanswer.replace(".0","");
    }

    void nagyobb_seged(){
        egyik = rnd.nextInt(15*x)+1;
        egyik2 = rnd.nextInt(15*x)+1;
        megismelyik = rnd.nextInt(4);
        if(megismelyik == 0){masik = egyik + (rnd.nextInt(2*x)+1);masik2 = egyik2 + (rnd.nextInt(2*x)+1);}
        if(megismelyik == 1){masik = egyik - (rnd.nextInt(2*x)+1);masik2 = egyik2 + (rnd.nextInt(2*x)+1);}
        if(megismelyik == 2){masik = egyik + (rnd.nextInt(2*x)+1);masik2 = egyik2 - (rnd.nextInt(2*x)+1);}
        else {masik = egyik - (rnd.nextInt(2*x)+1);masik2 = egyik2 - (rnd.nextInt(2*x)+1);}
    }

    void nagyobb_osszeadas(){
        nagyobb_seged();
        left = egyik+"+"+egyik2;
        right = masik+"+"+masik2;
        if(egyik+egyik2 > masik2+masik)goodanswer = egyik+"+"+egyik2;
        else if(egyik+egyik2 < masik2+masik)goodanswer = masik+"+"+masik2;
        else nagyobb_osszeadas();
    }

    void nagyobb_kivonas(){
        nagyobb_seged();
        left = egyik+"-"+egyik2;
        right = masik+"-"+masik2;
        if(egyik-egyik2 > masik2-masik)goodanswer = egyik+"-"+egyik2;
        else if(egyik-egyik2 < masik2-masik)goodanswer = masik+"-"+masik2;
        else nagyobb_kivonas();
    }

    void nagyobb_szorzas(){
        left = egyik+"x"+egyik2;
        right = masik+"x"+masik2;
        nagyobb_seged();
        if(egyik*egyik2 > masik2*masik)goodanswer = egyik+"x"+egyik2;
        else if(egyik*egyik2 < masik2*masik)goodanswer = masik+"x"+masik2;
        else nagyobb_szorzas();
    }

    void nagyobb_osztas(){
        nagyobb_seged();
        left = egyik+"/"+egyik2;
        right = masik+"/"+masik2;
        if(egyik/egyik2 > masik2/masik)goodanswer = egyik+"/"+egyik2;
        else if(egyik/egyik2 < masik2/masik)goodanswer = masik+"/"+masik2;
        else nagyobb_osztas();
    }

    void nagyobb_negyzet(){
        nagyobb_seged();
        left = egyik+"^"+egyik2;
        right = masik+"^"+masik2;
        if(Math.pow(egyik,egyik2) > Math.pow(masik2,masik))goodanswer = egyik+"^"+egyik2;
        else if(Math.pow(egyik,egyik2) < Math.pow(masik2,masik))goodanswer = masik+"^"+masik2;
        else nagyobb_negyzet();
    }
}
