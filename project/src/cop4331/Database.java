package cop4331;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * 
 * @author Jevon Harriott
 *
 */

public class Database {
	
	private static Database project= new Database();
	
	private Database() {
			LoadDatabase();
			outputDatabase();
	}
	
	public static Database getInstance(){
		return project;
	}
	
	
	@SuppressWarnings("unchecked")
	/**
	 * load the user database by reading the registry.ser file
	 */
	public void LoadDatabase(){
		
	      try {
	    	  //InputStream fileIn = Database.class.getResourceAsStream("/registry.ser");
	         FileInputStream fileIn = new FileInputStream("registry.ser");
	         ObjectInputStream out= new ObjectInputStream(fileIn);
	    	 this.users = (ArrayList<User>)out.readObject();
	    	 out.close();
	         fileIn.close();
	        
	      }catch(IOException i) {
	         i.printStackTrace();
	        
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * add the user to the registry
	 * @param username is the username enter from the user
	 * @param password is the password entered
	 * @param type is the type of customer selected
	 */
	public void addUsers(String username,String password, String type){
		if(type.equals("Seller")){
			this.users.add(new Seller(username,password,"Seller"));
			
		}
		else if(type.equals("Customer")){
			this.users.add(new Customer(username,password,"Customer"));
		}
		 try {
			 new FileOutputStream("registry.ser").close();
	         FileOutputStream fileOut =
	         new FileOutputStream("registry.ser",true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(users);
	         out.close();
	         fileOut.close();
			
			 
	         System.out.printf("Serialized data is saved in registry.ser");
	         outputDatabase();
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
		
	}
	/**
	 * verify that the username and password are equal
	 * @param username is the username that is entered
	 * @param password is the password that is entered
	 * @return u the username and password
	 * 
	 */
	public User veriftyUserandPass(String username,String password){
		for(User u : users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;
            }
        }        
        return null;
	}
	
	public void outputDatabase(){
		for(User u : users){
            System.out.println(u.getUsername() + ",  " + u.getPassword());
        }
	}
	/**
	 * check if the user is already taken
	 * @param u is the username entered
	 * @return false if the user is found
	 * @return true if the user is not found
	 */
	public Boolean checkUser(String u){
		LoadDatabase();
		for(User u1:users){
			if(u1.getUsername().equals(u)){
				return false;
			}
			
		}
		return true;
		
		
	}
	
	private ArrayList<User> users=new ArrayList<User>();
}
