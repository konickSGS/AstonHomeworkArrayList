package gs.konick.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Юнит-тесты для класса ArrayUtil
 */
public class ArrayUtilTest {

    @DisplayName("Проверка функции shiftRightNoCircle")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideShiftRightNoCircle")
    public void testShiftRightNoCircle(Object[] array, Object[] expected, int indexFrom, int shift) {
        var actual = ArrayUtil.shiftRightNoCircle(array, indexFrom, shift);
        Assertions.assertArrayEquals(
                actual,
                expected
        );
    }

    public static Stream<Arguments> provideShiftRightNoCircle() {
        Object[] empty = {};
        Object[] array = new Object[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        return Stream.of(
                Arguments.of(empty, empty, 4, 10),
                Arguments.of(
                        array,
                        new Object[]{0, 1, 2, 3, 4, 5, 4, 5, 6, 7},
                        4,
                        2
                ),
                Arguments.of(
                        array,
                        new Object[]{0, 1, 2, 3, 4, 4, 5, 6, 7, 8},
                        4,
                        1
                ),
                Arguments.of(
                        array,
                        array,
                        0,
                        0
                ),
                Arguments.of(
                        array,
                        array,
                        5,
                        0
                ),
                Arguments.of(
                        array,
                        array,
                        4,
                        10
                ),
                Arguments.of(
                        array,
                        new Object[]{0, 3, 4, 5, 6, 7, 8, 9, 8, 9},
                        3,
                        -2
                ),
                Arguments.of(
                        array,
                        new Object[]{3, 4, 5, 6, 7, 8, 9, 7, 8, 9},
                        3,
                        -3
                ),
                Arguments.of(
                        array,
                        new Object[]{4, 5, 6, 7, 8, 9, 6, 7, 8, 9},
                        3,
                        -4
                ),
                Arguments.of(
                        array,
                        array,
                        3,
                        -10
                )
        );
    }
}
