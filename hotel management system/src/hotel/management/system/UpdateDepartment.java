package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class UpdateDepartment extends JFrame implements ActionListener{
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3;
    JButton b1,b2,b3;
    UpdateDepartment(){
        setBounds(500,100,400,400);
        JLabel l1=new JLabel("UPDATE DEPT");
        l1.setBounds(150,20,200,20);
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        add(l1);
        
        
       JLabel  room=new JLabel("Department");
       room.setBounds(50,70,120,20);
        room.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(room);
        
        
        t1=new JTextField();
        t1.setBounds(200,70,150,25);
        add(t1);
        
        JLabel available=new JLabel("Old Budgete");
        available.setBounds(50,110,120,20);
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(available);
       t3=new JTextField();
        t3.setBounds(200,110,150,25);
        add(t3);

        JLabel price=new JLabel("New Budgete");
        price.setBounds(50,150,120,20);
        price.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(price);
        t2=new JTextField();
        t2.setBounds(200,150,150,25);
        add(t2);
       
        
        b3=new JButton("SEARCH");
        b3.setBounds(10,210,110,30);
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Tahoma",Font.PLAIN,18));
        b3.addActionListener(this);
        add(b3);
        b1=new JButton("UPDATE");
        b1.setBounds(130,210,110,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("CANCEL");
        b2.setBounds(250,210,110,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b3){
            String s1=t1.getText();
            Integer cnt=0;
           try{
                String ss="select * from department where dept='"+s1+"'";
                System.out.println(ss);
                 conn c=new conn();
                 ResultSet rs=c.s.executeQuery(ss);
                while(rs.next()){
                      t3.setText(rs.getString("budget"));
                      cnt++;
                }
                }catch(Exception e){
            
                 }
              if(cnt==0){
                  JOptionPane.showMessageDialog(null, "Department Not Exists");
              }
        }
        else  if(ae.getSource()==b1){
            String dept=t1.getText();
           // String available=(String)c1.getSelectedItem();
            String budget=t2.getText();
           
            conn c=new conn();
            try{
                String str="update department set budget='"+budget+"' where dept='"+dept+"'";
                System.out.println(str);
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Update Successful");
                this.setVisible(false);
                new Reception().setVisible(true);
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Food Already Exists");
            }
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new UpdateDepartment();
    }
}
