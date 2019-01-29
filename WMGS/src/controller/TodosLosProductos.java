package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Inventario;
import model.Producto;
import view.InventarioRespuesta;


public class TodosLosProductos {
	
	private Inventario inventarioPointer;
	private DatosProducto productoAMostrar;
	private List<Producto> listaDeProductos;
	
	public void listarTodosLosProductos() {

		inventarioPointer = Inventario.getInstancia();
		
		listaDeProductos = inventarioPointer.verInventario();
	
		String nombre;
		int codigo;
		String descripcion;
		int cantidad = 0;
		float precio;
		
		InventarioRespuesta inventarioRespuesta = new InventarioRespuesta();
		
		nombre = listaDeProductos.get(0).getNombre();
		codigo = listaDeProductos.get(0).getCodigo();
		descripcion = listaDeProductos.get(0).getDescripcion();
		cantidad = listaDeProductos.get(0).getCantidad();
		precio = listaDeProductos.get(0).getPrecio();
			
		DefaultTableModel model = (DefaultTableModel) inventarioRespuesta.getTableInv().getModel();
		
		for(int i=0; i< listaDeProductos.size(); i++) {

			nombre = listaDeProductos.get(i).getNombre();
			codigo = listaDeProductos.get(i).getCodigo();
			descripcion = listaDeProductos.get(i).getDescripcion();
			cantidad = listaDeProductos.get(i).getCantidad();
			precio = listaDeProductos.get(i).getPrecio();
			
			model.addRow(new Object[]{nombre, codigo, descripcion, cantidad, precio});
			
		}

		inventarioRespuesta.setVisible(true);
		inventarioRespuesta.getTableInv().setAutoResizeMode(cantidad);
		inventarioRespuesta.getTableInv().setAlignmentY(0);
		inventarioRespuesta.getTableInv().getColumnModel().getColumn(0).setPreferredWidth(130);
		inventarioRespuesta.getTableInv().getColumnModel().getColumn(1).setPreferredWidth(130);
		inventarioRespuesta.getTableInv().getColumnModel().getColumn(2).setPreferredWidth(130);
		inventarioRespuesta.getTableInv().getColumnModel().getColumn(3).setPreferredWidth(130);
		inventarioRespuesta.getTableInv().getColumnModel().getColumn(4).setPreferredWidth(130);
		
	}
	
	}

