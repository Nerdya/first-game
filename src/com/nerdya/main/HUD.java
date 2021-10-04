package com.nerdya.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	public static int HEALTH = 100;
	private int greenValue = 255;
	
	private int score = 0;
	private int level = 1;
	
	public void tick() {
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
		greenValue = Game.clamp(greenValue, 0, 255);
		
		greenValue = 255 * HEALTH / 100;
		
		score++;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(16, 16, 200, 16);
		g.setColor(new Color(255 - greenValue, greenValue, 0));
		g.fillRect(16, 16, HEALTH * 2, 16);
		g.setColor(Color.white);
		g.drawRect(16, 16, 200, 16);
		
//		g.drawString("HP: " + HEALTH, 16, 12);
		g.drawString("Score: " + score, 16, 48);
		g.drawString("Level: " + level, 16, 64);
		
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
