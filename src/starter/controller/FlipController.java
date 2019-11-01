package starter.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import starter.boundary.App;
import starter.model.Model;

public class FlipController extends MouseAdapter{
	
	Model model;
	App dsa;
	
	public FlipController(Model model, App dsa) {
		this.model = model;
		this.dsa = dsa;
	}
	

	public void mouseEvent(MouseEvent me) {
		System.out.println(me.getPoint());
	}
	
}
