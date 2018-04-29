import java.util.Scanner;

public class Eingabe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		String string;
		while (!(string = scanner.nextLine()).equals("q"))
			System.out.println("Du hast " + string + " geschrieben.");		
		scanner.close();
		System.out.println("Programm beendet.");
	}

}
