//For the phrase "Java now has regular expressions" evaluate whether the
//following expressions will find a match:
//  ^Java
//  \Breg.*
//  n.w\s+h(a|i)s
//  s?
//  s*
//  s+
//  s{4}
//  S{1}.
//  s{0,3} 

import java.util.regex.*;

public class Main {
    private static final String phrase = "Java now has regular expressions";

    public static boolean finding(String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phrase);
        return m.find();
    }

    public static void main(String[] args) {
        String regex = "(^Java)|(\\Breg.*)|(n.w\\s+h(a|i)s)|(s?)|(s*)|(s+)|(s{4})|(S{1})|(s{0,3})";
        System.out.println(Main.finding(regex));
    }
}
