package menues;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import clases.Inventario;
import clases.Producto;

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
			
		
//		inventarioRespuesta.tableInv.setModel((new DefaultTableModel(
//				new Object[][] {
//					{nombre,codigo, descripcion, cantidad, precio},
//				}
//				,
//				new String[] {
//					"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
//				}
//			)));
			
		DefaultTableModel model = (DefaultTableModel) inventarioRespuesta.tableInv.getModel();
		
		for(int i=0; i< listaDeProductos.size(); i++) {

			nombre = listaDeProductos.get(i).getNombre();
			codigo = listaDeProductos.get(i).getCodigo();
			descripcion = listaDeProductos.get(i).getDescripcion();
			cantidad = listaDeProductos.get(i).getCantidad();
			precio = listaDeProductos.get(i).getPrecio();
			
			model.addRow(new Object[]{nombre, codigo, descripcion, cantidad, precio});
			
//			inventarioRespuesta.tableInv.setValueAt(nombre, i, 0);
//			inventarioRespuesta.tableInv.setValueAt(codigo, i, 1);
//			inventarioRespuesta.tableInv.setValueAt(descripcion, i, 2);
//			inventarioRespuesta.tableInv.setValueAt(cantidad, i, 3);
//			inventarioRespuesta.tableInv.setValueAt(precio, i, 4);
		}
		
//		for(int i= 0;i> listaDeProductos.size(); i++) {
//			
//			if (listaDeProductos!=null) {
//				
//				nombre = listaDeProductos.get(i).getNombre();
//				codigo = listaDeProductos.get(i).getCodigo();
//				descripcion = listaDeProductos.get(i).getDescripcion();
//				cantidad = listaDeProductos.get(i).getCantidad();
//				precio = listaDeProductos.get(i).getPrecio();
//					
//				
//			//	JOptionPane.showMessageDialog(null,"Nombre: " +nombre+ "Codigo: " +codigo+ "Descripcion: " +descripcion+ "Cantidad:" +cantidad+ "Precio:" +precio++);
//							
//				inventarioRespuesta.tableInv.setModel((new DefaultTableModel(
//					new Object[][] {
//						{nombre,codigo, descripcion, cantidad, precio},
//					},
//					new String[] {
//						"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
//					}
//				)));
//				
//				
//			}
			inventarioRespuesta.setVisible(true);
			inventarioRespuesta.tableInv.setAutoResizeMode(cantidad);
			inventarioRespuesta.tableInv.setAlignmentY(0);
			inventarioRespuesta.tableInv.getColumnModel().getColumn(0).setPreferredWidth(130);
			inventarioRespuesta.tableInv.getColumnModel().getColumn(1).setPreferredWidth(130);
			inventarioRespuesta.tableInv.getColumnModel().getColumn(2).setPreferredWidth(130);
			inventarioRespuesta.tableInv.getColumnModel().getColumn(3).setPreferredWidth(130);
			inventarioRespuesta.tableInv.getColumnModel().getColumn(4).setPreferredWidth(130);
		}
	
	}

