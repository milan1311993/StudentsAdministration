package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import FrameListStudentMain.*;

public class ListenerForDeleteStudent implements ActionListener {

	private ListOfStudents list;
	private int position;
	private ActionListener listener;
	private Frame f;

	public ListenerForDeleteStudent(ListOfStudents l, int p, ActionListener aListener, Frame f) {
		this.list = l;
		this.position = p;
		this.listener = aListener;
		this.f = f;

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to delete this student from DataBase?", "Warning", dialogButton);
		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = f.connection();

				String query = "DELETE FROM student WHERE student.index_number = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, list.getIndexNumber(position));

				ps.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
			list.deleteElement(position);
		}
	}

}
