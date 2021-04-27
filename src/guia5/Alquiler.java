package guia5;

import java.time.Instant;

public class Alquiler implements Contratable{
	
	Herramienta herramientaAlquilada;
	public Instant fechaInicio;
	public Instant fechaFinal;
	public Instant diaRealDevolucion; //Si es null, tomar como que no se devolvio. Se toma la fecha de hoy
    
	
    
    
    public Alquiler(Herramienta h, Instant fI, Instant fF) {
		this.herramientaAlquilada = h;
		this.fechaInicio = fI;
		this.fechaFinal = fF;
	}

	public boolean enMora() {
    	
    	return ((this.diaRealDevolucion == null) || (this.fechaFinal.isBefore(this.diaRealDevolucion)));		
    }
    
    public boolean finalizado() {
    	
    	return (this.diaRealDevolucion != null);	
    }

	@Override
	public double costo() {
    	double resultado = herramientaAlquilada.getCostoPorDia()*this.cantidadDeDias(); 
    	
    	//TODO: Hacer algo si la herramienta no se devolvio en el dia pactado? Quizas cobrar un 50% mas
    	
    	return resultado;
	}

	@Override
	public void contratar() {
		
		
	}
	
	public int cantidadDeDias() {
		if(this.diaRealDevolucion == null) {
			return 0; //Hoy - fechaInicio
		}
		
		return 2; //fechaFinal - fechaInicio
	}

}
