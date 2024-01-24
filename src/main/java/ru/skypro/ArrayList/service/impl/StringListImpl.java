package ru.skypro.ArrayList.service.impl;

import ru.skypro.ArrayList.service.StringList;

import java.util.ArrayList;
import java.util.Collection;

public class StringListImpl implements StringList {
    ArrayList<String> ArrayList = new ArrayList<>();
    private int index ;
    private String item;
    public static final int size = 9;

    public StringListImpl(String[] arrayList, int index, String item) {
        this.ArrayList = ArrayList;
        this.index = index;
        this.item = item;
    }

    @Override
    public String add(String item) {
        ArrayList.add(item);
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > 9) {
            throw new RuntimeException("Выход за границу массива") ;
        }
        else {
            ArrayList.add(index,item);
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index > 9) {
            throw new RuntimeException("Выход за границу массива") ;
        }
        else {
            ArrayList.set(index, item);
            return item;
        }
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i <= ArrayList.size();i++) {
            if (item.equals(ArrayList.get(i))) {
                ArrayList.remove(item);
                return item;
            }
        }
        throw new RuntimeException("No such element");
    }

    @Override
    public String remove(int index) {
        for (int i = 0; i <= ArrayList.size();i++) {
            if (ArrayList.get(index) == ArrayList.get(i)) {
                ArrayList.remove(index);
                return ArrayList.get(index);
            }
        }
        throw new RuntimeException("No such element");
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        int result = -1;
        for (int i = 0; i < index; i++) {
            if (item == ArrayList.get(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(String item) {
        int lastIndex = -1;
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (ArrayList.get(i) == null) {
                    lastIndex = i;
                }
            }
            return lastIndex;
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(ArrayList.get(i))) {
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    @Override
    public String get(int index) {
        if ((index < size) && (index >= 0)) {
            return ArrayList.get(index);
        }
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new RuntimeException("Empty list");
        }else{
            if(ArrayList.equals(otherList)) {
                return true;
            } else {
                return false;
            }
        }
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
    public boolean clear(Collection c) {
        if (c == null) {
            return false;
        }
        if ((c.size() == 0) || (size == 0)) {
            return false;
        }
        boolean modyfied = false;
        int i = 0;
        while (i < size) {
            if (c.contains(ArrayList)) {
                modyfied = true;
            } else {
                i++;
            }
        }
        return modyfied;

    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        System.arraycopy(ArrayList, 0, newArray, 0, size);
        return newArray;
    }
}
