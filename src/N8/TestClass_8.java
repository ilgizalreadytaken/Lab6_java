package N8;

public class TestClass_8 {
    // Простой тест для проверки имени
    public static void testName_8(ExampleClass_8 obj) {
        if (obj.getName() == null || obj.getName().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым!");
        }
    }
}