//Repeat Exercise 10 from the previous chapter, using the ternary operator
//and a bitwise test to display the ones and zeroes, instead of Integer.toBinaryString( ). 

public class Main {

        public static void main(String[] args)
        {
            BitTest test = new BitTest();
            int i = 0x0fc;
            int j = 0x1fd;
            System.out.println("i = " + i);
            test.binaryPrint(i);
            System.out.println("j = " + j);
            test.binaryPrint(j);
            System.out.println("i & j = " + (i & j));
            test.binaryPrint(i & j);
            System.out.println("i | j = " + (i | j));
            test.binaryPrint(i | j);
            System.out.println("i ^ j = " + (i ^ j));
            test.binaryPrint(i ^ j);
            System.out.println("~i = " + ~i);
            test.binaryPrint(~i);
            System.out.println("~j = " + ~j);
            test.binaryPrint(~j);
        }
  
}
