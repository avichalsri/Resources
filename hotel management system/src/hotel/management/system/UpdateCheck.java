package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateCheck extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1,t2,t3,t4,t5;
    Choice c1;
    UpdateCheck(){
        setBounds(400,150,700,400);
        JLabel l1=new JLabel("CHECK IN DETAILS");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(50,30,250,20);
        add(l1);
        
        
        JLabel l2=new JLabel("CUSTOMER  ID");
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
            c1.setBounds(200,70,150,25);
            c1.setFont(new Font("Tahoma",Font.PLAIN,17));
            add(c1);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        JLabel l3=new JLabel("ROOM NO");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l3.setForeground(Color.blue);
        l3.setBounds(20,110,150,20);
        add(l3);
        t1=new JTextField();
        t1.setBounds(200,110,150,25);
        add(t1);
        
        
        JLabel l4=new JLabel("NAME");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l4.setForeground(Color.blue);
        l4.setBounds(20,150,150,20);
        add(l4);
        t2=new JTextField();
        t2.setBounds(200,150,150,25);
        add(t2);
        
        
        JLabel l5=new JLabel("CHECK-IN");
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l5.setForeground(Color.blue);
        l5.setBounds(20,190,150,20);
        add(l5);
        t3=new JTextField();
        t3.setBounds(200,190,150,25);
        add(t3);
        
        JLabel l6=new JLabel("AMOUNT PAID");
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l6.setForeground(Color.blue);
        l6.setBounds(20,230,150,20);
        add(l6);
        t4=new JTextField();
        t4.setBounds(200,230,150,25);
        add(t4);
        
        
        JLabel l7=new JLabel("PENDING");
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l7.setForeground(Color.blue);
        l7.setBounds(20,270,150,20);
        add(l7);
        t5=new JTextField();
        t5.setBounds(200,270,150,25);
        add(t5);
        
        b1=new JButton("CHECK");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(10,310,100,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("UPDATE");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(130,310,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);
        
        
        b3=new JButton("BACK");
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.setBounds(260,310,100,30);
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(420,55,250,250);
        add(l9);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c=new conn();
                String id=c1.getSelectedItem();
                String s1="select * from customer where number='"+id+"'";
                ResultSet rs=c.s.executeQuery(s1);
                String deposit=null,price=null,s=null;
                Integer pending;
                while(rs.next()){
                    t1.setText(rs.getString("room"));
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("status"));
                    t4.setText(rs.getString("deposit"));  
                    s=rs.getString("room");
                    deposit=rs.getString("deposit");
                }
                ResultSet rs1=c.s.executeQuery("select * from room where roomnumber='"+s+"'");
                while(rs1.next()){
                    price=rs1.getString("price");
                    pending=Integer.parseInt(price)-Integer.parseInt(deposit);
                    t5.setText(Integer.toString(pending));
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            
        }
        else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
