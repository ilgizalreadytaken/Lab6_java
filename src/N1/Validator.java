package N1;

import java.lang.reflect.Method;

// Класс Validator используется для выполнения валидации объекта с
// помощью тестов, описанных в переданном классе тестов.
// Метод validate выполняет все тестовые методы, указанные в классе testClass, на переданном объекте obj.
// Рефлексия используется для динамического вызова методов тестирования без явного указания их имен.
// Если тест не проходит, выбрасывается исключение ValidateException с информацией о проблеме.

public class Validator {
    // Метод для валидации объекта obj с использованием тестов из переданного класса testClass.
    // Каждый метод теста в testClass должен принимать объект для проверки.
    public static void validate(Object obj, Class<?> testClass) {

        // testClass.getDeclaredMethods() — это метод,
        // который возвращает массив всех методов, объявленных
        // в классе testClass, включая приватные и защищенные методы.

        for (Method method : testClass.getDeclaredMethods()) {
            try {
                // Вызов каждого метода теста с объектом obj в качестве параметра
                method.invoke(null, obj);
            } catch (Exception e) {
                // Если возникла ошибка (например, тест не пройден), выбрасываем исключение ValidateException с подробным сообщением
                throw new ValidateException("Ошибка в " + method.getName() + ": " + e.getCause().getMessage());
            }
        }
    }
}

