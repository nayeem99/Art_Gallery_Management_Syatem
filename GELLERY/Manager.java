package GELLERY;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Manager extends JFrame {
	private JButton empButton;
	private JButton logoutButton;
	private JPanel panelman;
	private Login login;
	private Manager manager=this;
	
	
	public Manager(Login login) {
		
		 //frame
		setTitle("Login man");
		setBounds(40, 40, 500, 500);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.login=login;
		
		//panle
		panelman = new JPanel();
        panelman.setBounds(0, 0, 680, 500);
        panelman.setBackground(Color.cyan);
        panelman.setLayout(null);
        add(panelman);
        
        initComoponents();
	}
	
	private void initComoponents () {
		
		
		//login button
		empButton = new JButton("Login");
		empButton.setBounds(300,200,80,50);
		empButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,10));
		/*empButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Manager manager=new Manager(login);
				manager.setVisible(true);
				setVisible(false);
				
			}
		});*/
		
		panelman.add(empButton);
		
		//logout button
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(300,300,80,50);
		logoutButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,10));
		logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 
				
				//Manager manager=new Manager();
				manager.dispose();
				login.setVisible(true);
				
				//setVisible(false);
				
			}
		});
		
		panelman.add(logoutButton);
	}

}

//datetimepicker
//stdefultop null
//gridlayout
