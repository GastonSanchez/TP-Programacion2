package trabajoPractico;

import java.util.HashMap;
import java.util.Map.Entry;

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
		if (!this.destinos.containsKey(ubicacion)) {
			Destino d = new Destino(ubicacion, distancia);
			this.destinos.put(ubicacion, d);
		} else {
			throw new RuntimeException("El destino ya se encuentra agregado.");
		}
	}

	public void agregarTrailer(String patente, double cargaMax, double capacidadMax, boolean refrigerado,
			double costoKM, double seguroCarga) {
		Trailer trailer = new Trailer(patente, cargaMax, capacidadMax, refrigerado, costoKM, null, seguroCarga);
		this.transportes.put(patente, trailer);
	}

	public void agregarMegaTrailer(String patente, double cargaMax, double capacidadMax, boolean refrigerado,
			double costoKM, double seguroCarga, double costoFijo, double costoComida) {
		MegaTrailer megaTrailer = new MegaTrailer(patente, cargaMax, capacidadMax, refrigerado, costoKM, null,
				seguroCarga, costoFijo, costoComida);
		this.transportes.put(patente, megaTrailer);
	}

	public void agregarFlete(String patente, double cargaMax, double capacidadMax, double costoKM, int pasajeros,
			double costoPasajeros) {
		Flete flete = new Flete(patente, cargaMax, capacidadMax, costoKM, null, pasajeros, costoPasajeros);
		this.transportes.put(patente, flete);
	}

	public double obtenerCostoViaje(String patente) {
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

	public boolean incorporarPaquete(String destino, double peso, double volumen, boolean refrigerado) {
		Destino destPaquete = new Destino();
		destPaquete = destinos.get(destino);
		Paquete p = new Paquete(destPaquete, peso, volumen, refrigerado);
		if (p.esRefrigerado()) {
			return this.depoRefrigerado.incorporar(p);
		} else {
			return this.depoNoRefrigerado.incorporar(p);
		}

	}

	public String mostrarInventarioRefrigerado() {
		return depoRefrigerado.mostrarInventario();
	}

	public String mostrarInventarioNoRefrigerado() {
		return depoNoRefrigerado.mostrarInventario();
	}

	public void iniciarViaje(String patente) {
		transportes.get(patente).iniciarViaje();

	}

	public void finalizarViaje(String patente) {
		transportes.get(patente).finalizarViaje();

	}

	public double cargarTransporte(String patente) {
		if (transportes.get(patente).esRefrigerado()) {
			return transportes.get(patente).cargar(depoRefrigerado);
		} else {
			return transportes.get(patente).cargar(depoNoRefrigerado);
		}
	}

	public String obtenerTransporteIgual(String patente) {
		for (Entry<String, Transporte> t : transportes.entrySet()) {
			if (transportes.get(patente).getDest() == t.getValue().getDest()
					&& transportes.get(patente).getCargaActual() == t.getValue().getCargaActual()
					&& transportes.get(patente).tipoDeTransporte() == t.getValue().tipoDeTransporte() && transportes.get(patente).getId() != t.getValue().getId()) {
				return t.getKey();
			}
		}
		return null;
	}

}
