package cop4331;



import java.io.Serializable;
/**
 * 
 * @author Jevon Harriott
 *
 */

public class Customer extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5595802768871880692L;

	/**
	 * 
	 */
	/**
	 * 
	 */
	/**
	 * Customer constructor
	 */
	public Customer(String username, String password, String type) {
		super(username, password, type);
		this.shoppingcart=new Cart();
		
	}
	/**
	 * get the customer cart
	 * @return shoppingcart is the customer shopping cart
	 */
	public Cart getCart(){
	
		return shoppingcart;
	}
	
	private Cart shoppingcart;
	
	

	
}
