package N8;

// Исключение, которое выбрасывается, если объект не прошел тесты.
public class ValidateException_8 extends RuntimeException {
    public ValidateException_8(String message) {
        super(message);
    }
}