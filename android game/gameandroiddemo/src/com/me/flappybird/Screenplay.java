package com.me.flappybird;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class Screenplay implements Screen {

	private TextureAtlas Atlas;
	private Stage stage;
	public Chim bird;
	public static Land land;
	public static Label labelScore;
	private float duraTimepipe;

	public Screenplay(Flappybird game) {
		stage = new Stage();
		game.manager.load("data/flappy.txt", TextureAtlas.class);
		game.manager.finishLoading();
		Atlas = game.manager.get("data/flappy.txt", TextureAtlas.class);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.justTouched()) {
			if (bird.isDie) {
				resetGame();
			} else {
				bird.Tapme();
				Flappybird.Sounds.get(config.SoundsJump).play();
			}
		}
		duraTimepipe += delta;
		if (duraTimepipe > config.KtimeAddPipe) {
			if (bird.isTapPipe()) {
				duraTimepipe = 0;
				addPipe();
			}
		}
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(Flappybird.VIEWPORT.x, Flappybird.VIEWPORT.y);
	}

	@Override
	public void show() {
		resetGame();
	}

	public void resetGame() {
		stage.clear();
		Pipe.setPIPE_HIT(1);
		addBackground();
		addBird();
		addScore();
		addLand();
	}

	public void addBird() {
		TextureRegion[] birdRegions = new TextureRegion[] {
				Atlas.findRegion("bird1"), Atlas.findRegion("bird2"),
				Atlas.findRegion("bird3") };
		bird = new Chim(birdRegions);
		bird.setPosition(Flappybird.VIEWPORT.x / 2 - bird.getWidth(),
				Flappybird.VIEWPORT.y / 2);
		stage.addActor(bird);
	}

	public void addBackground() {
		Image bg = new Image(Atlas.findRegion("background"));
		stage.addActor(bg);
	}

	public void addScore() {
		LabelStyle style = new LabelStyle();
		style.font = new BitmapFont(Gdx.files.internal("data/flappyfont.fnt"),
				Gdx.files.internal("data/flappyfont.png"), false);
		labelScore = new Label("0", style);
		labelScore.setPosition(
				Flappybird.VIEWPORT.x / 2 - labelScore.getWidth() / 2,
				Flappybird.VIEWPORT.y - labelScore.getHeight());
		stage.addActor(labelScore);
	}

	public void addPipe() {
		int r = config.random(0, 7);
		float dy = r * 10;
		r = config.random(0, 1);
		if (r == 0) {
			dy = -dy;
		}
		Pipe pipe1 = new Pipe(Atlas.findRegion("pipe1"), bird, true);
		pipe1.setZIndex(1);
		float x = Flappybird.VIEWPORT.x;
		float y = (Flappybird.VIEWPORT.y - config.KlandHeight) / 2
				+ config.KlandHeight + config.KholeBetwenPipe / 2;
		pipe1.setPosition(x, y + dy);
		Pipe pipe2 = new Pipe(Atlas.findRegion("pipe2"), bird, false);
		pipe2.setZIndex(1);
		y = (Flappybird.VIEWPORT.y - config.KlandHeight) / 2
				+ config.KlandHeight - pipe2.getHeight()
				- config.KholeBetwenPipe / 2;
		pipe2.setPosition(x, y + dy);
		stage.addActor(pipe1);
		stage.addActor(pipe2);
		labelScore.setZIndex(pipe1.getZIndex());
		land.setZIndex(pipe2.getZIndex());
		bird.setZIndex(pipe2.getZIndex());
	}

	public void addLand() {
		land = new Land(Atlas.findRegion("land"), bird);
		stage.addActor(land);
	}

	@Override
	public void dispose() {
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
