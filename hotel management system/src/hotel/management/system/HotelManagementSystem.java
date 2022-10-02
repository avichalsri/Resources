package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class HotelManagementSystem  extends JFrame implements ActionListener{
    HotelManagementSystem(){
        setBounds(0,100,1366,565);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(0,0,1366,565);
        add(l1);
        JLabel l2=new JLabel("Hotel Management System");
        l2.setBounds(20,400,1000,90);
        l2.setForeground(Color.white);
        l2.setFont(new Font("serif",Font.PLAIN, 70));
        l1.add(l2);
        JButton b1=new JButton("next");
         b1.setFont(new Font("Tahoma",Font.BOLD,20));
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.addActionListener(this);
        b1.setBounds(1030,450,150,50);
        l1.add(b1);
        setLayout(null);
        setVisible(true);
        while(true){
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }catch (Exception e){ }
            l2.setVisible(true);
            try{
                Thread.sleep(500);
            }catch (Exception e){}
        }
    }
    public void actionPerformed(ActionEvent a){
        new Login().setVisible(true);
        this.setVisible(false);
        
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
