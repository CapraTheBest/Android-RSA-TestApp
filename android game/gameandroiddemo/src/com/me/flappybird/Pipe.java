package com.me.flappybird;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.forever;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pipe extends Image {

	private boolean getScore;
	private Chim bird;
	public static int PIPE_HIT;

	public Pipe(TextureRegion region, Chim bird, boolean getScore) {
		super(region);
		this.bird = bird;
		this.getScore = getScore;
		actionmoveLeft();
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (bird.isDie) {
			clearActions();
			return;
		}
		if (getX() < -getWidth()) {
			remove();
		}
		addScore();
		checkcolistion();
	}

	public static int getPIPE_HIT() {
		return PIPE_HIT;
	}

	public static void setPIPE_HIT(int pIPE_HIT) {
		PIPE_HIT = pIPE_HIT;
	}

	public void actionmoveLeft() {
		MoveByAction moveLeft = new MoveByAction();
		moveLeft.setDuration(config.KmoveLeftDura);
		moveLeft.setAmountX(-config.KlandWidth);
		addAction(forever(moveLeft));
	}

	public void addScore() {
		if (getX() <= bird.getX()) {
			if (bird.getY() >= Flappybird.VIEWPORT.y) {
				bird.hitMe();
				Screenplay.land.clearActions();
				Flappybird.Sounds.get(config.SoundsHit).play();
			}
			if (getScore) {
				getScore = false;
				bird.updateScore();
				Flappybird.Sounds.get(config.SoundsScore).play();
			}
		}
	}

	public void checkcolistion() {
		if (iscolistion()) {
			PIPE_HIT = 0;
			bird.hitMe();
			Screenplay.land.clearActions();
			Flappybird.Sounds.get(config.SoundsHit).play();
		}
	}

	public boolean iscolistion() {
		float d = 2;
		float maxx1 = getX() + getWidth();
		float minx1 = getX() + d;
		float maxy1 = getY() + getHeight();
		float miny1 = getY() + d;
		float maxx2 = bird.getX() + bird.getWidth();
		float minx2 = bird.getX() + d;
		float maxy2 = bird.getY() + bird.getHeight();
		float miny2 = bird.getY() + d;
		return !(maxx1 < minx2 || maxx2 < minx1 || maxy2 < miny1 || maxy1 < miny2);
	}

}
