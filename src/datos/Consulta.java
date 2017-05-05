package datos;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {
	private Date fechaConsulta;
	private ArrayList<ClimaDia> pronostico;
	private Ubicacion ubicacion;
	private Viento viento;
	private Ambiente ambiente;
	private Astronomia astronomia;
	private double latitud;
	private double longitud;
	private int tempActual;
	private String descripcion;

	public Consulta(Date fechaConsulta, ArrayList<ClimaDia> pronostico, Ubicacion ubicacion, Viento viento, Ambiente ambiente,
			Astronomia astronomia, double latitud, double longitud, int tempActual, String descripcion) {
		super();
		this.fechaConsulta = fechaConsulta;
		this.pronostico = pronostico;
		this.ubicacion = ubicacion;
		this.viento = viento;
		this.ambiente = ambiente;
		this.astronomia = astronomia;
		this.latitud = latitud;
		this.longitud = longitud;
		this.tempActual = tempActual;
		this.descripcion = descripcion;
	}


	public Date getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(Date fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}

	public ArrayList<ClimaDia> getPronostico() {
		return pronostico;
	}

	public void setPronostico(ArrayList<ClimaDia> pronostico) {
		this.pronostico = pronostico;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Viento getViento() {
		return viento;
	}

	public void setViento(Viento viento) {
		this.viento = viento;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAtmosfera(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Astronomia getAstronimia() {
		return astronomia;
	}

	public void setAstronimia(Astronomia astronomia) {
		this.astronomia = astronomia;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public int getTempActual() {
		return tempActual;
	}

	public void setTempActual(int tempActual) {
		this.tempActual = tempActual;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
