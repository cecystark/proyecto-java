package model;

import java.io.Serializable;
import java.util.List;

import controller.Sistema;

public class Inventario implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private List<Producto> listaDeProductos;
    private static Inventario instancia;
    
    
    private Inventario(){
    	listaDeProductos = Sistema.getInstancia().listaDeProductos;
    	
    }

    public static Inventario getInstancia(){
       if(instancia == null){
          instancia=new Inventario();
       }

       return instancia;
    }
	
	
	public int altaProducto(String nombre, String descripcion, Object cantidad, String precio) {
		
		Producto nuevoProducto = null;

		
		if(buscarProducto(nombre)==null) {
			
			float precioFloat = Float.parseFloat(precio);
			int cantidadInt = (int) cantidad;
			
			nuevoProducto = new Producto(nombre, descripcion, cantidadInt, precioFloat);	
			
			nuevoProducto.setCodigo(listaDeProductos.size()+1);
			
			listaDeProductos.add(nuevoProducto);			
		}
		
		return nuevoProducto.getCodigo();
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
