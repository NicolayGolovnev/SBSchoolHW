package golovnev;

import java.util.*;

/**
 * Класс, который реализует метод для подсчета частоты появления слов в тексте
 */
public class Task8 {
    /**
     * Метод, который подсчитывает количество появлений слов в тексте.
     * Возвращает массив слов до 10 штук, которые чаще всего встречаются в тексте.
     * Регистр букв в тексте не учитывается (приводится к нижнему регистру).
     * @param text ихсодный текст
     * @return массив слов, чаще всех встречающихся в тексте
     * @throws NullPointerException исходный текст оказался пустым
     */
    public static String[] getWordsByFrequency(String text) {
        if (text.isEmpty())
            throw new NullPointerException("Text is empty!");

        ArrayList<String> words = new ArrayList<>(List.of(text.toLowerCase().split(" ")));
        HashMap<String, Integer> freq = new HashMap<>();
        words.forEach((word) -> freq.put(word, Collections.frequency(words, word)));

        return freq.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);
    }
}
