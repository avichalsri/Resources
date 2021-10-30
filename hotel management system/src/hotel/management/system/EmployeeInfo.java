package hotel.management.system;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class EmployeeInfo extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    Choice c2;
    JTextField j1;
    JCheckBox c3;
    EmployeeInfo(){
        JLabel l10=new JLabel("JOB");
        l10.setFont(new Font("Tahoma",Font.PLAIN,16));
        l10.setBounds(20,50,100,20);
        add(l10);
        c2=new Choice();
        try{
            conn c=new conn();
            String str="select job from employee group by job";
            ResultSet rs=c.s.executeQuery(str);
            c2.add("Any");
            while(rs.next()){
                c2.add(rs.getString("job"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        c2.setBounds(150,50,150,25);
        add(c2);
        
        JLabel l11=new JLabel("ADDHAR");
        l11.setFont(new Font("Tahoma",Font.PLAIN,16));
        l11.setBounds(370,50,150,20);
        add(l11);
        
        j1=new JTextField();
        j1.setBounds(500,50,150,20);
        add(j1);
        
        
        c3=new JCheckBox("Search by Aadhar");
        c3.setBounds(670,40,200,30);
        c3.setBackground(Color.white);
        c3.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(c3);
        
        
        setBounds(80,100,1250,600);
        t1=new JTable();
        t1.setBounds(0,130,1250,350);
        add(t1);
        
        JLabel l1=new JLabel("Name");
        l1.setBounds(30,100,100,20);
        add(l1);
        
        JLabel l2=new JLabel("Age");
        l2.setBounds(186,100,100,20);
        add(l2);
        
        JLabel l3=new JLabel("Gender");
        l3.setBounds(342,100,100,20);
        add(l3);
        
        JLabel l4=new JLabel("Job");
        l4.setBounds(498,100,100,20);
        add(l4);
        
        JLabel l5=new JLabel("Salary");
        l5.setBounds(654,100,100,20);
        add(l5);
        
        JLabel l6=new JLabel("Phone");
        l6.setBounds(810,100,100,20);
        add(l6);
        
        JLabel l7=new JLabel("Aadhar");
        l7.setBounds(966,100,100,20);
        add(l7);
        
        JLabel l8=new JLabel("Mail");
        l8.setBounds(1122,100,100,20);
        add(l8);
        
        b1=new JButton("Load data");
        b1.setBounds(400,500,150,30);
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setFont(new Font("Tahoma",Font.PLAIN,18));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("Back");
        b2.setBounds(600,500,150,30);
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setFont(new Font("Tahoma",Font.PLAIN,18));
        b2.addActionListener(this);
        add(b2);
                
        
        
       // getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c=new conn();
                String str="select * from employee";
                if(c3.isSelected()){
                    str+=" where aadhar='"+j1.getText()+"'";
                }
                else if(c2.getSelectedItem()!="Any"){
                    str+=" where job='"+c2.getSelectedItem()+"'";
                }
                ResultSet rs=c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new EmployeeInfo().setVisible(true);
    }
}
