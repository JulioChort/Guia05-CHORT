package guia5;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		
		Oficio o1 = new Oficio("Carpintero");
		
		Trabajador t1 = new Trabajador("Juan","juan@gmail.com",o1);
		
		Herramienta h1 = new Herramienta("Martillo", 60);
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		Servicio s1 = new ServicioEstandar("Arreglar ",200, 150, 0.05);
		 
		//////// Algunos casos de prueba //////// Descomentar 1 por 1 para no perderse
		
		contratarUnTrabajo(u1, o1, t1, s1);		//El usuario contratata el trabajo y se le asigna a un trabajador sin problemas
		
		noCoincideOficio(u1, o1, t1, s1);		//Tira la excepcion "OficioNoCoincideException"
		
		agendaOcupada(u1, o1, t1, s1);			//Tira la excepcion "AgendaOcupadaException"
		
		alquilarHerramienta(u1, h1);			//El usuario alquila una herramienta sin problemas
		
		//alquilarMasDe2Herramientas(u1, h1);	//Tira la excepcion "AlquilerNoEntregadoException"
		

	}
	
	public static void contratarUnTrabajo(Usuario u1, Oficio o1, Trabajador t1, Servicio s1) {
		
		Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o1, false);
		
		
		try {
			
				t1.asignarTrabajo((Trabajo)tr1);
				
				u1.deudaAcumulada();

		} catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
				
			AgendOcup.printStackTrace();
		}
		
	}
	

	public static void noCoincideOficio(Usuario u1, Oficio o1, Trabajador t1, Servicio s1) {
	
	Oficio o2 = new Oficio("Electricista");
	
	Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o2, true);
	
	try {
		
			t1.asignarTrabajo((Trabajo)tr1);	
			
	} catch(OficioNoCoincideException OfNoCoinc) {
		
		OfNoCoinc.printStackTrace();
	}
	catch(AgendaOcupadaException AgendOcup) {
		
		AgendOcup.printStackTrace();
	}
	
}
	
	public static void agendaOcupada(Usuario u1, Oficio o1, Trabajador t1, Servicio s1) {
		
		Contratable tr2 = new Trabajo("una silla", LocalDate.of(2021,4,27), false, o1, new ServicioEstandar("reparar ", 120, 100, 0.03));
		
		Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o1, true);
		
		try {
			
				t1.asignarTrabajo((Trabajo) tr2);
			
				t1.asignarTrabajo((Trabajo) tr1);
				
		} catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
			
			AgendOcup.printStackTrace();
		}
		
	}

	public static void alquilarHerramienta(Usuario u1, Herramienta h1) {
		
		try {
			
			Contratable a1 = u1.contratarAlquiler(h1, LocalDate.of(2021,4,27), LocalDate.of(2021,4,28)); 
				
			System.out.println(a1.toString());
			
		} catch(AlquilerNoEntregadoException AlqNoEntregado) {
			
			AlqNoEntregado.printStackTrace();
		}
		
	}
	
	public static void alquilarMasDe2HerramientasSinDevolver() {
		
		
		
		System.out.println("Salio todo bien.");
		
	}
	
}
