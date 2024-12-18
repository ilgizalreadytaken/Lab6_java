package N4;

import java.lang.reflect.Field;


@ToString
public class Person {
    @ToString // Поле будет включено в toString
    private String name;

    @ToString(value = ToString.Value.NO) // Поле исключено из toString
    private int age;

    @ToString // Поле будет включено в toString
    private String city;

    // Конструктор для инициализации полей
    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    // Метод для создания строкового представления объекта с учетом аннотаций @N4.ToString
    public String toStringAnnotated() {
        StringBuilder sb = new StringBuilder(); // Строитель строки для результирующего представления объекта
        Class<?> clazz = this.getClass(); // Получаем класс объекта N4.Person

        // Проверяем, есть ли аннотация @N4.ToString на уровне класса
        if (clazz.isAnnotationPresent(ToString.class)) {
            sb.append(clazz.getSimpleName()).append(" {"); // Начинаем строить строку с имени класса и открывающей фигурной скобки
            Field[] fields = clazz.getDeclaredFields(); // Получаем все поля класса N4.Person

            // Проходим по всем полям
            for (Field field : fields) {
                // Проверяем, есть ли аннотация @N4.ToString на уровне поля
                if (field.isAnnotationPresent(ToString.class)) {
                    ToString fieldAnnotation = field.getAnnotation(ToString.class); // Получаем аннотацию поля
                    if (fieldAnnotation.value() == ToString.Value.YES) { // Если поле включено в toString (value = YES)
                        field.setAccessible(true); // Даем доступ к приватным полям
                        try {
                            // Добавляем в строку имя поля и его значение
                            sb.append(field.getName()).append("=").append(field.get(this)).append(", ");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace(); // Обрабатываем исключение, если доступ к полю невозможен
                        }
                    }
                }
            }
            // Убираем последнюю запятую и пробел, если они есть
            if (sb.toString().endsWith(", ")) {
                sb.setLength(sb.length() - 2); // Убираем лишнюю запятую
            }
            sb.append("}"); // Закрываем фигурную скобку
        }
        return sb.toString(); // Возвращаем готовую строку
    }
}