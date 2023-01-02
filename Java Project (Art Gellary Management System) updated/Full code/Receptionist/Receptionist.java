package Receptionist;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GELLERY.Login;


public class Receptionist extends JFrame {
	
	private JButton sellArtButton;
	private JButton logoutButton;
	private JPanel panelrecep;
	private Login login;
	private Receptionist recep=this;
	private JButton sellTicketButton;
	
	
	public Receptionist(Login login) {
		
		//frame
		setTitle("Reciptionist");
		setBounds(10, 10, 500, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.login=login;
		
		
		//panel
		panelrecep = new JPanel();
        panelrecep.setBounds(0, 0, 500, 400);
        panelrecep.setBackground(Color.cyan);
        panelrecep.setLayout(null);
        add(panelrecep);
        
        
        
        initComoponents();
	}
	
	private void initComoponents () {
		
		//sell tickets
		sellTicketButton = new JButton("Sell Tickets");
		sellTicketButton.setBounds(200, 120, 180, 50);
		sellTicketButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			SellTickets selltic=new SellTickets(recep);
			selltic.setVisible(true);
			setVisible(false);
			
		}
	});
		
		
		panelrecep.add(sellTicketButton);
		
		
		
		sellArtButton = new JButton("Sell Arts");
		sellArtButton.setBounds(200, 180, 180, 50);
		//sellArtButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,100));
		sellArtButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SellArts sellArts=new SellArts(recep);
				sellArts.setVisible(true);
			    setVisible(false);
			
				
			}
		});
		
		panelrecep.add(sellArtButton);
		
		//logout
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(200, 240, 180, 50);
		//logoutButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,10));
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ee) {
				// 
				
				//Manager manager=new Manager();
				recep.dispose();
				login.setVisible(true);
				
				//setVisible(false);
				
			}
		});
		
		panelrecep.add(logoutButton);
	}

}

//datetimepicker
//stdefultop null
//gridlayout
