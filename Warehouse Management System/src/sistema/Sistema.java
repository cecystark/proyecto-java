package sistema;

import menues.Home;
import menues.Menu;

public class Sistema {

	public Sistema() {
		Home frameHome;
		
		frameHome = new Home();
		frameHome.setVisible(true);
		
		Menu frameMenu = new Menu();
		frameMenu.setVisible(false);

	}
}
