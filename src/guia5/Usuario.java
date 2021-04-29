package guia5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private String usuario;
	private List<Contratable> misContratados;
	
	public Usuario(String n, String u) {
		this.nombre = n;
		this.usuario = u;
		this.misContratados = new ArrayList<Contratable>();
	}
	
	public String toString() {
		
		return "Usuario: "+this.usuario+", se llama realmente "+this.nombre;
	}

	public Trabajo contratarServicio(Servicio serv, String desc, LocalDate fechaInic, Oficio of, Boolean urgencia) { 
		
		Contratable tr1 = new Trabajo(desc, fechaInic, urgencia, of, serv);
		
		this.aniadirContratable(tr1);
		 
		return (Trabajo) tr1;	
	}

	public Alquiler contratarAlquiler (Herramienta h1, LocalDate fecInic, LocalDate fecFinal) throws AlquilerNoEntregadoException {
		
		Contratable a1 = new Alquiler(h1, fecInic, fecFinal);
		
		if(this.contieneDosAlquileres()) {
			
			throw new AlquilerNoEntregadoException();
		}
		
		this.aniadirContratable(a1);
		
		return (Alquiler) a1;
	}
	
	public void aniadirContratable(Contratable c1) {
		this.misContratados.add(c1);
	}
	
	public boolean contieneDosAlquileres() {
		
		if(!this.misContratados.isEmpty()) {
			
			int apariciones = 0;
			
			for(Contratable c : this.misContratados) {
				
				if(c instanceof Alquiler) 
					if(!c.finalizado())
						apariciones++;
				
				if(apariciones > 1)
					return true;
			}
		}
		
		return false;
	}
	
	public void deudaAcumulada() {
		
		if(this.misContratados.isEmpty()) {
			System.out.println("El usuario no tiene ni trabajos ni alquileres contratados.");
		}else {
			
			System.out.println("El usuario debe pagar los siguientes alquieres/trabajos: ");
			
			for(Contratable c : this.misContratados) {
				
				System.out.println("	- Debe "+c.costo()+" de "+c.toString());
			}
		}
	}
	
	

}
