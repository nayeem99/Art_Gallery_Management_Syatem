import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class CheckDb {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/falldb";
		try{
			Connection con = (Connection) DriverManager.getConnection(url, "root", "");
			Statement stat = (Statement) con.createStatement();
			
			String sql = "SELECT * FROM user";
			ResultSet res = stat.executeQuery(sql);
			//res.next();
			while(res.next()){
				System.out.print(res.getInt("id") + " ");
				System.out.print(res.getString("name") + " ");
				System.out.print(res.getString("password") + " ");
				System.out.print(res.getString("type") + "\n");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}     
	}

}









