package menues;

import javax.swing.JOptionPane;

import clases.Inventario;
import clases.Producto;

public class BuscarProducto {
	
	private Inventario inventarioPointer;
	
	
	public Producto buscarProducto(String textoprod, String textocod) 
	{
		DatosProducto prodAMostrar = new DatosProducto();
		ProductoRespuesta prodRespuesta = new ProductoRespuesta();
		Producto productoBuscado = new Producto();	
		
		int codigo;
		
		inventarioPointer = Inventario.getInstancia();
		
		if (textoprod.isEmpty()) { //si complete el campo CODIGO en el form
		
			codigo = Integer.parseInt(textocod);
		
			productoBuscado = inventarioPointer.buscarProducto(codigo);

			
			if(productoBuscado == null)
				JOptionPane.showMessageDialog(null,"El producto " +codigo+ " no existe");
			//else 
			//	prodAMostrar.mostrarProducto(productoBuscado);
					
		} else { //si complete el campo PRODUCTO en el form
	
			productoBuscado = inventarioPointer.buscarProducto(textoprod);
			
			if(productoBuscado == null)
				JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " no existe");
			//else 
				
			//	prodAMostrar.mostrarProducto(productoBuscado);
	
		}
		
		return productoBuscado;
	}
	
	public Producto buscarProducto(String textocod) 
	{
		DatosProducto prodAMostrar = new DatosProducto();
		ProductoRespuesta prodRespuesta = new ProductoRespuesta();
		Producto productoBuscado = new Producto();	
		
		int codigo;
		
		inventarioPointer = Inventario.getInstancia();
		
		
			codigo = Integer.parseInt(textocod);
		
			productoBuscado = inventarioPointer.buscarProducto(codigo);

		
		return productoBuscado;
	}
}
