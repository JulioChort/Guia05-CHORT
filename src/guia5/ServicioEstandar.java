package guia5;

public class ServicioEstandar {

	 public double costo;

	 public double calcularCosto(Trabajador t){

	        return (costo+t.getCostoPorHora())*t.getPorcentajeComision();
	 }
	
	
}
