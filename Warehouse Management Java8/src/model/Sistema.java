package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private String nombreArchivo;
	private String usuario;
	private String contrasenia;	
	private List<Producto> listaDeProductos;
	private static Sistema instanciaUnica; 
	
	public Sistema() {	
		this.listaDeProductos = new ArrayList<>();
	}
	
	private synchronized static void createInstance() {
		if(instanciaUnica == null) {
			instanciaUnica = new Sistema();
		}
	}
	
	public static Sistema getInstance() {
		createInstance();
		
		return instanciaUnica;
	}
	
	@SuppressWarnings("unchecked")
 	public boolean cargarArchivo() {
		boolean result = true;
		
		File archivo = new File("inventario.txt");
		FileInputStream entrada = null;
		ObjectInputStream reader = null;
		
		try {
			archivo.createNewFile();
		} catch (IOException e1) {
			
		}
		
		try {
			entrada = new FileInputStream(archivo);
			reader = new ObjectInputStream(entrada);
			this.listaDeProductos = (ArrayList<Producto>) reader.readObject();
		}
		catch (IOException | ClassNotFoundException e ) {

			//System.out.println(e.toString());
			result = false;
		}
		return result;
	}
	
	public boolean guardarArchivo() {
		boolean result = true;
		
		FileOutputStream salida = null;
		ObjectOutputStream writer = null;
		
		try {
			salida = new FileOutputStream(this.nombreArchivo);
			writer = new ObjectOutputStream(salida);
			writer.writeObject(this.listaDeProductos);
			writer.flush();
			writer.close();						
		}
		catch (IOException e) {

			result = false;
		}
		
		return result;
	}
		
	public void establishDatosUsuario(){
		String usuario="admin";
		String contrasenia="admin";
	}
	
	public boolean validarUsuario(String user, String pass) {
		this.establishDatosUsuario();
		return usuario.equals(user) && contrasenia.equals(pass);
	}
	
	public Producto buscarProducto(String prodBuscado) 
	{	
		Producto producto = (Producto) listaDeProductos.stream().filter(p->p.getNombre().equals(prodBuscado));			
		
		return producto;
	}
	
	public Producto buscarProducto(int prod_busc) 
	{
		Producto producto = (Producto) listaDeProductos.stream().filter(p->p.getCodigo()==prod_busc);			
		
		return producto;
	}
	
	public int altaProducto(String nombre, String descripcion, int cantidad, float precio) {
		
		Producto nuevoProducto=null;
	
		if(buscarProducto(nombre)==null) //verifico que no exista antes de crearlo
		{
			
			nuevoProducto = new Producto(nombre, descripcion, cantidad, precio);	
			
			nuevoProducto.setCodigo(listaDeProductos.size()+1);
			
			listaDeProductos.add(nuevoProducto);			
		}
		
		return nuevoProducto.getCodigo();
	}

	public void bajaProducto(int codigo){
		
		listaDeProductos.remove(buscarProducto(codigo));
	}

	public void bajaProducto(String producto){
		
		listaDeProductos.remove(buscarProducto(producto));
	}

	public boolean retirarMercaderia(int codigo, int cantidad) {
		
		boolean sePudo;
		Producto prod;
		prod = new Producto();
		
		prod = buscarProducto(codigo);
		
		if(cantidad<=prod.getCantidad()) {
			
			prod.setCantidad(prod.getCantidad()-cantidad);			
			sePudo= true;
		}
		else
			sePudo =false;
		
		return sePudo;
	}

	public void ingresarMercaderia(int codigo, int cantidad) {
		
		Producto prod;
		prod = new Producto();
		
		prod = buscarProducto(codigo);
		
		prod.setCantidad(prod.getCantidad()+cantidad);	
	}

	public List<Producto> verInventario() {
		
		return listaDeProductos;
	
	}

}





