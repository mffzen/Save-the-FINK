package Game3;
	
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Blocks {
		
		private Color blockColor;
		private int x, y, width, height;
		Graphics2D g;
		
		public Blocks(Graphics2D g, Color blockColor, int x, int y, int width, int height){
			
			this.g = g;
			this.blockColor = blockColor;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
		}
		
		protected void render(){
			
			g.setColor(blockColor);
			g.fillRect(x, y, width, height);
			g.setColor(Color.black);
			g.drawRect(x-1, y-1, width+1, height+1);

		}
	}
