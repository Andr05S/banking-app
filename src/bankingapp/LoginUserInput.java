package bankingapp;
import java.util.HashMap; //allows us to use the same hashmap that we set up to take in the CSV
import java.util.Scanner; //takes in user inputs
public class LoginUserInput {

	public static boolean LoginPrompt() {
		// TODO Auto-generated method stub
		Scanner userInput = new Scanner(System.in); //read user input
		HashMap<String, String> logins = LoginArray.getFile(); //summon our CSV for comparison
		System.out.println("Enter your username"); //prompt the user
		String enteredName = userInput.nextLine(); //receive the user input and file it as a variable.
		//System.out.println("Your username is " +enteredName); // test for variable
		
		while (!logins.containsKey(enteredName)) {                             //check if the entered name matches
			System.out.println("Please enter your username");              //prompts user
			enteredName = userInput.nextLine();                             //takes user input and stores it as username
		}
		
		System.out.println("Hello " +enteredName);                     //greets user
		System.out.println("Please enter your password");              //asks user to enter password
		String enteredPassword = userInput.nextLine();                 // stores userinput in a new variable
		
		while (!logins.get(enteredName).equals(enteredPassword)) { //compares the password to the corresponding username's password stored in the hashmap
			System.out.println("Please enter your password");      //If it returns false, then the program loops until a correct password is entered.
			enteredPassword = userInput.nextLine();                //user is prompted to input a different password
		}
		System.out.println("Welcome!");                           //user is successful!
		userInput.close(); //close inputs.
		return true;
	}
}
