package Receptionist;


import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import GELLERY.DataAccess;

public class CustomerTableModel extends AbstractTableModel {
	
	private String[] colNames = {"ID","Name","Type","Age","Price","Mobile No"};
	private static ArrayList<CustomerUser> CustomerUser = new ArrayList<CustomerUser>();
	
public CustomerTableModel(String keys) {
		String querys = "select * from customer";
		if(!keys.equals(""))
			querys = querys + " where id like '%"+keys+"%'";
		
		DataAccess da = new DataAccess();
		if(da.GetCustomers(querys)!=null){
			CustomerUser = da.GetCustomers(querys);
		}
	}
	
	@Override
	public int getColumnCount() {
		
		return colNames.length;
	}
	
	public String getColumnName(int col) {
		
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		
		return CustomerUser.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		if(CustomerUser.size()==0)
			return null;
		
		
		try
		{
			CustomerUser e = CustomerUser.get(row);
			switch(col)
			{
				case 0:
					return e.personid;
				case 1:
					return e.name;
				case 2:
					return e.type;
				case 3:
					return e.age;
				case 4:
					return e.price;
				case 5:
					return e.mobileno;
				default:
					return null;
			}
			
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	
	



	
	
	

}

