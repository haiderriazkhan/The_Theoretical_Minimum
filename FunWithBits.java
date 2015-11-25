public class FunWithBits {
	
	// To add 1 to a number x we flip the rightmost 0 bit and all numbers after it (if there are any).
	public int increment(int x) {
		
		// Initialize our bit comparer to 1.
		int c = 1;
		
		// Until we hit a bit that is set to zero.
		while ((x & c) != 0) {
			
			// flip the current bit (a 1)
			x = x^c;
			// left shift by one position.
			c <<= 1;
			
		}
		
		// flip the current bit (a 0)
		x = x^c;
		return x;
		
	}
	
	public int increment_shortcut(int x) {
		
		return -(~x);
		
	}
	
	public int addition (int x , int y) {
		
		int sum = x;
		
		while (y != 0) {
			
			int carry = x & y;
			int sum = x ^ y;
			y = carry << 1;
		}
		
		return sum;
		
	}
	
	
	
}