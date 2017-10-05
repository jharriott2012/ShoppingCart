

package cop4331;

import java.io.Serializable;
/**
 * 
 * @author Jevon Harriott
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	public Product(int id,String name,String description,double SellPrice,double InvoicePrice,int quantity ){
		this.id=id;
		this.name=name;
		this.description=description;
		this.SellPrice=SellPrice;
		this.InvoicePrice=InvoicePrice;
		this.quantity=quantity;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSellPrice() {
		return SellPrice;
	}
	public void setSellPrice(float sellPrice) {
		SellPrice = sellPrice;
	}
	public double getInvoicePrice() {
		return InvoicePrice;
	}
	public void setInvoicePrice(float invoicePrice) {
		InvoicePrice = invoicePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private int id;
	private String name;
	private String description;
	private double SellPrice;
	private double InvoicePrice;
	private int quantity;
}
