package guia5;

public class ServicioPersonalizado extends Servicio{

	int valorPresupuestado;
	int costoDeMateriales;
	int costoDeTransporte;
	
	public ServicioPersonalizado(String d, int vP, int cdM, int cdT, int cH) {
		this.descripcion = d;
		this.valorPresupuestado = vP;
		this.costoDeMateriales = cdM;
		this.costoDeTransporte = cdT;
		this.costoPorHoraTrabajador = cH;
	}
	@Override
	public double calcularCosto() {
		return this.valorPresupuestado+this.costoDeMateriales+this.costoDeTransporte + this.costoPorHoraTrabajador; //Supongo que el trabajo dura siempre dura 1 hora
	}
}
