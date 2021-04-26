package guia5;

public abstract class Servicio {
	
	Oficio oficioAsociado;
    boolean urgente;

    public abstract double calcularCosto(Trabajador t);

}
