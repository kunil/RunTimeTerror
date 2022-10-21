package runtimeterror1;


public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to Hot or Cold!");
		System.out.println("Do you want to play the game?");
		
		Game game1 = new Game();
		UserInput ui = new UserInput();
		
		game1.startGame();
		UserInput.plrMovement();
		
	}

}
