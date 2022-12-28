package cms;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class StudentRegister extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel registerPanel;
	private JTextField firstnameBox;
	private JTextField lastnameBox;
	private JTextField emailBox;
	private JTextField fbox;
	private JTextField passwordBox;
	JComboBox courseBox;
	public String[] columnbox = {}; 
	public JRadioButton maleButton,femaleButton; 
	ButtonGroup gender;
	private JTextField gpaLabel;
	private JTextField address;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegister frame = new StudentRegister();
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
	public StudentRegister() {
		setTitle("Register FORM"); //Title for the java frame
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 530);
		registerPanel = new JPanel();		
		registerPanel.setBackground(Color.WHITE);
		setContentPane(registerPanel);		
        registerPanel.setLayout(null);
        registerPanel.setLayout(null);
        this.setLocationRelativeTo(null); //keep the frame to the center of the location
		
		JPanel toPanel = new JPanel();
		toPanel.setBackground(new Color(153, 255, 102));
		toPanel.setBounds(0, 0, 686, 54);
		registerPanel.add(toPanel);
		toPanel.setLayout(null);
		
		
//		JList list = new JList();
//		list.setBounds(233, 19, 0, 0);
//		registerPanel.add(list);
		
		JLabel titleName = new JLabel("Student Register ");
		titleName.setBounds(228, 10, 239, 35);
		toPanel.add(titleName);
		titleName.setFont(new Font("Arial Black", Font.BOLD, 24));

		JLabel firstName = new JLabel("First Name:");
		firstName.setFont(new Font("Arial", Font.PLAIN, 14));
		firstName.setBounds(44, 78, 114, 23);
		registerPanel.add(firstName);
		
		firstnameBox = new JTextField();
		firstnameBox.setFont(new Font("Arial", Font.PLAIN, 14));
		firstnameBox.setBounds(168, 78, 229, 23);
		registerPanel.add(firstnameBox);
		firstnameBox.setColumns(10);
		
		JLabel lastName = new JLabel("Last Name:");
		lastName.setFont(new Font("Arial", Font.PLAIN, 14));
		lastName.setBounds(44, 111, 111, 17);
		registerPanel.add(lastName);
		
		lastnameBox = new JTextField();
		lastnameBox.setFont(new Font("Arial", Font.PLAIN, 14));
		lastnameBox.setBounds(168, 111, 229, 23);
		registerPanel.add(lastnameBox);
		lastnameBox.setColumns(10);
		
		JLabel email = new JLabel("email:");
		email.setFont(new Font("Arial", Font.PLAIN, 14));
		email.setBounds(44, 287, 100, 23);
		registerPanel.add(email);
		
		emailBox = new JTextField();
		emailBox.setFont(new Font("Arial", Font.PLAIN, 14));
		emailBox.setBounds(168, 287, 229, 24);
		registerPanel.add(emailBox);
		emailBox.setColumns(10);
		
		JLabel sex = new JLabel("SEX ");
		sex.setFont(new Font("Arial", Font.PLAIN, 14));
		sex.setBounds(44, 182, 45, 13);
		registerPanel.add(sex);
		
		JRadioButton maleButton = new JRadioButton("Male");
		maleButton.setBackground(Color.WHITE);
		maleButton.setFont(new Font("Arial", Font.PLAIN, 14));
		maleButton.setBounds(168, 177, 60, 21);
		registerPanel.add(maleButton);
		
		JRadioButton femaleButton = new JRadioButton("Female");
		femaleButton.setBackground(Color.WHITE);
		femaleButton.setFont(new Font("Arial", Font.PLAIN, 14));
		femaleButton.setBounds(260, 177, 80, 21);
		registerPanel.add(femaleButton);
		
		gender = new ButtonGroup(); //adding male and female for radio button 
		gender.add(maleButton);
		gender.add(femaleButton);
				
		JLabel courseOption = new JLabel("Degree Course:");
		courseOption.setFont(new Font("Arial", Font.PLAIN, 14));
		courseOption.setBounds(44, 200, 134, 29);
		registerPanel.add(courseOption);
		
		JLabel father = new JLabel("Father's Name");
		father.setFont(new Font("Arial", Font.PLAIN, 14));
		father.setBounds(44, 153, 111, 13);
		registerPanel.add(father);
		
		fbox = new JTextField();
		fbox.setFont(new Font("Arial", Font.PLAIN, 14));
		fbox.setBounds(168, 148, 229, 23);
		registerPanel.add(fbox);
		fbox.setColumns(10);
		
		JLabel password = new JLabel("Password:");
		password.setFont(new Font("Arial", Font.PLAIN, 14));
		password.setBounds(48, 327, 100, 13);
		registerPanel.add(password);
		
		passwordBox = new JPasswordField();
		passwordBox.setFont(new Font("Arial ", Font.PLAIN, 10));
		passwordBox.setBounds(168, 325, 229, 23);
		registerPanel.add(passwordBox);
		passwordBox.setColumns(10);
		
		courseBox = new JComboBox();
		courseBox.setBounds(168, 205, 114, 21);
		registerPanel.add(courseBox);	
		
		// if JCombobox is clicked, show course from another database to here
				courseBox.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						Connection con;
						PreparedStatement ps;
						ResultSet rs;
						try {
							con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy", "root", ""); // connection to database
							String sql = "select coursename from course";
							ps = con.prepareStatement(sql);
							rs = ps.executeQuery();					
							while(rs.next()) {
									courseBox.addItem(rs.getString("coursename")); //add fetch data into coursebox		 					
							}
						}
						catch(Exception eq) {
							JOptionPane.showMessageDialog(null, "Could not upload course"); //show message if column data doesn't exist
						}
					 }
				});
				
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/comasy","root","");
					PreparedStatement ps = con.prepareStatement ("INSERT INTO register (`firstName`, `lastName`, `sex`, `course`, `email`, `Address`, `password`, `gpa`, `father_name`) values(?,?,?,?,?,?,?,?,?)");  
					String gnder ="";		            
	            	if(maleButton.isSelected()) {
	            		gnder+=maleButton.getText();
	            	}
	            	else if(femaleButton.isSelected()) {
	            		gnder+=femaleButton.getText();
	            	}
					ps.setString(1,firstnameBox.getText());
					ps.setString(2,lastnameBox.getText());
					ps.setString(3,gnder);
					ps.setString(4,(String)courseBox.getSelectedItem());
					ps.setString(5,emailBox.getText());					
					ps.setString(6,address.getText());
					ps.setString(7,passwordBox.getText());
					ps.setString(8,gpaLabel.getText());
					ps.setString(9,fbox.getText());					
					
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Data Inserted Successfully"); // show message
					
					//reset list and text field for next data entry
					firstnameBox.setText("");
					lastnameBox.setText("");
					emailBox.setText("");
					address.setText("");
					passwordBox.setText("");
					fbox.setText("");
					gpaLabel.setText("");
					courseBox.setSelectedIndex(0);				
					con.close();
					
			} catch (Exception e1){
					e1.printStackTrace();
			}
			
		}
		});
		
		registerButton.setForeground(new Color(51, 102, 204));
		registerButton.setFont(new Font("Arial", Font.PLAIN, 16));
		registerButton.setBounds(208, 409, 122, 43);
		registerPanel.add(registerButton);
		
		JButton goHomeButton = new JButton("Go To Home Page");
		goHomeButton.setForeground(new Color(0, 0, 0));
		goHomeButton.setFont(new Font("Arial", Font.PLAIN, 13));
		goHomeButton.setBounds(352, 409, 153, 43);
		registerPanel.add(goHomeButton);
		
		JLabel gpa = new JLabel("+2 CGPA:");
		gpa.setFont(new Font("Arial", Font.PLAIN, 14));
		gpa.setBounds(292, 208, 66, 13);
		registerPanel.add(gpa);
		
		gpaLabel = new JTextField();
		gpaLabel.setBounds(359, 204, 38, 23);
		registerPanel.add(gpaLabel);
		gpaLabel.setColumns(10);
		
		JLabel adrname = new JLabel("Address:");
		adrname.setFont(new Font("Arial", Font.PLAIN, 14));
		adrname.setBounds(44, 243, 66, 13);
		registerPanel.add(adrname);
		
		address = new JTextField();
		address.setBounds(168, 239, 229, 23);
		registerPanel.add(address);
		address.setColumns(10);
			
		
		//when button clicked,this action perform to go to HomePage.java frame 
		goHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); //close the current frame to overcome opening many frame 
				HomePage hButton = new HomePage();
				hButton.setVisible(true);
				dispose(); //clear this current frame after showing HomePage Frame
			}
		});
		
		
		
	    

		
	}
	}

