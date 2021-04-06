//Create an empty LinkedList<Integer>. Using a Listlterator, add
//Integers to the List by always inserting them in the middle of the List. 

public class Main {
    public static void main(String[] args) {
        IntoTheMiddle itm = new IntoTheMiddle();
        for (int i = 0; i < 5; i++){
            itm.insert(i);
            System.out.println("The list is now: " + itm.list);
        }
    }
}
