package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import FrameListStudentMain.Frame;
import Panels.PanelForSignIn;

public class ListenerForSignOffUserButton implements ActionListener {

	private JPanel panelForUser;
	private PanelForSignIn panelForSignIn;
	private Frame f;

	public ListenerForSignOffUserButton(JPanel panelForUser, PanelForSignIn panelForSignIn, java.awt.Frame f2) {
		this.panelForUser = panelForUser;
		this.panelForSignIn = panelForSignIn;
		this.f = (Frame) f2;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.panelForUser.setVisible(false);
		f.getScrollPane1().setVisible(false);
		f.getButtonAdd().setVisible(false);
		f.getButtonShowAll().setVisible(false);
		f.getPanelForLoad().setVisible(false);

		panelForSignIn.setVisible(true);
		JOptionPane.showMessageDialog(null, "Successful sign off. See you soon!", "Notification", 1);
		this.panelForSignIn.getUserNameT().setText("");
		this.panelForSignIn.getPasswordT().setText("");
	}

}
