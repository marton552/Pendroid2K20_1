package com.pindurpendurok.puszedli.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pindurpendurok.puszedli.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		System.setProperty("user.name", "Public");

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 720/2;
		config.height = 1280/2;

		new LwjglApplication(new MyGdxGame(true), config);
	}
}
