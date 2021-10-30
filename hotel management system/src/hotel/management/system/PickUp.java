package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class PickUp extends JFrame implements ActionListener{
    Choice c1;
    JCheckBox c2;
    JButton b1,b2;
    JTable t1;
    PickUp(){
        setBounds(400,150,700,500);
        JLabel l1=new JLabel("PICKUP SERVICE");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(250,30,250,20);
        add(l1);
        
        JLabel l2=new JLabel("CAR TYPE");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l2.setBounds(20,70,120,20);
        add(l2);
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("model"));
            }
        }catch(Exception e){
            
        }
        c1.setBounds(150,70,120,25);
        c1.setFont(new Font("Tahoma",Font.PLAIN,17));
        c1.setBackground(Color.white);
        add(c1);
        
        /*c2=new JCheckBox("Only Display Available");
        c2.setBounds(400,70,200,30);
        c2.setBackground(Color.white);
        c2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(c2);*/
        
        t1=new JTable();
        t1.setBounds(0,150,700,200);
        add(t1);
        
        
         b1=new JButton("CHECK");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(10,370,120,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("BACK");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(150,370,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);
        
        
        JLabel l3=new JLabel("Name");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        l3.setForeground(Color.blue);
        l3.setBounds(20,120,120,20);
        add(l3);
        
        
        JLabel l4=new JLabel("Age");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        l4.setForeground(Color.blue);
        l4.setBounds(140,120,120,20);
        add(l4);
        
        JLabel l5=new JLabel("Gender");
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        l5.setForeground(Color.blue);
        l5.setBounds(260,120,120,20);
        add(l5);
        
        
        JLabel l6=new JLabel("Model");
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        l6.setForeground(Color.blue);
        l6.setBounds(380,120,120,20);
        add(l6);
        
        
        JLabel l7=new JLabel("Avaibility");
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        l7.setForeground(Color.blue);
        l7.setBounds(500,120,120,20);
        add(l7);
        
        JLabel l8=new JLabel("Location");
        l8.setFont(new Font("Tahoma",Font.PLAIN,16));
        l8.setForeground(Color.blue);
        l8.setBounds(620,120,120,20);
        add(l8);
        
        
        
        
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String s1="select * from driver where model='"+c1.getSelectedItem()+"'";
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
        new PickUp().setVisible(true);
    }
}
