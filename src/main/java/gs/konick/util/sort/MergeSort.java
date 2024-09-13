package gs.konick.util.sort;

import gs.konick.util.MyArrayList;

import java.util.Comparator;
import java.util.List;

public class MergeSort extends AbstractSort implements ListSort {
    @Override
    public <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        List<T> newList = new MyArrayList<>(list);
        // Чтобы на каждой итерации не создавать подлисты, лучше создать с самого начала одну копию листа и ее использовать
        List<T> copyList = new MyArrayList<>(list);

        mergeSort(newList, copyList, comparator, 0, newList.size() - 1);
        return newList;
    }

    private <T> void mergeSort(List<T> sourceList, List<T> copyList, Comparator<T> comparator, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {
            return;
        }
        int medianIndex = (rightIndex + leftIndex) / 2;

        mergeSort(sourceList, copyList, comparator, leftIndex, medianIndex);
        mergeSort(sourceList, copyList, comparator, medianIndex + 1, rightIndex);
        merge(sourceList, copyList, comparator, leftIndex, rightIndex);
    }

    private <T> void merge(List<T> sourceList, List<T> copyList, Comparator<T> comparator, int leftIndex, int rightIndex) {
        int medianIndex = (rightIndex + leftIndex) / 2;
        int i = leftIndex;
        int j = medianIndex + 1;
        int sourceIndex = leftIndex;

        while (i <= medianIndex && j <= rightIndex) {
            if (comparator.compare(copyList.get(i), copyList.get(j)) < 0) {
                sourceList.set(sourceIndex, copyList.get(i));
                i++;
            } else {
                sourceList.set(sourceIndex, copyList.get(j));
                j++;
            }
            sourceIndex++;
        }
        while (i <= medianIndex) {
            sourceList.set(sourceIndex, copyList.get(i));
            i++;
            sourceIndex++;
        }

        while (j <= rightIndex) {
            sourceList.set(sourceIndex, copyList.get(j));
            j++;
            sourceIndex++;
        }

        for (int k = leftIndex; k <= rightIndex; k++) {
            copyList.set(k, sourceList.get(k));
        }
    }

    @Override
    public String toString() {
        return "Сортировка слиянием";
    }
}
