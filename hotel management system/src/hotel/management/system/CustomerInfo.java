package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    CustomerInfo(){
        setBounds(80,100,1250,600);
        t1=new JTable();
        t1.setBounds(0,40,1250,450);
        add(t1);
        
        JLabel l1=new JLabel("Document Type");
        l1.setBounds(30,20,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Number");
        l2.setBounds(186,20,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Name");
        l3.setBounds(342,20,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Gender");
        l4.setBounds(498,20,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Room No");
        l5.setBounds(654,20,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(810,20,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Status");
        l7.setBounds(966,20,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Deposit");
        l8.setBounds(1122,20,100,20);
        add(l8);
        
        b1=new JButton("Load data");
        b1.setBounds(400,500,150,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("Back");
        b2.setBounds(600,500,150,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        add(b2);
                
        
        
       // getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c=new conn();
                String str="select * from customer";
                ResultSet rs=c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new CustomerInfo().setVisible(true);
    }
}
