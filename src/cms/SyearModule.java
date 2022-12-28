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

public class SyearModule extends JFrame {

	private JPanel firstPanel;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SyearModule frame = new SyearModule();
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
	public SyearModule() {
		setTitle("2nd Year Module ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		firstPanel = new JPanel();
		firstPanel.setBackground(new Color(255, 255, 255));
		firstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(firstPanel);
		firstPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel titlename = new JLabel("2nd Year Modules Subject");
		titlename.setBounds(205, 29, 310, 26);
		firstPanel.add(titlename);
		titlename.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JPanel toPane = new JPanel();
		toPane.setBackground(new Color(153, 255, 102));
		toPane.setBounds(0, 0, 686, 79);
		firstPanel.add(toPane);
		toPane.setLayout(null);
		this.setLocationRelativeTo(null);	
		
		
		JLabel firstSem = new JLabel("First Semester : ");
		firstSem.setFont(new Font("Arial", Font.PLAIN, 16));
		firstSem.setBounds(68, 100, 126, 26);
		firstPanel.add(firstSem);	
		
		JLabel secondSem = new JLabel("Second Semester : ");
		secondSem.setFont(new Font("Arial", Font.PLAIN, 16));
		secondSem.setBounds(60, 282, 203, 26);
		firstPanel.add(secondSem);
		
		//CREATING TABLE
		JTable table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean click = table.isEditing();
				if(click==false) {
					JOptionPane.showMessageDialog(null, "You can only view this table.(ONLY ACCESS TO INSTRUCTOR!!!)");
				}
			}
		});
		table.setBounds(32, 136, 272, 278);
		Object[] columns = {"Module code", "Module name"};
		
		DefaultTableModel tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columns); //set columns for the table
		table.setModel(tmodel);
		
		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		firstPanel.add(table);
		
		// WHEN TABLE IS CLICKED
		JScrollPane panetable = new JScrollPane(table);		
		panetable.setForeground(Color.GRAY);
		panetable.setBackground(Color.BLUE);
		panetable.setBounds(67, 136, 467, 131);
		firstPanel.add(panetable);
		
		// SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(20);
		cm.getColumn(1).setPreferredWidth(120);
		
		JTable sptable = new JTable();
		sptable.setBounds(343, 136, 314, 278);
		Object[] columns1 = {"Module code", "Module name"};
		DefaultTableModel stmodel = new DefaultTableModel();
		stmodel.setColumnIdentifiers(columns1); //set columns for the table
		sptable.setModel(tmodel);
		sptable.setSelectionBackground(Color.WHITE);
		sptable.setSelectionForeground(Color.BLUE);
		sptable.setFont(new Font("Arial", Font.PLAIN, 13));
		sptable.setRowHeight(20);
		sptable.setAutoCreateRowSorter(true);
		firstPanel.add(sptable);
		
		JScrollPane spanetable = new JScrollPane(sptable);
		spanetable.setForeground(Color.GRAY);
		spanetable.setBackground(Color.BLUE);
		spanetable.setBounds(60, 315, 474, 131);
		firstPanel.add(spanetable);
		
		//SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel scm = sptable.getColumnModel();
		scm.getColumn(0).setPreferredWidth(2);
		scm.getColumn(1).setPreferredWidth(185);
		
		//WHEN TABLE IS CLICKED
		sptable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			boolean click = sptable.isEditing();
				if(click==false) {
					JOptionPane.showMessageDialog(null, "You can only view this table");
				}
			}
		});
		
		JButton backButton = new JButton("back");		
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
		firstPanel.add(backButton);
		
		JButton viewButton = new JButton("View ");		
		viewButton.setFont(new Font("Arial", Font.PLAIN, 10));		
		viewButton.setBounds(585, 136, 65, 21);
		firstPanel.add(viewButton);
		
		JButton sViewButton = new JButton("View");		
		sViewButton.setBounds(583, 315, 74, 21);
		firstPanel.add(sViewButton);

		
		
		//ACtion Listener
		
		//FOr 1st sem display
		viewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				ResultSet rs;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();																						 
					String sql = "SELECT module_code, module_name FROM addmodule WHERE level='5' AND sem='1'"; // sql query to get data of required columns from database
				
					ps = con.prepareStatement(sql);					
					rs = ps.executeQuery();	
					DefaultTableModel tbmodel = (DefaultTableModel)table.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					// set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String oldcode = rs.getString("module_code"); //"mcode" is the database column
						String moAdd = rs.getString("module_name");									                
						
						String tableD[] = {oldcode, moAdd};						
						tbmodel.addRow(tableD);							
					}
					con.close();
					rs.close();			
					
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}				
			}
		});
		
		//For second sem display
		sViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				ResultSet rs;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();																						 
					String sql = "SELECT module_code, module_name FROM addmodule WHERE level='5' AND sem='2'"; // sql query to get data of required columns from database
				
					ps = con.prepareStatement(sql);					
					rs = ps.executeQuery();	
					DefaultTableModel tbmodel = (DefaultTableModel)sptable.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					// set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String code = rs.getString("module_code"); //"mcode" is the database column
						String add = rs.getString("module_name");									                
						
						String tablec[] = {code, add};						
						tbmodel.addRow(tablec);							
					}
					con.close();
					rs.close();			
					
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}			
			}
		});
		
		//this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewModule vm = new ViewModule();
				vm.setVisible(true);
					}
				});	
	}
}
