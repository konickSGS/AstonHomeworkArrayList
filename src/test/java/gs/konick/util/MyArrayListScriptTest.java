package gs.konick.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListScriptTest {
    @Test
    @DisplayName("Проверка функции add c циклом")
    public void testAdd() {
        List<Integer> actual = new MyArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            actual.add(random);
            expected.add(random);
        }
        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    @Test
    @DisplayName("Проверка функции add (индекс) c циклом")
    public void testAddWithIndex() {
        List<Integer> actual = new MyArrayList<>();
        List<Integer> expected = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            actual.add(random);
            expected.add(random);
        }

        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            int randomIndex = (int) (Math.random() * 1000);

            actual.add(randomIndex, random);
            expected.add(randomIndex, random);
        }

        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    @Test
    @DisplayName("Проверка функции add и remove. Создадим и удалим все элементы")
    public void testAddAndRemove() {
        List<Integer> actual = new MyArrayList<>();
        List<Integer> expected = new MyArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            actual.add(random);
        }
        for (int i = 0; i < 1000; i++) {
            actual.remove(0);
        }

        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    @Test
    @DisplayName("Проверка функции add и remove. Создадим и удалим часть")
    public void testAddAndRemovePart() {
        List<Integer> actual = new MyArrayList<>();
        List<Integer> expected = new MyArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            actual.add(random);
            expected.add(random);
        }

        for (int i = 0; i < 500; i++) {
            int randomIndex = (int) (Math.random() * 500);
            actual.remove(randomIndex);
            expected.remove(randomIndex);
        }

        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }

    @Test
    @DisplayName("Проверка функции add и clear. Создадим и удалим все элементы")
    public void testAddAndClear() {
        List<Integer> actual = new MyArrayList<>();
        List<Integer> expected = new MyArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int random = (int) (Math.random() * 100);
            actual.add(random);
        }
        actual.clear();

        Assertions.assertArrayEquals(
                actual.toArray(),
                expected.toArray(),
                "Текущий результат " + actual.toString() + " не равен " + expected.toString()
        );
    }
}
