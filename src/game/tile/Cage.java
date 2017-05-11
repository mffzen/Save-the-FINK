package game.tile;

import java.awt.Graphics;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;

public class Cage extends Tile {

	public Cage(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(MainGame.cage.getBufferedImage(), x, y, width, height, null);
	
	}

	@Override
	public void tick() {
	}
	
}
