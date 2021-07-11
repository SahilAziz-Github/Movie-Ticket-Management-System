import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.*;

public class UserDashboard extends JFrame implements ActionListener{

    private JPanel panel;
    private JLabel dashboardLabel, movieLabel1, movieLabel2, durationLabel1, durationLabel2, hallLabel1, hallLabel2, viewLabel1, viewLabel2, timeLabel1, timeLabel2, priceLabel1, priceLabel2;
    private JButton logoutBtn, selectMovie1, selectMovie2,pchangeButton,delButton;
    private SimpleDateFormat sdf;
    private Calendar cal;
    private String date1, date2, date3, date4, date5;
    private String movieDates[]=new String[6];
    private JComboBox movieDatesCombo;
    String  usern=null, movname=null, tim=null,movname1=null,tim1=null,hall1=null,hall2=null; 
    public UserDashboard(String user){
        this.setTitle("User Dashboard");
        this.setSize(800, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
        
        usern=user;
		System.out.println("from dashboard page"+usern);
                
        panel=new JPanel();
        panel.setSize(800, 700);
        this.add(panel);
        
        ImageIcon background_image = new ImageIcon(getClass().getResource("dash_board.jpg"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(800,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        
        JLabel imgLabel = new JLabel("", background_image, JLabel.CENTER);
        imgLabel.setBounds(0, 0, 800, 700);
        panel.add(imgLabel);

        dashboardLabel=new JLabel("User Dashboard");
        dashboardLabel.setBounds(285, 10, 200, 50);
        dashboardLabel.setForeground(Color.white);
        dashboardLabel.setFont(new Font("times new roman", Font.PLAIN, 30));
        imgLabel.add(dashboardLabel);
		
		 JLabel userW=new JLabel("Welcome,"+usern);
        userW .setBounds(600, 50, 200, 50);
        userW.setForeground(Color.white);
        userW.setFont(new Font("times new roman", Font.PLAIN, 28));
        imgLabel.add(userW);

        movieLabel1=new JLabel();
        movieLabel1.setBounds(200, 100, 450, 50);
        movieLabel1.setForeground(Color.white);
        movieLabel1.setFont(new Font("times new roman", Font.PLAIN, 24));
        imgLabel.add(movieLabel1);

        durationLabel1=new JLabel();
        durationLabel1.setBounds(200, 150, 150, 30);
        durationLabel1.setForeground(Color.white);
        durationLabel1.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(durationLabel1);

        hallLabel1=new JLabel();
        hallLabel1.setBounds(370, 150, 100, 30);
        hallLabel1.setForeground(Color.white);
        hallLabel1.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(hallLabel1);

        viewLabel1=new JLabel();
        viewLabel1.setBounds(470, 150, 100, 30);
        viewLabel1.setForeground(Color.white);
        viewLabel1.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(viewLabel1);

        timeLabel1=new JLabel();
        timeLabel1.setBounds(570, 150, 100, 30);
        timeLabel1.setForeground(Color.white);
        timeLabel1.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(timeLabel1);

        priceLabel1=new JLabel();
        priceLabel1.setBounds(570, 180, 200, 30);
        priceLabel1.setForeground(Color.white);
        priceLabel1.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(priceLabel1);

        selectMovie1=new JButton("Select");
        selectMovie1.setBounds(200, 200, 80, 25);
        selectMovie1.setForeground(Color.black);
        selectMovie1.setFont(new Font("times new roman", Font.PLAIN, 16));
	selectMovie1.addActionListener(this);
        imgLabel.add(selectMovie1);
        selectMovie1.setVisible(false);

        movieLabel2=new JLabel();
        movieLabel2.setBounds(200, 270, 450, 50);
        movieLabel2.setForeground(Color.white);
        movieLabel2.setFont(new Font("times new roman", Font.PLAIN, 24));
        imgLabel.add(movieLabel2);

        durationLabel2=new JLabel();
        durationLabel2.setBounds(200, 320, 150, 30);
        durationLabel2.setForeground(Color.white);
        durationLabel2.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(durationLabel2);

        hallLabel2=new JLabel();
        hallLabel2.setBounds(370, 320, 100, 30);
        hallLabel2.setForeground(Color.white);
        hallLabel2.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(hallLabel2);

        viewLabel2=new JLabel();
        viewLabel2.setBounds(470, 320, 100, 30);
        viewLabel2.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(viewLabel2);

        timeLabel2=new JLabel();
        timeLabel2.setBounds(570, 320, 100, 30);
        timeLabel2.setForeground(Color.white);
        timeLabel2.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(timeLabel2);

        priceLabel2=new JLabel();
        priceLabel2.setBounds(570, 350, 200, 30);
        priceLabel2.setForeground(Color.white);
        priceLabel2.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(priceLabel2);

        selectMovie2=new JButton("Select");
        selectMovie2.setBounds(200, 370, 80, 25);
        selectMovie2.setForeground(Color.black);
        selectMovie2.setFont(new Font("times new roman", Font.PLAIN, 16));
	selectMovie2.addActionListener(this);
        imgLabel.add(selectMovie2);
        selectMovie2.setVisible(false);

        logoutBtn=new JButton("Log Out");
        logoutBtn.setBounds(600, 600, 100, 30);
        logoutBtn.setFont(new Font("times new roman", Font.PLAIN, 18));
        logoutBtn.addActionListener(this);
        imgLabel.add(logoutBtn);
		
	delButton=new JButton("Delete Account");
        delButton.setBounds(130, 600, 150, 30);
        delButton.setFont(new Font("times new roman", Font.PLAIN, 18));
        delButton.addActionListener(this);
        imgLabel.add(delButton);

        pchangeButton=new JButton("Change Password");
        pchangeButton.setBounds(300, 600, 200, 30);
        pchangeButton.setFont(new Font("times new roman", Font.PLAIN, 18));
        pchangeButton.addActionListener(this);
        imgLabel.add(pchangeButton);
        


        sdf=new SimpleDateFormat("dd-MMM-yy");
        cal=new GregorianCalendar();

        cal.add(Calendar.DAY_OF_MONTH, 1);
        date1=sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        date2=sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        date3=sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        date4=sdf.format(cal.getTime());
        cal.add(Calendar.DAY_OF_MONTH, 1);
        date5=sdf.format(cal.getTime());

        movieDates[0]="Select Date";
        movieDates[1]=date1;
        movieDates[2]=date2;
        movieDates[3]=date3;
        movieDates[4]=date4;
        movieDates[5]=date5;

        movieDatesCombo=new JComboBox(movieDates);
        movieDatesCombo.setBounds(20, 120, 120, 30);
        movieDatesCombo.setFont(new Font("times new roman", Font.PLAIN, 18));
        movieDatesCombo.addActionListener(this);
        imgLabel.add(movieDatesCombo);

    }

    private void movieInfo(){
        movieLabel1.setText("");
        movieLabel2.setText("");
        durationLabel1.setText("");
        durationLabel2.setText("");
        hallLabel1.setText("");
        hallLabel2.setText("");
        viewLabel1.setText("");
        viewLabel2.setText("");
        timeLabel1.setText("");
        timeLabel2.setText("");
        priceLabel1.setText("");
        priceLabel2.setText("");
        selectMovie1.setVisible(false);
        selectMovie2.setVisible(false);
    }

    
    private void databaseTable(String temp){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try
        {
            String query="select movieid, moviename, movieduration, hallnumber, view, time, ticketprice,moviedate from movienames where moviedate='"+temp+"';";
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
            System.out.println("Connection");
            statement=connection.createStatement();
            System.out.println("Statement");
            resultSet=statement.executeQuery(query);
            System.out.println("Results Found");

            if(resultSet.next())
            {
                int i=0;
                String movieName[]=new String[2];
                String movieDuration[]=new String[2];
                String hallNumber[]=new String[2];
                String printView[]=new String[2];
                String showTime[]=new String[2];
                String ticketPrice[]=new String[2];

                movieName[i]=resultSet.getString("moviename");
				movname=movieName[i];
                movieDuration[i]=resultSet.getString("movieduration");
                hallNumber[i]=resultSet.getString("hallnumber");
				hall1=hallNumber[i];
                printView[i]=resultSet.getString("view");
                showTime[i]=resultSet.getString("time");
				tim=showTime[i];
                ticketPrice[i]=resultSet.getString("ticketprice");
				//dat=resultSet.getString("date");
                while(resultSet.next())
                {
                    movieInfo();
                    i++;
                    movieName[i]=resultSet.getString("moviename");
					movname1=movieName[i];
                    movieDuration[i]=resultSet.getString("movieduration");
                    hallNumber[i]=resultSet.getString("hallnumber");
					hall2=hallNumber[i];
                    printView[i]=resultSet.getString("view");
                    showTime[i]=resultSet.getString("time");
					tim1=showTime[i];
                    ticketPrice[i]=resultSet.getString("ticketprice");
                }
                if(!movieName[0].equals(""))
                {
                    movieLabel1.setText(movieName[0]);
                    durationLabel1.setText("Duration: "+ movieDuration[0] +" mins");
                    hallLabel1.setText("Hall: "+ hallNumber[0]);
                    viewLabel1.setText("View: "+ printView[0]);
                    timeLabel1.setText("Time: "+ showTime[0]);
                    priceLabel1.setText("Price: "+ ticketPrice[0] +" Tk");
                    selectMovie1.setVisible(true);
                }
                if(!movieName[1].equals(""))
                {
                    movieLabel2.setText(movieName[1]);
                    durationLabel2.setText("Duration: "+ movieDuration[1] +" mins");
                    hallLabel2.setText("Hall: "+ hallNumber[1]);
                    viewLabel2.setText("View: "+ printView[1]);
                    timeLabel2.setText("Time: "+ showTime[1]);
                    priceLabel2.setText("Price: "+ ticketPrice[1] +" Tk");
                    selectMovie2.setVisible(true);
                }
            }
            else
            {
                movieInfo();
                JOptionPane.showMessageDialog(this, "No movie has been scheduled yet");
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
            System.out.println("The End");
        }

    }


    public void actionPerformed(ActionEvent action){
        if(action.getSource()==logoutBtn)
        {
            new LoginPage();
            this.dispose();
        }

        if(action.getSource()==movieDatesCombo)
        {
            String temp=movieDatesCombo.getSelectedItem().toString();
            if(temp.equals("Select Date"))
            {
                movieInfo();
                System.out.println("Success");
            }
            if(temp.equals(date1))
            {
                movieInfo();
                databaseTable(temp);
                System.out.println("Success");
            }
            if(temp.equals(date2))
            {
                movieInfo();
                databaseTable(temp);
                System.out.println("Success");
            }
            if(temp.equals(date3))
            {
                movieInfo();
                databaseTable(temp);
                System.out.println("Success");
            }
            if(temp.equals(date4))
            {
                movieInfo();
                databaseTable(temp);
                System.out.println("Success");
            }
            if(temp.equals(date5))
            {
                movieInfo();
                databaseTable(temp);
                System.out.println("Success");
            }
        }
        if(action.getSource()==pchangeButton)
        {
            new PassChangePage(usern);
            this.dispose();
        }
		 if(action.getSource()==selectMovie1)
        {
            Account l=new Account(usern, tim, movname,hall1);
			l.setVisible(true);
            this.setVisible(false);
        }
		 if(action.getSource()==selectMovie2)
        {
           Account l=new Account(usern, tim1, movname1,hall2);
			l.setVisible(true);
            this.setVisible(false);
        }
		if(action.getSource()==delButton)
        {	
		Connection connection=null;
        Statement statement=null;
            try
			{
				String query="DELETE FROM people where username='"+usern+"';";
				Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver");
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","");
                System.out.println("Connection");
                statement=connection.createStatement();
                System.out.println("Statement");
                statement.execute(query);
                System.out.println("Query executed");
                JOptionPane.showMessageDialog(this, "Your account has been deleted");
                new LoginPage();
                this.dispose();
			}
            catch(Exception e)
        {
            System.out.println("Exception: "+ e.getMessage());
            JOptionPane.showMessageDialog(this, "An exception occurred");
        }
        }

    }



}