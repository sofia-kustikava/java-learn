//Using a Map<String,Integer>, follow the form of
//UniqueWords.java to create a program that counts the occurrence of words in a file. Sort
//the results using Collections.sort( ) with a second argument of
//String.CASE_INSENSITIVE_ORDER (to produce an alphabetic sort), and display the
//result. 

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Count wc = new Count();
        wc.wordCounter();
    }
}
