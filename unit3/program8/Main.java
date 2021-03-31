//Show that hex and octal notations work with long values. Use
//Long.toBinaryString( ) to display the results

public class Main {
    public static void main(String[] args) {
        long hex = 0x1f;
        long oct = 016;
        System.out.println(Long.toBinaryString(hex));
        System.out.println(Long.toBinaryString(oct));
    }
}
