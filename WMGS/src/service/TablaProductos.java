package service;

import model.Inventario;
import model.Producto;
import view.frames.InventarioRespuestaFrame;

import javax.swing.table.DefaultTableModel;
import java.util.List;


public class TablaProductos {

	public static final int ANCHO_COLUMNA = 130;
	private Inventario inventarioPointer;
	private List<Producto> listaDeProductos;
	
	public void listarTodosLosProductos() {

		inventarioPointer = Inventario.getInstancia();
		
		listaDeProductos = inventarioPointer.verInventario();
		
		InventarioRespuestaFrame inventarioRespuesta = new InventarioRespuestaFrame();

		DefaultTableModel model = (DefaultTableModel) inventarioRespuesta.getTableInv().getModel();

		listaDeProductos.forEach(p -> model.addRow(
			new Object[]{
				p.getNombre(),
				p.getCodigo(),
				p.getDescripcion(),
				p.getCantidad(),
				p.getPrecio()
			}));

		inventarioRespuesta.setVisible(true);
		inventarioRespuesta.getTableInv().setAutoResizeMode(0);
		inventarioRespuesta.getTableInv().setAlignmentY(0);
		for (int i = 0; i < 5; i++) {
			inventarioRespuesta.getTableInv().getColumnModel().getColumn(i).setPreferredWidth(ANCHO_COLUMNA);
		}
	}
}

