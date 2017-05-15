package game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import mainpkge.Handler;
import mainpkge.Id;
import mainpkge.MainGame;

public abstract class Entity extends JPanel {

	public int x, y;
	public float gravity = 10f, time, dt = 0.1f;

	public float vX = 0, vY = 0, vinit = 0;
	public float jumpAngle = (float) (45 * Math.PI / 180);
	public int width = 64, height = 64;
	public int facing = 1; // 0 = left and 1 = right
	
	public double airR = 0.2;

	public boolean solid;
	public boolean falling = true, jumping = false, canJump = true;

	public Id id;
	public Handler handler;

	public Entity(int x, int y, int width, int height, boolean solid, Id id, Handler handler) {
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

	public void enemyDie() {
		handler.removeEntity(this);
	}

	public void die() {
		handler.removeEntity(this);
		MainGame.lives--;
		MainGame.key = 0;
		MainGame.showDeathScreen = true;
		MainGame.time = 103;
		if (MainGame.lives <= 0)
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

	public Id getId() {
		return id;
	}

	public boolean isSolid() {
		return solid;
	}

	public void setvX(float vX) {
		this.vX = vX;
	}

	public void setvY(float vY) {
		this.vY = vY;
	}

	public float getvX() {
		return vX;
	}

	public float getvY() {
		return vY;
	}

	public void jump() {
		System.out.println(vY);
		vY = -40;
		// (-(float) (vinit*Math.sin(45)));
		if (facing == 1) {
			vX = 9;
		}
		if (facing == 0) {
			vX = -9;
		}
		// (float) (vinit*Math.cos(45));
		jumping = true;
		canJump = false;

		System.out.println(vY);
	}

	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), width, height);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle(getX() + 10, getY(), width - 20, 5);
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle(getX() + 10, getY() + height - 5, width - 20, 5);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle(getX(), getY() + 10, 5, height - 20);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle(getX() + width - 5, getY() + 10, 5, height - 20);
	}

}
