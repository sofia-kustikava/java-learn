public class Exception1 extends Exception{
    public String toString() {
        return "Exception1";
    }

    public void throwExc1() throws Exception1{
        throw new Exception1();
    }
}
