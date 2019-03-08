package Railway;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Statement; 
import javax.swing.*;
import static Railway.Registeration.*;
import static Railway.TrainDetails.t1; 
import static Railway.TrainDetails.t2;
import static Railway.TrainDetails.t3;
import static Railway.TrainDetails.t4;
import static Railway.login.username;
import static Railway.reserve.end;
import static Railway.reserve.in;
import static Railway.reserve.out;
import static Railway.reserve.start;
import static Railway.reserve.str;
import static Railway.reserve.total;
import static Railway.reserve.type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    class activity extends JFrame{ 
    JLabel l1,l2,l3,p1,p2,p3,p4;
    JButton b1,b2,b3,b4,b5;
    JMenuBar j;
    JMenu m; 
    JMenuItem i1,i2,i3,i4;
    Panel p;
    JPanel o;
    ResultSet rs;
    public static String s;
    public void register4() { 
        setTitle("RAILWAYS RESERVATION");
        setVisible(true);
        setSize(700, 800);
       getContentPane().setBackground(Color.LIGHT_GRAY);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); 
     l2 = new JLabel("Welcome Sir/Mam ,");
       l2.setBounds(20, 30, 200 , 30);
      l2.setFont(new Font(null, Font.BOLD, 20)); 
        add(l2); 
//       l3 = new JLabel("name");
//       l3.setBounds(110, 30, 150, 30); 
//       add(l3);
o=new JPanel();
o.setBounds(125, 100, 450, 500);
                o.setBackground(Color.white);
                add(o);
                
                o.setLayout(null);
                 

        
         b1 = new JButton("Reserve Ticket");
        b1.setBounds(85, 80, 300, 40);
       b1.setFont(new Font(null, Font.BOLD, 24));

       o. add(b1);
        b1.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e) {
                reserve f1=new reserve();
                setVisible(false);
                f1.register3();
//To change body of generated methods, choose Tools | Templates.
            } 
        });
        b2 = new JButton("Cancel Reservation");
        b2.setBounds(85, 140, 300, 40);
                b2.setFont(new Font(null, Font.BOLD, 24));

        o.add(b2);
          b2.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
               
              int r = JOptionPane.showConfirmDialog(null, "Sure to cancel","Confirm", 2);
           if(r==JOptionPane.OK_OPTION)
             {   
              try { 
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                     String str3 = "update login set price = ?  ,total=? , pnr = ? ,source = ?,destination =?,intime=?,outtime=? ,tickettype=? where username=?";   
                     PreparedStatement ps = con.prepareStatement(str3);
                     ps.setString(1, null);
                     ps.setString(2, null);
                      ps.setString(3,null);
                      ps.setString(4,null);
                      ps.setString(5,null);
                      ps.setString(6,null);
                      ps.setString(7,null);
                      ps.setString(8,null);
                     
                     ps.setString(9, username);
                    int i = ps.executeUpdate();
                    if (i > 0) {
                        System.out.println("inserted");
                    } else {
                        System.out.println("not inserted"); 
                    } 
                } catch (ClassNotFoundException ex) {
                    System.out.println("ex");

                } catch (SQLException o) {
                    System.out.println(o);
                }
                
        
      } 
     }
     });
        b3 = new JButton("Train Detail");  
        b3.setBounds(85, 200, 300, 40);
        b3.setFont(new Font(null, Font.BOLD, 24));

        o.add(b3);
         
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
            TrainDetails t = new TrainDetails();
                setVisible(false);
                t.Tdetails();
           
         }
        });
        
        b5 = new JButton("Show Ticket Status");
        b5.setBounds(85, 260, 300  , 40);
        b5.setFont(new Font(null, Font.BOLD, 24));

       o. add(b5);
        
        b5.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
             
               try { 
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                      Statement stmt = con.createStatement();
                   String str1 = "select * from login where username='"+username+"' ";
                 rs=stmt.executeQuery(str1);
              if(rs.next())   
            {
               s = rs.getString("source");
            }
           }  catch (ClassNotFoundException ex) {
                    System.out.println("ex");

                }   catch (SQLException o) {
                    System.out.println(o);
                }               
                
                
               if(s==null)
               {
                   JOptionPane.showMessageDialog(null, "Book YOur Ticket First","Error",JOptionPane.ERROR_MESSAGE);
                   activity t=new activity();
                setVisible(false); 
               t.register4();
                          
               }   
                   
                else
               {   
                 TicketDetails t = new TicketDetails();
                   setVisible(false);
                 t.details();
               }          
               }
        });
        
        b4 = new JButton("Sign Out");
        b4.setBounds(85, 320, 300, 40);
        b4.setFont(new Font(null, Font.BOLD, 24));

        o.add(b4);
         
        
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Sure to Sign Out","Confirm",2);
        if (result == JOptionPane.OK_OPTION) {
            login l = new login(); 
            setVisible(false);
            l.login();
      }  
     } 
     });
       }
    public static void main(String[] args) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    activity a=new activity();
        a.register4();
                }
                    
            });
        
    }}
