package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public abstract class abstractbutton extends Button {

	protected boolean isLockActive = false;
	protected TextureRegion lockRegion;
	protected boolean isTextActive = false;
	protected float textPosx = 0;
	protected float textPosy = 0;
	protected String text = "";
	protected BitmapFont bitmapFont;
	protected boolean isExternalTextureActive = false;
	protected float externalTexturePosx = 0;
	protected float externalTexturePosy = 0;
	protected float externalTextureSizeW = 50;
	protected float externalTextureSizeH = 50;
	protected TextureRegion externalRegion;
	protected boolean DIPactive = false;

	public abstractbutton(BitmapFont bitmapFont, Drawable up, Drawable down) {
		super(up, down);
		this.bitmapFont = bitmapFont;
	}

	public abstractbutton(BitmapFont bitmapFont, Drawable up, Drawable down,
			float width, float height, boolean DIPactive) {
		super(up, down);
		this.bitmapFont = bitmapFont;
		this.DIPactive = DIPactive;
		if (DIPactive) {
			setSize(width * Appsetting.getWorldSizeRatio(),
					height * Appsetting.getWorldSizeRatio());
			if (this.bitmapFont != null) {
				bitmapFont.setScale(Appsetting.getWorldSizeRatio());
			}
		}
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO Auto-generated method stub
		if (!isLockActive) {
			return super.hit(x, y, touchable);
		} else {
			return null;
		}
	}

	public boolean isLockActive() {
		return isLockActive;
	}

	public void setLockActive(boolean isLockActive) {
		this.isLockActive = isLockActive;
	}

	public TextureRegion getLockRegion() {
		return lockRegion;
	}

	public void setLockRegion(TextureRegion lockRegion, boolean isLockActive) {
		this.lockRegion = lockRegion;
		this.isLockActive = isLockActive;
	}

	public boolean isTextActive() {
		return isTextActive;
	}

	public void setTextActive(boolean isTextActive) {
		this.isTextActive = isTextActive;
	}

	public String getText() {
		return text;
	}

	public void setText(String text, boolean DIPactive) {
		this.text = text;
		this.DIPactive = DIPactive;
	}

	public void setTextChange(String text) {
		this.text = text;
	}

	public void setTextPosXY(float x, float y) {
		textPosx = x;
		textPosy = y;
		if (DIPactive) {
			textPosx = x * Appsetting.getWorldPostionXRatio();
			textPosy = y * Appsetting.getWordPostionYRatio();
		}
	}

	public boolean isExternalTextureActive() {
		return isExternalTextureActive;
	}

	public void setExternalTextureActive(boolean isExternalTextureActive) {
		this.isExternalTextureActive = isExternalTextureActive;
	}

	public TextureRegion getExternalRegion() {
		return externalRegion;
	}

	public void setExternalRegion(TextureRegion externalRegion,
			boolean isExternalTextureActive) {
		this.externalRegion = externalRegion;
		this.isExternalTextureActive = isExternalTextureActive;
	}

	public void setTextureExternalPosXY(float x, float y) {
		externalTexturePosx = x;
		externalTexturePosy = y;
		if (DIPactive) {
			externalTexturePosx = x * Appsetting.getWorldPostionXRatio();
			externalTexturePosy = y * Appsetting.getWordPostionYRatio();
		}
	}

	public void setTextureExternalPosSize(float width, float height) {
		externalTextureSizeW = width;
		externalTextureSizeH = height;
		if (DIPactive) {
			externalTextureSizeW *= Appsetting.getWorldSizeRatio();
			externalTextureSizeH *= Appsetting.getWorldSizeRatio();
		}
	}

	public boolean isDIPactive() {
		return DIPactive;
	}

	public void setDIPactive(boolean dIPactive) {
		DIPactive = dIPactive;
	}

}
