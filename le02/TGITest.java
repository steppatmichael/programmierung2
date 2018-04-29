
public class TGITest {

	public static void main(String[] args) {
		byte a = 0b1100;
		byte b = 0b1010;
		byte y;
		
		// ODER-Operation
		y = (byte) (a & b);		
		System.out.println("UND:  " + Integer.toBinaryString(y));	
		
		// ODER-Operation
		y = (byte) (a | b);		
		System.out.println("ODER: " + Integer.toBinaryString(y));
		
		// XOR
		y = (byte) (a ^ b);		
		System.out.println("XOR: " + Integer.toBinaryString(y));		
	}
}
