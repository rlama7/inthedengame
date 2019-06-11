/**
 * BreakableWall.java	--A program responsible to represent a breakable wall - a static entity.
 * @author        		  Ratna Lama
 * @version       		  1.0
 * @since         		  11/15/2018
 */

package com.ratnalama.intheden.entity.statics;

import java.awt.Graphics;

import com.ratnalama.intheden.Handler;
import com.ratnalama.intheden.graphics.Assets;
import com.ratnalama.intheden.items.Item;
import com.ratnalama.intheden.tile.Tile;

public class BreakableWall extends StaticEntity{

	// Constructor
	public BreakableWall(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH*2, Tile.TILEHEIGHT*2);
		
		// set boundary for breakable walls
		bounds.x = 8;
		bounds.y = 8;
		bounds.width = width;
		bounds.height = height;		
	} // end Constructor

	// update
	@Override
	public void tick() {
				
	} // end tick()
	
	// expired
	@Override
	public void expired() {
		handler.getWorld().getItemManager().addItem(Item.fire.createNewItem((int) x, (int) y));
	} // end expired()
	
	// draw
	@Override
	public void render(Graphics magicalBrush) {
		magicalBrush.drawImage(Assets.redTree, 
				(int)(x-handler.getGameCamera().getxOffset()), 
				(int)(y-handler.getGameCamera().getyOffset()),
				width, height, null);		
	} // end render()

} // end BreakableWall Class
