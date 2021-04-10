//Exercise 9: (1) Modify GenericMethods.java so that f( ) accepts three arguments, all
//of which are of a different parameterized type.
//Exercise 10: (1) Modify the previous exercise so that one of f( )’s arguments is nonparameterized. 

public class Main {
    public static <T,U> void f(T t, U u, String s) {
        System.out.println(t.getClass().getName());
        System.out.println(u.getClass().getName());
        System.out.println(s.getClass().getName());
    }
    public static void main(String[] args) {
        f(5,5.5f,"Howdy??");
    }
}
