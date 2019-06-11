/**
 * GameWorld.java	--A program responsible to represent the game world.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/02/2018
 */

package com.ratnalama.intheden.gameworld;

import java.awt.Graphics;

import com.ratnalama.intheden.Handler;
import com.ratnalama.intheden.audio.AudioPlayer;
import com.ratnalama.intheden.entity.EntityManager;
import com.ratnalama.intheden.entity.collidable.BulletController;
import com.ratnalama.intheden.entity.creature.Player;
import com.ratnalama.intheden.entity.statics.Bee;
import com.ratnalama.intheden.entity.statics.Boar;
import com.ratnalama.intheden.entity.statics.BreakableWall;
import com.ratnalama.intheden.entity.statics.Kong;
import com.ratnalama.intheden.entity.statics.Lion;
import com.ratnalama.intheden.entity.statics.Shroom;
import com.ratnalama.intheden.entity.statics.Turtle;
import com.ratnalama.intheden.entity.statics.Vulture;
import com.ratnalama.intheden.items.ItemManager;
import com.ratnalama.intheden.tile.Tile;
import com.ratnalama.intheden.utils.Utils;

public class GameWorld {	

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	// Entities
	private EntityManager entityManager;
	
	// Item
	private ItemManager itemManager;
	
	// Bullet
	private BulletController bulletController;
	
	// Audio
	private AudioPlayer bgMusic;
	
	
	// Constructor
	public GameWorld(Handler handler, String path) {
		this.handler = handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 1100, 1100));
				
		itemManager = new ItemManager(handler);
		
		//bulletController = new BulletController(handler);
		
		// add new entity
		// lion
		entityManager.addEntity(new Lion(handler, 610, 595));
		entityManager.addEntity(new Boar(handler, 75, 1100));
		entityManager.addEntity(new Bee(handler, 1050, 100));
		entityManager.addEntity(new Turtle(handler, 330, 840));
		entityManager.addEntity(new Shroom(handler, 775, 390));
		entityManager.addEntity(new Kong(handler, 800, 840));
		entityManager.addEntity(new Vulture(handler, 295, 550));
		
		// breakable Wall
		entityManager.addEntity(new BreakableWall(handler, 512, 190));
		entityManager.addEntity(new BreakableWall(handler, 512, 958));
		entityManager.addEntity(new BreakableWall(handler, 192, 575));
		entityManager.addEntity(new BreakableWall(handler, 960, 575));
		entityManager.addEntity(new BreakableWall(handler, 575, 450));
		entityManager.addEntity(new BreakableWall(handler, 575, 767));
				
		loadGameWorld(path);
		
		// audio
		bgMusic = new AudioPlayer("/audio/safari.wav");
		bgMusic.loopPlay();
		
		
//		entityManager.getPlayer().setX(spawnX);
//		entityManager.getPlayer().setY(spawnY);
	} // end Constructor
	
	// update
	public void tick() {
		//bulletController.tick();
		itemManager.tick();
		entityManager.tick();
		
		
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
		
		/* ---BEGIN render tiles that are only in the player's view range-------------- */ 
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth())/ Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight())/ Tile.TILEHEIGHT + 1);
		
		for(int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(magicalBrush, (int) (x*Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y*Tile.TILEHEIGHT-handler.getGameCamera().getyOffset()));				
			}
		}
		
		// bullet
		//bulletController.render(magicalBrush);
		
		// Items
		itemManager.render(magicalBrush);
		
		// Entities
		entityManager.render(magicalBrush);		
		/* ---END render tiles that are only in the player's view range--------------- */ 
	} // end render()
	
	
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.grassTile;			
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		
		if (t == null) {
			return Tile.dirtTile;
		}
		return t;
	} // end getTile()
	
	
	// Loads game world
	private void loadGameWorld(String path) {
		String file = Utils.loadFile(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for	(int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x+y*width) + 4]);			
			}
		}		 
	} // end loadGameWorld()
	
	
	/* --------------------BEGIN Getters and Setters----------------------------------------- */
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	public Handler getHandler() {
		return handler;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	public BulletController getBulletController() {
		return bulletController;
	}

	public void setBulletController(BulletController bulletController) {
		this.bulletController = bulletController;
	}
	
	/* --------------------END Getters and Setters------------------------------------------ */

} // end GameWorld Class
