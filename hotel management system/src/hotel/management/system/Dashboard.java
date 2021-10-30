package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4,i5,i6;
     Dashboard(){
         mb=new JMenuBar();
         add(mb);
         m1=new JMenu("HOTEL MANAGEMENT");
         mb.add(m1);
         m1.setForeground(Color.red);
         m2=new JMenu("ADMIN");
         mb.add(m2);
         m2.setForeground(Color.blue);
         i1=new JMenuItem("RECEPTION");
         i1.addActionListener(this);
         m1.add(i1);
         i2=new JMenuItem("ADD EMPLOYEE");
         i2.addActionListener(this);
         m2.add(i2);
         i3=new JMenuItem("ADD ROOMS");
         i3.addActionListener(this);
         m2.add(i3);
         i4=new JMenuItem("ADD DRIVER");
         i4.addActionListener(this);
         m2.add(i4);
         i5=new JMenuItem("ADD FOOD");
         i5.addActionListener(this);
         m2.add(i5);
         i6=new JMenuItem("ADD DEPARTMENT");
         i6.addActionListener(this);
         m2.add(i6);
         mb.setBounds(0,0,1950,30);
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
         Image i2=i1.getImage().getScaledInstance(1950,680,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel l1=new JLabel(i3);
         l1.setBounds(0,30,1950,680);
         add(l1);
         JLabel l2=new JLabel("THE TAJ WELCOMES YOU");
         l2.setForeground(Color.white);
         l2.setBounds(400,50,600,50);
         l2.setFont(new Font("Tahoma",Font.PLAIN,40));
         l1.add(l2);
         setLayout(null);
         setBounds(0,0,1950,700);
         setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
         if(ae.getActionCommand().equals("RECEPTION")){
             new Reception().setVisible(true);
         }
         else if(ae.getActionCommand().equals("ADD EMPLOYEE")){
             new AddEmployee().setVisible(true);
         }
         else if(ae.getActionCommand().equals("ADD ROOMS")){
             new AddRoom().setVisible(true);
         }
         else if(ae.getActionCommand().equals("ADD DRIVER")){
             new AddDriver().setVisible(true);
         }
         else if(ae.getActionCommand().equals("ADD FOOD")){
             new Addfood().setVisible(true);
         }
         else if(ae.getActionCommand().equals("ADD DEPARTMENT")){
             new AddDepartment().setVisible(true);
         }
     }
     public static void main(String[] args){
         new Dashboard();
     }
}
