package Game3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Displayer {
	
	private Graphics2D g;
	private JFrame f;
	private JPanel canvas;
	
	private int width = 900;
	private int height = 700;
	private int block = 50;
	
	private int[] iM = {520, 130, 150, 50};																//ice block measures
	
	private Color blocks = new Color(27, 148, 23);
	private Color ice = new Color(191, 226, 242);
	private Color wall = new Color(10, 10, 10);
	private Color background = new Color(34, 106, 161);
	private Color ground = new Color(102, 51, 0);
	
	private Stack<Blocks> gameBlocks = new Stack<Blocks>();
	
	private boolean isRunning = false;

	public Displayer(){
		
		f = new JFrame("                                                                                                                              SAVE THE FINK");
		f.setSize(width, height);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		canvas = new JPanel();
		canvas.setPreferredSize(new Dimension(width, height));
		
		f.add(canvas);
		f.pack();
		
		f.setVisible(true);
		
		g = (Graphics2D) canvas.getGraphics();
		canvas.setBackground(background);
		
		isRunning = true;
		
		createBlocks();
	}
	
	private void createBlocks(){
		
		Blocks iceBlock = new Blocks(g, ice, iM[0], iM[1], iM[2], iM[3]);
		Blocks block0 = new Blocks(g, blocks, 780, 619, block * 2 + 10, block);
		Blocks block1 = new Blocks(g, blocks, 680, 570, block, block);
		Blocks block2 = new Blocks(g, blocks, 600, 520, block, block);
		Blocks block3 = new Blocks(g, blocks, 460, 470, block * 2, block);
		Blocks block4 = new Blocks(g, blocks, 250, 420, block * 3, block);
		Blocks block5 = new Blocks(g, blocks, 160, 370, block, block);
		Blocks block6 = new Blocks(g, blocks, 10, 300, 120, block);
		Blocks block7 = new Blocks(g, blocks, 200, 230, 130, block);
		Blocks block8 = new Blocks(g, blocks, 380, 180, block * 2, block);
		
		Blocks finalBlock = new Blocks(g, ground, 750, 130, 140, block);
		Blocks pendulumBlock = new Blocks(g, Color.GRAY, 250, 471, block * 3, block + 20);
		
		gameBlocks.push(iceBlock);
		gameBlocks.push(block0);
		gameBlocks.push(block1);
		gameBlocks.push(block2);
		gameBlocks.push(block3);
		gameBlocks.push(block4);
		gameBlocks.push(block5);
		gameBlocks.push(block6);
		gameBlocks.push(block7);
		gameBlocks.push(block8);
		gameBlocks.push(finalBlock);
		gameBlocks.push(pendulumBlock);
		
	}
	
	private void renderWalls(){
		
		g.setColor(Color.BLACK);
		g.drawLine(10, 669, 889, 669);																	//ground line
		
		g.setColor(ground);
		g.fillRect(10, 670, 880, 20);																	//ground
		g.setColor(wall);
		g.fillRect(0, 0, block - 40, height);															//left wall
		g.fillRect(width - 10, 0, 10, height);															//right wall
		g.fillRect(10, 0, width - 10, 10);																//ceiling wall
		g.fillRect(0, height - 10, width - 10, height);													//ground wall
		
	}
	
	protected void render(){
		
		
		while(isRunning){
			
			for(Blocks x: gameBlocks){
				
				renderWalls();
				x.render();
			
			}
		}
	}
}