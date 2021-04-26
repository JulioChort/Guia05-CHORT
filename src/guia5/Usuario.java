package guia5;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	String nombre;
	String usuario;
	List<Servicio> serviciosContratados;
	List<Alquiler> alquileresContratados;
	
	public Usuario(String n, String u) {
		this.nombre = n;
		this.usuario = u;
		this.serviciosContratados = new ArrayList<Servicio>();
		this.alquileresContratados = new ArrayList<Alquiler>();
	}
	
	public String toString() {
		
		return "Usuario: "+this.usuario+", se llama realmente "+this.nombre;
	}

}
