//A Fibonacci sequence is the sequence of numbers 1, 1, 2, 3, 5, 8, 13, 21,
//34, and so on, where each number (from the third on) is the sum of the previous two. Create
//a method that takes an integer as an argument and displays that many Fibonacci numbers
//starting from the beginning, e.g., If you run java Fibonacci 5 (where Fibonacci is the
//name of the class) the output will be: 1, 1, 2, 3, 5
  
  public class Main {
    public static void main(String[] args) {
        int a1 = 1;
        int a2 = 1;
        int a3;
        System.out.print(a1+" "+a2+" ");
        for(int i = 3; i <= 11; i++){
            a3=a1+a2;
            System.out.print(a3+" ");
            a1=a2;
            a2=a3;
        }
        System.out.println();
    }
}
