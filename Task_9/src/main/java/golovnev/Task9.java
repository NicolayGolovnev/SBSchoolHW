package golovnev;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, который реализует метод-обработку выполнения методов с аннотациями, реализованными внутри этого пакета
 */
public class Task9 {
    /**
     * Статический метод, который выполняет обработку методов класса {@code className} с заданными аннотациями
     * (реализованы в этом же пакете).
     *
     * @param className имя класса, содержащий тестовые методы
     * @return список объектов, которые нужны для проверки в тестировании
     * @throws ClassNotFoundException если класс не найден
     * @throws InvocationTargetException проверенное исключение, которое обертывает исключение при вызове метода
     * {@link Method#invoke(Object, Object...)}
     * @throws IllegalAccessException если вызванный метод через рефлексию не имеет необходимого уровня доступа
     */
    public static List<Object> start(String className) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class<?> testClass = Class.forName(className);
        Method[] declaredMethods = testClass.getDeclaredMethods();

        List<Method> beforeMethod = getMethodsByAnnotation(declaredMethods, DoBeforeAll.class),
                afterMethod = getMethodsByAnnotation(declaredMethods, DoAfterAll.class),
                testsMethod = getMethodsByAnnotation(declaredMethods, DoTest.class);
        if (beforeMethod.size() > 1)
            throw new RuntimeException("Не может быть более одного метода с аннотацией DoBeforeAll");
        else if (afterMethod.size() > 1)
            throw new RuntimeException("Не может быть более одного метода с аннотацией DoAfterAll");
        else if (testsMethod.size() < 1)
            throw new RuntimeException("Не может быть менее одного метода с аннотацией DoTest");

        testsMethod = testsMethod.stream()
                .sorted(Comparator.comparingInt((method) -> method.getAnnotation(DoTest.class).order()))
                .collect(Collectors.toList());
        if (beforeMethod.size() == 1)
            testsMethod.add(0, beforeMethod.get(0));
        if (afterMethod.size() == 1)
            testsMethod.add(afterMethod.get(0));

        List<Object> returnList = new ArrayList<>();
        for (var method : testsMethod){
            method.setAccessible(true);
            returnList.add(method.invoke(className));
        }
        return returnList;
    }

    /**
     * Статический метод, который позволяет получить список необходиммых нам методов, подписанных аннотацией {@code annotation}
     * @param declaredMethods список методов класса, полученные через рефлексию
     * @param annotation класс аннотации
     * @return список методов класса, подписанные только заданной аннотацией
     */
    private static List<Method> getMethodsByAnnotation(Method[] declaredMethods, Class<? extends Annotation> annotation) {
        List<Method> returnList = new ArrayList<>();
        for (var method : declaredMethods)
            if (method.isAnnotationPresent(annotation)) {
                if (annotation == DoAfterAll.class)
                    returnList.add(method);
                else if (annotation == DoBeforeAll.class)
                    returnList.add(method);
                else if (annotation == DoTest.class)
                    returnList.add(method);
            }
        return returnList;
    }
}
