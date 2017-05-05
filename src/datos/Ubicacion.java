package datos;

public class Ubicacion {
	private String ciudad;
	private String pais;
	private String region;
	
	public Ubicacion(String ciudad, String pais, String region) {
		super();
		this.ciudad = ciudad;
		this.pais = pais;
		this.region = region;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

}
