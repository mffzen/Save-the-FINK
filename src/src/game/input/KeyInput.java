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
					// VAD SKA H�NDA OM JAG HOPPAR?
					if(en.canJump){
						en.jump();
					}
					break;
				case KeyEvent.VK_A:
					// VAD SKA H�NDA OM JAG TRYCKER A?
					if(en.canJump){
					en.vX = -7;
					en.facing = 0;
					}
					break;
				case KeyEvent.VK_D:
					// VAD SKA H�NDA OM JAG TRYCKER D
					if(en.canJump){
					en.vX = 7;
					en.facing = 1;
					}
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
				
				case KeyEvent.VK_A:
					// VAD SKA H�NDA OM JAG SL�PPER A?
					en.vX = 0;
					break;
				case KeyEvent.VK_D:
					// VAD SKA H�NDA OM JAG SL�PPER D?
					en.vX = 0;
					break;
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// anv�nds inte
	}

}
