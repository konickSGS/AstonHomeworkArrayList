package gs.konick.util.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Реализация quickSort
 */
public class QuickSort extends AbstractSort {
    /**
     * Главный метод сортировки
     */
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> newList = new ArrayList<>(list);

        quickSort(newList, comparator, 0, list.size() - 1);
        return newList;
    }

    /**
     * Основная рекурсия. Метод находит "стержень" и вызывает быструю сортировку
     */
    private <T> void quickSort(List<T> list, Comparator<T> comparator, int leftIndex, int rightIndex) {
        int currentLength = rightIndex - leftIndex + 1;
        if (currentLength < 2) {
            return;
        }

        T pivot = list.get(leftIndex);
        int pIndex = partition(list, comparator, leftIndex, rightIndex, pivot);
        quickSort(list, comparator, leftIndex, pIndex - 1);
        quickSort(list, comparator, pIndex, rightIndex);
    }

    /**
     * Метод, который переносит часть элементов влево, а часть вправо от pivot в зависимости от того, прошли ли они условие компаратора
     * Таким образом мы делим лист на две части, где точно уверены, что слева будут "меньше pivot", а справа "больше pivot"
     */
    private <T> int partition(List<T> list, Comparator<T> comparator, int leftIndex, int rightIndex, T pivot) {
        while (true) {
            while (comparator.compare(list.get(leftIndex), pivot) < 0) {
                leftIndex++;
            }
            while (comparator.compare(list.get(rightIndex), pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex >= rightIndex) {
                return rightIndex + 1;
            }

            swap(list, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
    }

    /**
     * Метод для взаимного переноса
     */
    private <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
