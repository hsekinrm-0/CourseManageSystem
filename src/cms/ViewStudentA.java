package cms;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewStudentA extends JFrame {

	private JPanel firstPanel;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentA frame = new ViewStudentA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewStudentA() {
		setTitle("Student Register on your module");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //get exit when x is pressed
		setBounds(100, 100, 800, 530);
		firstPanel = new JPanel();
		firstPanel.setBackground(new Color(255, 255, 255));
		firstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(firstPanel);
		firstPanel.setLayout(null);
		this.setLocationRelativeTo(null); //center of the screen 
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(153, 0, 51));
		topPanel.setBounds(0, 0, 786, 87);
		firstPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel titleName = new JLabel("Student Registered ");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(249, 21, 336, 45);
		topPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));
		
		//CREATING TABLE
		JTable table = new JTable();
		table.setBounds(32, 136, 272, 278);
		Object[] columns = {"First_Name", "Last_Name", "Gender", "Course", "Father's_name", "e-mail", "Address", "GPA"};
		
		DefaultTableModel tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columns); //set columns for the table
		table.setModel(tmodel);
		
		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		firstPanel.add(table);
	
		// SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(50);
		cm.getColumn(1).setPreferredWidth(50);
		cm.getColumn(2).setPreferredWidth(2);
		cm.getColumn(3).setPreferredWidth(3);
		cm.getColumn(4).setPreferredWidth(60);
		cm.getColumn(5).setPreferredWidth(80);
		cm.getColumn(6).setPreferredWidth(60);
		cm.getColumn(7).setPreferredWidth(8);
		
		// WHEN TABLE IS CLICKED
		JScrollPane panetable = new JScrollPane(table);		
		panetable.setForeground(Color.GRAY);
		panetable.setBackground(Color.BLUE);
		panetable.setBounds(26, 115, 728, 215);
		firstPanel.add(panetable);
				
		JButton backButton = new JButton("back");		
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(669, 451, 85, 21);
		firstPanel.add(backButton);
		
		JButton viewButton = new JButton("View ");
		viewButton.setFont(new Font("Arial", Font.PLAIN, 10));
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				ResultSet rs;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();																						 
					String sql = "SELECT `firstName`, `lastName`, `sex`, `course`, `email`, `Address`, `password`, `gpa`, `father_name` FROM `register`"; // sql query to get data of required columns from database
				
					ps = con.prepareStatement(sql);					
					rs = ps.executeQuery();	
					DefaultTableModel tbmodel = (DefaultTableModel)table.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					// set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String fname = rs.getString("firstName"); //"mcode" is the database column
						String lname = rs.getString("lastname");
						String seex = rs.getString("sex");
						String coourse = rs.getString("course");
						String mail = rs.getString("email");
						String addr = rs.getString("Address");
						String cgpa = rs.getString("gpa");
						String ftname = rs.getString("father_name");
						
						String tableD[] = {fname,lname,seex,coourse,ftname,mail,addr,cgpa};	//making array string to put value into table 					
						tbmodel.addRow(tableD);							
					}
					con.close();
					rs.close();			
					
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}				
			}
		});
		viewButton.setBounds(26, 340, 85, 21);
		firstPanel.add(viewButton);

		
		
		//ACtion Listener
		
		//this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				AdminHome vm = new AdminHome();
				vm.setVisible(true);
					}
				});

		
	}
}
