package com.me.flappybird;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Mystate extends Stage {

	Screenplay screenplay;

	public Mystate(float width, float height, boolean keepAspectRatio) {
		super(width, height, keepAspectRatio);
		// TODO Auto-generated constructor stub
	}

	public void setScreenplay(Screenplay screenplay) {
		this.screenplay = screenplay;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (screenplay != null) {
			if (screenplay.bird.isDie) {
				screenplay.resetGame();
			} else {
				screenplay.bird.Tapme();
			}
		}
		return super.touchDown(screenX, screenY, pointer, button);
	}

}
