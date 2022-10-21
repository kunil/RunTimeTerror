package runtimeterror1;


import java.util.Scanner;

public class UserInput {

	public static String readInput() {
		
		boolean validInput = false;
		String validDirection = null;
		while (validInput == false) {
			Scanner plrInput = new Scanner(System.in);
			System.out.println("Input a direction!");
			
			String direction = plrInput.nextLine();
			System.out.println(direction.toLowerCase());
			
			if (direction.toLowerCase().equals("w") || direction.toLowerCase().equals("a") || direction.toLowerCase().equals("s") || direction.toLowerCase().equals("d")) {
				validDirection = direction.toLowerCase();
				validInput = true;
			}		
		}
		System.out.println("Valid Input Done");
		//This will return either w, a, d or s based on user input
		return (validDirection);

	}
	
	
}

