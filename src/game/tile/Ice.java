package game.tile;

import java.awt.Color;
import java.awt.Graphics;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;



public class Ice extends Tile {

	public Ice(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
		super(x, y, width, height, solid, id, handler);
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(MainGame.ice.getBufferedImage(), x, y, width, height, null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
