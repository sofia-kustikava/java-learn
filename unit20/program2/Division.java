//Add support for division to the interface extractor. 

@ExtractInterface("IDivision")
public class Division { 
    public int divide(int x, int y) throws ArithmeticException {
		if(y == 0) throw new ArithmeticException("Divide by zero");
		int diff = subtract(x, y);
		if(diff < 0) return 0;
		if(diff == 0) return 1;
		int result = 0;
		while(diff >= 0) {
			result++;
			diff = subtract(diff, y);				
		}
		return result;
	}
	private int subtract(int x, int y) { return x - y; }
	public static void main(String[] args) {
		try {
		Divider d = new Divider();
		print("11/16 = " + d.divide(11, 16));		
		print("10/10 = " + d.divide(10,10));
		print("10/1 = " + d.divide(10,1));
		print("10/2 = " + d.divide(10,2));
		print("10/3 = " + d.divide(10,3));
		print("10/0 = " + d.divide(10,0));		
		} catch(Exception e)  {
			print(e);
		}
	}
}
