//Instead of implementing an interface, make next( ) a static method.
//What are the benefits and drawbacks of this approach?

public class Main{
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            System.out.println(Colors.next());
        }
    }
}
