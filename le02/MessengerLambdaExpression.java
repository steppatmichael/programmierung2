import java.util.ArrayList;
import java.util.List;

public class MessengerLambdaExpression {
	
	// funktionales Interface für die Ausgabe der Nachricht
	interface Printer {
		void message(String text);
	} 
	static Printer printer;
	
	
	// Setzen der Ausgabe
	static void registerPrinter(Printer p) {
		printer = p;		
	}	
	// Nachricht ausgeben
	static void showMessage() {
		printer.message("Eine gute Nachricht");
	}
	
	public static void main(String[] args) {			
		// Registrierung und Übergabe der Implementierung mit dem
		// Lambda-Ausdruck
		registerPrinter(abc->System.out.println(abc));	
		showMessage();	
		
		 // direkte Implementierung mit Test		
        Printer p = t -> System.out.println("Parameter: " + t);
        p.message("Wirklich?");    
	}

}
