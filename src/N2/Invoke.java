package N2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Определяем аннотацию @N2.Invoke
@Target(ElementType.METHOD) // Аннотация может быть применена только к методам
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна во время исполнения
public @interface Invoke {
}
