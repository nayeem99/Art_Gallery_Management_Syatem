import javax.swing.JFrame;


public class Home extends JFrame{
	private DataAccess da;
	
	public Home(DataAccess da){
		super("Home");
		this.setLocation(50, 50);
		this.setSize(600, 600);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.da = da;
	}
}







