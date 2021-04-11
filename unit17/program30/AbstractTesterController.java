import java.util.*;

abstract class AbstractTesterController<C> {
    public abstract Map<String,Test<C>> testRegistry();
    private final Set<String> containers = new LinkedHashSet<>(Arrays.asList(new String[]{"java.util.ArrayList","java.util.LinkedList"}));
    public Set<String> containerRegistry() {
        return containers;
    }
    public void run() {
        for (String name : containers) {
            C container = classForName(name);
            System.out.println(">>>>>>>>>>> " + name + " <<<<<<<<<<<");
            TesterInBook.run(container,testRegistry());
        }
    }
    public void run(int[] paramList) {
        for (String name : containers) {
            C container = classForName(name);
            System.out.println(">>>>>>>>>>> " + name + " <<<<<<<<<<<");
            TesterInBook.run(container,testRegistry(),paramList);
        }
    }
    @SuppressWarnings("unchecked")
    private C classForName(String name) {
        Class<?> klass = null;
        try {
            klass = Class.forName(name);
        } catch(ClassNotFoundException e) {
            System.err.println(name + " Class not found.");
            System.exit(1);
        }

        C object = null;
        try {
            object = (C) klass.newInstance();
        } catch (IllegalAccessException e) {
            System.err.println(klass.getSimpleName() + " Class not accessible.");
            System.exit(1);
        } catch (InstantiationException e) {
            System.err.println(klass.getSimpleName() + " Class not instantiable.");
            System.exit(1);
        }
        return object;
    }
}
