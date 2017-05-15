package game.GFX;

import java.awt.image.BufferedImage;

import game.GFX.SpriteSheet;

public class Sprite {
	
	public SpriteSheet sheet;
	public BufferedImage image;
	
	public Sprite(SpriteSheet sheet, int x, int y){
		image = sheet.getSprite(x, y);
	}
	
	public BufferedImage getBufferedImage(){
		return image;
	}

}
