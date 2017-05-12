package game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import mainpkge.Id;
import mainpkge.MainGame;
import game.entity.Entity;

public class KeyInput implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		for (Entity en : MainGame.handler.entity) {
			if (en.getId() == Id.player) {
				switch (key) {
				case KeyEvent.VK_W:
					break;
				case KeyEvent.VK_A:
					en.setvX(-5);
					en.facing = 0;
					break;
				case KeyEvent.VK_D:
					en.setvX(5);
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
				case KeyEvent.VK_W:
					break;
				case KeyEvent.VK_A:
					en.setvX(0);
					break;
				case KeyEvent.VK_D:
					en.setvX(0);
					break;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// används inte
	}

}
