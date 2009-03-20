package dijkstra;

public class Knoop {
	
	private String name;
	private int L;			// afbeelding L(knoop) (1000000 = oneindig)
	private Knoop I;
	
	public Knoop(String name) {
		this.name = name;
		this.L = 0;
		this.I = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getL() {
		return L;
	}
	
	public void setL(int L) {
		this.L = L;
	}
	
	public Knoop getI() {
		return I;
	}
	
	public void setI(Knoop I) {
		this.I = I;
	}
}
