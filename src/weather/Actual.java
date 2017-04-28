package weather;

import java.util.Date;

public class Actual {
	private int codigo;
	private Date fecha;
	private int temperatura;
	private String descripcion;
	
	public Actual(int codigo, Date fecha, int temperatura, String descripcion) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.temperatura = temperatura;
		this.descripcion = descripcion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

}
