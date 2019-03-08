package Railway;

import static Railway.login.password;
import static Railway.login.username;
import com.sun.glass.events.KeyEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;

import static java.awt.image.ImageObserver.ERROR;
import java.sql.*;

import java.util.logging.*;

import javafx.scene.control.IndexRangeBuilder;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Registeration extends JFrame {

    JLabel lp, l, l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf, tf1, tf2, tf3, tf4;  
    JButton b1, b2;
    JRadioButton r1, r2;
    JTextArea a1;
    JComboBox c;
    JPasswordField pf, pf1;
    JCheckBox cb1, cb2, cb3;
    ButtonGroup bg;
    ImageIcon icon;
    public static String name , address , phone , email;
    public void register2() {
        setTitle("Registration form");
        setVisible(true);
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());
        // setFont(new Font(null, Font.BOLD, 24));
        JLabel lp = new JLabel(new ImageIcon("E:\\5.jpg")); 
        add(lp);

        l = new JLabel("REGISTER HERE");
        l.setBounds(300, 5, 350, 35); 
        lp.add(l);   
        l.setFont(new Font(null, Font.BOLD, 40));
        l1 = new JLabel("USERNAME:");
        l1.setBounds(150, 70, 150, 60);
        l1.setFont(new Font(null, Font.BOLD, 24));
        lp.add(l1);
        l1.setForeground(new ColorUIResource(Color.white)); 
        tf = new JTextField();
        tf.setBounds(350, 90, 200, 30);
        lp.add(tf);
        l2 = new JLabel("PASSWORD:");
        l2.setBounds(150, 120, 150, 60);
        l2.setFont(new Font(null, Font.BOLD, 24));
        lp.add(l2);
        l2.setForeground(new ColorUIResource(Color.white));
        pf = new JPasswordField();
        pf.setBounds(350, 140, 200, 30);
        lp.add(pf); 
        l3 = new JLabel("NAME");
        l3.setBounds(150, 190, 200, 30);
        l3.setFont(new Font(null, Font.BOLD, 24));
        lp.add(l3);
        l3.setForeground(new ColorUIResource(Color.white));
        tf1 = new JTextField();
        tf1.setBounds(350, 190, 200, 30);
        lp.add(tf1);

        l4 = new JLabel("ADDRESS");
        l4.setBounds(150, 240, 200, 30);
        l4.setFont(new Font(null, Font.BOLD, 24));
        lp.add(l4);
        l4.setForeground(new ColorUIResource(Color.white ));
        a1 = new JTextArea();
        a1.setBounds(350, 240, 200, 60);
        lp.add(a1);
        l5 = new JLabel("PHONE NO.");
        l5.setBounds(150, 340, 200, 30);
        l5.setFont(new Font(null, Font.BOLD, 24));
        lp.add(l5);
        l5.setForeground(new ColorUIResource(Color.white));
        tf2 = new JTextField();
        tf2.setBounds(350, 335, 200, 30);
        lp.add(tf2);
        tf2.setDocument(new limit_J(10));
         
          tf2.addKeyListener(new KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char caracter = evt.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) 
                        && (caracter != '\b')) {
                    evt.consume();  
               }
            }
        });

        l6 = new JLabel("EMAIL ADDRESS:");
        l6.setBounds(150, 400, 220, 30);
        l6.setFont(new Font(null, Font.BOLD, 24));
        lp.add(l6);
        l6.setForeground(new ColorUIResource(Color.WHITE));

        tf3 = new JTextField();
        tf3.setBounds(370, 400, 300, 30);
        lp.add(tf3);
   
        b1 = new JButton("Submit");
        b1.setBounds(250, 450, 130, 40);
        b1.setFont(new Font(null, Font.BOLD, 24));
        lp.add(b1);

        b1.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) { 
                username = (String) tf.getText();
                System.out.println("USERNAME: " + username);
                password = pf.getText();
                System.out.println("PASSWORD: " + password);
                 name = tf1.getText();
                System.out.println("NAME: " + name); 
                 address = (String) a1.getText();
                System.out.println("ADDRESS: " + address);
                 phone = (String) tf2.getText();
                System.out.println("PHONE NO.: " + phone);
                 email = tf3.getText();
                System.out.println("EMAIL: " + email);
                
               // int n = Integer.parseInt(phone);
           if(username.equals("")||password.equals("")|address.equals("")||email.equals("")||name.equals(""))
                {
                 JOptionPane.showMessageDialog(null,"All Fields Are Mendatory","Error",JOptionPane.ERROR_MESSAGE );              
                } 
           else
           {
             try {  
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                      Statement stmt = con.createStatement();
                   String str2 = "select * from login where username='"+username+"' ";
                   ResultSet rs=stmt.executeQuery(str2);   
            if(rs.next())  
            {
               JOptionPane.showMessageDialog(null, "Username is already taken","Error",JOptionPane.ERROR_MESSAGE);
               
            }
      else 
       {
         int result = JOptionPane.showConfirmDialog(null, "Press ok to confirm","Confirm", 2);
            if (result == JOptionPane.OK_OPTION) 
            {        
              String str = "insert into login (username,password,name,address,email,phone)values(?,?,?,?,?,?)";   
                   
                     PreparedStatement ps = con.prepareStatement(str);
                     String str1 = "insert into ticket(username) values(?)";
                   PreparedStatement ps1 = con.prepareStatement(str1);
                   ps1.setString(1, username);
                    int j = ps1.executeUpdate();
                     
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, name); 
                    ps.setString(4,address);
                    ps.setString(5 , email);
                    ps.setString(6 , phone);
                  // ps1.setString(2, phone);
                   
                    int i = ps.executeUpdate();
                    if (i > 0) {
                        System.out.println("inserted");
                    } else {
                        System.out.println("not inserted"); 
                    }
                  login l = new login();
            setVisible(false);
            l.login();      
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

        b2 = new JButton("Reset");
        b2.setBounds(460, 450, 130, 40);
        b2.setFont(new Font(null, Font.BOLD, 24));
        lp.add(b2);
        b2.addActionListener(new ActionListener() { 

            @Override
            public void actionPerformed(ActionEvent h) {
                Registeration r1 = new Registeration();
                setVisible(false);
                r1.register2();
            }
        });

    } 
 
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 Registeration r = new Registeration();
        r.register2(); 
               
            }
        });
       

    }
}
