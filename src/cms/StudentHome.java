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

public class StudentHome extends JFrame {

	private JPanel sHomePanel;
	public JButton homeButton;
	public JButton teachButton;
	public JButton gradeButton;
	public JButton moduleButton;
	public JLabel titleName;
	public JPanel topanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentHome frame = new StudentHome();
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
	public StudentHome() {
		setTitle("Studnet Homepage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		sHomePanel = new JPanel();
		sHomePanel.setBackground(Color.WHITE);
		sHomePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(sHomePanel);
		sHomePanel.setLayout(null);
		this.setLocationRelativeTo(null); //making the Frame to center of the screen
		
		topanel = new JPanel();
		topanel.setBackground(new Color(153, 255, 102));
		topanel.setBounds(0, 0, 686, 81);
		sHomePanel.add(topanel);
		topanel.setLayout(null);
		
		titleName = new JLabel("Student Dashboard");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(192, 24, 329, 29);
		topanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));
		
		moduleButton = new JButton("View Modules ");		
		moduleButton.setBackground(Color.LIGHT_GRAY);
		moduleButton.setFont(new Font("Arial", Font.PLAIN, 24));
		moduleButton.setBounds(241, 127, 206, 51);
		sHomePanel.add(moduleButton);
		
		gradeButton = new JButton("View Grades ");
		gradeButton.setBackground(Color.LIGHT_GRAY);
		gradeButton.setFont(new Font("Arial", Font.PLAIN, 24));
		gradeButton.setBounds(241, 229, 206, 51);
		sHomePanel.add(gradeButton);
		
		teachButton = new JButton("View modules Instructor");
		teachButton.setBackground(Color.LIGHT_GRAY);
		teachButton.setFont(new Font("Arial", Font.PLAIN, 24));
		teachButton.setBounds(195, 333, 299, 51);
		sHomePanel.add(teachButton);
		
		homeButton = new JButton("home");
		homeButton.setForeground(new Color(255, 255, 255));
		homeButton.setBackground(new Color(102, 153, 255));
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.setBounds(572, 447, 85, 21);
		sHomePanel.add(homeButton);
		
		
		//ACtion Listener
		//WHEN BUTTON CLICKED, HomePage frame appear
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewModule frame appear
		moduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewModule vim = new ViewModule();
				vim.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewMarks frame appear
		gradeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewMarks mark = new ViewMarks();
				mark.setVisible(true);
			}
		});
		
		//WHEN BUTTON CLICKED, ViewInstructor frame appear
		teachButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				ViewInstructor teacher = new ViewInstructor();
				teacher.setVisible(true);
			}
		});

	}
}
