package cop4331;
/*
 * @author Jevon Harriott
 * 
 * 
 */

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CartTest {

	@Test
	public void test() {
		Customer c= new Customer("Test","Test","Customer");
		Cart cart=new Cart();
		Cart test=new Cart();
		
		
		cart.addToCart(new Product(1,"basketball","description",4.99,2.01,3));
		test.addToCart(new Product(1,"basketball","description",4.99,2.01,6));
		c.getCart().updateQuantity(cart.getProducts().get(0), 6);
		int w=cart.getProducts().get(0).getQuantity();
		int k=cart.getProducts().get(0).getQuantity();
		
		
		Assert.assertEquals(w,k);
	}

}
