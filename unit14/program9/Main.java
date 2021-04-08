//Modify the previous exercise so that it uses
//Class.getDeclaredFields( ) to also display information about the fields in a class. 

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void printBase(Object o){
        Class<?> c=o.getClass();
        System.out.println(c.getName());
        Field[] fs=c.getDeclaredFields();
        for(Field f : fs){
            System.out.println(f);
        }
        Class<?> spc=c.getSuperclass();
        boolean flag=false;
        if(spc!=null){
            while(!flag){
                flag=true;
                try{
                    printBase(spc.newInstance());
                } catch(InstantiationException ie){
                    if(Modifier.isAbstract(spc.getModifiers())){
                        System.out.println("abstract "+spc.getName());
                        fs=spc.getDeclaredFields();
                        for(Field f : fs){
                            System.out.println(f);
                        }
                        spc=spc.getSuperclass();
                        flag=false;
                    }else{
                        System.out.println("Error during init of object! Must have a default constructor!");
                    }
                } catch(IllegalAccessException iae){
                    System.out.println("Error during init of object! Please check the accessibility of constructor!");
                }
            }
        }
    }
    public static void main(String[] args){
        Oval o=new Oval();
        ClassFamily.printBase(o);
    }
}
