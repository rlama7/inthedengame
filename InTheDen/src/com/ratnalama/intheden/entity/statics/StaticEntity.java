/**
 * StaticEntity.java	--A program responsible to represent static entities.
 * @author            	  Ratna Lama
 * @version           	  1.0
 * @since             	  11/04/2018
 */

package com.ratnalama.intheden.entity.statics;

import com.ratnalama.intheden.Handler;
import com.ratnalama.intheden.entity.Entity;

public abstract class StaticEntity extends Entity {

	// Constructor
	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);

	} // end Constructor

} // end StaticEntity Class
