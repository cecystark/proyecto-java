package controller;

import model.Producto;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private static Sistema instancia;
	
	private String nombreArchivo;
	private String usuario;
	private String contrasenia;
		
	public List<Producto> listaDeProductos;
	
	public Sistema() {
		this.nombreArchivo = "invent.txt";
		this.usuario = "admin";
		this.contrasenia = "admin";
		
		this.listaDeProductos = new ArrayList<>();
	}
	
	public static Sistema getInstancia() {
		if (instancia == null) {
		   instancia = new Sistema();
		}
		
		return instancia;
	}
	
	public boolean cargarArchivo() {
		boolean result = true;
		
		File archivo = new File(this.nombreArchivo);
		FileInputStream entrada;
		ObjectInputStream reader;
		
		try {
			archivo.createNewFile();
		} catch (IOException e1) {
			
			JOptionPane.showMessageDialog(null, "ERROR en la creacion del fichero");
		}
		
		try {
			entrada = new FileInputStream(archivo);
			reader = new ObjectInputStream(entrada);
			this.listaDeProductos = (ArrayList<Producto>) reader.readObject();
		}
		catch (IOException | ClassNotFoundException e ) {
			JOptionPane.showMessageDialog(null, "ERROR en la lectura del fichero");
			System.out.println(e.toString());
			result = false;
		}
		return result;
	}
	
	public boolean guardarArchivo() {
		boolean result = true;
		
		FileOutputStream salida;
		ObjectOutputStream writer;
		
		try {
			salida = new FileOutputStream(this.nombreArchivo);
			writer = new ObjectOutputStream(salida);
			writer.writeObject(this.listaDeProductos);
			writer.flush();
			writer.close();						
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "ERROR en la escritura del fichero");
			result = false;
		}
		
		return result;
	}
	
	public boolean validarUsuario(String user, String pass) {
		return usuario.equals(user) && contrasenia.equals(pass);
	}

}
