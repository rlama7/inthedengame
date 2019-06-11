/**
 * UIObject.java		--A program to hold the core user interface of the game.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  11/04/2018
 */

package com.ratnalama.intheden.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {	

	protected float x, y;
	protected int width, height;
	protected boolean hovering = false;
	protected Rectangle bounds;
	
	// Constructor
	public UIObject(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height; 
		bounds = new Rectangle((int) x, (int) y, width, height);
		
	} // end Constructor
	
	/* ----------------ABSTRACT METHOD: Child Class Must Implement ----------------------------------- */
	
	// update
	public abstract void tick();
	
	// draw
	public abstract void render(Graphics magicalBrush);
	
	// event on mouse click
	public abstract void onClick();
	
	/* ----------------Utility Method --------------------------------------------------------------- */
	
	public void onMouseMove(MouseEvent e) {
		if (bounds.contains(e.getX(), e.getY())) {
			hovering = true;			
		} else {
			hovering = false;
		}		
	} // end onMouseMove()
	
	public void onMouseRelease(MouseEvent e) {
		if (hovering) {
			onClick();
		}		
	} // end onMouseRelease()	
	
	/* --------------------BEGIN Getters and Setters-------------------------------------------------- */
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}
	/* --------------------END Getters and Setters---------------------------------------------------- */

} // end UIObject
