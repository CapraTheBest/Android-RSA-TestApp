package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Asset {

	private final static String FILE_SPRITE_ATLAS = "data/sprite_sheet.sprites";
	private final static String FILE_UI_SKIN = "skin/uiskin.json";

	public static TextureAtlas spriteatlas;
	public static Skin skin;
	public static TextureRegion bg;
	public static TextureRegion logo;
	public static TextureRegion Button_startgame1;
	public static TextureRegion Button_startgame2;

	public static Texture loadtexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static TextureAtlas getspriteatlas() {
		if (spriteatlas == null) {
			spriteatlas = new TextureAtlas(FILE_SPRITE_ATLAS);
		}
		return spriteatlas;
	}

	public static Skin getskin() {
		if (skin == null) {
			FileHandle skinfile = Gdx.files.internal(FILE_UI_SKIN);
			skin = new Skin(skinfile);
		}
		return skin;
	}

	public static void loadall() {
		relaseresource();
		loadImages();
	}

	public static void relaseresource() {
		spriteatlas = null;
		skin = null;
	}

	public static void loadImages() {
		bg = getspriteatlas().findRegion("bg");
		logo = getspriteatlas().findRegion("logo");
		Button_startgame1 = getspriteatlas().findRegion("button_startgame1");
		Button_startgame2 = getspriteatlas().findRegion("button_startgame2");
	}
}
