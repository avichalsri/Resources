package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Checkout extends JFrame implements ActionListener{
    JComboBox c1,c11;
    JTextField tt1,tt2,tt3,tt4,tt5,tt6,tt7,tt8,tt9,tt10,tt11,tt12,tt13,tt14,tt15,tt16;
    Choice c4;
    JCheckBox c2;
    JButton b1,b2,b5;
    JTable t1,t2,t3;
    Checkout(){
        setBounds(300,-10,1000,750);
        JLabel l1=new JLabel("CHECK-OUT");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(250,30,250,20);
        add(l1);
        
        JLabel l2=new JLabel("DOCUMENT");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l2.setBounds(20,70,150,20);
        add(l2);
        c1=new JComboBox(new String[]{"Passport","VoterID","Aadhar","Driving Licence"});
        c1.setBounds(110,70,100,25);
        c1.setFont(new Font("Tahoma",Font.PLAIN,17));
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel l21=new JLabel("ID-NO");
        l21.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l21.setBounds(260,70,80,20);
        add(l21);
        tt1=new JTextField();
        tt1.setBounds(340,70,150,25);
        add(tt1);
         b5=new JButton("SEARCH");
        b5.setBackground(Color.blue);
        b5.setForeground(Color.white);
        b5.setBounds(500,70,90,25);
        b5.setFont(new Font("Tahoma",Font.PLAIN,15));
        b5.addActionListener(this);
        add(b5);
        
         JLabel l50=new JLabel("DATE");
        l50.setFont(new Font("Tahoma",Font.PLAIN,16));
        l50.setForeground(Color.blue);
        l50.setBounds(680,70,50,20);
        add(l50);
        tt16=new JTextField();
        tt16.setBounds(730,70,150,25);
        add(tt16);
        
        t1=new JTable();
        t1.setBounds(0,150,1000,100);
        add(t1);
        
        JLabel l8=new JLabel("TOTAL");
        l8.setFont(new Font("Tahoma",Font.PLAIN,16));
        l8.setForeground(Color.blue);
        l8.setBounds(20,260,120,20);
        add(l8);
        JLabel l9=new JLabel("PAID");
        l9.setFont(new Font("Tahoma",Font.PLAIN,16));
        l9.setForeground(Color.blue);
        l9.setBounds(270,260,120,20);
        add(l9);
        JLabel l10=new JLabel("REMAINING");
        l10.setFont(new Font("Tahoma",Font.PLAIN,16));
        l10.setForeground(Color.blue);
        l10.setBounds(520,260,120,20);
        add(l10);
        
        tt2=new JTextField();
        tt2.setBounds(80,260,150,25);
        add(tt2);
        
        
        tt3=new JTextField();
        tt3.setBounds(330,260,150,25);
        add(tt3);
        tt4=new JTextField();
        tt4.setBounds(620,260,150,25);
        add(tt4);
        
        tt15=new JTextField();
        tt15.setBounds(10,670,120,25);
        add(tt15);
         b1=new JButton("PAY");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(150,670,120,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("BACK");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(290,670,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);
        
        
        JLabel l3=new JLabel("Room No");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        l3.setForeground(Color.blue);
        l3.setBounds(20,120,120,20);
        add(l3);
        
        
        JLabel l4=new JLabel("EntryDate");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        l4.setForeground(Color.blue);
        l4.setBounds(260,120,120,20);
        add(l4);
        
        JLabel l5=new JLabel("Price");
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        l5.setForeground(Color.blue);
        l5.setBounds(500,120,120,20);
        add(l5);
        
        
        JLabel l6=new JLabel("Amount Paid");
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        l6.setForeground(Color.blue);
        l6.setBounds(740,120,120,20);
        add(l6);
        
        JLabel l13=new JLabel("Driver-Id");
        l13.setFont(new Font("Tahoma",Font.PLAIN,16));
        l13.setForeground(Color.blue);
        l13.setBounds(20,290,120,20);
        add(l13);
        
        
        JLabel l7=new JLabel("Date");
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        l7.setForeground(Color.blue);
        l7.setBounds(260,290,120,20);
        add(l7);
        
        JLabel l11=new JLabel("Price");
        l11.setFont(new Font("Tahoma",Font.PLAIN,16));
        l11.setForeground(Color.blue);
        l11.setBounds(500,290,120,20);
        add(l11);
        
        
        JLabel l12=new JLabel("Amount Paid");
        l12.setFont(new Font("Tahoma",Font.PLAIN,16));
        l12.setForeground(Color.blue);
        l12.setBounds(740,290,120,20);
        add(l12);
        
        t2=new JTable();
        t2.setBounds(0,315,1000,100);
        add(t2);
        
        JLabel l14=new JLabel("TOTAL");
        l14.setFont(new Font("Tahoma",Font.PLAIN,16));
        l14.setForeground(Color.blue);
        l14.setBounds(20,420,120,20);
        add(l14);
        JLabel l15=new JLabel("PAID");
        l15.setFont(new Font("Tahoma",Font.PLAIN,16));
        l15.setForeground(Color.blue);
        l15.setBounds(270,420,120,20);
        add(l15);
        JLabel l16=new JLabel("REMAINING");
        l16.setFont(new Font("Tahoma",Font.PLAIN,16));
        l16.setForeground(Color.blue);
        l16.setBounds(520,420,120,20);
        add(l16);
        
        tt5=new JTextField();
        tt5.setBounds(80,420,150,25);
        add(tt5);
        
        
        tt6=new JTextField();
        tt6.setBounds(330,420,150,25);
        add(tt6);
        tt7=new JTextField();
        tt7.setBounds(620,420,150,25);
        add(tt7);
        
        
        JLabel l17=new JLabel("Food-Item");
        l17.setFont(new Font("Tahoma",Font.PLAIN,16));
        l17.setForeground(Color.blue);
        l17.setBounds(20,460,120,20);
        add(l17);
        
        
        JLabel l18=new JLabel("Date");
        l18.setFont(new Font("Tahoma",Font.PLAIN,16));
        l18.setForeground(Color.blue);
        l18.setBounds(260,460,120,20);
        add(l18);
        
        JLabel l19=new JLabel("Price");
        l19.setFont(new Font("Tahoma",Font.PLAIN,16));
        l19.setForeground(Color.blue);
        l19.setBounds(500,460,120,20);
        add(l19);
        
        
        JLabel l20=new JLabel("Amount Paid");
        l20.setFont(new Font("Tahoma",Font.PLAIN,16));
        l20.setForeground(Color.blue);
        l20.setBounds(740,460,120,20);
        add(l20);
        
        t3=new JTable();
        t3.setBounds(0,485,1000,100);
        add(t3);
        
        JLabel l22=new JLabel("TOTAL");
        l22.setFont(new Font("Tahoma",Font.PLAIN,16));
        l22.setForeground(Color.blue);
        l22.setBounds(20,590,120,20);
        add(l22);
        JLabel l23=new JLabel("PAID");
        l23.setFont(new Font("Tahoma",Font.PLAIN,16));
        l23.setForeground(Color.blue);
        l23.setBounds(270,590,120,20);
        add(l23);
        JLabel l24=new JLabel("REMAINING");
        l24.setFont(new Font("Tahoma",Font.PLAIN,16));
        l24.setForeground(Color.blue);
        l24.setBounds(520,590,120,20);
        add(l24);
        
        tt8=new JTextField();
        tt8.setBounds(80,590,150,25);
        add(tt8);
        
        
        tt9=new JTextField();
        tt9.setBounds(330,590,150,25);
        add(tt9);
        tt10=new JTextField();
        tt10.setBounds(620,590,150,25);
        add(tt10);
        
        
        tt11=new JTextField();
        tt11.setBounds(80,640,150,25);
        add(tt11);
        tt12=new JTextField();
        tt12.setBounds(330,640,150,25);
        add(tt12);
        tt13=new JTextField();
        tt13.setBounds(560,640,150,25);
        add(tt13);
        tt14=new JTextField();
        tt14.setBounds(810,640,150,25);
        add(tt14);
        
        
        JLabel l26=new JLabel("PAID BW");
        l26.setFont(new Font("Tahoma",Font.PLAIN,16));
        l26.setForeground(Color.blue);
        l26.setBounds(0,640,130,20);
        add(l26);
        JLabel l27=new JLabel("TOTAL");
        l27.setFont(new Font("Tahoma",Font.PLAIN,16));
        l27.setForeground(Color.blue);
        l27.setBounds(250,640,120,20);
        add(l27);
        JLabel l28=new JLabel("PAID");
        l28.setFont(new Font("Tahoma",Font.PLAIN,16));
        l28.setForeground(Color.blue);
        l28.setBounds(500,640,120,20);
        add(l28);
        JLabel l29=new JLabel("REMAINING");
        l29.setFont(new Font("Tahoma",Font.PLAIN,16));
        l29.setForeground(Color.blue);
        l29.setBounds(720,640,120,20);
        add(l29);
        
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b5){
                   conn c=new conn();
                   String ss="";
                   String ss1=(String)c1.getSelectedItem();
                   ss+=ss1.charAt(0);
                   ss+=tt1.getText();
                   String s1="select roomno,entryday,price,paid from roomalloted where custid='"+ss+"'";
                   String s2="select id1,date,price,paid from carbooked where id='"+ss+"'";
                   String s3="select name,date,piece,paid from foodcustomer where id='"+ss+"'";
                   String s4="select amount from paidbw where id='"+ss+"'";
                   try{
                        ResultSet rs2=c.s.executeQuery(s1);
                        t1.setModel(DbUtils.resultSetToTableModel(rs2));
                         Integer total1=0,total2=0;
                         ResultSet rs=c.s.executeQuery(s1);
                         Integer cnt=0,total_price=0,total_paid=0;
                         while(rs.next()){
                             cnt++;
                             total1+=Integer.parseInt(rs.getString("price"));
                             total2+=Integer.parseInt(rs.getString("paid"));
                         }
                         total_price=total1;total_paid=total2;
                           tt2.setText(Integer.toString(total1));
                           tt3.setText(Integer.toString(total2));
                           tt4.setText(Integer.toString(total1-total2));
                           
                        rs2=c.s.executeQuery(s2);
                        t2.setModel(DbUtils.resultSetToTableModel(rs2));
                         total1=0;total2=0;
                        rs=c.s.executeQuery(s2);
                         while(rs.next()){
                             cnt++;
                             total1+=Integer.parseInt(rs.getString("price"));
                             total2+=Integer.parseInt(rs.getString("paid"));
                         }
                         total_price+=total1;total_paid+=total2;
                           tt5.setText(Integer.toString(total1));
                           tt6.setText(Integer.toString(total2));
                           tt7.setText(Integer.toString(total1-total2));
                           
                           
                         rs2=c.s.executeQuery(s3);
                        t3.setModel(DbUtils.resultSetToTableModel(rs2));
                         total1=0;total2=0;
                        rs=c.s.executeQuery(s3);
                         while(rs.next()){
                             cnt++;
                             total1+=Integer.parseInt(rs.getString("piece"));
                             total2+=Integer.parseInt(rs.getString("paid"));
                         }
                         total_price+=total1;total_paid+=total2;
                           tt8.setText(Integer.toString(total1));
                           tt9.setText(Integer.toString(total2));
                           tt10.setText(Integer.toString(total1-total2));
                         rs2=c.s.executeQuery(s3);
                        t3.setModel(DbUtils.resultSetToTableModel(rs2));
                        
                        Integer cnt1=0;
                         total1=0;total2=0;
                        rs=c.s.executeQuery(s4);
                         while(rs.next()){
                             ;cnt1++;
                             //total1+=Integer.parseInt(rs.getString("piece"));
                             total2+=Integer.parseInt(rs.getString("amount"));
                         }
                           total_paid+=total2;
                           tt11.setText(Integer.toString(total2));
                           tt12.setText(Integer.toString(total_price));
                           tt13.setText(Integer.toString(total_paid));
                           tt14.setText(Integer.toString(total_price-total_paid));
                           tt15.setText(Integer.toString(0));
                           
                                        
                         if(cnt<=0){
                             tt14.setText(Integer.toString(0));
                             JOptionPane.showMessageDialog(null,"Customer Not Found");
                         }
                         
                   }catch(Exception e){
                       System.out.println(ae);
                   }
        }
        else if(ae.getSource()==b1){
            try{
                conn c=new conn();
               Integer cnt1=0,total=0;
               String ss="";
                String ss1=(String)c1.getSelectedItem();
                ss+=ss1.charAt(0);
                ss+=tt1.getText();
                String s4="select amount from paidbw where id='"+ss+"'";
                 ResultSet rs=c.s.executeQuery(s4);
                 while(rs.next()){
                     cnt1++;total+=Integer.parseInt(rs.getString("amount"));
                 }
                 total+=Integer.parseInt((tt15.getText()));
                 if(cnt1>0){
                     String s5="update paidbw set amount='"+total+"' where id='"+ss+"'";
                     c.s.executeUpdate(s5);
                 }
                 else{
                     String s5="insert into paidbw values('"+ss+"','"+total+"')";
                     c.s.executeUpdate(s5);
                 }
                 Integer x=Integer.parseInt(tt14.getText());
                x-=Integer.parseInt((tt15.getText()));
                if(x==0){
                    String s6="update room set avaibility='Available' where roomno=(select roomno from roomalloted where custid='"+ss+"')";
                    String s7="update driver set avaibility='Available' where aadhar=(select id1 from carbooked where id='"+ss+"')";
                    String s8="delete from roomalloted where custid='"+ss+"'";
                    String s9="delete from carbooked where id='"+ss+"'";
                    String s10="delete from foodcustomer where id='"+ss+"'";
                    String s11="update customer set exitdata='"+tt16.getText()+"' where id='"+ss+"'";
                    c.s.executeUpdate(s6);
                    c.s.executeUpdate(s7);
                    c.s.executeUpdate(s8);
                    c.s.executeUpdate(s9);
                    c.s.executeUpdate(s10);
                    c.s.executeUpdate(s11);
                    JOptionPane.showMessageDialog(null, "CheckOut Successful,Thank You and Welcome for next time");
                    this.setVisible(false);
                    new Dashboard().setVisible(true);
                }
                else if(x>0){
                    JOptionPane.showMessageDialog(null, "Can't Checkout,'"+x+"' has remains to pay");
                }
                else if(x<0){
                    JOptionPane.showMessageDialog(null, "Can't Checkout,'"+x+"' paid extra");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[]args){
        new Checkout().setVisible(true);
    }
}
