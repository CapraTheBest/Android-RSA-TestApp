package com.me.analog;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class AnalogTouch implements ApplicationListener {

	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;
	private Texture boxTexture;
	private Sprite boxSprite;
	private Touchpad touchpad;
	private TouchpadStyle touchpadStyle;
	private Skin toupadskin;
	private Drawable toubackground;
	private Drawable touknob;
	private Stage stage;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		float aspectRatio = (float) Gdx.graphics.getWidth()
				/ (float) Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 10 * aspectRatio, 10);
		toupadskin = new Skin();
		toupadskin.add("toubackground", new Texture(
				"data/onscreen_control_base.png"));
		toupadskin
				.add("touknob", new Texture("data/onscreen_control_knob.png"));
		touchpadStyle = new TouchpadStyle();
		toubackground = toupadskin.getDrawable("toubackground");
		touknob = toupadskin.getDrawable("touknob");
		touchpadStyle.background = toubackground;
		touchpadStyle.knob = touknob;
		touchpad = new Touchpad(10, touchpadStyle);
		touchpad.setBounds(15, 15, 120, 120);
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true, spriteBatch);
		stage.addActor(touchpad);
		Gdx.input.setInputProcessor(stage);
		boxTexture = new Texture(Gdx.files.internal("data/face_box.png"));
		boxSprite = new Sprite(boxTexture);
		boxSprite.setPosition(
				Gdx.graphics.getWidth() / 2 - boxSprite.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - boxSprite.getHeight() / 2);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		camera.update();
		boxSprite.setX(boxSprite.getX() + touchpad.getKnobPercentX() * 3);
		boxSprite.setY(boxSprite.getY() + touchpad.getKnobPercentY() * 3);
		if (boxSprite.getX() < 0) {
			boxSprite.setX(Gdx.graphics.getWidth());
		} else if (boxSprite.getX() > Gdx.graphics.getWidth()) {
			boxSprite.setX(0);
		} else if (boxSprite.getY() < 0) {
			boxSprite.setY(Gdx.graphics.getHeight());
		} else if (boxSprite.getY() > Gdx.graphics.getHeight()) {
			boxSprite.setY(0);
		}
		spriteBatch.begin();
		boxSprite.draw(spriteBatch);
		spriteBatch.end();
		stage.act();
		stage.draw();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
