package cop4331;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * 
 * 
 * @author Jevon Harriott
 *
 */
public class RegisterFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField rTextfield;
	private JPasswordField jpasswordField;
	private JPasswordField jcpasswordField;
	private JComboBox comboBox;
	private Button backButton;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
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
	public RegisterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel registerLabel = new JLabel("Register");
		registerLabel.setBounds(186, 11, 138, 14);
		contentPane.add(registerLabel);
		
		rTextfield = new JTextField();
		
		rTextfield.setBounds(125, 53, 199, 31);
		contentPane.add(rTextfield);
		rTextfield.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(125, 36, 75, 14);
		contentPane.add(lblUsername);
		
		jpasswordField = new JPasswordField();
		jpasswordField.setBounds(125, 101, 199, 31);
		contentPane.add(jpasswordField);
		
		jcpasswordField = new JPasswordField();
		jcpasswordField.setBounds(125, 153, 199, 31);
		contentPane.add(jcpasswordField);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(125, 87, 199, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setBounds(125, 139, 107, 14);
		contentPane.add(lblConfirmPassword);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Customer", "Seller"}));
		comboBox.setBounds(124, 190, 200, 31);
		contentPane.add(comboBox);
		
		Button rButton = new Button("Register");
		rButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String u= rTextfield.getText();
			     String p = new String(jpasswordField.getPassword());
			     String type= comboBox.getSelectedItem().toString();
			     String cp = new String(jcpasswordField.getPassword());	
			     
			     
			     if (p.equals(cp))
			        {
			        	Database db= Database.getInstance();
			        	if(db.checkUser(u)==true ){
			        		db.addUsers(u, p, type);
			        		new LoginFrame().setVisible(true);
				        	dispose();
			        	}
			        	else{
			        		JOptionPane.showMessageDialog(rootPane, "Username exists");
			        	}
			        	
			        	
			
			        	
			        }
			       else {
			           JOptionPane.showMessageDialog(rootPane, "Password doesn't match");
			        }
			       
			    }
			     
		});
		rButton.setBounds(125, 229, 70, 22);
		contentPane.add(rButton);
		
		backButton = new Button("Back");
		backButton.setActionCommand("backButton");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginFrame().setVisible(true);
			}
		});
		backButton.setBounds(10, 11, 70, 22);
		contentPane.add(backButton);
	}
}
