package view;

import controller.Sistema;

public class Main {

	public static void main(String[] args) {
		Sistema.getInstancia().cargarArchivo();
		
		Home frameHome = new Home();
		frameHome.setVisible(true);
		
		Menu frameMenu = new Menu();
		frameMenu.setVisible(false);
	}
	
}


