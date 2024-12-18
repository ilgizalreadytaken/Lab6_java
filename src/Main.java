import N1.Product;
import N1.ProductTests;
import N1.ValidateException;
import N1.Validator;
import N2.Invoke;
import N2.TaskClass;
import N3.AnnotatedClass; // Импортируем класс для кейса 3
import N3.Default;
import N4.Person;
import N5.ExampleClass;
import N5.Validate;
import N6.AnotherClass;
import N6.Two;
import N7.Cache;
import N7.CachedClass;
import N8.ExampleClass_8;
import N8.ValidateException_8;
import N8.Validator_8;


import java.util.Scanner;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Выберите задание:");
            System.out.println("1 - Валидация объекта (N1.Product)");
            System.out.println("2 - Вызов методов с аннотацией @Invoke");
            System.out.println("3 - Проверка аннотации @Default");
            System.out.println("4 - Проверка аннотации @ToString");
            System.out.println("5 - Проверка аннотации @Validate");
            System.out.println("6 - Проверка аннотации @Two");
            System.out.println("6 - Проверка аннотации @Cache");
            System.out.println("8 - Задание");
            System.out.println("0 - Выход");
            choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Программа завершена.");
                break; // Выход из цикла, завершение программы
            }

            switch (choice) {
                case 1:
                    // Задание 1: Валидация объекта
                    Product product = new Product("Laptop", -1500.00);
                    System.out.println(product);
                    try {
                        Validator.validate(product, ProductTests.class);
                    } catch (ValidateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    // Задание 2: Вызов методов с аннотацией @Invoke
                    Method[] methods = TaskClass.class.getDeclaredMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Invoke.class)) {
                            try {
                                method.invoke(null); // Вызываем метод без создания объекта (static)
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;

                case 3:
                    // Проверка аннотации @Default
                    // Создаем объект аннотированного класса
                    AnnotatedClass obj = new AnnotatedClass();
                    obj.displayInfo(); // Выводим информацию о состоянии объекта

                    // Проверяем наличие аннотации @Default на уровне класса
                    Class<?> clazz = obj.getClass(); // Получаем класс объекта
                    if (clazz.isAnnotationPresent(Default.class)) { // Проверяем, аннотирован ли класс
                        Default annotation = clazz.getAnnotation(Default.class); // Получаем аннотацию
                        System.out.println("Класс аннотирован с value: " + annotation.value().getName());
                        // Выводим значение свойства value из аннотации
                    }

                    // Проверяем наличие аннотации @Default на уровне полей
                    for (Field field : clazz.getDeclaredFields()) { // Проходим по всем полям класса
                        if (field.isAnnotationPresent(Default.class)) { // Проверяем, аннотировано ли поле
                            Default fieldAnnotation = field.getAnnotation(Default.class); // Получаем аннотацию
                            System.out.println("Поле '" + field.getName() + "' аннотировано с value: "
                                    + fieldAnnotation.value().getName());
                            // Выводим имя поля и значение свойства value из аннотации
                        }
                    }
                    break;

                case 4:
                    // Задание 4: Использование аннотации @ToString
                    Person person = new Person("Алексей", 30, "Москва");
                    System.out.println("Результат toStringAnnotated:");
                    System.out.println(person.toStringAnnotated());
                    break;

                case 5:
                    // Проверка аннотации @Validate для класса ExampleClass8
                    try {
                        // Получаем объект класса ExampleClass8
                        Class<?> clazz5 = ExampleClass.class;

                        // Проверяем, есть ли аннотация @Validate у класса
                        if (clazz5.isAnnotationPresent(Validate.class)) {
                            // Получаем аннотацию @Validate, если она присутствует
                            Validate validate = clazz5.getAnnotation(Validate.class);
                            System.out.println("Аннотация @N5.Validate найдена!");

                            // Выводим типы, указанные в свойстве value аннотации
                            System.out.println("Типы, указанные в аннотации:");
                            for (Class<?> type : validate.value()) {
                                // Для каждого типа в массиве value выводим его имя
                                System.out.println(type.getName());
                            }
                        } else {
                            // Если аннотация @Validate не найдена, выводим сообщение
                            System.out.println("Аннотация @N5.Validate не найдена.");
                        }
                    } catch (Exception e) {
                        // Если возникла ошибка при обработке, выводим стек ошибки
                        e.printStackTrace();
                    }
                    break;


                case 6:
                    // Проверка аннотации @Two для класса AnotherClass
                    try {
                        // Получаем объект класса AnotherClass
                        Class<?> clazz6 = AnotherClass.class;

                        // Проверяем, есть ли аннотация @Two у класса
                        if (clazz6.isAnnotationPresent(Two.class)) {
                            // Получаем аннотацию @Two, если она присутствует
                            Two twoAnnotation = clazz6.getAnnotation(Two.class);
                            System.out.println("Аннотация @N6.Two найдена!");

                            // Выводим значения свойств first и second из аннотации
                            System.out.println("first: " + twoAnnotation.first());
                            System.out.println("second: " + twoAnnotation.second());
                        } else {
                            // Если аннотация @Two не найдена, выводим сообщение
                            System.out.println("Аннотация @N6.Two не найдена.");
                        }
                    } catch (Exception e) {
                        // Если возникла ошибка при обработке, выводим стек ошибки
                        e.printStackTrace();
                    }
                    break;


                case 7:
                    // Проверка аннотации @N7.Cache для класса N7.CachedClass
                    try {
                        // Получаем объект класса N7.CachedClass
                        Class<?> clazz7 = CachedClass.class;

                        // Проверяем, есть ли аннотация @N7.Cache у класса
                        if (clazz7.isAnnotationPresent(Cache.class)) {
                            // Получаем аннотацию @N7.Cache, если она присутствует
                            Cache cacheAnnotation = clazz7.getAnnotation(Cache.class);
                            System.out.println("Аннотация @N7.Cache найдена!");

                            // Получаем значения свойства value из аннотации (массив строк)
                            String[] cacheNames = cacheAnnotation.value();

                            // Проверяем, есть ли указанные кэши
                            if (cacheNames.length > 0) {
                                System.out.println("Кэши: ");
                                // Если кэши указаны, выводим их по одному
                                for (String cacheName : cacheNames) {
                                    System.out.println(cacheName);
                                }
                            } else {
                                // Если кэши не указаны, выводим сообщение
                                System.out.println("Кэши не указаны.");
                            }
                        } else {
                            // Если аннотация @N7.Cache не найдена, выводим сообщение
                            System.out.println("Аннотация @N7.Cache не найдена.");
                        }
                    } catch (Exception e) {
                        // Если возникла ошибка при обработке, выводим стек ошибки
                        e.printStackTrace();
                    }
                    break;

                case 8:
                    // Проверка аннотации @N8.Validate_8 для объектов N8.ExampleClass_8
                    try {
                        // Создание объектов для проверки
                        ExampleClass_8 validObject_8 = new ExampleClass_8("John", 12);  // Этот объект должен пройти тесты
                        ExampleClass_8 invalidObject_8 = new ExampleClass_8("", 45);  // Этот объект не пройдет тесты

                        // Проверка объектов с помощью валидатора
                        Validator_8.validate_8(validObject_8, invalidObject_8);  // Второй объект вызовет исключение

                    } catch (ValidateException_8 e) {
                        // Вывод сообщения об ошибке валидации
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Некорректный выбор. Повторите попытку.");
            }
        }
        scanner.close();
    }
}
