package cms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
import java.sql.Statement;

import javax.swing.JTextField;

public class AddMarks extends JFrame {

	private JPanel addPanel;
	private JTextField stdtext;
	private JTextField mdtext;
	private JTextField mdcode;
	private JTextField addField;
	JComboBox levelBox;
	JComboBox coursebox;
	JComboBox semBox;
	public String[] levelbox = { "4", "5", "6" };
	public String[] sembox = { "1", "2" };
	public String[] columnbox = {};
	private JTextField addField1;
	private JTextField addField2;
	private JTextField addField3;
	private JTextField addField4;
	private JTextField addField5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMarks frame = new AddMarks();
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
	public AddMarks() {
		setTitle("View modules Instructor ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // get exit when x is pressed
		setBounds(100, 100, 1300, 695);
		addPanel = new JPanel();
		addPanel.setFont(new Font("Arial", Font.PLAIN, 16));
		addPanel.setBackground(new Color(255, 255, 255));
		addPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addPanel);
		addPanel.setLayout(null);
		this.setLocationRelativeTo(null); // center of the screen

		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(0, 51, 255));
		toPanel.setBounds(0, 0, 1286, 87);
		addPanel.add(toPanel);
		toPanel.setLayout(null);

		JLabel titleName = new JLabel("Add Marks");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(572, 20, 184, 45);
		toPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));

		JLabel tableLabel = new JLabel("View Table");
		tableLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		tableLabel.setBounds(51, 97, 85, 13);
		addPanel.add(tableLabel);

		// FORMING TABLE
		JTable table = new JTable();
		Object[] columns = { "Student_name", "module", "marks", "module", "marks", "module", "marks", "module", "marks", "module", "marks", "module", "marks", "level", "course", "sem"};
		DefaultTableModel tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columns); // set columns for the table
		table.setModel(tmodel);
		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		addPanel.add(table);

		// SETS TABLE WIDTH OF EACH COLUMN
		TableColumnModel cm = table.getColumnModel();
		cm.getColumn(0).setPreferredWidth(40);
		cm.getColumn(1).setPreferredWidth(50);
		cm.getColumn(2).setPreferredWidth(3);
		cm.getColumn(3).setPreferredWidth(50);
		cm.getColumn(4).setPreferredWidth(3);
		cm.getColumn(5).setPreferredWidth(50);
		cm.getColumn(6).setPreferredWidth(3);
		cm.getColumn(7).setPreferredWidth(50);
		cm.getColumn(8).setPreferredWidth(3);
		cm.getColumn(9).setPreferredWidth(50);
		cm.getColumn(10).setPreferredWidth(3);
		cm.getColumn(11).setPreferredWidth(50);
		cm.getColumn(12).setPreferredWidth(3);
		cm.getColumn(13).setPreferredWidth(3);
		cm.getColumn(14).setPreferredWidth(3);
		cm.getColumn(15).setPreferredWidth(3);

		// WHEN TABLE IS CLICKED
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boolean click = table.isEditing();
				if (click == false) {
					JOptionPane.showMessageDialog(null, "INSERT FROM BELOW!");
				}
			}
		});

		// TABLE SCROLL PANE
		JScrollPane panetable = new JScrollPane(table);
		panetable.setForeground(Color.GRAY);
		panetable.setBackground(Color.BLUE);
		panetable.setBounds(29, 117, 1228, 136);
		addPanel.add(panetable);

		//student name label
		JLabel stdname = new JLabel("Student Name:");
		stdname.setFont(new Font("Arial", Font.PLAIN, 14));
		stdname.setBounds(29, 300, 113, 21);
		addPanel.add(stdname);

		//student name textfield
		stdtext = new JTextField();
		stdtext.setFont(new Font("Arial", Font.PLAIN, 14));
		stdtext.setBounds(145, 297, 322, 27);
		addPanel.add(stdtext);
		stdtext.setColumns(10);
		
		JLabel lvllabel = new JLabel("Level:");
		lvllabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lvllabel.setBounds(482, 300, 52, 21); //y-axis, x-axis, len , breadth
		addPanel.add(lvllabel);
		
		// make JComboBox for level 4,5,6
		levelBox = new JComboBox(levelbox);
		levelBox.setFont(new Font("Arial", Font.PLAIN, 14));
		levelBox.setBounds(534, 300, 42, 21);
		addPanel.add(levelBox);
		
		JLabel semlabel = new JLabel("Semester:");
		semlabel.setFont(new Font("Arial", Font.PLAIN, 14));
		semlabel.setBounds(771, 297, 78, 27); //y-axis, x-axis, len , breadth
		addPanel.add(semlabel);
		
		// make JComboBox for level 4,5,6
		semBox = new JComboBox(sembox);
		semBox.setFont(new Font("Arial", Font.PLAIN, 14));
		semBox.setBounds(848, 300, 42, 21);
		addPanel.add(semBox);
		
		JLabel clabel = new JLabel("Course:");
		clabel.setFont(new Font("Arial", Font.PLAIN, 14));
		clabel.setBounds(607, 300, 59, 21); //y-axis, x-axis, len , breadth
		addPanel.add(clabel);
		
		coursebox = new JComboBox();		
		coursebox.setFont(new Font("Arial", Font.PLAIN, 14));
		coursebox.setBounds(665, 300, 85, 21);
		addPanel.add(coursebox);


		//module name label
		JLabel mdname = new JLabel("Module:");
		mdname.setFont(new Font("Arial", Font.PLAIN, 14));
		mdname.setBounds(51, 368, 67, 27);
		addPanel.add(mdname);
		
		JLabel mdname1 = new JLabel("Module:");
		mdname1.setFont(new Font("Arial", Font.PLAIN, 14));
		mdname1.setBounds(51, 406, 67, 27);
		addPanel.add(mdname1);
		
		JLabel mdname2 = new JLabel("Module:");
		mdname2.setFont(new Font("Arial", Font.PLAIN, 14));
		mdname2.setBounds(51, 442, 67, 27);
		addPanel.add(mdname2);
		
		JLabel mdname3 = new JLabel("Module:");
		mdname3.setFont(new Font("Arial", Font.PLAIN, 14));
		mdname3.setBounds(51, 486, 67, 27);
		addPanel.add(mdname3);
		
		JLabel mdname4 = new JLabel("Module:");
		mdname4.setFont(new Font("Arial", Font.PLAIN, 14));
		mdname4.setBounds(51, 523, 67, 27);
		addPanel.add(mdname4);
		
		JLabel mdname5 = new JLabel("Module:");
		mdname5.setFont(new Font("Arial", Font.PLAIN, 14));
		mdname5.setBounds(51, 560, 67, 27);
		addPanel.add(mdname5);
		
		//-----JCOMBO BOX TO ADD MODULES SUBJECT-----
		JComboBox<String> moduleBox = new JComboBox<String>();
		moduleBox.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox.setBounds(110, 369, 322, 22);
		addPanel.add(moduleBox);
		
		JComboBox moduleBox1 = new JComboBox();
		moduleBox1.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox1.setBounds(110, 409, 322, 22);
		addPanel.add(moduleBox1);
		
		JComboBox moduleBox2 = new JComboBox();
		moduleBox2.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox2.setBounds(110, 445, 322, 22);
		addPanel.add(moduleBox2);
		
		JComboBox moduleBox3 = new JComboBox();
		moduleBox3.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox3.setBounds(110, 489, 322, 22);
		addPanel.add(moduleBox3);
		
		JComboBox moduleBox4 = new JComboBox();
		moduleBox4.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox4.setBounds(110, 526, 322, 22);
		addPanel.add(moduleBox4);
		
		JComboBox moduleBox5 = new JComboBox();
		moduleBox5.setFont(new Font("Arial", Font.PLAIN, 12));
		moduleBox5.setBounds(110, 563, 322, 22);
		addPanel.add(moduleBox5);

		//-----ADD MARKS LABEL FOR ALL SUBJECT-----
		JLabel addlabel = new JLabel("Add marks:");
		addlabel.setFont(new Font("Arial", Font.PLAIN, 14));
		addlabel.setBounds(456, 409, 78, 21);
		addPanel.add(addlabel);
		
		JLabel addlabel1 = new JLabel("Add marks:");
		addlabel1.setFont(new Font("Arial", Font.PLAIN, 14));
		addlabel1.setBounds(456, 445, 78, 21);
		addPanel.add(addlabel1);
		
		JLabel addlabel2 = new JLabel("Add marks:");
		addlabel2.setFont(new Font("Arial", Font.PLAIN, 14));
		addlabel2.setBounds(456, 489, 78, 21);
		addPanel.add(addlabel2);
		
		JLabel addlabel3 = new JLabel("Add marks:");
		addlabel3.setFont(new Font("Arial", Font.PLAIN, 14));
		addlabel3.setBounds(456, 526, 78, 21);
		addPanel.add(addlabel3);
		
		JLabel addlabel4 = new JLabel("Add marks:");
		addlabel4.setFont(new Font("Arial", Font.PLAIN, 14));
		addlabel4.setBounds(456, 563, 78, 21);
		addPanel.add(addlabel4);
		
		JLabel addlabel5 = new JLabel("Add marks:");
		addlabel5.setFont(new Font("Arial", Font.PLAIN, 14));
		addlabel5.setBounds(456, 371, 78, 21);
		addPanel.add(addlabel5);

		//-----TEXT FILED TO ADD MARKS FOR ALL MODULES-----
		addField = new JTextField();
		addField.setBounds(534, 370, 45, 25);
		addPanel.add(addField);
		addField.setColumns(10);
		
		addField1 = new JTextField();
		addField1.setBounds(534, 408, 45, 25);
		addPanel.add(addField1);
		addField1.setColumns(10);
		
		addField2 = new JTextField();
		addField2.setBounds(534, 444, 45, 25);
		addPanel.add(addField2);
		addField2.setColumns(10);
		
		addField3 = new JTextField();
		addField3.setBounds(534, 488, 45, 25);
		addPanel.add(addField3);
		addField3.setColumns(10);
		
		addField4 = new JTextField();
		addField4.setBounds(534, 525, 45, 25);
		addPanel.add(addField4);
		addField4.setColumns(10);
		
		addField5 = new JTextField();
		addField5.setBounds(534, 562, 45, 25);
		addPanel.add(addField5);
		addField5.setColumns(10);

		// load data from database button
		JButton loadButton = new JButton("Load Data");
		loadButton.setForeground(Color.WHITE);
		loadButton.setFont(new Font("Arial", Font.PLAIN, 11));
		loadButton.setBackground(Color.GRAY);
		loadButton.setBounds(1170, 302, 87, 21);
		addPanel.add(loadButton);
		
		// add information button to column
		JButton addbutton = new JButton("Submit");
		addbutton.setBackground(new Color(153, 255, 102));
		addbutton.setForeground(Color.BLACK);
		addbutton.setFont(new Font("Arial", Font.PLAIN, 15));
		addbutton.setBounds(637, 560, 85, 27);
		addPanel.add(addbutton);
		
		JLabel actionLabel = new JLabel("Action:");
		actionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		actionLabel.setBounds(51, 616, 45, 19);
		addPanel.add(actionLabel);
		
		//for action message field
		JLabel lMessage = new JLabel("");
		lMessage.setFont(new Font("Arial", Font.BOLD, 14));
		lMessage.setBounds(106, 616, 243, 19);
		addPanel.add(lMessage);			

		// Back button
		JButton backButton = new JButton("back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(1172, 614, 85, 21);
		addPanel.add(backButton);
		

		// ACtion Listener

		// add data into addmodule database
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();																						 
					String sql = "select studentName, sub1, mark1, sub2, mark2, sub3, mark3, sub4, mark4, sub5, mark5, sub6, mark6, level,course,sem from addmarks"; // sql query to get data of required columns from database
					rs = st.executeQuery(sql);	
					
					DefaultTableModel tbmodel = (DefaultTableModel)table.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					//table.setModel(DbUtils.resultSetToTableModel(rs)); // set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String stdtext = rs.getString("studentName"); //"mcode" is the database column
						String moduleBox = rs.getString("sub1");
						String moduleBox1 = rs.getString("sub2");
						String moduleBox2 = rs.getString("sub3");
						String moduleBox3 = rs.getString("sub4");
						String moduleBox4 = rs.getString("sub5");
						String moduleBox5 = rs.getString("sub6");
						String levelBox = rs.getString("level");
						String coursebox = rs.getString("course");
						String sembox = rs.getString("sem");
						String addField = rs.getString("mark1");
						String addField1 = rs.getString("mark2");
						String addField2 = rs.getString("mark3");
						String addField3= rs.getString("mark4");
						String addField4 = rs.getString("mark5");
						String addField5 = rs.getString("mark6");				
						
						
						String tableD[] = {stdtext,moduleBox,addField,moduleBox1,addField1,moduleBox2,addField2,moduleBox3,addField3,moduleBox4,addField4,moduleBox5,addField5,levelBox,coursebox,sembox};						
						tbmodel.addRow(tableD);						
					}	
					st.close();
                    rs.close();
					
					//show message if data added to database
					lMessage.setText("" + "<html>" + "<font color=\"blue\">Data LOADED</font> " + "</html>");

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
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
							coursebox.addItem(rs.getString("coursename")); //add fetch data into coursebox		 					
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
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
		
		moduleBox1.addMouseListener(new MouseAdapter() {
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
						moduleBox1.addItem(rs.getString("subject")); //add fetch data from subject column of addmodule database into JCombobox		 					
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
				}
			 }
		});
		
		moduleBox2.addMouseListener(new MouseAdapter() {
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
						moduleBox2.addItem(rs.getString("subject")); //add fetch data from subject column of addmodule database into JCombobox		 					
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
				}
			 }
		});

		
		moduleBox3.addMouseListener(new MouseAdapter() {
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
						moduleBox3.addItem(rs.getString("subject")); //add fetch data from subject column of addmodule database into JCombobox		 					
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
				}
			 }
		});

		
		moduleBox4.addMouseListener(new MouseAdapter() {
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
						moduleBox4.addItem(rs.getString("subject")); //add fetch data from subject column of addmodule database into JCombobox		 					
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
				}
			 }
		});
		
		moduleBox5.addMouseListener(new MouseAdapter() {
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
						moduleBox5.addItem(rs.getString("subject")); //add fetch data from subject column of addmodule database into JCombobox		 					
					}
				}
				catch(Exception eq) {
					JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
				}
			 }
		});




		// add data into the SQL database
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			

					// validation for not leave blank data
					if (stdtext.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Please enter student name!");
					}
					else {
						Connection con;
						PreparedStatement ps;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
															
							String sql = "INSERT INTO `addmarks`(`studentName`, `sub1`, `mark1`, `sub2`, `mark2`, `sub3`, `mark3`, `sub4`, `mark4`, `sub5`, `mark5`, `sub6`, `mark6`, `level`, `course`, `sem`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // sql query 
							
							ps = con.prepareStatement(sql);
							ps.setString(2,(String)moduleBox.getSelectedItem());
							ps.setString(4,(String)moduleBox1.getSelectedItem());
							ps.setString(6,(String)moduleBox2.getSelectedItem());
							ps.setString(8,(String)moduleBox3.getSelectedItem());
							ps.setString(10,(String)moduleBox4.getSelectedItem());
							ps.setString(12,(String)moduleBox5.getSelectedItem());
							
							ps.setString(15,(String)coursebox.getSelectedItem());
							ps.setString(14,(String)levelBox.getSelectedItem());
							ps.setString(16,(String)semBox.getSelectedItem());
							
							ps.setString(1,stdtext.getText());
							
							ps.setString(3,addField.getText());
							ps.setString(5,addField1.getText());
							ps.setString(7,addField2.getText());
							ps.setString(9,addField3.getText());
							ps.setString(11,addField4.getText());
							ps.setString(13,addField5.getText());
														
							// Returns an integer representing the number of rows affected by the SQL statement.						
							ps.executeUpdate();
							
							//show message if data added to database
							lMessage.setText("" + "<html>" + "<font color=\"green\">Data Inserted Successfully</font> " + "</html>");					
							
							con.close();
							
							//reset list and text field for next data entry
							addField.setText("");
							addField1.setText("");
							addField2.setText("");
							addField3.setText("");
							addField4.setText("");
							addField5.setText("");
							semBox.setSelectedIndex(0);
							levelBox.setSelectedIndex(0);
							coursebox.setSelectedIndex(0);
							moduleBox.setSelectedIndex(0);
							moduleBox1.setSelectedIndex(0);
							moduleBox2.setSelectedIndex(0);
							moduleBox3.setSelectedIndex(0);
							moduleBox4.setSelectedIndex(0);
							moduleBox5.setSelectedIndex(0);
							stdtext.setText("");
							
						} catch (Exception e3) {
							//JOptionPane.showMessageDialog(null, e3);
							System.out.print(e3);// show message if database doesn't connect				   
					}
				  }
				}
			 });
		
		// this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // close the current frame to overcome opening many frame
				TeacherDashboard ahome = new TeacherDashboard();
				ahome.setVisible(true); // open TeacherDashboard frame
			}
		});

	}
}
