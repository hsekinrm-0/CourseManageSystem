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

public class TyearModule extends JFrame {

	private JPanel firstPanel;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TyearModule frame = new TyearModule();
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
	public TyearModule() {
		setTitle("3rd Year Module ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		firstPanel = new JPanel();
		firstPanel.setBackground(new Color(255, 255, 255));
		firstPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(firstPanel);
		firstPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel titlename = new JLabel("3rd Year Modules Subject");
		titlename.setBounds(205, 29, 310, 26);
		firstPanel.add(titlename);
		titlename.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JPanel toPane = new JPanel();
		toPane.setBackground(new Color(153, 255, 102));
		toPane.setBounds(0, 0, 686, 79);
		firstPanel.add(toPane);
		toPane.setLayout(null);
		this.setLocationRelativeTo(null);
		
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
		panetable.setBounds(94, 158, 496, 167);
		firstPanel.add(panetable);
		
		// SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(20);
		cm.getColumn(1).setPreferredWidth(120);
		
				
		JButton backButton = new JButton("back");		
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
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
					String sql = "SELECT module_code, module_name FROM addmodule WHERE level='6' AND sem='1'"; // sql query to get data of required columns from database
				
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
		viewButton.setBounds(94, 347, 65, 21);
		firstPanel.add(viewButton);

		
		
		//ACtion Listener
		
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
