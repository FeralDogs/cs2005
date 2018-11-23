package javaapplication37;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Scrollable;

public class GroupPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private JLabel label1 = new JLabel("time:");
    private JTextField field1 = new JTextField(16);
    private JLabel label2 = new JLabel("distance:");
    private JTextField field2 = new JTextField(16);
    private JLabel label3 = new JLabel("altitude");
    private JTextField field3 = new JTextField(16);
    private JLabel label4 = new JLabel("Date");
    private JTextField field4 = new JTextField(16);

    JScrollPane sp = new JScrollPane();

    public void setField1(String s) {
        field3.setText(s);
    }

    public GroupPanel(User.Run run) {

        this.setBorder(BorderFactory.createTitledBorder("Name " + run.getName()));
        GroupLayout l = new GroupLayout(this);
        System.out.println("User name " + run.getName());

           //double distance = Double.toString(Math.random());
           // double altitude = Double.toString(Math.random());
            //double time = Double.toString(Math.random());
        field1.setText(run.getDistance());
        field2.setText(run.getAltitude());
        field3.setText(run.getTime());
        field4.setText(run.getDate());
        

        
        this.setLayout(l);

        l.setAutoCreateGaps(true);
        l.setAutoCreateContainerGaps(true);
        l.setHorizontalGroup(l.createSequentialGroup()
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(label1)
                        .addComponent(label2)
                        .addComponent(label3)
                        .addComponent(label4)
                        
                        
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(field1)
                        .addComponent(field2)
                        .addComponent(field3)
                        .addComponent(field4)
                        
                )
        );

        l.setVerticalGroup(l.createSequentialGroup()
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(field1))
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(field2))
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(field3)
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(field4)
                )
                
                
                
                
        );

        sp.setToolTipText("test");
        sp.add(this);
    }

    public static void main(String[] args) {

    }

}
