package gs.konick.util.sort;

import java.util.List;

public abstract class AbstractSort implements ListSort {
    /**
     * Метод для того, чтобы поменять ссылки в листе друг с другом
     */
    protected <T> void swap(List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override
    public String toString() {
        return "Сортировка";
    }
}
