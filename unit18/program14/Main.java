//Starting with BasicFileOutput.java, write a program that compares
//the performance of writing to a file when using buffered and unbuffered I/O. 

import java.io.*;

public class Main{
    private static String inFile = "/Users/Sofia/com/java/second/package6/Main1.txt";

    public static long test(Writer out) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(new File(inFile)));
        int lineCount = 1;
        String s;
        long begin;
        long end;
        long result=0;
        while((s = in.readLine()) != null ){
            begin=System.nanoTime();
            for(int i=0;i<10000;i++){
                out.write(lineCount++ + ": " + s);
            }
            result+=(System.nanoTime()-begin);
        }

        out.close();
        return result;
    }

    public static void main(String[] args) throws IOException {
        long timeBuffer=0;
        long timeNot=0;
        for(int i=0;i<20;i++){
            FileWriter fileOut=new FileWriter("/Users/Sofia/com/java/second/package6/Main1.txt");
            BufferedWriter bufferedOut = new BufferedWriter(new FileWriter("/Users/Sofia/com/java/second/package6/Main2.txt"));
            if(i>=5){
                timeBuffer+=test(bufferedOut);
                timeNot+=test(fileOut);
            }
        }
        System.out.println("Buf:    "+timeBuffer/15);
        System.out.println("Not:    "+timeNot/15);
        System.out.println((double)timeBuffer/timeNot);
    }
}
