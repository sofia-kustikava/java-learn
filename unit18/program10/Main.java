//Exercise 7: (2) Open a text file so that you can read the file one line at a time. Read each
//line as a String and place that String object into a LinkedList. Print all of the lines in the
//LinkedList in reverse order.
//Exercise 8: (1) Modify Exercise 7 so that the name of the file you read is provided as a
//command-line argument. 
//Exercise 10: (2) Modify Exercise 8 to take additional command-line arguments of words
//to find in the file. Print all lines in which any of the words match. 

import java.util.*;
import java.io.*;

public class Main{
    public static void inversePrint(File file, String inWord){
        LinkedList<String> list=new LinkedList<String>();
        BufferedReader bf=null;
        try{
            bf=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=bf.readLine())!=null){
                String[] words=line.split("[\\W]+");
                if(words.length>0){
                    for(String word:words){
                        if(word.toLowerCase().equals(inWord)){
                            list.add(line);
                            break;
                        }
                    }
                }
            }
        }catch(FileNotFoundException e){
            System.out.println(file.getName()+" FileNotFoundException");
        }catch(IOException ioe){
            System.out.println("IOException");
        }finally{
            if(bf!=null){
                try{
                    bf.close();
                }catch(IOException ioe){
                    System.out.println("File can't be closed!");
                }
            }
        }
        int size=list.size();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(--size));
        }
    }

    public static void main(String[] args){
        if(args.length!=2){
            System.out.println("Check it out!");
        }else{
            Main.inversePrint(new File(args[0]),args[1]);
        }
  
