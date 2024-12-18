package N4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


// Аннотация @N4.ToString
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // Применяется к типам и полям
public @interface ToString {
    enum Value { YES, NO } // Возможные значения свойства
    Value value() default Value.YES; // Свойство со значением по умолчанию
}