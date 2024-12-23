// Класс, содержащий метод для замены списка
import java.util.*;

public class ListReplacer {
    // Используем дженерики для поддержки любых типов данных
    public static <T> void replaceFirstOccurrence(List<T> list, List<T> subList, List<T> replacement) {
        // Найти индекс первого вхождения subList в list
        int index = Collections.indexOfSubList(list, subList);

        // Если вхождение найдено, произвести замену
        if (index != -1) {
            // Удаляем элементы subList из list
            for (int i = 0; i < subList.size(); i++) {
                list.remove(index);
            }

            // Вставляем элементы replacement в list
            list.addAll(index, replacement);
        }
    }
}