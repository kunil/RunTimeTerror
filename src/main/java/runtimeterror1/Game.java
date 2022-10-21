package runtimeterror1;
import java.util.Random;

public class Game {

	public static void startGame() {
		
		int gridSize = 5;
		boolean gameComplete = false;
		
		Random randomX = new Random();
		Random randomY = new Random();
		
		Random randomXPlr = new Random();
		Random randomYPlr = new Random();
				
		
		int[] endGoalPosition = {randomX.nextInt(1, gridSize), randomY.nextInt(1, gridSize)};
		int[] plrCurrentPosition = {randomXPlr.nextInt(1, gridSize), randomYPlr.nextInt(1, gridSize)};
		
		System.out.println ("Grid is set at " + gridSize + " x " + gridSize);
		System.out.println("Goal is at position (" + endGoalPosition[0] + ", " + endGoalPosition[1] + ")");
		System.out.println("Player is at position (" + plrCurrentPosition[0] + ", " + plrCurrentPosition[1] + ")");
		
		
		while (gameComplete == false) {
			String plrInput = UserInput.plrMovement();
			int[] newPlrPosition = {plrCurrentPosition[0], plrCurrentPosition[1]};
			
			if (plrInput.equals("w")){
				if (newPlrPosition[1] <= 1) {
					newPlrPosition[1] = gridSize;
				}
				else {
					newPlrPosition[1] = newPlrPosition[1] - 1;
				}
			}
			
			else if (plrInput.equals("a")){
				if (newPlrPosition[0] <= 1) {
					newPlrPosition[0] = gridSize;
				}
				else {
					newPlrPosition[0] = newPlrPosition[0] - 1;
				}
			}
			
			else if (plrInput.equals("s")){
				if (newPlrPosition[1] >= 5) {
					newPlrPosition[1] = 1;
				}
				else {
					newPlrPosition[1] = newPlrPosition[1] + 1;
				}
			}
			
			else if (plrInput.equals("d")){
				if (newPlrPosition[0] >= 5) {
					newPlrPosition[0] = 1;
				}
				else {
					newPlrPosition[0] = newPlrPosition[0] + 1;
				}
			}
			System.out.println("Player's PREVIOUS position was at (" + plrCurrentPosition[0] + ", " + plrCurrentPosition[1] + ")");
			System.out.println("Goal is at position (" + endGoalPosition[0] + ", " + endGoalPosition[1] + ")");
			System.out.println("Player's CURRENT position was at (" + newPlrPosition[0] + ", " + newPlrPosition[1] + ")");
			
			plrCurrentPosition = newPlrPosition.clone();
			
			if (plrCurrentPosition[0] == endGoalPosition[0] && plrCurrentPosition[1] == endGoalPosition[1]) {
				System.out.println("Player has reached the treasure! Congratulations!");
				gameComplete = true;
			}
			
		}
		
		System.out.println ("Game has finished");
		
		
		
	}
	
}