package Artstock;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


import GELLERY.CurrentDateTime;
import GELLERY.DataAccess;


public class EditStock extends JFrame{
	JTextField t1,t2,t3,t4;
	JButton b;
	CurrentDateTime date;
	public EditStock(){
		
		this.setLocation(50, 50);
		this.setSize(600, 200);
		//this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		t1 = new JTextField(10);
		add(t1);
		t2 = new JTextField(10);
		add(t2);
		t3 = new JTextField(10);
		add(t3);
		t4 = new JTextField(10);
		//add(t4);
	
		b = new JButton("Update");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime now = LocalDateTime.now();  
				String sql="update arts set id="+t1.getText()+",type='"+t2.getText()+"',price="+t3.getText()+" where id="+t1.getText();
				DataAccess d = new DataAccess();
				d.insert(sql);
				
				ArtStock.populateTable();
			}
		});
		add(b);
	}

}













/*

String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
DataAccess d = new DataAccess();
d.insert(sql);
*/

