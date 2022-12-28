package cms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
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

public class Course extends JFrame {

	private JPanel coursePanel;
	public JTextField coAdd;
	public JTextField addcoid;
	private JButton deletebutton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course frame = new Course();
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
	public Course() {
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

		JPanel toPanel = new JPanel(); //top panel to frame 
		toPanel.setBackground(new Color(153, 0, 51));
		toPanel.setBounds(0, 0, 686, 87);
		coursePanel.add(toPanel); //add to main pane
		toPanel.setLayout(null);

		JLabel titleName = new JLabel("COURSE"); //frame title name 
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(267, 21, 184, 45);
		toPanel.add(titleName); //add to main pane
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));

		JLabel tableLabel = new JLabel("View Table");
		tableLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		tableLabel.setBounds(51, 97, 85, 13);
		coursePanel.add(tableLabel); //add to main pane

		// FORMING TABLE
		JTable table = new JTable();
		Object[] columns = { "Course ID", "Course name" };
		DefaultTableModel tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columns); // set columns for the table
		table.setModel(tmodel);
		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		coursePanel.add(table); //add to main pane

		// SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(2);
		cm.getColumn(1).setPreferredWidth(180);

		// WHEN TABLE IS CLICKED
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tble = table.getSelectedRow();
				TableModel tModel = table.getModel();			
											
				//table data into respective field
				addcoid.setText(tModel.getValueAt(tble,0).toString()); //for module code   
				coAdd.setText(tModel.getValueAt(tble,1).toString()); //for module code				
				}
		});

		// TABLE SCROLL PANE
		JScrollPane panetable = new JScrollPane(table);
		panetable.setForeground(Color.GRAY);
		panetable.setBackground(Color.BLUE);
		panetable.setBounds(46, 117, 596, 139);
		coursePanel.add(panetable);

		// for course Id label
		JLabel coid = new JLabel("Course ID:");
		coid.setFont(new Font("Arial", Font.PLAIN, 14));
		coid.setBounds(51, 302, 84, 19);
		coursePanel.add(coid); //add to main pane

		// for course ID add field
		addcoid = new JTextField();
		addcoid.setFont(new Font("Arial", Font.PLAIN, 14));
		addcoid.setBounds(159, 298, 302, 27);
		coursePanel.add(addcoid); //add to main pane
		addcoid.setColumns(10); 

		// for coursename label
		JLabel coName = new JLabel("Course name:");
		coName.setFont(new Font("Arial", Font.PLAIN, 14));
		coName.setBounds(51, 349, 95, 27);
		coursePanel.add(coName); //add to main pane

		// to add course name field
		coAdd = new JTextField();
		coAdd.setFont(new Font("Arial", Font.PLAIN, 14));
		coAdd.setBounds(158, 349, 302, 28);
		coursePanel.add(coAdd); //add to main pane
		coAdd.setColumns(10);

		// Back button
		JButton backButton = new JButton("back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
		coursePanel.add(backButton); //add to main pane

		// add information button to column
		JButton addbutton = new JButton("Add");
		addbutton.setBackground(new Color(153, 255, 102));
		addbutton.setForeground(Color.WHITE);
		addbutton.setFont(new Font("Arial", Font.PLAIN, 14));
		addbutton.setBounds(197, 393, 85, 20);
		coursePanel.add(addbutton); //add to main pane

		// ACTION LISTENER

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
				if (coAdd.getText().equals("") || addcoid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter ALL DATA !!"); //show dialog message 
					// clear textfield for re-enter data
					coAdd.setText("");
					addcoid.setText("");

				} else {
					// get text from the field and save into varaible
					String courseID = addcoid.getText(); 
					String coursename = coAdd.getText();

					Connection conet;
					try {
						conet = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); //connect database
						// mysql query
						PreparedStatement ps = conet.prepareStatement("INSERT INTO `course`(`courseID`, `coursename`) VALUES(?,?)");
						ps.setString(1, courseID);
						ps.setString(2, coursename);
						ps.execute();

						conet.close(); // connection closed
						// successfully added message
						JOptionPane.showMessageDialog(null, "DATA ADDED SUCCESSFULLY!");

						// clear textfield for new data entry
						coAdd.setText("");
						addcoid.setText("");
					}

					catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1); // show message if database doesn't connect
					}

				}
			}

		});

		//delete button to panel 
		deletebutton = new JButton("Delete");
		deletebutton.setBackground(Color.RED);
		deletebutton.setForeground(Color.WHITE);
		deletebutton.setFont(new Font("Arial", Font.PLAIN, 14));
		deletebutton.setBounds(308, 393, 85, 20); // parameters(x-axis,y-axis,length,height)
		coursePanel.add(deletebutton);

		//add load button to panel
		JButton loadButton = new JButton("Load Data");
		loadButton.setForeground(Color.WHITE); 
		loadButton.setFont(new Font("Arial", Font.PLAIN, 11));
		loadButton.setBackground(Color.GRAY);
		loadButton.setBounds(557, 266, 87, 21);
		coursePanel.add(loadButton);

		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				ResultSet rs;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); //connection to database

					String sql = "select courseID, coursename from course "; //sql query to get data of courseID and coursename from database
					ps = con.prepareStatement(sql); //to write the SQL command and the user-provided data separately 
					rs = ps.executeQuery(); //Returns an integer representing the number of rows affected by the SQL statement.
					table.setModel(DbUtils.resultSetToTableModel(rs)); //set table to upload data from database to jtable 

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}

			}
		});

		// when delete button is clicked, delete rows of ID 
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// if the  courseID field is submitted empty then show message
				if (addcoid.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter ID to delete !!"); // show message if courseid is not given
					
					// clear textfield for re-enter data					
					addcoid.setText("");

				} else {
				Connection con;
				PreparedStatement ps;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); //connection to database
					// delete from course database if courseID is given 
					String sql = "delete from course where courseid = ?"; //sql query to get data of courseID and coursename from database
					ps = con.prepareStatement(sql); //to write the SQL command and the user-provided data separately
					ps.setString(1, addcoid.getText()); //to set string value at the given parameter index.

					ps.executeUpdate(); //to create, drop, insert, update, delete and it returns int type.
					JOptionPane.showMessageDialog(null, "Deleted Successfully");

					// clear textfield for new data entry
					addcoid.setText(""); 
					coAdd.setText("");

					con.close(); // connection closed
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, "Delected Unsuccessful");
				}
			  }
			}
		});

	}
}
