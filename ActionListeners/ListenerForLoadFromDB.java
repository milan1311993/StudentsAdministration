package ActionListeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import FrameListStudentMain.Frame;

public class ListenerForLoadFromDB implements ActionListener {
	
	private Frame f;

	public ListenerForLoadFromDB(Frame f) {
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(null,
					"Successfully load from DataBase.\nYou may see, update, delete or add student", "Notification", 1);
			
			f.getButtonLoad().setVisible(false);
			f.getButtonShowAll().setVisible(true);
			f.getButtonAdd().setVisible(true);

	}

}
