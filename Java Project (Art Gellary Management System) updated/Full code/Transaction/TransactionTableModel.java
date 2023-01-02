package Transaction;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import GELLERY.DataAccess;


public class TransactionTableModel extends AbstractTableModel  {
	private String[] colNames = {"Arts ID","Arts Price","Customer Id","Customer Name","Customer Mobileno","Sale Date"};
	private static ArrayList<TransactionUsers> tusers = new ArrayList<TransactionUsers>();
	
public TransactionTableModel(String keys) {
		String querys = "select * from transaction";
		if(!keys.equals(""))
			querys = querys + " where sale_date like '%"+keys+"%'";
		
		DataAccess da = new DataAccess();
		if(da.GetTransaction(querys)!=null){
			tusers = da.GetTransaction(querys);
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
		
		return tusers.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
	
		if(tusers.size()==0)
			return null;
		
		
		try
		{
			TransactionUsers e = tusers.get(row);
			switch(col)
			{
				case 0:
					return e.arts_id;
				case 1:
					return e.arts_price;
				case 2:
					return e.customer_id;
				case 3:
					return e.customer_name;
				case 4:
					return e.mobileno;
				case 5:
					return e.sale_date;
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
		
		tusers.remove(i);
		
	}

	



	
	

}
