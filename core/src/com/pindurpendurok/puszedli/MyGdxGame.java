package com.pindurpendurok.puszedli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.GameLoadingStage;

import hu.csanyzeg.master.MyBaseClasses.Game.MyGame;

public class MyGdxGame extends MyGame {

	public MyGdxGame(boolean debug) { super(debug); }

	public MyGdxGame() {

	}

	public Preferences save;

	@Override
	public void create() {
		super.create();
		setLoadingStage(new GameLoadingStage(this));
		setScreen(new GameScreen(this));

		save = Gdx.app.getPreferences("gameSave");

		if(save.contains("inditas")){
			save.putFloat("inditas",(save.getFloat("inditas")+1));
		}else{
			save.putInteger("ev",2001);
			save.putInteger("honap",7);
			save.putInteger("nap",23);
		}
		save.flush();
	}
}
