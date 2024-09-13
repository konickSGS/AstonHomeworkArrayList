package gs.konick.util.sort;

import gs.konick.util.ArrayUtil;
import gs.konick.util.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class QuickSortTest {
    @DisplayName("Проверка функции sort")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideSortEdgeCases")
    public <T> void testGetEdgeCases(List<T> list, Comparator<T> comparator) {
        List<T> myArrayList = new MyArrayList<>(list);
        ListSort sort = new QuickSort();
        List<T> actual = sort.sort(myArrayList, comparator);

        List<T> expected = new ArrayList<>(list);
        expected.sort(comparator);
        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                sort + "\nТекущий результат\n" + actual + "\nне равен\n" + expected
        );
    }

    public static Stream<Arguments> provideSortEdgeCases() {
        Comparator<Integer> intComparator = (o1, o2) -> Integer.compare(o2, o1);
        int[] array = ArrayUtil.makeRandomIntegerArray(100, 10, 1000);
        List<Integer> randomList = Arrays.stream(array).boxed().toList();

        return Stream.of(
                Arguments.of(
                        List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                        intComparator
                ),
                Arguments.of(
                        List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                        intComparator
                ),
                Arguments.of(
                        List.of(5, 4, 3, 2, 1, 0, 10, 9, 8, 7, 6),
                        intComparator
                ),
                Arguments.of(
                        List.of(10),
                        intComparator
                ),
                Arguments.of(
                        List.of(10, 9),
                        intComparator
                ),
                Arguments.of(
                        randomList,
                        intComparator
                )
        );
    }
}
