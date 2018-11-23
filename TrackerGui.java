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

    ArrayList<String> fr = new ArrayList<String>();
    ArrayList<String> ch = new ArrayList<String>();

    static boolean updatedItem = false;

    JComboBox friendList = new JComboBox();

    JComboBox choice = new JComboBox();

    String choiceSelected = "";
    String friendSelected = "";

    ActionListener cbActionListener1 = new ActionListener() {//add actionlistner to listen for change
        @Override
        public void actionPerformed(ActionEvent e) {

            String s = (String) choice.getSelectedItem();//get the selected item
            System.out.println("choice :" + s);
            switch (s) {//check for a match
                case "Choose":
                    break;
                case "Accept":
                    choiceSelected = s;
                    break;
                case "Decline":
                    choiceSelected = s;
                    break;
                default:
                    break;
            }
        }
    };

    ActionListener cbActionListener2 = new ActionListener() {//add actionlistner to listen for change
        @Override
        public void actionPerformed(ActionEvent e) {

            String s = (String) friendList.getSelectedItem();//get the selected item
            System.out.println("friend:" + s);
            switch (s) {//check for a match
                case "Friends":
                    break;
                default:
                    friendSelected = s;
                    break;
            }
        }
    };

    public void setUser(User user) {
        currentUser = user;
    }

    public User getUser() {
        return currentUser;
    }

    static ArrayList<User> users = new ArrayList<User>();

    private String[] buttonLabels = {
        "Friend's List", "Edit Profile", "UpdateStats",
        "My Statistics", "ActivityTracker", "Logo", "Update"
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
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello from button");
                }
            });
        }
        if (button.equals("Edit Profile")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello from button");
                }
            });
        }
        if (button.equals("UpdateStats")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello from button");
                }
            });
        }

        if (button.equals("Update")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {

                    String s = (String) friendList.getSelectedItem();
                    String c = (String) choice.getSelectedItem();

                    switch (c) {//check for a match
                        case "Choose":
                            break;
                        case "Accept":
                            fr.add(s);

                            updatedItem = true;
                            break;
                        case "Decline":
                            fr.remove(s);
                            updatedItem = true;
                            
                            break;
                        default:
                            break;
                    }

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

       
        

        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);

        fr.add("Friends");
        fr.add("David");
        ch.add("Choose");
        ch.add("Accept");
        ch.add("Decline");

        friendList.setModel(new DefaultComboBoxModel(fr.toArray()));
        choice.setModel(new DefaultComboBoxModel(ch.toArray()));

        choice.addActionListener(cbActionListener1);
        friendList.addActionListener(cbActionListener2);

        friendList.setSize(200, 200);

        choice.setSize(200, 200);

        this.currentUser = currentUser;
        this.setBounds(200, 200, 1182, 779);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2, 0));

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            this.getContentPane().add(button);

            buttonMap.put(button.getText(), button);

            addActionListeners(button.getText());

        }

        if (loginPage.loginSucess) {
            TrackerGui.users.add(currentUser);
        }

      

        JPanel groupPanel = new JPanel();

        JPanel groupPanel2 = new JPanel();

        groupPanel.setLayout(new GridLayout(1, 0));
        JScrollPane scrollPane = new JScrollPane(groupPanel);

        for (int i = 0; i < CreateAccount.users.size(); i++) {

            String currentName = CreateAccount.users.get(1).getUser();
            User user = CreateAccount.users.get(i);

            for (int j = 0; j < user.runs.size(); j++) {

                GroupPanel p = new GroupPanel(user.runs.get(j));

               

                System.out.println("i" + i);

                groupPanel.add(p);
                
                if (!currentName.equals(user.getUser())) {
                    enableComponents(p, false);
                }
                
                

            }

            this.add(scrollPane);

        }

        //this.add(friendList);
        //this.add(choice);

    }

}
