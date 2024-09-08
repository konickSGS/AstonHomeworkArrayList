package gs.konick.util;

import java.util.Arrays;

/**
 * Класс, в котором хранятся несколько полезных методов для работы с массивами
 */
public class ArrayUtil {
    /**
     * Сдвиг массива вправо, но не циклический. shift может быть отрицательным
     * Возьмем массив:
     * 0 1 2 3 4 5 6 7 8 9
     * Результат shiftNoCircle(array, 4, 2):
     * 0 1 2 3 4 5 4 5 6 7
     * Результат shiftNoCircle(array, 4, -2):
     * 0 1 4 5 6 7 8 9 8 9
     * @param array - исходный массив
     * @param indexFrom - индекс с которого мы хотим двигать
     * @param shift - сдвиг. Только положительное
     * @return новый массив со сдвигом
     * @throws IllegalArgumentException
     */
    public static Object[] shiftRightNoCircle(Object[] array, int indexFrom, int shift) {
        Object[] newArray = Arrays.copyOf(array, array.length);

        // Если shift отрицательный, то начало того куска, который мы хотим перенести, может уйти за начало массива
        // И чтобы этого не было, мы сразу это начало отсекаем.
        //    | 0 1 2 3 4 5 6 7 8 9. с indexFrom = 3 и shift = -4
        //  3 | 4 5 6 7 8 9 6 7 8 9
        // Мы видим, что 3 уехало на индекс -1, что приведет к ошибке. Поэтому indexFrom мы сдвигаем на 1
        if (indexFrom + shift < 0) {
            indexFrom += Math.abs(indexFrom + shift);
        }
        // Если shift отрицательное, то значит, что новый массив должен идти только до конца длины
        int lastIndex = (shift >= 0) ? array.length - shift : array.length;
        for (int i = indexFrom; i < lastIndex; i++) {
            newArray[i + shift] = array[i];
        }
        return newArray;
    }
}
