package Panels;

import java.awt.Color;

import javax.swing.*;

import ActionListeners.ListenerForBackButton;
import FrameListStudentMain.Frame;

public class PanelForRegistration extends JPanel {

	private JTextField firstNameI;
	private JTextField lastNameI;
	private JTextField numberI;
	private JTextField emailI;
	private JTextField adressI;
	private JTextField userNameI;
	private JPasswordField passwordI;
	private JPasswordField confirmPasswordI;
	private JButton signUp;
	private JLabel warningL;
	private Frame f;

	private int compW = 150;
	private int compH = 20;
	private int offsetH = 30;
	private int offsetW = 170;
	private int buttonW = 110;
	private int buttonH = 30;

	public PanelForRegistration(Frame f) {
		this.setLayout(null);
		this.f = f;

		JButton back = new JButton("Back");
		back.setBounds(850, 10, 80, 20);
		back.setBackground(new Color(133, 255, 255));
		this.add(back);

		ListenerForBackButton listenerForBack = new ListenerForBackButton(this, f.getPanelForSignIn());
		back.addActionListener(listenerForBack);

		JLabel nameL = new JLabel("First name*");
		nameL.setBounds(50, 50, compW, compH);
		nameL.setForeground(Color.red);
		this.add(nameL);

		firstNameI = new JTextField();
		firstNameI.setBounds(nameL.getX() + offsetW, nameL.getY(), compW, compH);
		this.add(firstNameI);

		JLabel lastNameL = new JLabel("Last name*");
		lastNameL.setBounds(nameL.getX(), nameL.getY() + offsetH, offsetW, offsetH);
		lastNameL.setForeground(Color.red);
		this.add(lastNameL);

		lastNameI = new JTextField();
		lastNameI.setBounds(lastNameL.getX() + offsetW, lastNameL.getY(), compW, compH);
		this.add(lastNameI);

		JLabel numberL = new JLabel("Number");
		numberL.setBounds(lastNameL.getX(), lastNameL.getY() + offsetH, compW, compH);
		this.add(numberL);

		numberI = new JTextField();
		numberI.setBounds(numberL.getX() + offsetW, numberL.getY(), compW, compH);
		this.add(numberI);

		JLabel emailL = new JLabel("Email*");
		emailL.setBounds(numberL.getX(), numberL.getY() + offsetH, compW, compH);
		emailL.setForeground(Color.red);
		this.add(emailL);

		emailI = new JTextField();
		emailI.setBounds(emailL.getX() + offsetW, emailL.getY(), compW, compH);
		this.add(emailI);

		JLabel adressL = new JLabel("Adress");
		adressL.setBounds(emailL.getX(), emailL.getY() + offsetH, compW, compH);
		this.add(adressL);

		adressI = new JTextField();
		adressI.setBounds(adressL.getX() + offsetW, adressL.getY(), compW, compH);
		this.add(adressI);

		JLabel userNameL = new JLabel("User name*");
		userNameL.setBounds(adressL.getX(), adressL.getY() + offsetH, compW, compH);
		userNameL.setForeground(Color.red);
		this.add(userNameL);

		userNameI = new JTextField();
		userNameI.setBounds(userNameL.getX() + offsetW, userNameL.getY(), compW, compH);
		this.add(userNameI);

		JLabel passwordL = new JLabel("Password*");
		passwordL.setBounds(userNameL.getX(), userNameL.getY() + offsetH, compW, compH);
		passwordL.setForeground(Color.red);
		this.add(passwordL);

		passwordI = new JPasswordField();
		passwordI.setBounds(passwordL.getX() + offsetW, passwordL.getY(), compW, compH);
		this.add(passwordI);

		JLabel confirmPasswordL = new JLabel("Confirm password*");
		confirmPasswordL.setBounds(passwordL.getX(), passwordL.getY() + offsetH, compW, compH);
		confirmPasswordL.setForeground(Color.red);
		this.add(confirmPasswordL);

		confirmPasswordI = new JPasswordField();
		confirmPasswordI.setBounds(confirmPasswordL.getX() + offsetW, confirmPasswordL.getY(), compW, compH);
		this.add(confirmPasswordI);

		signUp = new JButton("Sign up");
		signUp.setBounds(380, confirmPasswordL.getY() + offsetH + 10, 2 * buttonW, buttonH);
		signUp.setBackground(new Color(133, 255, 255));
		this.add(signUp);

		warningL = new JLabel("All mandatory fields must be fulfilled");
		warningL.setBounds(signUp.getX(), signUp.getY() + offsetH, compW * 2, compH);
		warningL.setVisible(false);
		warningL.setForeground(Color.RED);
		this.add(warningL);

		JLabel mandatory = new JLabel("* mandatory fields");
		mandatory.setBounds(passwordL.getX(), signUp.getY() + 2 * offsetH, compW * 2, compH);
		mandatory.setForeground(Color.red);
		this.add(mandatory);
	}

	// getters
	public JTextField getFirstNameI() {
		return firstNameI;
	}

	public JTextField getLastNameI() {
		return lastNameI;
	}

	public JTextField getNumberI() {
		return numberI;
	}

	public JTextField getEmailI() {
		return emailI;
	}

	public JTextField getAdressI() {
		return adressI;
	}

	public JTextField getUserNameI() {
		return userNameI;
	}

	public JPasswordField getPasswordI() {
		return passwordI;
	}

	public JPasswordField getConfirmPasswordI() {
		return confirmPasswordI;
	}

	public JButton getSignUp() {
		return signUp;
	}

	public JLabel getWarningL() {
		return warningL;
	}

}
