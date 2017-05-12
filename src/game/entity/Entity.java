package game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JPanel;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;

public abstract class Entity extends JPanel {
	
	public int playerMass = 10;
	public int x, y;
	public double gravity  = 10.0;
	
	public double dt = 0.16;
	
	
	public double vX, vY, jumpSpeed, jumpingAngle = 45;;
	public int width, height;
	public int facing = 1; // 0 = left and 1 = right
	
	public boolean jumping = false;
	public boolean atGround = false;
	
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

	public void setvX(int vX) {
		this.vX = vX;
	}


	public void setvY(int vY) {
		this.vY = vY;
	}
	
	public double getvX() {
		return vX;
	}
	
	public double getvY() {
		return vY;
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
