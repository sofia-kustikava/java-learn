import java.util.*;

final class Tester<C> {
    private static final int[] defaultParams = new int[]{10,5000,100,5000,1000,500,10000,50};
    private int[] paramList = defaultParams;
    private final C container;
    private final Map<String,Test<C>> tests;
    private final String header;

    public C initialize(int size) {
        return container;
    }
    private Tester(C container, Map<String,Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        header = container.getClass().getSimpleName();
    }
    private Tester(C container, Map<String,Test<C>> tests, int[] paramList) {
        this(container,tests);
        assert paramList.length >= 2;
        assert paramList.length % 2 == 0;
        this.paramList = paramList;
    }

    public static <C> void run(C cntnr, Map<String,Test<C>> tests) {
        new Tester<C>(cntnr,tests).timedTest();
    }
    public static <C> void run(C cntnr, Map<String,Test<C>> tests, int[] paramList) throws IllegalArgumentException {
        if (paramList.length < 2) {
            throw new IllegalArgumentException("Need at least 1 pair(test size and loop times) of paramater!");
        }
        if ( (paramList.length % 2) != 0 ) {
            throw new IllegalArgumentException("Parameters should be in pair!");
        }
        new Tester<C>(cntnr,tests,paramList).timedTest();
    }

    private static final String SIZE_FIELD = "%5d";
    private static final String RESULT_FIELD = "%10.10s: %10d";
    public void timedTest() {
        Formatter f = new Formatter(System.out);
        for (int i = 0; i < paramList.length/2; i++) {
            int size = paramList[i*2];
            int loops = paramList[i*2+1];
            f.format(SIZE_FIELD, size);
            for (Map.Entry<String,Test<C>> test : tests.entrySet()) {
                C kontainer = initialize(size);
                f.format(RESULT_FIELD, test.getKey(), eachTest(test.getValue(),kontainer,size,loops));
            }
            f.format("\n");
        }
    }
    private long eachTest(Test<C> test, C kontainer, int size, int loops) {
        assert size > 0;
        assert loops > 0;
        long result = 0;
        for (int i = 0; i < loops; i++) {
            result += test.test(kontainer, size);
        }
        return result / loops;
    }
}
