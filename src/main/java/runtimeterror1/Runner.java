package runtimeterror1;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***************************");
		System.out.println("* Welcome to Hot or Cold! *");
		System.out.println("***************************");
		
		
		boolean contQuestion = true;
		while (contQuestion==true) {
			System.out.println();
			
			Scanner newGameScan = new Scanner(System.in);
			System.out.println("Do you want to play the game? [y/n]");
			String yN = newGameScan.nextLine();
			
			boolean contGame = true;
//			Game [] myGames = new Game[10];
//			int gameCounter = 0;
			
			if (yN.equals("y")) {
				// if we want to continue to play the game after it's over
				while (contGame) {
					System.out.println();
					System.out.println("Loading game...");
					System.out.println();
					System.out.println();

					
					// game ends, want to play again
					if (Game.runGame()==false) {
						contGame = false;
						System.exit(0);
					}
				}
				
				
			// if we don't want to play the game again
			} else if (yN.equals("n")){
				System.exit(0);
				contQuestion=false;
				break;
				
			// if input is invalid
			} else {
				System.out.println("Invalid input.");
				contQuestion=true;
			}
//			newGameScan.close();
		}
		

		
	}

}
