package N8;

@Validate_8(value = {TestClass_8.class})
public class ExampleClass_8 {
    private String name;
    private int age;

    public ExampleClass_8(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}