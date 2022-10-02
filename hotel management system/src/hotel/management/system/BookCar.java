package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class BookCar extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton b1,b2;
    JComboBox c1;
    Choice c2,c3;
    JButton b3,b4,b5,b6;
   BookCar(){
        setBounds(200,100,800,600);
        JLabel l1=new JLabel("BOOK CAR");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(70,30,250,20);
        add(l1);
        
        
        JLabel l2=new JLabel("ID");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l2.setBounds(20,70,150,20);
        add(l2);
        c1=new JComboBox(new String[]{"Passport","VoterID","Aadhar","Driving Licence"});
        c1.setBounds(200,70,150,25);
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel l3=new JLabel("ID-NUMBER");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l3.setForeground(Color.blue);
        l3.setBounds(20,110,150,20);
        add(l3);
        t1=new JTextField();
        t1.setBounds(200,110,150,25);
        add(t1);
        
        
       /* JLabel l4=new JLabel("NAME");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l4.setForeground(Color.blue);
        l4.setBounds(20,150,150,20);
        add(l4);
        t2=new JTextField();
        t2.setBounds(200,150,150,25);
        add(t2);
        
        
        JLabel l5=new JLabel("GENDER");
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l5.setForeground(Color.blue);
        l5.setBounds(20,190,150,20);
        add(l5);
        b1=new JRadioButton("Male");
        b1.setBounds(200,190,70,20);
        b1.setFont(new Font("Tahoma",Font.PLAIN,17));
        b1.setBackground(Color.white);
        add(b1);
        b2=new JRadioButton("Female");
        b2.setBounds(280,190,100,20);
        b2.setFont(new Font("Tahoma",Font.PLAIN,17));
        b2.setBackground(Color.white);
        add(b2);
        
        
        JLabel l6=new JLabel("COUNTRY");
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l6.setForeground(Color.blue);
        l6.setBounds(20,230,150,20);
        add(l6);
        t3=new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);*/
        
        
        JLabel l7=new JLabel("MODEL");
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l7.setForeground(Color.blue);
        l7.setBounds(20,150,150,20);
        add(l7);
        c2=new Choice();
        try{
            conn c=new conn();
            String str="select * from driver where avaibility='"+"Available"+"'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("model"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c2.setBounds(200,150,150,25);
        add(c2);
        
        
        b5=new JButton("SEARCH");
        b5.setBackground(Color.blue);
        b5.setForeground(Color.white);
        b5.setBounds(200,190,100,30);
        b5.setFont(new Font("Tahoma",Font.PLAIN,15));
        b5.addActionListener(this);
        add(b5);
        
        JLabel l10=new JLabel("CAR-ID");
        l10.setFont(new Font("Tahoma",Font.PLAIN,16));
        l10.setBounds(20,230,150,20);
        add(l10);
        c3=new Choice();
        try{
            conn c=new conn();
            String str="select * from driver where avaibility='"+"Available"+"' and model='"+c2.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                c3.add(rs.getString("aadhar"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c3.setBounds(200,230,150,25);
        add(c3);
        
         b6=new JButton("SEARCH");
        b6.setBackground(Color.blue);
        b6.setForeground(Color.white);
        b6.setBounds(200,270,100,30);
        b6.setFont(new Font("Tahoma",Font.PLAIN,15));
        b6.addActionListener(this);
        add(b6);
        
        
        JLabel l11=new JLabel("PRICE");
        l11.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l8.setForeground(Color.blue);
        l11.setBounds(20,310,150,20);
        add(l11);
        t7=new JTextField();
        t7.setBounds(200,310,150,25);
        add(t7);
        
        
        
        JLabel l8=new JLabel("DEPOSIT");
        l8.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l8.setForeground(Color.blue);
        l8.setBounds(20,350,150,20);
        add(l8);
        t4=new JTextField();
        t4.setBounds(200,350,150,25);
        add(t4);
        
        JLabel l9=new JLabel("DATE");
        l9.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l9.setForeground(Color.blue);
        l9.setBounds(20,390,150,20);
        add(l9);
        t5=new JTextField();
        t5.setBounds(200,390,150,25);
        add(t5);
        
        /*t6=new JTextField();
        t6.setBounds(200,470,150,25);
        add(t6);*/
        
        /*JLabel l10=new JLabel("MOBILE");
        l10.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l10.setBounds(20,470,150,20);
        add(l10);*/
        
        b3=new JButton("ADD");
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.setBounds(20,510,100,30);
        b3.setFont(new Font("Tahoma",Font.PLAIN,20));
        b3.addActionListener(this);
        add(b3);
        
        
        b4=new JButton("BACK");
        b4.setBackground(Color.blue);
        b4.setForeground(Color.white);
        b4.setBounds(200,510,100,30);
        b4.setFont(new Font("Tahoma",Font.PLAIN,20));
        b4.addActionListener(this);
        add(b4);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.png"));
        Image i3=i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT );
        ImageIcon i4=new ImageIcon(i3);
        JLabel i2=new JLabel(i4);
        i2.setBounds(400,30,400,450);
        add(i2);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b3){
        String id=(String)c1.getSelectedItem();
        String id1="";
        id1+=id.charAt(0);
        String number=t1.getText();
        id1+=number;
        String id2=c3.getSelectedItem();
       // String name=t2.getText();
        /*String gender=null;
        if(b1.isSelected()){
            gender="Male";
        }
        else if(b2.isSelected()){
            gender="Female";
        }
        String country=t3.getText();
        String room=c2.getSelectedItem();*/
        String inday=t5.getText();
        String deposit=t4.getText();
        //String number1=t6.getText();
        String price=t7.getText();
        String str2="insert into carbooked values("+"'"+id1+"','"+id2+"','"+price+"','"+deposit+"','"+inday+"')";
        String str="select * from customer where id='"+id1+"'";
       String str1="update driver set avaibility='Occupied' where aadhar="+"'"+id2+"'";
        try{
           conn c=new conn();
           ResultSet rs=c.s.executeQuery(str);
           int cnt=0;
           while(rs.next()){
               cnt++;
           }
           if(cnt==0){
               JOptionPane.showMessageDialog(null,"Customer Not Present");
           }
           else{ 
           c.s.executeUpdate(str1);
           c.s.executeUpdate(str2);
           JOptionPane.showMessageDialog(null,"Car Booked Successfully");
           new Reception().setVisible(true);
           this.setVisible(false);}
           
       }catch(Exception e){
           System.out.println(e);
       }
       }
        else if(ae.getSource()==b5){
            c3.removeAll();
           try{
              conn c=new conn();
              String str="select * from driver where avaibility='"+"Available"+"' and model='"+c2.getSelectedItem()+"'";
              ResultSet rs=c.s.executeQuery(str);
              while(rs.next()){
                 c3.add(rs.getString("aadhar"));
               }
             }catch(Exception e){
            System.out.println(e);
           }
            
        }
        else if(ae.getSource()==b6){
            String price="";
           try{
              conn c=new conn();
              String str="select * from driver  where aadhar='"+c3.getSelectedItem()+"'";
              ResultSet rs=c.s.executeQuery(str);
              while(rs.next()){
                 price=(rs.getString("price"));
              }
              t7.setText(price);
            }catch(Exception e){
              System.out.println(e);
            }
        }
        else if(ae.getSource()==b4){
            new Reception().setVisible(true);
           this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new BookCar().setVisible(true);
    }
    
}
