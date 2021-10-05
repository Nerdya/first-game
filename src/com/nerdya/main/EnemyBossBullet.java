package com.nerdya.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject {
	
	private Handler handler;
	
	private Random r = new Random();

	public EnemyBossBullet(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		
		speedX = r.nextInt(5 - -5) + -5;
		speedY = 5;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		
//		if (y <= 0 || y >= Game.HEIGHT - 32) speedY *= -1;
//		if (x <= 0 || x >= Game.WIDTH - 16) speedX *= -1;
		
		if (y >= Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.05f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}

}
