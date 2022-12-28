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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHome extends JFrame {

	private JPanel teacherPanel;
	private JButton addInsButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setTitle("Admistrative Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		teacherPanel = new JPanel();
		teacherPanel.setBackground(Color.WHITE);
		teacherPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(teacherPanel);
		teacherPanel.setLayout(null);
		this.setLocationRelativeTo(null);
		
		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(153, 0, 51));
		toPanel.setBounds(0, 0, 686, 81);
		teacherPanel.add(toPanel);
		toPanel.setLayout(null);
		
		JLabel titleName = new JLabel("Admistrative Dashboard");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(145, 24, 422, 29);
		toPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));
		
		JButton courseButton = new JButton("Course Management");		
		courseButton.setBackground(Color.LIGHT_GRAY);
		courseButton.setFont(new Font("Arial", Font.PLAIN, 20));
		courseButton.setBounds(216, 133, 241, 39);
		teacherPanel.add(courseButton);
		
		JButton slipButton = new JButton("View Student");
		slipButton.setBackground(Color.LIGHT_GRAY);
		slipButton.setFont(new Font("Arial", Font.PLAIN, 20));
		slipButton.setBounds(216, 339, 241, 39);
		teacherPanel.add(slipButton);
		
		JButton addMarkButton = new JButton("Add modules");
		addMarkButton.setBackground(Color.LIGHT_GRAY);
		addMarkButton.setFont(new Font("Arial", Font.PLAIN, 19));
		addMarkButton.setBounds(216, 269, 241, 39);
		teacherPanel.add(addMarkButton);
		
		JButton addInsButton;
		addInsButton = new JButton("Add Instructure");
		addInsButton.setBackground(Color.LIGHT_GRAY);
		addInsButton.setFont(new Font("Arial", Font.PLAIN, 19));
		addInsButton.setBounds(216, 202, 241, 39);
		teacherPanel.add(addInsButton);
		
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
				dispose(); //close the current frame to overcome opening many frame 
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewInsModule frame appear
		courseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				Course cf = new Course();
				cf.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewStudent frame appear
		slipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewStudentA Student = new ViewStudentA();
				Student.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewInstructor frame appear
		addInsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				AddInstruct addIn = new AddInstruct();
				addIn.setVisible(true);
			}
		});
		

		addMarkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				AddModule addmo = new AddModule();
				addmo.setVisible(true);
			}
		});

	}
}
