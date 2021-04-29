package guia5;

public class Oficio {
	
	String nombre;
	
	
	public Oficio(String n) {
		this.nombre = n;
	}
	
	public boolean isEqualsTo(Object o) {
		boolean resultado = false;
		
		if(o instanceof Oficio) {
			Oficio aux = (Oficio) o;
			
			if(aux.nombre == this.nombre)
				resultado = true;
		}
		
		return resultado;
	}
	
	public String toString() {
		return this.nombre;
	}

}
