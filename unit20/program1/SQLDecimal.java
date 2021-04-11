import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLDecimal{
    public int value() default 0;
    public String name() default "";
    public Constraints constraints() default @Constraints;
}
