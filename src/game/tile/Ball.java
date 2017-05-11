package game.tile;

import java.awt.Color;
import java.awt.Graphics;

import game.entity.Entity;
import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;

public class Ball extends Entity {
	
	private double gravity = 9.8;
	private double energyloss = .1;
	private double xFriction = .9;
	private int x;
	private int y;
	private double dx = 20;
	private double dy = 0;
	private double dt = .16;
	private int radius = 40;

	public Ball(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
		
	}

	@Override
	public void render(Graphics g) {	
	
		g.drawImage(MainGame.ball.getBufferedImage(), x, y, width, height, null);
	}
		

	@Override
	public void tick() {
		// Hindrar bollen från att åka ur banan.
		// Sätter x = bredden på fönstret
		// "-radius" gör så att inte halva bollen hamnar utanför
		// "-radius-1" för att en pixel hamnar utanför då det börjar räkna
		// på 0
		
		/*for (int i = 0; i < handler.tile.size(); i++) {
			Tile t = handler.tile.get(i);
			if (t.isSolid()) {
				if (getBoundsLeft().intersects(t.getBounds())) {
					x = 0 + radius;
					dx = -dx;
				}
				if (getBoundsRight().intersects(t.getBounds())) {
					x = MainGame.WIDTH * 2  - radius - 1;
					dx = -dx;
					
				}
				if (getBoundsTop().intersects(t.getBounds())) {
					dx *= xFriction;
					if (Math.abs(dx) < .8) {
						dx = 0;
					}
				}
				if (getBoundsBottom().intersects(t.getBounds())) {
					dy = -dy;
				}
			}
		} 
		
		x += dx;
		
		dy += gravity * dt;
		// positionsformel (Gravitation)
		y += dy * dt + .5 * gravity * dt * dt;
*/
		if (x + dx > MainGame.WIDTH * 4) {
			x = MainGame.WIDTH * 4  - radius - 1;
			dx = -dx;

			// Får bollen att studsa och ändrar tecken på dx för att ändra
			// riktning
		} else if (x + dx < 0 + radius) {
			x = 0 + radius;
			dx = -dx;
		} else {
			x += dx;
		}

		if (y == MainGame.HEIGHT * 3 - radius - 1) {
			dx *= xFriction;
			if (Math.abs(dx) < .8) {
				dx = 0;
			}
		}

		if (y > MainGame.HEIGHT * 3 - radius - 1) {
			y = MainGame.HEIGHT * 3 - radius - 1;
			dy *= energyloss;
			dy = -dy;
		} else {
			// Hastighetsformel
			dy += gravity * dt;
			// positionsformel (Gravitation)
			y += dy * dt + .5 * gravity * dt * dt;
		}
		
	}
		
	}


