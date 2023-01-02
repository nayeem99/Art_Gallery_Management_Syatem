import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DataAccess {
	private Connection con;
	private Statement stat;
	private ResultSet res;
	
	public DataAccess(){
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/falldb", "root", "");
			stat = (Statement)con.createStatement();
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	public boolean login(String name, String pass){
		String sql = "Select * from user where name = '" + name + "' and password ='" + pass + "'";
		try{
			res = stat.executeQuery(sql);
			if(res.next()){
				return true;
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<User> GetUsers(String sql){
		ArrayList<User> list = new ArrayList<User>();
		
		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				User u = new User();
				u.id=res.getInt("id");
				u.name=res.getString("name");
				u.password=res.getString("password");
				u.type=res.getString("type");
				list.add(u);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(String sql){
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}








