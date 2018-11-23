package javaapplication37;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;





public class loginPage {

	private JFrame frame;
	private JTextField login_username_field;
	private JPasswordField login_password_field;

        static boolean loginSucess=false;
        
        
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage window = new loginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public loginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 547, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("enter username");
		lblEnterUsername.setBounds(66, 54, 91, 16);
		frame.getContentPane().add(lblEnterUsername);
		
		login_username_field = new JTextField();
		login_username_field.setBounds(181, 51, 116, 22);
		frame.getContentPane().add(login_username_field);
		login_username_field.setColumns(10);
                login_username_field.setText("");
                
                login_password_field = new JPasswordField();
                login_username_field.setText("");
                
                
		login_password_field.setBounds(181, 98, 116, 22);
                
                
		
		JLabel lblEnterPassword = new JLabel("enter password");
		lblEnterPassword.setBounds(66, 101, 91, 16);
		frame.getContentPane().add(lblEnterPassword);
		
		JButton btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			int var1;
			boolean var2;
			public void actionPerformed(ActionEvent e) {
				try {
					String tempUsername = login_username_field.getText();
					String tempPassword = login_password_field.getText();
					var1 = CreateAccount.checkUsername(tempUsername);
					if(var1>-1) {
						var2 = CreateAccount.checkPassword(var1,tempPassword);
						if(var1>-1 && var2== true) {
							JOptionPane.showMessageDialog(null, "username and password match.opening Tracker");
							
                                                        
                                                        frame.setVisible(false);
                                                        //User user=new User("boo","jim");
                                                        
                                                        User currentUser = new User(tempUsername, tempPassword);
							TrackerGui tracker = new TrackerGui(currentUser);
                                                        
                                                        
							tracker.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "Incorrect password");
						}
					}else {
						JOptionPane.showMessageDialog(null, "your username is not found! Sign up?");
					}
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnLogin.setBounds(60, 151, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblNewToOur = new JLabel("new to our community?create account?");
		lblNewToOur.setBounds(66, 202, 231, 16);
		frame.getContentPane().add(lblNewToOur);
		
		JButton btnSignUp = new JButton("sign up");
		btnSignUp.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				CreateAccount create = new CreateAccount();
				create.setVisible(true);
			}
		});
		btnSignUp.setBounds(60, 243, 97, 25);
		frame.getContentPane().add(btnSignUp);
		
                
		frame.getContentPane().add(login_password_field);
	}
}