package starter.boundary;

import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import starter.controller.QuitController;
import starter.model.EmptyTile;
import starter.model.Model;
import starter.model.NumberedTile;
import starter.model.TileSet;

public class PopUp {

	public PopUp() {
	}

	public static void infoBox(String infoMessage, String titleBar, App app, Model model) {
		// JOptionPane.showMessageDialog(app, infoMessage, "InfoBox: " + titleBar,
		// JOptionPane.INFORMATION_MESSAGE);
		// JOptionPane.showOptionDialog(app, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE, "Reset");
		Object[] options = {"Reset", "Quit"}; 
		int result = JOptionPane.showOptionDialog(app, infoMessage, titleBar, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, null);
		if(result == JOptionPane.YES_OPTION) 
		{
			Model resetModel = new Model(new TileSet(new NumberedTile[8], new EmptyTile(null)), 0);
			model.puzzlePieces = resetModel.puzzlePieces;
			app.repaint();
		}
		else if(result == JOptionPane.NO_OPTION)
		{
			app.dispatchEvent(new WindowEvent(app, WindowEvent.WINDOW_CLOSING));
		}
	}

}
