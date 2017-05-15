package game.entity;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;
import game.entity.Entity;
import game.tile.Tile;

public class Dragon extends Entity{

	private Random random = new Random();

	
	public int amplitude = 80;
	public int freq = 1;
	public int yBase = 0;
	public int dx = 4;

	public Dragon(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);

	}

	@Override
	public void render(Graphics g) {
			g.drawImage(MainGame.dragon.getBufferedImage(), x, y, width, height, null);
	}

	@Override
	public void tick() {
		x += dx;
		final int waveLength = width / freq;
		yBase = (++yBase) % waveLength;
		
		final double normalized = (double) yBase/ (double) waveLength;
		final double rad = normalized * Math.PI*2;
		final double sine = Math.sin(rad);
		
		y = (int)(sine*amplitude) + height*6;
		
		for (int i = 0; i < handler.tile.size(); i++) {
			Tile t = handler.tile.get(i);
			if (t.isSolid()) {
				if (getBoundsLeft().intersects(t.getBounds())) {
					dx = -dx;
				}
				if (getBoundsRight().intersects(t.getBounds())) {
					dx = -dx;
				}
			}
		} 
	}
}
