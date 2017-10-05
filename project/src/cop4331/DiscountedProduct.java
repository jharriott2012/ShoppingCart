package cop4331;

/**
 * 
 * @author Jevon Harriott
 *
 */
public class DiscountedProduct {

	private static final long serialVersionUID = 1L;
	public DiscountedProduct(double discount ,Product products){
		this.setProducts(products);
		this.discount=discount;
		
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
		this.name = name + "discounted";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getSellPrice() {
		return SellPrice*discount;
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
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}
	private int id;
	private String name;
	private String description;
	private double SellPrice;
	private double InvoicePrice;
	private int quantity;
	private double discount;
	private Product products;
	
}
