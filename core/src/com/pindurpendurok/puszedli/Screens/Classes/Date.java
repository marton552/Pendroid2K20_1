package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.Game;
import com.pindurpendurok.puszedli.MyGdxGame;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;

import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

public class Date {
    public int ev = 1;
    public int honap = 1;
    public int nap = 1;
    GameStage gs;
    public Date(GameStage gg){
        gs = gg;
    }

    public void leptetes(){
        ev = gs.save.getInteger("ev");
        honap = gs.save.getInteger("honap");
        nap = gs.save.getInteger("nap");
        nap++;

        //szökőév kezelés így az elején
        if(ev%4==0 && (ev%100!=0 || ev%400==0) && honap == 2){
            if(nap==30){
                nap = 1;
                honap++;
            }
        }
        else if(honap == 2){
            if(nap == 29){
                nap = 1;
                honap++;
            }
        }

        //napról hónapra váltás
        else if(honap == 1 || honap == 3 || honap == 5 || honap == 7 || honap == 8 || honap == 10 || honap == 12){
            if(nap==32){
                nap = 1;
                honap++;
            }
        }
        else if(honap == 4 || honap == 3 || honap == 6 || honap == 9 || honap == 11){
            if(nap==31){
                nap = 1;
                honap++;
            }

        }

        if(honap == 13){
            honap = 1;
            ev++;
        }
        gs.save.putInteger("ev",ev);
        gs.save.putInteger("honap",honap);
        gs.save.putInteger("nap",nap);
        gs.save.flush();
    }

    public String getMonth(int m){
        String s = "hónapok";
        if(m == 1)s = "Januar";
        else if(m == 2)s = "Februar";
        else if(m == 3)s = "Marcius";
        else if(m == 4)s = "Aprilis";
        else if(m == 5)s = "Majus";
        else if(m == 6)s = "Junius";
        else if(m == 7)s = "Julius";
        else if(m == 8)s = "Augusztus";
        else if(m == 9)s = "Szeptember";
        else if(m == 10)s = "Oktober";
        else if(m == 11)s = "November";
        else s = "December";
        return s;
    }
}
