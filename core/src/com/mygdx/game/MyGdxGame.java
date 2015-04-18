



package com.mygdx.game;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	@Override
	public void create () {
		//setScreen(new CameraScreen(this)); // Carte RTM
		setScreen(new InterfaceScreen(this)); // Interface MENU
	}

}