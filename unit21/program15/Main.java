//Modify Exercise 2 so that the task is a Callable that sums the values of
//all the Fibonacci numbers. Create several tasks and display the results. 

import java.util.*;
import java.util.concurrent.*;

public class Main implements Callable<Integer>{
    private Fibonacci f;
    public Main(int num){
        f=new Fibonacci(num);
    }
    public Integer call(){
        int sum=0;
        while(f.hasNext()){
            sum+=f.next();
        }
        return sum;
    }
    public static void main(String[] args) {
        ExecutorService ex=Executors.newCachedThreadPool();
        try{
            List<Future<Integer>> list=new ArrayList<Future<Integer>>();
            for(int i=0;i<10;i++){
                list.add(ex.submit(new Main(i+1)));
            }
            for(Future<Integer> f:list){
                System.out.println(f.get());
            }
        }catch(InterruptedException ie){
            System.out.println(ie);
        }catch(ExecutionException ee){
            System.out.println(ee);
        }finally{
            ex.shutdown();
        }
    }
}
