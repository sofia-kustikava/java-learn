//Use a static import to modify TrafficLight.java so you don’t have to
//qualify the enum instances.

import static com.java.second.package6.Signal.*;
import static com.java.second.package6.TrafficLight.*;

public class Main{
    public static void main(String[] args){
        for(Signal s:values()){
            System.out.println(s+": "+s.getDescription());
        }
        for(int i=0;i<10;i++){
            change();
            look();
        }
    }
}
