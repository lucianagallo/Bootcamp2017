package main.java.modelo;

public class Astronomia {
	private String amanecer;
	private String atardecer;
	
	public Astronomia(String amanecer, String atardecer) {
		super();
		this.amanecer = amanecer;
		this.atardecer = atardecer;
	}
	public String getAmanecer() {
		return amanecer;
	}
	public void setAmanecer(String amanecer) {
		this.amanecer = amanecer;
	}
	public String getAtardecer() {
		return atardecer;
	}
	public void setAtardecer(String atardecer) {
		this.atardecer = atardecer;
	}

	
}
