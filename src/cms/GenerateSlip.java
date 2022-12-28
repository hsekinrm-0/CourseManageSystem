package cms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class GenerateSlip extends JFrame {

	private JPanel addPanel;
	private JTextField stdtext;
	private JTextField mdtext;
	private JTextField mdcode;
	public String m1,m2,m3,m4,m5,m6;
	JComboBox resBox;
	public String[] resultBox = { "pass", "fail" };
	public String[] columnbox = {};
//	public JRadioButton pass,fail; 
//	ButtonGroup result;
//	private JTextField reslt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateSlip frame = new GenerateSlip();
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
	public GenerateSlip() {
		setTitle("Generate slip");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // get exit when x is pressed
		setBounds(100, 100, 800, 650);
		addPanel = new JPanel();
		addPanel.setFont(new Font("Arial", Font.PLAIN, 16));
		addPanel.setBackground(new Color(255, 255, 255));
		addPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(addPanel);
		addPanel.setLayout(null);
		this.setLocationRelativeTo(null); // center of the screen

		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(153, 0, 51));
		toPanel.setBounds(0, 0, 1286, 87);
		addPanel.add(toPanel);
		toPanel.setLayout(null);

		JLabel titleName = new JLabel("Generate Result Slip");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(220, 20, 387, 45);
		toPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));

		// FORMING TABLE
		JTable table = new JTable();
		Object[] columns = { "Student_name", "level","sem","course","mark1","mark2","mark3","mark4","mark5","mark6","Reuslt" };
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
		cm.getColumn(1).setPreferredWidth(3);
		cm.getColumn(2).setPreferredWidth(3);	
		cm.getColumn(3).setPreferredWidth(3);
		cm.getColumn(4).setPreferredWidth(3);
		cm.getColumn(5).setPreferredWidth(3);
		cm.getColumn(6).setPreferredWidth(3);
		cm.getColumn(7).setPreferredWidth(3);
		cm.getColumn(8).setPreferredWidth(3);
		cm.getColumn(9).setPreferredWidth(3);
		cm.getColumn(10).setPreferredWidth(30);
		

		// WHEN TABLE IS CLICKED
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int tble = table.getSelectedRow();
				TableModel tModel = table.getModel();										
				
				//table data into respective field
				stdtext.setText(tModel.getValueAt(tble,0).toString()); //for student name 
				
				
			}
		});

		// TABLE SCROLL PANE
		JScrollPane panetable = new JScrollPane(table);
		panetable.setForeground(Color.GRAY);
		panetable.setBackground(Color.BLUE);
		panetable.setBounds(29, 270, 721, 185);
		addPanel.add(panetable);

		//student name label
		JLabel stdname = new JLabel("Student Name:");
		stdname.setFont(new Font("Arial", Font.PLAIN, 14));
		stdname.setBounds(98, 136, 113, 21);
		addPanel.add(stdname);

		//student name textfield
		stdtext = new JTextField();
		stdtext.setFont(new Font("Arial", Font.PLAIN, 14));
		stdtext.setBounds(229, 133, 322, 27);
		addPanel.add(stdtext);
		stdtext.setColumns(10);

		// load data from database button
		JButton loadButton = new JButton("View Table");
		loadButton.setForeground(Color.WHITE);
		loadButton.setFont(new Font("Arial", Font.PLAIN, 11));
		loadButton.setBackground(Color.GRAY);
		loadButton.setBounds(29, 233, 96, 27);
		addPanel.add(loadButton);
		
		// add information button to column
		JButton slipbutton = new JButton("Generate Slip");
		slipbutton.setBackground(Color.LIGHT_GRAY);
		slipbutton.setForeground(Color.BLACK);
		slipbutton.setFont(new Font("Arial", Font.PLAIN, 15));
		slipbutton.setBounds(597, 177, 135, 27);
		addPanel.add(slipbutton);
		
		JLabel actionLabel = new JLabel("Action:");
		actionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		actionLabel.setBounds(29, 571, 45, 19);
		addPanel.add(actionLabel);
		
		//for action message field
		JLabel lMessage = new JLabel("");
		lMessage.setFont(new Font("Arial", Font.BOLD, 14));
		lMessage.setBounds(84, 571, 243, 19);
		addPanel.add(lMessage);			

		// Back button
		JButton backButton = new JButton("back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(665, 569, 85, 21);
		addPanel.add(backButton);
		
		JLabel lblNewLabel = new JLabel("Progress to next level of study:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(98, 183, 203, 15);
		addPanel.add(lblNewLabel);
		
		resBox = new JComboBox(resultBox);
		resBox.setFont(new Font("Arial", Font.PLAIN, 14));
		resBox.setBounds(311, 177, 59, 25);
		addPanel.add(resBox);
		
		
		JButton submit = new JButton("Submit");
		submit.setBackground(Color.LIGHT_GRAY);
		submit.setFont(new Font("Arial", Font.PLAIN, 14));
		submit.setBounds(623, 132, 96, 28);
		addPanel.add(submit);
		
		JLabel reslt = new JLabel();
		reslt.setForeground(Color.BLACK);
		reslt.setBounds(492, 182, 45, 19);
		addPanel.add(reslt);			
		
	    

		// ACtion Listener

		// add data into addmodule database
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				ResultSet rs;

				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
					Statement st = con.createStatement();																						 
					String sql = "select studentName,level,mark1,mark2,mark3 ,mark4 ,mark5 ,mark6,course,sem,result from addmarks"; // sql query to get data of required columns from database
					rs = st.executeQuery(sql);	
					
					DefaultTableModel tbmodel = (DefaultTableModel)table.getModel(); 
					tbmodel.setRowCount(0); //refresh table everytime new value input or delete
					
					//table.setModel(DbUtils.resultSetToTableModel(rs)); // set table to upload data from database to Jtable
					while(rs.next()) {
						//data will be addded until finish
						String stdtext = rs.getString("studentName"); //"mcode" is the database column
						String m1 = rs.getString("mark1");
						String m2 = rs.getString("mark2");
						String m3 = rs.getString("mark3");
						String m4 = rs.getString("mark4");
						String m5 = rs.getString("mark5");
						String m6 = rs.getString("mark6");	
						String res = rs.getString("sem");
						String rus = rs.getString("result");
						
						String levelBox = rs.getString("level");
						String coursebox = rs.getString("course");
						
						String tableD[] = {stdtext,levelBox,res,coursebox,m1,m2,m3,m4,m5,m6,rus};						
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
		
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement pd;
				Connection con;
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database																											 

					String sql = "UPDATE addmarks SET result=? where studentName = '"+stdtext.getText()+"' "; // sql query to get data of required columns from database
					//String seql = "INSERT INTO `addmarks`( `result` ) values(?)"; // sql query 
					
	            	pd = con.prepareStatement(sql);
					pd.setString(16,(String)resBox.getSelectedItem());
					pd.executeUpdate();				
					
					JOptionPane.showMessageDialog(null,"Submit Successfully"); // show message
					
					//reset list and text field for next data entry
					stdtext.setText("");
					resBox.setSelectedIndex(0);

					//show message if data added to database
					lMessage.setText("" + "<html>" + "<font color=\"ORANGE\">DATA UPDATE SUCCESSFULLY</font> " + "</html>");
					con.close();
					}

				catch (Exception e3) {
					System.out.print(e3);
					//JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}
			}
		});





		// add data into the SQL database
		slipbutton.addActionListener(new ActionListener() {
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
															
							String sql = "INSERT INTO `addmarks`(`studentName`, `sub1`, `mark1`, `sub2`, `mark2`, `sub3`, `mark3`, `sub4`, `mark4`, `sub5`, `mark5`, `sub6`, `mark6`, `level`, `course`) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // sql query 
							
							ps = con.prepareStatement(sql);							
							
							
							
							ps.setString(1,stdtext.getText());
							
														
							// Returns an integer representing the number of rows affected by the SQL statement.						
							ps.executeUpdate();
							
							//show message if data added to database
							lMessage.setText("" + "<html>" + "<font color=\"green\">Data Inserted Successfully</font> " + "</html>");					
							
							con.close();
							
							//reset list and text field for next data entry
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
				AdminHome ahome = new AdminHome();
				ahome.setVisible(true); // open TeacherDashboard frame
			}
		});

	}
}
