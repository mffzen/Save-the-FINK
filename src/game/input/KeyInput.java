package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mainpkge.Id;
import mainpkge.MainGame;
import game.entity.Entity;
import game.entity.Player;
import game.tile.*;

public class KeyInput implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (Entity en : MainGame.handler.entity) {
			if (en.getId() == Id.player) {
				switch (key) {
				case KeyEvent.VK_SPACE:
					
				case KeyEvent.VK_LEFT:
					en.moveLeft = true;
					en.facing = 0;
					break;
				case KeyEvent.VK_RIGHT:
					en.moveRight = true;
					
					en.facing = 1;
					break;
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		for (Entity en : MainGame.handler.entity) {
			if (en.getId() == Id.player) {
				switch (key) {
				case KeyEvent.VK_SPACE:
				
				case KeyEvent.VK_RIGHT:
				en.moveRight = false;
				
				case KeyEvent.VK_LEFT:
				en.moveLeft = false;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// används inte
	}

}
