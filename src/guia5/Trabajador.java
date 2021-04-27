package guia5;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	
	 private String nombre;
	 private String email;
	 private Oficio oficio;
	 private int costoPorHora;
	 private double porcentajeComision;
	 List<Trabajo> trabajosAsignados;
	 

	 public int getCostoPorHora(){
	        return costoPorHora;
	 }

	 public double getPorcentajeComision(){
	        return porcentajeComision;
	 }
	 
	public List<Trabajo> getTrabajosAsignados() {
		return trabajosAsignados;
	}

	public Trabajador(String n, String e, Oficio o, int c, double p) {
		super();
		this.nombre = n;
		this.email = e;
		this.oficio = o;
		this.costoPorHora = c;
		this.porcentajeComision = p;
		this.trabajosAsignados = new ArrayList<Trabajo>();
	}

	public String toString() {
		
		return "Trabajador: "+this.nombre+", trabaja de "+this.oficio+", mail: "+this.email+" y cobra "+this.costoPorHora+" por hora de trabajo.";
	}

	public void asignarTrabajo(Trabajo trab) throws OficioNoCoincideException{ //TODO: Tiraria tambien AgendaOcupadaException
		
		if(trab.oficioAsociado != this.oficio) {
			
			throw new OficioNoCoincideException();
		} // Faltaria ver que no coincida la fecha
		
		
	}
	
	 
}
