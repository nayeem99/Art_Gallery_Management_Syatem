package GELLERY;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DataAccess {
	ResultSet result;
	Statement state;
	public DataAccess() {
		try {
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/artgg","root","");
			state=(Statement)con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null,"can not connect");
		}	
	}
	    //manager verification
	public boolean verification(String user,String password) {
		try {
			
			result=state.executeQuery("select * from manager where id="+user+" and password='"+password+"'");
			result.next();
			if(result.getInt("id")==Integer.parseInt(user) && result.getString("password").equals(password) ) {
				return true;
			}
			
			
		}
		
		catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Invalid id");
		}
		return false;
	}     
	 ////reciptionist verification
	public boolean verification2(String user,String password) {
		try {
			result=state.executeQuery("select * from receptionist where id="+user+" and password='"+password+"'");
			result.next();
			if(result.getInt("id")==Integer.parseInt(user) && result.getString("password").equals(password) ) {
				return true;
			}
			
			
		}
		
		catch(Exception t) {
			JOptionPane.showMessageDialog(null,"Invalid id");
		}
		return false;
	}
	


}
