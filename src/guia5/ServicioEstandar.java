package guia5;

public class ServicioEstandar extends Servicio{

	 public int costo;
	 
	 public ServicioEstandar(String d, int c, boolean u) {
		 this.descripcion = d;
		 this.costo = c;
		 this.urgente = u;
	 }

	  public double calcularCosto(Trabajador t){
		  
		  	double resultado = costo+t.getCostoPorHora()+(costo+t.getCostoPorHora())*t.getPorcentajeComision(); //Supongo que siempre dura 1 hora
		  	
		  	//resultado += resultado*t.getPorcentajeComision();

		  	if(this.urgente)
		  		resultado *= 1.5;
		  			
	        return resultado;
	 }
	  
	/* public String getDescripcion() {
		 super();
	 }*/
	
	
}
