
package Railway;
import javax.swing.*;
import java.awt.*;  
import java.awt.event.*;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;

class login extends JFrame {
 
   public static String username;
   public static String password; 
   
    static int SCALE_DEFAULT; 

    JLabel l1, r1, u, p;
    JPasswordField pf;
    JTextField tf1;
    JButton b1, b2, b3;
   JOptionPane op;

    public void login() {
        setTitle("railway reservation system");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new FlowLayout());
        JLabel b = new JLabel(new ImageIcon("E:\\rl.jpg"));
        add(b);
        
        b.setLayout(null);
        //JPanel jp=new JPanel();
        JLabel jl=new JLabel();
       ImageIcon io= new ImageIcon("E:\\gr.jpg");
        
   ImageIcon img=new ImageIcon(io.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
	jl.setIcon(img);
        jl.setBounds(450, 10, 100, 100);
	b.add(jl);
      
       JLabel l = new JLabel("GOLD RUSH");
        l.setFont(new Font("Cooper Black", 30, 30));
        l.setForeground(Color.BLACK);
        l.setBounds(400, 25, 200, 200);
        b.add(l);
        
        l1 = new JLabel("RAILWAY RESERVATION SYSTEM");
        l1.setFont(new Font("Cooper Black", 50, 45));
        l1.setForeground(Color.BLACK);
        l1.setBounds(80, 30, 1200, 300);
        b.add(l1);
        r1 = new JLabel("MEMBER LOGIN");
        r1.setFont(new Font("Britannic Bold", 50, 30));
        r1.setForeground(Color.BLACK);
      
        r1.setBounds(150, 120, 600, 250); 
        b.add(r1);

        u = new JLabel("USER NAME");
        u.setFont(new Font("Britannic Bold", 50, 20));
        u.setForeground(Color.WHITE);

        u.setBounds(50, 200, 400, 200);
        b.add(u);
        tf1 = new JTextField();
        tf1.setBounds(250, 290, 250, 25);
        b.add(tf1);
        p = new JLabel("PASSWORD");
        p.setFont(new Font("Britannic Bold", 50, 20));
        p.setForeground(Color.WHITE);

        p.setBounds(50, 250, 400, 200);
        b.add(p);
        pf = new JPasswordField(); 
        pf.setBounds(250, 340, 250, 25);  
        b.add(pf);

        b1 = new JButton("LOGIN");
        b1.setBounds(100, 400, 100, 30);
         b1.setForeground(Color.red); 
           b1.setFont(new Font("Britannic Bold", 50, 20));
        b.add(b1);
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String u1 = (String) tf1.getText();  
                username = u1;
                String p1 = pf.getText();
                password = p1;  
               if(u1.equals("")||p1.equals(""))
               {
                   JOptionPane.showMessageDialog(null, "empty username or password","heading",JOptionPane.QUESTION_MESSAGE);
               }  
             else
               {   
                 
                 try { 
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                  Statement stmt = con.createStatement();
                     String str1 = "select * from login where username='"+u1+"' and password='"+p1+"'";
                  ResultSet rs=stmt.executeQuery( str1);    
                   if(rs.next())      
                     {     
                          activity t=new activity();
                            setVisible(false); 
                            t.register4(); 
                      } 
                else
                    {
                        JOptionPane.showMessageDialog(null, "The username and passwrd is incorrect","heading",JOptionPane.ERROR_MESSAGE);
                     }
                 

                } catch (ClassNotFoundException ex) {
                    System.out.println("ex");
  
                } catch (SQLException o) {
                    System.out.println(o);   
                }
            } 
            }
        });
        
      

        b2 = new JButton("RESET");
        b2.setBounds(300, 400, 100, 30);
          b2.setForeground(Color.BLACK);
            b2.setFont(new Font("Britannic Bold", 50, 20));
        b.add(b2);
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) { 
               login r = new login();
                setVisible(false); 
               r.login();
            }
        });  

//action event close 
        b3 = new JButton("REGISTER HERE");  
        b3.setBounds(150, 470, 200, 30);
          b3.setForeground(Color.BLACK);
            b3.setFont(new Font("Britannic Bold", 40, 20));
        b.add(b3); 
        b3.addActionListener(new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent e) {
                Registeration r = new Registeration();
                setVisible(false);
                r.register2();

            }

        });

    }                   //registration fn close

    public static void main(String args[]) {
        login i = new login();
        i.login();
    }
}

