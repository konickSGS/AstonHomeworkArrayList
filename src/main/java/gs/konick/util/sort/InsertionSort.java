package gs.konick.util.sort;

import gs.konick.util.MyArrayList;

import java.util.Comparator;
import java.util.List;

public class InsertionSort extends AbstractSort implements ListSort {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> newList = new MyArrayList<>(list);

        insertionSort(newList, comparator);
        return newList;
    }

    private <T> void insertionSort(List<T> list, Comparator<T> comparator) {
        for (int i = 1; i < list.size(); ++i) {
            int j = i - 1;
            while (j >= 0 && comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                swap(list, j, j + 1);
                j--;
            }
        }
    }

    @Override
    public String toString() {
        return "Сортировка вставками";
    }
}
