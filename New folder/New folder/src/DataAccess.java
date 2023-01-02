import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DataAccess {
	private Connection con;
	private Statement myStatement;
	private ResultSet result;
	
	public DataAccess(){
		String url = "jdbc:mysql://localhost:3306/falldb";
		try{
			this.con = (Connection) DriverManager.getConnection(url, "root", "");
			this.myStatement = (Statement) con.createStatement();
		}
		catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	public boolean login(String name, String pass){
		String sql = "SELECT * FROM user where name = '"+ name +"' and password = '"+ pass +"'";
		try{
			this.result = this.myStatement.executeQuery(sql);
			if(this.result.next()){
				return true;
			}
		} 
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
}











