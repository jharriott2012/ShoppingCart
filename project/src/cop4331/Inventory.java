package cop4331;


import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * 
 * @author Jevon Harriott
 *
 */

public class Inventory implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * add a product in the inventory
	 * @param p is a product
	 * @postcondition remove the product
	 * 
	 */
	public void addProduct(Product p) {
		products.add(p);
	}
	/**
	 * remove a product in the inventory
	 * @precondition the product size is greater than 0
	 * @param p is a product
	 * @postcondition remove the product
	 * 
	 */
	public void removeProduct(Product p){
		
		products.remove(p);
	}
	/**
	 * update a product Quantity in the inventory
	 * @precondition the cart size is greater than 0
	 * @param p is a product
	 * @param quantity is the product quantity
	 * @postcondition update the product quantity
	 * 
	 */
	
	public void updateQuantity(Product p,int quantity){
		p.setQuantity(quantity);
		
	}
	/**
	 * update a product Quantity in the inventory when a customer buy a product
	 * @precondition the cart size is greater than 0
	 * @param  p is a product
	 * @param quantity is the product quantity
	 * @postcondition update the product quantity
	 * 
	 */
	
	public void newQuantity(Product p,int quantity){
		for(Product p1: products){
			if(p1.getName().equals(p.getName())){
				
				System.out.println("p1 "+p1.getQuantity()+ " p"+ quantity );
				quantity=p1.getQuantity()-quantity;

				p1.setQuantity(quantity);
				saveInventory(products);
				
				
			}
		}
		for(Product p2: products){
			System.out.println(p2.getQuantity()+p2.getName());
		}
		
		
	}
	/**
	 * get Products in the inventory
	 * @return product is the product in the Array list
	 * 
	 */
	public ArrayList<Product> getProducts(){
		return products;
	}
	/**
	 * get the total cost in the inventory
	 * @precondition the cart size is greater than 0
	 * @return cost is the inventory
	 */
	
	public double getCost(){
		for(Product p1: products){
			cost+=p1.getInvoicePrice()*p1.getQuantity();
		}
		return cost;
		
	}
	
    public Iterator<Product> getiProducts(){
        return new Iterator<Product>(){
            public boolean hasNext(){
                return current < products.size();
            }
            public Product next(){
                return products.get(current++);//Returns next item and increments current index
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }            
            private int current = 0;
        };                
    }
    /**
     * Load the total Revenue
     */
	public void totalProfitInventory(){
		
			  try {
				  		FileInputStream fileIn = new FileInputStream("revenue.ser");
			         //InputStream fileIn = Inventory.class.getResourceAsStream("revenue.ser");
			 
			         ObjectInputStream in = new ObjectInputStream(fileIn);
			       
			         this.revenue= (Double) in.readObject();
			         in.close();
			         fileIn.close();
			      }catch(IOException i) {
			         i.printStackTrace();
			         return;
			      }catch(ClassNotFoundException c) {
			         c.printStackTrace();
			         return;
			      
			      }
		}
	
	
	/**
	 * 
	 * Load the Inventory
	 */
	@SuppressWarnings("unchecked")
	public void LoadInventory(){
		 try {
			   FileInputStream fileIn = new FileInputStream("inventory.ser");
	    	 //InputStream fileIn = Inventory.class.getResourceAsStream("inventory.ser");
	         ObjectInputStream out= new ObjectInputStream(fileIn);
	    	 this.products = (ArrayList<Product>)out.readObject();
	    	 out.close();
	         fileIn.close();
	        
	      }catch(IOException i) {
	         i.printStackTrace();
	        
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void saveInventory(ArrayList<Product> products){
		 try {
			 
			 new FileOutputStream("inventory.ser").close();
	         FileOutputStream fileOut =
	         new FileOutputStream("inventory.ser",true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(products);
	         out.close();
	         fileOut.close();
	  
	         
	         
	      
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
		 outputDatabase();
		
	}
	/*
	 * save the customer purchases
	 * @param cost is the cost of the products in the cart
	 */
	public void saveInvoice(double cost){
		totalProfitInventory();
		total=getRevenue();
		total=total+cost;
		 try {
			 
			 new FileOutputStream("revenue.ser").close();
	         FileOutputStream fileOut =
	         new FileOutputStream("revenue.ser",true);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(total);
	         out.close();
	         fileOut.close();
	         System.out.printf("cost.ser");
	      
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
	}
	
	public void outputDatabase(){
		for(int i=0;i<products.size();i++){
			System.out.println(products.get(i).getName());
		
		}

	}
	/*
	 * get the total Revenue 
	 * @return the total revenue
	 */
	
	public double getRevenue(){
		return revenue;
	}
	
	public ArrayList<Product> products=new ArrayList<Product>();
	private double cost;
	private double revenue;
	private double total;
}
