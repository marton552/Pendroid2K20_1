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


	@Override
	public void create() {
		super.create();
		setLoadingStage(new GameLoadingStage(this));
		setScreen(new GameScreen(this));
	}
}
