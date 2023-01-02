package Receptionist;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;


import Artstock.*;
import GELLERY.CurrentDateTime;
import GELLERY.DataAccess;
import Transaction.Transaction;


class SellArts extends JFrame {
	//private static final LayoutManager FlowLayout = null;
    private JButton confirmButton;
	private JButton backButton;
	private JTextField artsId, customerId,price,customerName,customerMobileno;
	private static JTextField txtSearch1;
	private JLabel labelName,labelMobileNo;
	private JPanel panelSellArts;
	private Receptionist recep;
	private SellArts sellArts=this;
	private JButton customerIdButton,artsIdButton;
	private static JTable tblUsers;
	private static JTable tblUsers1;
	CurrentDateTime date;
	private static JTextField txtSearch;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private DataAccess da;
	public ResultSet result=null;
	String fn="price";
	String a="personid";
	String b="mobileno";
	private JLabel labelArtTable;
	private JLabel labelArtId;
	private JLabel labelPrice;
	private JLabel labelCustomerId;
	private JButton buyButton;
	private JTextField addCart;
	private JButton addButton;
	private JTable tblUsers2;
	private JLabel priceLabel;
	private JLabel cartLabel;
	private JLabel customerLabel;
	private JLabel customerNameLabel;
	private JLabel customerNLabel;
	private JLabel labelCustomerTable;
	private JLabel labelCartTable;
	private static ArrayList<ArtsUser> users = new ArrayList<ArtsUser>();
	
	

	public SellArts(Receptionist recep) {
		
		
		this.da=new DataAccess();
		
		
		setTitle("Login SellArts");
		setBounds(40, 40, 1100, 900);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.recep=recep;
		
		leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 550, 900);
        leftPanel.setBackground(Color.cyan);
        leftPanel.setLayout(null);
        add(leftPanel);
        
        rightPanel = new JPanel();
        rightPanel.setBounds(550, 0, 600, 900);
        rightPanel.setBackground(Color.white);
        rightPanel.setLayout(null);
        add(rightPanel);
        
        
        
        
       AddLeftComponents();
       AddRightComponents();
       
	}
	
	 private void AddRightComponents() {
		 
		 
		    txtSearch1 = new JTextField(10);
		    rightPanel.add(txtSearch1);
		    
	        tblUsers1 = new JTable();
			tblUsers1.setBackground(Color.white);
			
			JScrollPane sp = new JScrollPane();
			sp.setBounds(5, 80, 490, 250);
			rightPanel.add(sp);
			sp.setViewportView(tblUsers1);
			
			//Label
			labelCustomerTable=new JLabel("Customer Table:");
			labelCustomerTable.setBounds(20,5,300,60);
			labelCustomerTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			rightPanel.add(labelCustomerTable);
			
			
			labelArtTable=new JLabel("Arts Stock Table:");
			labelArtTable.setBounds(20,5,300,60);
			labelArtTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			leftPanel.add(labelArtTable);
			
			tblUsers2 = new JTable();
			tblUsers2.setBackground(Color.white);
			
			JScrollPane sp2 = new JScrollPane();
			sp2.setBounds(5, 500, 490, 250);
			sp2.setViewportView(tblUsers2);
			this.leftPanel.add(sp2);
			
			
			labelCartTable=new JLabel("Cart Table:");
			labelCartTable.setBounds(20,450,300,60);
			labelCartTable.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			leftPanel.add(labelCartTable);
			
			
			
			
			
			
			customerLabel=new JLabel("Enter Customer Id:");
			customerLabel.setBounds(300, 450, 180, 40);
			customerLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			rightPanel.add(customerLabel);
			
			customerId = new JTextField();
			customerId.setBounds(300, 500, 180, 40);
			customerId.setToolTipText("Please Enter customerId");
			rightPanel.add(customerId);
			
			
			
			priceLabel=new JLabel("totall price:");
			priceLabel.setBounds(60, 550, 180, 40);
			priceLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			rightPanel.add(priceLabel);
			
			price = new JTextField();
			price.setBounds(60, 600, 180, 40);
			price.setToolTipText("price");
			rightPanel.add(price);
			
			
			
			customerNameLabel=new JLabel("Customer Name:");
			customerNameLabel.setBounds(300, 550, 180, 40);
			customerNameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			rightPanel.add(customerNameLabel);
			
			customerName = new JTextField();
			customerName.setBounds(300, 600, 180, 40);
			//customerName.setToolTipText("price");
			rightPanel.add(customerName);
			
			
			customerNLabel=new JLabel("Customer MobileNo:");
			customerNLabel.setBounds(300, 650, 180, 40);
			customerNLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			rightPanel.add(customerNLabel);
			
			customerMobileno = new JTextField();
			customerMobileno.setBounds(300, 700, 180, 40);
			//customerName.setToolTipText("price");
			rightPanel.add(customerMobileno);
			
			
			cartLabel=new JLabel("Add to Cart:");
			cartLabel.setBounds(60, 450, 180, 40);
			cartLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN,20));
			rightPanel.add(cartLabel);
			

			addCart = new JTextField();
			addCart.setBounds(60, 500, 180, 40);
			addCart.setToolTipText("cart");
			rightPanel.add(addCart);
			
			
			addButton =new JButton("Addcart");
			addButton.setBounds(100, 400, 80, 40);
			addButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
                   String sql ="SELECT * FROM arts WHERE id="+addCart.getText() ;
					
					
					try {
						result=da.state.executeQuery(sql);
						if(result.next()){
							ArtsUser art=new ArtsUser();
							art.id=result.getInt("id");
							art.type=result.getString("type");
							art.price=result.getInt("price");
							art.input_date=result.getString("input_date");
							System.out.println(art);
							users.add(art);
							UsersTableModel model1=new UsersTableModel("");
							model1.addItems(users);
							tblUsers2.setModel(model1);
							int amount=0;
							for(int i=0;i<users.size();i++) {
								amount+=users.get(i).price;
							}
							price.setText(Integer.toString(amount));
						}else {
														
						}
						
					
				}catch(Exception exc) {
					
				}
					
					
				}
			});
			rightPanel.add(addButton);
			
			
			
			
			
			
			backButton =new JButton("back");
			backButton.setBounds(150, 780, 80, 60);
			backButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					// TODO Auto-generated method stub
					sellArts.dispose();
					recep.setVisible(true);
					
					
					
				}
			});
			
			rightPanel.add(backButton);
			
			
			

			customerIdButton =new JButton("Add");
			customerIdButton.setBounds(300, 400, 80, 40);
			customerIdButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String sql ="SELECT personid,name,mobileno FROM customer WHERE personid="+customerId.getText();
					try {
						result=da.state.executeQuery(sql);
						//String s = result.getString("price");
						//int p   = result.getInt(1);
						//result.getInt("price");
						if(result.next()) {
							customerId.setText(result.getString("personid"));
							customerName.setText(result.getString("name"));
							customerMobileno.setText(result.getString("mobileno"));
							
						}else {
							
						}
						
					
				}catch(Exception exc) {
					
				}
					
				}
			});
			
			rightPanel.add(customerIdButton);
			
			
			
			confirmButton =new JButton("Confirm");
			confirmButton.setBounds(60, 700, 80, 60);
			confirmButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				
					JOptionPane.showMessageDialog(null, "Confirm");
					try {
						int i=0;
						while (i<users.size()) {
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
							LocalDateTime now = LocalDateTime.now();
							String sql = "INSERT INTO transaction VALUES (" + users.get(i).id + "," + users.get(i).price
									+ "," + customerId.getText() + ",'" + customerName.getText() + "',"
									+ customerMobileno.getText() + ",'" + dtf.format(now) + "')";

							DataAccess d = new DataAccess();
							d.insert(sql);
							//d.insert(sql1);
							Transaction.populateTable();
							i++;
						}
					}catch(Exception ex){
						
					}
					
					
				}
			});
			
			rightPanel.add(confirmButton);
			
			buyButton =new JButton("Buy");
			buyButton.setBounds(150, 700, 80, 60);
			
			buyButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,"confirm");
					int t=0;
					while (t<users.size()) {
						String sql = "DELETE FROM arts WHERE id=" + users.get(t).id;
						//System.out.println(sql);
						t++;

						try {
							da.state.executeUpdate(sql);

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
					
				
					
				}
				
			});
			
			rightPanel.add(buyButton);
			
			
			
			
			
			
			
			SellArts.populateTable1();
		}

		public static void populateTable1() {
			
			CustomerTableModel model = new CustomerTableModel(txtSearch1.getText());
			
			tblUsers1.setModel(model);
		}
		
		 
		 
		 
		
		
	
	public void AddLeftComponents() {
		
		
		
		
		
		
		
		
		
		
		 
		// confirmButton = new JButton("con");
		// confirmButton.setBounds(12, 12, 111, 222);
	     //leftPanel.add(confirmButton);
		 
		    txtSearch = new JTextField(10);
		    leftPanel.add(txtSearch);
	
	        tblUsers = new JTable();
			tblUsers.setBackground(Color.white);
			
			JScrollPane sp = new JScrollPane();
			sp.setBounds(5, 80, 490, 250);
			this.leftPanel.add(sp);
			sp.setViewportView(tblUsers);
			
			
			
			
			SellArts.populateTable();
		}

		public static void populateTable() {
			
			UsersTableModel model = new UsersTableModel(txtSearch.getText());
			
			tblUsers.setModel(model);
		}		
	
		
		
		
		
		
		
		
}





//datetimepicker
//stdefultop null
//gridlayout
