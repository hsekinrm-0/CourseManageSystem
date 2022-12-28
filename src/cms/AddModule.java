package cms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import net.proteanit.sql.*;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class AddModule extends JFrame {

	private JPanel coursePanel;
	public JTextField moAdd;
	public JTextField addcomo;
	private JButton deletebutton;
	private JButton updatebutton;
    JComboBox levelBox;
	JComboBox coursebox;
	public String[] levelbox = { "4", "5", "6" };
	public String[] columnbox = {};
	public JRadioButton firstsem,secondsem; 
	ButtonGroup sem;	
	private JTextField oldcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddModule frame = new AddModule();
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
	public AddModule() {
		
		setTitle("View modules Instructor ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // get exit when x is pressed
		setBounds(100, 100, 700, 530);
		coursePanel = new JPanel();
		coursePanel.setFont(new Font("Arial", Font.PLAIN, 16));
		coursePanel.setBackground(new Color(255, 255, 255));
		coursePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(coursePanel);
		coursePanel.setLayout(null);
		this.setLocationRelativeTo(null); // center of the screen

		JPanel toPanel = new JPanel(); // top panel to frame
		toPanel.setBackground(new Color(153, 0, 51));
		toPanel.setBounds(0, 0, 686, 87);
		coursePanel.add(toPanel); // add to main pane
		toPanel.setLayout(null);

		JLabel titleName = new JLabel("Module"); // frame title name
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(267, 21, 184, 45);
		toPanel.add(titleName); // add to main pane
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));

		JLabel tableLabel = new JLabel("View Table");
		tableLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		tableLabel.setBounds(51, 97, 85, 13);
		coursePanel.add(tableLabel); // add to main pane

		// FORMING TABLE
		JTable table = new JTable();
		String[] columns = {"Module ID", "Module name", "level", "Semester", "Course"}; 
				
		DefaultTableModel tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columns); // set columns for the table		
		table.setModel(tmodel);	
				
				
		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		coursePanel.add(table); // add to main pane

		// SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(2);
		cm.getColumn(1).setPreferredWidth(200);
		cm.getColumn(2).setPreferredWidth(5);
		cm.getColumn(3).setPreferredWidth(5);
		cm.getColumn(4).setPreferredWidth(5);
		
		// WHEN TABLE IS CLICKED
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tble = table.getSelectedRow();
				TableModel tModel = table.getModel();			
								
				//show old module code if table is clicked
				oldcode = new JTextField();
				oldcode.setBounds(557, 350, 96, 19);
				coursePanel.add(oldcode);
				oldcode.setColumns(10);					
				
				//table data into respective field
				oldcode.setText(tModel.getValueAt(tble,0).toString()); //for module code       
				
				String level = tModel.getValueAt(tble,2).toString();//for level list
				for(int i=0; i < levelBox.getItemCount(); i++) {
					if(levelBox.getItemAt(i).toString().equalsIgnoreCase(level)) {
						levelBox.setSelectedIndex(i);
					}
				}						
				
				String course = tModel.getValueAt(tble,4).toString();//for course list
				Connection con;
				PreparedStatement ps;
				ResultSet rs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					String sql = "select coursename from course";
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();					
					while(rs.next()) {
							coursebox.addItem(rs.getString("coursename"));							
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course");
				}
				for(int i=0; i < coursebox.getItemCount(); i++) {
					
					if(coursebox.getItemAt(i).toString().equalsIgnoreCase(course)) {
						coursebox.setSelectedIndex(i);
					}
				}
				
				moAdd.setText(tModel.getValueAt(tble,1).toString()); //for module name to show on textfield if table is selected 				
			}
		});

		// TABLE SCROLL PANE
		JScrollPane ptable = new JScrollPane(table);
		ptable.setForeground(Color.GRAY);
		ptable.setBackground(Color.BLUE);
		ptable.setBounds(46, 117, 596, 139);
		coursePanel.add(ptable);

		// for course Id label
		JLabel moid = new JLabel("Module code:");
		moid.setFont(new Font("Arial", Font.PLAIN, 14));
		moid.setBounds(46, 282, 110, 19);
		coursePanel.add(moid); // add to main pane

		// for course ID add field
		addcomo = new JTextField();
		addcomo.setFont(new Font("Arial", Font.PLAIN, 14));
		addcomo.setBounds(166, 282, 110, 23);
		coursePanel.add(addcomo); // add to main pane
		addcomo.setColumns(10);
		
		//for sem label
		JLabel semLabel = new JLabel("Semester:");
		semLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		semLabel.setBounds(46, 316, 76, 13);
		coursePanel.add(semLabel);
		
		JRadioButton firstsem = new JRadioButton("1");
		firstsem.setBackground(Color.WHITE);
		firstsem.setFont(new Font("Arial", Font.PLAIN, 14));
		firstsem.setBounds(158, 312, 33, 21);
		coursePanel.add(firstsem);
		
		JRadioButton secondsem = new JRadioButton("2");
		secondsem.setBackground(Color.WHITE);
		secondsem.setFont(new Font("Arial", Font.PLAIN, 14));
		secondsem.setBounds(190, 312, 42, 21);
		coursePanel.add(secondsem);
		
		sem = new ButtonGroup(); //adding firstsem and secondsem for radio button 
		sem.add(firstsem);
		sem.add(secondsem);			

		// for coursename label
		JLabel moName = new JLabel("Module name:");
		moName.setFont(new Font("Arial", Font.PLAIN, 14));
		moName.setBounds(46, 341, 95, 27);
		coursePanel.add(moName); // add to main pane

		// to add course name field
		moAdd = new JTextField();
		moAdd.setFont(new Font("Arial", Font.PLAIN, 14));
		moAdd.setBounds(158, 341, 281, 28);
		coursePanel.add(moAdd); // add to main pane
		moAdd.setColumns(10);

		// make JComboBox for level 4,5,6
		levelBox = new JComboBox(levelbox);
		levelBox.setBounds(385, 278, 42, 21);
		coursePanel.add(levelBox);
		
		//delete button for delecting column data
		deletebutton = new JButton("Delete");
		deletebutton.setBackground(Color.RED);
		deletebutton.setForeground(Color.BLACK);
		deletebutton.setFont(new Font("Arial", Font.PLAIN, 14));
		deletebutton.setBounds(364, 393, 76, 28); // parameters(x-axis,y-axis,length,height)
		coursePanel.add(deletebutton);

		//update button to panel
		updatebutton = new JButton("Update");		
		updatebutton.setBackground(Color.ORANGE);
		updatebutton.setForeground(Color.BLACK);
		updatebutton.setFont(new Font("Arial", Font.PLAIN, 14));
		updatebutton.setBounds(254, 393, 85, 28); // parameters(x-axis,y-axis,length,height)
		coursePanel.add(updatebutton);

		// add load button to panel
		JButton loadButton = new JButton("Load Data");
		loadButton.setForeground(Color.WHITE);
		loadButton.setFont(new Font("Arial", Font.PLAIN, 11));
		loadButton.setBackground(Color.GRAY);
		loadButton.setBounds(557, 266, 87, 21);
		coursePanel.add(loadButton);

		JLabel forlvl = new JLabel("For Level: ");
		forlvl.setFont(new Font("Arial", Font.PLAIN, 13));
		forlvl.setBounds(295, 278, 68, 19);
		coursePanel.add(forlvl);

		JLabel lblNewLabel = new JLabel("For Course:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(295, 313, 85, 13);
		coursePanel.add(lblNewLabel);

		coursebox = new JComboBox();		
		coursebox.setBounds(385, 309, 74, 21);
		coursePanel.add(coursebox);					

		// add information button to column
		JButton addbutton = new JButton("Add");
		addbutton.setBackground(new Color(153, 255, 102));
		addbutton.setForeground(Color.BLACK);
		addbutton.setFont(new Font("Arial", Font.PLAIN, 14));
		addbutton.setBounds(158, 393, 74, 28);
		coursePanel.add(addbutton); // add to main pane
		
		JLabel actionLabel = new JLabel("Action:");
		actionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		actionLabel.setBounds(46, 450, 45, 19);
		coursePanel.add(actionLabel);
		
		//for action message field
		JLabel lMessage = new JLabel("");
		lMessage.setFont(new Font("Arial", Font.BOLD, 14));
		lMessage.setBounds(98, 449, 243, 19);
		coursePanel.add(lMessage);
		
		JLabel oldmLabel = new JLabel("Old Module id:");
		oldmLabel.setFont(new Font("Arial", Font.PLAIN, 10));
		oldmLabel.setBounds(557, 337, 76, 13);
		coursePanel.add(oldmLabel);
				
		// Back button		
		JButton backButton = new JButton("back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
		coursePanel.add(backButton);
		
		
		
		
		
		
		// ---------------------------------------ACTION LISTENER----------------------------------------------------

		// this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // close the current frame to overcome opening many frame
				AdminHome ah = new AdminHome();
				ah.setVisible(true); // open TeacherDashboard frame
			}
		});

		// add data into the SQL database
		addbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {

				// if the field is submitted empty then show message
				if (moAdd.getText().equals("") || addcomo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter ALL DATA !!"); // show dialog message
					
					// clear textfield for re-enter data
					moAdd.setText("");
					addcomo.setText("");
					
				} 
				else {					
					Connection con;
					PreparedStatement ps;
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
														
						String sql = "INSERT INTO `addmodule`(`course`, `level`, `sem`, `module_code`, `module_name`, `subject`) values(?,?,?,?,?,?)"; // sql query to get data of courseID and coursename from database
						String g ="";		            
		            	if(firstsem.isSelected()) {
		            		g+=firstsem.getText();
		            	}
		            	else if(secondsem.isSelected()) {
		            		g+=secondsem.getText();
		            	}
						ps = con.prepareStatement(sql);
						ps.setString(1,(String)coursebox.getSelectedItem());
						ps.setString(2,(String)levelBox.getSelectedItem());						
						ps.setString(3,g);						
						ps.setString(4,addcomo.getText());
						ps.setString(5,moAdd.getText());
						
						//concat module code and name in a variable to inseert into subject column
						String moCode = addcomo.getText();
						String moName = moAdd.getText();						       
						String add = moCode.concat(" - "+ moName);  						
						ps.setString(6,add);
//						ps.setString(ABORT, add)
						
						
						// Returns an integer representing the number of rows affected by the SQL statement.						
						ps.executeUpdate();
						
						//show message if data added to database
						lMessage.setText("" + "<html>" + "<font color=\"green\">Data Inserted Successfully</font> " + "</html>");					
						
						con.close();
						
						//reset list and text field for next data entry
						addcomo.setText("");
						levelBox.setSelectedIndex(0);
						coursebox.setSelectedIndex(0);
						moAdd.setText("");
						sem.setSelected(null, false);

					} catch (Exception e3) {
						//System.out.print(e3);
						JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect				   
				}
			  }
			}
		 });

		// if JCombobox is clicked, show course from another database to here		
		coursebox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Connection con;
				PreparedStatement ps;
				ResultSet rs;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					String sql = "select coursename from course";
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();	
					
					while(rs.next()) {
							coursebox.addItem(rs.getString("coursename")); //add data into coursebox		 					
					}					
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
				}
			 }
		});

		//add data from addmodule database to Jatable 
		loadButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				ResultSet rs;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();																						 
					String sql = "select id, module_code, module_name, course, level, sem from addmodule"; // sql query to get data of required columns from database
					
					ps = con.prepareStatement(sql);					
					rs = ps.executeQuery();	
					DefaultTableModel tbmodel = (DefaultTableModel)table.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					// set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String oldcode = rs.getString("module_code"); //"mcode" is the database column
						String moAdd = rs.getString("module_name");
						String levelBox = rs.getString("level");										
						String sem = rs.getString("sem");
						String coursebox = rs.getString("course");
						
						String text = addcomo.toString() + coursebox.toString();			                
						
						String tableD[] = {oldcode, moAdd, levelBox, sem, coursebox};						
						tbmodel.addRow(tableD);							
					}
					con.close();
					rs.close();	
					
					
					//show message if data added to database
					lMessage.setText("" + "<html>" + "<font color=\"blue\">DATA LOADED</font> " + "</html>");

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}				
			}

		});
		
		updatebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();
					String sql = "UPDATE addmodule SET module_code=?,module_name=?, level=?, sem=?, course=?, subject=? where module_code = '"+oldcode.getText()+"' "; // sql query to get data of required columns from database
									
					String g ="";		            
	            	if(firstsem.isSelected()) {
	            		g+=firstsem.getText();
	            	}
	            	else if(secondsem.isSelected()) {
	            		g+=secondsem.getText();
	            	}
					ps = con.prepareStatement(sql);
					ps.setString(1,addcomo.getText());
					ps.setString(2,moAdd.getText());
					ps.setString(3,(String)levelBox.getSelectedItem());						
					ps.setString(4,g);
					ps.setString(5,(String)coursebox.getSelectedItem());								
									
					//concat module code and name in a variable to inseert into subject column
					String moCode = addcomo.getText();
					String moName = moAdd.getText();						       
					String add = moCode.concat(" - "+ moName);  						
					ps.setString(6,add);
					
					
					// Returns an integer representing the number of rows affected by the SQL statement.						
					ps.executeUpdate();
					
					//reset list and text field for next data entry
					addcomo.setText("");
					levelBox.setSelectedIndex(0);
					coursebox.setSelectedIndex(0);
					moAdd.setText("");
					firstsem.setSelected(false);
					secondsem.setSelected(false);

					//show message if data added to database
					lMessage.setText("" + "<html>" + "<font color=\"ORANGE\">DATA UPDATE SUCCESSFULLY</font> " + "</html>");
					con.close();
					}

				catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}
			}
		});
		
		
		// when delete button is clicked, delete rows of ID
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Connection con;
					PreparedStatement ps;
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
						// delete from course database if courseID is given
						String sql = "delete from addmodule where module_code = ?"; // sql query to get data of courseID and
																				// coursename from database
						ps = con.prepareStatement(sql); // to write the SQL command and the user-provided data
														// separately
						ps.setString(1, oldcode.getText()); // to set string value at the given parameter index.

						ps.executeUpdate(); // to create, drop, insert, update, delete and it returns int type.
						
						//reset list and text field for next data entry
						oldcode.setText("");
						levelBox.setSelectedIndex(0);
						coursebox.setSelectedIndex(0);
						moAdd.setText("");
						firstsem.setSelected(false);
						secondsem.setSelected(false);
						
						//show message if data added to database
						lMessage.setText("" + "<html>" + "<font color=\"red\">DELECTED SUCCESSFULLY</font> " + "</html>");						

						con.close(); // connection closed
					} catch (Exception ee) {
						JOptionPane.showMessageDialog(null, "Delected Unsuccessful");
					}
				}
		});

	}
}
