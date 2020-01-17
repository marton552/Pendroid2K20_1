package com.pindurpendurok.puszedli.Screens.Classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import hu.csanyzeg.master.MyBaseClasses.SimpleWorld.SimpleWorldStage;

    public class Get {
        public Get(){

        }

        static float world_width;
        static float world_height;
        public static float Width(SimpleWorldStage game){
            world_width = game.getViewport().getWorldWidth();
            return world_width;
        }
        public static float Height(SimpleWorldStage game){
            world_height = game.getViewport().getWorldHeight();
            return world_height;
        }
        public static float Width(SimpleWorldStage game, int Szelesseg_osztoja){
            world_width = game.getViewport().getWorldWidth()/(float)Szelesseg_osztoja;
            return world_width;
        }
        public static float Height(SimpleWorldStage game, int Magassag_osztoja){
            world_height = game.getViewport().getWorldHeight()/(float)Magassag_osztoja;
            return world_height;
        }

    }

