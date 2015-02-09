package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;

public class Appsetting {

	public static boolean LOG_ACTIVE = true;
	public static float SCREEN_W = 0.0f;
	public static float SCREEN_H = 0.0f;
	public static float WORLD_TARGET_WIDTH = 0.0f;
	public static float WORLD_TARGET_HEIGHT = 0.0f;
	private static float WT_WTDTH_Portrait = 0.0f;
	private static float WT_HEIGHT_Portrait = 0.0f;
	private static float WT_WIDTH_Landscape = 0.0f;
	private static float WT_HEIGHT_Landscape = 0.0f;
	public static float WORLD_WIDTH = 0.0f;
	public static float WORLD_HEIGHT = 0.0f;

	private static Apporientation apporientation;

	private enum Apporientation {
		PORTRAIT, LANSCAPE, BOTH, NONE
	}

	public static void SetUp() {
		Reset();
		SCREEN_W = Gdx.graphics.getWidth();
		SCREEN_H = Gdx.graphics.getHeight();
		WORLD_TARGET_WIDTH = 960;
		WORLD_TARGET_HEIGHT = 540;
		WT_WTDTH_Portrait = 540;
		WT_HEIGHT_Portrait = 960;
		WT_WIDTH_Landscape = 960;
		WT_HEIGHT_Landscape = 540;
		WORLD_WIDTH = Gdx.graphics.getWidth();
		WORLD_HEIGHT = Gdx.graphics.getHeight();
	}

	public static boolean IS_PORTRAIT;

	public static void setUpOrientation() {
		if (apporientation == Apporientation.BOTH) {
			if (Gdx.graphics.getWidth() <= Gdx.graphics.getHeight()) {
				WORLD_WIDTH = Gdx.graphics.getWidth();
				WORLD_HEIGHT = Gdx.graphics.getHeight();
				WORLD_TARGET_WIDTH = WT_WTDTH_Portrait;
				WORLD_TARGET_HEIGHT = WT_HEIGHT_Portrait;
				IS_PORTRAIT = true;
			} else {
				WORLD_WIDTH = Gdx.graphics.getWidth();
				WORLD_HEIGHT = Gdx.graphics.getHeight();
				WORLD_TARGET_WIDTH = WT_WIDTH_Landscape;
				WORLD_TARGET_HEIGHT = WT_HEIGHT_Landscape;
				IS_PORTRAIT = false;
			}
		}
	}

	public static boolean isOrientationPortrait() {
		if (Gdx.graphics.getWidth() <= Gdx.graphics.getHeight()) {
			return true;
		} else {
			return false;
		}
	}

	public static float getWorldSizeRatio() {
		float ratioSize = 1.0f;
		if (WORLD_WIDTH <= WORLD_HEIGHT) {
			ratioSize = WORLD_WIDTH / WORLD_TARGET_WIDTH;
		} else {
			ratioSize = WORLD_HEIGHT / WORLD_TARGET_HEIGHT;
		}
		return ratioSize;
	}

	public static float getWorldPostionXRatio() {
		float RatioX = 0.0f;
		if (WORLD_WIDTH <= WORLD_HEIGHT) {
			RatioX = WORLD_WIDTH / WORLD_TARGET_WIDTH;
		} else {
			RatioX = WORLD_WIDTH / WORLD_TARGET_WIDTH;
		}
		return RatioX;
	}

	public static float getWordPostionYRatio() {
		float RatioY = 0.0f;
		if (WORLD_WIDTH <= WORLD_HEIGHT) {
			RatioY = WORLD_HEIGHT / WORLD_TARGET_HEIGHT;
		} else {
			RatioY = WORLD_HEIGHT / WORLD_TARGET_HEIGHT;
		}
		return RatioY;
	}

	private static void Reset() {
		apporientation = Apporientation.LANSCAPE;
		SCREEN_W = 0.0f;
		SCREEN_H = 0.0f;
		WORLD_TARGET_WIDTH = 0.0f;
		WORLD_TARGET_HEIGHT = 0.0f;
		WT_WIDTH_Landscape = 0.0f;
		WT_HEIGHT_Landscape = 0.0f;
		WORLD_HEIGHT = 0.0f;
		WORLD_WIDTH = 0.0f;
		WT_HEIGHT_Portrait = 0.0f;
		WT_WIDTH_Landscape = 0.0f;
	}
}
