package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.*;

import ActionListeners.ListenerForDeleteAccount;
import ActionListeners.ListenerForExcelFile;
import ActionListeners.ListenerForSignOffUserButton;
import FrameListStudentMain.*;

public class PanelForUser extends JPanel {
	private PanelForLoadFromDB panelForLoad;
	private int labelW = 100;
	private int labelH = 20;
	private int offsetW = 160;
	private int offsetH = 40;
	private int startX = 20;
	private int startY = 60;
	private Frame f;
	private Student student;
	private PanelForSignIn panelForSignIn;
	private JButton excel;

	private ListOfStudents list;
	private JComboBox filter;

	public PanelForUser(PanelForLoadFromDB panelForLoad, ListOfStudents list, JComboBox filter, Frame f, Student s,
			PanelForSignIn panelForSignIn) {
		this.setLayout(null);
		this.panelForLoad = panelForLoad;
		this.list = list;
		this.filter = filter;
		this.f = f;
		this.student = s;
		this.panelForSignIn = panelForSignIn;

		this.panelForLoad.setVisible(false);
		
		JButton deleteAccount = new JButton("Delete your account");
		deleteAccount.setBounds(650, 5, 160, 20);
		deleteAccount.setBackground(new Color(133, 255, 255));
		this.add(deleteAccount);
		
		ListenerForDeleteAccount listenerForDelete = new ListenerForDeleteAccount(this, panelForSignIn, f);
		deleteAccount.addActionListener(listenerForDelete);

		JButton signOff = new JButton("Sign off");
		signOff.setBounds(820, 5, 100, 20);
		signOff.setBackground(new Color(133, 255, 255));
		this.add(signOff);

		ListenerForSignOffUserButton listenerForSignOff = new ListenerForSignOffUserButton(this, panelForSignIn, f);
		signOff.addActionListener(listenerForSignOff);

		excel = new JButton("Download .xclx file");
		excel.setBounds(10, 5, 150, 20);
		excel.setBackground(new Color(133, 255, 255));
		this.add(excel);

		ListenerForExcelFile listenerForExcel = new ListenerForExcelFile(list, this);
		excel.addActionListener(listenerForExcel);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = f.connection();

			String query = "SELECT student.first_name,student.last_name,student.index_number,level_of_study.level,year_of_study.year FROM student,level_of_study,year_of_study WHERE year_of_study.id=student.year_id AND student.level_of_study_id = level_of_study.id";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				student = new Student(rs.getString("first_name"), rs.getString("last_name"),
						rs.getString("index_number"), rs.getString("year"), rs.getString("level"));
				list.addToTail(student);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel firstNameL = new JLabel("First name");
		firstNameL.setBounds(20, 40, labelW, labelH);
		firstNameL.setForeground(new Color(2, 10, 161));
		this.add(firstNameL);

		JLabel lastNameL = new JLabel("Last name");
		lastNameL.setBounds(firstNameL.getX() + offsetW, firstNameL.getY(), labelW, labelH);
		lastNameL.setForeground(new Color(2, 10, 161));
		this.add(lastNameL);

		JLabel indexNumberL = new JLabel("Index number", SwingConstants.CENTER);
		indexNumberL.setBounds(lastNameL.getX() + offsetW, lastNameL.getY(), labelW, labelH);
		indexNumberL.setForeground(new Color(2, 10, 161));
		this.add(indexNumberL);

		JLabel levelOfStudL = new JLabel("Level of studies", SwingConstants.CENTER);
		levelOfStudL.setBounds(indexNumberL.getX() + offsetW, indexNumberL.getY(), labelW + 100, labelH);
		levelOfStudL.setForeground(new Color(2, 10, 161));
		this.add(levelOfStudL);

		JLabel yearL = new JLabel("Year of studies");
		yearL.setBounds(levelOfStudL.getX() + offsetW + 80, levelOfStudL.getY(), labelW, labelH);
		yearL.setForeground(new Color(2, 10, 161));
		this.add(yearL);

		int num = 0;
		startY = 80;
		int height = 100;

		for (Node tmp = list.head; tmp != null; tmp = tmp.next) {
			this.setPreferredSize(new Dimension(0, height));

			JLabel firstName = new JLabel(tmp.info.getFirstName());
			firstName.setBounds(this.startX, this.startY, this.labelW, this.labelH);
			this.add(firstName);

			JLabel lastName = new JLabel(tmp.info.getLastName());
			lastName.setBounds(firstName.getX() + offsetW, firstName.getY(), this.labelW, this.labelH);
			this.add(lastName);

			JLabel indexNumber = new JLabel(tmp.info.getIndexNumber(), SwingConstants.CENTER);
			indexNumber.setBounds(lastName.getX() + offsetW, lastName.getY(), labelW, labelH);
			this.add(indexNumber);

			JLabel levelOfStud = new JLabel(tmp.info.getLevelOfStudies(), SwingConstants.CENTER);
			levelOfStud.setBounds(indexNumber.getX() + offsetW, indexNumber.getY(), labelW + 100, labelH);
			this.add(levelOfStud);

			JLabel yearOfStud = new JLabel(tmp.info.getYearOfStudies(), SwingConstants.CENTER);
			yearOfStud.setBounds(levelOfStud.getX() + offsetW + 80, levelOfStud.getY(), labelW, labelH);
			this.add(yearOfStud);

			this.startY = yearOfStud.getY() + offsetH;
			num++;
			height += 40;
		}

	}
	// getter for button excel

	public JButton getExcel() {
		return excel;
	}

}
