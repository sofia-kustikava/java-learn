//Exercise 21: (1) Create an enum of the least-valuable six types of paper currency. Loop
//through the values( ) and print each value and its ordinal( ).
//Exercise 22: (2) Write a switch statement for the enum in the previous example. For
//each case, output a description of that particular currency. 

import com.java.se.lesson12.Paper;

public class Main {
    public static void main(String[] args) {
        for(Paper money : Paper.values()) {
            money.choose(money);
        }
    }
}
