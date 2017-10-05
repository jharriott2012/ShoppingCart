package cop4331;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;

import java.awt.CardLayout;

import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.GridLayout;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Jevon Harriott
 *
 */
public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTextField userTextfield;
	private JPasswordField passwordTextfield;
	private RegisterFrame h=new RegisterFrame();
	public static User login=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userTextfield = new JTextField();
		userTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userTextfield.setText("");
			}
		});
		userTextfield.setBounds(117, 73, 194, 31);
		contentPane.add(userTextfield);
		userTextfield.setColumns(10);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(117, 23, 146, 14);
		contentPane.add(lblLogin);
		
		passwordTextfield = new JPasswordField();
		passwordTextfield.setColumns(10);
		passwordTextfield.setBounds(117, 140, 194, 31);
		contentPane.add(passwordTextfield);
		
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u= userTextfield.getText();
			    String p = new String(passwordTextfield.getPassword());
			   
			    Database db= Database.getInstance();
				login=db.veriftyUserandPass(u,p);
				
				if(login!=null && login instanceof Customer){
					JOptionPane.showMessageDialog(rootPane, "Customer");
					System.out.println(u);
					System.out.println(p);
					System.out.println(login.getTypeOfUser());
					Customer c= new Customer(u,p,"Customer");
					dispose();
					new ShoppingFrame(c).setVisible(true);
				}
				else if(login!=null && login instanceof Seller){
					JOptionPane.showMessageDialog(rootPane, "Seller");
					System.out.println(u);
					System.out.println(p);
					System.out.println(login.getTypeOfUser());
					Seller s= new Seller(u,p,"Seller");
					dispose();
					new InventoryFrame().setVisible(true);
					
				}
				else{
					 JOptionPane.showMessageDialog(rootPane, "Username or Password doesn't match");
				}
			}
		});
		loginButton.setBounds(274, 214, 89, 23);
		contentPane.add(loginButton);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();
				 h.setVisible(true);
			}
		});
		registerButton.setBounds(75, 214, 89, 23);
		contentPane.add(registerButton);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(117, 48, 194, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(117, 115, 194, 14);
		contentPane.add(lblNewLabel_1);
		
		
	
		
	}
}
