package cop4331;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author Jevon Harriott
 *
 */

public class InventoryFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	Inventory inv= new Inventory();
	Seller sell= new Seller("a","b","Seller");
	Boolean match;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	double cost;
	double profit;
	double revenue;
	DecimalFormat dc = new DecimalFormat("0.00");
	private JTextField textField_6;
	
	
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryFrame frame = new InventoryFrame();
					
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
	public InventoryFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 455);
		contentPane = 
				new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 119, 423, 254);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				textField.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
				textField_1.setText(model.getValueAt(table.getSelectedRow(), 1).toString());
				textField_2.setText(model.getValueAt(table.getSelectedRow(), 2).toString());
				textField_3.setText(model.getValueAt(table.getSelectedRow(), 3).toString());
				textField_4.setText(model.getValueAt(table.getSelectedRow(), 4).toString());
				
			}
		});
		inv=sell.getInventory();
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Invoice Price", "Sell Price", "Quantity"
			}
		));
		addtoRow();
		
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				if(!textField_1.getText().trim().equals("")||!textField_1.getText().trim().equals("")||!textField_2.getText().trim().equals("")||!textField.getText().trim().equals("")||!textField_3.getText().trim().equals("")||!textField_4.getText().trim().equals("")||!textField_5.getText().trim().equals(""))
				{
				
					String text=textField.getText();
					int id=Integer.parseInt(text);
					String name=textField_1.getText();
					double invoice = Double.parseDouble(textField_2.getText());
					double sell = Double.parseDouble(textField_3.getText());
					String text1=textField.getText();
					int qty=Integer.parseInt(text1);
					String desc=textField_5.getText();
					match=false;
					for(int i=0;i<inv.getProducts().size();i++){
						if(id == inv.getProducts().get(i).getId()){
							JOptionPane.showMessageDialog(rootPane, "This id already exist");
							match=true;
						}
					}
					if(match!=true){
						model.addRow(new Object[]{textField.getText(),textField_1.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText()});
						inv.addProduct(new Product(id,name,desc,sell,invoice,qty));
						inv.saveInventory(inv.getProducts());
						
					}
					for(int i=0;i<inv.getProducts().size();i++){
					System.out.println(inv.getProducts().get(i).getId());
					System.out.println(inv.getProducts().get(i).getName());
		
				}
				}else{
					 JOptionPane.showMessageDialog(rootPane, "Please fill out every field");
				}
					
				
			}
		});
		btnAdd.setBounds(531, 122, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(23, 28, 84, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(51, 25, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 53, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(49, 53, 132, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblInvoicePrice = new JLabel("Invoice Price");
		lblInvoicePrice.setBounds(185, 28, 77, 14);
		contentPane.add(lblInvoicePrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(262, 25, 71, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSellPrice = new JLabel("Sell Price");
		lblSellPrice.setBounds(191, 53, 71, 14);
		contentPane.add(lblSellPrice);
		
		textField_3 = new JTextField();
		textField_3.setBounds(262, 50, 71, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(368, 28, 67, 14);
		contentPane.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(416, 25, 32, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				if(table.getSelectedRow()==-1){
					if(table.getRowCount()==0){
						JOptionPane.showMessageDialog(rootPane, "Table is empty");
					}
					else{
						JOptionPane.showMessageDialog(rootPane, "You must select a product");
					}
					
				}
				else{
					model.setValueAt(textField_4.getText(),table.getSelectedRow(), 4);
					String text1=textField_4.getText();
					int qty=Integer.parseInt(text1);
					String text=textField.getText();
					int id=Integer.parseInt(text);
					for(int i=0;i<inv.getProducts().size();i++){
						if(id==inv.getProducts().get(i).getId()){
							inv.updateQuantity(inv.getProducts().get(i), qty);
							inv.saveInventory(inv.getProducts());
						}
						
					}
					
					//for(int i=0;i<inv.getProducts().size();i++){
						//System.out.println(inv.getProducts().get(i).getName());
						//System.out.println(inv.getProducts().get(i).getQuantity());
			
					//}
					
				}
				
			}
		});
		btnUpdate.setBounds(531, 156, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(343, 53, 92, 14);
		contentPane.add(lblDescription);
		
		textField_5 = new JTextField();
		textField_5.setBounds(416, 50, 190, 38);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model= (DefaultTableModel)table.getModel();
				if(table.getSelectedRow()==-1){
					if(table.getRowCount()==0){
						JOptionPane.showMessageDialog(rootPane, "Table is empty");
					}
					else{
						JOptionPane.showMessageDialog(rootPane, "You must select a product");
					}
					
				}
				else{
					model.removeRow(table.getSelectedRow());
					String text=textField.getText();
					int id=Integer.parseInt(text);
					System.out.println(id);
					for(int i=0;i<inv.getProducts().size();i++){
						if(id==inv.getProducts().get(i).getId()){
							inv.removeProduct(inv.getProducts().get(i));
							inv.saveInventory(inv.getProducts());
						}
			
					}
					for(int i=0;i<inv.getProducts().size();i++){
						System.out.println(inv.getProducts().get(i).getId());
						System.out.println(inv.getProducts().get(i).getName());
			
					}
					
					
					
					
				}
		}
		});
		btnRemove.setBounds(531, 190, 89, 23);
		contentPane.add(btnRemove);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(555, 11, 89, 23);
		contentPane.add(btnLogout);
		
		cost=inv.getCost();
		String formattedText = dc.format(cost);
		
		JLabel lblTotalCost = new JLabel("Total Cost " +"$" + formattedText);
		lblTotalCost.setBounds(20, 391, 114, 14);
		contentPane.add(lblTotalCost);
		inv.totalProfitInventory();
		revenue=inv.getRevenue();
		
		String formattedText1 = dc.format(revenue);
		JLabel lblTotalProfit = new JLabel("Total Revenue " + "$" +formattedText1);
		lblTotalProfit.setBounds(193, 391, 140, 14);
		contentPane.add(lblTotalProfit);
		profit=revenue-cost;
		String formattedText2 = dc.format(profit);
		
		JLabel lblTotalRevenue = new JLabel("Total Profit "+"$"+formattedText2);
		lblTotalRevenue.setBounds(368, 391, 162, 14);
		contentPane.add(lblTotalRevenue);
		
		
		
	}
	
	public void addtoRow(){
	
		inv.LoadInventory();
	
	DefaultTableModel model= (DefaultTableModel)table.getModel();
	Object rowData[]=new Object[5];
	for(int i=0;i<inv.getProducts().size();i++){
		
		rowData[0]=inv.getProducts().get(i).getId();
		rowData[1]=inv.getProducts().get(i).getName();
		rowData[2]=inv.getProducts().get(i).getInvoicePrice();
		rowData[3]=inv.getProducts().get(i).getSellPrice();
		rowData[4]=inv.getProducts().get(i).getQuantity();
		model.addRow(rowData);
		
	}
		
	}
}
