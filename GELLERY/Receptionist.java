package GELLERY;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Receptionist extends JFrame {
	
	private JButton sellArtButton;
	private JButton logoutButton;
	private JPanel panelrecep;
	private Login login;
	private Receptionist recep=this;
	private JButton sellTicketButton;
	
	
	public Receptionist(Login login) {
		
		//frame
		setTitle("Login recep");
		setBounds(40, 40, 500, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.login=login;
		
		
		//panel
		panelrecep = new JPanel(new GridLayout(3,2,10,10));
        panelrecep.setBounds(0, 0, 500, 600);
        panelrecep.setBackground(Color.cyan);
        //panelrecep.setLayout(null);
        add(panelrecep);
        
        
        
        initComoponents();
	}
	
	private void initComoponents () {
		
		//sell tickets
		sellTicketButton = new JButton("Sell Tickets");
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
		//sellArtButton.setBounds(300,200,80,50);
		sellArtButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,100));
		/*sellArtButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Manager manager=new Manager(login);
				manager.setVisible(true);
				setVisible(false);
				
			}
		});*/
		
		panelrecep.add(sellArtButton);
		
		//logout
		logoutButton = new JButton("Logout");
		//logoutButton.setBounds(300,500,80,50);
		logoutButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,10));
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
