package cms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage extends JFrame {

	private JPanel homePanel;
	protected Window frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setTitle("HOME PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		homePanel = new JPanel();
		homePanel.setBackground(Color.WHITE);
		homePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(homePanel);
		this.setLocationRelativeTo(null); //place frame to the center of the monitor
		homePanel.setLayout(null);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(153, 255, 102));
		topPanel.setBounds(0, 0, 686, 99);
		homePanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel cmsLabel = new JLabel("Course Management System");
		cmsLabel.setBounds(118, 28, 472, 43);
		topPanel.add(cmsLabel);
		cmsLabel.setForeground(new Color(255, 255, 255));
		cmsLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		
		JLabel instructLabel = new JLabel("Instructor");
		instructLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		instructLabel.setBounds(59, 146, 122, 26);
		homePanel.add(instructLabel);
		
		JButton instruButton = new JButton("Login");	
		instruButton.setFont(new Font("Arial", Font.PLAIN, 18));
		instruButton.setBounds(49, 182, 217, 63);
		homePanel.add(instruButton);
		
		JLabel adminLabel = new JLabel("Administrative");
		adminLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		adminLabel.setBounds(391, 146, 152, 26);
		homePanel.add(adminLabel);
		
		JButton adminButton = new JButton("Login");
		adminButton.setFont(new Font("Arial", Font.PLAIN, 18));
		adminButton.setBounds(393, 182, 217, 63);
		homePanel.add(adminButton);
		
		JLabel studentLabel = new JLabel("Student");
		studentLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		studentLabel.setBounds(291, 318, 122, 26);
		homePanel.add(studentLabel);
		
		JButton stdloginButton = new JButton("Login");
		stdloginButton.setFont(new Font("Arial", Font.PLAIN, 18));
	    stdloginButton.setBounds(157, 359, 159, 48);
		homePanel.add(stdloginButton);
		
		JButton stdregisButton = new JButton("Register");
		stdregisButton.setFont(new Font("Arial", Font.PLAIN, 18));
		stdregisButton.setBounds(337, 359, 159, 48);
		homePanel.add(stdregisButton);
		
		
		/** .....ACTION LISTENER CODE START HERE......  **/
		
		//action listener for instructor button
		instruButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				LoginInstruct inButton = new LoginInstruct();
				inButton.setVisible(true);
			}
		});
		
		//action listener for administrative button
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				LoginAdmin adButton = new LoginAdmin();
				adButton.setVisible(true);
			}
		});
		
		//action listener for student login button
		stdloginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				LoginStudent stdlogButton = new LoginStudent();
				stdlogButton.setVisible(true);
			}
		});
		
		
		//action listener for student register button
		stdregisButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				StudentRegister stdreButton = new StudentRegister();
				stdreButton.setVisible(true);
				
			}
		});
		
	
		
	}
	
}

