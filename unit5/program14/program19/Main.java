//Write a method that takes a vararg String array. Verify that you can
//pass either a comma-separated list of Strings or a String[] into this method. 

import com.java.se.lesson12.VarArgs;

public class Main {
    public static void main(String[] args) {
        VarArgs varArgs = new VarArgs();

        varArgs.result(new String[]{"1","2","3"});
        String[] strings1 = new String[]{"4","5","6"};
        varArgs.result(strings1);
    }
}
