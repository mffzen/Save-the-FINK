package mainpkge;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import game.entity.Entity;
import game.entity.Player;
import game.tile.Cage;
import game.tile.Ice;
import game.tile.Keys;
import game.tile.Tile;
import game.tile.Wall;
import game.tile.WallTop;

public class Handler {
	// En linkedlist med entitys i.
	public LinkedList<Entity> entity = new LinkedList<Entity>();
	public LinkedList<Tile> tile = new LinkedList<Tile>();

	public void render(Graphics g) {
		for (Entity en : entity) {
			en.render(g);
		}
		for (Tile ti : tile) {
			ti.render(g);
		}
	}

	public void tick() {
		for (Entity en : entity) {
			en.tick();
		}
		for (Tile ti : tile) {
			ti.tick();
		}
	}

	public void addEntity(Entity en) {
		entity.add(en);
	}

	public void removeEntity(Entity en) {
		entity.remove(en);
	}

	public void addTile(Tile ti) {
		tile.add(ti);
	}

	public void removeTile(Tile ti) {
		tile.remove(ti);
	}

	public void createLevel(BufferedImage level) {
		int width = level.getWidth();
		int height = level.getHeight();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int pixel = level.getRGB(x, y);

				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				
				if (red == 0 && green == 255 && blue == 255)
					addTile(new WallTop(x * 64, y * 64, 64, 64, true, Id.WallTop, this));
				if (red == 0 && green == 0 && blue == 0)
					addTile(new Wall(x * 64, y * 64, 64, 64, true, Id.Wall, this));
				if (red == 0 && green == 0 && blue == 255)
					addEntity(new Player(x * 64, y * 64, 64, 64, false, Id.player, this));
				if (red == 255 && green == 0 && blue == 0)
					addTile(new Keys(x * 64, y * 64, 64, 64, true, Id.keys, this));
				if(red == 0 &&  green == 255 && blue == 0)
					addTile(new Cage(x * 64, y * 64, 64, 64, true, Id.cage, this));
				if (red == 255 && green == 0 && blue == 255)
					addTile(new Ice(x * 64, y * 64, 64, 64, true, Id.ice, this));
			}
		}
	}
	
	public void clearLevel(){
		entity.clear();
		tile.clear();
	}
}
