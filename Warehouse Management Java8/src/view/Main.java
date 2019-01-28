package view;

import controller.Controlador;
import model.Sistema;

public class Main {

	public static void main(String[] args) {
		
		Home home = new Home();
//	home.setVisible(true);
		
		Controlador controlador = new Controlador(home);
//		
//		Menu frameMenu = new Menu();
//		frameMenu.setVisible(false);
	}
	
}


