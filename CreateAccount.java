package javaapplication37;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField email_field;
	private JTextField username_field;
	private JLabel label;
	private JLabel lblPassword;
	private JPasswordField password_field;

	
	static String[] usernames = new String[100];
	static String[] emails = new String[100];
	static String[] passwords = new String[100];
        static ArrayList<User> users=new ArrayList<User>();
    
        
        static private User currentUser;
        
        
        
        
        public User getUser(){
            return currentUser;
        }
        
        
        
        
        

	public static int checkUsername(String a){
		int index=-1;
		for(int j =0;j<usernames.length;j++) {
			if(a.equals(usernames[j])) {
				index=j;
				break;
			}
		}
		if(index>=0) {
			return index;
		}
		else {
			return index;
		}
	}
	
	public static boolean checkPassword(int a,String b) {
		if(passwords[a].equals(b)) {
			return true;
		}
		return false;
	}
	
	public static int getCount() {
		int count=0;
		for(int x=0; x<usernames.length;x++) {
			if(usernames[x]==null) {
				count=x;
				break;
			}
		}
		return count;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
                                        
					CreateAccount create = new CreateAccount();
					create.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(51, 51, 56, 16);
		contentPane.add(lblEmail);
		
		email_field = new JTextField();
		email_field.setBounds(170, 48, 116, 22);
		contentPane.add(email_field);
		email_field.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(51, 99, 71, 16);
		contentPane.add(lblUsername);
		
		username_field = new JTextField();
		username_field.setBounds(170, 96, 116, 22);
		contentPane.add(username_field);
		username_field.setColumns(10);
		
		label = new JLabel("");
		label.setBounds(51, 157, 56, 16);
		contentPane.add(label);
		
		lblPassword = new JLabel("password");
		lblPassword.setBounds(51, 157, 56, 16);
		contentPane.add(lblPassword);
		
		password_field = new JPasswordField();
		password_field.setBounds(170, 154, 116, 22);
		contentPane.add(password_field);
		

		
		JButton btnCreateAccount = new JButton("create account");
		btnCreateAccount.setBounds(51, 214, 116, 25);
		btnCreateAccount.addActionListener(new ActionListener() {

			int count = CreateAccount.getCount();
			int ctrl = 1;
			public void actionPerformed(ActionEvent arg0) {
				try {
					String tempUsername = username_field.getText();
					String tempEmail = email_field.getText();
					String tempPassword = password_field.getText();
					for(int i =0;i<usernames.length;i++) {
						if(tempUsername.equals(usernames[i])) {
							JOptionPane.showMessageDialog(null, "This username is already taken. Please try again");
							ctrl =0;
						}
						if(tempEmail.equals(emails[i])) {
							JOptionPane.showMessageDialog(null, "email already taken. Please try again");
							ctrl =0;
						}
						
					}
					

					
					try {
						String subTempString1;
						String subTempString2;
						subTempString1 = tempEmail.substring(tempEmail.indexOf('@'), tempEmail.indexOf('.'));
						subTempString2 = tempEmail.substring(tempEmail.indexOf('.'), tempEmail.length());
						if(subTempString1.length()<4) {
							JOptionPane.showMessageDialog(null, "Invalid email service provider entered. please try again!");
							ctrl=0;
						}
						if(subTempString2.length()<3) {
							JOptionPane.showMessageDialog(null, "Invalid email extention entered. please try again!");
							ctrl=0;
						}
						
					}
					catch(Exception e) {
						ctrl=0;
						JOptionPane.showMessageDialog(null, "Invalid email address entered. please try again!");
					}

					
					
					if(ctrl==1) {
						usernames[count]=tempUsername;
						emails[count]=tempEmail;
						passwords[count]=tempPassword;
						count++;
                                                
                                                currentUser=new User(tempUsername, tempEmail);
                                       
                                                TrackerGui.users.add(currentUser);
                                                
                                                
						System.out.println("Account Succesfully created");
						System.out.println("Your Username is: "+tempUsername);
						System.out.println("Your email address is: "+tempEmail);
						JOptionPane.showMessageDialog(null, "new account created");
						setVisible(false);
						
	
						
					}
					ctrl=1;
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
				
				System.out.println("-------------------------------------------------------------------------------------");
			}
		});
		contentPane.add(btnCreateAccount);
	}
}