package guia5;

import java.time.Instant;
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

	public Trabajo contratar(Servicio serv, String desc, Instant fechaInic, Oficio of) { //String d, Instant fI, boolean u, Oficio o
		
		String descTrabajo = serv.getDescripcion()+" "+desc;
		
		Contratable tr1 = new Trabajo(descTrabajo, fechaInic, serv.getUrgencia(), of);
		
		this.trabajosYHerramientasContratadas.add(tr1);
		
		return (Trabajo) tr1;	//TODO: Probablemente cambiar/sacar el cast
	}
	
	

}
