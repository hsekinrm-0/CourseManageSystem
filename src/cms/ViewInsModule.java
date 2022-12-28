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

public class ViewInsModule extends JFrame {

	private JPanel modInsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewInsModule frame = new ViewInsModule();
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
	public ViewInsModule() {
		setTitle("View which module you're teaching");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // get exit when x is pressed
		setBounds(100, 100, 700, 530);
		modInsPanel = new JPanel();
		modInsPanel.setBackground(new Color(255, 255, 255));
		modInsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(modInsPanel);
		modInsPanel.setLayout(null);
		this.setLocationRelativeTo(null); // center of the screen

		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(0, 51, 255));
		topPanel.setBounds(0, 0, 686, 87);
		modInsPanel.add(topPanel);
		topPanel.setLayout(null);

		JLabel titleName = new JLabel("View modules you're teaching");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(123, 20, 440, 45);
		topPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 25));

		JTable table = new JTable();
		String[] columns = { "Teacher", "Course", "Level", "Semester", "Subject" };

		DefaultTableModel tmodel = new DefaultTableModel();
		tmodel.setColumnIdentifiers(columns); // set columns for the table
		table.setModel(tmodel);

		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setRowHeight(20);
		table.setAutoCreateRowSorter(true);
		modInsPanel.add(table); // add to main pane

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
				boolean click = table.isEditing();
				if (click == false) {
					JOptionPane.showMessageDialog(null,
							"You can only view this table.(ONLY ACCESS TO ADMINISTRATOR!!!)");
				}

			}
		});

		// TABLE SCROLL PANE
		JScrollPane ptable = new JScrollPane(table);
		ptable.setForeground(Color.GRAY);
		ptable.setBackground(Color.BLUE);
		ptable.setBounds(31, 117, 616, 250);
		modInsPanel.add(ptable);

//Back button
		JButton backButton = new JButton("back");
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
		modInsPanel.add(backButton);

// add load button to panel
		JButton loadButton = new JButton("view ");
		loadButton.setForeground(Color.WHITE);
		loadButton.setFont(new Font("Arial", Font.PLAIN, 11));
		loadButton.setBackground(Color.GRAY);
		loadButton.setBounds(31, 377, 75, 18);
		modInsPanel.add(loadButton);

//ACtion Listener

//this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // close the current frame to overcome opening many frame
				TeacherDashboard sh = new TeacherDashboard();
				sh.setVisible(true);
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
					DefaultTableModel tbmodel = (DefaultTableModel) table.getModel();
					tbmodel.setRowCount(0); // refresh table everytime new value input or delete

					// set table to upload data from database to Jtable
					while (rs.next()) {
						// data will be addded until finish
						String tname = rs.getString("teacher_name"); // "teacher_name" is the database column
						String cou = rs.getString("course");
						String lev = rs.getString("level");
						String sm = rs.getString("sem");
						String sub = rs.getString("subject");

						String tableD[] = { tname, cou, lev, sm, sub };
						tbmodel.addRow(tableD);
					}
					con.close();
					rs.close();

				} catch (Exception e3) {
					JOptionPane.showMessageDialog(null, e3); // show message if database doesn't connect
				}
			}

		});
	}
}