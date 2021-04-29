package guia5;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {
		
		Oficio o1 = new Oficio("Carpintero");
		
		Trabajador t1 = new Trabajador("Juan","juan@gmail.com",o1);
		
		Herramienta h1 = new Herramienta("Martillo", 60);
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		Servicio s1 = new ServicioEstandar("arreglar ",200, 150, 0.05);
		 
		//////// Algunos casos de prueba //////// Descomentar 1 por 1 para no perderse
		
		//contratarUnTrabajo(u1, o1, t1, s1);		//El usuario contratata el trabajo y se le asigna a un trabajador sin problemas
		
		//noCoincideOficio(u1, o1, t1, s1);		//Tira la excepcion "OficioNoCoincideException"
		
		//agendaOcupada(u1, o1, t1, s1);		//Tira la excepcion "AgendaOcupadaException"
		
		//alquilarHerramienta(u1, h1);			//El usuario alquila una herramienta sin problemas
		
		//alquilarMasDe2Herramientas(u1, h1);	//Tira la excepcion "AlquilerNoEntregadoException"
		
		todosJuntos(u1, o1, t1, s1, h1);		//Todas las pruebas anteriores en una sola
		

	}
	
	public static void contratarUnTrabajo(Usuario u1, Oficio o1, Trabajador t1, Servicio s1) {
		
		Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o1, false);
		
		
		try {
			
				t1.asignarTrabajo((Trabajo)tr1);

		} 
		catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
				
			AgendOcup.printStackTrace();
		}
		finally {
			u1.deudaAcumulada();
		}
		
	}
	

	public static void noCoincideOficio(Usuario u1, Oficio o1, Trabajador t1, Servicio s1) {
	
		Oficio o2 = new Oficio("Electricista");
		
		Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o2, true);
		
		try {
			
				t1.asignarTrabajo((Trabajo)tr1);	
				
		} 
		catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
			
			AgendOcup.printStackTrace();
		}
		finally {
			u1.deudaAcumulada();
		}
	
}
	
	public static void agendaOcupada(Usuario u1, Oficio o1, Trabajador t1, Servicio s1) {
		
		Contratable tr2 = new Trabajo("una silla", LocalDate.of(2021,4,27), false, o1, new ServicioEstandar("reparar ", 120, 100, 0.03));
		
		Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o1, true);
		
		try {
			
				t1.asignarTrabajo((Trabajo) tr2);
			
				t1.asignarTrabajo((Trabajo) tr1);
				
		} 
		catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
			
			AgendOcup.printStackTrace();
		}
		finally {
			u1.deudaAcumulada();
		}
		
	}

	public static void alquilarHerramienta(Usuario u1, Herramienta h1) {
		
		try {
			
			Contratable a1 = u1.contratarAlquiler(h1, LocalDate.of(2021,4,27), LocalDate.of(2021,4,29)); 
			
			//((Alquiler) a1).setFechaRealDevolucion(LocalDate.of(2021,4,30));		//Por si se desea colocar una fecha de devolucion
				
			System.out.println(a1.toString());
			
		} 
		catch(AlquilerNoEntregadoException AlqNoEntregado) {
			
			AlqNoEntregado.printStackTrace();
		}
		finally {
			u1.deudaAcumulada();
		}
		
	}
	
	public static void alquilarMasDe2Herramientas(Usuario u1, Herramienta h1) {
		
		Herramienta h2 = new Herramienta("Destornillador", 85);
		
		Herramienta h3 = new Herramienta("Llave inglesa", 120);
		
		try {
			
			Contratable a1 = u1.contratarAlquiler(h1, LocalDate.of(2021,4,27), LocalDate.of(2021,4,29)); 
			System.out.println(a1.toString());
			
			Contratable a2 = u1.contratarAlquiler(h2, LocalDate.of(2021,4,27), LocalDate.of(2021,4,29));
			System.out.println(a2.toString());
			
			Contratable a3 = u1.contratarAlquiler(h3, LocalDate.of(2021,4,27), LocalDate.of(2021,4,29)); 
			System.out.println(a3.toString());
			
		} 
		catch(AlquilerNoEntregadoException AlqNoEntregado) {
			
			AlqNoEntregado.printStackTrace();
		}
		finally {
			u1.deudaAcumulada();
		}
		
	}
	
	public static void todosJuntos(Usuario u1, Oficio o1, Trabajador t1, Servicio s1, Herramienta h1) { //todosJuntos(u1, o1, t1, s1, h1)
		
		u1.deudaAcumulada();	//No tiene nada contratado
		
		Oficio o2 = new Oficio("Electricista");
		
		Herramienta h2 = new Herramienta("Destornillador", 85);
		
		Herramienta h3 = new Herramienta("Llave inglesa", 120);
		
		Servicio s2 = new ServicioPersonalizado("instalar ", 50, 200, 30, 500);
		
		Servicio s3 = new ServicioEstandar("arreglar ", 300, 50, 0.08);
		
		Contratable tr1 = u1.contratarServicio(s1, "una puerta", LocalDate.of(2021,4,27),o1, false);
		
		Contratable tr2 = u1.contratarServicio(s2, "una hamaca", LocalDate.of(2021,4,25),o2, true);
		
		Contratable tr3 = u1.contratarServicio(s3, "una silla", LocalDate.of(2021,4,27), o1, true);	
		
		try {
			
			t1.asignarTrabajo((Trabajo)tr1);

		} 
		catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
				
			AgendOcup.printStackTrace();
		}
		
		try {
			
			t1.asignarTrabajo((Trabajo)tr2);	
			
		} 
		catch(OficioNoCoincideException OfNoCoinc) {
		
		OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
		
		AgendOcup.printStackTrace();
		}
		
		try {
		
			t1.asignarTrabajo((Trabajo) tr3);
			
		} 
		catch(OficioNoCoincideException OfNoCoinc) {
			
			OfNoCoinc.printStackTrace();
		}
		catch(AgendaOcupadaException AgendOcup) {
			
			AgendOcup.printStackTrace();
		}
		
		try {
			
			Contratable a1 = u1.contratarAlquiler(h1, LocalDate.of(2021,4,27), LocalDate.of(2021,4,28)); 
			
		} 
		catch(AlquilerNoEntregadoException AlqNoEntregado) {
			
			AlqNoEntregado.printStackTrace();
		}
		try {
			Contratable a2 = u1.contratarAlquiler(h2, LocalDate.of(2021,4,27), LocalDate.of(2021,4,29));
			
			Contratable a3 = u1.contratarAlquiler(h3, LocalDate.of(2021,4,27), LocalDate.of(2021,4,29)); 
			
		} 
		catch(AlquilerNoEntregadoException AlqNoEntregado) {
			
			AlqNoEntregado.printStackTrace();
		}
		finally {
			
			u1.deudaAcumulada();
		}
		
		
		
		
	}
}
	

