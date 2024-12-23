import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // ЗАДАЧА 2.1
        System.out.println("\nЗадание 2 №1 Количество мяуканий \n ");

        Cat cat = new Cat("Мурзик"); // Создаём кота
        Meowable meowingCat = new MeowCounter(cat); // Оборачиваем кота декоратором

        Funs.meowsCare(meowingCat); // Отправляем кота в метод

        // Вывод количества мяуканий
        System.out.println("Кот мяукал " + MeowCounter.getMeowCount() + " раз");

        //ЗАДАЧА 3.2
        System.out.println("\nЗадание 3 №2 Замена в списках \n ");

        // Пример работы с Integer
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 3, 5));
        List<Integer> subList1 = Arrays.asList(2, 3);
        List<Integer> replacement1 = Arrays.asList(9, 9);

        System.out.println("До замены: " + list1);
        ListReplacer.replaceFirstOccurrence(list1, subList1, replacement1);
        System.out.println("После замены: " + list1);

        // Пример работы со строками
        List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "b", "c", "e"));
        List<String> subList2 = Arrays.asList("b", "c");
        List<String> replacement2 = Arrays.asList("x", "y");

        System.out.println("\nДо замены: " + list2);
        ListReplacer.replaceFirstOccurrence(list2, subList2, replacement2);
        System.out.println("После замены: " + list2);


        //ЗАДАЧА 5.2
        System.out.println("\nЗадание 5 №2 Глухие согласные \n ");

        String fileName = "C:\\Users\\ivan3\\IdeaProjects\\lab_5\\src\\input.txt"; // Имя входного файла

        try {
            // Чтение содержимого файла
            String content = Files.readString(Path.of(fileName));

            // Вывод содержимого файла
            System.out.println("Содержимое файла:");
            System.out.println(content);

            // Поиск глухих согласных, которые не входят в слова
            Set<Character> unusedDeafConsonants = DeafConsonants.findUnusedDeafConsonants(content);

            // Печать результата
            System.out.println("\nГлухие согласные, не входящие ни в одно слово:");
            unusedDeafConsonants.forEach(System.out::println);

        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        //ЗАДАЧА 6.2
        System.out.println("\nЗадание 6 №2 Очередь Палиндром \n ");
        // Пример с целыми числами
        List<Integer> intList = Arrays.asList(1, 2, 3);
        Queue<Integer> intQueue = QueueFromList.buildQueue(intList);
        System.out.println("Очередь с числами: " + intQueue);

        // Пример со строками
        List<String> stringList = Arrays.asList("A", "B", "C");
        Queue<String> stringQueue = QueueFromList.buildQueue(stringList);
        System.out.println("Очередь со строками: " + stringQueue);

        //ЗАДАЧА 7.1
        System.out.println("\nЗадание 7 №1 Ломанная линия \n");

        List<Point> points = Arrays.asList(
                new Point(1, -2),
                new Point(1, -2), // Дубликат
                new Point(3, -4),
                new Point(0, -5)
        );

        // Обработка точек:
        List<Point> processedPoints = points.stream()
                .map(point -> new Point(point.getX(), Math.abs(point.getY()))) // Преобразование Y в положительное значение
                .distinct() // Удаление дубликатов
                .sorted(Comparator.comparingInt(Point::getX)) // Сортировка по X
                .collect(Collectors.toList()); // Сбор результата в список

        // Создание объекта Polyline
        Polyline polyline = Polyline.createPolyline(processedPoints);

        // Вывод результата
        System.out.println(polyline);

        //ЗАДАЧА 7.2
        System.out.println("\nЗадание 7 №2 Номер-имя \n");

        // Укажите путь к вашему файлу
        Path path = Paths.get("C:\\Users\\ivan3\\IdeaProjects\\lab_5\\src\\kids.txt");

        try {
            // Чтение строк из файла
            List<String> lines = Files.readAllLines(path);

            System.out.println("Содержимое файла:");
            System.out.println(lines);

            // Перенос стрима из метода processFile класса Person в Main
            Map<Integer, List<String>> groupedNames = lines.stream()
                    .map(line -> line.split(":")) // Разделяем строку на имя и номер
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty()) // Отфильтровываем строки с пустыми номерами
                    .map(parts -> {
                        // Преобразование имени с первой заглавной буквой
                        String name = capitalizeName(parts[0]);
                        int number = Integer.parseInt(parts[1]);
                        return new AbstractMap.SimpleEntry<>(number, name);
                    })
                    .collect(Collectors.groupingBy(
                            Map.Entry::getKey, // Группировка по номеру
                            TreeMap::new, // Использование TreeMap для сортировки по номерам
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList()) // Собираем имена в список
                    ));

            System.out.println("Группировка по номеру:");
            System.out.println(groupedNames);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Метод для преобразования имени с первой заглавной буквой
    private static String capitalizeName(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}