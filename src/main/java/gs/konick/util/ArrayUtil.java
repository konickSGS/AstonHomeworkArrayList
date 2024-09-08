package gs.konick.util;

import java.util.Arrays;

/**
 * Класс, в котором хранятся несколько полезных методов для работы с массивами
 */
public class ArrayUtil {
    /**
     * Сдвиг массива вправо, но не циклический.
     * Возьмем массив:
     * 0 1 2 3 4 5 6 7 8 9
     * Результат shiftNoCircle(array, 4, 2):
     * 0 1 2 3 4 5 4 5 6 7
     * @param array - исходный массив
     * @param indexFrom - индекс с которого мы хотим двигать
     * @param shift - сдвиг. Только положительное
     * @return новый массив со сдвигом
     * @throws IllegalArgumentException
     */
    public static Object[] shiftRightNoCircle(Object[] array, int indexFrom, int shift) {
        if (shift < 0) {
            throw new IllegalArgumentException("Размер сдвига должен быть положительным");
        }

        Object[] newArray = Arrays.copyOf(array, array.length);

        for (int i = indexFrom; i < array.length - shift; i++) {
            newArray[i + shift] = array[i];
        }
        return newArray;
    }
}
