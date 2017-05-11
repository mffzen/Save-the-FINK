package menyochljud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Meny {
	public static JFrame frame;
	public static JPanel panel;

	
	public Meny(){
		frame = new JFrame("SAVE THE FINK");
		panel = new JPanel();
		
		//frame.setLayout(new GridLayout(3,1));

	}
	
	public void run(){
		
		panel.setBackground(Color.BLACK);
		panel.setLayout(new GridLayout(3,1) );
	
		JButton s = new JButton("Spela");
		JButton a = new JButton("Avsluta");
		JButton k = new JButton("Kanske");
		panel.add(s);
		panel.add(k);
		panel.add(a);	
		frame.setSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.getContentPane().add(panel);
s.addActionListener(new Action());
a.addActionListener(new Action());
k.addActionListener(new Action());
	}


}
