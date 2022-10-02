package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
    Reception(){
        setBounds(400,100,800,550);
        b1=new JButton("New Costumor Form");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(10,20,200,25);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Search Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(10,60,200,25);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        add(b2);
        
        
        b3=new JButton("Update Room Status");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setBounds(10,100,200,25);
        b3.setFont(new Font("Tahoma",Font.PLAIN,18));
        b3.addActionListener(this);
        add(b3);
        
        b4=new JButton("Order Food");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        b4.setBounds(10,140,200,25);
        b4.setFont(new Font("Tahoma",Font.PLAIN,18));
        b4.addActionListener(this);
        add(b4);
        
        b5=new JButton("Book Car");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.white);
        b5.setBounds(10,180,200,25);
        b5.setFont(new Font("Tahoma",Font.PLAIN,18));
        b5.addActionListener(this);
        add(b5);
        
        b6=new JButton("Pay");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.white);
        b6.setBounds(10,220,200,25);
        b6.setFont(new Font("Tahoma",Font.PLAIN,18));
        b6.addActionListener(this);
        add(b6);
        
        b7=new JButton("CheckOut");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.white);
        b7.setBounds(10,260,200,25);
        b7.setFont(new Font("Tahoma",Font.PLAIN,18));
        b7.addActionListener(this);
        add(b7);
        
        b8=new JButton("Employee Info");
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.white);
        b8.setBounds(10,300,200,25);
        b8.setFont(new Font("Tahoma",Font.PLAIN,18));
        b8.addActionListener(this);
        add(b8);
        
        b9=new JButton("Department Info");
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.white);
        b9.setBounds(10,340,200,25);
        b9.setFont(new Font("Tahoma",Font.PLAIN,18));
        b9.addActionListener(this);
        add(b9);
        
        b10=new JButton("Update Dept");
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.white);
        b10.setBounds(10,380,200,25);
        b10.setFont(new Font("Tahoma",Font.PLAIN,18));
        b10.addActionListener(this);
        add(b10);
        
       /* b11=new JButton("Search Room");
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.white);
        b11.setBounds(10,420,200,25);
        b11.setFont(new Font("Tahoma",Font.PLAIN,18));
        b11.addActionListener(this);
        add(b11);*/
        
        b12=new JButton("LogOut");
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.white);
        b12.setBounds(10,420,200,25);
        b12.setFont(new Font("Tahoma",Font.PLAIN,18));
        b12.addActionListener(this);
        add(b12);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(250,20,500,470);
        add(l1);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddCustomer().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b2){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b3){
            new UpdateRoom1().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b4){
            new OrderFood().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b5){
            new BookCar().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b6){
            new PayMiddle().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b7){
            new Checkout().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b8){
            new EmployeeInfo().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b9){
            new Department().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b10){
            new UpdateDepartment().setVisible(true);
            this.setVisible(false);
        }
        /*else if(ae.getSource()==b11){
            new SearchRoom().setVisible(true);
            this.setVisible(false);
        }*/
        else if(ae.getSource()==b12){
            this.setVisible(false);
        }
        
    }
    public static void main(String[]args){
        new Reception().setVisible(true);
    }
}
