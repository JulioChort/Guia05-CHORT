package guia5;

import java.util.ArrayList;
import java.util.List;

public class Trabajador {
	
	
	 private String nombre;
	 private String email;
	 private Oficio oficio;
	 //private int costoPorHora;	
	 //private double porcentajeComision;		//De la consulta concluimos que estos valores estarán almacenados en Servicio
	 private List<Trabajo> trabajosAsignados;
	 
	 public Trabajador(String n, String e, Oficio o) {
			this.nombre = n;
			this.email = e;
			this.oficio = o;
			this.trabajosAsignados = new ArrayList<Trabajo>();
		}
	 
	public List<Trabajo> getTrabajosAsignados() {
		return trabajosAsignados;
	}
	
	public void aniadirTrabajo(Trabajo tr1) {
		this.trabajosAsignados.add(tr1);
	}


	public String toString() {
		
		return this.nombre+" que trabaja de "+this.oficio.toString()+", mail: "+this.email;
	}

	public void asignarTrabajo(Trabajo trab) throws OficioNoCoincideException, AgendaOcupadaException{ 
		
		if(trab.oficioAsociado != this.oficio) {
			
			throw new OficioNoCoincideException();
		}else if(this.coincideFecha(trab)) {
			
			throw new AgendaOcupadaException();
		}	
		
		this.aniadirTrabajo(trab);
		
		System.out.println("El trabajo "+trab.toString()+" se asignó exitosamente al trabajador "+this.toString());
	}
	
	public boolean coincideFecha(Trabajo tr1) {
		
		if(this.trabajosAsignados.isEmpty())
			return false;
		
		for(Trabajo t : this.trabajosAsignados) {
			
			if(t.fechaInicio.isEqual(tr1.fechaInicio))
				return true;
		}
			
		return false;
	}
	
	 
}
