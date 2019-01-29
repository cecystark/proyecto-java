package menues;

import clases.Inventario;

public class ActualizacionStock {
	
	Inventario inventarioPointer;
	
		
	public void cargarMercaderia(String codigo,int cantidad) {
		
		inventarioPointer = Inventario.getInstancia();
		
		int code = Integer.parseInt(codigo);
		
		inventarioPointer.ingresarMercaderia(code, cantidad);

	}
	
	public boolean descargarMercaderia(String codigo,int cantidad) {
		
		//boolean sePudoRetirar; 
		
		inventarioPointer = Inventario.getInstancia();
		
		int code = Integer.parseUnsignedInt(codigo);
		
		return inventarioPointer.retirarMercaderia(code, cantidad);
		
		
			
	}


}
