package model;

public class Producto {
	
	private String nombre;
	private String descripcion;
	private int cantidad;
	private float precio;
	private int codigo;

	//constructors
	
	public Producto() {

	}
	
	public Producto(String nombre, String descripcion, int cantidad, float precio) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;		
	}
	
	//setters
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
	

