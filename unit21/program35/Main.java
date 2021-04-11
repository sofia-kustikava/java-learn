//Modify BankTellerSimulation.java so that it represents Web clients
//making requests of a fixed number of servers. The goal is to determine the load that the
//group of servers can handle. 

import java.util.concurrent.*;

public class Main {
    static final int MAX_LINE_SIZE = 100;
    static final int ADJUSTMENT_PERIOD = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        WebClient.RequestLine requests = new WebClient.RequestLine(MAX_LINE_SIZE);
        WebClient.RequestGenerator gen=new WebClient.RequestGenerator(requests);
        exec.execute(gen);
        WebServer.Server server=new WebServer.Server(exec, requests, ADJUSTMENT_PERIOD, 30);
        exec.execute(server);
        exec.execute(new Runnable(){
            public void run(){
                try{
                    while(!Thread.interrupted()){
                        TimeUnit.MILLISECONDS.sleep(20);
                        System.out.println(gen.showBalance()+" ["+requests.size()+"/"+MAX_LINE_SIZE+"]"+server);
                    }
                }catch(InterruptedException ie){
                    System.out.println("Print interrupted!");
                }finally{
                    System.out.println("Printer exit!");
                }

            }
        });
        if(args.length > 0){
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        }else {
            System.out.println("Press ‘Enter’ to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
