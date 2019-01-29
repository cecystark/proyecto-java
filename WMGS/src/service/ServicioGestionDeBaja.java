package service;

import model.Inventario;

import javax.swing.*;

public class ServicioGestionDeBaja {

	public void gestionarBaja(String textoprod) {
		Inventario inventarioPointer = Inventario.getInstancia();
		if (inventarioPointer.buscarProducto(textoprod)!= null)
		{
			inventarioPointer.bajaProducto(textoprod);
			JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " fue dado de BAJA exitosamente en el sistema");
		}
		else
			JOptionPane.showMessageDialog(null,"El producto " +textoprod+ " no existe");
	}
	public void gestionarBaja(int textocod) {
		Inventario inventarioPointer = Inventario.getInstancia();

		if(inventarioPointer.buscarProducto(textocod)!= null) //si encuentro el codigo, lo doy de baja sino aviso
		{
			inventarioPointer.bajaProducto(textocod);
			JOptionPane.showMessageDialog(null,"El producto " +textocod+ " fue dado exitosamente de BAJA en el sistema");
		}
		else
			JOptionPane.showMessageDialog(null,"El producto " +textocod+ " no existe");

	}
}
