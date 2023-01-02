package Transaction;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

import GELLERY.DataAccess;
import Manager.Manager;


public class Transaction extends JFrame {
	//private static final LayoutManager FlowLayout = null;
	private JButton backButton;
	private JLabel saleLabel;
	private static JTable tblUsers;
	private static JTextField txtSearch;
	private JPanel leftPanel;
	
	private DataAccess da;
	public ResultSet result=null;
	
	private Manager man;
	private Transaction tra=this;
	private JButton searchDateButton;
	private JLabel transactionTable;

	
	
	public Transaction(Manager man) {
	
		
		
		
		this.da=new DataAccess();
		this.man=man;
		
		setTitle("Transaction");
		setBounds(40, 40, 700, 600);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//this.recep=recep;
		
		leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 700, 600);
        leftPanel.setBackground(Color.cyan);
        leftPanel.setLayout(null);
        add(leftPanel);
        
        
        
        
        
        
       AddLeftComponents();
       //AddRightComponents();
       
	}

private void AddLeftComponents() {
	
	    transactionTable = new JLabel("Transaction Table:");
	    transactionTable.setBounds(5, 120, 300, 60);
	    transactionTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
	    leftPanel.add(	transactionTable);
		
        txtSearch = new JTextField(10);
        txtSearch.setBounds(400, 50, 100, 60);
        	
   		leftPanel.add(txtSearch);
   		
   		saleLabel = new JLabel("Enter a Date to see the sale:");
   		saleLabel.setBounds(300, 5, 300, 60);
   		saleLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
		leftPanel.add(	saleLabel);
		
   		
   		
   		   
   		searchDateButton =new JButton("Sale Date");
   		searchDateButton.setBounds(400, 130, 100, 60);
   		
   		searchDateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				populateTable();
			}
		});
   		leftPanel.add(searchDateButton);
   		
   		backButton =new JButton("back");
   		backButton.setBounds(10, 500, 100, 60);
   		backButton.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// 
 				
 				//Manager manager=new Manager();
 				tra.dispose();
 				man.setVisible(true);
 				
 				//setVisible(false);
 				
 			}
 		});
 		
         
   		
   		leftPanel.add(backButton);
   		 
   	     
   	        tblUsers = new JTable();
   			tblUsers.setBackground(Color.white);
   			//tblUsers.setRowHeight(70);
   			
   			JScrollPane sp = new JScrollPane();
   			sp.setBounds(5, 200, 600, 300);
   			this.leftPanel.add(sp);
   			sp.setViewportView(tblUsers);
   			
   			this.populateTable();
   		}

   		public static void populateTable() {
   			
   			TransactionTableModel model = new TransactionTableModel(txtSearch.getText());
   			
   			tblUsers.setModel(model);
   		}
		
	}
	
	
