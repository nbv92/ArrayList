package ru.skypro.Arrays.service.impl;

import ru.skypro.Arrays.exception.InvalidIndexException;
import ru.skypro.Arrays.exception.NullItemException;
import ru.skypro.Arrays.exception.StorageIsFullException;
import ru.skypro.Arrays.service.IntegerList;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] storage;
    private int index ;
    private Integer item;
    public int size;

    public IntegerListImpl() {
        storage = new Integer[10];
    }

    public IntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateItem(item);
        growIfNeeded();
        storage[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        growIfNeeded();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage [size++] = item;
            return item;
        }
        System.arraycopy(storage, index, storage, index +1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex (index);
        validateItem (item);
        storage[index] = item;
        return item;
    }

    @Override
    public Integer remove(int index) {
            validateIndex(index);

            Integer item = storage[index];

            if (index != size) {
                System.arraycopy(storage, index + 1, storage, index, size - index);
            }

            size--;
            return item;
    }

    @Override
    public Integer remove(Integer item) {
        return null;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort (storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i > 0; i--) {
            if (storage[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex (index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals (this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void growIfNeeded() {
            if (size == storage.length){
               grow();
        }
    }

    private void validateIndex (int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private  void sort (Integer[] arr) {
        quickSort(arr,0, arr.length - 1);
    }

    private void quickSort(Integer[] arr, int begin, int end) {
        if(begin < end) {
            int partitionIndex = partition (arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end );
        }
    }

    private int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                i++;

                swapElements(arr, i, i);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private boolean binarySearch(Integer[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private void grow() {
        storage = Arrays.copyOf(storage, size + size / 2);
    }
}
