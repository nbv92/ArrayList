package ru.skypro.Arrays.service;


public interface IntegerList {
    Integer add(Integer item);
    Integer add(int index, Integer item);
    Integer set(int index, Integer item);

    Integer remove(int index);

    Integer remove(Integer item);

    boolean contains(Integer item);
    int indexOf(Integer item);
    int lastIndexOf(Integer item);

    Integer get(int index);
    boolean equals(IntegerList otherList);
    int size();
    boolean isEmpty();
    void clear();
    Integer[] toArray();
}
