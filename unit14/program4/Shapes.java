//Modify the previous exercise so that it uses instanceof to check the type
//before performing the downcast. 

import java.util.List;
import java.util.Arrays;

public class Shapes {
    public static void rotate(Shape s){
        if(!(s instanceof Circle)){
            s.rotate();
        }
    }
    public static void highlight(Shape s){
        s.highlight();
        System.out.println(s);
    }
    public static void highlightOff(Shape s){
        s.highlightOff();
        System.out.println(s);
    }
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for(Shape shape : shapeList){
            shape.draw();
            System.out.println(shape.getClass().getSimpleName());
            Shapes.rotate(shape);
            Shapes.highlight(shape);
        }

    }
}
