/**
 * AudioPlayer.java		--A program responsible to manage sound effect for the game.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  12/02/2018
 */
package com.ratnalama.intheden.audio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.ratnalama.intheden.Handler;

public class AudioPlayer {
	
	private Clip clip;
	
	// Constructor
	public AudioPlayer(String s) {
		try {
			// input
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResource(s));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
					baseFormat.getSampleRate(), 16, 
					baseFormat.getChannels(),
					baseFormat.getChannels()*2,
					baseFormat.getSampleRate(), 
					false);
			// decode
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end Constructor
	
	public void play() {
		if (clip == null) {
			return;			
		}
		stop();
		clip.setFramePosition(0);
		clip.start();		
	} // end play()
	
	public void loopPlay() {
		try {
			play();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end loopPlay()
	
	
	public void stop() {
		if (clip.isRunning()) {
			clip.stop();
		}
	} // end stop()
	
	public void close() {
		stop();
		clip.close();
	} // close()
	
	
} // end AudioPlayer Class
