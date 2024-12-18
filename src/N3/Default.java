package N3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Аннотация @N3.Default
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
@Target({ElementType.TYPE, ElementType.FIELD}) // Применяется к типам и полям
public @interface Default {
    Class<?> value(); // Обязательное свойство value типа Class
}
