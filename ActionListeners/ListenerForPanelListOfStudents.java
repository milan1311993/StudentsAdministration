package ActionListeners;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import FrameListStudentMain.*;
import Panels.PanelForEntryData;

public class ListenerForPanelListOfStudents implements ActionListener {

	private JPanel panelForEntryData;
	private JPanel panelForListOfStud;
	private PanelForEntryData panelForEdit;
	private ListOfStudents list;
	private JComboBox filter;
	private Frame f;
	private JPanel panelForList;

	private int labelW = 100;
	private int labelH = 20;
	private int offsetW = 110;
	private int offsetH = 40;
	private int startX = 20;
	private int startY = 60;

	public ListenerForPanelListOfStudents(JPanel fzus, JPanel pls, PanelForEntryData fzes, ListOfStudents lista,
			JComboBox filter, Frame f, JPanel panelForList) {
		this.panelForEntryData = fzus;
		this.panelForListOfStud = pls;
		this.panelForEdit = fzes;
		this.list = lista;
		this.filter = filter;
		this.f = f;
		this.panelForList = panelForList;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		panelForListOfStud.setLayout(null);
		this.f.getScrollPane().setVisible(true);
		this.panelForEntryData.setVisible(false);
		this.panelForEdit.setVisible(false);
		this.panelForListOfStud.setVisible(true);
		this.filter.setVisible(true);
		f.getPanelForLoad().setVisible(false);
		panelForListOfStud.removeAll();
		panelForListOfStud.repaint();

		JLabel firstNameL = new JLabel("First name");
		firstNameL.setBounds(20, 20, labelW, labelH);
		firstNameL.setForeground(new Color(2, 10, 161));
		panelForListOfStud.add(firstNameL);

		JLabel lastNameL = new JLabel("Last name");
		lastNameL.setBounds(firstNameL.getX() + offsetW, firstNameL.getY(), labelW, labelH);
		lastNameL.setForeground(new Color(2, 10, 161));
		panelForListOfStud.add(lastNameL);

		JLabel indexNumberL = new JLabel("Index number", SwingConstants.CENTER);
		indexNumberL.setBounds(lastNameL.getX() + offsetW, lastNameL.getY(), labelW, labelH);
		indexNumberL.setForeground(new Color(2, 10, 161));
		panelForListOfStud.add(indexNumberL);

		JLabel levelOfStudL = new JLabel("Level of studies", SwingConstants.CENTER);
		levelOfStudL.setBounds(indexNumberL.getX() + offsetW, indexNumberL.getY(), labelW + 100, labelH);
		levelOfStudL.setForeground(new Color(2, 10, 161));
		panelForListOfStud.add(levelOfStudL);

		JLabel yearL = new JLabel("Year of studies");
		yearL.setBounds(levelOfStudL.getX() + offsetW + 100, levelOfStudL.getY(), labelW, labelH);
		yearL.setForeground(new Color(2, 10, 161));
		panelForListOfStud.add(yearL);

		JButton[] buttonDelete = new JButton[list.numberOfElement()];
		JButton[] buttonEdit = new JButton[list.numberOfElement()];

		ListenerForDeleteStudent[] listenerDelete = new ListenerForDeleteStudent[list.numberOfElement()];
		ListenerForEditStudent[] listenerEdit = new ListenerForEditStudent[list.numberOfElement()];

		int num = 0;
		startY = 60;
		int height = 100;

		ListenerForPanelListOfStudents p = new ListenerForPanelListOfStudents(this.panelForEntryData,
				this.panelForListOfStud, this.panelForEdit, this.list, this.filter, f, this.panelForList);

		for (Node tmp = list.head; tmp != null; tmp = tmp.next) {
			this.panelForList.setPreferredSize(new Dimension(0, height));

			JLabel firstName = new JLabel(tmp.info.getFirstName());
			firstName.setBounds(this.startX, this.startY, this.labelW, this.labelH);
			panelForListOfStud.add(firstName);

			JLabel lastName = new JLabel(tmp.info.getLastName());
			lastName.setBounds(firstName.getX() + offsetW, firstName.getY(), this.labelW, this.labelH);
			panelForListOfStud.add(lastName);

			JLabel indexNumber = new JLabel(tmp.info.getIndexNumber(), SwingConstants.CENTER);
			indexNumber.setBounds(lastName.getX() + offsetW, lastName.getY(), labelW, labelH);
			panelForListOfStud.add(indexNumber);

			JLabel levelOfStud = new JLabel(tmp.info.getLevelOfStudies(), SwingConstants.CENTER);
			levelOfStud.setBounds(indexNumber.getX() + offsetW, indexNumber.getY(), labelW + 100, labelH);
			panelForListOfStud.add(levelOfStud);

			JLabel yearOfStud = new JLabel(tmp.info.getYearOfStudies(), SwingConstants.CENTER);
			yearOfStud.setBounds(levelOfStud.getX() + offsetW + 100, levelOfStud.getY(), labelW, labelH);
			panelForListOfStud.add(yearOfStud);

			buttonDelete[num] = new JButton("Delete");
			buttonDelete[num].setBackground(new Color(133, 255, 255));
			buttonDelete[num].setForeground(new Color(2, 10, 161));
			buttonDelete[num].setBounds(yearOfStud.getX() + offsetW, yearOfStud.getY(), labelW, labelH);
			panelForListOfStud.add(buttonDelete[num]);

			buttonEdit[num] = new JButton("Edit");
			buttonEdit[num].setBackground(new Color(133, 255, 255));
			buttonEdit[num].setForeground(new Color(2, 10, 161));
			buttonEdit[num].setBounds(yearOfStud.getX() + offsetW + offsetW, yearOfStud.getY(), labelW, labelH);
			panelForListOfStud.add(buttonEdit[num]);

			listenerDelete[num] = new ListenerForDeleteStudent(list, num + 1, this, f);

			buttonDelete[num].addActionListener(p);
			buttonDelete[num].addActionListener(listenerDelete[num]);

			listenerEdit[num] = new ListenerForEditStudent(this.panelForEdit, this.panelForListOfStud, this.list,
					num + 1, f, panelForEdit);
			buttonEdit[num].addActionListener(listenerEdit[num]);

			this.startY = yearOfStud.getY() + offsetH;
			num++;
			height += 40;
		}
	}

}
