package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Room extends JFrame implements ActionListener{
    JButton b1,b2;
    JTable t1;
    Room(){
        setBounds(80,100,1000,600);
        t1=new JTable();
        t1.setBounds(0,40,1000,450);
        add(t1);
        
        JLabel l1=new JLabel("Room Number");
        l1.setBounds(50,20,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Available");
        l2.setBounds(250,20,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Cleaning Status");
        l3.setBounds(450,20,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Price");
        l4.setBounds(650,20,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Type");
        l5.setBounds(850,20,100,20);
        add(l5);
        
        
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
                String str="select * from room";
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
        new Room().setVisible(true);
    }
}
