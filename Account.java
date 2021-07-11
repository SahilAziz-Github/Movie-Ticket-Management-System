import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Account extends JFrame{
    public int seats;
    public int maximumSeats=4;
    public int price=300;
    public int amount;
    public double VAT ;
    public double disc=0;
    public double totalamount;
    public double amountReturn;
	String usern,date2,time2,m_name,hallno ;
    public Account(String user, String time1, String mname,String hall3){
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Reservation");
        this.setSize(800,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
        this.setIconImage(icon.getImage());
		
		usern=user;
		time2=time1;
		m_name=mname;
		hallno=hall3;
        
        JPanel Panel = new JPanel();
        Panel.setLayout(null);
        add(Panel);
        
        ImageIcon background_image = new ImageIcon(getClass().getResource("account.png"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(800,700,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        
        JLabel imgLabel = new JLabel("", background_image, JLabel.CENTER);
        imgLabel.setBounds(0, 0, 800, 700);
        Panel.add(imgLabel);
        
        JLabel movie = new JLabel("Movie Name:");
        movie.setBounds(180, 30, 170, 30);
        movie.setForeground(Color.white);
        movie.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(movie);
        JLabel movie_n = new JLabel(m_name);
        movie_n.setBounds(360, 30, 170, 30);
        movie_n.setForeground(Color.white);
        movie_n.setOpaque(true);
        movie_n.setBackground(Color.white);
        movie_n.setForeground(Color.black);
        imgLabel.add(movie_n);
        
        JLabel time = new JLabel("Show Time :");
        time.setBounds(180, 80, 170, 30);
        time.setForeground(Color.white);
        time.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(time);
        JLabel s_time = new JLabel(time2);
        s_time.setBounds(360, 80, 170, 30);
        s_time.setForeground(Color.white);
        s_time.setOpaque(true);
        s_time.setBackground(Color.white);
        s_time.setForeground(Color.black);
        imgLabel.add(s_time);
        
        JLabel hall = new JLabel("Hall No :");
        hall.setBounds(180, 130, 170, 30);
        hall.setForeground(Color.white);
        hall.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(hall);
        JLabel halln = new JLabel(hallno);
        halln.setBounds(360, 130, 170, 30);
        halln.setForeground(Color.white);
        halln.setOpaque(true);
        halln.setBackground(Color.white);
        halln.setForeground(Color.black);
        imgLabel.add(halln); 
        
        JLabel t_seats = new JLabel("Total Seats :");
        t_seats.setBounds(180, 180, 170, 30);
        t_seats.setForeground(Color.white);
        t_seats.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(t_seats);
        JTextField seatsL = new JTextField();
        seatsL.setBounds(360, 180, 170, 30);
        seatsL.setBackground(Color.white);
        seatsL.setForeground(Color.blue);
        imgLabel.add(seatsL);
        
        JLabel Amount = new JLabel("Amount Due :");
        Amount.setBounds(180, 230, 170, 30);
        Amount.setForeground(Color.white);
        Amount.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(Amount);
        JLabel AmountL = new JLabel();
        AmountL.setBounds(360, 230, 170, 30);
        AmountL.setForeground(Color.white);
        AmountL.setOpaque(true);
        AmountL.setBackground(Color.white);
        AmountL.setForeground(Color.blue);
        imgLabel.add(AmountL);
        
        JLabel vat = new JLabel("VAT(15%) :");
        vat.setBounds(180, 260, 170, 30);
        vat.setForeground(Color.white);
        vat.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(vat);
        JLabel vatL = new JLabel();
        vatL.setBounds(360, 260, 170, 30);
        vatL.setForeground(Color.white);
        vatL.setOpaque(true);
        vatL.setBackground(Color.white);
        vatL.setForeground(Color.blue);
        imgLabel.add(vatL);
        
        JLabel total = new JLabel("Sub Total :");
        total.setBounds(180, 291, 170, 30);
        total.setForeground(Color.white);
        total.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(total);
        JLabel s_total = new JLabel();
        s_total.setBounds(360, 291, 170, 30);
        s_total.setForeground(Color.white);
        s_total.setOpaque(true);
        s_total.setBackground(Color.white);
        s_total.setForeground(Color.blue);
        imgLabel.add(s_total);
        
        JLabel username = new JLabel("User Name");
        username.setBounds(180, 391, 170, 30);
        username.setForeground(Color.white);
        username.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(username);
        JLabel usernameL = new JLabel(usern);
        usernameL.setBounds(360, 391, 170, 30);
        usernameL.setOpaque(true);
        usernameL.setBackground(Color.white);
        imgLabel.add(usernameL); 
        
        JLabel t_amount = new JLabel("Total Amount Due :");
        t_amount.setBounds(180, 441, 170, 30);
        t_amount.setForeground(Color.white);
        t_amount.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add( t_amount);
        JLabel  t_amountL = new JLabel();
        t_amountL.setBounds(360, 441, 170, 30);
        t_amountL.setForeground(Color.white);
        t_amountL.setOpaque(true);
        t_amountL.setBackground(Color.white);
        t_amountL.setForeground(Color.blue);
        imgLabel.add(t_amountL);
        
        JLabel AmountP = new JLabel("Amount Paid :");
        AmountP.setBounds(180, 491, 170, 30);
        AmountP.setForeground(Color.white);
        AmountP.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(AmountP);
        JTextField AmountField = new JTextField();
        AmountField.setBounds(360, 491, 170, 30);
        AmountField.setBackground(Color.white);
        AmountField.setForeground(Color.red);
        imgLabel.add(AmountField);
        
        JLabel change = new JLabel("Change :");
        change.setBounds(180, 541, 170, 30);
        change.setForeground(Color.white);
        change.setFont(new Font("times new roman", Font.PLAIN, 20));
        imgLabel.add(change);
        JTextField ChangeField = new JTextField();
        ChangeField.setBounds(360, 541, 170, 30);
        ChangeField.setBackground(Color.white);
        ChangeField.setForeground(Color.blue);
        imgLabel.add(ChangeField);
        
        JButton PrintButton = new JButton("Print");
        PrintButton.setBounds(550, 600, 100, 30);
        PrintButton.setFont(new Font("times new roman", Font.PLAIN, 18));
        imgLabel.add(PrintButton);
        
		/*try
		{
			String query='Select moviedate, moviename, time from movienames where movieid=1' ;
		}
		catch(Exception ex)
		{
			
		}*/
		
        this.setVisible(true);
        
        PrintButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                dispose();
                JOptionPane.showMessageDialog(null, "Ticket Confirmed");
				
				
				System.out.println("Customer Name : "+usern);
				System.out.println("Movie Name : "+m_name);
				System.out.println("Hall Number : "+hallno);
				System.out.println("Showtime : "+time2);
				System.out.println("Number of Seats Booked :"+seatsL.getText());
				
				System.exit(0);
            }
        });
        
         seatsL.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String value = seatsL.getText();
                if(value.isEmpty()){
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
                else
                {                   
                    seats = Integer.parseInt(seatsL.getText());
                    if(seats > maximumSeats){
                        JOptionPane.showMessageDialog(null, "Please, select less than 5 seats!");
                        seatsL.setText("");
                        
                    }else{
                    
                        amount = price*seats;
                        VAT = amount*0.15;
                        totalamount = amount +VAT;
                        AmountL.setText(" "+Integer.toString(amount));
                        vatL.setText(" "+Double.toString(VAT));
                        s_total.setText(" "+Double.toString(totalamount));
                        t_amountL.setText(" "+Double.toString(totalamount));
                    }
            }
            }
        });
	
        
        AmountField.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String value = AmountField.getText();
                if(value.isEmpty()){
                    JOptionPane.showMessageDialog(null, "ERROR");
                }
                else
                {
                    double a = Double.parseDouble(AmountField.getText());
                    if(a< totalamount){
                        JOptionPane.showMessageDialog(null, "ERROR");
                        AmountField.setText("");
                    }
                    else
                    {
                        amountReturn = a- totalamount;
                        
                        ChangeField.setText(""+ Double.toString(amountReturn));
                    }
                }
            }
	});
        
        
        
   } 
   }
   /*
    public static void main(String[] args){
        Account frame = new Account();
        frame.setVisible(true);
    }
    
} */
