package service;

import model.Producto;
import view.frames.ProductoRespuestaFrame;

import javax.swing.table.DefaultTableModel;

public class TablaProducto {

	public static final int ANCHO_COLUMNA = 130;

	public void mostrarProducto(Producto producto) {

		if (producto!=null) {
			ProductoRespuestaFrame prodRespuesta = new ProductoRespuestaFrame();

			prodRespuesta.setVisible(true);

			prodRespuesta.getTable().setAutoResizeMode(producto.getCantidad());
			prodRespuesta.getTable().setAlignmentY(0);

			prodRespuesta.getTable().setModel((new DefaultTableModel(
				new Object[][] {
					{
						producto.getNombre(),
						producto.getCodigo(),
						producto.getDescripcion(),
						producto.getCantidad(),
						producto.getPrecio()
					},
				},
				new String[] {
					"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
				}
			)));

			for (int i = 0; i < 5; i++) {
				prodRespuesta.getTable().getColumnModel().getColumn(i).setPreferredWidth(ANCHO_COLUMNA);
			}
		}
	}
}
