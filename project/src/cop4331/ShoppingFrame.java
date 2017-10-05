package cop4331;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * @author Jevon Harriott
 */
public class ShoppingFrame extends JFrame {
	
	private JPanel contentPane;

	
	Inventory inv =new Inventory();
	private double total;
	

	private JTable table;
	private JTextField textField;
	DecimalFormat dc = new DecimalFormat("0.00");
	boolean match;
	int i;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					ShoppingFrame frame = new ShoppingFrame();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ShoppingFrame(){
		getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(488, 27, 105, 28);
		getContentPane().add(btnNewButton_2);
		
	}
	/**
	 * Create the frame.
	 */
	public ShoppingFrame(final Customer c) {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				model.getValueAt(table.getSelectedRow(), 0);
				model.getValueAt(table.getSelectedRow(), 1);
				model.getValueAt(table.getSelectedRow(), 2);
				model.getValueAt(table.getSelectedRow(), 3);
				model.getValueAt(table.getSelectedRow(), 4);
			}
		});
		scrollPane.setBounds(64, 72, 440, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Sell Price", "In Stock","Quantity"
			}
		));
		
		JButton btnNewButton = new JButton("Add To Cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				if (table.isEditing())
				    table.getCellEditor().stopCellEditing();
				if(table.getSelectedRow()==-1){
					if(table.getRowCount()==0){
						JOptionPane.showMessageDialog(rootPane, "Table is empty");
					}
					else{
						JOptionPane.showMessageDialog(rootPane, "You must select a product");
					}
					
				}
				else{
					int qty;
					int stock;
					qty=Integer.parseInt(model.getValueAt(table.getSelectedRow(), 4).toString());
					stock=Integer.parseInt(model.getValueAt(table.getSelectedRow(), 3).toString());
					for(i=0;i<inv.getProducts().size();++i){
						
						if(inv.getProducts().get(i).getId()==(Integer)(model.getValueAt(table.getSelectedRow(), 0))){
						
							if(c.getCart().getProducts().size()==0 && qty!=0 && qty<=stock){
							c.getCart().addToCart(new Product(inv.getProducts().get(i).getId(),inv.getProducts().get(i).getName(),inv.getProducts().get(i).getDescription(),inv.getProducts().get(i).getSellPrice(),inv.getProducts().get(i).getInvoicePrice(),qty));
							}
							else if(qty>stock){
								JOptionPane.showMessageDialog(rootPane, "You have exceed the quantity limit");
								
							}
							else{
								for(i=0;i<c.getCart().getProducts().size();i++){
									match=false;
									if(c.getCart().getProducts().get(i).getId()==(Integer)(model.getValueAt(table.getSelectedRow(), 0))&& qty<=stock){
										match=true;
										if(qty==c.getCart().getProducts().get(i).getQuantity()){
											JOptionPane.showMessageDialog(rootPane, "Product quantity already exists");
										}else{
										JOptionPane.showMessageDialog(rootPane, "Quantity have been updated");
										c.getCart().updateQuantity(c.getCart().getProducts().get(i),qty);
										model.setValueAt(qty,table.getSelectedRow(), 4 );
										}
									}
									
									else if(match==false){
										for(i=0;i<inv.getProducts().size();++i){
										if(inv.getProducts().get(i).getId()==(Integer)(model.getValueAt(table.getSelectedRow(), 0))){
											c.getCart().addToCart(new Product(inv.getProducts().get(i).getId(),inv.getProducts().get(i).getName(),inv.getProducts().get(i).getDescription(),inv.getProducts().get(i).getSellPrice(),inv.getProducts().get(i).getInvoicePrice(),qty));
										}
										}
									}
									else{
											JOptionPane.showMessageDialog(rootPane, "Product already exist in the cart");
										
									}
							
									
										
								}
								
									
							}
							
							
					}
					
						
						
					}
					total=c.getCart().getTotal();
					String formattedText = dc.format(total);
					System.out.println(total);
					textField.setText("$" + formattedText);
					
					
				}
				
				
				
				
				
			}
		});
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setBounds(514, 27, 101, 28);
		getContentPane().add(btnNewButton_2);
		btnNewButton.setBounds(514, 75, 101, 23);
		contentPane.add(btnNewButton);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("View Cart");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CartFrame(c).setVisible(true);

				dispose();
				
			}
		});
		btnNewButton_1.setBounds(514, 127, 101, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblTitle = new JLabel("total");
		lblTitle.setBounds(29, 367, 46, 14);
		contentPane.add(lblTitle);
		
		textField = new JTextField();
		total=c.getCart().getTotal();
		String formattedText = dc.format(total);
		
		textField.setText("$"+formattedText);
		textField.setBounds(61, 364, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		addtoRow();
	

	
		
	}

	
	public void addtoRow(){

	inv.LoadInventory();
	DefaultTableModel model= (DefaultTableModel)table.getModel();
	Object rowData[]=new Object[5];
	for(int i=0;i<inv.getProducts().size();i++){
		
		rowData[0]=inv.getProducts().get(i).getId();
		rowData[1]=inv.getProducts().get(i).getName();
		rowData[2]=inv.getProducts().get(i).getSellPrice();
		rowData[3]=inv.getProducts().get(i).getQuantity();
		
	
		model.addRow(rowData);
	}
	
	}
}
