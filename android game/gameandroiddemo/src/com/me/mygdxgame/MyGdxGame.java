package com.me.mygdxgame;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	

	@Override
	public void create() {
		setScreen(new Playstate(this, "MainMenu Screen"));
	}
}
