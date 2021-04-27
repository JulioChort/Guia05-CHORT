package guia5;

import java.time.Instant;

public class App {

	public static void main(String[] args) {
		
		Oficio o1 = new Oficio("Carpintero");
		
		Trabajador t1 = new Trabajador("Juan","juan@gmail.com",o1,150,5.0);
		
		Herramienta h1 = new Herramienta("Martillo", 200);
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		//Contratable panchito = new Trabajo("juan",);
		
		System.out.println(t1.toString());
		System.out.println(h1.toString());
		System.out.println(u1.toString());
		
		 
		
		
		
		
		// TODO: Implementar interfaz Contratable

	}
	
	public static void usuarioContrataUnTrabajo() {
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		Oficio o1 = new Oficio("Carpintero");
		
		Trabajador t1 = new Trabajador("Juan","juan@gmail.com",o1,150,5.0);
		
		Contratable tr1 = new Trabajo("Arreglar la puerta de madera",Instant.now(), false, o1);
		
		u1.contratar(tr1);
		
	}
	
public static void usuarioContrataUnaHerramienta() {
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		Herramienta h1 = new Herramienta("Martillo", 200);
		
		Contratable a1 = new Alquiler(h1,Instant.now(), Instant.now());
		
		u1.contratar(a1);
		
	}

	
	
	
	
}
