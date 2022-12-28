package cms;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class LoginStudent extends JFrame {

	private JPanel loginPanel;
	public JTextField eField;
	public JPasswordField loginPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent frame = new LoginStudent();
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
	public LoginStudent() {
		setTitle("LOGIN FORM"); // Title for the java frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);

		this.setLocationRelativeTo(null); // frame in center
		setContentPane(loginPanel);
		loginPanel.setLayout(null);

		JLabel loginP = new JLabel("Student Login Page");
		loginP.setVerticalAlignment(SwingConstants.CENTER);
		loginP.setFont(new Font("Arial Black", Font.PLAIN, 24));
		loginP.setBounds(212, 23, 294, 43);
		loginPanel.add(loginP);

		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(153, 255, 102));
		toPanel.setBounds(0, 0, 686, 74);
		loginPanel.add(toPanel);

		JLabel idname = new JLabel("Email:");
		idname.setFont(new Font("Arial Black", Font.PLAIN, 18));
		idname.setBounds(72, 168, 130, 13);
		loginPanel.add(idname);

		JLabel loginPassword = new JLabel("Password:");
		loginPassword.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginPassword.setBounds(72, 259, 130, 13);
		loginPanel.add(loginPassword);

		eField = new JTextField();
		eField.setFont(new Font("Arial", Font.PLAIN, 16));
		eField.setBounds(212, 154, 294, 43);
		loginPanel.add(eField);
		eField.setColumns(10);

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

		// ACTION LISTENER

		// when button clicked,this action perform to go to HomePage.java frame
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					String i = eField.getText();
					String p = loginPassField.getText();
					String q = "select * from register where email='" + i + "' and password='" + p + "'";
					ResultSet rs = stmt.executeQuery(q);
					if (rs.next()) {
						dispose(); // close the current frame to overcome opening many frame
						StudentHome sh = new StudentHome();
						sh.setVisible(true);
                       //closing connection
						conet.close();
					} else {
						dispose(); // close the current frame to overcome opening many frame
						ErrorS ef = new ErrorS();
						ef.setVisible(true);
					}
				}

				catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});

	}
}
