package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;

public abstract class Gamescreen implements Screen {

	Game game;
	private Stage stage;
	private String screename = "Untitled Screen";
	private float startime = System.nanoTime();
	public static float SECONT_TIME = 0;
	private float statetime = 0;
	private boolean isbackbutton = false;

	public Gamescreen(Game game, String screename) {
		super();
		this.game = game;
		if (screename.equals("")) {
			this.screename = "Untitled Screen";
		} else {
			this.screename = screename;
		}
		stage = new Stage(0, 0, false);
		stage.getCamera().position.set(0 / 2, 0 / 2, 0);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		if (System.nanoTime() - startime >= 1000000000) {
			SECONT_TIME++;
			startime = System.nanoTime();
		}
		statetime += delta;
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
		if (isbackbutton) {
			if (Gdx.input.isKeyPressed(Keys.BACK)) {
				keyBack();
			}
		}
	}

	public abstract void keyBack();

	public Game getGame() {
		return game;
	}

	public Stage getStage() {
		return stage;
	}

	public String getScreename() {
		return screename;
	}

	public void setScreename(String screename) {
		this.screename = screename;
	}

	public float getStartime() {
		return startime;
	}

	public void setStartime(float startime) {
		this.startime = startime;
	}

	public static float getSECONT_TIME() {
		return SECONT_TIME;
	}

	public static void setSECONT_TIME(float sECONT_TIME) {
		SECONT_TIME = sECONT_TIME;
	}

	public float getStatetime() {
		return statetime;
	}

	public void setStatetime(float statetime) {
		this.statetime = statetime;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setBackgroundTexture(TextureRegion region) {
		Drawable tBg = new TextureRegionDrawable(region);
		Image img = new Image(tBg, Scaling.stretch);
		img.setFillParent(true);
		stage.addActor(img);
	}
	
	public void setButtonback(boolean isbackbutton) {
		Gdx.input.setCatchBackKey(true);
		this.isbackbutton = isbackbutton;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

}
