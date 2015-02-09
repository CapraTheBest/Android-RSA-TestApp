package com.me.flappybird;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Chim extends Image {

	public int score;
	private Action curAction;
	Animation animation;
	TextureRegion curFrame;
	float dura;
	boolean isDie, TapPipe;

	public Chim(TextureRegion[] regions) {
		super(regions[0]);
		setOrigin(getWidth() / 2, getHeight() / 2);
		animation = new Animation(0.03f, regions);
		dura = 0;
		isDie = false;
		TapPipe = false;
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (isDie) {
			return;
		}
		dura += delta;
		curFrame = animation.getKeyFrame(dura, true);
		setDrawable(new TextureRegionDrawable(curFrame));
	}

	public void Tapme() {
		removeAction(curAction);
		TapPipe = true;
		float y = getY() + config.KjumpHeight;
		RotateToAction faceup = new RotateToAction();
		faceup.setDuration(config.KjumpDura);
		faceup.setRotation(30);
		MoveToAction moveup = new MoveToAction();
		moveup.setDuration(config.KjumpDura);
		moveup.setPosition(getX(), y);
		moveup.setInterpolation(Interpolation.sineIn);
		Action fly = new ParallelAction(faceup, moveup);
		RotateToAction faceDown = new RotateToAction();
		float duration = getDuraDown(y, config.KlandHeight);
		faceDown.setDuration(duration);
		faceDown.setRotation(-90);
		MoveToAction moveDown = new MoveToAction();
		moveDown.setDuration(duration);
		moveDown.setPosition(getX(), config.KlandHeight);
		moveDown.setInterpolation(Interpolation.sineIn);
		Action fall = new ParallelAction(faceDown, moveDown);
		curAction = new SequenceAction(fly, fall);
		addAction(curAction);
	}

	public void hitMe() {
		isDie = true;
		removeAction(curAction);
		RotateToAction faceDown = new RotateToAction();
		faceDown.setDuration(config.KjumpDura);
		faceDown.setRotation(-90);
		MoveToAction moveDown = new MoveToAction();
		moveDown.setDuration(getDuraDown(getX(), config.KlandHeight));
		moveDown.setPosition(getX(), config.KlandHeight);
		moveDown.setInterpolation(Interpolation.sineIn);
		curAction = new SequenceAction(faceDown, moveDown);
		addAction(curAction);
	}
	
	public void hitLand() {
		isDie = true;
		removeAction(curAction);
		MoveToAction moveDown = new MoveToAction();
		moveDown.setDuration(getDuraDown(getX(), config.KlandHeight));
		moveDown.setPosition(getX(), config.KlandHeight);
		moveDown.setInterpolation(Interpolation.sineIn);
		curAction = new SequenceAction(moveDown);
		addAction(curAction);
	}

	public boolean isTapPipe() {
		return TapPipe;
	}

	public void updateScore() {
		score += 1;
		Screenplay.labelScore.setText("" + score);
	}

	public float getDuraDown(float up, float down) {
		float dy = up - down;
		float Dura;

		if (dy <= config.KjumpHeight) {
			Dura = config.KjumpDura;
		} else {
			Dura = 0.8f;
		}
		return Dura;
	}

}
