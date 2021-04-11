public class ChopstickBuck{
    private final int num;
    private volatile int availableNum;
    public ChopstickBuck(int num){
        this.num=num;
        availableNum=num;
    }
    public synchronized void take() throws InterruptedException{
        for(int i=0;i<2;i++){
            while(availableNum==0){
                wait();
            }
            availableNum--;
        }
    }
    public synchronized void drop() throws InterruptedException{
        availableNum++;availableNum++;
        notifyAll();
    }
}
