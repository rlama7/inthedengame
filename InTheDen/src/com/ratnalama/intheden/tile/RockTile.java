/**
 * RockTile.java	--A program responsible to represent a solid rock wall.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package com.ratnalama.intheden.tile;

import com.ratnalama.intheden.graphics.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		//super(Assets.wall, id);
		super(Assets.woodfence, id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

} // end RockTile Class
