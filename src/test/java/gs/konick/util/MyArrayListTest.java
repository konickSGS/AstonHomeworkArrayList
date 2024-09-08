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
public class MyArrayListTest {
    @DisplayName("Проверка функции add")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideAddEdgeCases")
    public <T> void testAddEdgeCases(List<T> list, int index, T element) {
        List<T> actual = new MyArrayList<>(list);
        List<T> expected = new ArrayList<>(list);

        actual.add(index, element);
        expected.add(index, element);
        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray()
        );
    }

    public static Stream<Arguments> provideAddEdgeCases() {

        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4), 2, 1000),
                Arguments.of(List.of(1, 2, 3, 4), 0, 1000),
                Arguments.of(List.of(), 0, 1000)
        );
    }
}
