package controller;

import javax.swing.JOptionPane;

import model.Inventario;

public class DatosBaja {
	
	private int codigo;
	
	
	public void gestionarBaja(String textoprod, String textocod) {
		
		Inventario inventarioPointer = Inventario.getInstancia();
	
		if (textoprod.isEmpty()) { //si complete el campo CODIGO en el form
		
			codigo = Integer.parseInt(textocod);
	
			if(inventarioPointer.buscarProducto(codigo)!= null) //si encuentro el codigo, lo doy de baja sino aviso
			{			
				inventarioPointer.bajaProducto(codigo);	
				JOptionPane.showMessageDialog(null,"El producto " +codigo+ " fue dado exitosamente de BAJA en el sistema");
			}
				else
					JOptionPane.showMessageDialog(null,"El producto " +codigo+ " no existe");
		}

		else { //si complete el campo PRODUCTO en el form
	
			if (inventarioPointer.buscarProducto(textoprod)!= null)
			{
				inventarioPointer.bajaProducto(textoprod);
				JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " fue dado de BAJA exitosamente en el sistema");
			}
			else
			JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " no existe");
		}
	}

}
