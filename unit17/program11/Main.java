//Create a class that contains an Integer that is initialized to a value
//between o and 100 using java.util.Random. Implement Comparable using this Integer
//field. Fill a PriorityQueue with objects of your class, and extract the values using poll( ) to
//show that it produces the expected order

import java.util.*;

public class Main {
    private static class IntegerUnit implements Comparable<IntegerUnit>{
        private static Random r = new Random();
        private Integer item;
        public IntegerUnit(int max) {
            item = r.nextInt(max);
        }
        public int getItem() {
            return item;
        }
        public int compareTo(IntegerUnit unit) {
            return item - unit.getItem();
        }
        public boolean equals(Object o) {
            if ( ! ( o instanceof IntegerUnit) ) {
                return false;
            }
            @SuppressWarnings("unchecked")
            IntegerUnit unit = (IntegerUnit)o;
            return item.equals(unit.getItem());
        }
        public int hashCode() {
            return item.hashCode();
        }
        public String toString() {
            return "Test: " + item;
        }
    }
    public static void testWithPriorityQueue(int size, int max) {
        Queue<IntegerUnit> priQue = new PriorityQueue<>(size);
        for (int i = 0; i < size; i++) {
            if ( ! priQue.offer(new IntegerUnit(max)) ) {
                throw new IllegalStateException("Size: " + size);
            }
        }
        System.out.println(priQue);
        for (int i = 0; i < size; i++) {
            System.out.println(priQue.poll());
        }
    }
    public static void main(String[] args) {
        testWithPriorityQueue(10,100);
    }
}
