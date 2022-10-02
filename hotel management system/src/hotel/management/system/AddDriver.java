package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddDriver extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4;
    JComboBox c1,c2;
    JButton b1,b2;
    AddDriver(){
        setBounds(200,100,1000,500);
        JLabel l1=new JLabel("ADD DRIVER");
        l1.setBounds(180,20,200,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(l1);
        
        JLabel  name=new JLabel("Name");
       name.setBounds(50,70,120,20);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        
        
        t1=new JTextField();
        t1.setBounds(200,70,150,25);
        add(t1);
        
        
        JLabel  age=new JLabel("AADHAR");
       age.setBounds(50,120,120,20);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);
        
        
        t2=new JTextField();
        t2.setBounds(200,120,150,25);
        add(t2);
        
        JLabel  gender=new JLabel("GENDER");
       gender.setBounds(50,170,120,20);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        c1=new JComboBox(new String[]{"MALE","FEMALE"});
        c1.setBounds(200,170,150,25);
        c1.setBackground(Color.white);
        add(c1);
        
         JLabel  model=new JLabel("CAR MODEL");
       model.setBounds(50,220,120,20);
        model.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(model);
        t3=new JTextField();
        t3.setBounds(200,220,150,25);
        add(t3);
        
        
        JLabel  available=new JLabel("AVAILABLE");
       available.setBounds(50,270,120,20);
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(available);
        c2=new JComboBox(new String[]{"Available","Occupied"});
        c2.setBounds(200,270,150,25);
        c2.setBackground(Color.white);
        add(c2);
        
        
        JLabel  location=new JLabel("PRICE");
       location.setBounds(50,320,120,20);
        location.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(location);
        t4=new JTextField();
        t4.setBounds(200,320,150,25);
        add(t4);
        
        
        b1=new JButton("ADD DRIVER");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.setBounds(40,370,140,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CANCEL");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.setBounds(210,370,140,30);
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel l2=new JLabel(i3);
        l2.setBounds(400,30,600,400);
        add(l2);
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name=t1.getText();
            String aadhar=t2.getText();
            String model=t3.getText();
            String price=t4.getText();
            String gender=(String)(c1.getSelectedItem());
            String available=(String)(c2.getSelectedItem());
            
            conn c=new conn();
            String str="insert into driver values("+"'"+aadhar+"',"+"'"+name+"',"+"'"+gender+"',"+"'"+model+"',"+"'"+available+"',"+"'"+price+"')";
          // System.out.println(str);
            try{
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully");
                this.setVisible(false);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddDriver();
    }
}
