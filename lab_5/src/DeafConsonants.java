import java.io.*;
import java.nio.file.*;
import java.util.*;

public class DeafConsonants {

    // Список глухих согласных букв в русском языке
    private static final Set<Character> DEAF_CONSONANTS = Set.of('п', 'ф', 'к', 'т', 'ш', 'с', 'х', 'ц', 'ч');

    public static Set<Character> findUnusedDeafConsonants(String content) {
        // Приведение текста к нижнему регистру и удаление пунктуации
        String cleanedContent = content.toLowerCase().replaceAll("[\\p{Punct}\\d]+", "");

        // Извлечение слов
        String[] words = cleanedContent.split("\\s+");

        // Собираем все использованные буквы из слов
        Set<Character> usedLetters = new HashSet<>(); // HashSet позволяет хранить дублирующиеся свободные элементы
        for (String word : words) {
            for (char c : word.toCharArray()) {
                usedLetters.add(c);
            }
        }

        // Определяем неиспользованные глухие согласные
        Set<Character> unusedDeafConsonants = new TreeSet<>(DEAF_CONSONANTS);
        unusedDeafConsonants.removeAll(usedLetters);

        return unusedDeafConsonants;
    }
}