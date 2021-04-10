//Modify ClassTypeCapture.java by adding a
//Map<String,Class<?>>, a method addType(String typename, Class<?> kind), and
//a method createNew(String typename). createNew( ) will either produce a new
//instance of the class associated with its argument string, or produce an error message. 

import java.util.*;

public class Main {
    public static class ClassTypeCapture {
        private Map<String, Class<?>> kindMap = new HashMap<String, Class<?>>();

        public void addType(String name, Class<?> klass) {
            kindMap.put(name, klass);
        }

        public boolean find(Object arg) {
            for (Class<?> c : kindMap.values()) {
                if (c.isInstance(arg)) {
                    return true;
                }
            }
            return false;
        }

        public Object createNew(String typename) {
            if (!kindMap.containsKey(typename)) {
                throw new IllegalArgumentException("Exception " + typename);
            }
            try {
                return kindMap.get(typename).newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class TestObject {
        private static int count = 0;
        private int ID = ++count;

        public String toString() {
            return "ID " + ID;
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture capture = new ClassTypeCapture();
        capture.addType("String", String.class);
        capture.addType("Integer", Integer.class);
        System.out.println("Exception String: " + capture.find(new String("Howdy??")));
        System.out.println("Exception Integer: " + capture.find(new Integer(5)));
        System.out.println("Exception Double: " + capture.find(new Double(5.5)));

        capture.addType("TestObject", TestObject.class);
        System.out.println(capture.createNew("TestObject"));
        System.out.println(capture.createNew("TestObject"));
        System.out.println(capture.createNew("TestObject"));
    }
}
