package guia5;

public class ServicioEstandar extends Servicio{

	 public int costoServicio;
	 private double comisionTrabajador;	//El porcentaje se encuentra en el rango de [0.00; 1.00]
	 
	 public ServicioEstandar(String d, int cS, int cH, double cT) {
		 this.descripcion = d;
		 this.costoServicio = cS;
		 this.costoPorHoraTrabajador = cH;
		 this.comisionTrabajador = cT;
	 }

	 @Override
	  public double calcularCosto(){		  
		  	return(this.costoServicio + this.costoPorHoraTrabajador)*(1 + this.comisionTrabajador); 	//Supongo que el trabajo dura siempre dura 1 hora
	 }

	
}
