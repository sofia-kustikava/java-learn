//Add support for division to the interface extractor. 

@ExtractInterface("IDivision")
public class Division { 
    public int divide(int x, int y) {
        int total = 0;
        for(int i = 0; i < x; i++)
            total = add(total, y);
        return total;
    }
    private int add(int x, int y) { return x / y; }
    public static void main(String[] args) {
        Division m = new Division();
        System.out.println("15/5 = " + m.divide(15, 5));
    }
}
