package Artstock;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import GELLERY.DataAccess;

public class UsersTableModel extends AbstractTableModel {
	
	private String[] colNames = {"ID","Type","Price","Date"};
	private static ArrayList<ArtsUser> users = new ArrayList<ArtsUser>();
	
	public UsersTableModel(String key) {
		String query = "select * from arts";
		if(!key.equals(""))
			query = query + " where id like '%"+key+"%'";
		
		DataAccess da = new DataAccess();
		if(da.GetArtsUsers(query)!=null){
			users = da.GetArtsUsers(query);
		}
	}
	
	public void addItems(ArrayList<ArtsUser> list) {
		users=null;
		users=list;
		
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
		
		return users.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		if(users.size()==0)
			return null;
		
		
		try
		{
			ArtsUser u = users.get(row);
			switch(col)
			{
				case 0:
					return u.id;
				case 1:
					return u.type;
				case 2:
					return u.price;
				case 3:
					return u.input_date;
				default:
					return null;
			}
			
		}
		catch(Exception ex)
		{
			return null;
		}
	}

	public static void removeRow(int i) {
		
		users.remove(i);
		
	}
}
