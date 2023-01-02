package Employee;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import GELLERY.DataAccess;

public class EmpTableModel extends AbstractTableModel {
	
	private String[] colNames = {"ID","Name","Type","Conatct Number"};
	private static ArrayList<EmpUser> empusers = new ArrayList<EmpUser>();
	
public EmpTableModel(String keys) {
		String querys = "select * from employee";
		if(!keys.equals(""))
			querys = querys + " where id like '%"+keys+"%'";
		
		DataAccess da = new DataAccess();
		if(da.GetEmpUsers(querys)!=null){
			empusers = da.GetEmpUsers(querys);
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
		
		return empusers.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		if(empusers.size()==0)
			return null;
		
		
		try
		{
			EmpUser e = empusers.get(row);
			switch(col)
			{
				case 0:
					return e.id;
				case 1:
					return e.name;
				case 2:
					return e.type;
				case 3:
					return e.contact_number;
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
		
		empusers.remove(i);
		
	}

	
}
