//Write a program with two constant values, one with alternating binary ones and zeroes,
//with a zero in the least-significant digit, and the second, also alternating, with a one in the
//least-significant digit (hint: Its easiest to use hexadecimal constants for this). Take these two
//values and combine them in all possible ways using the bitwise operators, and display the results using
//Integer.toBinaryString( ).

public class Main {
    public static void main(String[] args) {
        int i = 0x0fc;
        int j = 0x1fd;
        System.out.println("i = " + Integer.toBinaryString(i));
        System.out.println("j = " + Integer.toBinaryString(j));
        System.out.println("i & j = " + Integer.toBinaryString(i & j));
        System.out.println("i | j = " + Integer.toBinaryString(i | j));
        System.out.println("i ^ j = " + Integer.toBinaryString(i ^ j));
        System.out.println("~i = " + Integer.toBinaryString(~i));
        System.out.println("~j = " + Integer.toBinaryString(~j));
    }
}
