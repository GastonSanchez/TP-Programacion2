package trabajoPractico;

import java.util.ArrayList;

public class Deposito {

	private int capacidad;
	private boolean refrigerado;
	private ArrayList <Paquete> inventario = new ArrayList <Paquete>();
	private double cargaActual;
	
	public Deposito (int volumen) {
		this.capacidad=volumen;
	}
	
	public boolean incorporar(Paquete p) {
		if(this.capacidad>= cargaActual + p.getVolumen()) {
			this.inventario.add(p);
			this.cargaActual+=p.getVolumen();
			return true;
		} else {
			return false;
		}
	}
	
	public String mostrarInventario () {
		return "Carga actual: "+ cargaActual + "\nInventario:" + this.inventario.toString();
	}
	
	
}
