package N2;

public class TaskClass {

    @Invoke
    public static void displayMessage() {
        System.out.println("Метод с аннотацией @Invoke был вызван!");
    }

    @Invoke
    public static void anotherMethod() {
        System.out.println("Этот метод тоже аннотирован!");
    }

    public static void nonAnnotatedMethod() {
        System.out.println("Этот метод не аннотирован!");
    }
}
