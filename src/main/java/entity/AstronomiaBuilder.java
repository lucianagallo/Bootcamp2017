package main.java.entity;

public class AstronomiaBuilder {
	private int id;
	private String amanecer;
	private String atardecer;

	AstronomiaBuilder withId(int i) {
		id = i;
		return this;
	}

	AstronomiaBuilder withAmanecer(String am) {
		amanecer = am;
		return this;
	}

	AstronomiaBuilder withAtardecer(String at) {
		atardecer = at;
		return this;
	}

	Astronomia build() {
		Astronomia a = new Astronomia();
		a.setId(this.id);
		a.setAmanecer(this.amanecer);
		a.setAtardecer(this.atardecer);
		return a;
	}
}
