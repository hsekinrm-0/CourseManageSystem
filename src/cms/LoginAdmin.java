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

public class LoginAdmin extends JFrame {

	private JPanel loginPanel;
	public JTextField userNameField;
	public JPasswordField loginPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setTitle("LOGIN FORM"); // Title for the java frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null); // frame in center
		setContentPane(loginPanel);
		loginPanel.setLayout(null);

		JPanel toPanel = new JPanel();
		toPanel.setBounds(0, 0, 686, 94);
		toPanel.setBackground(new Color(153, 0, 51));
		loginPanel.add(toPanel);
		toPanel.setLayout(null);

		JLabel loginP = new JLabel("Administrative Login Page");
		loginP.setForeground(new Color(255, 255, 204));
		loginP.setBounds(150, 29, 451, 55);
		toPanel.add(loginP);
		loginP.setVerticalAlignment(SwingConstants.CENTER);
		loginP.setFont(new Font("Arial Black", Font.PLAIN, 28));

		JLabel userNamelog = new JLabel("Username:");
		userNamelog.setBounds(72, 168, 130, 13);
		userNamelog.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginPanel.add(userNamelog);

		JLabel loginPassword = new JLabel("Password:");
		loginPassword.setBounds(72, 259, 130, 13);
		loginPassword.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginPanel.add(loginPassword);

		userNameField = new JTextField();
		userNameField.setBounds(212, 154, 294, 43);
		userNameField.setFont(new Font("Arial", Font.PLAIN, 16));
		loginPanel.add(userNameField);
		userNameField.setColumns(10);

		loginPassField = new JPasswordField();
		loginPassField.setBounds(212, 247, 294, 43);
		loginPanel.add(loginPassField);

		JButton loginButton = new JButton("Log In");
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setBounds(138, 363, 147, 55);
		loginButton.setForeground(new Color(153, 0, 51));
		loginButton.setFont(new Font("Arial Black", Font.PLAIN, 18));
		loginPanel.add(loginButton);

		JButton homeButton = new JButton("Go to home page");
		homeButton.setBackground(Color.LIGHT_GRAY);
		homeButton.setBounds(376, 364, 190, 54);
		homeButton.setFont(new Font("Arial", Font.PLAIN, 18));
		loginPanel.add(homeButton);

		// ACTION LISTENER
		// when button clicked,this action perform to go to HomePage.java frame
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // close the current frame to overcome opening many frame
				HomePage hButton = new HomePage();
				hButton.setVisible(true);
			}
		});

		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				Connection conet;
				Statement stmt;
				try {
					conet = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", "");
					stmt = conet.createStatement();
					String i = userNameField.getText();
					String p = loginPassField.getText();
					String q = "select * from adminlog where username='" + i + "' and password='" + p + "'";
					ResultSet rs = stmt.executeQuery(q);
					if (rs.next()) {
						dispose(); // close the current frame to overcome opening many frame
						AdminHome ahome = new AdminHome();
						ahome.setVisible(true);
                       //closing connection
						conet.close();
					} else {
						dispose(); // close the current frame to overcome opening many frame
						ErrorA ef = new ErrorA();
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
