package Employee;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import Artstock.Add;
import Artstock.UsersTableModel;
import GELLERY.DataAccess;
import Manager.Manager;



public class Emp extends JFrame {
	
    DataAccess da;
	
	private JPanel upperPanel;
	private JPanel lowerPanel;
	//private ArtStock artStock;
	private JLabel lblSearch;
	private static JTextField txtSearch;
	private JButton btnSearch,btnEdit,btnDelete,btnBack;
	private JButton btnAdd;
	ResultSet result;
	Statement state;
	Connection con;
	private static JTable tblUsers;
	private JPanel empStock;
	private Manager man;
	private Emp emp=this;
	
	public Emp(Manager man) {
		//setTitle();
		super("Home");
		setBounds(50, 50, 600, 600);
		
		this.man=man;
		//this.emp=emp;
		//this.setVisible(true);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		upperPanel = new JPanel(new FlowLayout());
		upperPanel.setBorder(new LineBorder(Color.black, 1));
		upperPanel.setBounds(5, 5, 570, 40);
		add(upperPanel);
				

		lowerPanel = new JPanel(null);
		lowerPanel.setBorder(new TitledBorder(new LineBorder(Color.GREEN, 1),"Data"));
		lowerPanel.setBounds(5, 50, 570, 340);
		add(lowerPanel);
		
		this.AddUpperComponent();
		this.AddLowerComponent();
        //initComoponents();
	}
private void AddUpperComponent() {
		
		lblSearch = new JLabel("Search");
		upperPanel.add(lblSearch);
		
		txtSearch = new JTextField(10);
		upperPanel.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				populateTable();
			}
		});
		upperPanel.add(btnSearch);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				AddEmp a = new AddEmp();
				a.setVisible(true);
				
			}
		});
		upperPanel.add(btnAdd); 
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				EditEmp a = new EditEmp();
				a.setVisible(true);
				
			}
		});
		this.upperPanel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
         btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null,"confirm");
				String sql ="DELETE FROM employee WHERE id="+txtSearch.getText();
				//System.out.println(sql);
				
				try {
					da.state.executeUpdate(sql);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
	
         this.upperPanel.add(btnDelete);
         
         
         btnBack = new JButton("Back");
        
         btnBack.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// 
 				
 				//Manager manager=new Manager();
 				emp.dispose();
 				man.setVisible(true);
 				
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
	
	EmpTableModel model = new EmpTableModel(txtSearch.getText());
	
	tblUsers.setModel(model);
}

}


	
			


