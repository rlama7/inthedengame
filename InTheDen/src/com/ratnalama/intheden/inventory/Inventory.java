/**
 * Inventory.java	--A program responsible to represent item inventory class.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/14/2018
 */

package com.ratnalama.intheden.inventory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.ratnalama.intheden.Handler;
import com.ratnalama.intheden.entity.creature.Player;
import com.ratnalama.intheden.graphics.Assets;
import com.ratnalama.intheden.graphics.Text;
import com.ratnalama.intheden.items.Item;

public class Inventory {
	
	private Handler handler;
	private Player player1;

	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private static Font font;
	
	private int invX = 32, invY = 32,
			invWidth = 200, invHeight = 200,
			invListCenterX = invX, 
			invListCenterY = invY; 
	
	// Constructor
	public Inventory(Handler handler) {
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
		// test
		//addItem(Item.rewardItem01.createNewItem(5));
		
		
	} // end Constructor
	
	// update
	public void tick() {
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_M)) {
			active = !active;
		}
		
		if (!active) {
			return;
		}
				
	} // end tick()
	
	// draw
	public void render(Graphics magicalBrush) {
//		if (!active) {
//			return;
//		}
		
		// inventory screen
		//magicalBrush.drawImage(Assets.inventoryScreen, invX, invY+530, invWidth, invHeight-100, null);
		
		
		// draw text
		//font = new Font("SanSerif", Font.BOLD, 24);
		font = Assets.font20;
		magicalBrush.setFont(font);
		magicalBrush.setColor(Color.blue);
		String itemCount = Integer.toString(inventoryItems.size());	    
		magicalBrush.drawString("Item> " + itemCount, 1070, 320);
			
//		String health = Integer.toString(player1.getHealth());
//		String itemCount = Integer.toString(inventoryItems.size());
//		
//		Text.drawString(magicalBrush, "Player Info ", invListCenterX+50, 
//				invListCenterY + 540, true, Color.WHITE, Assets.font12);
//		Text.drawString(magicalBrush, "Health> " + health, invListCenterX+50, 
//				invListCenterY + 560, true, Color.WHITE, Assets.font12);
//		Text.drawString(magicalBrush, "Power> " + itemCount, invListCenterX+50, 
//				invListCenterY + 580, true, Color.WHITE, Assets.font12);
//		System.out.println("INVENTORY: ");
//		for (Item i : inventoryItems) {
//			System.out.println(i.getName() + " " + i.getCount());
//		}
//		for (Item i : inventoryItems) {
//			System.out.println(i.getName() + " " + i.getCount());
//		}
				
	} // render()
	
	/* ----------------------BEGIN Utility Methods------------------------------ */
	public void addItem(Item item) {
		for (Item i : inventoryItems) {
			if (i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);		
	} // end addItem()	
	/* ----------------------END Utility Methods-------------------------------- */
	
	
	/* ----------------------BEGIN Getters and Setters------------------------- */
	public Handler getHandler() {
		return handler;
	}

	public boolean isActive() {
		return active;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	public Player getPlayer1() {
		return player1;
	}
	/* ----------------------END Getters and Setters--------------------------- */
} // end Inventory Class
