package le03;

import java.util.HashMap;
import java.util.Map;

public class AssociativeArray {
	// Enthält die Objektdaten die in der Liste gespeichert werden
	static class Person {
		String name;
		String vorname;
		String email;
		
		public Person(String vorname, String name) {
			this.vorname = vorname;
			this.name = name;
		}
		
		@Override
		public String toString() {
			if(email != null)
				return String.format("%s %s %s", vorname, name, email);	
			else
				return String.format("%s %s", vorname, name);	
		}
	}

	public static void main(String[] args) {
		// Deklaration des Objektbehälter
		Map<String, Person> map = new HashMap<String, Person>();
		
		// Einfügen von ein paar Objekten
		Person p = new AssociativeArray.Person("Monika", "Mustermann");
		map.put(p.name, p);
		
		p = new AssociativeArray.Person("Erika", "Gabler");
		map.put(p.name, p);
		
		p = new AssociativeArray.Person("James", "Bond");
		p.email = "james.bond@t-online.de";
		map.put(p.name, p);
		
		p = new AssociativeArray.Person("Hugo", "Drax");
		map.put(p.name, p);
		
		System.out.println(map.get("Gabler"));
		System.out.println(map.get("Bond"));
		System.out.println(map.get("Hugo"));
		System.out.println(map.get("Drax"));		
		
	}

}
