/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Railway;

import static Railway.login.username;
import static Railway.reserve.date;
import static Railway.reserve.date1;
import static Railway.reserve.decide;
import static Railway.reserve.end;
import static Railway.reserve.in;
import static Railway.reserve.out;
import static Railway.reserve.pnr;
import static Railway.reserve.st;
import static Railway.reserve.start;
import static Railway.reserve.str;
import static Railway.reserve.tno1;
import static Railway.reserve.total;
import static Railway.reserve.type;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.sql.*;
import javax.swing.*;

public class payment extends JFrame {

    JLabel l1, l2, l3, l4, l5,l7;
    JComboBox c, c1, c2, c3; 
    JTextField t1, t2, t3,tf3; 
    JPasswordField p1, p2;
    JButton b1, b2;
    public static int y=0;
  
    public void payment1() {

        

       // setLayout(null);
        setTitle("Payment method");
        setVisible(true);
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // setLayout(null);
 setLayout(new FlowLayout()); 
        //getContentPane().setBackground(Color.BLUE);
        JLabel j = new JLabel(new ImageIcon("E:\\8.jpg"));
       //j.setBounds(700, 20, 500, 500);
       add(j);
     // j.setLayout(null);
        l1 = new JLabel("PAYMENT DETAILS");
        l1.setBounds(550, 19, 500, 55);
       j. add(l1);
        l1.setFont(new Font("Cooper Black", Font.BOLD, 40));
        l1.setForeground(Color.black);
        
        //JPanel P=new JPanel(new FlowLayout());
        //P.setBounds(80,70,400,600);
        //P.setBackground(Color.WHITE);
       // P.setLayout(null);
       //P.setVisible(true);
        //j.add(P);
        l2 = new JLabel("Card Type");
        l2.setBounds(400, 110, 200, 35);
                l2.setFont(new Font("Cooper Black", Font.BOLD, 20));

        l2.setForeground(Color.black);
       // P.setLayout(null);
        j.add(l2);
        //  l2.setFont(new Font(null, Font.PLAIN, 16));
        c = new JComboBox();
        c.setBounds(620, 110, 200, 35);
        c.addItem("select type");
        c.addItem("Visa");
        c.addItem("Rupay");
        c.addItem("Master card");
        c.addItem("maestro card");
       j. add(c);
       
        l3 = new JLabel("Card Number");
        l3.setBounds(400, 160, 200, 35);
         l3.setForeground(Color.black);
          l3.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(l3);
        
        t1 = new JTextField();
        t1.setBounds(620, 160, 200, 35);
       j. add(t1);
        t1.setDocument(new limit_J(16));
         t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != '\b')) {
                    evt.consume();  
               }
            }
        });
        
        l4 = new JLabel("Card holder name");
        l4.setBounds(400, 210, 400, 35);
         l4.setForeground(Color.black);
          l4.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(l4);
        t2 = new JTextField();
        t2.setBounds(620, 210, 200, 35);
        j.add(t2);
        l5 = new JLabel("CVV");
        l5.setBounds(400, 310, 100, 35);
         l5.setForeground(Color.black);
          l5.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(l5);
        p1 = new JPasswordField();
        p1.setBounds(620, 310, 60, 35);
       j. add(p1);
        p1.setDocument(new limit_J(3));
         p1.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != '\b')) {
                    evt.consume();  
               }
            }
        });
        
        l5 = new JLabel("Expiry date");
        l5.setBounds(400, 260, 200, 35);
         l5.setForeground(Color.black);
          l5.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(l5);
        c1 = new JComboBox();
        c1.setBounds(620, 260, 90, 35);
        c1.addItem("Month");
        c1.addItem("1");
        c1.addItem("2");
        c1.addItem("3");
        c1.addItem("4");
        c1.addItem("5");
        c1.addItem("6");
        c1.addItem("7");
        c1.addItem("8");
        c1.addItem("9");
        c1.addItem("10");
        c1.addItem("11");
        c1.addItem("12");
        
       j. add(c1);
        c2 = new JComboBox();
        c2.setBounds(780, 260, 90, 35);
        c2.addItem("Year");
        c2.addItem("2019");
        c2.addItem("2020");
        c2.addItem("2021");
        c2.addItem("2022");
        c2.addItem("2023");
        c2.addItem("2024");
        c2.addItem("2025");
        c2.addItem("2026"); 
        c2.addItem("2027");
        c2.addItem("2028");
        
        j.add(c2);
        
           l7 = new JLabel("Price");
        l7.setBounds(400, 360, 200, 35);
         l7.setForeground(Color.black);
         
          l7.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(l7);
//        l7.setForeground(new Color(150, 40, 50)); 
           tf3 = new JTextField();
        tf3.setBounds(620, 360, 200, 35);
        j.add(tf3);
        tf3.setText(str);
        tf3.setEditable(false);

        b1 = new JButton("Pay Now");
        b1.setBounds(500, 410, 200, 35);
         b1.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardtype = (String) c.getSelectedItem();
                String cardno = t1.getText();
                String name = t2.getText();
                String month = (String) c1.getSelectedItem();
                String year = (String) c2.getSelectedItem();
                String cvv = p1.getText();
                
                if (cardtype.equals("select type") || cardno.equals("") || name.equals("") || month.equals("Month") || year.equals("Year") || cvv.equals("")) {
                    JOptionPane.showMessageDialog(null, "All fields are mandatory!","Error",JOptionPane.ERROR_MESSAGE);
//                    payment s1 = new payment();
//                    setVisible(false);  
//                    s1.payment1();
                }
                else{
                    int r=JOptionPane.showConfirmDialog(null, "Press Ok to Confirm","Error", 2);
                    if(r==JOptionPane.OK_OPTION)
                    {
                        
                         try {   
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                    String str3 = "update login set price = ?  ,total=? , pnr = ? ,source = ?,destination =?,intime=?,outtime=? ,tickettype=? ,date = ? where username=?";   
                   
                    if(decide==1)
                        {
                            String str5 = "update valid set seats = ? where tno = ? and date=?";
                                PreparedStatement ps1 = con.prepareStatement(str5); 
                                  ps1.setString(1, st+"");
                                  ps1.setString(2, tno1);
                                  ps1.setString(3, date1); 
                                 ps1.executeUpdate(); 
                        }
                        if(decide==2)
                        {
                            String str6 = "insert into valid values(?,?,?)";
                           PreparedStatement ps1 = con.prepareStatement(str6); 
                            ps1.setString(1,pnr );
                              ps1.setString(2, date);
                           ps1.setString(3, st+"");
                              ps1.executeUpdate();
                        }   

                    PreparedStatement ps = con.prepareStatement(str3); 
                    String s1= total+"";
                     ps.setString(1, str); 
                     ps.setString(2, s1); 
                      ps.setString(3,pnr); 
                      ps.setString(4,start);
                      ps.setString(5,end); 
                      ps.setString(6,in); 
                      ps.setString(7,out);  
                      ps.setString(8,type);  
                      ps.setString(9, date);
                     ps.setString(10, username);
                     System.out.println(str+"  "+s1+"  "+date);
                    int i = ps.executeUpdate();
            }  
            catch (ClassNotFoundException ex) {
                    System.out.println("ex");

                } catch (SQLException o) {
                    System.out.println(o);
                }
           
                        
                        
                        
                        
                        
                        
                        TicketDetails t = new TicketDetails();
                        setVisible(false);
                        t.details(); 
                    }
                } 
            }

        });
        b2 = new JButton("Cancel");
        b2.setBounds(750, 410, 200, 35); 
         b2.setFont(new Font("Cooper Black", Font.BOLD, 20));
        j.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int r=JOptionPane.showConfirmDialog(null, "Sure to Cancel","Confirm", 2);
               if(r==JOptionPane.OK_OPTION)
               {   
                activity a = new activity();
                setVisible(false);
                a.register4();//To change body of generated methods, choose Tools | Templates.
               } 
               }
        });
        //add(P);
    }

    public static void main(String[] args) {
        payment p = new payment();
        p.payment1();
    }
}

