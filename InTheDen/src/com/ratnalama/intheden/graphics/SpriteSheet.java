/**
 * SpriteSheet.java	--A program responsible to represent sprite sheet for creating game entities.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/26/2018
 */

package com.ratnalama.intheden.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;

	// Constructor
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	} // end Constructor

	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	} // end crop()

} // end SpriteSheet
