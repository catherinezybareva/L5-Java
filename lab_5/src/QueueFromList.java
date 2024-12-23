import java.util.*;

public class QueueFromList {
    // Используем дженерик T вместо фиксированного типа Integer
    public static <T> Queue<T> buildQueue(List<T> list) {
        Queue<T> queue = new LinkedList<>();

        // Добавляем элементы из списка в очередь
        for (T element : list) {
            queue.add(element);
        }

        // Добавляем элементы из списка в обратном порядке
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.add(list.get(i));
        }

        return queue;
    }
}
