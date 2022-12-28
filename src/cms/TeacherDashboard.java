package cms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TeacherDashboard extends JFrame {

	private JPanel teacherPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDashboard frame = new TeacherDashboard();
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
	public TeacherDashboard() {
		setTitle("Instructor HomePage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		teacherPanel = new JPanel();
		teacherPanel.setBackground(Color.WHITE);
		teacherPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(teacherPanel);
		teacherPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(0, 51, 255));
		toPanel.setBounds(0, 0, 686, 81);
		teacherPanel.add(toPanel);
		toPanel.setLayout(null);
		
		JLabel titleName = new JLabel("Instructor Dashboard");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(174, 24, 370, 29);
		toPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));
		
		JButton moduleButton = new JButton("View Module you're on");		
		moduleButton.setBackground(Color.LIGHT_GRAY);
		moduleButton.setFont(new Font("Arial", Font.PLAIN, 20));
		moduleButton.setBounds(219, 149, 244, 33);
		teacherPanel.add(moduleButton);
		
		JButton studentButton = new JButton("View students register ");
		studentButton.setBackground(Color.LIGHT_GRAY);
		studentButton.setFont(new Font("Arial", Font.PLAIN, 20));
		studentButton.setBounds(219, 234, 244, 39);
		teacherPanel.add(studentButton);
		
		JButton addMarkButton = new JButton("Add marks in responsible course ");
		addMarkButton.setBackground(Color.LIGHT_GRAY);
		addMarkButton.setFont(new Font("Arial", Font.PLAIN, 19));
		addMarkButton.setBounds(177, 320, 329, 39);
		teacherPanel.add(addMarkButton);
		
		JButton homeButton = new JButton("home");
		homeButton.setForeground(new Color(255, 255, 255));
		homeButton.setBackground(new Color(102, 153, 255));
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.setBounds(572, 447, 85, 21);
		teacherPanel.add(homeButton);
		
		
		//ACtion Listener
		//WHEN BUTTON CLICKED, HomePage frame appear
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewInsModule frame appear
		moduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewInsModule vim = new ViewInsModule();
				vim.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewStudent frame appear
		studentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewStudent Student = new ViewStudent();
				Student.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewInstructor frame appear
		addMarkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				AddMarks add = new AddMarks();
				add.setVisible(true);
			}
		});

	}
}
