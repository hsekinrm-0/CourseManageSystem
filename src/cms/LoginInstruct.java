package cms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginInstruct extends JFrame {

	private JPanel loginPanel;
	private JTextField userNameField;
	private JPasswordField loginPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInstruct frame = new LoginInstruct();
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
	public LoginInstruct() {
		setTitle("LOGIN FORM"); // Title for the java frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null); // frame in center
		setContentPane(loginPanel);
		loginPanel.setLayout(null);

		JLabel loginP = new JLabel("Instructor Login Page");
		loginP.setVerticalAlignment(SwingConstants.CENTER);
		loginP.setFont(new Font("Arial Black", Font.PLAIN, 24));
		loginP.setBounds(212, 23, 294, 43);
		loginPanel.add(loginP);

		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(0, 51, 255));
		toPanel.setBounds(0, 0, 686, 74);
		loginPanel.add(toPanel);

		JLabel userNamelog = new JLabel("Username:");
		userNamelog.setFont(new Font("Arial Black", Font.PLAIN, 18));
		userNamelog.setBounds(72, 168, 130, 13);
		loginPanel.add(userNamelog);

		JLabel loginPassword = new JLabel("Password:");
		loginPassword.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginPassword.setBounds(72, 259, 130, 13);
		loginPanel.add(loginPassword);

		userNameField = new JTextField();
		userNameField.setFont(new Font("Arial", Font.PLAIN, 16));
		userNameField.setBounds(212, 154, 294, 43);
		loginPanel.add(userNameField);
		userNameField.setColumns(10);

		loginPassField = new JPasswordField();
		loginPassField.setBounds(212, 247, 294, 43);
		loginPanel.add(loginPassField);

		JButton loginButton = new JButton("Log In");
		loginButton.setForeground(new Color(0, 102, 255));
		loginButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginButton.setBounds(138, 363, 147, 55);
		loginPanel.add(loginButton);

		JButton homeButton = new JButton("Go to home page");
		homeButton.setFont(new Font("Arial", Font.PLAIN, 18));
		homeButton.setBounds(376, 364, 190, 54);
		loginPanel.add(homeButton);

		// when button clicked,this action perform to go to HomePage.java frame
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // close the current frame to overcome opening many frame
				HomePage hButton = new HomePage();
				hButton.setVisible(true);

			}
		});

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conet;
				Statement stmt;
				try {
					conet = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", "");
					stmt = conet.createStatement();
					String i = userNameField.getText();
					String p = loginPassField.getText();
					String q = "select * from teacherlog where username='" + i + "' and password='" + p + "'";
					ResultSet rs = stmt.executeQuery(q);
					
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESSFULLY"); //show dialog message 
						dispose(); // close the current frame to overcome opening many frame
						TeacherDashboard tbb = new TeacherDashboard();
						tbb.setVisible(true);
                       //closing connection
						conet.close();
					} else {
						dispose(); // close the current frame to overcome opening many frame
						ErrorT et = new ErrorT();
						et.setVisible(true);
					}
				}

				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "DATA NOT CONNECT"); //show dialog message 
				}
				
				
			}
		});

	}
}
