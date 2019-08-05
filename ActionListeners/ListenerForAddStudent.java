package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import FrameListStudentMain.*;

public class ListenerForAddStudent implements ActionListener {

	private JTextField firstName;
	private JTextField lastName;
	private JTextField indexNumber;
	private JComboBox level;
	private ButtonGroup year;
	private ListOfStudents students;
	private Frame f;

	public ListenerForAddStudent(JTextField i, JTextField p, JTextField br, JComboBox n, ButtonGroup g,
			ListOfStudents s, Frame f) {
		this.firstName = i;
		this.lastName = p;
		this.indexNumber = br;
		this.level = n;
		this.year = g;
		this.students = s;
		this.f = f;

	}

	// valid index number
	private boolean validNumber(String num) {
		return num.matches("[0-9]+");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (firstName.getText() == "" || lastName.getText() == "" || indexNumber.getText() == ""
				|| level.getSelectedIndex() == -1 || year.getSelection() == null) {
			JOptionPane.showMessageDialog(null, "All the fields must be fulfilled", "ERROR", 0);
		} else if (!validNumber(indexNumber.getText())) {
			JOptionPane.showMessageDialog(null, "Index number must be a number!", "ERROR", 0);

		} else {
			Student s = new Student(this.firstName.getText(), this.lastName.getText(), this.indexNumber.getText(),
					this.year.getSelection().getActionCommand(), this.level.getSelectedItem().toString());
			students.addToTail(s);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = f.connection();

				String query = "INSERT INTO student (first_name,last_name,index_number,level_of_study_id,year_id) VALUES(?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, firstName.getText());
				ps.setString(2, lastName.getText());
				ps.setString(3, indexNumber.getText());
				ps.setInt(4, s.levelInt());
				ps.setInt(5, s.yearInt());

				ps.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
			this.firstName.setText("");
			this.lastName.setText("");
			this.indexNumber.setText("");
			this.level.setSelectedIndex(0);
			this.year.clearSelection();
			JOptionPane.showMessageDialog(null, "Successfully added a student", "Congratulations", 1);

		}
	}

}
