package Panels;

import java.awt.Color;
import javax.swing.*;
import ActionListeners.ListenerForSignOffUserButton;
import ActionListeners.ListenerRadioButtonForStudies;
import FrameListStudentMain.*;

public class PanelForEntryData extends JPanel {

	private int labelW = 150;
	private int inputW = 200;
	private int compH = 20;
	private int offsetW = 130;
	private int offsetH = 30;

	private JTextField firstNameI;
	private JTextField lastNameI;
	private JTextField indexNumberI;
	private JComboBox levelOfStudiesI;
	private ButtonGroup yearS;
	private PanelForSignIn panelForSignIn;
	private Frame f;
	private PanelForLoadFromDB panelForLoad;

	private JRadioButton yearRBI;
	private JRadioButton yearRBII;
	private JRadioButton yearRBIII;
	private JRadioButton yearRBIV;

	public JButton editStudentB;

	public PanelForEntryData(PanelForSignIn panelForSignIn, Frame f, PanelForLoadFromDB p) {
		this.panelForSignIn = panelForSignIn;
		this.f = f;
		this.panelForLoad = p;

		this.setLayout(null);

		JButton signOff = new JButton("Sign off");
		signOff.setBounds(840, 5, 80, 20);
		signOff.setBackground(new Color(133, 255, 255));
		this.add(signOff);

		ListenerForSignOffUserButton listenerForSignOff = new ListenerForSignOffUserButton(this, panelForSignIn, f);
		signOff.addActionListener(listenerForSignOff);

		JButton signOff1 = new JButton("Sign off");
		signOff1.setBounds(840, 5, 80, 20);
		signOff1.setBackground(new Color(133, 255, 255));
		panelForLoad.add(signOff1);

		ListenerForSignOffUserButton listenerForSignOff1 = new ListenerForSignOffUserButton(this, panelForSignIn, f);
		signOff1.addActionListener(listenerForSignOff1);

		JLabel firstNameL = new JLabel("Name*");
		firstNameL.setBounds(20, 60, this.labelW, this.compH);
		this.add(firstNameL);

		firstNameI = new JTextField();
		firstNameI.setBackground(new Color(147, 230, 169));
		firstNameI.setBounds(firstNameL.getX() + offsetW, firstNameL.getY(), this.inputW, this.compH);
		this.add(firstNameI);

		JLabel lastNameL = new JLabel("Last name*");
		lastNameL.setBounds(firstNameL.getX(), firstNameL.getY() + offsetH, this.labelW, this.compH);
		this.add(lastNameL);

		lastNameI = new JTextField();
		lastNameI.setBackground(new Color(147, 230, 169));
		lastNameI.setBounds(lastNameL.getX() + offsetW, lastNameL.getY(), inputW, compH);
		this.add(lastNameI);

		JLabel indexNumberL = new JLabel("Index number*");
		indexNumberL.setBounds(lastNameL.getX(), lastNameL.getY() + offsetH, this.labelW, this.compH);
		this.add(indexNumberL);

		indexNumberI = new JTextField();
		indexNumberI.setBackground(new Color(147, 230, 169));
		indexNumberI.setBounds(indexNumberL.getX() + offsetW, indexNumberL.getY(), this.inputW, this.compH);
		this.add(indexNumberI);

		JLabel indexW = new JLabel("-> only numbers allowed");
		indexW.setBounds(indexNumberI.getX() + offsetW + 80, indexNumberI.getY(), inputW, compH);
		indexW.setForeground(Color.red);
		this.add(indexW);

		JLabel levelOfStudL = new JLabel("Level of studies*");
		levelOfStudL.setBounds(indexNumberL.getX(), indexNumberL.getY() + offsetH, this.labelW, this.compH);
		this.add(levelOfStudL);

		levelOfStudiesI = new JComboBox();
		levelOfStudiesI.setBackground(new Color(147, 230, 169));
		levelOfStudiesI.addItem("Undergraduate studies");
		levelOfStudiesI.addItem("Master studies");
		levelOfStudiesI.addItem("PhD studies");
		levelOfStudiesI.setBounds(levelOfStudL.getX() + offsetW, levelOfStudL.getY(), this.inputW, this.compH);
		this.add(levelOfStudiesI);

		JLabel yearL = new JLabel("Year of studies*");
		yearL.setBounds(levelOfStudL.getX(), levelOfStudL.getY() + offsetH, this.labelW, this.compH);
		this.add(yearL);

		JLabel mandatoryF = new JLabel("*all the fields are mandatory");
		mandatoryF.setBounds(yearL.getX(), yearL.getY() + 4 * offsetH, 3 * this.labelW, compH);
		mandatoryF.setForeground(Color.red);
		this.add(mandatoryF);

		int radioW = 40;
		int radioH = 20;
		int radioO = 50;

		yearRBI = new JRadioButton("1");
		yearRBI.setBounds(yearL.getX() + this.offsetW, yearL.getY(), radioW, radioH);
		yearRBI.setActionCommand("1");
		yearRBI.setBackground(new Color(115, 201, 89));
		this.add(yearRBI);

		yearRBII = new JRadioButton("2");
		yearRBII.setBounds(yearRBI.getX() + radioO, yearRBI.getY(), radioW, radioH);
		yearRBII.setActionCommand("2");
		yearRBII.setBackground(new Color(115, 201, 89));
		this.add(yearRBII);

		yearRBIII = new JRadioButton("3");
		yearRBIII.setBounds(yearRBII.getX() + radioO, yearRBII.getY(), radioW, radioH);
		yearRBIII.setActionCommand("3");
		yearRBIII.setBackground(new Color(115, 201, 89));
		this.add(yearRBIII);

		yearRBIV = new JRadioButton("4");
		yearRBIV.setBounds(yearRBIII.getX() + radioO, yearRBIII.getY(), radioW, radioH);
		yearRBIV.setActionCommand("4");
		yearRBIV.setBackground(new Color(115, 201, 89));
		this.add(yearRBIV);

		yearS = new ButtonGroup();
		yearS.add(yearRBI);
		yearS.add(yearRBII);
		yearS.add(yearRBIII);
		yearS.add(yearRBIV);

		ListenerRadioButtonForStudies listenerForRadioB = new ListenerRadioButtonForStudies(yearRBI, yearRBII,
				yearRBIII, yearRBIV, levelOfStudiesI);
		levelOfStudiesI.addActionListener(listenerForRadioB);

		editStudentB = new JButton("Save changes");
		editStudentB.setBounds(150, 200, 130, 20);
		editStudentB.setVisible(false);
		editStudentB.setBackground(new Color(133, 255, 255));
	}

	// getters
	public JTextField getFirstNameI() {
		return this.firstNameI;
	}

	public JTextField getLastNameI() {
		return lastNameI;
	}

	public JTextField getIndexNumberI() {
		return indexNumberI;
	}

	public JComboBox getLevelOfStudiesI() {
		return levelOfStudiesI;
	}

	public ButtonGroup getYearS() {
		return yearS;
	}

	public JRadioButton getYearRBI() {
		return yearRBI;
	}

	public JRadioButton getYearRBII() {
		return yearRBII;
	}

	public JRadioButton getYearRBIII() {
		return yearRBIII;
	}

	public JRadioButton getYearRBIV() {
		return yearRBIV;
	}

}
