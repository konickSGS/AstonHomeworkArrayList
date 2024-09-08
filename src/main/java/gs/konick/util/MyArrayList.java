package gs.konick.util;

import java.util.*;

/**
 * Коллекция, которая будет функционировать как ArrayList.
 * Учебный пример для Aston
 * @param <T> тип элемента коллекции
 * @author GilSar
 */
public class MyArrayList<T> extends AbstractList<T> implements RandomAccess {

    /**
     * Вместимость массива по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Коэффициент, на который будет увеличиваться массив при переполнении
     */
    private static final double DEFAULT_CAPACITY_INCREASE_COEF = 1.5;

    /**
     * Массив, в котором хранятся элементы.
     * В Java дженерики плохо взаимодействуют с массивами, поэтому тип Object
     */
    private Object[] array;

    /**
     * Количество элементов в MyArrayList
     */
    private int size;

    /**
     * Конструктор, который принимает "вместимость"
     * @param capacity - вместимость
     */
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Вместимость массива не может быть меньше 0");
        }
        this.array = new Object[capacity];
    }

    /**
     * Конструктор по умолчанию просто создает массив длины DEFAULT_CAPACITY
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор, который принимает любую коллекцию
     * @param collection
     * @param <T>
     */
    public <T> MyArrayList(Collection<? extends T> collection) {
        this.array = collection.toArray();
        this.size = this.array.length;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * Метод, который "расширяет" массив: создает новый массив большей длины, в который копируются все элементы
     * @param newCapacity - новая вместимость массива
     */
    private void increaseArray(int newCapacity) {
        this.array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * Метод расширения по умолчанию, в котором длина увеличивается в DEFAULT_CAPACITY_INCREASE_COEF раз
     */
    private void increaseArray() {
        int oldCapacity = this.array.length;
        int newCapacity = (int) DEFAULT_CAPACITY_INCREASE_COEF * oldCapacity + 1;

        increaseArray(newCapacity);
    }

    /**
     * Метод для вставки (не замены) элемента по индексу
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, T element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы массива длины %d", index, this.size));
        }
        if (this.size == this.array.length) {
            increaseArray();
        }
        this.size++;

        Object[] shiftArray = ArrayUtil.shiftRightNoCircle(array, index, 1);
        shiftArray[index] = element;
        this.array = shiftArray;
    }

    /**
     * Метод для вставки элемента в конец списка
     * @param element element whose presence in this collection is to be ensured
     * @return
     */
    @Override
    public boolean add(T element) {
        this.add(size, element);
        return true;
    }

    /**
     * Метод удаляет элемент по индексу
     * @param index the index of the element to be removed
     * @return удаляемый элемент
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Индекс %d выходит за пределы массива длины %d", index, this.size));
        }

        @SuppressWarnings("unchecked") T removedElement = (T) this.array[index];
        this.array = ArrayUtil.shiftRightNoCircle(array, index + 1, -1);
        this.size--;
        return removedElement;
    }

    /**
     * Возвращение элемента по индексу
     * @param index индекс
     * @return элемент листа по индексу
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        return (T) this.array[index];
    }

    /**
     * @return количество элементов в листе
     */
    @Override
    public int size() {
        return this.size;
    }
}
