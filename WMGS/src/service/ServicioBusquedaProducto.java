package service;

import javax.swing.JOptionPane;

import model.Inventario;
import model.Producto;

public class ServicioBusquedaProducto {

	private Inventario inventarioPointer;

	public Producto buscarProducto(String textoprod) {
		inventarioPointer = Inventario.getInstancia();
		Producto productoBuscado = inventarioPointer.buscarProducto(textoprod);


		if (productoBuscado == null)
			JOptionPane.showMessageDialog(null, "El producto " + textoprod + " no existe");
		return productoBuscado;
	}

	public Producto buscarProducto(int textocod) {
		inventarioPointer = Inventario.getInstancia();
		int codigoInt;
		codigoInt = textocod;

		Producto productoBuscado = inventarioPointer.buscarProducto(codigoInt);

		if (productoBuscado == null)
			JOptionPane.showMessageDialog(null, "El producto " + codigoInt + " no existe");
		return productoBuscado;
	}
}
