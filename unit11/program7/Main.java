//Create a class, then make an initialized array of objects of your class. Fill
//a List from your array. Create a subset of your List by using subList( ), then remove this
//subset from your List. 

public class Main {
    public static void main(String[] args) {
        Class1[] classArray = new Class1[5];
        for(int i=0; i<5; i++)
            classArray[i] = new Class1();
        List<Class1> classList = Arrays.asList(classArray);
        System.out.println("Full list: " + classList);
        List<Class1> sub = classList.subList(2, 5);
        System.out.println("Sublist: " + sub);
        //classList.removeAll(sub);
        List<Class1> copy = new ArrayList<Class1>(classList);
        copy.removeAll(sub);
        classList = copy;
        System.out.println("Result: " + classList);
    }
}
