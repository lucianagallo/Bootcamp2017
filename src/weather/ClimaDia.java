package weather;

import java.util.Date;

public class ClimaDia {
	
	private int codigo;
	private Date fecha;
	private String dia;
	private int max;
	private int min;
	private String descripcion;
	
	public ClimaDia(int codigo, Date fecha, String dia, int max, int min, String descripcion) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.dia = dia;
		this.max = max;
		this.min = min;
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
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
