package ActionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import FrameListStudentMain.*;
import Panels.PanelForEntryData;

public class ListenerForEditSaveButton implements ActionListener {

	private ListOfStudents list;
	private PanelForEntryData panelForEntry;
	private int position;
	private Frame f;

	public ListenerForEditSaveButton(ListOfStudents l, PanelForEntryData entryData, int pos, Frame f) {
		this.list = l;
		this.panelForEntry = entryData;
		this.position = pos;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Node tmp = list.getElementAtPosition(position);
		tmp.info = new Student(panelForEntry.getFirstNameI().getText(), panelForEntry.getLastNameI().getText(),
				panelForEntry.getIndexNumberI().getText(), panelForEntry.getYearS().getSelection().getActionCommand(),
				panelForEntry.getLevelOfStudiesI().getSelectedItem().toString());

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = f.connection();

			String query = "UPDATE student SET first_name = ?, last_name = ?, index_number = ?, level_of_study_id = ?, year_id = ? WHERE student.index_number = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, panelForEntry.getFirstNameI().getText());
			ps.setString(2, panelForEntry.getLastNameI().getText());
			ps.setInt(3, Integer.parseInt(panelForEntry.getIndexNumberI().getText()));
			ps.setInt(4, tmp.info.yearInt());
			ps.setInt(5, tmp.info.levelInt());
			ps.setInt(6, list.getIndexNumber(position));

			ps.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,
				"Successfully changed information about this student\nYou may see the update list of students clicking on All students.",
				"Congratulations", 1);
		this.panelForEntry.setVisible(false);

	}

}
