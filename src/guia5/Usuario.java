package guia5;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	String nombre;
	String usuario;
	List<Contratable> trabajosYHerramientasContratadas;
	
	public Usuario(String n, String u) {
		this.nombre = n;
		this.usuario = u;
		this.trabajosYHerramientasContratadas = new ArrayList<Contratable>();
	}
	
	public String toString() {
		
		return "Usuario: "+this.usuario+", se llama realmente "+this.nombre;
	}

	public void contratar(Contratable cont) {
		
		
		cont.contratar();
		
		this.trabajosYHerramientasContratadas.add(cont);
		
		return;
	}
	
	

}
