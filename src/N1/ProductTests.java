package N1;


//Класс ProductTests содержит методы для тестирования объекта класса Product.
//Эти методы проверяют корректность состояния объекта (например, проверка,
//что название продукта не пустое и что цена положительная).

public class ProductTests {
    public static void testNameNotEmpty(Product product) {
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new ValidateException("Название продукта не может быть пустым");
        }
    }

    public static void testPricePositive(Product product) {
        if (product.getPrice() <= 0) {
            throw new ValidateException("Цена должна быть больше 0");
        }
    }
}
