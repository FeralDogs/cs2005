package javaapplication37;

import java.awt.Component;
import java.awt.Container;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static javaapplication37.CreateAccount.users;
import javaapplication37.GroupPanel;

public class TrackerGui extends JFrame {

    private JTextField txtUsersRecentStatistics;
    private JTextField txtUserWillBe;
    private JTextField txtStatisticsOfFriend;
    private JTextField txtStatisticsOfFriend_1;
    private JTextField txtStatisticsOfFriend_2;
    private Map<String, JButton> buttonMap = new HashMap<String, JButton>();

    static private User currentUser;
    
    
    
    public void setUser(User user){
        currentUser=user;
    }
    
    public User getUser(){
        return currentUser;
    }
    
    
    
    static ArrayList<User> users = new ArrayList<User>();

    private String[] buttonLabels = {
        "Friend's List", "Edit Profile", "UpdateStats",
        "My Statistics", "ActivityTracker", "Logo"
    };

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrackerGui window = new TrackerGui(currentUser);

                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void addActionListeners(String button) {

        // add more action listeners here 
        if (button.equals("Friend's List")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Hello from button");
                }
            });
        }
        if (button.equals("Edit Profile")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Hello from button");
                }
            });
        }
        if (button.equals("UpdateStats")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    System.out.println("Hello from button");
                }
            });
        }

        //etc.
    }

    public void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }

    /**
     * Create the application.
     */
    public TrackerGui(User currentUser) {
        
        
       
        super("my frame");
        this.currentUser=currentUser;
        this.setBounds(200, 200, 1182, 779);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2, 0));

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            this.getContentPane().add(button);

            buttonMap.put(button.getText(), button);

            addActionListeners(button.getText());

        }

        
        if (loginPage.loginSucess){
            TrackerGui.users.add(currentUser);
        }
        
        User obj = new User("bob", "3");
        TrackerGui.users.add(obj);
        User obj2 = new User("john", "3");
        TrackerGui.users.add(obj2);
        User obj3 = new User("dave", "3");
        TrackerGui.users.add(obj3);
        User obj4 = new User("jill", "3");
        TrackerGui.users.add(obj4);

        JPanel groupPanel = new JPanel();
        
        JPanel groupPanel2 = new JPanel();
        
        
        
        
        groupPanel.setLayout(new GridLayout(1, 0));
        JScrollPane scrollPane = new JScrollPane(groupPanel);

        for (int i = 0; i < TrackerGui.users.size(); i++) {

            User user = TrackerGui.users.get(i);

            for (int j = 0; j < user.runs.size(); j++) {

                GroupPanel p = new GroupPanel(user.runs.get(j));
                
                if (i>0){
                    enableComponents(p, false);
                }
                
                System.out.println("i" + i);
                
                
               
               groupPanel.add(p);
               
               //enableComponents(groupPanel, false);
               
               
               

            }

            this.add(scrollPane);
            ;
        }

    }

}
