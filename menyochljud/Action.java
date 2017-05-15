package menyochljud;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ljudfil.SoundTest;

import java.applet.Applet;
 import java.applet.AudioClip;

public class Action implements ActionListener {	
	
	java.net.URL enFink = SoundTest.class.getResource("enFINK.wav"); 
	java.net.URL neej = SoundTest.class.getResource("nej.wav"); 
	java.net.URL jaa = SoundTest.class.getResource("ja.wav"); 
	java.net.URL kanskee = SoundTest.class.getResource("kanske.wav"); 
	java.net.URL hemoova = SoundTest.class.getResource("dufårgåhemochöva.wav"); 
	
	AudioClip ja = Applet.newAudioClip(jaa); 
	AudioClip nej = Applet.newAudioClip(neej); 
	AudioClip kanske = Applet.newAudioClip(kanskee); 
	AudioClip hemova = Applet.newAudioClip(hemoova); 
	AudioClip fink = Applet.newAudioClip(enFink); 
	
	
	public void actionPerformed(ActionEvent e){

		   if(e.getActionCommand().equals("Spela")){
			   ja.play();
			   
			   try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   
			   System.exit(0);
		   
		   }else if(e.getActionCommand().equals("Kanske")){
			   kanske.play();
			   
			   try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   fink.play(); 
			 
		   }else{
			  nej.play();
			  
			   try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  
			  System.exit(0);
		   }
	}

			   
		   
}
		  

	
