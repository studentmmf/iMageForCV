package org.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class Menu extends JMenuBar {
	
	public Menu() {
		
	}
	
	public void addMenuItem(String menu) {
		JMenu m = new JMenu();
		add(m);
	}
}
