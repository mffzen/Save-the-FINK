package game.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;
import game.entity.Entity;
import game.tile.Tile;

public class Player extends Entity {

	public Player(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
		super(x, y, width, height, solid, id, handler);
	}

	public void render(Graphics g) {
		if (facing == 0) {
			g.drawImage(MainGame.player[1].getBufferedImage(), x, y, width, height, null);
		} else if (facing == 1) {
			g.drawImage(MainGame.player[0].getBufferedImage(), x, y, width, height, null);
		}
	}

	public void tick() {
		dt = System.currentTimeMillis() - time;
		time = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		System.out.println(dt);
		System.out.println(time);

		x+= vX;
		
		// VAD SKA HÄNDA OM JAG FALLER?
			

		// VAD SKA HÄNDA OM JAG HOPPAR?

		
		// VAD SKA HÄNDA OM JAG ÄR PÅ MARKEN? Jag kan gå höger, vänster eller hoppa!
		
		

		for (int i = 0; i < handler.tile.size(); i++) {
			Tile t = handler.tile.get(i);
			if (t.isSolid()) {
				if (getBoundsTop().intersects(t.getBounds()) && t.getId() != Id.keys && t.getId() != Id.cage) {
					setvY(0);
					y = t.getY() + t.width;

					// VAD SKA HÄNDA OM JAG TRÄFFAR TAKET?
					
				}
				if (getBoundsBottom().intersects(t.getBounds()) && t.getId() != Id.keys && t.getId() != Id.cage) {
					setvY(0);
					y = t.getY() - t.width;
					// VAD SKA HÄNDA OM JAG TRÄFFAR BOTTEN?
			
				}

				if (getBoundsLeft().intersects(t.getBounds()) && t.getId() != Id.keys && t.getId() != Id.cage) {
					setvX(0);
					x = t.getX() + t.width;
				}
				if (getBoundsRight().intersects(t.getBounds()) && t.getId() != Id.keys && t.getId() != Id.cage) {
					setvX(0);
					x = t.getX() - t.width;
				}

				if (getBounds().intersects(t.getBounds()) && t.getId() == Id.keys) {
					MainGame.key++;
					t.die();
				}

				if (getBounds().intersects(t.getBounds()) && t.getId() == Id.cage && MainGame.key >= 3) {
					MainGame.gameComplete = true;
					t.die();
				}

			}
		}

		for (int i = 0; i < handler.entity.size(); i++) {
			Entity e = handler.entity.get(i);

			if (e.getId() == Id.dragon) {
				if (getBounds().intersects(e.getBounds())) {
					e.die();
				}
			}
		}
	}

}
