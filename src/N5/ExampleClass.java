package N5;

// Аннотация @N5.Validate с указанием типов, которые будут проверяться
@Validate(value = {String.class, Integer.class})
public class ExampleClass {

    // Поля класса для хранения имени и возраста
    private String name;
    private int age;

    // Конструктор для инициализации полей name и age
    public ExampleClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Метод для вывода имени и возраста
    public void display() {
        // Выводим информацию о человеке
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
