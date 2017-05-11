package game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;

public abstract class Entity {
	
	public int playerMass = 10;
	public int x, y;
	public double dx = 0.2;
	public double dy = 9.8;
	
	public int velocityX, velocityY;
	public final double dt = 0.1;
	public final double JANGLE = 45;
	public double gravity = 9.8;
	public int width, height;
	public int facing = 1; // 0 = left and 1 = right
	
	public boolean jumping = false;
	public boolean falling = true;
	public boolean moveRight = false;
	public boolean moveLeft = false;
	
	public boolean solid;
	public Id id;
	public Handler handler;
	
	public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler){
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
	
	public void enemyDie(){
		handler.removeEntity(this);
	}

	public void die(){
	handler.removeEntity(this);	
	MainGame.lives--;
	MainGame.key= 0;
	MainGame.showDeathScreen = true;
	MainGame.time = 103;
	if(MainGame.lives <=0)
	MainGame.gameOver = true;
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
	
	public int getVelocityX() {
		return velocityX;
	}
	
	public int getVelocityY() {
		return velocityY;
	}

	
	public Rectangle getBounds(){
		return new Rectangle(getX(), getY(), width, height);
	}
	
	public Rectangle getBoundsTop(){
		return new Rectangle(getX()+10, getY(), width-20, 5);
	}
	
	public Rectangle getBoundsBottom(){
		return new Rectangle(getX()+10, getY()+height-5, width-20, 5);
	}
	
	public Rectangle getBoundsLeft(){
		return new Rectangle(getX(), getY()+10, 5, height-20);
	}
	
	public Rectangle getBoundsRight(){
		return new Rectangle(getX()+width-5, getY()+10, 5, height-20);
	}

}
