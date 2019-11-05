package starter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import starter.boundary.App;
import starter.model.*;

public class ResetController implements ActionListener{

	Model model;
	App dsa;
	
	public ResetController(Model model, App dsa) 
	{
		this.model = model;
		this.dsa = dsa;
	}

	@Override
	public void actionPerformed(ActionEvent btnPressed) {
		//System.out.println("Reset Button Pressed");
		
	}
}
