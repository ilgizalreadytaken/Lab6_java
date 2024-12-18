package N1;


// Класс Product представляет продукт с именем и ценой.
// Этот класс используется для хранения информации о товарах
// и проверки их валидности с помощью валидатора.

public class Product {
    private String name;
    private double price;

    // конструктор для созлания имени и прайса
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //Метод для получения названия продукта
    public String getName() {
        return name;
    }

    //Метод для получения цены продукта
    public double getPrice() {
        return price;
    }

    //Метод для представления объекта в виде строки.
    @Override
    public String toString() {
        return "N1.Product(name=" + name + ", price=" + price + ")";
    }
}

//В главном классе (Main) создается объект типа Product,
//который имеет два поля: name (название продукта) и price
//(цена продукта). Эти поля будут проверяться на корректность в рамках валидации.