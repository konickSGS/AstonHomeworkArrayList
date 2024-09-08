package gs.konick.util.sort;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractSort {
    public abstract <T> List<T> sort(List<T> list, Comparator<T> comparator);
}
