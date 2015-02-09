package com.me.flappybird;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;

public class Flappybird extends Game {
	
	public static final Vector2 VIEWPORT = new Vector2(320, 480);
	public AssetManager manager = new AssetManager();
	public static HashMap<String, Sound> Sounds = new HashMap<String, Sound>();

	@Override
	public void create() {
		Sounds.put(config.SoundsHit, Gdx.audio.newSound(Gdx.files.internal("data/sounds/sfx_hit.mp3")));
		Sounds.put(config.SoundsScore, Gdx.audio.newSound(Gdx.files.internal("data/sounds/sfx_point.mp3")));
		Sounds.put(config.SoundsJump, Gdx.audio.newSound(Gdx.files.internal("data/sounds/sfx_wing.mp3")));
		setScreen(new Screenplay(this));
	}

	@Override
	public void dispose() {
		for (String key : Sounds.keySet()) {
			Sounds.get(key).dispose();
		}
		manager.dispose();
		super.dispose();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}

}
