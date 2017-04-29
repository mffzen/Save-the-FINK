package Game3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjectPicture {
	
	protected BufferedImage image;
	
	public ObjectPicture(String path){
		
		image = null;
		 
        try{
            
        	image = ImageIO.read(new File(path));
        	
        }catch (IOException e){
        	
           e.printStackTrace();
        }
        
	}

	protected void render(Graphics2D g, int x, int y, int crop1, int crop2, int crop3, int crop4){
		
		g.drawImage(image.getSubimage(crop1, crop2, crop3, crop4), null, x, y);
		
	}
	
	protected void render(Graphics2D g, int x, int y){
		
		g.drawImage(image, null, x, y);
		
	}
	
}
