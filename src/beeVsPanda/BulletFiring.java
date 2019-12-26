package beeVsPanda;

import java.awt.*;

public class BulletFiring extends Thread {

	GameBoard gb;
	Bee[] bee;
	Bullet bullet;


	public BulletFiring(GameBoard gb, Bee[] bee,Bullet bullet){
		this.gb = gb;
		this.bee = bee;
		this.bullet = bullet;
	}

	public void run(){

		while(bullet.getX() < 975){ //Bullet hitting after crossing screen bug fixed

			bullet.setX(bullet.getX() + 1);
			checkCollision();
			try{
				Thread.sleep(3);
			}
			catch(Exception e){

			}
			gb.repaint();
		}
		bullet.setX(-50); //Bullet hitting after crossing screen bug fixed
	}


	public void checkCollision(){

		Rectangle bulletRect = new Rectangle(bullet.getX(),bullet.getY(),20,13);

		boolean isHit = false;

		for(int i = 0; i < bee.length; i++){

			Rectangle beeRect = new Rectangle(bee[i].getX(),bee[i].getY(),80,60);		
			if(bulletRect.intersects(beeRect) == true){
				GameBoard.score++;
				GameBoard.score = 9 + GameBoard.score; //for getting 10 points after shooting a bee

				isHit = true;

				bee[i].setImagePath("images//BeeBlast//blast1.png"); //When bullet hits a bee, it shows a blast
				try{
					Thread.sleep(100);
				}
				catch(Exception e){
					//exception handling
				}

				bee[i].setImagePath("images//Bee//Bee1.png"); //After Blast setting the image again

				bee[i].setX(1100);	//Bee outside of Screen Bug fixer
				bullet.setX(2000);	//Bullet outside of Screen Bug fixer

				break;
			}

		}

		if(isHit == true)
			GameSound.bulletHitSound();


	}


}
