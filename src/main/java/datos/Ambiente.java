package main.java.datos;

public class Ambiente {
	private int humedad;
	private double presion;
	private int indiceUv;
	private double visibilidad;
	
	public Ambiente(int humedad, double presion, int indiceUv, double visibilidad) {
		this.humedad = humedad;
		this.presion = presion;
		this.visibilidad = visibilidad;
		this.indiceUv = indiceUv;
	}
	public int getHumedad() {
		return humedad;
	}
	public void setHumedad(int humedad) {
		this.humedad = humedad;
	}
	public double getPresion() {
		return presion;
	}
	public void setPresion(double presion) {
		this.presion = presion;
	}
	public double getVisibilidad() {
		return visibilidad;
	}
	public void setVisibilidad(double visibilidad) {
		this.visibilidad = visibilidad;
	}
	public int getIndiceUv() {
		return indiceUv;
	}
	public void setIndiceUv(int indiceUv) {
		this.indiceUv = indiceUv;
	}
	
	
}

