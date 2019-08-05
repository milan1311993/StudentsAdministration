package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import FrameListStudentMain.Frame;
import Panels.PanelForSignIn;

public class ListenerForDeleteAccount implements ActionListener{

	private JPanel panelForUser;
	private PanelForSignIn panelForSignIn;
	private Frame f;
	
	public ListenerForDeleteAccount(JPanel panelForUser, PanelForSignIn panelForSignIn, java.awt.Frame f2) {
		this.panelForUser = panelForUser;
		this.panelForSignIn = panelForSignIn;
		this.f = (Frame) f2;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null,
				"Are you sure you want to delete your account from DataBase?", "Warning", dialogButton);
		if (dialogResult == JOptionPane.YES_OPTION) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = f.connection();

				String query = "DELETE FROM users WHERE users.user_name = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, panelForSignIn.getUserNameT().getText());

				ps.execute();

			} catch (Exception e) {
				e.printStackTrace();
			}
		this.panelForUser.setVisible(false);
		f.getScrollPane1().setVisible(false);
		f.getButtonAdd().setVisible(false);
		f.getButtonShowAll().setVisible(false);
		f.getPanelForLoad().setVisible(false);

		panelForSignIn.setVisible(true);
		JOptionPane.showMessageDialog(null, "Your account is deleted!", "Notification", 1);
		this.panelForSignIn.getUserNameT().setText("");
		this.panelForSignIn.getPasswordT().setText("");		
	}
	}
}
