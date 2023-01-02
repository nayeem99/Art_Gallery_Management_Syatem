package GELLERY;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class SellTickets extends JFrame {
	private static final LayoutManager FlowLayout = null;
    private JButton confirmButton;
	private JButton backButton;
	private JTextField name, mobileNo;
	private JLabel labelName,labelMobileNo;
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
		 name.setBounds(300, 180, 180, 50);
		 name.setToolTipText("Please Enter Your FullName");
		 panelSell.add(name);
		 
		 
		 
		 mobileNo = new JTextField();
		 mobileNo.setBounds(300, 220, 180, 50);
		 mobileNo.setToolTipText("Please Enter Your mobile number");
		 panelSell.add(mobileNo);
		
		
		//Label
			labelName = new JLabel(" Name");
			labelName.setBounds(200,100, 80, 50);
			 panelSell.add(labelName);
			
			 labelMobileNo = new JLabel("Passward");
			 labelMobileNo.setBounds(200,160, 80, 50);
			panelSell.add(labelMobileNo);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//clearButton = new JButton("Clear All");
		//panelSell.add(clearButton);
		
		confirmButton = new JButton("Confirm");
		confirmButton.setBounds(100,200,80,50);
		confirmButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,10));
		
		
		panelSell.add(confirmButton);
		
		
		backButton = new JButton("Back");
		backButton.setBounds(300,500,80,50);
		backButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,10));
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
