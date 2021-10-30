package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame implements ActionListener{
    JComboBox c1,c11;
    Choice c4;
    JCheckBox c2;
    JButton b1,b2,b5;
    JTable t1;
    SearchRoom(){
        setBounds(200,50,1000,600);
        JLabel l1=new JLabel("SEARCH FOR ROOM");
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setForeground(Color.blue);
        l1.setBounds(250,30,250,20);
        add(l1);
        
        JLabel l2=new JLabel("BED TYPE");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l2.setBounds(20,70,150,20);
        add(l2);
        c1=new JComboBox(new String[]{"Any","Single","Double"});
        c1.setBounds(110,70,100,25);
        c1.setFont(new Font("Tahoma",Font.PLAIN,17));
        c1.setBackground(Color.white);
        add(c1);
        
        JLabel l21=new JLabel("STATUS");
        l21.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l21.setBounds(260,70,80,20);
        add(l21);
        c11=new JComboBox(new String[]{"Cleaned","Dirty","Any"});
        c11.setBounds(340,70,100,25);
        c11.setFont(new Font("Tahoma",Font.PLAIN,17));
        c11.setBackground(Color.white);
        add(c11);
        
        c2=new JCheckBox("Only Display Available");
        c2.setBounds(500,70,200,30);
        c2.setBackground(Color.white);
        c2.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(c2);
        
        JLabel l41=new JLabel("PRICE");
        l41.setFont(new Font("Tahoma",Font.PLAIN,16));
        //l2.setForeground(Color.blue);
        l41.setBounds(735,55,60,20);
        add(l41);
        
        c4=new Choice();c4.add("Any");
       try{
            conn c=new conn();
            ResultSet rs;
            rs=c.s.executeQuery("select * from room");
            while(rs.next()){
                c4.add(rs.getString("price"));
            }
        }catch(Exception e){
            
        }
        c4.setBounds(830,70,120,25);
        c4.setFont(new Font("Tahoma",Font.PLAIN,17));
        c4.setBackground(Color.white);
        add(c4);
        
        
        
        t1=new JTable();
        t1.setBounds(0,150,1000,300);
        add(t1);
        
        
         b1=new JButton("CHECK");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(10,520,120,30);
        b1.setFont(new Font("Tahoma",Font.PLAIN,20));
        b1.addActionListener(this);
        add(b1);
        
        
        b2=new JButton("BACK");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(150,520,120,30);
        b2.setFont(new Font("Tahoma",Font.PLAIN,20));
        b2.addActionListener(this);
        add(b2);
        
        
        JLabel l3=new JLabel("Room No");
        l3.setFont(new Font("Tahoma",Font.PLAIN,16));
        l3.setForeground(Color.blue);
        l3.setBounds(20,120,120,20);
        add(l3);
        
        
        JLabel l4=new JLabel("Avaibility");
        l4.setFont(new Font("Tahoma",Font.PLAIN,16));
        l4.setForeground(Color.blue);
        l4.setBounds(220,120,120,20);
        add(l4);
        
        JLabel l5=new JLabel("Status");
        l5.setFont(new Font("Tahoma",Font.PLAIN,16));
        l5.setForeground(Color.blue);
        l5.setBounds(420,120,120,20);
        add(l5);
        
        
        JLabel l6=new JLabel("Price");
        l6.setFont(new Font("Tahoma",Font.PLAIN,16));
        l6.setForeground(Color.blue);
        l6.setBounds(620,120,120,20);
        add(l6);
        
        
        JLabel l7=new JLabel("Bed Type");
        l7.setFont(new Font("Tahoma",Font.PLAIN,16));
        l7.setForeground(Color.blue);
        l7.setBounds(820,120,120,20);
        add(l7);
        
        b5=new JButton("SEARCH");
        b5.setBackground(Color.blue);
        b5.setForeground(Color.white);
        b5.setBounds(735,80,90,25);
        b5.setFont(new Font("Tahoma",Font.PLAIN,15));
        b5.addActionListener(this);
        add(b5);
        
        
        //getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b5){
            c4.removeAll();c4.add("Any");
           try{
              conn c=new conn();
              String s1="select price  from room";Integer cnt=0;
              if(c1.getSelectedItem()=="Any"){
                    ;
                }
                else{
                    if(cnt==0){
                        s1+=(" where type='"+c1.getSelectedItem()+"'");cnt=1;
                    }
                    else{
                        ;
                    }
                }
                if(c11.getSelectedItem()=="Any"){
                    ;
                }
                else{
                    if(cnt==0){
                        s1+=(" where status='"+c11.getSelectedItem()+"'");cnt=1;
                    }
                    else{
                        s1+=(" and status='"+c11.getSelectedItem()+"'");
                    }
                }
                if(c2.isSelected()){
                    if(cnt==0){
                        s1+=(" where avaibility='Available'");cnt=1;
                    }
                    else{
                        s1+=(" and avaibility='Available'");
                    }
                }
                ResultSet rs2=c.s.executeQuery(s1);
               while(rs2.next()){
                  c4.add(rs2.getString("price"));
               }
             }catch(Exception e){
            
            }
        }
        else if(ae.getSource()==b1){
            try{
                String s1="select * from room";Integer cnt=0;
                //String s2="select * from room where available='Unoccupied' and bed='"+c1.getSelectedItem()+"'";
                //System.out.println(s2);
                conn c=new conn();
                if(c1.getSelectedItem()=="Any"){
                    ;
                }
                else{
                    if(cnt==0){
                        s1+=(" where type='"+c1.getSelectedItem()+"'");cnt=1;
                    }
                    else{
                        ;
                    }
                }
                if(c4.getSelectedItem()=="Any"){
                    ;
                }
                else{
                    if(cnt==0){
                        s1+=(" where price='"+c4.getSelectedItem()+"'");cnt=1;
                    }
                    else{
                        s1+=(" and price='"+c4.getSelectedItem()+"'");
                    }
                }
                if(c11.getSelectedItem()=="Any"){
                    ;
                }
                else{
                    if(cnt==0){
                        s1+=(" where status='"+c11.getSelectedItem()+"'");cnt=1;
                    }
                    else{
                        s1+=(" and status='"+c11.getSelectedItem()+"'");
                    }
                }
                /*if(c2.isSelected()){
                    ResultSet rs2=c.s.executeQuery(s1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs2));
                }
                else{
                    ResultSet rs1=c.s.executeQuery(s1);
                    t1.setModel(DbUtils.resultSetToTableModel(rs1));
                */
                if(c2.isSelected()){
                    if(cnt==0){
                        s1+=(" where avaibility='Available'");cnt=1;
                    }
                    else{
                        s1+=(" and avaibility='Available'");
                    }
                }
                ResultSet rs2=c.s.executeQuery(s1);
                t1.setModel(DbUtils.resultSetToTableModel(rs2));
                
                
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
        new SearchRoom().setVisible(true);
    }
}
