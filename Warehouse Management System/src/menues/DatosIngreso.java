package menues;


public class DatosIngreso {
	
	private String usuario;
	private String contrasenia;
	
	public int validarDatos() {
		
		usuario = Home.textUsuario.getText();
		contrasenia = Home.textContrasenia.getText();
		
		if(usuario.equals("cecilia") && contrasenia.equals("ulfe"))
			return 1;
		else
			return 0;
			
	}
	
	
}
