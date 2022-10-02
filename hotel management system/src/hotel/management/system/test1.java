package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateRoom extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4;
    Choice c1;
    JButton b1,b2,b3;
    UpdateRoom(){
        setBounds(200,100,800,400);
        JLabel l1=new JLabel("UPDATE ROOM STATUS");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(50,30,250,20);
        add(l1);
        
        JLabel l2=new JLabel("GUEST ID");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l2.setBounds(20,70,150,20);
        add(l2);
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        c1.setBounds(200,70,150,20);
        c1.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(c1);
        
        
        JLabel l3=new JLabel("ROOM NO");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l3.setForeground(Color.blue);
        l3.setBounds(20,110,150,20);
        add(l3);
        t1=new JTextField();
        t1.setBounds(200,110,150,25);
        add(t1);
        
        
        JLabel l4=new JLabel("AVAIBILITY");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l4.setForeground(Color.blue);
        l4.setBounds(20,150,150,20);
        add(l4);
        t2=new JTextField();
        t2.setBounds(200,150,150,25);
        add(t2);
        
        
        JLabel l5=new JLabel("CLEANING STATUS");
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l5.setForeground(Color.blue);
        l5.setBounds(20,190,150,20);
        add(l5);
        t3=new JTextField();
        t3.setBounds(200,190,150,25);
        add(t3);
        
        b1=new JButton("CHECK");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(30,250,100,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("UPDATE");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(150,250,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);
        
        
        b3=new JButton("BACK");
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.setBounds(290,250,100,30);
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.addActionListener(this);
        add(b3);
        
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel(i3);
        l6.setBounds(400,25,400,300);
        add(l6);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1=c1.getSelectedItem();
            conn c=new conn();
            String s2="select * from customer where number='"+s1+"'";
            String s3=null;String s4=null;
            try{
                   ResultSet rs=c.s.executeQuery(s2);
                   while(rs.next()){
                       t1.setText(rs.getString("room"));
                       s3="select * from room where roomnumber='"+rs.getString("room")+"'";
                   }
                   ResultSet rs1=c.s.executeQuery(s3);
                   while(rs1.next()){
                       t2.setText(rs1.getString("available"));
                        t3.setText(rs1.getString("status"));
                   }
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            try{
                conn c=new conn();
                String room=t1.getText();
                String available=t2.getText();
                String status=t3.getText();
                
                String str="update room set available ='"+available+"',"+"status='"+status+"'"+"where roomnumber='"+room+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Upadted");
                new Reception().setVisible(true);
                this.setVisible(false);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateRoom().setVisible(true);
    }
}
