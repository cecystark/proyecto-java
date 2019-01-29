package clases;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String descripcion;
	private int cantidad;
	private float precio;
	private int codigo;
	
	public boolean soyElProducto(String nombre) {
		
		return(this.nombre.equals(nombre));
	}
	
	
	public boolean soyElProducto(int codigo) {
		
		return(this.codigo == codigo);
	}
	
	
	//constructors
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	
	public Producto(String nombre, String descripcion, int cantidad, float precio) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;		
	}
	
	//setters


	public void setCantidad(int cantidad) {
		
		this.cantidad = cantidad;
	}
	
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	//getters
	
 	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}	
	
	public int getCantidad() {
		return cantidad;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	public int getCodigo() {
		return codigo;
	}
}
	
