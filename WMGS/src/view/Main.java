package view;

import controller.Sistema;

public class Main {

	public static void main(String[] args) {
		Sistema.getInstancia().cargarArchivo();
		
		HomeFrame frameHome = new HomeFrame();
		frameHome.setVisible(true);
		
		MenuFrame frameMenu = new MenuFrame();
		frameMenu.setVisible(false);
	}
	
}


