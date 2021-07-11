import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddMovies extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel nameLabel, idLabel, movieNameLabel, durationLabel, dateLabel, hallLabel, viewLabel, timeLabel, ticketPriceLabel;
    private JTextField idTf, movieNameTf, durationTf, dateTf, hallTf, viewTf, timeTf, ticketPriceTf;
    private JButton confirmBtn, cancelBtn;

    public AddMovies(){
        this.setTitle("Movie Tickets Booking System");
        this.setSize(800, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());

        panel=new JPanel();
        panel.setSize(800, 700);
        this.add(panel);
        
        ImageIcon background_image = new ImageIcon(getClass().getResource("movie.jpg"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(800,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        
        JLabel imgLabel = new JLabel("", background_image, JLabel.CENTER);
        imgLabel.setBounds(0, 0, 800, 700);
        panel.add(imgLabel);

        nameLabel=new JLabel("Add New Movies");
        nameLabel.setBounds(330, 5, 400, 40);
        nameLabel.setFont(new Font("times new roman", Font.PLAIN, 22));
        imgLabel.add(nameLabel);

        idLabel=new JLabel("Movie ID:");
        idLabel.setBounds(270, 100, 100, 30);
        idLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(idLabel);

        movieNameLabel=new JLabel("Movie Name:");
        movieNameLabel.setBounds(270, 150, 110, 30);
        movieNameLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(movieNameLabel);

        durationLabel=new JLabel("Duration:");
        durationLabel.setBounds(270, 200, 100, 30);
        durationLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(durationLabel);

        dateLabel=new JLabel("Date:");
        dateLabel.setBounds(270, 250, 100, 30);
        dateLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(dateLabel);

        hallLabel=new JLabel("Hall");
        hallLabel.setBounds(270, 300, 150, 30);
        hallLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(hallLabel);

        viewLabel=new JLabel("View:");
        viewLabel.setBounds(270, 350, 150, 30);
        viewLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(viewLabel);

        timeLabel=new JLabel("Time:");
        timeLabel.setBounds(270, 400, 150, 30);
        timeLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(timeLabel);

        ticketPriceLabel=new JLabel("Ticket Price:");
        ticketPriceLabel.setBounds(270, 450, 150, 30);
        ticketPriceLabel.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(ticketPriceLabel);

        idTf=new JTextField();
        idTf.setBounds(430, 100, 220, 30);
        imgLabel.add(idTf);

        movieNameTf=new JTextField();
        movieNameTf.setBounds(430, 150, 220, 30);
        imgLabel.add(movieNameTf);

        durationTf=new JTextField();
        durationTf.setBounds(430, 200, 220, 30);
        imgLabel.add(durationTf);

        dateTf=new JTextField();
        dateTf.setBounds(430, 250, 220, 30);
        imgLabel.add(dateTf);

        hallTf=new JTextField();
        hallTf.setBounds(430, 300, 220, 30);
        imgLabel.add(hallTf);

        viewTf=new JTextField();
        viewTf.setBounds(430, 350, 220, 30);
        imgLabel.add(viewTf);

        timeTf=new JTextField();
        timeTf.setBounds(430, 400, 220, 30);
        imgLabel.add(timeTf);

        ticketPriceTf=new JTextField();
        ticketPriceTf.setBounds(430, 450, 220, 30);
        imgLabel.add(ticketPriceTf);

        cancelBtn=new JButton("Cancel");
        cancelBtn.setBounds(270, 530, 100, 30);
        cancelBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        cancelBtn.addActionListener(this);
        imgLabel.add(cancelBtn);

        confirmBtn=new JButton("Confirm");
        confirmBtn.setBounds(550, 530, 100, 30);
        confirmBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        confirmBtn.addActionListener(this);
        imgLabel.add(confirmBtn);

    }

    private void databaseTable(){
        boolean flag=true;
        Connection connection=null;
        Statement statement=null;

        try
        {
            if(idTf.getText().equals("") || movieNameTf.getText().equals("") || durationTf.getText().equals("") || dateTf.getText().equals("") || hallTf.getText().equals("") || viewTf.getText().equals("") || timeTf.getText().equals("") || ticketPriceTf.getText().equals(""))
            {
                flag=false;
                JOptionPane.showMessageDialog(this, "Please complete all the fields");
            }
            String query="insert into movienames values('"+idTf.getText()+"','"+movieNameTf.getText()+"','"+durationTf.getText()+"','"+dateTf.getText()+"','"+hallTf.getText()+"','"+viewTf.getText()+"','"+timeTf.getText()+"','"+ticketPriceTf.getText()+"');";
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
                JOptionPane.showMessageDialog(this, "Movie has been scheduled");
                new ManagerDashboard();
                this.dispose();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Exception: "+ e.getMessage());
            JOptionPane.showMessageDialog(this, "Movie ID already exists");
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

    public void actionPerformed(ActionEvent action) {
        if(action.getSource()==cancelBtn)
        {
            new ManagerDashboard();
            this.dispose();
        }
        if(action.getSource()==confirmBtn)
        {
            databaseTable();
        }

    }

}