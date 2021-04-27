package guia5;

public abstract class Servicio {

	String descripcion;
    boolean urgente;

    public abstract double calcularCosto(Trabajador t);
    
    public String getDescripcion() {
    	return this.descripcion;
    }
    
    public boolean getUrgencia() {
    	return this.urgente;
    }

}
