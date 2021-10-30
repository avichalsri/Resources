package hotel.management.system;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
       JLabel l1,l2;
       JTextField t1;
       JPasswordField t2;
       JButton b1,b2;
        Login(){
            setBounds(500,200,600,400);
            l1=new JLabel("UserName");
            l1.setBounds(40,20,100,30);
            add(l1);
            l2=new JLabel("Password");
            l2.setBounds(40,70,100,30);
            add(l2);
            t1=new JTextField();t2=new JPasswordField();
            t1.setBounds(150, 20, 150, 20);
            add(t1);
            t2.setBounds(150, 70, 150, 20);
            add(t2);
            b1=new JButton("Login");
            b1.setBackground(Color.white);
            b1.setForeground(Color.blue);
            b1.setBounds(40, 150, 120, 30);
            b1.addActionListener(this);
            add(b1);
            b2=new JButton("Cancel");
            b2.setBackground(Color.white);
            b2.setForeground(Color.blue);
            b2.setBounds(180, 150, 120, 30);
            b2.addActionListener(this);
            add(b2);
            getContentPane().setBackground(Color.WHITE);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
            Image i2=i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
            ImageIcon i3=new ImageIcon(i2);
            JLabel l3=new JLabel(i3);
            l3.setBounds(350,10,200,200);
            add(l3);
           setLayout(null);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==b1){
                String username=t1.getText();
                String password=t2.getText();
                conn c=new conn();
                String str="select * from login where username = "+"'"+username+"'"+" and password ="+"'"+password+"'";
                try{
                    ResultSet rs=c.s.executeQuery(str);
                    if(rs.next()){
                        this.setVisible(false);
                       new Dashboard().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                        this.setVisible(false);
                    }
                }catch(Exception e){
                    ;
                }
            }
            else if(ae.getSource()==b2){
                System.exit(0);
            }
        }
        public static void main(String[] args){
            new Login();
        }
}
