/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Railway;
    
import static Railway.Registeration.address;
import static Railway.Registeration.email;
import static Railway.Registeration.name;
import static Railway.Registeration.phone;
import static Railway.login.username;
import com.toedter.calendar.JCalendar;  
import com.toedter.calendar.JDateChooser;
import java.awt.Button;  
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font; 
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author pc
 */
public class reserve extends JFrame { 
    public final static int no = 10 ;
    public static int f,m,ch,st,decide;
    public static  float total;
    JLabel l, l1, l2, l3, l4, l5, l6, l7, l8,l9,l10,la,lno,lpnr;
    JTextField tf, tf1, tf2, tf3,tno,tpnr,td;
    JButton b1, b2 , b,b3;  
    JRadioButton r1, r2;
    JTextArea a1;
    JComboBox c,c1,c2;
    JPasswordField pf, pf1; 
    JCheckBox cb1, cb2, cb3;
    ButtonGroup bg;
    JCalendar cal; 
    JDateChooser d;
    Panel p,pl;
    JLabel male,female,child;
    JTextField m1,f1,ch1;
    public static float finalP;
    public static float cs=165,cr=250,ds=40,dr=60;
    public static float cs1 = 98,cr1=140,ds1=110,dr1=220;
    public static String pnr1 = "11048",pnr2 = "16010",pnr3="15001",pnr4="17068";
    public static String t1 = "1:30pm",t2 = "10:00am",t3="6:20am",t4="9:00pm";
    public static String t5="5:50pm",t6="3:20pm",t7="7:25am",t8="10:35am",str;
    public static String start , end, type,TrainNo,in,out,date,seat , date1,tno1,pnr; 
    public void register3() {
        
        JLabel p1=new JLabel(); 
        add(p1); 
        setTitle("TICKET BOOKING");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        l = new JLabel("RESERVE TICKETS");
          l.setBounds(300, 5, 250, 45);
        add(l);
        l.setFont(new Font(null, Font.BOLD, 24));
        l1 = new JLabel("Starting place");
        l1.setBounds(150, 50, 100, 30);
        add(l1);
        l1.setForeground(new Color(150, 40, 50));
          c= new JComboBox();
        c.setBounds(300, 50, 200, 30);
        c.addItem("select city");
        c.addItem("Chandigarh");
        c.addItem("Delhi");
        add(c);
       
//      
        l2 = new JLabel("Ending place");
        l2.setBounds(150, 90, 100, 30);
        add(l2);
        l2.setForeground(new Color(150, 40, 50));
         c1= new JComboBox();
        c1.setBounds(300, 90, 200, 30);
        c1.addItem("Select city");
        c1.addItem("Sonipat");
        c1.addItem("Rohtak");
        add(c1);
        
        
        
          l3 = new JLabel("Ticket Type");
        l3.setBounds(150, 140, 100, 30);
        add(l3);
       // l3.setForeground(new Color(150, 40, 50));
         c2= new JComboBox();
        c2.setBounds(300, 140, 200, 30); 
        c2.addItem("Ticket Type");
        c2.addItem("Sleeper");
        c2.addItem("Sitting");
        add(c2);
        
        l4 = new JLabel("Date");
        l4.setBounds(150, 190, 100, 30);
        add(l4); 
        l4.setForeground(new Color(150, 40, 50));
        d = new JDateChooser(); 
        add(d); 
       d.setBounds(300, 190, 200, 30); 
         l9 = new JLabel(new ImageIcon("E:\\1.jpg"));
        l9.setBounds(500, 10, 1000,500);
       add(l9);
             
        b1 = new JButton("Submit");
        b1.setBounds(220, 240, 100, 35);
        add(b1);
        
        b3 = new JButton("Cancel");   
        b3.setBounds(370, 240, 100, 35);
        add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                 int r=JOptionPane.showConfirmDialog(null, "Press OK to Confirm");
            if(r==JOptionPane.OK_OPTION)
            {  
                activity v = new activity();
                setVisible(false); 
                v.register4();
            }
           }
        }); 
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                 SimpleDateFormat de = new SimpleDateFormat("yyyy/MM/dd");
                Date d1 = (new Date());
                Date d2 = d.getDate();
            
              if(d1.compareTo(d2)>0) 
              {
                  JOptionPane.showMessageDialog(null, "Invalid dtae","Error",JOptionPane.ERROR_MESSAGE);
//                  reserve r = new reserve();
//                  setVisible(false); 
//                  r.register3();
              }
                
              else if(c.getSelectedItem().toString().equals("select city")||c1.getSelectedItem().toString().equals("Select city")||c2.getSelectedItem().toString().equals("Ticket Type"))          {
               JOptionPane.showMessageDialog(null, "Fields Cannnot be Empty","Error",JOptionPane.ERROR_MESSAGE);
            }
               
            else
            { 
               int r=JOptionPane.showConfirmDialog(null, "Press OK to Confirm","Cinfirmation",2);
            if(r==JOptionPane.OK_OPTION)
            {
                
                p=new Panel(); 
                p.setBounds(100, 260, 500, 800);
                add(p);
                String s1 = c1.getSelectedItem().toString();
                 String s2 = c2.getSelectedItem().toString();
                                               
//                 la = new JLabel("*** Available seats are:- 10");
//                 la.setBounds(40, 20, 150, 30);
//                 p.add(la); 
//                       

               male = new JLabel("Male ");
               male.setBounds(40, 60, 150, 30); 
               p.add(male); 
               m1  = new JTextField();   
               m1.setBounds(190, 60, 200, 30);
               p.add(m1);
               m1.setText("0");
              m1.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != '\b')) {
                    evt.consume();  
               }
            }
        });
               
               female = new JLabel("Female ");
               female.setBounds(40, 110, 150, 30);
               p.add(female); 
               f1  = new JTextField();
               f1.setBounds(190, 110, 200, 30);
               p.add(f1);
               f1.setText("0");
             f1.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != '\b')) {
                    evt.consume();  
               }
            }
        });
               
               child = new JLabel("Child ");
               child.setBounds(40, 160, 150, 30);
               p.add(child); 
               ch1  = new JTextField();
               ch1.setBounds(190, 160, 200, 30);
               p.add(ch1); 
               ch1.setText("0");
                ch1.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != '\b')) {
                    evt.consume();  
               }
            }
        });
              
        l5 = new JLabel("In time");
        l5.setBounds(40,210 , 100, 30);
         p.add(l5);
         
        l5.setForeground(new Color(150, 40, 50));
        tf1=new JTextField();
        tf1.setBounds(190,210, 200, 30);
        p.add(tf1);
     
          if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Sonipat")
               tf1.setText(t1);
       if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Rohtak")
                tf1.setText(t2);
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Sonipat")
              tf1.setText(t3);
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Rohtak")
            tf1.setText(t4);
        tf1.setEditable(false);
        l6 = new JLabel("Out time");
        l6.setBounds(40, 260, 100, 30);
        p.add(l6);
         tf2=new JTextField();
        tf2.setBounds(190,260, 200, 30);
        p.add(tf2);
        
         if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Sonipat")
             tf2.setText(t5);
         if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Rohtak")
           tf2.setText(t6);      
        if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Sonipat")  
                tf2.setText(t7);
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Rohtak")
            tf2.setText(t8);
      tf2.setEditable(false);
               
      lpnr = new JLabel("Train no.");
      lpnr.setBounds(40, 310, 100, 30);
      p.add(lpnr);
      tpnr = new JTextField();
      tpnr.setBounds(190, 310, 200, 30);
      p.add(tpnr);
      
       if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Sonipat")
               tpnr.setText(pnr1);
       if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Rohtak")
                tpnr.setText(pnr2);
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Sonipat")
              tpnr.setText(pnr3);
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Rohtak")
            tpnr.setText(pnr4);
               tpnr.setEditable(false);
         TrainNo = tpnr.getText().toString();
        b2 = new JButton("Proceed to pay");
        b2.setBounds(50, 370, 150, 30);
        p.add(b2); 
        b = new JButton("Reset");
        b.setBounds(220, 370, 100, 30);
        p.add(b);
        
        b2.addActionListener(new ActionListener() { 
                    @Override
                public void actionPerformed(ActionEvent e) {
                String male1 = m1.getText().toString();
                String female1 = f1.getText().toString();
                String child1 = ch1.getText().toString();
                int male2 = Integer.parseInt(male1);
                int female2 = Integer.parseInt(female1);
                int child2 = Integer.parseInt(child1);
                total=male2+female2+child2; 
           
            if(male2==0&&female2==0&&child2==0)
            {
                    JOptionPane.showMessageDialog(null, "Enter Valid Seats","Error",JOptionPane.ERROR_MESSAGE);
                 
            }
            else{
                
           if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Sonipat")
           {
            if(c2.getSelectedItem()=="Sitting")
            {
               finalP = total*cs1; 
               str = ""+finalP;
            }
            else
            {
               finalP = total*cs;
                str = ""+finalP;
            }
        }
        
       if(c.getSelectedItem()=="Chandigarh"&&c1.getSelectedItem()=="Rohtak")
        {
            if(c2.getSelectedItem()=="Sitting")
            {
               finalP = total*cr1;
               str = ""+finalP;
           }
            else
            {
               finalP = total*cr;
               str = ""+finalP;
            }
        }
       
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Sonipat")
        {
            if(c2.getSelectedItem()=="Sitting")
            {
               finalP = total*ds1; 
                str = ""+finalP; 
         }
            else
            {
               finalP = total*ds; 
                 str = ""+finalP;
            }
        }
       
       if(c.getSelectedItem()=="Delhi"&&c1.getSelectedItem()=="Rohtak")
        {
            if(c2.getSelectedItem()=="Sitting")
            {
               finalP = total*dr1;  
                 str = ""+finalP;
          }
            else
            {
              finalP = total*dr;
                 str = ""+finalP; 
            }
        }
         
        start =    (String) c.getSelectedItem();
        end =      (String) c1.getSelectedItem();
        type =     (String) c2.getSelectedItem(); 
        in = tf1.getText().toString();
        out = tf2.getText().toString(); 
        pnr = tpnr.getText().toString();  

       SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
           date =df.format(d.getDate())+""; 
            System.out.println(date);
                  try{  
                     Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                      Statement stmt = con.createStatement();
                     String str1 = "select tno  , date , seats from valid";
                  ResultSet rs=stmt.executeQuery( str1);
                  int flag=0;   
               while(rs.next())  
                     {
                         tno1 = rs.getString("tno");
                         date1 = rs.getString("date");
                        if(tno1.equals(pnr)&&date1.equals(date))      
                        {
                           String seat = rs.getString("seats").toString();
                            st = Integer.parseInt(seat);
                          flag =1; 
                          if(st==0)
                          {
                              JOptionPane.showMessageDialog(null, "This Train is Full","Error",JOptionPane.ERROR_MESSAGE);
                             reserve r = new reserve();
                              setVisible(false);
                              r.register3();
                          }
                       else if(st>=(int)total)   
                          {
                              decide = 1;
                              st = st - (int)total; 
                              
                                 payment p = new payment();  
                                setVisible(false);
                             p.payment1();
                          }
                        else  
                          {
                              JOptionPane.showMessageDialog(null, "Not Enough Seats , Enter Less No of Seats", "Error", JOptionPane.ERROR_MESSAGE);   
                          }     
                        }
                    }
            if(flag==0) 
            {
                  int x;
                  if((int)total>100)
                  {
                      JOptionPane.showMessageDialog(null, "Not Enough Seats", "Error", JOptionPane.ERROR_MESSAGE);
                  } 
                 else
                  {   
                  decide = 2;
                  st = 100-(int)total;
                 payment p = new payment();
                 setVisible(false);
                 p.payment1();
                  }
            } 
                } catch (ClassNotFoundException ex) {
                    System.out.println("ex");

                } catch (SQLException o) {
                    System.out.println(o);
                }
       
                 
             }           
           
                }
                });
        b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      reserve v = new reserve();
                        setVisible(false);
                        v.register3(); 
                   }
                });  
             }
            }
            }
        }); 
        
         
       }
                          
        public static void main(String[]args){
            reserve f1=new reserve(); 
            f1.register3();
            
        }
        

    
}
