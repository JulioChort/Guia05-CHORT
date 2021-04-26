package guia5;

import java.time.Instant;

public class Alquiler {
	
	Herramienta herramientaAlquilada;
	public Instant fechaInicio;
    public Instant fechaFinal; //Si es null, tomar como que no se devolvio. Se toma la fecha de hoy
    
    public Instant diaRealDevolucion;

    public double calcularCosto(){
    	double resultado = herramientaAlquilada.getCostoPorDia(); //* la cantidad de dias
    	
    	//TODO: Hacer algo si la herramienta no se devolvio en el dia pactado? Quizas cobrar un 50% mas
    	
    	return resultado;
    }

}
