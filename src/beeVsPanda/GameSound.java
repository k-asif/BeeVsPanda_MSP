package beeVsPanda;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GameSound {

	public static void bulletFiredSound(){

		try{	
			File sound = new File("sounds//BulletFired//bulletWhizzing.wav");

			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){

		}
	}


	public static void bulletHitSound(){

		try{	
			File soundHit = new File("sounds//BulletFired//SilencerShot.wav");

			AudioInputStream ais = AudioSystem.getAudioInputStream(soundHit);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){

		}

	}


	public static void Shooter_Bee_Collide_Sound(){

		try{	
			File sound = new File("sounds//BulletFired//Blast.wav");

			AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}
		catch(Exception e){

		}
	}

}
