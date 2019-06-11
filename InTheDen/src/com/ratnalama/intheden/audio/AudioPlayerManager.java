/**
 * AudioPlayerManager.java	--A program responsible to manage sound effects in the game world.
 * @author        			  Ratna Lama
 * @version       			  1.0
 * @since         			  12/07/2018
 */

package com.ratnalama.intheden.audio;

import java.util.HashMap;

import com.ratnalama.intheden.Handler;

public class AudioPlayerManager {

	private Handler handler;
	private HashMap<String, AudioPlayer> sfx;

	// Constructor
	public AudioPlayerManager(Handler handler) {
		this.handler = handler;
		sfx = new HashMap<String, AudioPlayer>();
	} // end Constructor
	
	public void initSound() {
		sfx.put("safari", new AudioPlayer("/audio/safari.wav"));		
		sfx.put("sword", new AudioPlayer("/audio/sword.wav"));
		sfx.put("lion", new AudioPlayer("/audio/lion.flac"));
		sfx.put("boar", new AudioPlayer("/audio/boar.wav"));
		sfx.put("bee", new AudioPlayer("/audio/bee.wav"));
		sfx.put("kingKong", new AudioPlayer("/audio/kong.wav"));
		sfx.put("turtle", new AudioPlayer("/audio/kong.wav"));
		sfx.put("vulture", new AudioPlayer("/audio/vulture.wav"));
		sfx.put("shroom", new AudioPlayer("/audio/kong.wav"));
	} // end initSound()		
	

	/* -------------------------BEGIN Getters and Setters-------------------------------- */
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	public HashMap<String, AudioPlayer> getSfx() {
		return sfx;
	}

	public void setSfx(HashMap<String, AudioPlayer> sfx) {
		this.sfx = sfx;
	}
	/* -------------------------END Getters and Setters---------------------------------- */
} // end ItemManager Class

