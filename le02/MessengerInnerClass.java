package le02;

public class MessengerInnerClass {
	
	// funktionales Interface für die Ausgabe der Nachricht
	interface Printer {
		void message();
	} 
	static Printer printer;
	
	// 1. Implementierung von Printer
	static class HelloPrinter implements Printer {

		@Override
		public void message() {
			System.out.println("Hello :)");			
		}		
	}
	
	// 2. Implementierung von Printer
	static class OrderPrinter implements Printer {

		@Override
		public void message() {
			System.out.println("Do Something!");			
		}
		
	}	
	// Setzen der Ausgabe
	static void registerPrinter(Printer p) {
		printer = p;		
	}	
	// Nachricht ausgeben
	static void showMessage() {
		printer.message();
	}
	
	public static void main(String[] args) {				
		// Registrierung von implementierten Printern
		registerPrinter(new MessengerInnerClass.HelloPrinter());
		//registerPrinter(new Messenger.OrderPrinter());
		showMessage();		 
	}

}
