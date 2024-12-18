package N6;

// Применяем аннотацию @N6.Two с обязательными свойствами first и second
@Two(first = "Example", second = 42)
public class AnotherClass {

    // Поля класса для хранения значений
    private String description;
    private int number;

    // Конструктор для инициализации полей
    public AnotherClass(String description, int number) {
        this.description = description;
        this.number = number;
    }

    // Метод для вывода описания и числа
    public void showInfo() {
        System.out.println("Description: " + description + ", Number: " + number);
    }
}
