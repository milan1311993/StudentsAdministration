package ActionListeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import FrameListStudentMain.Frame;
import Panels.*;

public class ListenerForSignInButton implements ActionListener {

	private PanelForSignIn panelForSignIn;
	private PanelForLoadFromDB panelForLoad;
	private Frame frame;

	public ListenerForSignInButton(PanelForSignIn panelForSignIn, PanelForLoadFromDB panelForLoad, Frame f) {
		this.panelForSignIn = panelForSignIn;
		this.panelForLoad = panelForLoad;
		this.frame = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String userName = panelForSignIn.getUserNameT().getText();
		String password = new String(panelForSignIn.getPasswordT().getPassword());

		if (userName.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "All the fields must be fulfilled", "ERROR", 3);
		} else {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = frame.connection();

				String query = "SELECT COUNT(*) AS numRows FROM `users` WHERE (`users`.`user_name` = ? OR `users`.`email` = ?) AND `users`.`password` = ?";
				PreparedStatement prepStat = con.prepareStatement(query);
				prepStat.setString(1, userName);
				prepStat.setString(2, userName);
				prepStat.setString(3, password);

				ResultSet rs = prepStat.executeQuery();
				rs.next();
				int numRows = Integer.parseInt(rs.getString("numRows"));
				if (numRows > 0) {
					JOptionPane.showMessageDialog(null, "Successeful sign in", "Notification", 1);
					query = "SELECT `user_privileges_id` FROM `users` WHERE `users`.`user_name`  = '" + userName
							+ "'OR `users`.`email` = '" + userName + "';";
					prepStat = con.prepareStatement(query);
					rs = prepStat.executeQuery();
					rs.next();
					panelForSignIn.setVisible(false);

					if (Integer.parseInt(rs.getString("user_privileges_id")) == 1) {
						frame.getButtonLoad().setVisible(true);
						panelForLoad.setVisible(true);

					} else {
						frame.getPanelUser().setVisible(true);
						frame.getScrollPane1().setVisible(true);
						JTextField signInAs = new JTextField();
						signInAs.setBounds(480, 5, 160, 20);
						signInAs.setText("Sign in as: " + userName);
						signInAs.setEditable(false);
						signInAs.setForeground(new Color(2, 10, 161));
						frame.getPanelUser().add(signInAs);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Wrong user name/email or password", "Error", 3);
				}

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

}
