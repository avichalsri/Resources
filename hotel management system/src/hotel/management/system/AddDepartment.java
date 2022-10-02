
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDepartment extends JFrame implements ActionListener{
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    AddDepartment(){
        setBounds(500,100,400,400);
        JLabel l1=new JLabel("ADD DEPT");
        l1.setBounds(150,20,200,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(l1);
        
        
       JLabel  room=new JLabel("Dept Name");
       room.setBounds(50,70,120,20);
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(room);
        
        
        t1=new JTextField();
        t1.setBounds(200,70,150,25);
        add(t1);
        
        
        JLabel  budgete=new JLabel("Budgete");
       budgete.setBounds(50,120,120,20);
        budgete.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(budgete);
        
        
        t2=new JTextField();
        t2.setBounds(200,120,150,25);
        add(t2);
        
        
        
        
        b1=new JButton("Add Dept");
        b1.setBounds(50,210,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(190,210,120,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        add(b2);
        
        
        /*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel l2=new JLabel(i3);
        l2.setBounds(400,30,600,400);
        add(l2);*/
        
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String dept=t1.getText();
            //String available=(String)c1.getSelectedItem();
            //String status=(String)c2.getSelectedItem();
            String budgete=t2.getText();
           // String type=(String)c3.getSelectedItem();
            
            conn c=new conn();
            try{
                String str="insert into  department values("+"'"+dept+"','"+budgete+"')";
                System.out.println(str);
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Department Added Successfully");
                this.setVisible(false);        
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Dept Already Exists,So go in Update Dept Section");
            }
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
            new Dashboard().setVisible(true);
        }
    }
    public static void main(String[] args){
        new AddDepartment();
    }
}
