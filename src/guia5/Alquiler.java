package guia5;

import java.time.Duration;
import java.time.LocalDate;

public class Alquiler implements Contratable{
	
	private Herramienta herramientaAlquilada;
	public LocalDate fechaInicio;
	public LocalDate fechaFinal;
	public LocalDate fechaRealDevolucion; //Si es null, tomar como que no se devolvio. Se toma la fecha de hoy
    
    
    public Alquiler(Herramienta h, LocalDate fI, LocalDate fF) { //Estaria bien pasarle el usuario? Para tener un registro de los usuarios en la lista de alquileres
		this.herramientaAlquilada = h;
		this.fechaInicio = fI;
		this.fechaFinal = fF;
	}

	public boolean enMora() {
    	
    	return ((this.fechaRealDevolucion == null && this.fechaFinal.isBefore(LocalDate.now())) || (this.fechaFinal.isBefore(this.fechaRealDevolucion)));		
    }
    
    public boolean finalizado() {
    	
    	return (this.fechaRealDevolucion != null);	
    }

	@Override
	public double costo() {
    	double resultado = herramientaAlquilada.getCostoPorDia()*this.cantidadDeDias(); 
    	
    	if(this.enMora()) 
    		resultado *= 1.5;	//Le sumo un 50% porque está atrasado (de onda)
    	
    	return resultado;
	}

	
	public int cantidadDeDias() {
		
		if(this.fechaRealDevolucion == null) {
			return (int) Duration.between(this.fechaInicio, LocalDate.now()).toDaysPart(); //Casteado a int porque devuelve en long
		}

		return (int) Duration.between(this.fechaInicio, this.fechaFinal).toDaysPart();
	}
	
	@Override
	public String toString() {
		
		return "Herramienta alquilada: "+this.herramientaAlquilada+", desde: "+this.fechaInicio+" hasta: "+this.fechaFinal+", fecha real de devolución "+this.fechaRealDevolucion;
	}

}
