//Create three new types of exceptions. Write a class with a method that
//throws all three. In main( ), call the method but only use a single catch clause that will
//catch all three types of exceptions. 

public class Main {
    public static void main(String[] args) {
        ErrorEx errorExc = new ErrorEx();
        try {
            errorExc.throwExc();
        } catch (Exception1 | Exception2 | Exception3 e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
