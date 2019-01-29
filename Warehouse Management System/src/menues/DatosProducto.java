package menues;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import clases.Inventario;
import clases.Producto;

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
				
		//	JOptionPane.showMessageDialog(null,"Nombre: " +nombre+ "Codigo: " +codigo+ "Descripcion: " +descripcion+ "Cantidad:" +cantidad+ "Precio:" +precio++);
			
			prodRespuesta.setVisible(true);
			
			prodRespuesta.table.setAutoResizeMode(cantidad);
			prodRespuesta.table.setAlignmentY(0);
			
		
			prodRespuesta.table.setModel((new DefaultTableModel(
				new Object[][] {
					{nombre,codigo, descripcion, cantidad, precio},
				},
				new String[] {
					"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
				}
			)));
			
			prodRespuesta.table.getColumnModel().getColumn(0).setPreferredWidth(130);
			prodRespuesta.table.getColumnModel().getColumn(1).setPreferredWidth(130);
			prodRespuesta.table.getColumnModel().getColumn(2).setPreferredWidth(130);
			prodRespuesta.table.getColumnModel().getColumn(3).setPreferredWidth(130);
			prodRespuesta.table.getColumnModel().getColumn(4).setPreferredWidth(130);
			
		}
}
}
