package guia5;

public abstract class Servicio {

	protected String descripcion;
	protected int costoPorHoraTrabajador;	//Se supone que todos los trabajos duran siempre 1 hora
	
    public abstract double calcularCosto();
    
    public String getDescripcion() {
    	return this.descripcion;
    }
    
    public String toString() {
    	return this.descripcion;
    }

}
