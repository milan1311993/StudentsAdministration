package Panels;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class PanelForSignIn extends JPanel {

	private JTextField userNameT;
	private JPasswordField passwordT;
	private JButton signIn;
	private JButton registration;


	//getters
	public JTextField getUserNameT() {
		return userNameT;
	}

	public JPasswordField getPasswordT() {
		return passwordT;
	}

	public JButton getSignIn() {
		return signIn;
	}

	public JButton getRegistration() {
		return registration;
	}

	private int compW = 150;
	private int compH = 30;
	private int offsetH = 30;
	private int offsetW = 170;


	public PanelForSignIn() {
		this.setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME!");
		welcome.setBounds(380, 20, 200, 30);
		welcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		this.add(welcome);
		
		JLabel createdby = new JLabel("created by Milan Mihajlovic");
		createdby.setBounds(welcome.getX()+130, welcome.getY() +30, 200, 30);
		this.add(createdby);

		JLabel userNameL = new JLabel("User name or email");
		userNameL.setBounds(250, 140, compW, compH);
		this.add(userNameL);

		userNameT = new JTextField();
		userNameT.setBounds(userNameL.getX(), userNameL.getY() + offsetH, compW, compH);
		this.add(userNameT);

		JLabel passwordL = new JLabel("Password");
		passwordL.setBounds(userNameT.getX(), userNameT.getY() + offsetH, compW, compH);
		this.add(passwordL);

		passwordT = new JPasswordField();
		passwordT.setBounds(passwordL.getX(), passwordL.getY() + offsetH, compW, compH);
		this.add(passwordT);

		signIn = new JButton("Sign in");
		signIn.setBounds(passwordT.getX(), passwordT.getY() + offsetH + 40, compW, compH);
		signIn.setBackground(new Color(133, 255, 255));
		this.add(signIn);
		
		JLabel regL = new JLabel("Don't have an account?");
		regL.setBounds(passwordT.getX()+330,passwordT.getY()+20,2*compW,compH);
		this.add(regL);

		registration = new JButton("Sign up");
		registration.setBounds(signIn.getX() + 330, signIn.getY(), compW, compH);
		registration.setBackground(new Color(133, 255, 255));
		this.add(registration);

	}
}