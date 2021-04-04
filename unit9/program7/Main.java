//Change Exercise 9 in the Polymorphism chapter so that Rodent is an
//interface. 

public class Main {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(), new Hamster()};
        for (Rodent rodent : rodents) {
            rodent.move();
            rodent.gnaw();
        }
    }
}
