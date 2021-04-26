package guia5;

public class App {

	public static void main(String[] args) {
		
		Trabajador t1 = new Trabajador("Juan","juan@gmail.com","Carpintero",150,5.0);
		
		Herramienta h1 = new Herramienta("Martillo", 200);
		
		Usuario u1 = new Usuario("Jose", "Jose1986");
		
		System.out.println(t1.toString());
		System.out.println(h1.toString());
		System.out.println(u1.toString());
		
		
		
		

		// TODO: Implementar interfaz Contratable

		// TODO: OficioNoCoincideException
		//       AgendaOcupadaException
		//       AlquilerNoEntregadoException

	}

}
