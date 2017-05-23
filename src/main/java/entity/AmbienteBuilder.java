package main.java.entity;

public class AmbienteBuilder {
	private int id;
	private int humedad;
	private double presion;
	private int indiceUv;
	private double visibilidad;
	
	public AmbienteBuilder withHumedad(int h){
		humedad = h;
		return this;
	}
	AmbienteBuilder withPresion(double p){
		presion = p;
		return this;
	}
	AmbienteBuilder withIndiceUv(int i){
		indiceUv=i;
		return this;
	}
	AmbienteBuilder withVisibilidad(double v){
	 visibilidad=v;
	 return this;
	}
	AmbienteBuilder withId(int i){
		id=i;
		return this;
	}
	Ambiente build(){
		Ambiente a = new Ambiente();
		a.setId(this.id);
		a.setHumedad(this.humedad);
		a.setIndiceUv(this.indiceUv);
		a.setPresion(this.presion);
		a.setVisibilidad(this.visibilidad);
		return a;
	}
}