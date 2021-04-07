//Modify Exercise 9 by adding a finally clause. Verify that your finally
//clause is executed, even if a NullPointerException is thrown. 

public class Main {
    public static void main(String[] args) {
        ErrorEx errorExc = new ErrorEx();
        try {
            errorExc.throwExc();
        } catch (Exception1 | Exception2 | Exception3 e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally");
        }
    }
}
