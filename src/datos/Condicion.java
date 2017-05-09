package datos;

import java.util.Date;

public class Condicion {
	private int codigo;
	private int temperatura;
	private String descripcion;
	private Date dia;
	private Ubicacion ubicacion;
	private Viento viento;
	private Ambiente ambiente;
	private Astronomia astronomia;
		
	public Condicion(int codigo, int temperatura, String descripcion, Date dia, Ubicacion ubicacion, Viento viento,
			Ambiente ambiente, Astronomia astronomia) {
		super();
		this.codigo = codigo;
		this.temperatura = temperatura;
		this.descripcion = descripcion;
		this.dia = dia;
		this.ubicacion = ubicacion;
		this.viento = viento;
		this.ambiente = ambiente;
		this.astronomia = astronomia;
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

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Astronomia getAstronomia() {
		return astronomia;
	}

	public void setAstronomia(Astronomia astronomia) {
		this.astronomia = astronomia;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getDia() {
		return dia;
	}
	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	
}
