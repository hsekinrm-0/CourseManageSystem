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

public class AddInstruct extends JFrame {
	private JPanel coursePanel;
	private JButton deletebutton;
	private JButton updatebutton;

	JComboBox moduleBox;
	JComboBox coursebox;
	JComboBox semBox;
	public String[] sembox = {"1", "2"};
	JComboBox levelBox;
	public String[] levelbox = { "4", "5", "6" };
	private JTextField teacherField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInstruct frame = new AddInstruct();
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
	public AddInstruct() {
		
		setTitle("View modules Instructor ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // get exit when x is pressed
		setBounds(100, 100, 850, 530);
		coursePanel = new JPanel();
		coursePanel.setFont(new Font("Arial", Font.PLAIN, 16));
		coursePanel.setBackground(new Color(255, 255, 255));
		coursePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(coursePanel);
		coursePanel.setLayout(null);
		this.setLocationRelativeTo(null); // center of the screen

		JPanel toPanel = new JPanel(); // top panel to frame
		toPanel.setBackground(new Color(153, 0, 51));
		toPanel.setBounds(0, 0, 836, 87);
		coursePanel.add(toPanel); // add to main pane
		toPanel.setLayout(null);

		JLabel titleName = new JLabel("Add Teacher"); // frame title name
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(320, 24, 244, 45);
		toPanel.add(titleName); // add to main pane
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));

		JLabel tableLabel = new JLabel("View Table");
		tableLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		tableLabel.setBounds(31, 97, 85, 13);
		coursePanel.add(tableLabel); // add to main pane

		// FORMING TABLE
		JTable table = new JTable();
		String[] columns = { "Teacher", "Course", "Level", "Semester", "Subject"}; 
				
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
		cm.getColumn(0).setPreferredWidth(90);
		cm.getColumn(1).setPreferredWidth(2);
		cm.getColumn(2).setPreferredWidth(2);
		cm.getColumn(3).setPreferredWidth(2);
		cm.getColumn(4).setPreferredWidth(250);
		
		// WHEN TABLE IS CLICKED
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tble = table.getSelectedRow();
				TableModel tModel = table.getModel();							
								
				
				//table data into respective field
				teacherField.setText(tModel.getValueAt(tble,0).toString()); //for module code       
				
				String level = tModel.getValueAt(tble,2).toString();//for level list
				for(int i=0; i < levelBox.getItemCount(); i++) {
					if(levelBox.getItemAt(i).toString().equalsIgnoreCase(level)) {
						levelBox.setSelectedIndex(i);
					}
				}
				
				String sems = tModel.getValueAt(tble,3).toString();//for semester list
				for(int i=0; i < semBox.getItemCount(); i++) {
					if(semBox.getItemAt(i).toString().equalsIgnoreCase(sems)) {
						semBox.setSelectedIndex(i);
					}
				}
				
				//----------COURSE LIST JComboBox
				String course = tModel.getValueAt(tble,1).toString();//for course list
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
				
				//---------SUBJECT LIST JComboBox
				String subjet = tModel.getValueAt(tble,4).toString();
				Connection conn;
				PreparedStatement pst;
				ResultSet rls;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					String msql = "select subject from addmodule";
					pst = conn.prepareStatement(msql);
					rls = pst.executeQuery();					
					while(rls.next()) {
							moduleBox.addItem(rls.getString("subject")); //retriving data from subject column from 	addmodule database						
					}
				}
				catch(Exception etq) {
					JOptionPane.showMessageDialog(null, "Could not upload subject");
				}
                for(int i=0; i < moduleBox.getItemCount(); i++) {
					
					if(moduleBox.getItemAt(i).toString().equalsIgnoreCase(subjet)) {
						moduleBox.setSelectedIndex(i);
					}
				}
								
			}
		});

		// TABLE SCROLL PANE
		JScrollPane ptable = new JScrollPane(table);
		ptable.setForeground(Color.GRAY);
		ptable.setBackground(Color.BLUE);
		ptable.setBounds(31, 117, 768, 139);
		coursePanel.add(ptable);
		
		//for sem label
		JLabel semLabel = new JLabel("Semester:");
		semLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		semLabel.setBounds(31, 353, 76, 13);
		coursePanel.add(semLabel);
		
        //TEacher name input
		JLabel teacher = new JLabel("Teacher name:");
		teacher.setFont(new Font("Arial", Font.PLAIN, 13));
		teacher.setBounds(31, 390, 95, 13);
		coursePanel.add(teacher);	
		
		//enter teacher name 
		teacherField = new JTextField();
		teacherField.setFont(new Font("Arial", Font.PLAIN, 12));
		teacherField.setBounds(131, 385, 286, 25);
		coursePanel.add(teacherField);
		teacherField.setColumns(10);		

		// for coursename label
		JLabel courseLabel = new JLabel("Course:");
		courseLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		courseLabel.setBounds(31, 316, 95, 22);
		coursePanel.add(courseLabel);
		
		//delete button for delecting column data
		deletebutton = new JButton("Delete");
		deletebutton.setBackground(Color.RED);
		deletebutton.setForeground(Color.BLACK);
		deletebutton.setFont(new Font("Arial", Font.PLAIN, 14));
		deletebutton.setBounds(495, 353, 86, 28); // parameters(x-axis,y-axis,length,height)
		coursePanel.add(deletebutton);

		//update button to panel
		updatebutton = new JButton("Update");		
		updatebutton.setBackground(Color.ORANGE);
		updatebutton.setForeground(Color.BLACK);
		updatebutton.setFont(new Font("Arial", Font.PLAIN, 14));
		updatebutton.setBounds(495, 317, 85, 28); // parameters(x-axis,y-axis,length,height)
		coursePanel.add(updatebutton);

		// add load button to panel
		JButton loadButton = new JButton("Load Data");
		loadButton.setForeground(Color.WHITE);
		loadButton.setFont(new Font("Arial", Font.PLAIN, 11));
		loadButton.setBackground(Color.GRAY);
		loadButton.setBounds(712, 282, 87, 21);
		coursePanel.add(loadButton);

		JLabel forlvl = new JLabel("For Level: ");
		forlvl.setFont(new Font("Arial", Font.PLAIN, 13));
		forlvl.setBounds(235, 319, 68, 19);
		coursePanel.add(forlvl);

		JLabel subj = new JLabel("Subject:");
		subj.setFont(new Font("Arial", Font.PLAIN, 14));
		subj.setBounds(31, 285, 62, 13);
		coursePanel.add(subj);

		coursebox = new JComboBox();		
		coursebox.setFont(new Font("Arial", Font.PLAIN, 13));
		coursebox.setBounds(131, 316, 75, 24);
		coursePanel.add(coursebox);					
		
		// make JComboBox for level 4,5,6
		levelBox = new JComboBox(levelbox);
		levelBox.setFont(new Font("Arial", Font.PLAIN, 12));
		levelBox.setBounds(302, 315, 42, 24);
		coursePanel.add(levelBox);
		
		semBox = new JComboBox(sembox);
		semBox.setFont(new Font("Arial", Font.PLAIN, 12));
		semBox.setBounds(131, 354, 76, 21);
		coursePanel.add(semBox);
		
		// add information button to column
		JButton addbutton = new JButton("Add");
		addbutton.setBackground(new Color(153, 255, 102));
		addbutton.setForeground(Color.BLACK);
		addbutton.setFont(new Font("Arial", Font.PLAIN, 14));
		addbutton.setBounds(495, 282, 85, 28);
		coursePanel.add(addbutton); // add to main pane
		
		JLabel actionLabel = new JLabel("Action:");
		actionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		actionLabel.setBounds(168, 450, 45, 19);
		coursePanel.add(actionLabel);
		
		//-----JCOMBO BOX TO ADD MODULES SUBJECT-----
		moduleBox = new JComboBox();
		moduleBox.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox.setBounds(131, 281, 323, 24);
		coursePanel.add(moduleBox);
		
		//for action message field
		JLabel lMessage = new JLabel("");
		lMessage.setFont(new Font("Arial", Font.BOLD, 14));
		lMessage.setBounds(223, 450, 243, 19);
		coursePanel.add(lMessage);
				
		// Back button		
		JButton backButton = new JButton("back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(714, 448, 85, 21);
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
				if (teacherField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please enter instructor name!!"); // show dialog message
					
					// clear textfield for re-enter data
					teacherField.setText("");
					
				} 
				else {					
					Connection con;
					PreparedStatement ps;
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
														
						String sql = "INSERT INTO teacher(`teacher_name`, `course`, `level`, `sem`, `subject`) values(?,?,?,?,?)"; // sql query to get data of courseID and coursename from database
						ps = con.prepareStatement(sql);
						
						ps.setString(1,teacherField.getText());
						ps.setString(2,(String)coursebox.getSelectedItem());
						ps.setString(3,(String)levelBox.getSelectedItem());						
						ps.setString(4,(String)semBox.getSelectedItem());
						ps.setString(5,(String)moduleBox.getSelectedItem());											
						
						// Returns an integer representing the number of rows affected by the SQL statement.						
						ps.executeUpdate();
						
						//show message if data added to database
						lMessage.setText("" + "<html>" + "<font color=\"green\">Data Inserted Successfully</font> " + "</html>");					
						
						con.close();
						
						//reset list and text field for next data entry
						teacherField.setText("");
						levelBox.setSelectedIndex(0);
						coursebox.setSelectedIndex(0);
						semBox.setSelectedIndex(0);
						moduleBox.setSelectedIndex(0);
						
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
					String sql = "select `teacher_name`, `course`, `level`, `sem`, `subject` from teacher"; // sql query to get data of required columns from database
					
					ps = con.prepareStatement(sql);					
					rs = ps.executeQuery();	
					DefaultTableModel tbmodel = (DefaultTableModel)table.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					// set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String tname = rs.getString("teacher_name"); //"teacher_name" is the database column
						String cou = rs.getString("course");
						String lev = rs.getString("level");										
						String sm = rs.getString("sem");
						String sub = rs.getString("subject");			                
						
						String tableD[] = {tname, cou, lev, sm, sub};						
						tbmodel.addRow(tableD);							
					}
					con.close();
					rs.close();	
					
					
					//show message if data added to database
					lMessage.setText("" + "<html>" + "<font color=\"blue\">Data LOADED</font> " + "</html>");

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
					int row = table.getSelectedRow();
					String value = (table.getModel().getValueAt(row, 0).toString());
					String sql = "UPDATE teacher SET course=?, level=?, sem=?, subject=? where teacher_name = '"+teacherField.getText()+"' "; // sql query to get data of required columns from database
					
					ps = con.prepareStatement(sql);
					ps.setString(1,(String)coursebox.getSelectedItem());						
					ps.setString(2,(String)levelBox.getSelectedItem());					
					ps.setString(3,(String)semBox.getSelectedItem());
					ps.setString(4,(String)moduleBox.getSelectedItem());			
					
					// Returns an integer representing the number of rows affected by the SQL statement.						
					ps.executeUpdate();								
					
					con.close();
					
					//reset list and text field for next data entry
					levelBox.setSelectedIndex(0);
					coursebox.setSelectedIndex(0);
					semBox.setSelectedIndex(0);
					moduleBox.setSelectedIndex(0);

					//show message if data added to database
					lMessage.setText("" + "<html>" + "<font color=\"ORANGE\">DATA UPDATED SUCCESSFULLY</font> " + "</html>");
					}

				catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}
			}
		});
		
		//FOR MODULE SUBJECT TO ENTER USING DROP JCOMBO BOX
				moduleBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Connection con;
						PreparedStatement ps;
						ResultSet rs;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
							String sql = "select subject from addmodule";
							ps = con.prepareStatement(sql);
							rs = ps.executeQuery();					
							while(rs.next()) {
								moduleBox.addItem(rs.getString("subject")); //add fetch data from subject column of addmodule database into JCombobox		 					
							}
						}
						catch(Exception eq) {
							JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
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
						String sql = "delete from teacher where teacher_name = ?"; // sql query to get data of courseID and
																				// coursename from database
						ps = con.prepareStatement(sql); // to write the SQL command and the user-provided data
														// separately
						ps.setString(1, teacherField.getText()); // to set string value at the given parameter index.

						ps.executeUpdate(); // to create, drop, insert, update, delete and it returns int type.
						
						//reset list and text field for next data entry
						teacherField.setText("");
						levelBox.setSelectedIndex(0);
						coursebox.setSelectedIndex(0);
						semBox.setSelectedIndex(0);
						moduleBox.setSelectedIndex(0);
						
						//show message if data added to database
						lMessage.setText("" + "<html>" + "<font color=\"red\">Deleted Successfully</font> " + "</html>");						

						con.close(); // connection closed
					} catch (Exception ee) {
						JOptionPane.showMessageDialog(null, "Delected Unsuccessful");
					}
				}
		});

	}
}
