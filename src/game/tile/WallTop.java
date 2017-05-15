package game.tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;



public class WallTop extends Tile {

	public WallTop(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
		super(x, y, width, height, solid, id, handler);
	}
	

	@Override
	public void render(Graphics g) {
		g.drawImage(MainGame.walltop.getBufferedImage(), x, y, width, height, null);
		Graphics2D hej = (Graphics2D) g;
		hej.setColor(Color.RED);
		hej.draw(getBounds());
		}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
