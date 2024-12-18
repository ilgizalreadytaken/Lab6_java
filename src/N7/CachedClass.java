package N7;

// Применяем аннотацию @N7.Cache с необязательным свойством value
@Cache(value = {"userCache", "productCache"})
public class CachedClass {

    // Поля класса для хранения данных
    private String name;
    private int id;

    // Конструктор для инициализации полей
    public CachedClass(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Метод для вывода информации
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}
