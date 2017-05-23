package main.java.entity;

public class Astronomia {
	private int id;
	private String amanecer;
	private String atardecer;
	
	public Astronomia(){}
	
	public Astronomia(int id, String amanecer, String atardecer) {
		this.id=id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
