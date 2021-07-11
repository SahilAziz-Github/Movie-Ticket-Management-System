import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener,MouseListener{

    private JPanel panel;
    private JLabel softwareNameLabel, usernameLabel, passwordLabel;
    private JTextField usernameTf;
    private JPasswordField passwordPf;
    private JButton loginBtn,btn, registerBtn,exitBtn;
    String usern=null;

    public LoginPage(){
        this.setTitle("Movie Tickets Booking System");
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        panel=new JPanel();
        panel.setSize(800, 700);
        this.add(panel);
        
        ImageIcon background_image = new ImageIcon(getClass().getResource("login_reg.jpg"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(800,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        
        JLabel imgLabel = new JLabel("", background_image, JLabel.CENTER);
        imgLabel.setBounds(0, 0, 800, 700);
        panel.add(imgLabel);

        softwareNameLabel=new JLabel("Movie Tickets Booking System");
        softwareNameLabel.setBounds(215, 100, 400, 60);
        softwareNameLabel.setForeground(Color.white);
        softwareNameLabel.setFont(new Font("times new roman", Font.PLAIN, 30));
        imgLabel.add(softwareNameLabel);

        usernameLabel=new JLabel("Username:");
        usernameLabel.setBounds(220, 220, 100, 30);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(usernameLabel);

        passwordLabel=new JLabel("Password:");
        passwordLabel.setBounds(220, 270, 100, 30);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(passwordLabel);

        usernameTf=new JTextField();
        usernameTf.setBounds(320, 220, 200, 30);
        imgLabel.add(usernameTf);

        passwordPf=new JPasswordField();
        passwordPf.setBounds(320, 270, 200, 30);
        imgLabel.add(passwordPf);
		
		btn = new JButton("Show Password");
		btn.setBounds(50, 350, 150,30);
		btn.addMouseListener(this);
		imgLabel.add(btn);

        loginBtn=new JButton("Login");
        loginBtn.setBounds(380, 340, 100, 30);
        loginBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        loginBtn.addActionListener(this);
        imgLabel.add(loginBtn);

        registerBtn=new JButton("Register New Account");
        registerBtn.setBounds(380, 400, 200, 30);
        registerBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        registerBtn.addActionListener(this);
        imgLabel.add(registerBtn);

        
        exitBtn=new JButton("Exit");
        exitBtn.setBounds(600, 550, 100, 30);
        exitBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        exitBtn.addActionListener(this);
        imgLabel.add(exitBtn);
        
        
        this.setVisible(true);




    }


    private void databaseTable(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try
        {
            String query="select password, role, username from people where username='"+usernameTf.getText()+"';";
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
            //System.out.println("Connection");
            statement=connection.createStatement();
            //System.out.println("Statement");
            resultSet=statement.executeQuery(query);
            //System.out.println("Results Found");
			
			
			
            if(resultSet.next())
            {
                String loginPassword=resultSet.getString("password");
                String statusRole=resultSet.getString("role");
                usern = resultSet.getString("username");
                if(loginPassword.equals(new String(passwordPf.getPassword())) && statusRole.equals("customer"))
                {
					System.out.println("from login page"+usern);
                    new UserDashboard(usern);
                    this.dispose();
                }
                else if(loginPassword.equals(new String(passwordPf.getPassword())) && statusRole.equals("manager"))
                {
                    new ManagerDashboard();
                    this.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Invalid password");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Invalid username");
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+ e.getMessage());
        }
        finally
        {
            try
            {
                if(connection!=null)
                {
                    connection.close();
                }
                if(statement!=null)
                {
                    statement.close();
                }
                if(resultSet!=null)
                {
                    resultSet.close();
                }
            }
            catch(Exception e)
            {
                //empty body
            }
            
        }


    }

    public void actionPerformed(ActionEvent action)
	{
        if(action.getSource()==exitBtn)
        {
            System.exit(0);
        }

        if(action.getSource()==loginBtn)
        {
			//System.out.println("Login pressed");
            databaseTable();
        }

        if(action.getSource()==registerBtn)
        {
            new RegistrationPage();
            this.dispose();
          }
	}
		public void mouseEntered(MouseEvent me){}
		public void mouseExited(MouseEvent me){}
		public void mouseClicked(MouseEvent me){}
		public void mouseReleased(MouseEvent me)
		{
		if(me.getSource().equals(btn))
		{
			passwordPf.setEchoChar('*');
		}
	}
		public void mousePressed(MouseEvent me)
		{
		if(me.getSource().equals(btn))
		{
			passwordPf.setEchoChar((char)0);
		}
	}
       



}


