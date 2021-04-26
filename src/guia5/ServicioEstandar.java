package guia5;

public class ServicioEstandar extends Servicio{

	 public double costo;

	  public double calcularCosto(Trabajador t){
		  
		  	double resultado = costo+t.getCostoPorHora()+(costo+t.getCostoPorHora())*t.getPorcentajeComision();
		  	
		  	//resultado += resultado*t.getPorcentajeComision();

		  	if(this.urgente)
		  		resultado *= 1.5;
		  			
	        return resultado;
	 }
	
	
}
