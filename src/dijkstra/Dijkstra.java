package dijkstra;

import java.util.List;
import java.util.ArrayList;

public class Dijkstra {
	
	private List<Knoop> knopen;
	private List<Boog> bogen;	
	
	public Dijkstra() {
		knopen = new ArrayList<Knoop>();
		bogen = new ArrayList<Boog>();
	}
	
	public void addKnoop(String name) {
		knopen.add(new Knoop(name));
	}
	
	public void addKnoop(Knoop a) {
		knopen.add(a);
	}
	
	public void addBoog(Knoop a, Knoop b, int gewicht) {
		bogen.add(new Boog(a, b, gewicht));
	}
	
	public Knoop lookUpByName(String name) {
		for (Knoop knoop : knopen) {
			if (knoop.getName().equals(name)) {
				return knoop;
			}
		}
		
		return null;
	}
	
	public boolean containsKnoop(Knoop a) {
		return knopen.contains(a);
	}
	
	public boolean connectedWith(Knoop a, Knoop b) {
		for(Boog boog : bogen) {
			// Controleer of v het startpunt is van de boog
			if (boog.getA().equals(a) && boog.getB().equals(b)) {				
				return true;			
			}
			if (boog.getA().equals(b) && boog.getB().equals(a)) {				
				return true;			
			}
		}
		return false;
	}
	
	public Boog getBoog(Knoop a, Knoop b) {
		for(Boog boog : bogen) {
			// Controleer of v het startpunt is van de boog
			if (boog.getA().equals(a) && boog.getB().equals(b)) {				
				return boog;			
			}
			if (boog.getA().equals(b) && boog.getB().equals(a)) {				
				return boog;			
			}
		}
		
		return null;
	}
	
	// Bereken het kortste pad tussen a en b
	public void kortstePad(Knoop a, Knoop b) {
		
		List<Knoop> pad = new ArrayList<Knoop>();
		
		// ------------------
		// 1. Initialisatie
		// ------------------
		
		List<Knoop> T = new ArrayList<Knoop>();
		T = knopen;
		
		// definieer afbeelding L op V
		for(Knoop knoop : knopen) {
			knoop.setL(10000000); // oneindig
		}		
		
		a.setL(0);
		
		Knoop v =  null;		
		while (knopen.contains(b)) {		// 4. Test einde
 
			// ------------------
			// 2. Kies volgende
			// ------------------
			
			// Kies v element van T met kleinse L(v)
			
			v = null;
			int kleinsteGewicht = 1000000;
			
			for(Knoop knoop : T) {							
				if (knoop.getL() < kleinsteGewicht) {
					kleinsteGewicht = knoop.getL();
					v = knoop;
				}																
			}					
			
			// Zet T gelijk aan T\{v}
			T.remove(v);
			
			// ------------------
			// 3. Herbereken L
			// ------------------
			
			for(Knoop knoop : T) {
				if (connectedWith(knoop, v)) {
					Boog boog = getBoog(knoop, v);
				
					if(knoop.getL() > (v.getL() + boog.getGewicht())) {
						knoop.setI(v);
						knoop.setL(v.getL() + boog.getGewicht());
					}											
				}
			}		
			
		}
		
		// Print het resultaat		
		System.out.println("Lengte kortste pad = " + v.getL());
		
		System.out.println(b.getName() + ", ");
		Knoop k = b;
		while(k.getI() != a) {
			System.out.println(k.getI().getName() + ", ");
			k = k.getI();
		}
		System.out.println(k.getI().getName());
				
		
	}
}
