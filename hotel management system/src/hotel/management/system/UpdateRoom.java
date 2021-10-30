package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class UpdateRoom extends JFrame implements ActionListener{
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2,b3;
    UpdateRoom(){
        setBounds(200,100,1000,500);
        JLabel l1=new JLabel("UPDATE ROOM STATUS");
        l1.setBounds(120,20,250,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        
       JLabel  room=new JLabel("Room Number");
       room.setBounds(50,70,120,20);
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(room);
        
        
        t1=new JTextField();
        t1.setBounds(200,70,150,25);
        add(t1);
        
        JLabel available=new JLabel("Available");
        available.setBounds(50,110,120,20);
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(available);
        c1=new JComboBox(new String[]{"Available","Occupied","In Service"});
        c1.setBounds(200,110,150,20);
        c1.setBackground(Color.white);
        add(c1);
        
        
        
        JLabel status=new JLabel("Cleaning Status");
        status.setBounds(50,150,120,20);
        status.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(status);
        c2=new JComboBox(new String[]{"Cleaned","Dirty"});
        c2.setBounds(200,150,150,20);
        c2.setBackground(Color.white);
        add(c2);
        
        
        JLabel price=new JLabel("Price");
        price.setBounds(50,190,120,20);
        price.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(price);
        t2=new JTextField();
        t2.setBounds(200,190,150,25);
        add(t2);
        
        JLabel type=new JLabel("Type");
        type.setBounds(50,230,120,20);
        type.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(type);
        setBackground(Color.white);
        c3=new JComboBox(new String[]{"Single","Double"});
        c3.setBounds(200,230,150,20);
        c3.setBackground(Color.white);
        add(c3);
        b3=new JButton("Details");
        b3.setBounds(20,270,120,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Tahoma",Font.PLAIN,18));
        b3.addActionListener(this);
        add(b3);
        
        
        b1=new JButton("Apply");
        b1.setBounds(150,270,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(280,270,120,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        add(b2);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
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
        if(ae.getSource()==b3){
            String roomno=t1.getText();
            conn c=new conn();
             String s1="select *  from room where roomno='"+roomno+"'";
             try{
                 ResultSet rs=c.s.executeQuery(s1);
                 Integer cnt=0;
                 while(rs.next()){
                     cnt++;
                    c1.setSelectedItem(rs.getString("avaibility"));
                    c2.setSelectedItem(rs.getString("status"));
                    t2.setText(rs.getString("price"));
                    c2.setSelectedItem(rs.getString("type"));
                }
                 if(cnt==0){
                     JOptionPane.showMessageDialog(null, "RoomNo Not Exists");
                 }
             }catch(Exception e){
                 System.out.println(e);
             }
        }
        else  if(ae.getSource()==b1){
            String room=t1.getText();
            String available=(String)c1.getSelectedItem();
            String status=(String)c2.getSelectedItem();
            String price=t2.getText();
            String type=(String)c3.getSelectedItem();
            
            conn c=new conn();
            try{
                String str="update room set avaibility='"+available+"',status='"+status+"',price='"+price+"',type='"+type+"' where roomno='"+room+"'";
                //System.out.println(str);
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Changes Successful");
                this.setVisible(false);        
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Unable to Perform Changes");
            }
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateRoom();
    }
}
