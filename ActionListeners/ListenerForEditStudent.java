package ActionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import FrameListStudentMain.*;
import Panels.PanelForEntryData;

public class ListenerForEditStudent implements ActionListener {

	private PanelForEntryData panelForEntry;
	private JPanel panelListOfStudents;
	private ListOfStudents list;
	private int position;
	private Frame f;

	public ListenerForEditStudent(PanelForEntryData ped, JPanel pls, ListOfStudents list, int position, Frame f,
			JPanel edit) {
		this.panelForEntry = ped;
		this.panelListOfStudents = pls;
		this.list = list;
		this.position = position;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.panelListOfStudents.setVisible(false);
		this.panelForEntry.setVisible(true);
		f.getScrollPane().setVisible(false);
		f.getFilter().setVisible(false);

		// get position of student selected for edit and information about that student
		int pos = 1;
		Node tmp = list.head;
		while (pos != position) {
			tmp = tmp.next;
			pos++;
		}
		this.panelForEntry.getFirstNameI().setText(tmp.info.getFirstName());
		this.panelForEntry.getLastNameI().setText(tmp.info.getLastName());
		this.panelForEntry.getIndexNumberI().setText(tmp.info.getIndexNumber());
		this.panelForEntry.getLevelOfStudiesI().setSelectedItem(tmp.info.getLevelOfStudies());
		// radio button
		if (tmp.info.yearInt() == 1) {
			this.panelForEntry.getYearRBI().setSelected(true);
		} else if (tmp.info.yearInt() == 2) {
			this.panelForEntry.getYearRBII().setSelected(true);
		} else if (tmp.info.yearInt() == 3) {
			this.panelForEntry.getYearRBIII().setSelected(true);
		} else {
			this.panelForEntry.getYearRBIV().setSelected(true);
		}

		// background for panel for edit and button for save changes
		panelForEntry.remove(panelForEntry.editStudentB);
		panelForEntry.editStudentB = new JButton("Save changes");
		panelForEntry.editStudentB.setBounds(150, 230, 130, 20);
		panelForEntry.editStudentB.setBackground(new Color(133, 255, 255));
		panelForEntry.add(panelForEntry.editStudentB);

		// listener for button save changes
		ListenerForEditSaveButton listenerForSave = new ListenerForEditSaveButton(list, panelForEntry, position, f);
		panelForEntry.editStudentB.addActionListener(listenerForSave);

	}

}
