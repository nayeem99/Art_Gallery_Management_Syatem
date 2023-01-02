import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class UsersTableModel extends AbstractTableModel {
	
	private String[] colNames = {"ID","Name","Type"};
	private ArrayList<User> users = new ArrayList<User>();
	
	public UsersTableModel(String key) {
		String query = "select * from user";
		if(!key.equals(""))
			query = query + " where name like '%"+key+"%'";
		
		DataAccess da = new DataAccess();
		users = da.GetUsers(query);
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colNames.length;
	}
	
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		if(users.size()==0)
			return null;
		
		
		try
		{
			User u = users.get(row);
			switch(col)
			{
				case 0:
					return u.id;
				case 1:
					return u.name;
				case 2:
					return u.type;
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
