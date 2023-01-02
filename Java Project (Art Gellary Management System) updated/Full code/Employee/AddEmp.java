package Employee;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import GELLERY.CurrentDateTime;
import GELLERY.DataAccess;


public class AddEmp extends JFrame{
	JTextField t1,t2,t3,t4;
	JButton b;
	//CurrentDateTime date;
	public AddEmp(){
		super("Add");
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
		add(t4);
	
		b = new JButton("insert");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0){
				 
				String sql = "INSERT INTO employee VALUES ("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"',"+t4.getText()+")";
				//String sql = "INSERT INTO arts VALUES ("+t1.getText()+",'"+t2.getText()+"',"+t3.getText()+")";
				//String sql1 = "SELECT SYSDATE ('"+t4.getText("a")+"')";
				DataAccess d = new DataAccess();
				d.insert(sql);
				//d.insert(sql1);
				Emp.populateTable();
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

