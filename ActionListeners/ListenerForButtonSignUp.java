package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import FrameListStudentMain.Frame;
import Panels.*;
import java.sql.*;

public class ListenerForButtonSignUp implements ActionListener {

	private PanelForRegistration panelReg;
	private PanelForSignIn panelSignIn;
	private Frame f;

	public ListenerForButtonSignUp(PanelForRegistration panelReg, PanelForSignIn panelSignIn, Frame f) {
		this.panelReg = panelReg;
		this.panelSignIn = panelSignIn;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (panelReg.getFirstNameI().getText().equals("") || panelReg.getLastNameI().getText().equals("")
				|| panelReg.getEmailI().getText().equals("") || panelReg.getUserNameI().getText().equals("")
				|| panelReg.getPasswordI().getPassword().length == 0
				|| panelReg.getConfirmPasswordI().getPassword().length == 0) {
			panelReg.getWarningL().setVisible(true);
		} else {
			String pass = new String(panelReg.getPasswordI().getPassword());
			String confirmPass = new String(panelReg.getConfirmPasswordI().getPassword());
			if (!(pass.equals(confirmPass))) {
				JOptionPane.showMessageDialog(null, "Passwords does not match!", "Warning", 1);
			} else {
				String userName = panelReg.getUserNameI().getText();
				String email = panelReg.getEmailI().getText();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = f.connection();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("SELECT COUNT(*) AS num FROM `users` WHERE `users`.`user_name`='"
							+ userName + "'OR `users`.`email`='" + email + "';");
					int numRows = 0;
					if (rs.next()) {
						numRows = Integer.parseInt(rs.getString("num"));
					}
					if (numRows > 0) {
						JOptionPane.showMessageDialog(null, "User name/email is already in use", "Warning", 2);
					} else {
						String ime = panelReg.getFirstNameI().getText();
						String prezime = panelReg.getLastNameI().getText();
						String adress = panelReg.getAdressI().getText();
						String number = panelReg.getNumberI().getText();

						String query = "INSERT INTO `users`(`firstName`,`surname`,`email`,`adress`,`number`,`user_name`,`password`,confirm_password,`user_privileges_id`) VALUES (?,?,?,?,?,?,?,?,?)";
						PreparedStatement prepStat = con.prepareStatement(query);
						prepStat.setString(1, ime);
						prepStat.setString(2, prezime);
						prepStat.setString(3, email);
						prepStat.setString(4, adress);
						prepStat.setString(5, number);
						prepStat.setString(6, userName);
						prepStat.setString(7, pass);
						prepStat.setString(8, confirmPass);
						prepStat.setInt(9, 2);

						prepStat.execute();
						JOptionPane.showMessageDialog(null, "Successfully sign up, please sign in!", "Notification", 1);
						panelReg.setVisible(false);
						panelSignIn.setVisible(true);

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}

}
