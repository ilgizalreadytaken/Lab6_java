package N7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация применяется только к типам (классам)
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
public @interface Cache {
    // Необязательное свойство value типа String[], значение по умолчанию — пустой массив
    String[] value() default {};
}
