package hotel.management.system;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class AddEmployee extends JFrame  implements ActionListener{
    JTextField t1,t2,t3,t4,t5,t6;
    JRadioButton r1,r2;
    JComboBox box;
    JButton b1,b2;
    AddEmployee(){
        setBounds(270,160,800,520);
        JLabel name=new JLabel("NAME");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60,30,120,30);
        name.setForeground(Color.gray);
        add(name);
        t1=new JTextField();
        t1.setBounds(200,30,150,25);
        add(t1);
        
        
        JLabel age=new JLabel("AGE");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60,80,120,30);
        age.setForeground(Color.gray);
        add(age);
        t2=new JTextField();
        t2.setBounds(200,80,150,25);
        add(t2);
        
        
        JLabel gender=new JLabel("GENDER");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60,130,120,30);
        gender.setForeground(Color.gray);
        add(gender);
        r1=new JRadioButton("Male");
        r1.setBounds(200,130,60,30);
        r1.setFont(new Font("Tahoma",Font.PLAIN,16));
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setBounds(270,130,100,30);
        r2.setFont(new Font("Tahoma",Font.PLAIN,16));
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel job=new JLabel("JOB");
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        job.setBounds(60,180,120,30);
        job.setForeground(Color.gray);
        add(job);
        String str[ ]={"Please select","Front Desk Clerks","Porters","HouseKeeping","Kitchen","Room Service","Kaiters","Manager","Accountant"};
        box=new JComboBox(str);
        box.setBounds(200,180,150,30);
        box.setBackground(Color.WHITE);
        add(box);
        
        
        JLabel salary=new JLabel("SALARY");
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        salary.setBounds(60,230,120,30);
        salary.setForeground(Color.gray);
        add(salary);
        t3=new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);
        
        
        JLabel phone=new JLabel("PHONE");
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        phone.setBounds(60,280,120,30);
        phone.setForeground(Color.gray);
        add(phone);
        t4=new JTextField();
        t4.setBounds(200,280,150,25);
        add(t4);
        
        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        aadhar.setBounds(60,330,120,30);
       aadhar.setForeground(Color.gray);
        add(aadhar);
        t5=new JTextField();
        t5.setBounds(200,330,150,25);
        add(t5);
        
        
        JLabel mail=new JLabel("EMAIL");
        mail.setFont(new Font("Tahoma",Font.PLAIN,17));
        mail.setBounds(60,380,120,30);
        mail.setForeground(Color.gray);
        add(mail);
        t6=new JTextField();
        t6.setBounds(200,380,150,25);
        add(t6);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
        JLabel l1=new JLabel(i1);
        Image i2=i1.getImage().getScaledInstance(400,500, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l2=new JLabel(i3);
        l2.setBounds(400,0,400,540);
        add(l2);
        
        JLabel l3=new JLabel("ADD EMPLOYEE DETAILS");
        l3.setForeground(Color.blue);
        l3.setBounds(50,30,400,20);
        l3.setFont(new Font("Tahoma",Font.PLAIN,25));
        l2.add(l3);
        getContentPane().setBackground(Color.WHITE);
        
        b1=new JButton("SUBMIT");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(200,430,150,30);
        b1.setFont(new Font("Tahima",Font.PLAIN,15));
        add(b1);
        b1.addActionListener(this);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name=t1.getText();
        String age=t2.getText();
        String salary=t3.getText();
        String phone=t4.getText();
        String aadhar=t5.getText();
        String mail=t6.getText();
        
        String gender=null;
        if(r1.isSelected()){
            gender="Male";
        }
        else{
            gender="Female";
        }
        
        String job=(String)box.getSelectedItem();
        
        conn c=new conn();
        String str="insert into employee values("+"'"+name+"',"+"'"+age+"',"+"'"+gender+"',"+"'"+job+"',"+"'"+salary+"',"+"'"+phone+"',"+"'"+aadhar+"',"+"'"+mail+"'"+")";
        try{
            c.s.executeUpdate(str);
            JOptionPane.showMessageDialog(null,"New Employee Added");
            this.setVisible(false);
        }catch(Exception e){
            System.out.println(e);
        }
        //System.out.println(str);
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
