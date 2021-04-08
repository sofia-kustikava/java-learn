//Create a class containing private, protected and package-access
//methods. Write code to access these methods from outside of the class’s package. 

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args){
        try{
            Class<?> c=Acces.class;
            Object o=c.newInstance();
            Method[] ms=c.getDeclaredMethods();
            for(Method m:ms){
                m.setAccessible(true);
                m.invoke(o);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
