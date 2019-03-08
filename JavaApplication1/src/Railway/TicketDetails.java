/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Railway;

import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField; 
import static Railway.reserve.*;
import static Railway.Registeration.*;
import static Railway.login.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Pankaj
 */
public class TicketDetails extends JFrame { 
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12; 
    JTextField j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11,j12;
    ResultSet rs,rs1;
    String s,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11;
    JButton b;
   public void details()
    {
        setTitle("Ticket Details");
        setVisible(true);
        setSize(800, 800); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(null); 
               getContentPane().setBackground(new Color(216,191,216));

          try { 
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                      Statement stmt = con.createStatement();
                   String str1 = "select * from login where username='"+username+"' ";
                   String str2 = "select * from Ticket where username='"+username+"'";
                rs=stmt.executeQuery(str1);
//               
            if(rs.next())   
            {
               s = rs.getString("name");
               s1  = rs.getString("address");
               s2 = rs.getString("email");
               s3 = rs.getString("phone"); 
               s4 = rs.getString("source");
               s5 = rs.getString("destination");
               s6 = rs.getString("tickettype");
               s7 = rs.getString("pnr");
               s9 = rs.getString("total"); 
               s10 = rs.getString("price");
               s11 = rs.getString("date");
            }
              rs1=stmt.executeQuery(str2);
          if(rs1.next())
          {
              s8 = rs1.getString("tno");
          }
        }  catch (ClassNotFoundException ex) {
                    System.out.println("ex");

                }   catch (SQLException o) {
                    System.out.println(o);
                }
         
        l = new JLabel("Ticket Details");
        l.setFont(new Font(null, Font.BOLD, 24));
        l.setBounds(300, 20, 200, 50);
        add(l);
        
        l1 = new JLabel("Name");
        l1.setBounds(100, 90, 100, 30);
        add(l1);
        j1 = new JTextField();
        j1.setBounds(220, 90, 200, 30);
        add(j1);
        j1.setText(s);
        j1.setEditable(false); 
       
        l2 = new JLabel("Address");
        l2.setBounds(100, 140, 100, 30);
        add(l2);
        j2 = new JTextField(); 
        j2.setBounds(220, 140, 200, 30);
        add(j2);
        j2.setText(s1);
        j2.setEditable(false); 

        
        l3 = new JLabel("Phone No.");
        l3.setBounds(100, 190, 100, 30);
        add(l3); 
        j3 = new JTextField();
        j3.setBounds(220, 190, 200, 30);
        add(j3);
        j3.setText(s3);
        j3.setEditable(false);
        
        l4 = new JLabel("Email");
        l4.setBounds(100, 240, 100, 30);
        add(l4);
        j4 = new JTextField();
        j4.setBounds(220, 240, 200, 30);
        add(j4);
        j4.setText(s2);
        j4.setEditable(false); 
        
        l5 = new JLabel("From");
        l5.setBounds(100, 290, 100, 30);
        add(l5);
        j5 = new JTextField();
        j5.setBounds(220, 290, 200, 30);
        add(j5);
        j5.setText(s4);
        j5.setEditable(false); 
        
        l6 = new JLabel("To");
        l6.setBounds(100, 340, 100, 30);
        add(l6);
        j6 = new JTextField();
        j6.setBounds(220, 340, 200, 30);
        add(j6);
        j6.setText(s5);
        j6.setEditable(false); 
        
        l7 = new JLabel("Types of Tickets");
        l7.setBounds(100, 390, 200, 30);
        add(l7);
        j7 = new JTextField();
        j7.setBounds(220, 390, 200, 30);
        add(j7);
        j7.setText(s6);
        j7.setEditable(false); 
     
        l8 = new JLabel("Train No.");
        l8.setBounds(500, 90, 100, 30);
        add(l8);
        j8 = new JTextField();
        j8.setBounds(590, 90, 200, 30);
        add(j8);
        j8.setText(s7);
        j8.setEditable(false); 
         
        l9 = new JLabel("Ticket ID");
        l9.setBounds(500, 140, 100, 30); 
        add(l9);
        j9 = new JTextField();
        j9.setBounds(590, 140, 200, 30);
        add(j9);
        j9.setText(s8);   
        j9.setEditable(false);  
        
        l10 = new JLabel("Total Tickets");
        l10.setBounds(500, 190, 100, 30); 
        add(l10);
        j10 = new JTextField();
        j10.setBounds(590, 190, 200, 30);
        add(j10);
        j10.setText(s9);   
        j10.setEditable(false); 
     
      l11 = new JLabel("Price");
        l11.setBounds(500, 240, 100, 30); 
        add(l11);
        j11 = new JTextField();
        j11.setBounds(590, 240, 200, 30);
        add(j11);
        j11.setText(s10);   
        j11.setEditable(false); 

         l12 = new JLabel("Date");
        l12.setBounds(500, 290, 100, 30); 
        add(l12);
        j12 = new JTextField();
        j12.setBounds(590, 290, 200, 30);
        add(j12);
        j12.setText(s11);
        j12.setEditable(false); 
        
        b = new JButton("Close");
       b.setBounds(290, 460, 150, 30);
       add(b);
    b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int r = JOptionPane.showConfirmDialog(null, "Press Ok to exit","Confirm",2); 
             if(r==JOptionPane.OK_OPTION) 
             {
               activity a = new activity();
                setVisible(false);
                a.register4();
            }
           } 
        });
    
    }
    
    public static void main(String[] args) {
        TicketDetails d = new TicketDetails(); 
        d.details();
    }
}
