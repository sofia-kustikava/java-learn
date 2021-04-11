import java.util.concurrent.*;
import java.util.*;

public class WebServer{
    private static int handlerCounter = 0;
    static class RequestHandler implements Runnable, Comparable<RequestHandler> {
        private final int id = handlerCounter++;
        private int requestServed = 0;
        private WebClient.RequestLine requests;
        private boolean servingRequestLine = true;
        public RequestHandler(WebClient.RequestLine rq) { requests = rq; }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    WebClient.Request r = requests.take();
                    TimeUnit.MILLISECONDS.sleep(r.getServiceTime());
                    synchronized(this) {
                        requestServed++;
                        while(!servingRequestLine){
                            wait();
                        }
                    }
                }
            } catch(InterruptedException e) {
                System.out.println(this + "interrupted");
            }
            System.out.println(this + "terminating");
        }
        public synchronized void hangs() {
            requestServed = 0;
            servingRequestLine = false;
        }
        public synchronized void serveRequestLine() {
            assert !servingRequestLine:"already serving: " + this;
            servingRequestLine = true;
            notifyAll();
        }
        public String toString() { return "Request Handler  " + id + " "; }
        public String shortString() { return "H" + id; }
        public synchronized int compareTo(RequestHandler other) {
            return requestServed < other.requestServed ? -1 : (requestServed == other.requestServed ? 0 : 1);
        }
    }
    static class Server implements Runnable {
        private ExecutorService exec;
        private WebClient.RequestLine requests;
        private PriorityQueue<RequestHandler> workingHandlers = new PriorityQueue<RequestHandler>();
        private Queue<RequestHandler> handlersDoingOtherThings = new LinkedList<RequestHandler>();
        private int adjustmentPeriod;
        private int maxHandler;

        public Server(ExecutorService e, WebClient.RequestLine requests, int adjustmentPeriod, int maxHandler) {
            exec = e;
            this.requests = requests;
            this.adjustmentPeriod = adjustmentPeriod;
            this.maxHandler=maxHandler;
            RequestHandler handler= new RequestHandler(requests);
            exec.execute(handler);
            workingHandlers.add(handler);
        }
        public int getHandlerNumber(){return workingHandlers.size()+handlersDoingOtherThings.size();}
        public void adjustHandlerNumber() {
            if(requests.size() / (float)requests.getMax() > 0.5f) {
                if(handlersDoingOtherThings.size() > 0) {
                    RequestHandler handler = handlersDoingOtherThings.remove();
                    handler.serveRequestLine();
                    workingHandlers.offer(handler);
                    return;
                }
                if(workingHandlers.size()<maxHandler){
                    RequestHandler handler = new RequestHandler(requests);
                    exec.execute(handler);
                    workingHandlers.add(handler);
                    return;
                }
            }
            if(workingHandlers.size() > 1 && requests.size() / (float)requests.getMax() < 0.5f){
                reassignOneHandler();
            }
            if(requests.size() == 0){
                while(workingHandlers.size() > 1){
                    reassignOneHandler();
                }
            }
        }
        private void reassignOneHandler() {
            RequestHandler handler = workingHandlers.poll();
            handler.hangs();
            handlersDoingOtherThings.offer(handler);
        }
        public void run() {
            try {
                while(!Thread.interrupted()) {
                    TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                    adjustHandlerNumber();
            } catch(InterruptedException e) {
                System.out.println(this + "interrupted");
            }
            System.out.println(this + "terminating");
        }
        public String toString() { return "["+workingHandlers.size()+"/"+handlersDoingOtherThings.size()+"/"+maxHandler+"]"; }
    }
}
