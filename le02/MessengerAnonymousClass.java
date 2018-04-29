public class Messenger {
	
	// funktionales Interface f�r die Ausgabe der Nachricht
	interface Printer {
		void message();
	} 
	static Printer printer;
		
	// Setzen der Ausgabe
	static void registerPrinter(Printer p) {
		printer = p;		
	}	
	// Nachricht ausgeben
	static void showMessage() {
		printer.message();
	}
	
	public static void main(String[] args) {
		
		// direkte Implemetierung von Printer bei der
		// Parameter�bergabe mit anonymer Klasse
		
		registerPrinter(new Printer() {
			@Override
			public void message() {
				System.out.println("Hello World");				
			}	
		});			
		showMessage();		 
	}
}
