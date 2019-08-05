package FrameListStudentMain;

import java.awt.Color;
import java.sql.Connection;
import java.sql.*;
import javax.swing.*;
import ActionListeners.*;
import Panels.*;

public class Frame extends JFrame {

	private ListOfStudents listOfStudents = new ListOfStudents();
	private Student student = new Student();
	private JScrollPane scrollPane;
	private JButton loadFromDB;
	private JButton showAllStudents;
	private JButton openFormForAddStudent;
	private PanelForEntryData panelForEntryData;
	private JComboBox filter;
	private PanelForUser panelUser;
	private JScrollPane scrollPane1;
	private PanelForLoadFromDB panelForLoad;
	private PanelForSignIn panelForSignIn;

	public Frame() {
		this.setLayout(null);
		this.setTitle("Faculty administration");
		this.setSize(960, 540);
		this.setResizable(false);

		int buttonH = 30;
		int buttonW = 200;
		int offsetW = 220;

		// buttons "New student"(panel), "All students"(panel)
		openFormForAddStudent = new JButton("New student");
		openFormForAddStudent.setBounds(5, 5, buttonW, buttonH);
		openFormForAddStudent.setVisible(false);
		openFormForAddStudent.setBackground(new Color(133, 255, 255));
		this.add(openFormForAddStudent);

		showAllStudents = new JButton("All students");
		showAllStudents.setBounds(openFormForAddStudent.getX() + offsetW, openFormForAddStudent.getY(), buttonW,
				buttonH);
		showAllStudents.setVisible(false);
		showAllStudents.setBackground(new Color(133, 255, 255));
		this.add(showAllStudents);

		// ComboBox for filter
		filter = new JComboBox();
		filter.setBounds(showAllStudents.getX() + offsetW, showAllStudents.getY(), buttonW, buttonH);
		filter.addItem("Filter students");
		filter.addItem("Undergraduate studies");
		filter.addItem("Master studies");
		filter.addItem("PhD studies");
		filter.setVisible(false);
		filter.setBackground(new Color(133, 255, 255));
		this.add(filter);

		// Panels

		panelForSignIn = new PanelForSignIn();
		panelForSignIn.setBounds(0, 0, this.getWidth(), this.getHeight());
		panelForSignIn.setBackground(new Color(115, 201, 89));
		this.add(panelForSignIn);

		panelForLoad = new PanelForLoadFromDB();
		panelForLoad.setBounds(0, 0, this.getWidth(), this.getHeight());
		panelForLoad.setVisible(false);
		panelForLoad.setBackground(new Color(115, 201, 89));
		this.add(panelForLoad);

		// button "Load students from DataBase"
		loadFromDB = new JButton("Load students from DataBase");
		loadFromDB.setBounds(400, 200, 220, 30);
		loadFromDB.setBackground(new Color(133, 255, 255));
		panelForLoad.add(loadFromDB);
		
		PanelForListOfStudents panelForListOfStudents = new PanelForListOfStudents();
		panelForListOfStudents.setBounds(0, this.getHeight(), this.getWidth(), this.getHeight());
		panelForListOfStudents.setVisible(false);
		panelForListOfStudents.setBackground(new Color(115, 201, 89));
		this.add(panelForListOfStudents);

		panelForEntryData = new PanelForEntryData(panelForSignIn, this, panelForLoad);
		panelForEntryData.setBounds(0, 0, this.getWidth(), this.getHeight());
		panelForEntryData.setVisible(false);
		panelForEntryData.setBackground(new Color(115, 201, 89));
		this.add(panelForEntryData);

		panelUser = new PanelForUser(panelForLoad, listOfStudents, filter, this, student, panelForSignIn);
		panelUser.setBounds(0, 0, this.getWidth(), this.getHeight());
		panelUser.setVisible(false);
		panelUser.setBackground(new Color(115, 201, 89));
		this.add(panelUser);

		// button for add student
		JButton addStudent = new JButton("Add student");
		addStudent.setBounds(150, 230, 150, 20);
		addStudent.setBackground(new Color(133, 255, 255));
		panelForEntryData.add(addStudent);

		PanelForEntryData panelForEditData = new PanelForEntryData(panelForSignIn, this, panelForLoad);
		panelForEditData.setBounds(0, 0, this.getWidth(), this.getHeight());
		panelForEditData.setVisible(false);
		panelForEditData.setBackground(new Color(115, 201, 89));
		this.add(panelForEditData);

		PanelForRegistration panelForReg = new PanelForRegistration(this);
		panelForReg.setBounds(0, 0, this.getWidth(), this.getHeight());
		panelForReg.setVisible(false);
		panelForReg.setBackground(new Color(115, 201, 89));
		this.add(panelForReg);

		// Listeners
		ListenerForPanelForEntryData listenerForPanelForEntry = new ListenerForPanelForEntryData(panelForEntryData,
				panelForListOfStudents, filter, panelForLoad, this);
		openFormForAddStudent.addActionListener(listenerForPanelForEntry);

		ListenerForPanelListOfStudents listenerForPanelList = new ListenerForPanelListOfStudents(panelForEntryData,
				panelForListOfStudents, panelForEditData, listOfStudents, filter, this, panelForListOfStudents);
		showAllStudents.addActionListener(listenerForPanelList);

		ListenerForAddStudent listenerForAddingStudent = new ListenerForAddStudent(panelForEntryData.getFirstNameI(),
				panelForEntryData.getLastNameI(), panelForEntryData.getIndexNumberI(),
				panelForEntryData.getLevelOfStudiesI(), panelForEntryData.getYearS(), listOfStudents, this);
		addStudent.addActionListener(listenerForAddingStudent);

		ListenerForFilter ListenerForFilter = new ListenerForFilter(panelForListOfStudents, listOfStudents, filter,
				panelForEditData, panelForEntryData, this);
		filter.addActionListener(ListenerForFilter);

		ListenerForLoadFromDB listenerForLoad = new ListenerForLoadFromDB(this);
		loadFromDB.addActionListener(listenerForLoad);

		ListenerForSignInButton signInButton = new ListenerForSignInButton(panelForSignIn, panelForLoad, this);
		panelForSignIn.getSignIn().addActionListener(signInButton);

		ListenerForPanelRegistration listenerForReg = new ListenerForPanelRegistration(panelForSignIn, panelForReg);
		panelForSignIn.getRegistration().addActionListener(listenerForReg);

		ListenerForButtonSignUp listenerForButtonSignUp = new ListenerForButtonSignUp(panelForReg, panelForSignIn,
				this);
		panelForReg.getSignUp().addActionListener(listenerForButtonSignUp);


		// Scroll bar
		scrollPane = new JScrollPane(panelForListOfStudents, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 60, panelForListOfStudents.getWidth() - 15, panelForListOfStudents.getHeight() - 95);
		scrollPane.setVisible(false);

		this.add(scrollPane);

		scrollPane1 = new JScrollPane(panelUser, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane1.setBounds(0, 0, panelUser.getWidth() - 15, panelUser.getHeight() - 35);
		scrollPane1.setVisible(false);
		this.add(scrollPane1);

	}

	// Getters
	public JButton getButtonLoad() {
		return this.loadFromDB;
	}

	public JButton getButtonShowAll() {
		return this.showAllStudents;
	}

	public JButton getButtonAdd() {
		return this.openFormForAddStudent;
	}

	public JComboBox getFilter() {
		return this.filter;
	}

	public JScrollPane getScrollPane() {
		return this.scrollPane;
	}

	public PanelForUser getPanelUser() {
		return panelUser;
	}

	public JScrollPane getScrollPane1() {
		return this.scrollPane1;
	}

	public PanelForLoadFromDB getPanelForLoad() {
		return this.panelForLoad;
	}

	// connection to Data Basa

	public Connection connection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/faculty_student", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public PanelForSignIn getPanelForSignIn() {
		return panelForSignIn;
	}

	
	

}
