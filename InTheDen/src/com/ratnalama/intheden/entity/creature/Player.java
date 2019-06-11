/**
 * Player.java		--A program responsible to represent the various players in the game.
 * @author            Ratna Lama
 * @version           1.0
 * @since             11/01/2018
 */

package com.ratnalama.intheden.entity.creature;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.ratnalama.intheden.Handler;
import com.ratnalama.intheden.audio.AudioPlayer;
import com.ratnalama.intheden.audio.AudioPlayerManager;
import com.ratnalama.intheden.entity.Entity;
import com.ratnalama.intheden.entity.collidable.Bullet;
import com.ratnalama.intheden.entity.collidable.BulletController;
import com.ratnalama.intheden.graphics.Animation;
import com.ratnalama.intheden.graphics.Assets;
import com.ratnalama.intheden.inventory.Inventory;

public class Player extends Creature {
	
	// Animations
	private Animation animUp, animRight, animDown, animLeft;
	private Animation bulletUpAnim, bulletDownAnim, bulletRightAnim, bulletLeftAnim;
	private Animation walkRight, walkLeft, walkUp, walkDown;
	
	
	// Bullet Controller
	private int ammo;
	private Bullet magazine;
	private BulletController bulletController;
	
	
	// Attack timer
	private long lastAttackTimer, attackCooldown = 100, attackTimer = attackCooldown;
	
	// Inventory
	private Inventory inventory;
	
	// sound effect
	private HashMap<String, AudioPlayer> sfx;
	//private AudioPlayerManager sfx1;
	
	// text 
	private static Font font;

	// Constructor
	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 10;
		bounds.y = 10;
		bounds.width = 50;
		bounds.height = 45;
		ammo = 20;
		bulletController = new BulletController(handler);
		
		// sound effect
		//sfx1.initSound();
		sfx = new HashMap<String, AudioPlayer>();
		sfx.put("sword", new AudioPlayer("/audio/sword.wav"));
		
		
		// Animations		
		// tank animation
		animUp = new Animation(500, Assets.greenTankUp);
		animRight = new Animation(500, Assets.greenTankRight); 
		animDown = new Animation(500, Assets.greenTankDown);
		animLeft = new Animation(500, Assets.greenTankLeft);
		
		// player walk
		walkRight = new Animation(700, Assets.playerRight);
		walkLeft = new Animation(700, Assets.playerLeft);
		walkUp = new Animation(700, Assets.playerUp);
		walkDown = new Animation(700, Assets.playerDown);
		
		
		
		// bullet animation
		// bullet controller
		bulletUpAnim = new Animation(500, Assets.bulletUp);
		bulletDownAnim = new Animation(500, Assets.bulletDown);
		bulletRightAnim = new Animation(500, Assets.bulletRight);
		bulletLeftAnim = new Animation(500, Assets.bulletLeft);
		//shootBullet();
		
		
		// inventory
		inventory = new Inventory(handler);
		
		
		
	} // end Constructor
	

	@Override
	public void tick() {
		// Animations
		animUp.tick();
		animRight.tick();
		animDown.tick();
		animLeft.tick();
		
		walkRight.tick();
		walkLeft.tick();
		walkUp.tick();
		walkDown.tick();
		
		//bulletController.tick();		
		bulletUpAnim.tick();
		bulletDownAnim.tick();
		bulletRightAnim.tick();
		bulletLeftAnim.tick();
		
		// Movement
		getInput();
		move();
		handler.getGameCamera().centerEntity(this);
		
		// check Attack
		checkAttack();
		
		// tick inventory
		inventory.tick();	
	} // end tick()
	
	// check attack
	private void checkAttack() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		
		if (attackTimer < attackCooldown) {
			return;		
		}
		
		Rectangle cb = getCollisionBounds(0, 0); // co-ordinate of the collision box
		Rectangle attack = new Rectangle();
		int attackSize = 10;
		attack.width = attackSize;
		attack.height = attackSize;
		
		if (handler.getKeyManager().bulletUp) {	
			attack.x = cb.x + cb.width / 2 - attackSize / 2;
			attack.y = cb.y - attackSize;
			bulletUpAnim.tick();
			//shootBullet();
			//bulletController.addBullet(magazine);
		} else if (handler.getKeyManager().bulletDown) {
			attack.x = cb.x + cb.width / 2 - attackSize / 2;
			attack.y = cb.y + cb.height;
			bulletDownAnim.tick();
			//shootBullet();
			//bulletController.addBullet(magazine);
		} else if (handler.getKeyManager().bulletLeft) {
			attack.x = cb.x + - attackSize;
			attack.y = cb.y + cb.height / 2 - attackSize / 2;
			bulletLeftAnim.tick();
			//shootBullet();
			//bulletController.addBullet(magazine);
		} else if (handler.getKeyManager().bulletRight){
			attack.x = cb.x + cb.width;
			attack.y = cb.y + cb.height / 2 - attackSize / 2;
			bulletRightAnim.tick();
			//shootBullet();
			//bulletController.addBullet(magazine);
		} else {
			return;	// if not attacking simply return			
		} // end if-else
		
//		if (handler.getKeyManager().bullet) {
//			shootBullet();
//		} else {
//			return;
//		}
//		
		attackTimer = 0;
		
		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) { 
				continue;
			}
			
			if (e.getCollisionBounds(0, 0).intersects(attack)) {
				e.hurt(1);
				return;
			}			
		}		
	} // end checkAttack()
	
	// check if entity has expired
	@Override
	public void expired() {
		System.out.println("You Loose! Game Over!!");
	} // expired()
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
		if (handler.getKeyManager().up) {
			sfx.get("sword").play();
			yMove = -speed;			
		}
		if (handler.getKeyManager().down) {
			sfx.get("sword").play();
			yMove = speed;			
		}
		if (handler.getKeyManager().left) {
			sfx.get("sword").play();
			xMove = -speed;			
		}
		if (handler.getKeyManager().right) {
			sfx.get("sword").play();
			xMove = speed;			
		}		
	} // end getInput()
	

	@Override
	public void render(Graphics magicalBrush) {
		// bullet
		//bulletController.render(magicalBrush);
		
		magicalBrush.drawImage(getCurrentAnimationFrame(), 
				(int) (x - handler.getGameCamera().getxOffset()), 
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		// draw text
		font = Assets.font20;
		magicalBrush.setFont(font);
	    String health = Integer.toString(this.getHealth());	 
	    magicalBrush.setColor(Color.red);
	    magicalBrush.drawString("Info> ", 1070, 280);
	    magicalBrush.setColor(Color.blue);
	    magicalBrush.drawString("Health> " + health, 1070, 300);
	    
				
//		magicalBrush.drawImage(getBulletAnimationFrame(), 
//				(int) (x - handler.getGameCamera().getxOffset()),
//				(int) (y - handler.getGameCamera().getyOffset()),
//				width, height, null);
		
		//shootBullet();
		
	} // end render()
	
	// render inventory
	public void postRender(Graphics magicalBrush) {		
		inventory.render(magicalBrush);		
	} // end postRender()
	
	
	// Tank rotation animation
	private BufferedImage getCurrentAnimationFrame() {
		
		// check which direction is the player moving 
		// and display the corresponding animation
		if (yMove < 0) {
			return walkUp.getCurrentFrame();
		} else if (yMove > 0) {
			return walkDown.getCurrentFrame();
		} else if (xMove < 0) {
			return walkLeft.getCurrentFrame();
		} else if(xMove > 0) {
			return walkRight.getCurrentFrame();
		} // end if-else
		return walkRight.getCurrentFrame();
	} // end getCurrentAnimationFrame()
	
	// bullet firing animation
//	private BufferedImage getBulletAnimationFrame() {
//		
//		// check which direction is the bullet fired and
//		// display the corresponding animation
//		if (yMove < 0) {
//			return bulletUpAnim.getCurrentFrame();			
//		} else if (yMove > 0) {
//			return bulletDownAnim.getCurrentFrame();			
//		} else if (xMove < 0) {
//			return bulletLeftAnim.getCurrentFrame();			
//		} else {
//			return bulletRightAnim.getCurrentFrame();
//		} // end if-else
//	} // end getBulletAnimationFrame()
	
	
	/* -------------------------BEGIN Getters and Setters----------------------------- */
	public Inventory getInventory() {
		return inventory;
	}
	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}
	
	public int getHealth() {
		return health;
	}
	
	/* -------------------------END Getters and Setters------------------------------- */

} // end Player Class
