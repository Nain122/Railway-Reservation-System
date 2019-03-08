package Railway;
 
import static Railway.login.username;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TrainDetails extends JFrame{ 
    
     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
     JTextField j1,j2,j3,j4,j5,j6,j9;
     ResultSet rs,rs1;       
     JCalendar calender; 
    JDateChooser dt;
    public static String t1,t2,t3,t4,t5;  
    JButton b1,b2,b3,b4;
    Panel p;
    
    public void Tdetails()
    {
        setTitle("Train Details");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(null); 
        getContentPane().setBackground(Color.lightGray);
         ImageIcon ic = new ImageIcon("E:\\3.jpg");
        setLayout(new BorderLayout());
        JLabel j = new JLabel(new ImageIcon());
        j.setIcon(ic);
        j.setBounds(500, -20, 850, 800);
        ImageIcon img = new ImageIcon(ic.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT));
        j.setIcon(img);
        add(j);
        l1 = new JLabel("Train Details");
        l1.setFont(new Font("Cooper Black", Font.BOLD, 30));
        l1.setBounds(500, 10, 600, 50);
        add(l1);
        JPanel P=new JPanel();
         P.setBounds(120, 60, 450, 150);
                P.setBackground(Color.white);
                add(P);
                
                P.setLayout(null);
                 P.setBackground(Color.LIGHT_GRAY);
        l2 = new JLabel("Train no.");
        l2.setBounds(80, 70, 100, 30); 
         l2.setFont(new Font(null, Font.BOLD, 20));
       P. add(l2);
        j1 = new JTextField();
        j1.setBounds(180, 70, 200, 30);
       P. add(j1);  
        j1.setDocument(new limit_J(5));
        
        
         l8 = new JLabel("Date");
         l8.setBounds(80, 130, 100, 30);
         P.add(l8);
         l8.setFont(new Font(null, Font.BOLD, 20)); 
         dt = new JDateChooser();
         dt.setBounds(180, 130, 200, 30);
         P.add(dt);
        b1 = new JButton("Submit");
        b1.setBounds(130, 190, 100, 30);
         b1.setFont(new Font(null, Font.BOLD, 15));
        P.add(b1);
        b2 = new JButton("Cancel");  
        b2.setBounds(250, 190, 100, 30);
         b2.setFont(new Font(null, Font.BOLD, 15));
       P. add(b2);
                
       b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               activity a = new activity();
                setVisible(false);
                a.register4();
            }
        });
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try { 
               SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
               String s1 = df.format(dt.getDate())+"";
               String str = j1.getText().toString();
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "nainji123");
                      Statement stmt = con.createStatement();
                   String str1 = "select * from train where num = '"+str+"' "; 
                  rs=stmt.executeQuery(str1);
            if(rs.next())   
            { 
               t1 = rs.getString("src");
               t2 = rs.getString("des");
               t3 = rs.getString("Tin"); 
               t4 = rs.getString("Tout");
                  String str2 = "select seats from valid where tno = '"+str+"' and date = '"+s1+"'";
                 rs1 = stmt.executeQuery(str2); 
              if(rs1.next())  
                  t5 =rs1.getString("seats");
              else
                  t5 = "100";
              
                p=new Panel(); 
                p.setBounds(70, 250, 410, 450);
                p.setBackground(Color.WHITE);
                add(p); 
               p.setLayout(null);
               l2 = new JLabel("Source");
               l2.setBounds(40, 60, 150, 30); 
                l2.setFont(new Font(null, Font.BOLD, 20));
               p.add(l2); 
               j2  = new JTextField();   
               j2.setBounds(190, 60, 200, 30);
               p.add(j2);
               j2.setText(t1);
               j2.setEditable(false); 
               
               l3 = new JLabel("Destination");
               l3.setBounds(40, 110, 150, 30);
               l3.setFont(new Font(null, Font.BOLD, 20));
               p.add(l3); 
               j3  = new JTextField();
               j3.setBounds(190, 110, 200, 30);
               p.add(j3);
               j3.setText(t2);
               j3.setEditable(false);
               
               l4 = new JLabel("In time");
               l4.setBounds(40, 160, 150, 30);
               l4.setFont(new Font(null, Font.BOLD, 20));
               p.add(l4); 
               j4  = new JTextField();
               j4.setBounds(190, 160, 200, 30);
               p.add(j4);
               j4.setText(t3);
              j4.setEditable(false);
               
        l5 = new JLabel("Out time");
        l5.setBounds(40,210 , 100, 30);
        l5.setFont(new Font(null, Font.BOLD, 20));
         p.add(l5);
        j5 = new JTextField();  
        j5.setBounds(190, 210, 200, 30);   
        p.add(j5);
        j5.setText(t4); 
        j5.setEditable(false);  
        
         l9 = new JLabel("Seats "); 
        l9.setBounds(40,260 , 100, 30);
        l9.setFont(new Font(null, Font.BOLD, 20));
         p.add(l9);
        j9 = new JTextField(); 
        j9.setBounds(190, 260, 200, 30);  
        p.add(j9);
        j9.setText(t5);
        j9.setEditable(false);  
        
        b3 = new JButton("Book Now");
        b3.setBounds(90, 310, 110, 30);
        b3.setFont(new Font(null, Font.BOLD, 15));
        p.add(b3);
        
        b4 = new JButton("Back");
        b4.setBounds(230, 310, 110, 30); 
        b4.setFont(new Font(null, Font.BOLD, 15));
        p.add(b4);
    
        b3.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                   reserve r = new reserve();
                       setVisible(false);
                       r.register3();
                   }
               });
        
        b4.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                     activity v = new activity();
                       setVisible(false);
                       v.register4();
                   
                   }
               });  
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "Invalid Train No.","Error",JOptionPane.ERROR_MESSAGE);
                
             } 
        }  
      catch (ClassNotFoundException ex) 
         {
           System.out.println("ex");       
         }   
       catch (SQLException o) 
         {
           System.out.println(o);
        }        
      }
        });  
    }
       public static void main(String[] args) { 
           java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                   TrainDetails a = new TrainDetails();
        a.Tdetails();
           
               }
           }
           );
        
    }
}