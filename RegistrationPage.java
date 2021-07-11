

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationPage extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel registrationLabel, firstnameLabel, lastnameLabel, usernameLabel, passwordLabel, repeatPasswordLabel;
    private JTextField firstnameTf, lastnameTf, usernameTf;
    private JPasswordField passwordPf, repeatPasswordPf;
    private JButton confirmBtn, cancelBtn;

    public RegistrationPage(){
        this.setTitle("Customer Registration");
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

        registrationLabel=new JLabel("Registration");
        registrationLabel.setBounds(300, 100, 150, 50);
        registrationLabel.setForeground(Color.white);
        registrationLabel.setFont(new Font("times new roman", Font.PLAIN, 28));
        imgLabel.add(registrationLabel);

        firstnameLabel=new JLabel("First Name:");
        firstnameLabel.setBounds(180, 190, 100, 30);
        firstnameLabel.setForeground(Color.white);
        firstnameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(firstnameLabel);

        lastnameLabel=new JLabel("Last Name:");
        lastnameLabel.setBounds(180, 240, 100, 30);
        lastnameLabel.setForeground(Color.white);
        lastnameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(lastnameLabel);

        usernameLabel=new JLabel("Username:");
        usernameLabel.setBounds(180, 290, 100, 30);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(usernameLabel);

        passwordLabel=new JLabel("Password:");
        passwordLabel.setBounds(180, 340, 100, 30);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(passwordLabel);

        repeatPasswordLabel=new JLabel("Repeat Password:");
        repeatPasswordLabel.setBounds(180, 390, 150, 30);
        repeatPasswordLabel.setForeground(Color.white);
        repeatPasswordLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(repeatPasswordLabel);

        firstnameTf=new JTextField();
        firstnameTf.setBounds(340, 190, 220, 30);
        imgLabel.add(firstnameTf);

        lastnameTf=new JTextField();
        lastnameTf.setBounds(340, 240, 220, 30);
        imgLabel.add(lastnameTf);

        usernameTf=new JTextField();
        usernameTf.setBounds(340, 290, 220, 30);
        imgLabel.add(usernameTf);

        passwordPf=new JPasswordField();
        passwordPf.setBounds(340, 340, 220, 30);
        imgLabel.add(passwordPf);

        repeatPasswordPf=new JPasswordField();
        repeatPasswordPf.setBounds(340, 390, 220, 30);
        imgLabel.add(repeatPasswordPf);

        cancelBtn=new JButton("Cancel");
        cancelBtn.setBounds(180, 470, 100, 30);
        cancelBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        cancelBtn.addActionListener(this);
        imgLabel.add(cancelBtn);

        confirmBtn=new JButton("Confirm");
        confirmBtn.setBounds(460, 470, 100, 30);
        confirmBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        confirmBtn.addActionListener(this);
        imgLabel.add(confirmBtn);
        
        this.setVisible(true);


    }

    private boolean passwordCheck(){
        String str1=new String(passwordPf.getPassword());
        String str2=new String(repeatPasswordPf.getPassword());
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
            if(firstnameTf.getText().equals("") || lastnameTf.getText().equals("") || usernameTf.getText().equals(""))
            {
                flag=false;
                JOptionPane.showMessageDialog(this, "Complete the naming fields");
            }
            else if(!passwordCheck())
            {
                flag=false;
                JOptionPane.showMessageDialog(this, "Password did not match");
            }
            String query="insert into people values('"+usernameTf.getText()+"','"+firstnameTf.getText()+"','"+lastnameTf.getText()+"','"+new String(passwordPf.getPassword())+"','customer');";
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
                JOptionPane.showMessageDialog(this, "Your account has been created");
                new LoginPage();
                this.dispose();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Exception: "+ e.getMessage());
            JOptionPane.showMessageDialog(this, "Username already exists");
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
        if(action.getSource()==cancelBtn)
        {
            new LoginPage();
            this.dispose();
        }
        if(action.getSource()==confirmBtn)
        {
            databaseTable();
        }

    }

}