package gs.konick.util.sort;

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
        AbstractSort quickSort = new QuickSort();
        List<T> actual = quickSort.sort(myArrayList, comparator);

        List<T> expected = new ArrayList<>(list);
        expected.sort(comparator);
        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    public static Stream<Arguments> provideSortEdgeCases() {

        Comparator<Integer> intComparator = (o1, o2) -> Integer.compare(o2, o1);
        return Stream.of(
                Arguments.of(
                        List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                        intComparator
                ),
                Arguments.of(
                        List.of(10),
                        intComparator
                ),
                Arguments.of(
                        List.of(10, 9),
                        intComparator
                )
        );
    }
}
