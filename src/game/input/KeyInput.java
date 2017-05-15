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
					// VAD SKA HÄNDA OM JAG HOPPAR?
					
					break;
				case KeyEvent.VK_A:
					// VAD SKA HÄNDA OM JAG TRYCKER A?
					en.facing =0;
					en.vX = -5;
					break;
				case KeyEvent.VK_D:
					// VAD SKA HÄNDA OM JAG TRYCKER D
					en.facing = 1;
					en.vX = 5;
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
					//VAD SKA HÄNDA OM JAG SLÄPPER HOPP-KNAPPEN?
					break;
				case KeyEvent.VK_A:
					// VAD SKA HÄNDA OM JAG SLÄPPER A?
					en.vX = 0;
					break;
				case KeyEvent.VK_D:
					// VAD SKA HÄNDA OM JAG SLÄPPER D?
					en.vX = 0;
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
