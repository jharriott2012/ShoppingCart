package cop4331;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author Jevon Harriott
 *
 */
public class InventoryTest {

	@Test
	public void testUpdateQuantity() {
		Seller s= new Seller("Test","Test","Seller");
		Inventory inventory=new Inventory();
		Inventory inventoryTest=new Inventory();
		
		
		inventory.addProduct(new Product(1,"basketball","description",4.99,2.01,3));
		inventoryTest.addProduct(new Product(1,"basketball","description",4.99,2.01,6));
		s.getInventory().updateQuantity(inventory.getProducts().get(0), 6);
		int w=inventory.getProducts().get(0).getQuantity();
		int k=inventoryTest.getProducts().get(0).getQuantity();
		
		
		Assert.assertEquals(w,k);
		
	}

@Test
public void testRemoveQuantity(){
	
	Inventory inventoryTest=new Inventory();
	
	
	
	inventoryTest.addProduct(new Product(1,"basketball","description",4.99,2.01,6));
	
	inventoryTest.removeProduct(inventoryTest.getProducts().get(0));
	
	int k=inventoryTest.getProducts().size();
	
	System.out.println(k);
	Assert.assertEquals(0,k);
	
}




}
