//Compare the performance of Collections.sort( ) between an
//ArrayList and a LinkedList. 

import java.util.*;

public class Main {
    private static final class SortPerformance extends AbstractTesterController<List<Integer>> {
        private static final int MAX_VALUE = 10000;
        private static final Random R = new Random();

        public Map<String, Test<List<Integer>>> testRegistry() {
            Map<String, Test<List<Integer>>> tests = new HashMap<>();
            tests.put("Collections.sort()", new Test<List<Integer>>() {
                public long test(List<Integer> list, int size) {
                    for (int i = 0; i < size; i++) {
                        list.add(R.nextInt(MAX_VALUE));
                    }
                    long start = System.nanoTime();
                    Collections.sort(list);
                    long end = System.nanoTime();
                    return end - start;
                }
            });
            return tests;
        }

        public static void test(String... args) {
            SortPerformance controller = new SortPerformance();
            controller.containerRegistry().addAll(Arrays.asList(args));
            controller.run(new int[]{10, 50, 100, 50, 1000, 25, 10000, 10});
        }
    }

    public static void main(String[] args) {
        SortPerformance.test();
    }
}
