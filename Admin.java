package LibraryLogin;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTextField;
	private JPasswordField adminPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin adminLogInFrame = new Admin();
					adminLogInFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin() {
		setResizable(false);
		setTitle("Admin Log-in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel adminLogInTitleLabel = new JLabel("Admin Log-in");
		adminLogInTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		adminLogInTitleLabel.setBounds(115, 31, 210, 48);
		panel.add(adminLogInTitleLabel);
		
		JLabel adminUsernameLabel = new JLabel("username:");
		adminUsernameLabel.setBounds(75, 106, 68, 14);
		panel.add(adminUsernameLabel);
		
		JLabel adminPasswordLabel_1 = new JLabel("password:");
		adminPasswordLabel_1.setBounds(75, 133, 68, 14);
		panel.add(adminPasswordLabel_1);
		
		usernameTextField = new JTextField();
		usernameTextField.setText("Enter your username.");
		usernameTextField.setBounds(139, 103, 215, 20);
		panel.add(usernameTextField);
		usernameTextField.setColumns(10);
		
		adminPasswordField = new JPasswordField();
		adminPasswordField.setEchoChar('*');
		adminPasswordField.setBounds(139, 131, 215, 20);
		panel.add(adminPasswordField);
		
		JCheckBox adminShowPasswordCheckBox = new JCheckBox("show password");
		adminShowPasswordCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(adminShowPasswordCheckBox.isSelected()) {
					adminPasswordField.setEchoChar((char)0);
				}
				else {
					adminPasswordField.setEchoChar('*');
				}
			}
		});
		adminShowPasswordCheckBox.setBounds(139, 158, 125, 23);
		panel.add(adminShowPasswordCheckBox);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn logIn = new LogIn();
				logIn.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(100, 204, 89, 23);
		panel.add(backButton);
		
		JButton logInButton = new JButton("Log-in");
		logInButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String adminUser = usernameTextField.getText();
				String adminPassword = adminPasswordField.getText();
				
				if(adminUser.equals("Admin_01") && adminPassword.equals("AdminOne") || 
				   adminUser.equals("Admin_02") && adminPassword.equals("AdminTwo") || 
				   adminUser.equals("Admin_03") && adminPassword.equals("AdminThree")) 
				{
					
					int success = JOptionPane.showConfirmDialog(null,"SUCCESSFULLY LOGIN","", JOptionPane.OK_CANCEL_OPTION);
					if(success == JOptionPane.OK_OPTION) {
						NULibrarySystem welcomeMessage = new NULibrarySystem();
						welcomeMessage.setVisible(true);
						dispose();
					}
				}
				else if(!(adminUser.equals("Admin_01")) && adminPassword.equals("AdminOne") ||
						!(adminUser.equals("Admin_02")) && adminPassword.equals("AdminTwo") ||
						!(adminUser.equals("Admin_03")) && adminPassword.equals("AdminThree")) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"USERNAME INCORRECT","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Admin adLogIn = new Admin(); 
						adLogIn.setVisible(true);
						dispose();
					}
				}
				else if(adminUser.equals("Admin_01") && !(adminPassword.equals("AdminOne")) ||
						adminUser.equals("Admin_02") && !(adminPassword.equals("AdminTwo")) ||
						adminUser.equals("Admin_03") && !(adminPassword.equals("AdminThree"))) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"PASSWORD INCORRECT","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Admin adLogIn = new Admin(); 
						adLogIn.setVisible(true);
						dispose();
					}
				}
				else if(!(adminUser.equals("Admin_01")) && !(adminPassword.equals("AdminOne")) ||
						!(adminUser.equals("Admin_02")) && !(adminPassword.equals("AdminTwo")) ||
						!(adminUser.equals("Admin_03")) && !(adminPassword.equals("AdminThree"))) 
				{
					int Incorrect = JOptionPane.showConfirmDialog(null,"USERNAME AND PASSWORD INCORRECT","", JOptionPane.CLOSED_OPTION);
					if(Incorrect == JOptionPane.OK_OPTION) {
						Admin adLogIn = new Admin(); 
						adLogIn.setVisible(true);
						dispose();
					}
				}
				
			}
		});
		logInButton.setBounds(236, 204, 89, 23);
		panel.add(logInButton);
	}
}
