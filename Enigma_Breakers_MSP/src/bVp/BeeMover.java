package bVp;

import java.awt.Rectangle;

public class BeeMover extends Thread {

	private Shooter shooter;
	private Bee bee;
	private GameBoard gb;

	public BeeMover( Bee bee, GameBoard gb, Shooter shooter){
		this.shooter = shooter;
		this.gb = gb;
		this.bee = bee;
	}

	public void run(){
		
		while(bee.getX() > - 100){
			bee.setX(bee.getX() - 1);		
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			gb.repaint();

			checkCollision();
		}
		bee.setX(1100);	//setting getX again to 1100
		run();	//starting from the beginning
	}			

	public void checkCollision(){

		Rectangle shooterRect = new Rectangle(shooter.getX(), shooter.getY(), 105, 120);	

		boolean isHit = false;

		Rectangle beeRect = new Rectangle(bee.getX(),bee.getY(),70,60); //105 because it'll be nearer when colliding

		if(shooterRect.intersects(beeRect) == true){
			isHit = true;
			
			gb.setLife(gb.getLife()-1); //Life of Shooter Decreasing
			if(gb.getLife()==0)
			{
				shooter.setX(1500);
			}

			bee.setImagePath("images//BeeBlast//blast1.png"); //When bullet hits a bee, it shows a blast
			try{
				Thread.sleep(100);
			}
			catch(Exception e){
				//exception handling
			}

			bee.setImagePath("images//Bee//Bee1.png"); //After Blast setting the image again

			bee.setX(1100); //Setting it again for coming continuously

		}


		if(isHit == true)
			GameSound.Shooter_Bee_Collide_Sound();

	}

}



