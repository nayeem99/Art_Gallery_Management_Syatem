package Receptionist;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GELLERY.DataAccess;


class SellTickets extends JFrame {
	
    private JButton confirmButton;
	private JButton backButton;
	private JTextField name, mobileNo,price,age,id,type;
	private JLabel labelName,labelMobileNo,labelAge,labelPrice,labelType;
	private JPanel panelSell;
	private Receptionist recep;
	private SellTickets selltic=this;
	private JButton clearButton;
	
	
	public SellTickets(Receptionist recep) {
		setTitle("Login selltickets");
		setBounds(40, 40, 500, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.recep=recep;
		
		panelSell = new JPanel();
        panelSell.setBounds(0, 0, 500, 600);
        panelSell.setBackground(Color.cyan);
        panelSell.setLayout(null);
        add(panelSell);
        
        
        
        initComoponents();
	}
	
	private void initComoponents () {
		
		
		
		 // 2Main textfeild
	     name = new JTextField();
		 name.setBounds(200, 120, 180, 50);
		 name.setToolTipText("Please Enter Your FullName");
		 panelSell.add(name);
		 
		 
		 
		 mobileNo = new JTextField();
		 mobileNo.setBounds(200, 180, 180, 50);
		 mobileNo.setToolTipText("Please Enter Your mobile number");
		 panelSell.add(mobileNo);
		 
		// 2Main textfeild
	     price = new JTextField(200);
		 price.setBounds(200, 240, 180, 50);
		 price.setToolTipText("Please Enter Your price");
		 panelSell.add(price);
		 
		// 2Main textfeild
	     age = new JTextField();
		 age.setBounds(200, 300, 180, 50);
		 age.setToolTipText("Please Enter Your age");
		 panelSell.add(age);
		// 2Main textfeild
		 /*
	     id = new JTextField();
		 id.setBounds(300, 80, 180, 20);
		 id.setToolTipText("Please Enter Your id");
		 panelSell.add(id); */
		 
		// 2Main textfeild
	     type = new JTextField(null);
		 type.setBounds(200, 360, 180, 50);
		 type.setToolTipText("Please Enter Your type");
		 panelSell.add(type);
		
		
		//Label
			/*labelName = new JLabel(" Name");
			labelName.setBounds(200,100, 80, 50);
			 panelSell.add(labelName);
			
			 labelMobileNo = new JLabel("Passward");
			 labelMobileNo.setBounds(200,160, 80, 50);
			panelSell.add(labelMobileNo);*/
		
		 labelName = new JLabel(" Name");
			labelName.setBounds(50,120, 80, 50);
			labelName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,15));
			 panelSell.add(labelName);
			
			 labelMobileNo = new JLabel("Mobile Number");
			 labelMobileNo.setBounds(50,180, 100, 50);
			 labelMobileNo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,15));
			panelSell.add(labelMobileNo);
			
			labelAge = new JLabel("Age");
			 labelAge.setBounds(50,300, 80, 50);
			 labelAge.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,15));
			panelSell.add(labelAge);
			
			labelPrice = new JLabel("Price");
			labelPrice.setBounds(50,240, 80, 50);
			labelPrice.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,15));
			panelSell.add(labelPrice);
			
			labelType = new JLabel("Type");
			labelType.setBounds(50,360, 80, 50);
			labelType.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,15));
			panelSell.add(labelType);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//clearButton = new JButton("Clear All");
		//panelSell.add(clearButton);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(200,450,80,50);
		confirmButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,12));
		confirmButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String sql1 = "INSERT INTO customer VALUES (null,'"+name.getText()+"','"+type.getText()+"',"+age.getText()+","+price.getText()+","+mobileNo.getText()+")";
				DataAccess de = new DataAccess();
				de.insert(sql1);
				
				//d.insert(sql1);
				//Home.populateTable();
			}
		});
		
		
		panelSell.add(confirmButton);
		
		
		backButton = new JButton("Back");
		backButton.setBounds(300,450,80,50);
		backButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,15));
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent j) {
				// 
				
				//Manager manager=new Manager();
				selltic.dispose();
				recep.setVisible(true);
				
				//setVisible(false);
				
			}
		});
		
		panelSell.add(backButton);
	}

}

//datetimepicker
//stdefultop null
//gridlayout
