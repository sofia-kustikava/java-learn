//Write a program that uses two nested for loops and the modulus
//operator (%) to detect and print prime numbers (integral numbers that are not evenly
//divisible by any other numbers except for themselves and 1). 

public class Main {
    public static void main(String[] args) {
        boolean bool = true;
        for (int i = 2; i <= 10; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) System.out.println(i);
            bool=true;
        }
    }
}
