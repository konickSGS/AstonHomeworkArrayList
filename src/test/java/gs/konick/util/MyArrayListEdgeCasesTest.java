package gs.konick.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

/**
 * Юнит-тесты для класса MyArrayList
 */
public class MyArrayListEdgeCasesTest {
    @DisplayName("Проверка функции add c конкретными параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideAddEdgeCases")
    public <T> void testAddEdgeCases(List<T> list, int index, T element) {
        List<T> actual = new MyArrayList<>(list);
        List<T> expected = new ArrayList<>(list);

        actual.add(index, element);
        expected.add(index, element);
        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    public static Stream<Arguments> provideAddEdgeCases() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), 2, 1000),
                Arguments.of(List.of(1, 2, 3, 4), 0, 1000),
                Arguments.of(List.of(), 0, 1000)
        );
    }

    @DisplayName("Проверка функции add c конкретными параметрами с исключениями")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideAddEdgeCasesException")
    public <T> void testAddEdgeCasesException(List<T> list, int index, T element, Throwable expected) {
        List<T> myArrayList = new MyArrayList<>(list);
        Assertions.assertThrows(expected.getClass(), () -> myArrayList.remove(index));
    }

    public static Stream<Arguments> provideAddEdgeCasesException() {

        return Stream.of(
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), -1, 1000, new IndexOutOfBoundsException()),
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), 10, 1000, new IndexOutOfBoundsException()),
                Arguments.of(List.of(), 0, 1000, new IndexOutOfBoundsException())
        );
    }

    @DisplayName("Проверка функции get c конкретными параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideGetEdgeCases")
    public <T> void testGetEdgeCases(List<T> list, int index, T actual) {
        List<T> myArrayList = new MyArrayList<>(list);

        T expected = myArrayList.get(index);
        Assertions.assertEquals(
                actual,
                expected,
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    public static Stream<Arguments> provideGetEdgeCases() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), 2, 3),
                Arguments.of(List.of(1, 2, 3, 4), 0, 1),
                Arguments.of(List.of(1), 0, 1)
        );
    }

    @DisplayName("Проверка функции get c конкретными параметрами с исключениями")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideGetEdgeCasesException")
    public <T> void testGetEdgeCasesException(List<T> list, int index, Throwable expected) {
        List<T> myArrayList = new MyArrayList<>(list);
        Assertions.assertThrows(expected.getClass(), () -> myArrayList.remove(index));
    }

    public static Stream<Arguments> provideGetEdgeCasesException() {

        return Stream.of(
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), -1, new IndexOutOfBoundsException()),
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), 10, new IndexOutOfBoundsException()),
                Arguments.of(List.of(), 0, new IndexOutOfBoundsException())
        );
    }

    @DisplayName("Проверка функции remove c конкретными параметрами")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideRemoveEdgeCases")
    public <T> void testRemoveEdgeCases(List<T> list, int index) {
        List<T> actual = new MyArrayList<>(list);
        List<T> expected = new ArrayList<>(list);

        actual.remove(index);
        expected.remove(index);

        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    public static Stream<Arguments> provideRemoveEdgeCases() {

        return Stream.of(
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), 2),
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), 0),
                Arguments.of(List.of(1), 0)
        );
    }

    @DisplayName("Проверка функции remove c конкретными параметрами с исключениями")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideRemoveEdgeCasesException")
    public <T> void testRemoveEdgeCasesException(List<T> list, int index, Throwable expected) {
        List<T> myArrayList = new MyArrayList<>(list);
        Assertions.assertThrows(expected.getClass(), () -> myArrayList.remove(index));
    }

    public static Stream<Arguments> provideRemoveEdgeCasesException() {

        return Stream.of(
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), -1, new IndexOutOfBoundsException()),
                Arguments.of(Stream.of(1, 2, 3, 4).map(Object::toString).toList(), 10, new IndexOutOfBoundsException()),
                Arguments.of(List.of(), 0, new IndexOutOfBoundsException())
        );
    }
}
