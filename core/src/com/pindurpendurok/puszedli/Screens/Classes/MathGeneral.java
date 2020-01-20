package com.pindurpendurok.puszedli.Screens.Classes;

import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import java.util.Random;

public class MathGeneral {

    public String feladvany="";
    float egyik;
    float egyik2;
    float masik;
    float masik2;
    float jomegoldas;
    Random rnd = new Random();

    public String left = "";
    public String right = "";
    public String goodanswer = "";

    public boolean bale = true;

    public MathGeneral() {

    }

    int megismelyik;
    int x = 0;
    public void ujfeladvany(int verzio){
        //x = GameStage.save.getInteger("ev")-2000;
        x = 50;

        if(verzio == 4){
            feladvany = "Melyik a nagyobb?";
            megismelyik = rnd.nextInt(6); //0 sima || 1 osszeadas || 2 kivonas || 3 szorzas || 4 osztas || 5 negyzet || 6 gyok
            //megismelyik = 0;
            if(megismelyik == 0){
                //melyik nagyobb?
                egyik = rnd.nextInt(15*x)+1;
                megismelyik = rnd.nextInt(1);
                if(megismelyik == 0){masik = egyik + (rnd.nextInt(2*x)+1); jomegoldas = masik; bale=false;}
                else {masik = egyik - (rnd.nextInt(2*x)+1); jomegoldas = egyik;bale=true;}
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
        else if(verzio == 5){
            osszeadas_seged();
            feladvany = egyik+"+"+masik+"=?";
            egyik2 = egyik+masik;
            szamoloscuccok();
        }

        else if(verzio == 6){
            osszeadas_seged();
            feladvany = egyik+"-"+masik+"=?";
            egyik2 = egyik-masik;
            szamoloscuccok();
        }
        else if(verzio == 7){
            szorzas_seged_seged();
            feladvany = egyik+"x"+masik+"=?";
            egyik2 = egyik*masik;
            szamoloscuccok();
        }
        else if(verzio == 8){
            szorzas_seged_seged();
            feladvany = egyik+"/"+masik+"=?";
            egyik2 = egyik/masik;
            szamoloscuccok();
        }
        else if(verzio == 9){
            szorzas_seged_seged();
            feladvany = egyik+"pow"+masik+"=?";
            egyik2 = (float)Math.pow(egyik,masik);
            szamoloscuccok();
        }


        if(verzio == 4){
            left = left.replace(".0","");
            right = right.replace(".0","");
            goodanswer = goodanswer.replace(".0","");
        }
        else{
            System.out.println(bale);
        if(left.length()>1)left = left.substring(0, left.length() - 2);
        if(right.length()>1)right = right.substring(0, right.length() - 2);
        if(goodanswer.length()>1)goodanswer = goodanswer.substring(0, goodanswer.length() - 2);
        feladvany = feladvany.replace(".0","");
    }}

    void szamoloscuccok(){
        goodanswer = egyik2+"";
        osszeadas_kisebbnagyobb(egyik2);
        megismelyik = rnd.nextInt(2);
        if(megismelyik == 0){egyik = egyik2; masik = masik2; bale=true;}
        else {masik = egyik2; egyik = masik2; bale=false;}
        left = egyik+"";
        right = masik+"";
    }

    void osszeadas_kisebbnagyobb(float a){
        megismelyik = rnd.nextInt(2);
        if(megismelyik == 0){masik2 = egyik2 + (rnd.nextInt(x)+1);}
        else {masik2 = egyik2 - (rnd.nextInt(x)+1);}
    }

    void szorzas_seged_seged(){
        egyik = rnd.nextInt(3*x)+1;
        megismelyik = rnd.nextInt(4);
        if(megismelyik == 0){masik = egyik + (rnd.nextInt(2*x)+1);}
        if(megismelyik == 1){masik = egyik - (rnd.nextInt(2*x)+1);}
        if(megismelyik == 2){masik = egyik + (rnd.nextInt(2*x)+1);}
        else {masik = egyik - (rnd.nextInt(2*x)+1);}
    }

    void osszeadas_seged(){
        egyik = rnd.nextInt(5*x*x)+1;
        megismelyik = rnd.nextInt(4);
        if(megismelyik == 0){masik = egyik + (rnd.nextInt(5*x)+1);}
        if(megismelyik == 1){masik = egyik - (rnd.nextInt(5*x)+1);}
        if(megismelyik == 2){masik = egyik + (rnd.nextInt(5*x)+1);}
        else {masik = egyik - (rnd.nextInt(5*x)+1);}
    }

    void nagyobb_seged_negyzet(){
        egyik = rnd.nextInt(3*x)+1;
        egyik2 = rnd.nextInt(3*x)+1;
        megismelyik = rnd.nextInt(4);
        if(megismelyik == 0){masik = egyik + (rnd.nextInt(8)+1);masik2 = egyik2 + (rnd.nextInt(2*x)+1);}
        if(megismelyik == 1){masik = egyik - (rnd.nextInt(8*x)+1);masik2 = egyik2 + (rnd.nextInt(2*x)+1);}
        if(megismelyik == 2){masik = egyik + (rnd.nextInt(8*x)+1);masik2 = egyik2 - (rnd.nextInt(2*x)+1);}
        else {masik = egyik - (rnd.nextInt(8)+1);masik2 = egyik2 - (rnd.nextInt(2*x)+1);}
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
        if(egyik+egyik2 > masik2+masik){goodanswer = egyik+"+"+egyik2;bale=true;}
        else if(egyik+egyik2 < masik2+masik){goodanswer = masik+"+"+masik2;bale=false;}
        else nagyobb_osszeadas();
    }

    void nagyobb_kivonas(){
        nagyobb_seged();
        left = egyik+"-"+egyik2;
        right = masik+"-"+masik2;
        if(egyik-egyik2 > masik-masik2){goodanswer = egyik+"-"+egyik2;bale=true;}
        else if(egyik-egyik2 < masik-masik2){goodanswer = masik+"-"+masik2;bale=false;}
        else nagyobb_kivonas();
    }

    void nagyobb_szorzas(){
        left = egyik+"x"+egyik2;
        right = masik+"x"+masik2;
        nagyobb_seged();
        if(egyik*egyik2 > masik2*masik){goodanswer = left;bale=true;}
        else if(egyik*egyik2 < masik2*masik){goodanswer = right;bale=false;}
        else nagyobb_szorzas();
    }

    void nagyobb_osztas(){
        nagyobb_seged();
        left = egyik+"/"+egyik2;
        right = masik+"/"+masik2;
        if(egyik/egyik2 > masik/masik2){goodanswer = egyik+"/"+egyik2;bale=true;}
        else if(egyik/egyik2 < masik/masik2){goodanswer = masik+"/"+masik2;bale=false;}
        else nagyobb_osztas();
    }

    void nagyobb_negyzet(){
        nagyobb_seged_negyzet();
        left = egyik+"pow"+egyik2;
        right = masik+"pow"+masik2;
        if(Math.pow(egyik,egyik2) > Math.pow(masik,masik2)){goodanswer = egyik+"pow"+egyik2;bale=true;}
        else if(Math.pow(egyik,egyik2) < Math.pow(masik,masik2)){goodanswer = masik+"pow"+masik2;bale=false;}
        else nagyobb_seged_negyzet();
    }
}
