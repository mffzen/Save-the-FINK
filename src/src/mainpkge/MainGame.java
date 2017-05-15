package mainpkge;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

import game.GFX.Sprite;
import game.GFX.SpriteSheet;
import game.entity.Dragon;
import game.entity.Entity;
import game.entity.Player;
import game.input.KeyInput;
import game.tile.Wall;

public class MainGame extends Canvas implements Runnable, ActionListener {

	public static final int WIDTH = 900;
	public static final int HEIGHT = 700;
	public static final int SCALE = 4;
	public static final String TITLE = "Save the fink!";
	
	public java.net.URL hemoova = SoundTest.class.getResource("/dufargahemochova.wav"); 
	public AudioClip hemova = Applet.newAudioClip(hemoova); 
	

	public static int time = 103;
	// 1000 ms = 1 sek
	Timer tm = new Timer(1000, this);

	private Thread thread;
	private boolean running = false;
	private BufferedImage image;
	private BufferedImage background;

	public static int key = 0;
	public static int lives = 3;
	public static int deathScreenTime = 0;

	public static boolean showDeathScreen = true;
	public static boolean gameOver = false;
	public static boolean gameComplete = false;
	public static boolean playedSound = false;
	
	public static Handler handler;
	public static SpriteSheet sheet;

	public static Sprite walltop;
	public static Sprite ice;
	public static Sprite ground;
	public static Sprite keys;
	public static Sprite cage;
	public static Sprite player[] = new Sprite[2];
	public static Sprite dragon;
	
	public MainGame() {
			
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);
		setMaximumSize(size);
		setMinimumSize(size);
	}

	private void init() {
		handler = new Handler();
		sheet = new SpriteSheet("/spritesheet.png");

		addKeyListener(new KeyInput());
		
		walltop = new Sprite(sheet, 2,1);
		ice = new Sprite(sheet, 3, 1);
		ground = new Sprite(sheet, 4, 1);
		player = new Sprite[2];
		dragon = new Sprite(sheet, 5, 1);
		keys = new Sprite(sheet, 6, 1);
		cage = new Sprite(sheet, 7, 1);
		
		for (int i = 0; i < player.length; i++) {
			player[i] = new Sprite(sheet, i + 1, 3);
		}

		try {
			image = ImageIO.read(getClass().getResource("/level.png"));
			//background = ImageIO.read(getClass().getResource("/background3.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// skyddar threaden från andra threads som kan störa
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this, "Thread");
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Gameloop
	@Override
	public void run() {
		init();
		requestFocus();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double dt = 0.0;
		double ns = 1000000000.0 / 60.0;
		int frames = 0;
		int ticks = 0;

		while (running) {
			tm.start();
			if(time <= 0){
				gameOver = true;
				showDeathScreen = true;
			}
			long now = System.nanoTime();
			dt += (now - lastTime) / ns;
			lastTime = now;
			while (dt >= 1) {
				tick();
				ticks++;
				dt--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println(frames + " fps " + ticks + " ups");
				frames = 0;
				ticks = 0;
			}
		}
		stop();

	}

	// Visar allt på skärmen
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		g.setColor(new Color(255, 255, 255));
		g.fillRect(0, 0, getWidth(), getHeight());

		
		if (!showDeathScreen && !gameComplete) {
			g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
			g.drawImage(MainGame.keys.getBufferedImage(), 270, 70, 75, 75, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Courier", Font.BOLD, 30));
			g.drawString("x" + key, 315, 150);
			g.setColor(Color.RED);
			g.drawString("Time left " + time, 1450, 100);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Courier", Font.BOLD, 30));
			g.drawImage(MainGame.player[0].getBufferedImage(), 130, 75, 75, 75, null);
			g.drawString("x" + lives, 210, 150);
		}

		if (showDeathScreen) {
			if (!gameOver) {
				g.setColor(Color.BLACK);
				g.setFont(new Font("Courier", Font.BOLD, 200));
				g.drawString("You have " + lives + " lives", 700, 500);
				g.setFont(new Font("courier", Font.BOLD, 100));
				g.drawString("- Collect 3 keys", 1050, 600);
				g.drawString("- Save the fink", 1050, 700);
				g.drawString("- Watch out for the homework", 1050, 800);
				g.drawString("- Good luck!", 1050, 900);
				
			} else {
				g.setColor(Color.RED);
				g.setFont(new Font("Courier", Font.BOLD, 200));
				g.drawString("GAME OVER", 1050, 700);
				
				if(!playedSound){
					hemova.play();
					playedSound = true;
				}
					
			}
		}
		if (gameComplete) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("Courier", Font.BOLD, 200));
			g.drawString("Congratulations!", 700, 700);
			g.drawString("You saved the fink!", 500, 850);
		}
		if(gameOver && time <= 0){
			g.setColor(Color.RED);
			g.setFont(new Font("Courier", Font.BOLD, 200));
			g.drawString("GAME OVER", 1050, 700);
			g.setFont(new Font("Courier", Font.BOLD, 100));
			g.drawString("Time out or you have too much homework", 600, 850);
			
			if(!playedSound){
				hemova.play();
				playedSound = true;
			}
		
		}
		if (!showDeathScreen)
			handler.render(g);
		g.dispose();
		bs.show();

	}

	// Uppdaterar allt som händer
	public void tick() {
		handler.tick();
		
		if (showDeathScreen && !gameOver && !gameComplete)
			deathScreenTime++;
		if (deathScreenTime >= 180) {
			showDeathScreen = false;
			deathScreenTime = 0;
			handler.clearLevel();
			handler.createLevel(image);
		}
		if (gameComplete) {
			handler.clearLevel();
		}
	}

	public static void main(String[] args) {
		
		Menu meny = new Menu();
		meny.run();
		/*
		MainGame game = new MainGame();
		JFrame frame = new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		game.start();*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (time != 0)
			time--;
		else
			time = 0;
	}
	

}
