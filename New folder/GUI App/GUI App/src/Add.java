import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class Add extends JFrame{
	JTextField t1,t2,t3,t4;
	JButton b;
	public Add(){
		super("Add");
		this.setLocation(50, 50);
		this.setSize(600, 200);
		//this.setVisible(true);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		t1 = new JTextField(10);
		add(t1);
		t2 = new JTextField(10);
		add(t2);
		t3 = new JTextField(10);
		add(t3);
		t4 = new JTextField(10);
		add(t4);
	
		b = new JButton("insert");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				String sql = "INSERT INTO user VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"')";
				DataAccess d = new DataAccess();
				d.insert(sql);
				Home.populateTable();
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