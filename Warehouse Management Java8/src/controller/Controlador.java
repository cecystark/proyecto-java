package controller;
import java.awt.event.ActionEvent;
import model.Sistema;
import view.Home;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Producto;
import model.Sistema;
//import view.InventarioRespuesta;
//import view.Menu;
//import view.ProductoRespuesta;

public  class Controlador implements ActionListener {
	
	private Home home; //vista
	private Sistema sistema; //modelo 
	
	public Controlador(Home home){
		
		this.home = home;
		this.sistema = Sistema.getInstance();
		
		JOptionPane.showMessageDialog(null, "Bienvenido"+sistema.toString());
		
		this.home.btn_ingresar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		home.setVisible(true);
		
		if(sistema.validarUsuario(home.textUsuario.getText(),home.textContrasenia.getText()))
			JOptionPane.showMessageDialog(null, "Bienvenido");
		else
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
	}
	
	public void validarIngreso(String usuario, String contrasenia){
		
		
//		Menu menu = new Menu();
		
		
//
//		if(sistema.validarUsuario(usuario, contrasenia)){
////			menu.setVisible(true);
////			dispose();
//			
//			JOptionPane.showMessageDialog(null, "Bienvenido");
//		}
//		else
//			JOptionPane.showMessageDialog(null, "Usuario o Contraseña incorrecta");
	}
	
	
	public void cargarMercaderia(String codigo, Object cantidad) {
		
		int codigoInt = Integer.parseInt(codigo);
		int cantidadInt = (int) cantidad;
		
		sistema = Sistema.getInstance();
		
		sistema.ingresarMercaderia(codigoInt, cantidadInt);

	}
	
	public void descargarMercaderia(String codigo, Object cantidad) {
		
		sistema = Sistema.getInstance();
		
		int codigoInt = Integer.parseUnsignedInt(codigo);
		int cantidadInt = (int) cantidad;
		
		boolean operacionOK = sistema.retirarMercaderia(codigoInt, cantidadInt);
		
		if (operacionOK)			
			JOptionPane.showMessageDialog(null,"La mercaderia ha sido retirada correctamente del sistema.");
		else 
			JOptionPane.showMessageDialog(null,"El stock es insuficiente, ingrese otra cantidad");
			
	}
	
	public Producto buscarProducto(String producto) 
		{
			sistema = Sistema.getInstance();
			
			Producto prodBuscado = sistema.buscarProducto(producto);
				
				if(prodBuscado == null)
					JOptionPane.showMessageDialog(null,"El producto " +producto+ " no existe");
			
			return prodBuscado;
		}

	public Producto buscarProducto(int producto) 
	 {
		 sistema = Sistema.getInstance();
				 
		 Producto prodBuscado = sistema.buscarProducto(producto);
			
		if(prodBuscado == null)
			JOptionPane.showMessageDialog(null,"El producto " +producto+ " no existe");
		
		return prodBuscado;
	}

	public void gestionarBaja(String producto) {
		
		sistema = Sistema.getInstance();
	
		if(sistema.buscarProducto(producto)!= null){ //si encuentro el producto, lo doy de baja sino aviso
			
			sistema.bajaProducto(producto);	
			JOptionPane.showMessageDialog(null,"El producto " +producto+ " fue dado exitosamente de BAJA en el sistema");
		}
			else
			JOptionPane.showMessageDialog(null,"El producto " +producto+ " no existe");
	}
	
	public void gestionarBaja(int producto) {
		
		sistema = Sistema.getInstance();
		
		if(sistema.buscarProducto(producto)!= null){ //si encuentro el producto, lo doy de baja sino aviso
			
			sistema.bajaProducto(producto);	
			JOptionPane.showMessageDialog(null,"El producto " +producto+ " fue dado exitosamente de BAJA en el sistema");
		}
			else
			JOptionPane.showMessageDialog(null,"El producto " +producto+ " no existe");	
	}

//	public void mostrarProducto(Producto producto) {
//		
//		sistema = Sistema.getInstance();
//		
//		String nombre;
//		int codigo;
//		String descripcion;
//		int cantidad;
//		float precio;
//		
//		if (producto!=null) {
//			ProductoRespuesta prodRespuesta = new ProductoRespuesta();
//			
//			nombre = producto.getNombre();
//			codigo = producto.getCodigo();
//			descripcion = producto.getDescripcion();
//			cantidad = producto.getCantidad();
//			precio = producto.getPrecio();
//				
//			
//			prodRespuesta.setVisible(true);
//			
//			prodRespuesta.getTable().setAutoResizeMode(cantidad);
//			prodRespuesta.getTable().setAlignmentY(0);
//			
//		
//			prodRespuesta.getTable().setModel((new DefaultTableModel(
//				new Object[][] {
//					{nombre,codigo, descripcion, cantidad, precio},
//				},
//				new String[] {
//					"Nombre", "Codigo", "Descripcion", "Cantidad", "Precio"
//				}
//			)));
//			
//			prodRespuesta.getTable().getColumnModel().getColumn(0).setPreferredWidth(130);
//			prodRespuesta.getTable().getColumnModel().getColumn(1).setPreferredWidth(130);
//			prodRespuesta.getTable().getColumnModel().getColumn(2).setPreferredWidth(130);
//			prodRespuesta.getTable().getColumnModel().getColumn(3).setPreferredWidth(130);
//			prodRespuesta.getTable().getColumnModel().getColumn(4).setPreferredWidth(130);
//			
//		}
//}
	
//	public void listarTodosLosProductos() {
//
//		sistema = Sistema.getInstance();
//		
//		List<Producto> listaDeProductos = sistema.verInventario();
//	
//		String nombre;
//		int codigo;
//		String descripcion;
//		int cantidad = 0;
//		float precio;
//		
//		InventarioRespuesta inventarioRespuesta = new InventarioRespuesta();
//		
//		nombre = listaDeProductos.get(0).getNombre();
//		codigo = listaDeProductos.get(0).getCodigo();
//		descripcion = listaDeProductos.get(0).getDescripcion();
//		cantidad = listaDeProductos.get(0).getCantidad();
//		precio = listaDeProductos.get(0).getPrecio();
//			
//		DefaultTableModel model = (DefaultTableModel) inventarioRespuesta.getTableInv().getModel();
//		
//		for(int i=0; i< listaDeProductos.size(); i++) {
//
//			nombre = listaDeProductos.get(i).getNombre();
//			codigo = listaDeProductos.get(i).getCodigo();
//			descripcion = listaDeProductos.get(i).getDescripcion();
//			cantidad = listaDeProductos.get(i).getCantidad();
//			precio = listaDeProductos.get(i).getPrecio();
//			
//			model.addRow(new Object[]{nombre, codigo, descripcion, cantidad, precio});
//			
//		}
//
//		inventarioRespuesta.setVisible(true);
//		inventarioRespuesta.getTableInv().setAutoResizeMode(cantidad);
//		inventarioRespuesta.getTableInv().setAlignmentY(0);
//		inventarioRespuesta.getTableInv().getColumnModel().getColumn(0).setPreferredWidth(130);
//		inventarioRespuesta.getTableInv().getColumnModel().getColumn(1).setPreferredWidth(130);
//		inventarioRespuesta.getTableInv().getColumnModel().getColumn(2).setPreferredWidth(130);
//		inventarioRespuesta.getTableInv().getColumnModel().getColumn(3).setPreferredWidth(130);
//		inventarioRespuesta.getTableInv().getColumnModel().getColumn(4).setPreferredWidth(130);
//		
//	}
//	

}
