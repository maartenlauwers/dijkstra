package dijkstra;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dijkstra dijkstra = new Dijkstra();
		
		Knoop a = new Knoop("a");
		Knoop b = new Knoop("b");
		Knoop c = new Knoop("c");
		Knoop d = new Knoop("d");
		Knoop z = new Knoop("z");
		
		dijkstra.addKnoop(a);
		dijkstra.addKnoop(b);
		dijkstra.addKnoop(c);
		dijkstra.addKnoop(d);
		dijkstra.addKnoop(z);
		
		dijkstra.addBoog(a, b, 3);
		dijkstra.addBoog(a, d, 4);
		dijkstra.addBoog(b, c, 2);
		dijkstra.addBoog(c, z, 1);		
		dijkstra.addBoog(d, z, 5);
		
		dijkstra.kortstePad(a, z);
		System.exit(0);

	}

}
