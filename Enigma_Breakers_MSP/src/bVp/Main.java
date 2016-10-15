package bVp;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {

		GameBoard gb = new GameBoard();	
		JFrame gw = new JFrame();
		gw.setTitle("Bee V Panda: Adventure in Jungle");
		gw.setSize(1000, 700);
		gw.add(gb);
		gw.setLocation(170, 15);
		gw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gw.setVisible(true);

	}

}
