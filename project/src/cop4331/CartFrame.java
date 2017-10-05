package cop4331;

/**
 * @author Jevon Harriott
 * 
 * 
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CartFrame extends JFrame {
	;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	double total;
	DecimalFormat dc = new DecimalFormat("0.00");
	Inventory inv=new Inventory();
	int qty;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartFrame frame = new CartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CartFrame() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 574, 397);
		JLabel lblEnterCreditCard_1 = new JLabel("Enter Credit Card");
		lblEnterCreditCard_1.setBounds(10, 284, 187, 26);
		getContentPane().add(lblEnterCreditCard_1);
		
		textField = new JTextField();
		textField.setBounds(10, 308, 227, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSubmit.setBounds(418, 310, 89, 23);
		getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(10, 344, 153, 14);
		getContentPane().add(lblNewLabel);
		
		
	}
	public CartFrame(final Customer c){
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 55, 410, 233);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Sell Price", "Quantity"
			}
		));
		addtoRow(c.getCart());
		Button backButton = new Button("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShoppingFrame(c).setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(478, 25, 70, 22);
		contentPane.add(backButton);
		for(int i=0;i<c.getCart().getProducts().size();i++){
			System.out.println(c.getCart().getProducts().get(i).getName());
		}
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()!=16){
					JOptionPane.showMessageDialog(rootPane, "Please enter a 16 digits Credit Number");
					
				}
				else{
					JOptionPane.showMessageDialog(rootPane, "Your order has been submitted!");
					for(int k=0;k<c.getCart().getProducts().size();k++){
						inv.LoadInventory();
						qty=c.getCart().getProducts().get(k).getQuantity();
						System.out.println(c.getCart().getProducts().get(k).getQuantity());
						inv.newQuantity(c.getCart().getProducts().get(k),qty);
						System.out.println(c.getCart().getTotal());
						inv.saveInvoice(c.getCart().getTotal());
						c.getCart().clearCart(c.getCart().getProducts());
						
					}
					
				}
				
				
			}
		});
		btnSubmit.setBounds(418, 310, 89, 23);
		getContentPane().add(btnSubmit);
		JLabel lblEnterCreditCard_1 = new JLabel("Enter Credit Card");
		lblEnterCreditCard_1.setBounds(10, 284, 187, 26);
		getContentPane().add(lblEnterCreditCard_1);
		textField = new JTextField();
		textField.setBounds(10, 308, 227, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		total=c.getCart().getTotal();
		String formattedText = dc.format(total);
		JLabel lblNewLabel = new JLabel("Total: $ "+ formattedText);
		
		lblNewLabel.setBounds(10, 344, 153, 14);
		getContentPane().add(lblNewLabel);
	 }
	
	public void addtoRow(Cart c){
		DefaultTableModel model= (DefaultTableModel)table.getModel();
		Object rowData[]=new Object[5];
		for(int i=0;i<c.getProducts().size();i++){
			rowData[0]=c.getProducts().get(i).getId();
			rowData[1]=c.getProducts().get(i).getName();
			rowData[2]=c.getProducts().get(i).getSellPrice();
			rowData[3]=c.getProducts().get(i).getQuantity();
			model.addRow(rowData);
			
			
		}
		
	}
	
}

