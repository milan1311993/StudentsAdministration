package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ListenerForPanelRegistration implements ActionListener {

	private JPanel panelForSignIn;
	private JPanel panelReg;

	public ListenerForPanelRegistration(JPanel panelForSignIn, JPanel panelForReg) {
		this.panelForSignIn = panelForSignIn;
		this.panelReg = panelForReg;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.panelForSignIn.setVisible(false);
		this.panelReg.setVisible(true);
	}

}
