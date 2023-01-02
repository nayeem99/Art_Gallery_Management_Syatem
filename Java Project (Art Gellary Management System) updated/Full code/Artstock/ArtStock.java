package Artstock;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Manager.Manager;
import java.sql.ResultSet;
import javax.swing.border.*;
import GELLERY.DataAccess;


public class ArtStock extends JFrame {
	
	
	
	private ArtStock artStock=this;
	private Manager manager;
	
     DataAccess da;
	
	private JPanel upperPanel,lowerPanel;

	
	private JLabel lblSearch;
	private static JTextField txtSearch;
	private JButton btnSearch,btnEdit,btnDelete,btnBack,btnAdd;
	ResultSet result;
	private static JTable tblUsers;
	
	
	public ArtStock(Manager manager) {
		//super("Home");
		this.da=new DataAccess();
		this.manager=manager;
		this.setLocation(50, 50);
		this.setSize(600, 600);
		//this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		upperPanel = new JPanel(new FlowLayout());
		this.upperPanel.setBorder(new LineBorder(Color.black, 1));
		this.upperPanel.setBounds(5, 5, 570, 40);
		add(this.upperPanel);
				

		lowerPanel = new JPanel(null);
		this.lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 1),"Data"));
		this.lowerPanel.setBounds(5, 50, 570, 340);
		add(this.lowerPanel);
		
		this.AddUpperComponent();
		this.AddLowerComponent();
	}
	
	private void AddUpperComponent() {
		
		lblSearch = new JLabel("Search");
		this.upperPanel.add(lblSearch);
		
		txtSearch = new JTextField(10);
		this.upperPanel.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				populateTable();
			}
		});
		this.upperPanel.add(btnSearch);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				Add a = new Add();
				a.setVisible(true);
				
			}
		});
		this.upperPanel.add(btnAdd); 
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				EditStock aa = new EditStock();
				aa.setVisible(true);
				
			}
			
			/*@Override
			public void actionPerformed(ActionEvent e) {

				int row = tblUsers.getSelectedRow();

				if(row<0)
				{
					JOptionPane.showMessageDialog(null, "Please Select A Row First");
					return;
				}
				
				int id = (int)tblUsers.getValueAt(row, 0);
				JOptionPane.showMessageDialog(null, id);
				txtSearch.setText((String)tblUsers.getValueAt(row, 1));
			}
			*/
		});
		this.upperPanel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
         btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				//UsersTableModel model =(UsersTableModel) tblUsers.getModel();
				try {
					JOptionPane.showMessageDialog(null,"confirm");
					String sql ="DELETE FROM arts WHERE id="+txtSearch.getText();
					//System.out.println(sql);
					
					da.state.executeUpdate(sql);
					
					//int i = tblUsers.getSelectedRow();
					//UsersTableModel.removeRow(i);
					
					
				}catch(Exception ex)
				{
				}
				
				
			}
			
			
		});
         
	
         this.upperPanel.add(btnDelete);
         
         
         
         btnBack = new JButton("Back");
         
         btnBack.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				
 				//Manager manager=new Manager();
 				artStock.dispose();
 				manager.setVisible(true);
 				
 				//setVisible(false);
 				
 			}
 		});
 		
         upperPanel.add(btnBack);
         
         
	
	}
	private void AddLowerComponent() {
		
		tblUsers = new JTable();
		tblUsers.setBackground(Color.white);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(5, 15, 490, 320);
		this.lowerPanel.add(sp);
		sp.setViewportView(tblUsers);
		
		this.populateTable();
	}

	public static void populateTable() {
		
		UsersTableModel model = new UsersTableModel(txtSearch.getText());
		
		tblUsers.setModel(model);
	}
}


