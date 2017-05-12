package game.entity;

import java.awt.Color;
import java.awt.Graphics;

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
		
		if(x <20){
		x += vX;
		vX += vX *dt;
		}else{
			vX = 20;
		}
		y += vY * dt;
		vY += gravity * dt;
		
			//y+= vY*dt + 0.5*-gravity*dt;


		for (int i = 0; i < handler.tile.size(); i++) {
			Tile t = handler.tile.get(i);
			if (t.isSolid()) {
				if (getBoundsTop().intersects(t.getBounds()) && t.getId() != Id.keys) {
					setvY(0);
				}
				if (getBoundsBottom().intersects(t.getBounds()) && t.getId() != Id.keys) {
					setvY(0);
				}
				if (getBoundsLeft().intersects(t.getBounds()) && t.getId() != Id.keys) {
					setvX(0);
					x = t.getX() + t.width;
				}
				if (getBoundsRight().intersects(t.getBounds()) && t.getId() != Id.keys) {
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
