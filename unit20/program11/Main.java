//Add an @TestNote annotation to @Unit, so that the accompanying
//note is simply displayed during testing.

import java.lang.reflect.*;
import java.io.*;
import java.util.*;

public class Main implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests = new ArrayList<String>();
    static long testsRun = 0;
    static long failures = 0;

    public static void main(String[] args) throws Exception {
        ClassLoader.getSystemClassLoader()
                .setDefaultAssertionStatus(true); // Enable asserts
        new ProcessFiles(new Main(), "class").start(args);
        if (failures == 0)
            System.out.print("OK (" + testsRun + " tests)");
        else {
            System.out.print("(" + testsRun + " tests)");
            System.out.print("\n>>> " + failures + " FAILURE" +
                    (failures > 1 ? "S" : "") + " <<<");
            for (String failed : failedTests)
                System.out.print("  " + failed);
        }
    }

    public void process(File cFile) {
        try {
            String cName = ClassNameFinder.thisClass(
                    BinaryFile.read(cFile));
            if (!cName.contains("."))
                return;
            testClass = Class.forName(cName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        TestMethods testMethods = new TestMethods();
        Method creator = null;
        Method cleanup = null;
        for (Method m : testClass.getDeclaredMethods()) {
            testMethods.addIfTestMethod(m);
            if (creator == null)
                creator = checkForCreatorMethod(m);
            if (cleanup == null)
                cleanup = checkForCleanupMethod(m);
        }
        if (testMethods.size() > 0) {
            if (creator == null)
                try {
                    if (!Modifier.isPublic(testClass
                            .getDeclaredConstructor().getModifiers())) {
                        System.out.print("Error: " + testClass +
                                " default constructor must be public");
                        System.exit(1);
                    }
                } catch (NoSuchMethodException e) {
                }
            System.out.print(testClass.getName());
        }
        for (Method m : testMethods) {
            System.out.print("  . " + m.getName() + " ");
            if (m.isAnnotationPresent(TestNote.class))
                System.out.print("Note: " + m.getAnnotation(TestNote.class).note());
            try {
                Object testObject = createTestObject(creator);
                boolean success = false;
                try {
                    if (m.getReturnType().equals(boolean.class))
                        success = (Boolean) m.invoke(testObject);
                    else {
                        m.invoke(testObject);
                        success = true;
                    }
                } catch (InvocationTargetException e) {
                    System.out.print(e.getCause());
                }
                System.out.print(success ? "" : "(failed)");
                testsRun++;
                if (!success) {
                    failures++;
                    failedTests.add(testClass.getName() +
                            ": " + m.getName());
                }
                if (cleanup != null)
                    cleanup.invoke(testObject, testObject);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
