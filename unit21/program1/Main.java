//Implement a Runnable. Inside run( ), print a message, and then call
//yield( ). Repeat this three times, and then return from run( ). Put a startup message in the
//constructor and a shutdown message when the task terminates. Create a number of these
//tasks and drive them using threads. 

public class Main implements Runnable{
    private static int count=0;
    private int id=++count;
    private int max=10;
    public Main(){System.out.println("Initializing "+id);}
    public void run(){
        for(int i=0;i<3;i++){
            System.out.println("#"+id+"("+(max--)+")");
            Thread.yield();
        }
        System.out.println("Finished "+id);
        return;
    }
    public static void main(String[] args){
        for(int i=0;i<5;i++){
            new Thread(new Main()).start();
        }
    }
}
