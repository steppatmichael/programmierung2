package le03;

/**
 * Beispiele für die Verwendung von Escapesequenzen mit der Methode String.format
 * Die Methode format erhält als ersten Parameter den auszugebenden String und die
 * darzustellenden Parameter
 * 
 * @author steppat
 *
 */
public class EscapeSequenzen {

	static void print(String string, Object... objects) {
		System.out.println(String.format(string, objects));
	}
	
	public static void main(String[] args) {
		// Folgende Werte sollen formatiert ausgegeben werden
		int x = 42;
		double pi = 3.14159265359;
		String s1 = "Hallo, ich bin ein String";
		String s2 = "... und ich ein zweiter :)";	
		
		// Formatierungen von Werten mit dem Prozentzeichen
		print("x hat den Wert: %d", x);
		print("x hat den Hexadezimalwert : %x", x);
		print("pi hat den Wert: %f", pi); 
		print("pi hat den Wert: %.2f", pi); 
		print("pi hat den Wert: %.12f", pi);
		print("Zwei Strings: %s %s", s1, s2);
		// Leerzeichen
		print("Tabellen: \n");
		// Tabellen
		print("A\tB\tC");
		print("1\t2\t3");
		
		
		
		
		
		
		

	}

}
