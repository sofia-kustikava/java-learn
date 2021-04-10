//Add a speak( ) method to all the pets in typeinfo.pets. Modify
//Apply.java to call the speak( ) method for a heterogeneous collection of Pet. 

import java.util.*;
import java.lang.reflect.*;
import static com.java.second.package6.TypeInfoSpeak.*;

public class Main {
    private static class Apply {
        private static <T> void apply(Iterable<? extends T> collect, Method m, Object... args) {
            try{
                for (T t : collect) {
                    m.invoke(t,args);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        ForNameCreator creator = new ForNameCreator();
        List<Pet> pets = creator.arrayList(10);
        try {
            Apply.apply(pets, Pet.class.getMethod("speak"));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
