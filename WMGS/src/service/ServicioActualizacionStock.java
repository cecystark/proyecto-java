package service;

import model.Inventario;

import javax.swing.*;

public class ServicioActualizacionStock {
	
	Inventario inventarioPointer;
	
	public void cargarMercaderia(String codigo, Object cantidad) {
		
		int cantidadInt = (int) cantidad;
		
		inventarioPointer = Inventario.getInstancia();
		
		int code = Integer.parseInt(codigo);
		
		inventarioPointer.ingresarMercaderia(code, cantidadInt);
	}
	
	public void descargarMercaderia(String codigo, Object cantidad) {
		
		inventarioPointer = Inventario.getInstancia();
		
		int codigoInt = Integer.parseUnsignedInt(codigo);
		int cantidadInt = (int) cantidad;
		
		boolean operacionExitosa = inventarioPointer.retirarMercaderia(codigoInt, cantidadInt);
		
		if (operacionExitosa)
			JOptionPane.showMessageDialog(null,"La mercaderia ha sido retirada correctamente del sistema.");
		else 
			JOptionPane.showMessageDialog(null,"El stock es insuficiente, ingrese otra cantidad");
	}
}
