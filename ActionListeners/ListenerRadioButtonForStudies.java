package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ListenerRadioButtonForStudies implements ActionListener {
	private JRadioButton jrbI;
	private JRadioButton jrbII;
	private JRadioButton jrbIII;
	private JRadioButton jrbIV;
	private JComboBox jcb;

	public ListenerRadioButtonForStudies(JRadioButton jrbI, JRadioButton jrbII, JRadioButton jrbIII, JRadioButton jrbIV,
			JComboBox jcb) {
		this.jrbI = jrbI;
		this.jrbII = jrbII;
		this.jrbIII = jrbIII;
		this.jrbIV = jrbIV;
		this.jcb = jcb;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// for undergraduate studies available years are 4
		if (jcb.getSelectedItem().equals("Undergraduate studies")) {
			this.jrbI.setVisible(true);
			this.jrbII.setVisible(true);
			this.jrbIII.setVisible(true);
			this.jrbIV.setVisible(true);
		} else {
			// for master available years are 1
			if (jcb.getSelectedItem().equals("Master studies")) {
				this.jrbI.setVisible(true);
				this.jrbII.setVisible(false);
				this.jrbIII.setVisible(false);
				this.jrbIV.setVisible(false);
			} else {
				// for phD available years are 3
				this.jrbI.setVisible(true);
				this.jrbII.setVisible(true);
				this.jrbIII.setVisible(true);
				this.jrbIV.setVisible(false);
			}
		}
	}
}
