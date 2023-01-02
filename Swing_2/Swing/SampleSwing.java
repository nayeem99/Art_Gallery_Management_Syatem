//import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleSwing extends JFrame implements ActionListener{
	
	private JTextField txt1;
	
	public SampleSwing(){
		//super("Sample");
		initComponents();		
	}
	
	private void initComponents(){
		
		//setSize(600,500);
		setBounds(300,200,600,500);
		setVisible(true);
		setTitle("Sample GUI");
		setLayout(null);
		//setLocation(300,200);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0,0,600,500);
		panel1.setBackground(Color.cyan);
		add(panel1);
		
		JLabel lbl1 = new JLabel("User Name");
		lbl1.setBounds(200,100, 80, 30);
		panel1.add(lbl1);
		
		txt1 = new JTextField();
		txt1.setBounds(300,100, 150, 30);
		panel1.add(txt1);
		
		JButton btn1 = new JButton("Click");
		btn1.setBounds(250,180, 80, 30);
		panel1.add(btn1);
		
		btn1.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		//JOptionPane msg = new JOptionPane();
		JOptionPane.showMessageDialog(null, txt1.getText());
	}
}








