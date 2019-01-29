package clases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Inventario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private List<Producto> listaDeProductos;
	private int nuevoNroCodigo;
    private static Inventario instancia;
  
    
    public List<Producto> getListaDeProductos(){
    	
    	return listaDeProductos;
    }
    
    private Inventario(){
    	listaDeProductos = new ArrayList<>();
    	nuevoNroCodigo = 0;

    }
    
  

    public static Inventario getInstancia(){
       if(instancia == null){
          instancia=new Inventario();
       }

       return instancia;
    }
	
	
	public int altaProducto(String nombre, String descripcion, int cantidad, String precio) {
		
		Producto nuevoProducto = null;

		
		if(buscarProducto(nombre)==null) {
			
			float f = Float.parseFloat(precio);
			
			nuevoProducto = new Producto(nombre, descripcion, cantidad, f);	
			
			nuevoProducto.setCodigo(nuevoNroCodigo);
			
			nuevoNroCodigo++;

			listaDeProductos.add(nuevoProducto);
		}
		
		return nuevoProducto.getCodigo();
	}
	
	public void guardarEnArchivo() {
		
		String fichero = "invent.txt";
		
		
		try {
				ObjectOutputStream ficheroSalida =  new ObjectOutputStream
						(new FileOutputStream(fichero));
				ficheroSalida.writeObject(listaDeProductos);
				ficheroSalida.flush();
				ficheroSalida.close();						
			
		} catch (IOException fnfe) {
			JOptionPane.showMessageDialog(null,"ERROR en la escritura del fichero ");
			
		}
		
		
	}
	
	public void levantarArchivo() {
		
		File archivo = new File("invent.txt");
		FileOutputStream salida = null;
		FileInputStream entrada = null;
		ObjectOutputStream writer = null;
		ObjectInputStream reader = null;
		
		
		try {
				entrada = new FileInputStream(archivo);
				reader = new ObjectInputStream(entrada);
				listaDeProductos = (ArrayList<Producto>) reader.readObject();
				
				
		} catch(IOException | ClassNotFoundException ex) {
			
			JOptionPane.showMessageDialog(null,"ERROR en la lectura del fichero ");
		}
		
	}
	
	public Producto buscarProducto(String nombre) {
		
		Producto productoBuscado = null;
		
		for( int i=0; i < listaDeProductos.size(); i++) {
			
			if(listaDeProductos.get(i).soyElProducto(nombre))
				productoBuscado = listaDeProductos.get(i);
		}
		
		return productoBuscado;
	}

	public Producto buscarProducto(int codigo) {
		
		Producto productoBuscado = null;
		
		for( int i=0; i < listaDeProductos.size(); i++) {
			
			if(listaDeProductos.get(i).soyElProducto(codigo))
				productoBuscado = listaDeProductos.get(i);
		}
		
		return productoBuscado;
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
