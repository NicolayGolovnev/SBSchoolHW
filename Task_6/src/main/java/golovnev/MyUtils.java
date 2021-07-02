package golovnev;

import java.util.*;

/**
 * Класс, содержащий методы поиска дубликатов двух коллекций
 */
public class MyUtils {
    /**
     * Первый метод поиска дубликатов: основан на проверки наличия
     * элементов второй коллекции во множестве первой коллекции
     * @param collA 1 коллекция клиентов Сбера
     * @param collB 2 коллекция клиентов Сбера
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicatesFirst(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<>();
        Set<UserSber> tracking = new HashSet<>(collA);
        for (UserSber user : collB)
            if (!tracking.add(user))
                duplicates.add(user);

        return duplicates;
    }


    /**
     * Второй метод поиска дупликатов: основан на методе removeAll -
     * удаляет элементы, которые принадлежат переданной коллекции
     * @param collA 1 коллекция клиентов Сбера
     * @param collB 2 коллекция клиентов Сбера
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicatesSecond(Collection<UserSber> collA, Collection<UserSber> collB) {
        Set<UserSber> setA = new HashSet<>(collA);
        Set<UserSber> setB = new HashSet<>(collB);
        Set<UserSber> unicSet = new HashSet<>(Set.copyOf(setA));
        unicSet.addAll(setB);

        unicSet.removeAll(setA);
        setB.removeAll(unicSet);
        return new ArrayList<>(setB);
    }

    /**
     * Третий метод поиска дубликатов: основан на методе retainAll -
     * удаляет элементы, не принадлежащей переданной коллекции
     * @param collA 1 коллекция клиентов Сбера
     * @param collB 2 коллекция клиентов Сбера
     * @return список дубликатов
     */
    public static List<UserSber> findDuplicatesThird(Collection<UserSber> collA, Collection<UserSber> collB) {
        List<UserSber> duplicates = new ArrayList<>(collA);
        duplicates.retainAll(collB);
        return duplicates;
    }
}
