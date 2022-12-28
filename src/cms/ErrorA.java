package cms;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ErrorA extends JFrame {

	private JPanel errorpane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorA frame = new ErrorA();
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
	public ErrorA() {
		setTitle("ERROR PAGE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 260);
		errorpane = new JPanel();
		errorpane.setBackground(Color.WHITE);
		errorpane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(errorpane);
		errorpane.setLayout(null);

		JLabel displaytext = new JLabel("Invalid ID or Password");
		displaytext.setForeground(Color.RED);
		displaytext.setFont(new Font("Arial Black", Font.PLAIN, 30));
		displaytext.setBounds(16, 46, 390, 91);
		errorpane.add(displaytext);
		this.setLocationRelativeTo(null);

		JButton backButton = new JButton("back");
		backButton.setForeground(Color.BLACK);
		backButton.setBackground(Color.RED);
		backButton.setFont(new Font("Arial", Font.PLAIN, 18));
		backButton.setBounds(317, 178, 79, 23);
		errorpane.add(backButton);

		// ACTION LISTENER

		// when button clicked,this action perform to go to HomePage.java frame
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginAdmin ahome = new LoginAdmin();
				ahome.setVisible(true);
			}
		});

	}
}
