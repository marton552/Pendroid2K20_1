package com.pindurpendurok.puszedli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.pindurpendurok.puszedli.Puzzle.PuzzleScreen;
import com.pindurpendurok.puszedli.Puzzle.PuzzleStage;
import com.pindurpendurok.puszedli.Screens.Bell.BellScreen;
import com.pindurpendurok.puszedli.Screens.Favago.FavagoScreen;
import com.pindurpendurok.puszedli.Screens.Foci.FociScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameScreen;
import com.pindurpendurok.puszedli.Screens.Game.GameStage;
import com.pindurpendurok.puszedli.Screens.GameLoadingStage;
import com.pindurpendurok.puszedli.Screens.Guess.GuessScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PapWorldScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PszichiaterScreen;
import com.pindurpendurok.puszedli.Screens.JobsGame.PszichiaterStage;
import com.pindurpendurok.puszedli.Screens.MiniGame.MathGameScreen;
import com.pindurpendurok.puszedli.Screens.Porno.PornoScreen;
import com.pindurpendurok.puszedli.Screens.Rocking.RockingScreen;
import com.pindurpendurok.puszedli.Screens.Shake.ShakeScreen;
import com.pindurpendurok.puszedli.Screens.Test.TestScreen;
import com.pindurpendurok.puszedli.Screens.Trash.TrashScreen;
import com.pindurpendurok.puszedli.Screens.Wow.WowScreen;

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
