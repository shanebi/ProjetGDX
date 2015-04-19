package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Classe main du programme
 * @author trynobass
 *
 */
public class MyGdxGame extends Game {
	@Override
	public void create () {
		setScreen(new InterfaceScreen(this));
	}

}