package starter.boundary;

import javax.swing.JOptionPane;

public class PopUp {

	public PopUp() {
	}

	public static void infoBox(String infoMessage, String titleBar, App app) {
		// JOptionPane.showMessageDialog(app, infoMessage, "InfoBox: " + titleBar,
		// JOptionPane.INFORMATION_MESSAGE);
		// JOptionPane.showOptionDialog(app, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE, "Reset");
		Object[] options = {"Reset", "Quit"}; 
		//JOptionPane.showOptionDialog(app, infoMessage, titleBar, JOptionPane.YES_NO_OPTION);
	}

}
