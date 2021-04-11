//Add a BusBoy class to Restaurant.java. After the meal is delivered,
//the WaitPerson should notify the BusBoy to clean up. 

import java.util.concurrent.*;

public class Main{
    private int count=10;
    private boolean tableClean=false;
    private Meal meal=null;
    private WaitPerson waitPerson;
    private Chef chef;
    private BusBoy busBoy;
    private ExecutorService es;
    public Main(int count){
        this.count=count;
        es=Executors.newCachedThreadPool();
        waitPerson=new WaitPerson();
        chef=new Chef();
        busBoy=new BusBoy();
        es.execute(waitPerson);
        es.execute(chef);
        es.execute(busBoy);
    }

    public class Meal{
        private int id;
        public Meal(int num){id=num;}
        public String toString(){return "Meal "+id;}
    }

    public class WaitPerson implements Runnable{
        public void run(){
            try{
                while(!Thread.interrupted()){
                    TimeUnit.MILLISECONDS.sleep(500);
                    synchronized(this){
                        while(meal==null){
                            wait();
                        }
                    }
                    synchronized(Main.this.chef){
                        System.out.println("Food");
                        synchronized(Main.this.busBoy){
                            System.out.println("----");
                            busBoy.notifyAll();
                        }
                        synchronized(this){
                            while(!tableClean){
                                wait();
                            }
                        }
                        System.out.println("Food served ");
                        meal=null;
                        tableClean=false;
                        chef.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("--------");
            }

        }
    }

    public class Chef implements Runnable{
        private int count=0;
        public void run(){
            try{
                while(!Thread.interrupted()){
                    synchronized(this){
                        while(meal!=null){
                            wait();
                        }
                    }
                    System.out.println("Order come");
                    if(++count>Main.this.count){
                        System.out.println("Out of meal");
                        Main.this.es.shutdownNow();
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                    synchronized(Main.this.waitPerson){
                        meal=new Meal(count);
                        System.out.println(meal+" prepared");
                        waitPerson.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("Chef interrupted");
            }
        }
    }

    public class BusBoy implements Runnable{
        public void run(){
            try{
                while(!Thread.interrupted()){
                    synchronized(this){
                        wait();
                    }
                    synchronized(Main.this.waitPerson){
                        tableClean=true;
                        System.out.println("Table cleaned");
                        waitPerson.notifyAll();
                    }
                }
            }catch(InterruptedException ie){
                System.out.println("BusBoy interrupted");
            }
        }
    }

    public static void main(String[] args){
        new Main(10);
    }
}
