package guia5;

public class AlquilerNoEntregadoException extends Exception{
	
	public AlquilerNoEntregadoException() {
		
		super("El usuario tiene 2 alquileres ya contratados sin devolver.");
	}

}
