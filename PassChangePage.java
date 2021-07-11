import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

   public class PassChangePage extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel registrationLabel, firstnameLabel, lastnameLabel, usernameLabel, passwordLabel, repeatPasswordLabel;
    private JTextField firstnameTextfield, lastnameTextfield, usernameTextfield;
    private JPasswordField passwordPasswordfield, repeatPasswordPasswordfield;
    private JButton confirmButton, cancelButton;
    String usern=null;
    
    public PassChangePage(String user){
        this.setTitle("Change Password Registration");
        this.setSize(800, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        
        usern=user;
		System.out.println(usern);
        panel=new JPanel();
        panel.setSize(800, 700);
        this.add(panel);
        
        ImageIcon background_image = new ImageIcon(getClass().getResource("password.jpg"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(800,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        
        JLabel imgLabel = new JLabel("", background_image, JLabel.CENTER);
        imgLabel.setBounds(0, 0, 800, 700);
        panel.add(imgLabel);
		

        registrationLabel=new JLabel("Change Password");
        registrationLabel.setBounds(300, 10, 250, 250);
        registrationLabel.setFont(new Font("times new roman", Font.PLAIN, 28));
        imgLabel.add(registrationLabel);

        passwordLabel=new JLabel("New Password:");
        passwordLabel.setBounds(180, 250, 200, 30);
        passwordLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(passwordLabel);

        repeatPasswordLabel=new JLabel("Repeat Password:");
        repeatPasswordLabel.setBounds(180, 300, 250, 30);
        repeatPasswordLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(repeatPasswordLabel);

        passwordPasswordfield=new JPasswordField();
        passwordPasswordfield.setBounds(340, 250, 220, 30);
        imgLabel.add(passwordPasswordfield);

        repeatPasswordPasswordfield=new JPasswordField();
        repeatPasswordPasswordfield.setBounds(340, 300, 220, 30);
        imgLabel.add(repeatPasswordPasswordfield);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(260, 380, 100, 30);
        cancelButton.setFont(new Font("times new roman", Font.PLAIN, 18));
        cancelButton.addActionListener(this);
        imgLabel.add(cancelButton);

        confirmButton=new JButton("Confirm");
        confirmButton.setBounds(460, 380, 100, 30);
        confirmButton.setFont(new Font("times new roman", Font.PLAIN, 18));
        confirmButton.addActionListener(this);
        imgLabel.add(confirmButton);
		
		


    }
    String str1 = null;
    private boolean passwordCheck(){
        str1=new String(passwordPasswordfield.getPassword());
        String str2=new String(repeatPasswordPasswordfield.getPassword());
        if(str1.equals(str2))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void databaseTable(){
        boolean flag=true;
        Connection connection=null;
        Statement statement=null;

        try
        {
			if(passwordCheck())
			{
				System.out.println("Pasword" +str1);
				System.out.println("Username"+usern);
				String query="UPDATE people SET password='"+str1+"' where username='"+usern+"';";
				Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver");
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
                System.out.println("Connection");
                statement=connection.createStatement();
                System.out.println("Statement");
                statement.execute(query);
                System.out.println("Query executed");
                JOptionPane.showMessageDialog(this, "Your account password has been changed");
                new LoginPage();
                this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Password did not match");
			}
			/*if(!passwordCheck())
            {
                flag=false;
                JOptionPane.showMessageDialog(this, "Password did not match");
            }
			else
			{
           // String query="UPDATE people SET password=('"+new String(passwordPasswordfield.getPassword())+"') where people.username=('"+usern+"');";
            String query="UPDATE people SET password='"+str1+"' where username='"+usern+"';";
            if(flag==true)
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver");
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
                System.out.println("Connection");
                statement=connection.createStatement();
                System.out.println("Statement");
                statement.execute(query);
                System.out.println("Query executed");
                JOptionPane.showMessageDialog(this, "Your account password has been changed");
                new LoginPage();
                this.dispose();
            }
        }*/
		}
        
        catch(Exception e)
        {
            System.out.println("Exception: "+ e.getMessage());
            JOptionPane.showMessageDialog(this, "An exception occurred");
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
            }
            catch(Exception e)
            {
                //empty body
            }
            
        }


    }


    public void actionPerformed(ActionEvent action){
        if(action.getSource()==cancelButton)
        {
            new LoginPage();
            this.dispose();
        }
        else if(action.getSource()==confirmButton)
        {
            databaseTable();
        }
		

    }
   }
/*	public static void main(String[] args){
        PassChangePage p = new PassChangePage();
        p.setVisible(true);
    }

}
*/