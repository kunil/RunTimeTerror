package runtimeterror1;

import java.lang.reflect.Array;
import java.util.Random;

public class Game {

	static int gridSize = 5;
	static boolean gameComplete = false;

	static Random randomX = new Random();
	static Random randomY = new Random();

	static Random randomXPlr = new Random();
	static Random randomYPlr = new Random();

	static int[] endGoalPosition = { randomX.nextInt(0, gridSize-1), randomY.nextInt(0, gridSize-1) };
	static int[] plrCurrentPosition = { randomXPlr.nextInt(0, gridSize-1), randomYPlr.nextInt(0, gridSize-1) };

	public static void isGameOver(String plrInput) {
		if ((plrCurrentPosition[0] == endGoalPosition[0] && plrCurrentPosition[1] == endGoalPosition[1])) {
			System.out.println("Player has reached the treasure! Congratulations!");
			gameComplete = true;
			System.out.println("-------------------------------- END OF GAME --------------------------------");
		} else if (plrInput.equals("q")) {
			System.out.println("Thanks for playing! Quitting game.");
			gameComplete = true;
			System.out.println("-------------------------------- END OF GAME --------------------------------");
		}
		
	}

	public static int[] createPlayerPosition() {

		Random randomXPlr = new Random();
		Random randomYPlr = new Random();

		int[] plrCurrentPosition = { randomXPlr.nextInt(1, gridSize), randomYPlr.nextInt(1, gridSize) };
		return (plrCurrentPosition);
	}

	public static void updatePosition(int[] playerPlay) {
		System.out.println("old pos: "+plrCurrentPosition[0]+", "+plrCurrentPosition[1]);
		int newX = (Array.getInt(plrCurrentPosition, 0) + Array.getInt(playerPlay, 0));
		plrCurrentPosition[0] = newX;
		int newY = (Array.getInt(plrCurrentPosition, 1) + Array.getInt(playerPlay, 1));
		plrCurrentPosition[1] = newY;
		System.out.println("new pos: "+plrCurrentPosition[0]+", "+plrCurrentPosition[1]);
	}

	// TO BE IMPLEMENTED: JUWON
	public static boolean checkBounds(int [] playerPlay) {
//		if ((plrGivenInput.equals("w") && plrCurrentPosition[1] <= 1)
//				|| (plrGivenInput.equals("a") && plrCurrentPosition[0] <= 1)
//				|| (plrGivenInput.equals("s") && plrCurrentPosition[1] >= gridSize)
//				|| (plrGivenInput.equals("d") && plrCurrentPosition[0] >= gridSize)) {
//			System.out.println("Input out of bounds!");
//			System.out.println();
//			return false;
//		}
		
		
		if (plrCurrentPosition[0]+playerPlay[0]<0 || plrCurrentPosition[0]+playerPlay[0]>gridSize) {
			return false;
		}
		if ((plrCurrentPosition[1]+playerPlay[1]<0 || plrCurrentPosition[1]+playerPlay[1]>gridSize)) {
			return false;
		}
		return true;
	}

	// TAKES WSAD, RETURNS COORDS
	public static int[] interpretPlayerPos(String plrInput) {
		int playerPlay[] = { 0, 0 };
		if (plrInput.equals("w")) {
			playerPlay[0] = -1;
		} else if (plrInput.equals("a")) {
			playerPlay[1] = -1;
		} else if (plrInput.equals("s")) {
			playerPlay[0] = 1;
		} else if (plrInput.equals("d")) {
			playerPlay[1] = 1;
		}
		return playerPlay;
	}

	// CALCULATES DISTANCE TO DETERTMINE HOTTER/COLDER
	public static boolean calculateDistance(int[] playerPlay) {
		// if hotter, return true
		// else, return false
		double prevDistance = Math.sqrt(Math.pow((endGoalPosition[0] - plrCurrentPosition[0]), 2)
				+ Math.pow((endGoalPosition[1] - plrCurrentPosition[1]), 2));

		int newPos[] = { plrCurrentPosition[0] + playerPlay[0], plrCurrentPosition[1] + playerPlay[1] };

		double newDistance = Math
				.sqrt(Math.pow((endGoalPosition[0] - newPos[0]), 2) + Math.pow((endGoalPosition[1] - newPos[1]), 2));

		if (newDistance < prevDistance) {
			return true;
		} else {
			return false;
		}
	}

	// OUTPUTS HOTTER OR COLDER
	public static void hotterColderOutput(boolean hotter) {
		if (hotter) {
			System.out.println("You're getting warmer!");
		} else {
			System.out.println("You're getting colder :(");
		}
	}

	// TO BE IMPLEMENTED: KUNIL
	// O O O O O
	// O O O X O
	// O O O O O
	// O O O O O
	// "X = player's position"
	// "O = spaces on map"
	public static void displayGrid() {
		for (int j = 0; j <= gridSize; j++) {
			for (int i = 0; i <= gridSize; i++) {
				if (i == plrCurrentPosition[1] && j == plrCurrentPosition[0])
					System.out.print("P ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}

	}

	// RUNS THE GAME
	public static boolean runGame() {

		while (gameComplete == false) {
			// takes input
			String plrInput = UserInput.readInput(); // W A S D Q
			
			isGameOver(plrInput);
			
			if (gameComplete == true) {
				return false;
			} // break the loop

			int playerPlay[] = interpretPlayerPos(plrInput);
			// user always asking for valid move
			if (checkBounds(playerPlay) == false) {
				boolean askAgain = true;
				
				while (askAgain == true) {
					
					System.out.println("Input out of bounds!");
					plrInput = UserInput.readInput();
					isGameOver(plrInput);
					
					playerPlay[0] = interpretPlayerPos(plrInput)[0];
					playerPlay[1] = interpretPlayerPos(plrInput)[1]; 
					
					if (checkBounds(playerPlay) == true) {
						

						askAgain = false;
					}
					
				}
			}

			// wsad -> coords
			updatePosition(playerPlay);

			// is it hotter or colder?
			hotterColderOutput(calculateDistance(playerPlay));
			displayGrid();
			System.out.println("**************************************************");
			System.out.println();

		}
		
		return true;

	}

}

// ***********************************************************************************
// REST OF CODE
//String plrInput = UserInput.plrMovement();
//int[] newPlrPosition = {plrCurrentPosition[0], plrCurrentPosition[1]};
//
//if (plrInput.equals("w")){
//	if (newPlrPosition[1] <= 1) {
//		newPlrPosition[1] = gridSize;
//	}
//	else {
//		newPlrPosition[1] = newPlrPosition[1] - 1;
//	}
//}
//
//else if (plrInput.equals("a")){
//	if (newPlrPosition[0] <= 1) {
//		newPlrPosition[0] = gridSize;
//	}
//	else {
//		newPlrPosition[0] = newPlrPosition[0] - 1;
//	}
//}
//
//else if (plrInput.equals("s")){
//	if (newPlrPosition[1] >= 5) {
//		newPlrPosition[1] = 1;
//	}
//	else {
//		newPlrPosition[1] = newPlrPosition[1] + 1;
//	}
//}
//
//else if (plrInput.equals("d")){
//	if (newPlrPosition[0] >= 5) {
//		newPlrPosition[0] = 1;
//	}
//	else {
//		newPlrPosition[0] = newPlrPosition[0] + 1;
//	}
//}
//
//
//System.out.println("Player's PREVIOUS position was at (" + plrCurrentPosition[0] + ", " + plrCurrentPosition[1] + ")");
//System.out.println("Goal is at position (" + endGoalPosition[0] + ", " + endGoalPosition[1] + ")");
//System.out.println("Player's CURRENT position is at (" + newPlrPosition[0] + ", " + newPlrPosition[1] + ")");
//
//plrCurrentPosition = newPlrPosition.clone();
