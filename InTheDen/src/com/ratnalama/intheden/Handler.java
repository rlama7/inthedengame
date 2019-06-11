/**
 * Handler.java		--A program responsible to handle various variables in the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/02/2018
 */

package com.ratnalama.intheden;

import com.ratnalama.intheden.gameworld.GameWorld;
import com.ratnalama.intheden.graphics.GameCamera;
import com.ratnalama.intheden.input.KeyManager;
import com.ratnalama.intheden.input.MouseManager;

public class Handler {

	private Game game;
	private GameWorld world;

	// Constructor
	public Handler(Game game) {
		this.game = game;

	} // end Constructor

	/* ---------------BEGIN Getters and Setters-------------------------------------- */
	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}

	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameWorld getWorld() {
		return world;
	}

	public void setWorld(GameWorld world) {
		this.world = world;
	}
	/* ---------------END Getters and Setters---------------------------------------- */

} // end Handler Class
