package cms;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class CourseManage extends JFrame {

	private JPanel cManagePanel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseManage frame = new CourseManage();
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
	public CourseManage() {
		setTitle("View modules Instructor ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //get exit when x is pressed
		setBounds(100, 100, 700, 530);
		cManagePanel = new JPanel();
		cManagePanel.setFont(new Font("Arial", Font.PLAIN, 16));
		cManagePanel.setBackground(new Color(255, 255, 255)); //title pane background color
		setContentPane(cManagePanel);
		cManagePanel.setLayout(null);
		this.setLocationRelativeTo(null); //center of the screen 
		
		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(153, 0, 51));
		toPanel.setBounds(0, 0, 686, 87);
		cManagePanel.add(toPanel);
		toPanel.setLayout(null);
		
		JLabel titleName = new JLabel("Add Marks");
		titleName.setForeground(Color.WHITE);
		titleName.setBounds(267, 21, 184, 45);
		toPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.PLAIN, 30));
		

		//Back button
		JButton backButton = new JButton("back");		
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
		cManagePanel.add(backButton);
					
		//ACtion Listener
		
		//this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				TeacherDashboard td = new TeacherDashboard(); 
				td.setVisible(true); //open TeacherDashboard frame
			}
		});
	}
}
