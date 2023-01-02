package GELLERY;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
   //Mainframe
public class Login extends JFrame{
	private JPanel panelIn;
	private JTextField userId;
	private JPasswordField userPass;
	private JButton logButton;
	private JButton clearButton;
	private JLabel userLabel;
	private JLabel passLabel;
	private DataAccess da=new DataAccess();
	private Login login=this;
	private JButton loginButton;
	//private JButton ExibButton 
	
	
	public Login() {
		 //Frame
		setTitle("Login");
		setLayout(null);
		//setVisible(true);
		setBounds(30, 30, 1280, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //MainPanel
        panelIn = new JPanel();
        panelIn.setBounds(0, 0, 1280, 1000);
        panelIn.setBackground(Color.cyan);
        panelIn.setLayout(null);
        add(panelIn);
        initComponents();
        
}
	 private void initComponents() {
		
		 // 2Main textfeild
		userId = new JTextField();
		userId.setBounds(300, 100, 180, 50);
		userId.setToolTipText("Please Enter Your UserName");
		panelIn.add(userId);
		
		userPass = new JPasswordField();
		userPass.setBounds(300, 160, 180, 50);
		userPass.setToolTipText("Please Enter Your Passward");
		panelIn.add(userPass);
		
		   //Label
		userLabel = new JLabel("User Name");
		userLabel.setBounds(200,100, 80, 50);
		panelIn.add(userLabel);
		
		passLabel = new JLabel("Passward");
		passLabel.setBounds(200,160, 80, 50);
		panelIn.add(passLabel);
		
		 //Buttons
		logButton = new JButton("Login");
		logButton.setBounds(300,200,80,50);
		logButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
		logButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				if(da.verification(userId.getText(),userPass.getText())) {//&& userPass.getText().equals("1234")){
					Manager manager=new Manager(login);
					manager.setVisible(true);
					setVisible(false);
				}
				else if (da.verification2(userId.getText(),userPass.getText())) {//&& userPass.getText().equals("1234")){
					Receptionist recep=new Receptionist(login);
					recep.setVisible(true);
					setVisible(false);
				}
				
				/*if(userId.getText().equals("M") ) {//&& userPass.getText().equals("1234")){
					Manager manager=new Manager(login);
					manager.setVisible(true);
					setVisible(false);
				}
				*/
			}
		});
		panelIn.add(logButton);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(400,300,80,50);
		clearButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
		
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Auto-generated method stub
				userId.setText("");
				userPass.setText("");
			}
		});
	
		panelIn.add(clearButton);
		
		
		
		
	}
	
	
}
