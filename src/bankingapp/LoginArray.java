package bankingapp; //where we is
import java.io.*; //we need this for our io exception checker.
import java.util.HashMap; //we need this to make a hashmap
public class LoginArray {

	public static HashMap<String, String> getFile() {
		// TODO Auto-generated method stub
		String file = "src\\csvforlogins.csv"; //calling the file where the login info is stored
		BufferedReader valueReader = null; //creating a reader to read the file
		HashMap<String, String> logins = new HashMap<String, String>(); //creating a hashmap to store the file
		String line; /*creating a string variable to convert from the csv file into lines 
		that the hashmap can understand*/
		try { //means that we will try this as many times as we can
			valueReader = new BufferedReader(new FileReader(file)); //this reads the file
			while((line = valueReader.readLine()) !=null) { /*while it returns a value, keeps going. 
			*stops when returns no value
			*This also resets our userName and passWord variable
			*each time while the logins hashmap does not reset.
			*Each iteration that runs will store a new value in a new space of the hashmap as a result
			*/
				String[] userArray = line.split(",");//splits the list at every comma
				String userName = userArray[0]; /*makes userName = first value of array*/
				String passWord = userArray[1]; /*makes passWord = second value of array*/
						logins.put(userName, passWord); //stores values in our hashmap
						//System.out.println(line); //test to make sure values are being written to line
				}
			
			
		}
		catch(Exception e) { //finds errors
			e.printStackTrace(); //prints the errorcode
		}
		finally {
		try{
			valueReader.close(); //close our reader
		}
		catch (IOException e) {
			e.printStackTrace(); //catch errors
		}
		}
		/*
		 * The block below tests our Hashmap for the stored values
		 * At each point "i" it loads up a key and its corresponding value
		 * *if its working right lol
		 * */
		/*for (String i : logins.keySet()) { 
		System.out.println(i);
		System.out.println(logins.get(i));
		}*/
		return logins;
	}
}
