package guia5;

public class Herramienta {

	private String  nombre;
    public int costoPorDia;
    
    public Herramienta(String n, int c){
    	this.nombre = n;
    	this.costoPorDia = c;
    }
    
    public int getCostoPorDia() {
    	return costoPorDia;
    }
    
	public String toString() {
		
		return "Herramienta: "+this.nombre+" que cuesta "+this.costoPorDia+" por dia.";
	}
	
}
