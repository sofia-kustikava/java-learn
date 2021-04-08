//Using the documentation for java.util.regex.Pattern as a resource,
//write and test a regular expression that checks a sentence to see that it begins with a capital
//letter and ends with a period.

import java.util.*;
import java.util.regex.*;

public class Main {
    private List<String> list=new ArrayList<String>();
    public Main(){}
    public Main(List<String> l){list=l;}
    public void setList(List<String> l){list=l;}
    public void parse(String regex){
        Pattern p=Pattern.compile(regex);
        Matcher m;
        Formatter f=new Formatter(System.out);
        for(String str:list){
            m=p.matcher(str);
            f.format("%1$-15.15s %1$-8.8s\n", str, m.find());
        }
    }
    public static void main(String[] args){
        Main test=new Main(Arrays.asList("i wanna be!","A tiny little!","butterfly!","But it's will.","never.","HAPPEND."));
        String regex="^[A-Z].*\\.";
        test.parse(regex);
    }
}
