package guia5;

import java.time.Instant;

public class Trabajo implements Contratable{
	
	String descripcion;
	Instant fechaInicio;
	Instant fechaFinal;
	boolean urgente;
	Oficio oficioAsociado;
	Servicio servicioAsociado;
	
	public Trabajo(String d, Instant fI, boolean u, Oficio o) {
		this.descripcion = d;
		this.fechaInicio = fI;
		this.urgente = u;
		this.oficioAsociado = o;
	}
	
	public void setFechaFinal(Instant f) {
		this.fechaFinal = f;
	}

	public boolean finalizado() {
		
		return (this.fechaFinal != null); 
	}

	@Override
	public double costo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void contratar() {
		
		
		
	}
}
