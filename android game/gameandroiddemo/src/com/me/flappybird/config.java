package com.me.flappybird;

import java.util.Random;

public class config {
	
	public static String SoundsJump = "Jump";
	public static String SoundsHit = "Hit";
	public static String SoundsLandhit = "Landhit";
	public static String SoundsScore = "Score";
	
	public static int KlandHeight = 112;
	public static float KlandWidth = 336;
	
	public static float KmoveLeftDura = 3;
	
	public static int KjumpHeight = 60;
	public static float KjumpDura = 0.2f;
	
	public static float KtimeAddPipe = 1.4f;
	
	public static float KholeBetwenPipe = 100;
	
	public static int random(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}

}
