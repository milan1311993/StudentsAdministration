package ActionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import FrameListStudentMain.*;
import Panels.PanelForEntryData;

public class ListenerForFilter implements ActionListener {

	private JPanel panelListOfStudents;
	private ListOfStudents list;
	private JComboBox levelOfStudies;
	private PanelForEntryData panelForEditData;
	private PanelForEntryData panelForEntryData;
	private Frame f;

	private int labelW = 100;
	private int labelH = 20;
	private int offsetW = 110;
	private int offsetH = 40;

	public ListenerForFilter(JPanel panelList, ListOfStudents list, JComboBox level, PanelForEntryData panelEntry,
			PanelForEntryData panelForEdit, Frame f) {
		this.panelListOfStudents = panelList;
		this.list = list;
		this.levelOfStudies = level;
		this.panelForEditData = panelEntry;
		this.panelForEntryData = panelForEdit;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		panelListOfStudents.removeAll();
		panelListOfStudents.revalidate();
		panelListOfStudents.repaint();

		panelListOfStudents.setLayout(null);

		JLabel firstNameL = new JLabel("First name");
		firstNameL.setBounds(20, 20, labelW, labelH);
		firstNameL.setForeground(new Color(2, 10, 161));
		panelListOfStudents.add(firstNameL);

		JLabel lastNameL = new JLabel("Last name");
		lastNameL.setBounds(firstNameL.getX() + offsetW, firstNameL.getY(), labelW, labelH);
		lastNameL.setForeground(new Color(2, 10, 161));
		panelListOfStudents.add(lastNameL);

		JLabel indexNumberL = new JLabel("Index number", SwingConstants.CENTER);
		indexNumberL.setBounds(lastNameL.getX() + offsetW, lastNameL.getY(), labelW, labelH);
		indexNumberL.setForeground(new Color(2, 10, 161));
		panelListOfStudents.add(indexNumberL);

		JLabel levelOfStudiesL = new JLabel("Level of studies", SwingConstants.CENTER);
		levelOfStudiesL.setForeground(new Color(2, 10, 161));
		levelOfStudiesL.setBounds(indexNumberL.getX() + offsetW, indexNumberL.getY(), labelW + 100, labelH);
		panelListOfStudents.add(levelOfStudiesL);

		JLabel yearL = new JLabel("Year of studies", SwingConstants.CENTER);
		yearL.setForeground(new Color(2, 10, 161));
		yearL.setBounds(levelOfStudiesL.getX() + offsetW + 100, levelOfStudiesL.getY(), labelW, labelH);
		panelListOfStudents.add(yearL);

		JButton[] buttonDelete = new JButton[list
				.getNumberOfElementsOfType(levelOfStudies.getSelectedItem().toString())];
		JButton[] buttonEdit = new JButton[list.getNumberOfElementsOfType(levelOfStudies.getSelectedItem().toString())];

		ListenerForDeleteStudent[] listenerForDelete = new ListenerForDeleteStudent[list
				.getNumberOfElementsOfType(levelOfStudies.getSelectedItem().toString())];
		ListenerForEditStudent[] listenerForEdit = new ListenerForEditStudent[list
				.getNumberOfElementsOfType(levelOfStudies.getSelectedItem().toString())];

		int startY = 60;
		int num = 0;

		ListenerForPanelListOfStudents p = new ListenerForPanelListOfStudents(this.panelForEntryData,
				this.panelListOfStudents, this.panelForEditData, this.list, levelOfStudies, f, panelListOfStudents);

		int positionInListOfStudents = 1;

		for (Node tmp = list.head; tmp != null; tmp = tmp.next) {
			if (levelOfStudies.getSelectedItem().toString().equals(tmp.info.getLevelOfStudies())) {
				JLabel name = new JLabel(tmp.info.getFirstName());
				name.setBounds(20, startY, this.labelW, this.labelH);
				panelListOfStudents.add(name);

				JLabel lastName = new JLabel(tmp.info.getLastName());
				lastName.setBounds(name.getX() + offsetW, name.getY(), this.labelW, this.labelH);
				panelListOfStudents.add(lastName);

				JLabel indexNumber = new JLabel(tmp.info.getIndexNumber(), SwingConstants.CENTER);
				indexNumber.setBounds(lastName.getX() + offsetW, lastName.getY(), labelW, labelH);
				panelListOfStudents.add(indexNumber);

				JLabel levelOfStud = new JLabel(tmp.info.getLevelOfStudies(), SwingConstants.CENTER);
				levelOfStud.setBounds(indexNumber.getX() + offsetW, indexNumber.getY(), labelW + 100, labelH);
				panelListOfStudents.add(levelOfStud);

				JLabel year = new JLabel(tmp.info.getYearOfStudies(), SwingConstants.CENTER);
				year.setBounds(levelOfStud.getX() + offsetW + 100, levelOfStud.getY(), labelW, labelH);
				panelListOfStudents.add(year);

				buttonDelete[num] = new JButton("Delete");
				buttonDelete[num].setForeground(new Color(2, 10, 161));
				buttonDelete[num].setBackground(new Color(133, 255, 255));
				buttonDelete[num].setBounds(year.getX() + offsetW, year.getY(), labelW, labelH);
				panelListOfStudents.add(buttonDelete[num]);

				buttonEdit[num] = new JButton("Edit");
				buttonEdit[num].setForeground(new Color(2, 10, 161));
				buttonEdit[num].setBackground(new Color(133, 255, 255));
				buttonEdit[num].setBounds(year.getX() + offsetW + offsetW, year.getY(), labelW, labelH);
				panelListOfStudents.add(buttonEdit[num]);

				listenerForDelete[num] = new ListenerForDeleteStudent(list, positionInListOfStudents, this, f);
				buttonDelete[num].addActionListener(p);
				buttonDelete[num].addActionListener(listenerForDelete[num]);

				listenerForEdit[num] = new ListenerForEditStudent(this.panelForEditData, this.panelListOfStudents,
						this.list, positionInListOfStudents, f, panelForEditData);
				buttonEdit[num].addActionListener(listenerForEdit[num]);

				startY = year.getY() + offsetH;
				num++;
			}
			positionInListOfStudents++;
		}
		if ((levelOfStudies.getSelectedItem().toString().equals("Filter students"))) {
			JOptionPane.showMessageDialog(null, "To see again list of all students click on All students",
					"Notification", 1);
		}
	}
}
