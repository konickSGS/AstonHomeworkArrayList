package gs.konick.util.sort;

import gs.konick.util.ArrayUtil;
import gs.konick.util.MyArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortTest {

    @DisplayName("Проверка функции sort")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @MethodSource("provideSortEdgeCases")
    public <T> void testGetEdgeCases(ListSort sort, List<T> list, Comparator<T> comparator) {
        List<T> myArrayList = new MyArrayList<>(list);
        List<T> actual = sort.sort(myArrayList, comparator);

        List<T> expected = new ArrayList<>(list);
        expected.sort(comparator);
        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                sort + "\nТекущий результат\n" + actual + "\nне равен\n" + expected
        );
    }

    // Все доступные сортировки
    static List<ListSort> sorts = List.of(
            new QuickSort(),
            new InsertionSort(),
            new MergeSort()
    );

    static Comparator<Integer> intReverseComparator = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }

        @Override
        public String toString() {
            return "Обратный порядок";
        }
    };

    public static Stream<Arguments> provideSortEdgeCases() {
        int[] array = ArrayUtil.makeRandomIntegerArray(100, 10, 1000);
        List<Integer> randomList = Arrays.stream(array).boxed().toList();

        var arguments = List.of(
                List.of(
                        List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0),
                        intReverseComparator
                ),
                List.of(
                        List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                        intReverseComparator
                ),
                List.of(
                        List.of(5, 4, 3, 2, 1, 0, 10, 9, 8, 7, 6),
                        intReverseComparator
                ),
                List.of(
                        List.of(10),
                        intReverseComparator
                ),
                List.of(
                        List.of(10, 9),
                        intReverseComparator
                ),
                List.of(
                        randomList,
                        intReverseComparator
                )
        );

        // Мы создаем все комбинации доступных сортировок и аргументов.
        return sorts.stream().map(sort ->
                        arguments.stream()
                                .map(ArrayList::new)
                                // Добавляем сортировку первым значением в список к аргументам
                                .map(l -> {
                                    l.addFirst(sort);
                                    return l;
                                }).toList()
                ).flatMap(List::stream)
                .map(l -> Arguments.of(l.toArray()));
    }
}
