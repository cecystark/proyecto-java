package controller;

import javax.swing.JOptionPane;

import model.Inventario;

public class ActualizacionStock {
	
	Inventario inventarioPointer;
	
		
	public void cargarMercaderia(String codigo, Object cantidad) {
		
		int cantidadInt = (int) cantidad;
		
		inventarioPointer = Inventario.getInstancia();
		
		int code = Integer.parseInt(codigo);
		
		inventarioPointer.ingresarMercaderia(code, cantidadInt);

	}
	
	public void descargarMercaderia(String codigo, Object cantidad) {
		
		//boolean sePudoRetirar; 
	
		
		inventarioPointer = Inventario.getInstancia();
		
		int codigoInt = Integer.parseUnsignedInt(codigo);
		int cantidadInt = (int) cantidad;
		
		boolean sePudo = inventarioPointer.retirarMercaderia(codigoInt, cantidadInt);
		
		if (sePudo)
			JOptionPane.showMessageDialog(null,"La mercader�a ha sido retirada correctamente del sistema.");
		else 
			JOptionPane.showMessageDialog(null,"El stock es insuficiente, ingrese otra cantidad");
			
	}


}
