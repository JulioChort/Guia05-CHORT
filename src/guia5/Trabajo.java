package guia5;

import java.time.LocalDate;

public class Trabajo implements Contratable{
	
	String descripcion;
	LocalDate fechaInicio;
	LocalDate fechaFinal;
	boolean urgente;
	Oficio oficioAsociado;
	Servicio servicioAsociado;
	
	public Trabajo(String d, LocalDate fI, boolean u, Oficio o, Servicio s) {
		this.descripcion = d;
		this.fechaInicio = fI;
		this.urgente = u;
		this.oficioAsociado = o;
		this.servicioAsociado = s;
	}
	
	public void setFechaFinal(LocalDate f) {
		this.fechaFinal = f;
	}

	public boolean finalizado() {
		
		return (this.fechaFinal != null); 
	}

	@Override
	public double costo() {
		return urgente? this.servicioAsociado.calcularCosto()*1.5 : this.servicioAsociado.calcularCosto();
	}
	
	@Override
	public String toString() {
		
		return  servicioAsociado.toString()+this.descripcion;
	}

}
