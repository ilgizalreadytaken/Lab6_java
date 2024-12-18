package N3;

// Класс с аннотацией @N3.Default
@Default(value = String.class) // Указываем значение
public class AnnotatedClass {
    @Default(value = Integer.class) // Аннотация на поле
    private Integer number;

    public AnnotatedClass() {
        this.number = 0; // Значение по умолчанию
    }

    public void displayInfo() {
        System.out.println("Аннотированный класс с полем: " + number);
    }
}
