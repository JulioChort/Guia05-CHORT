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
		
		 
		
		//usuarioContrataUnTrabajo();
		
		usuarioNoPuedeContratarUnTrabajo();
		
		
		// TODO: Implementar interfaz Contratable

	}
	
	public static void usuarioContrataUnTrabajo() {
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		Oficio o1 = new Oficio("Carpintero");
		
		Trabajador t1 = new Trabajador("Juan","juan@gmail.com",o1,150,5.0);
		
		Servicio s1 = new ServicioEstandar("Arreglar",200, false);
		
		Contratable tr1 = u1.contratar(s1, "una puerta", Instant.now(),o1);
		
		try {
			
				t1.asignarTrabajo((Trabajo)tr1);	// TODO: Probablemente remover el cast

		} catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		/*catch(AgendaOcupadaException AgendOcup) {
			
			System.out.println(AgendOcup.getMessage());		
			AgendOcup.printStackTrace();
		}*/
		
		
		System.out.println("Salio todo bien.");
		
	}
	
public static void usuarioContrataUnaHerramienta() {
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		Herramienta h1 = new Herramienta("Martillo", 200);
		
		Contratable a1 = new Alquiler(h1,Instant.now(), Instant.now());
		
		//u1.contratar(a1);
		
	}

public static void usuarioNoPuedeContratarUnTrabajo() {
	
	Usuario u1 = new Usuario("Jose", "Jose1986");
	
	Oficio o1 = new Oficio("Carpintero");
	
	Oficio o2 = new Oficio("Electricista");
	
	Trabajador t1 = new Trabajador("Juan","juan@gmail.com",o1,150,5.0);
	
	Servicio s1 = new ServicioEstandar("Arreglar",200, false);
	
	Contratable tr1 = u1.contratar(s1, "una puerta", Instant.now(),o2);
	
	try {
		
			t1.asignarTrabajo((Trabajo)tr1);	// TODO: Probablemente remover el cast

	} catch(OficioNoCoincideException OfNoCoinc) {
		
		OfNoCoinc.printStackTrace();
	}
	/*catch(AgendaOcupadaException AgendOcup) {
		
		System.out.println(AgendOcup.getMessage());		
		AgendOcup.printStackTrace();
	}*/
	
	
	System.out.println("Salio todo bien.");
	
}
	
	
	
}
