package game.tile;

import java.awt.Graphics;
import java.awt.Rectangle;

import mainpkge.Handler;
import mainpkge.Id;

public abstract class Tile {

	public int x, y, width, height, velocityX, velocityY;
	public Id id;
	public Handler handler;
	public boolean solid;
	
	public Tile(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
		this.id = id;
		this.handler = handler;
	}
	
	public abstract void render(Graphics g);
	public abstract void tick();
	
	public void die(){
		handler.removeTile(this);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Id getId(){
		return id;
	}
	
	public boolean isSolid() {
		return solid;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}


	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(getX(), getY(), width, height);
	}
	
	
}
