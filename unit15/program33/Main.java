//Repair GenericCast.java using an ArrayList. 

import java.util.*;

public class Main {
    private static class GoSize<T> {
        private int index = 0;
        private int max;
        private ArrayList<T> storage = new ArrayList<T>();
        public GoSize(int size) {
            max = size;
        }
        public void push(T item) {
            if (index < max) {
                storage.add(item);
                index++;
            } else {
                throw new IndexOutOfBoundsException(max);
            }
        }
        public T pop() {
            if (index > 0) {
                return storage.get(--index);
            } else {
                throw new IndexOutOfBoundsException(max);
            }
        }
    }
    public static void main(String[] args) {
        int SIZE = 7;
        GoSize<String> strings = new GoSize<String>(SIZE);
        for(String s : "L O A D I N G".split(" ")) {
            strings.push(s);
        }
        for(int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}
