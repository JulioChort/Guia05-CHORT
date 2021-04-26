package guia5;

public class ServicioPersonalizado extends Servicio{

	
	public double calcularCosto(Trabajador t) {
		double resultado = 1000.0 + t.getCostoPorHora();		//Valor fijo para simplificar el sistema
		
		if(this.urgente)
			resultado *= 1.5;
		
		return resultado;
	}
}
