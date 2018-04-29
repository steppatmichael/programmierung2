import java.util.ArrayList;
import java.util.List;

public class Listen {
	

	public static void main(String[] args) {
		
		// untypisierte ArrayList
		List<String> liste = new ArrayList<>();
		
		// Typisierte ArrayList
		//List<String> liste = new ArrayList<>();
		liste.add("Apfel");		
		liste.add("Birne");
		liste.add("Cashewnuss");
		liste.add("Dattel");
		liste.add("Erdbeere");
		liste.add("Feige");
		//liste.add(3);
		//liste.add(3.4);
		
		liste.remove(10);
		
		//for(Object s:liste) 
		//	System.out.println(s);
		
		
		for(int i = 0; i < liste.size(); i++) {
			System.out.println(String.format("%d %s", i, liste.get(i)));
		}
		

	}

}
