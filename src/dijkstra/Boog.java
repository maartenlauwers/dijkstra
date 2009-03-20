package dijkstra;

public class Boog {

	private Knoop a;
	private Knoop b;
	private int gewicht;
	
	public Boog(Knoop a, Knoop b, int gewicht) {
		this.a = a;
		this.b = b;
		this.gewicht = gewicht;
	}
	
	public Knoop getA() {
		return a;
	}

	public void setA(Knoop a) {
		this.a = a;
	}

	public Knoop getB() {
		return b;
	}

	public void setB(Knoop b) {
		this.b = b;
	}

	public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
		
}
