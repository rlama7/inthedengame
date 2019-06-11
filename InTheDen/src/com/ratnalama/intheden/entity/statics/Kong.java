/**
 * Kong.java	--A program responsible to represent a King Kong - a static entity.
 * @author        Ratna Lama
 * @version       1.0
 * @since         12/09/2018
 */

package com.ratnalama.intheden.entity.statics;

import java.awt.Graphics;

import com.ratnalama.intheden.Handler;
import com.ratnalama.intheden.audio.AudioPlayer;
import com.ratnalama.intheden.graphics.Assets;
import com.ratnalama.intheden.items.Item;
import com.ratnalama.intheden.tile.Tile;

public class Kong extends StaticEntity {
	private AudioPlayer chestBeat;

	// Constructor
	public Kong(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT*2);
		
		// set boundary for rocket entity
		bounds.x = 6;
		bounds.y = 6;// 
		bounds.width = width-10;
		bounds.height = height-20;
	} // end Constructor

	@Override
	public void tick() {
		
	} // end tick()
	
	@Override
	public void expired() {
		chestBeat = new AudioPlayer("/audio/kong.wav");
		chestBeat.play();
		handler.getWorld().getItemManager().addItem(Item.vikingHelmet.createNewItem((int) x, (int) y));
		
	} // expired()

	@Override
	public void render(Graphics magicalBrush) {	
		magicalBrush.drawImage(Assets.kong[0],
				(int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), 
				width, height, null);
		
	} // end render()

} // end Rocket Class
