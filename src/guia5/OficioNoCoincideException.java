package guia5;

public class OficioNoCoincideException extends Exception{
	
	public OficioNoCoincideException() {
		
		super("El oficio del trabajo no coincide con el del trabajador.");
	}

}
