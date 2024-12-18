package N6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Аннотация применяется только к типам (классам)
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время выполнения
public @interface Two {
    // Два обязательных свойства
    String first();
    int second();
}
