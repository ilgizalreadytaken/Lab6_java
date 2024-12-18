package N8;

import java.lang.reflect.Method;

public class Validator_8 {
    // Метод для валидации объектов с использованием тестов из переданных классов testClasses.
    // Каждый метод теста в testClass должен принимать объект для проверки.
    public static void validate_8(Object... objects) {
        for (Object obj : objects) {
            // Получаем аннотацию @N8.Validate_8 из класса объекта
            Validate_8 validateAnnotation = obj.getClass().getAnnotation(Validate_8.class);

            // Если аннотация @N8.Validate_8 присутствует
            if (validateAnnotation != null) {
                // Получаем список тестовых классов из аннотации
                Class<?>[] testClasses = validateAnnotation.value();
                for (Class<?> testClass : testClasses) {
                    // Выполняем все методы тестирования из каждого тестового класса
                    for (Method method : testClass.getDeclaredMethods()) {
                        try {
                            // Вызов тестового метода с объектом в качестве параметра
                            method.setAccessible(true);  // Делаем метод доступным, если он private
                            method.invoke(null, obj);
                        } catch (Exception e) {
                            // Если возникает ошибка в тесте, выбрасываем исключение с подробным сообщением
                            throw new ValidateException_8("Ошибка в " + method.getName() + " для объекта "
                                    + obj.getClass().getSimpleName() + ": " + e.getCause().getMessage());
                        }
                    }
                }
            } else {
                System.out.println("Аннотация @N8.Validate_8 не найдена для объекта " + obj.getClass().getSimpleName());
            }
        }
    }
}