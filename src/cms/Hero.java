package cms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Hero extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hero frame = new Hero();
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
	public Hero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Sname = new JLabel("Student name");
		Sname.setFont(new Font("Stencil", Font.PLAIN, 30));
		Sname.setBackground(Color.WHITE);
		Sname.setBounds(192, 39, 261, 74);
		contentPane.add(Sname);
		
		textField = new JTextField();
		textField.setBounds(175, 99, 261, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(171, 245, 265, 47);
		contentPane.add(passwordField);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Stencil", Font.PLAIN, 30));
		password.setBackground(Color.WHITE);
		password.setBounds(223, 171, 167, 80);
		contentPane.add(password);
		
		JButton btn1 = new JButton("Enter ");
		btn1.setBackground(Color.CYAN);
		btn1.setForeground(Color.BLACK);
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn1.setBounds(171, 326, 130, 47);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Clear");
		btn2.setBackground(Color.RED);
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn2.setBounds(311, 326, 130, 47);
		contentPane.add(btn2);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 140, 45, 13);
		contentPane.add(label);
	}
}
