package guia5;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	
	 private String nombre;
	 private String email;
	 private String oficio;
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

	public Trabajador(String n, String e, String o, int c, double p) {
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
	 
	 
	 
}
