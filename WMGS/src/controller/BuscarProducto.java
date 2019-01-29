package controller;

import javax.swing.JOptionPane;

import model.Inventario;
import model.Producto;
import view.ProductoRespuesta;

public class BuscarProducto {
	
	private Inventario inventarioPointer;
	
	
	public Producto buscarProducto(String textoprod, String textocod) 
	{
		inventarioPointer = Inventario.getInstancia();
		
		Producto productoBuscado = new Producto();	

		
		if (textoprod.isEmpty()) { //si complete el campo CODIGO en el form
		
			int codigoInt;
			codigoInt = Integer.parseInt(textocod);
		
			productoBuscado = inventarioPointer.buscarProducto(codigoInt);
			
			if(productoBuscado == null)
				JOptionPane.showMessageDialog(null,"El producto " +codigoInt+ " no existe");
		
					
		} else { //si complete el campo PRODUCTO en el form
	
			productoBuscado = inventarioPointer.buscarProducto(textoprod);
			
			
			if(productoBuscado == null)
				JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " no existe");
		
	
		}
		
		return productoBuscado;
	}
	
//	public Producto buscarProducto(String textocod) 
//	{
//			
//		int codigo = Integer.parseInt(textocod);
//		inventarioPointer = Inventario.getInstancia();
//		
//		Producto productoBuscado = new Producto();	
//		
//		productoBuscado = inventarioPointer.buscarProducto(codigo);
//
//		
//		return productoBuscado;
//	}
}
