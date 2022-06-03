package trabajoPractico;

import java.util.HashMap;

public class Empresa {
	private String cuit;
	private String nombre;
	private Deposito depoRefrigerado;
	private Deposito depoNoRefrigerado;
	private HashMap<String, Destino> destinos = new HashMap<String, Destino>();
	private HashMap<String, Transporte> transportes = new HashMap<String, Transporte>();

	public Empresa(String cuit, String nombre, int capacidad) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
		this.depoRefrigerado = new Deposito(capacidad);
		this.depoNoRefrigerado = new Deposito(capacidad);
	}

	public void agregarDestino(String ubicacion, int distancia) {
		Destino d = new Destino(ubicacion, distancia);
		this.destinos.put(ubicacion, d);
	}

	public void agregarTrailer(String patente, double cargaMax, double capacidadMax, boolean refrigerado,
			double costoKM, double seguroCarga) {
		Trailer trailer = new Trailer(patente, cargaMax, capacidadMax, refrigerado, costoKM, null, seguroCarga);
		this.transportes.put(patente, trailer);
	}

	public void agregarMegaTrailer(String patente, double cargaMax, double capacidadMax, boolean refrigerado,
			double costoKM, double seguroCarga, double costoFijo, double costoComida) {
		MegaTrailer megaTrailer = new MegaTrailer(patente, cargaMax, capacidadMax, refrigerado, costoKM, null, seguroCarga,
				costoFijo, costoComida);
		this.transportes.put(patente, megaTrailer);
	}

	public void agregarFlete(String patente, double cargaMax, double capacidadMax, double costoKM, int pasajeros,
			double costoPasajeros) {
		Flete flete = new Flete(patente, cargaMax, capacidadMax, costoKM, null, pasajeros, costoPasajeros);
		this.transportes.put(patente, flete);
	}

	
	public double obtenerCostoViaje (String patente) {
		double costoViaje;
		costoViaje = transportes.get(patente).calcularCostoViaje();
		return costoViaje;
	}
	
	public void asignarDestino(String patente, String destino) {
		transportes.get(patente).asignarDestino(destinos.get(destino));
	}
	
	@Override
	public String toString() {
		return "Empresa: " + nombre + "\nCUIT: " + cuit + "\nCantidad de vehiculos: " + transportes.size();
	}

	
	public void incorporarPaquete(String destino, double peso, double volumen, boolean refrigerado) {
		Paquete p = new Paquete(destino, peso, volumen, refrigerado);
		if (p.esRefrigerado()) {
			this.depoRefrigerado.incorporar(p);
		} else {
			this.depoNoRefrigerado.incorporar(p);
		}

	}
	
	public String mostrarInventarioRefrigerado() {
		return depoRefrigerado.mostrarInventario();
	}
	
	public String mostrarInventarioNoRefrigerado() {
		return depoNoRefrigerado.mostrarInventario();
	}

}
