/**
 * Assets.java		--A program responsible to display game assets.
 * @author            Ratna Lama
 * @version           1.0
 * @since             10/27/2018
 */

package com.ratnalama.intheden.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;	// grid space dimension
	
	public static Font font12, font16, font20, font28, font32;
	
	public static BufferedImage brownWall, gravelWall, greenWall, palmTree, redTree, rockFloor,
								greenTree, darkBrownWall, redTank, explosion1, leftBullet, 
								greenTank, explosion2, rightBullet, tire, grass, stoneWallLeft, 
								stoneWallMiddle, stoneWallCorner, rocket01, rocket02, rocket03, 
								rocket04, rewardItem01, egg, fire, honey, pork, redMushroom, 
								crown, tShell, vikingHelmet, menu, wall, woodfence, lion; 

	
	// Animation
	public static BufferedImage[] greenTankUp, greenTankRight, greenTankDown, greenTankLeft,	
								bulletUp, bulletDown, bulletRight, bulletLeft;
	public static BufferedImage[] playerUp, playerDown, playerLeft, playerRight;
	public static BufferedImage[] bee, boar, turtle, mushroom, vulture, kong;
	
	// Start button
	public static BufferedImage[] startButton;
		
	// Inventory
	public static BufferedImage inventoryScreen;	
	
	public static BufferedImage[] walkRight, walkLeft, walkUp, walkDown;
	
	
	// Initialize game sprite once
	public static void init() {
		// Silk Screen TTF Font
		font12 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 12);
		font16 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 16);
		font20 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 20);
		font28 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 28);
		font32 = FontLoader.loadFont("resources/fonts/slkscrb.ttf", 32);
		
		//SpriteSheet 
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet04D.png"));
		SpriteSheet animationSheet = new SpriteSheet(ImageLoader.loadImage("/textures/greenTankAnimation04.png"));
		SpriteSheet startMenu = new SpriteSheet(ImageLoader.loadImage("/textures/play02.png"));
		SpriteSheet bulletAnimation = new SpriteSheet(ImageLoader.loadImage("/textures/bullet04.png"));
		SpriteSheet rocket = new SpriteSheet(ImageLoader.loadImage("/textures/rocket01.png"));
		SpriteSheet rewardItem = new SpriteSheet(ImageLoader.loadImage("/textures/rewardItem01.png"));
		inventoryScreen = ImageLoader.loadImage("/textures/inventoryScreen.png");
		SpriteSheet greenGrass = new SpriteSheet(ImageLoader.loadImage("/textures/grass01.png"));
		SpriteSheet brickWall = new SpriteSheet(ImageLoader.loadImage("/textures/brickWall01.png"));
		SpriteSheet gameMenu01 = new SpriteSheet(ImageLoader.loadImage("/textures/gameMenu01.png"));
		SpriteSheet lionSheet = new SpriteSheet(ImageLoader.loadImage("/textures/lion.png"));
		SpriteSheet fence = new SpriteSheet(ImageLoader.loadImage("/textures/woodfence.png"));
		SpriteSheet tree = new SpriteSheet(ImageLoader.loadImage("/textures/red-green-tree.png"));
		SpriteSheet floor = new SpriteSheet(ImageLoader.loadImage("/textures/rockFloor.png"));
		SpriteSheet eggSheet = new SpriteSheet(ImageLoader.loadImage("/textures/egg.png"));
		SpriteSheet porkSheet = new SpriteSheet(ImageLoader.loadImage("/textures/pork.png"));
		SpriteSheet crownSheet = new SpriteSheet(ImageLoader.loadImage("/textures/crown.png"));
		SpriteSheet honeySheet = new SpriteSheet(ImageLoader.loadImage("/textures/honey.png"));
		SpriteSheet gsSheet = new SpriteSheet(ImageLoader.loadImage("/textures/greenShell.png"));
		SpriteSheet vikingSheet = new SpriteSheet(ImageLoader.loadImage("/textures/vikingHelmet.png"));
		SpriteSheet fireSheet = new SpriteSheet(ImageLoader.loadImage("/textures/fire.png"));
		SpriteSheet mushroomSheet = new SpriteSheet(ImageLoader.loadImage("/textures/redMushroom.png"));
		
		
		// Animation
		greenTankUp = new BufferedImage[2];
		greenTankRight = new BufferedImage[2];
		greenTankDown = new BufferedImage[2];
		greenTankLeft = new BufferedImage[2];
		bulletUp = new BufferedImage[2];
		bulletDown = new BufferedImage[2];
		bulletRight = new BufferedImage[2];
		bulletLeft = new BufferedImage[2];
		
		// player animation
		// right
		playerRight = new BufferedImage[6];
		playerRight[0] = ImageLoader.loadImage("/textures/right1.png");
		playerRight[1] = ImageLoader.loadImage("/textures/right2.png");
		playerRight[2] = ImageLoader.loadImage("/textures/right3.png");
		playerRight[3] = ImageLoader.loadImage("/textures/right4.png");
		playerRight[4] = ImageLoader.loadImage("/textures/right5.png");
		playerRight[5] = ImageLoader.loadImage("/textures/right6.png");
		// left		
		playerLeft = new BufferedImage[4];
		playerLeft[0] = ImageLoader.loadImage("/textures/left1.png");
		playerLeft[1] = ImageLoader.loadImage("/textures/left2.png");
		playerLeft[2] = ImageLoader.loadImage("/textures/left3.png");
		playerLeft[3] = ImageLoader.loadImage("/textures/left4.png");
		//up
		playerUp = new BufferedImage[7];
		playerUp[0] = ImageLoader.loadImage("/textures/up1.png");
		playerUp[1] = ImageLoader.loadImage("/textures/up2.png");
		playerUp[2] = ImageLoader.loadImage("/textures/up3.png");
		playerUp[3] = ImageLoader.loadImage("/textures/up4.png");
		playerUp[4] = ImageLoader.loadImage("/textures/up5.png");
		playerUp[5] = ImageLoader.loadImage("/textures/up6.png");
		playerUp[6] = ImageLoader.loadImage("/textures/up7.png");
		// down
		playerDown = new BufferedImage[6];
		playerDown[0] = ImageLoader.loadImage("/textures/down1.png");
		playerDown[1] = ImageLoader.loadImage("/textures/down2.png");
		playerDown[2] = ImageLoader.loadImage("/textures/down3.png");
		playerDown[3] = ImageLoader.loadImage("/textures/down4.png");
		playerDown[4] = ImageLoader.loadImage("/textures/down5.png");
		playerDown[5] = ImageLoader.loadImage("/textures/down6.png");
		
		// wild animals
		//bee
		bee = new BufferedImage[4];
		bee[0] = ImageLoader.loadImage("/textures/bee1.png");
		bee[1] = ImageLoader.loadImage("/textures/bee2.png");
		bee[2] = ImageLoader.loadImage("/textures/bee3.png");
		bee[3] = ImageLoader.loadImage("/textures/bee4.png");
		// boar
		boar = new BufferedImage[4];
		boar[0] = ImageLoader.loadImage("/textures/boar1.png");
		boar[1] = ImageLoader.loadImage("/textures/boar2.png");
		boar[2] = ImageLoader.loadImage("/textures/boar3.png");
		boar[3] = ImageLoader.loadImage("/textures/boar4.png");		
		// kong
		kong = new BufferedImage[5];
		kong[0] = ImageLoader.loadImage("/textures/kong1.png");
		kong[1] = ImageLoader.loadImage("/textures/kong2.png");
		kong[2] = ImageLoader.loadImage("/textures/kong3.png");
		kong[3] = ImageLoader.loadImage("/textures/kong4.png");
		kong[4] = ImageLoader.loadImage("/textures/kong5.png");
		// mushroom
		mushroom = new BufferedImage[6];
		mushroom[0] = ImageLoader.loadImage("/textures/shroom1.png");
		mushroom[1] = ImageLoader.loadImage("/textures/shroom2.png");
		mushroom[2] = ImageLoader.loadImage("/textures/shroom3.png");
		mushroom[3] = ImageLoader.loadImage("/textures/shroom4.png");
		mushroom[4] = ImageLoader.loadImage("/textures/shroom5.png");
		mushroom[5] = ImageLoader.loadImage("/textures/shroom6.png");
		// turtle
		turtle = new BufferedImage[5];
		turtle[0] = ImageLoader.loadImage("/textures/turtle1.png");
		turtle[1] = ImageLoader.loadImage("/textures/turtle2.png");
		turtle[2] = ImageLoader.loadImage("/textures/turtle3.png");
		turtle[3] = ImageLoader.loadImage("/textures/turtle4.png");
		turtle[4] = ImageLoader.loadImage("/textures/turtle5.png");
		
		// vulture
		vulture = new BufferedImage[4];
		vulture[0] = ImageLoader.loadImage("/textures/vulture1.png");
		vulture[1] = ImageLoader.loadImage("/textures/vulture2.png");
		vulture[2] = ImageLoader.loadImage("/textures/vulture3.png");
		vulture[3] = ImageLoader.loadImage("/textures/vulture4.png");
		
		
		// StartButton 
		startButton = new BufferedImage[2];
		startButton[0] = startMenu.crop(0, 0, width*4, height*2);
		startButton[1] = startMenu.crop(0, height*2, width*4, height*2);
		
		
		// Animation frames
		greenTankUp[0] = animationSheet.crop(0, 0, width-1, height-1);
		greenTankUp[1] = animationSheet.crop(width-1, 0, width-1, height-1);
		
		greenTankRight[0] = animationSheet.crop((width-1)*2, 0, width-1, height-1);
		greenTankRight[1] = animationSheet.crop((width-1)*3, 0, width-1, height-1);
				
		greenTankDown[0] = animationSheet.crop(0, height-1, width-1, height-1);
		greenTankDown[1] = animationSheet.crop(width-1, height-1, width-1, height-1);
				
		greenTankLeft[0] = animationSheet.crop((width-1)*2, height-1, width-1, height-1);
		greenTankLeft[1] = animationSheet.crop((width-1)*3, height-1, width-1, height-1);
				
		// bullet animation
		bulletUp[0] = bulletAnimation.crop(0, 0, width, height);
		bulletUp[1] = bulletAnimation.crop(0, width, width, height);
		
		bulletDown[0] = bulletAnimation.crop(width, 0, width, height);
		bulletDown[1] = bulletAnimation.crop(width, height, width, height);
		
		bulletRight[0] = bulletAnimation.crop(width*2, 0, width, height);
		bulletRight[1] = bulletAnimation.crop(width*2, height, width, height);
		
		bulletLeft[0] = bulletAnimation.crop(width*3, 0, width, height);
		bulletLeft[1] = bulletAnimation.crop(width*3, height, width, height);
		
		// menu
		
		menu = gameMenu01.crop(0, 0, width, height);
		
		// Other Assets
		brownWall = sheet.crop(0, 0, width, height);
		gravelWall = sheet.crop(width, 0, width, height);
		greenWall = sheet.crop(width*2, 0, width, height);
		palmTree = sheet.crop(width*3, 0, width, height);
		wall = brickWall.crop(0, 0, width, height);
		
		darkBrownWall = sheet.crop(0, height, width, height);
		redTank = sheet.crop(width, height, width, height);
		explosion1 = sheet.crop(width*2, height, width, height);
		leftBullet = sheet.crop(width*3, height, width, height);
		
		greenTank = sheet.crop(0, height*2, width, height);
		explosion2 = sheet.crop(width, height*2, width, height);
		rightBullet = sheet.crop(width*2, height*2, width, height);
		tire = sheet.crop(width*3, height*2, width, height);
		
		grass = greenGrass.crop(0, 0, width, height);
		stoneWallLeft = sheet.crop(width, height*3, width, height);
		stoneWallMiddle = sheet.crop(width*2, height*3, width, height);
		stoneWallCorner = sheet.crop(width*3, height*3, width, height);
		
		rocket01 = rocket.crop(0, 0, width*2, height*2);
		rocket02 = rocket.crop(width*2, 0, width*2, height*2);
		rocket03 = rocket.crop(0, height*2, width*2, height*2);
		rocket04 = rocket.crop(width*2, height*2, width*2, height*2);
		
		// lion
		lion = lionSheet.crop(0, 0, width*4, height*4);
		woodfence = fence.crop(0, 0, width*2, height*2);
		greenTree = tree.crop(0, 0, width*2, height*2);
		redTree = tree.crop(0, height*2, width*2, height*2);
		rockFloor = floor.crop(0, 0, width*2, height*2);
		
		// reward item
		rewardItem01 = rewardItem.crop(0, 0, width/2, height/2);
		egg = eggSheet.crop(0, 0, width*4, height*4); 
		fire = fireSheet.crop(0, 0, width*4, height*4); 
		honey = honeySheet.crop(0, 0, width*4, height*4);  
		pork = porkSheet.crop(0, 0, width*4, height*4); 
		redMushroom = mushroomSheet.crop(0, 0, width*4, height*4);
		crown = crownSheet.crop(0, 0, width*4, height*4); 
		tShell = gsSheet.crop(0, 0, width*4, height*4);
		vikingHelmet = vikingSheet.crop(0, 0, width*4, height*4);
		
	} // end init()
} // end Assets Class
