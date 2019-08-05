package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import FrameListStudentMain.Frame;

public class ListenerForPanelForEntryData implements ActionListener {

	private JPanel panelForEntryData;
	private JPanel panelForListOfStudents;
	private JPanel panelForLoadFromDB;
	private JComboBox filter;
	private Frame f;

	public ListenerForPanelForEntryData(JPanel panelEntry, JPanel panelList, JComboBox jCB, JPanel panelForLoad,
			Frame f) {
		this.panelForEntryData = panelEntry;
		this.panelForListOfStudents = panelList;
		this.filter = jCB;
		this.panelForLoadFromDB = panelForLoad;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.panelForEntryData.setVisible(true);
		this.panelForListOfStudents.setVisible(false);
		this.filter.setVisible(false);
		this.panelForLoadFromDB.setVisible(false);
		this.f.getScrollPane().setVisible(false);

	}

}
