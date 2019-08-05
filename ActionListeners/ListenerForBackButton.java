package ActionListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Panels.PanelForRegistration;

public class ListenerForBackButton implements ActionListener{
	private PanelForRegistration panelForReg;
	private JPanel panelForSignIn;
	
	 public ListenerForBackButton(PanelForRegistration panelForReg, JPanel panelForSignIn) {
		 this.panelForReg = panelForReg;
		 this.panelForSignIn = panelForSignIn;
	 }
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.panelForReg.setVisible(false);
		this.panelForSignIn.setVisible(true);
		this.panelForReg.getFirstNameI().setText("");
		this.panelForReg.getLastNameI().setText("");
		this.panelForReg.getNumberI().setText("");
		this.panelForReg.getEmailI().setText("");
		this.panelForReg.getAdressI().setText("");
		this.panelForReg.getUserNameI().setText("");
		this.panelForReg.getPasswordI().setText("");
		this.panelForReg.getConfirmPasswordI().setText("");
		this.panelForReg.getWarningL().setVisible(false);
		
	}

}
