package Manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Artstock.ArtStock;
import Employee.Emp;
import GELLERY.Login;
import Transaction.Transaction;

public class Manager extends JFrame {
	//private JButton logButton;
	private JButton empButton;
	private JButton logoutButton;
	private JButton transactionButton;
	private JPanel panelman;
	private Login login;
	private Manager manager=this;
	private JButton artButton;
	//private ArtStock artstock;
	//private Emp employee;
	
	
	public Manager(Login login) {
		
		 //frame
		setTitle("Manager");
		setBounds(40, 40, 680, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.login=login;
		
		//panle
		panelman = new JPanel();
        panelman.setBounds(0, 0, 680, 600);
        panelman.setBackground(Color.cyan);
        panelman.setLayout(null);
        add(panelman);
        
        initComoponents();
	}
	
	private void initComoponents () {
		
	
		
		//art button
		artButton=new JButton("Artstock");
		artButton.setBounds(250,200,200,50);
		artButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,30));
		artButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				ArtStock artstock=new ArtStock(manager);
				artstock.setVisible(true);
				setVisible(false);
			}
			
		});
		panelman.add(artButton);
		
		  //employee
		empButton=new JButton("Employee");
		empButton.setBounds(250,100,200,50);
		empButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,30));
		empButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				Emp employee=new Emp(manager);
				employee.setVisible(true);
				setVisible(false);
			}
			
		});
		panelman.add(empButton);
		
		
		
		transactionButton=new JButton("Transaction");
		transactionButton.setBounds(250,300,200,50);
		transactionButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,30));
		transactionButton.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				Transaction tra=new Transaction(manager);
				tra.setVisible(true);
				setVisible(false);
			}
			
		});
		panelman.add(transactionButton);
		
		
		//logout button
		logoutButton = new JButton("Logout");
		logoutButton.setBounds(250,400,200,50);
		logoutButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,30));
		logoutButton.addActionListener(new ActionListener() {
			
			
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


