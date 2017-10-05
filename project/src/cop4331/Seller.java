package cop4331;




import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 
 * @author Jevon
 *
 */
public class Seller extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * create a Seller constructor
	 *
	 */
	public Seller(String username, String password, String type) {
		super(username, password, type);
		this.inventory=new Inventory();
		this.inventory.addProduct(new Product(1,"basketball","description",4.99,2.01,3));
		this.inventory.addProduct(new Product(2,"golf","description",5.99,2.00,3));
		this.inventory.addProduct(new Product(3,"soccer ball","description",5.99,2.00,3));
		this.inventory.addProduct(new Product(4,"baseball","description",2.99,2.00,3));
		this.inventory.addProduct(new Product(5,"football","description",6.99,2.00,3));
		this.inventory.addProduct(new Product(6,"golf club","description",7.99,2.00,3));
		
	}
	/**
	 * get the Inventory
	 * @return this.inventory is the inventory
	 */
	public Inventory getInventory(){
		return this.inventory;
		
	}
	/**
	 * save the inventory to a ser file
	 * @param inventory is the Inventory
	 */
	public void saveInventory(Inventory inventory){
		 try {
			 new FileOutputStream("inventory.ser").close();
	         FileOutputStream fileOut =
	         new FileOutputStream("inventory.ser",true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(inventory);
	         out.close();
	         fileOut.close();
	         System.out.printf("inventory.ser");
	      
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
		
	}
	public void outputDatabase(){
		for(int i=0;i<inventory.getProducts().size();i++){
			System.out.println(inventory.getProducts().get(i).getName());
		
		}

	}
	private Inventory inventory;

}
