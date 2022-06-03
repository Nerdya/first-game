package com.nerdya.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject {
	
	private Random r = new Random();
	private Handler handler;
	
	private int phase0 = 30;
	private int phase1 = 50;

	public EnemyBoss(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		speedX = 0;
		speedY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 96, 96);
	}

	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		
		if (phase0 <= 0) {
			speedY = 0;
			phase1--;
		}
		else phase0--;
		
		if (phase1 <= 0) {
			if (speedX == 0) speedX = 2;
			int spawn = r.nextInt(10);
			if (spawn == 0) handler.addObject(new EnemyBossBullet(x + 48, y + 48, ID.BasicEnemy, handler));
		}
		
//		if (y <= 0 || y >= Game.HEIGHT - 96) speedY *= -1;
		if (x <= 0 || x >= Game.WIDTH - 96) speedX *= -1;
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 96, 96, 0.1f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 96, 96);
	}

}
