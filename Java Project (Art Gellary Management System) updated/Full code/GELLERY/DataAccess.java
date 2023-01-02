package GELLERY;

import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Artstock.ArtsUser;
import Employee.EmpUser;
import Receptionist.CustomerUser;
import Transaction.TransactionUsers;

public class DataAccess {
	public ResultSet result;
	public Statement state;
	public Connection con;
	
	
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
	public boolean verification(String ArtsUser,String password) {
		try {
			
			result=state.executeQuery("select * from manager where id="+ArtsUser+" and password='"+password+"'");
			result.next();
			if(result.getInt("id")==Integer.parseInt(ArtsUser) && result.getString("password").equals(password) ) {
				return true;
			}
			
			
		}
		
		catch(Exception e) {
			//JOptionPane.showMessageDialog(null,"Invalid id");
		}
		return false;
	}     
	 ////reciptionist verification
	public boolean verification2(String ArtsUser,String password) {
		try {
			result=state.executeQuery("select * from receptionist where id="+ArtsUser+" and password='"+password+"'");
			result.next();
			if(result.getInt("id")==Integer.parseInt(ArtsUser) && result.getString("password").equals(password) ) {
				return true;
			}
			
			
		}
		
		catch(Exception t) {
			JOptionPane.showMessageDialog(null,"Invalid id");
		}
		return false;
	}
	
	
	
	  //Arts Stock table / using artsUser
	public ArrayList<ArtsUser> GetArtsUsers(String sql){		
		try{
			ArrayList<ArtsUser> list = new ArrayList<ArtsUser>();
			result = state.executeQuery(sql);//for select
			while(result.next())
			{
				ArtsUser u = new ArtsUser();
				u.id=result.getInt("id");
				u.type=result.getString("type");
				u.price=result.getInt("price");
				u.input_date=result.getString("input_date");
				list.add(u);
			}
			return list;
		}
		catch (Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid");
		}
		return null;
	}
	
	//Insert queary 
	public void insert(String sql){
		try {
			state.executeUpdate(sql); //add, insert,delete
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"can not add");
			e.printStackTrace();
		}
	}
	
	
	  //Employee table model 
	public ArrayList<EmpUser> GetEmpUsers(String sql){		
		try{
			ArrayList<EmpUser> list = new ArrayList<EmpUser>();
			result = state.executeQuery(sql);//for select
			while(result.next())
			{
				EmpUser e = new EmpUser();
				e.id=result.getInt("id");
				e.name=result.getString("name");
				e.type=result.getString("type");
				e.contact_number=result.getInt("contact_number");
				list.add(e);
			}
			return list;
		}
		catch (Exception eb){
			eb.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid");
		}
		return null;
	}
	
	
	
  //customer 
	public ArrayList<CustomerUser> GetCustomers(String sql){		
		try{
			ArrayList<CustomerUser> list = new ArrayList<CustomerUser>();
			result = state.executeQuery(sql);//for select
			while(result.next())
			{
				CustomerUser e = new CustomerUser();
				e.personid=result.getInt("personid");
				e.name=result.getString("name");
				e.type=result.getString("type");
				e.age=result.getInt("age");
				e.price=result.getInt("price");
				e.mobileno=result.getInt("mobileno");
				list.add(e);
			}
			return list;
		}
		catch (Exception eb){
			eb.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid");
		}
		return null;
	}

	
	
	///Transaction table mode
	public ArrayList<TransactionUsers> GetTransaction(String sql){		
		try{
			ArrayList<TransactionUsers> list = new ArrayList<TransactionUsers>();
			result = state.executeQuery(sql);//for select
			while(result.next())
			{
				TransactionUsers er = new TransactionUsers();
				er.arts_id=result.getInt("arts_id");
				er.arts_price=result.getInt("arts_price");
				er.customer_id=result.getInt("customer_id");
				er.customer_name=result.getString("customer_name");
				er.mobileno=result.getInt("mobileno");
				er.sale_date=result.getString("sale_date");
				list.add(er);
			}
			return list;
		}
		catch (Exception eb){
			eb.printStackTrace();
			JOptionPane.showMessageDialog(null, "Invalid");
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	///adding price
	/*public ArrayList<ArtsUser> GetPrice(String sql){	
	try{
		ArrayList<ArtsUser> list = new ArrayList<ArtsUser>();
		result = state.executeQuery(sql);//for select
		while(result.next())
		{
			ArtsUser e = new ArtsUser();
			
			e.price=result.getInt("price");
			
			list.add(e);
		}
		return list;
	}
	catch (Exception eb){
		eb.printStackTrace();
		JOptionPane.showMessageDialog(null, "Invalid");
	}
	return null;
	}*/
	
	
}
