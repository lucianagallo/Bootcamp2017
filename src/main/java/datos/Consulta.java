package main.java.datos;

import java.util.ArrayList;
import java.util.Date;

public class Consulta {
	private Date fechaConsulta;
	private ArrayList<ClimaDia> pronostico;
	private Condicion condicion;
	private double latitud;
	private double longitud;

	public Consulta(Date fechaConsulta, ArrayList<ClimaDia> pronostico, Condicion condicion, double latitud,
			double longitud) {
		this.fechaConsulta = fechaConsulta;
		this.pronostico = pronostico;
		this.condicion = condicion;
		this.latitud = latitud;
		this.longitud = longitud;
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

	public Condicion getCondicion() {
		return condicion;
	}

	public void setCondicion(Condicion condicion) {
		this.condicion = condicion;
	}

}
