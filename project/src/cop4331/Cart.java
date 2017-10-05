package cop4331;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 
 * @author Jevon Harriott
 *
 */
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

/**add product to the user cart
 * @param p is a object
 * 
 */
	public void addToCart(Product p){
		cart.add(p);
		
	}
	/**
	 * get the products in the user
	 * @return the user products
	 */
	public ArrayList<Product> getProducts(){
		return cart;
	}
	/**
	 *remove the products in the user cart
	 * @param p is the products in the user cart
	 */
	public void RemoveProductinCart(Product p){
		cart.remove(p);
	}
/**
 * this function get total amount of the cart by multiply quantity by the sell price
 * @return total is total cost of the cart
 */
	public double getTotal(){
		total=0;
		for(Product p1: cart){
			total+=p1.getSellPrice()*p1.getQuantity();
		}
		return total;
	}
	/**
	 * update the product quantity in the cart
	 * @param p is a product in the cart
	 * @param quantity is the quantity of the product in the cart
	 */
	public void updateQuantity(Product p,int quantity){
		p.setQuantity(quantity);
		
	}
	/**
	 * clear the cart
	 * @param cart is a ArrayList of Product
	 */
	public void clearCart(ArrayList<Product> cart){
		cart.clear();
	}
	   
		

	
	
	private double total;
	private ArrayList<Product> cart=new ArrayList<Product>();
	
}
