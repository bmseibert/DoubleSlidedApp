package starter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import starter.boundary.App;
import starter.model.*;

public class QuitController implements ActionListener {

	Model model;
	App dsa;

	public QuitController(Model model, App dsa) 
		{
			this.model = model;
			this.dsa = dsa;
		}

	@Override
	public void actionPerformed(ActionEvent btnPressed) {
		// System.out.println("Reset Button Pressed");
		dsa.dispatchEvent(new WindowEvent(dsa, WindowEvent.WINDOW_CLOSING));
	}
}
