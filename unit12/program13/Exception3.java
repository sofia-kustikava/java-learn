public class Exception3 extends Exception{
    public String toString() {
        return "Exception3";
    }

    public void throwExc3() throws Exception3{
        throw new Exception3();
    }
}
