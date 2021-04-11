//Following the form of generics/Fibonacci.java, create a task that
//produces a sequence of n Fibonacci numbers, where n is provided to the constructor of the
//task. Create a number of these tasks and drive them using threads. 

public class Main{
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            new Thread(new Fibonacci(i+1)).start();
        }
    }
}
