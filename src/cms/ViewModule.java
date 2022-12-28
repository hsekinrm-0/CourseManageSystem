package cms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class ViewModule extends JFrame {

	private JPanel vmPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewModule frame = new ViewModule();
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
	public ViewModule() {
		setTitle("View Module Page ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		vmPanel = new JPanel();
		vmPanel.setBackground(new Color(255, 255, 255));
		vmPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(vmPanel);
		vmPanel.setLayout(null);
		this.setLocationRelativeTo(null); //frame to the center
		
		JPanel tPanel = new JPanel();
		tPanel.setBackground(new Color(153, 255, 102));
		tPanel.setBounds(0, 0, 686, 86);
		vmPanel.add(tPanel);
		tPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Modules ");
		lblNewLabel.setBounds(247, 24, 229, 35);
		tPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 28));
		
		JLabel firstyearL = new JLabel("For first year student:");
		firstyearL.setFont(new Font("Arial", Font.PLAIN, 16));
		firstyearL.setBounds(39, 120, 231, 34);
		vmPanel.add(firstyearL);
		
		JLabel secondyearL = new JLabel("For second year student:");
		secondyearL.setFont(new Font("Arial", Font.PLAIN, 16));
		secondyearL.setBounds(233, 214, 245, 34);
		vmPanel.add(secondyearL);
		
		JLabel thirdyearL = new JLabel("For third year student:");
		thirdyearL.setFont(new Font("Arial", Font.PLAIN, 16));
		thirdyearL.setBounds(415, 307, 261, 34);
		vmPanel.add(thirdyearL);
		
		JButton firstButton = new JButton("1st year ");
		firstButton.setFont(new Font("Arial", Font.PLAIN, 24));
		firstButton.setBounds(39, 161, 147, 43);
		vmPanel.add(firstButton);
		
		JButton secondButton = new JButton("2nd year ");
		secondButton.setFont(new Font("Arial", Font.PLAIN, 24));
		secondButton.setBounds(233, 249, 147, 43);
		vmPanel.add(secondButton);
		
		JButton thirdButton = new JButton("3rd year ");
		thirdButton.setFont(new Font("Arial", Font.PLAIN, 24));
		thirdButton.setBounds(415, 339, 147, 43);
		vmPanel.add(thirdButton);
		
		JButton homeButton = new JButton("home");
		homeButton.setForeground(new Color(255, 255, 255));
		homeButton.setBackground(new Color(102, 153, 255));
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.setBounds(39, 447, 85, 21);
		vmPanel.add(homeButton);
		
		JButton backButton = new JButton("back");		
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(0, 51, 51));
		backButton.setFont(new Font("Arial", Font.PLAIN, 16));
		backButton.setBounds(572, 447, 85, 21);
		vmPanel.add(backButton);			
		
		
		//ACtion Listener
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				HomePage hp = new HomePage();
				hp.setVisible(true);
			}
		});
		
		firstButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				FyearModule fym = new FyearModule();
				fym.setVisible(true);
			}
		});
		
		secondButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				SyearModule sym = new SyearModule();
				sym.setVisible(true);
			}
		});
		
		thirdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				TyearModule tym = new TyearModule();
				tym.setVisible(true);
			}
		});
		
		//this button when clicked get back to the previous page
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				StudentHome sh = new StudentHome();
				sh.setVisible(true);
					}
				});

		
	}
}
