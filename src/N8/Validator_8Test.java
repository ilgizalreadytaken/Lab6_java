package N8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Validator_8Test {

    // Тестируем метод validate_8 с объектами, которые должны пройти все тесты
    @Test
    void testValidObject() {
        // Создаем объект ExampleClass_8 с правильными данными
        ExampleClass_8 validObject = new ExampleClass_8("Valid Name", 25);

        // Применяем метод validate_8 и ожидаем, что тест пройдет без исключений
        assertDoesNotThrow(() -> Validator_8.validate_8(validObject));
    }

    // Тестируем метод validate_8 с объектами, которые не должны пройти все тесты
    @Test
    void testInvalidObject() {
        // Создаем объект ExampleClass_8 с некорректным возрастом
        ExampleClass_8 invalidObject = new ExampleClass_8("Invalid Name", -5);

        // Применяем метод validate_8 и ожидаем, что тест выбросит исключение
        assertThrows(ValidateException_8.class, () -> Validator_8.validate_8(invalidObject));
    }

    // Тестируем метод validate_8 с объектом без аннотации @Validate_8
    @Test
    void testObjectWithoutAnnotation() {
        // Создаем объект, который не имеет аннотации @Validate_8
        Object objectWithoutAnnotation = new Object();

        // Применяем метод validate_8 и проверяем, что аннотация не найдена
        assertDoesNotThrow(() -> Validator_8.validate_8(objectWithoutAnnotation));
    }
}