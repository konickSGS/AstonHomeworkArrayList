package gs.konick.util.sort;

import java.util.Comparator;
import java.util.List;

public interface ListSort {
    <T> List<T> sort(List<T> list, Comparator<T> comparator);
}
