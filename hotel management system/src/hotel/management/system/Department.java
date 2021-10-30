package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Department extends JFrame implements ActionListener{
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    Department(){
        setBounds(400,150,500,500);
        JLabel l1=new JLabel("Department");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(150,30,250,20);
        add(l1);
        
      
        
        
        t1=new JTable();
        t1.setBounds(0,100,700,300);
        add(t1);
        
        
         b1=new JButton("CHECK");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(10,410,120,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("BACK");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(150,410,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);
        
        
        JLabel l3=new JLabel("Department");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        l3.setForeground(Color.blue);
        l3.setBounds(120,70,150,20);
        add(l3);
        
        
        JLabel l4=new JLabel("Budgete");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        l4.setForeground(Color.blue);
        l4.setBounds(400,70,150,20);
        add(l4);
        
        
        
        
        
        
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String s1="select * from department";
               // String s2="select * from room where available='Unoccupied' and bed='"+c1.getSelectedItem()+"'";
                //System.out.println(s2);
                conn c=new conn();
            
                 ResultSet rs1=c.s.executeQuery(s1);
                 t1.setModel(DbUtils.resultSetToTableModel(rs1));
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[]args){
        new Department().setVisible(true);
    }
}
