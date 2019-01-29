package controller;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Inventario;
import model.Producto;
import view.ProductoRespuesta;

public class DatosProducto {
	
	private Inventario inventarioPointer;
	
	
	public void mostrarProducto(Producto producto) {
		
		inventarioPointer = Inventario.getInstancia();
		
		String nombre;
		int codigo;
		String descripcion;
		int cantidad;
		float precio;
		
		if (producto!=null) {
			ProductoRespuesta prodRespuesta = new ProductoRespuesta();
			
			nombre = producto.getNombre();
			codigo = producto.getCodigo();
			descripcion = producto.getDescripcion();
			cantidad = producto.getCantidad();
			precio = producto.getPrecio();
				
			
			prodRespuesta.setVisible(true);
			
			prodRespuesta.getTable().setAutoResizeMode(cantidad);
			prodRespuesta.getTable().setAlignmentY(0);
			
		
			prodRespuesta.getTable().setModel((new DefaultTableModel(
				new Object[][] {
					{nombre,codigo, descripcion, cantidad, precio},
				},
				new String[] {
					"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
				}
			)));
			
			prodRespuesta.getTable().getColumnModel().getColumn(0).setPreferredWidth(130);
			prodRespuesta.getTable().getColumnModel().getColumn(1).setPreferredWidth(130);
			prodRespuesta.getTable().getColumnModel().getColumn(2).setPreferredWidth(130);
			prodRespuesta.getTable().getColumnModel().getColumn(3).setPreferredWidth(130);
			prodRespuesta.getTable().getColumnModel().getColumn(4).setPreferredWidth(130);
			
		}
}
}
