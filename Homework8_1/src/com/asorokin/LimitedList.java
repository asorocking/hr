package com.asorokin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LimitedList<E> implements List<E> {

    private int size = 0;
    private int numbersOfElements = 0;
    Object[] elements = {};
    Object[] temp = {};

    public LimitedList(int size) {
        this.elements = new Object[size];
        this.size = size;
    }

    //MY
    @Override
    public E get(int index) {
        return (E) elements[index];
    }

    //MY
    @Override
    public boolean add(E element) {
        boolean result = false;
        if (numbersOfElements <= size) {
            elements[numbersOfElements] = element;
            numbersOfElements++;
            result = true;
        }
        return result;
    }

    //MY
    @Override
    public void add(int index, E element) {
        if (numbersOfElements <= size) {
            elements[index] = element;
            numbersOfElements++;
        }
    }

    //MY
    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                result++;
            }
        }
        return result;
    }

    //MY
    @Override
    public boolean isEmpty() {
        boolean result = true;
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                result = false;
            }
        }
        return result;
    }

    //MY
    @Override
    public int indexOf(Object o) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                result = i;
            }
        }
        return result;
    }

    //MY
    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (elements[i] == (o)) {
                result = true;
            }
        }
        return result;
    }

    //MY
    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elements[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) elements[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
//MY

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size()];
        for (int i = 0; i < size(); i++) {
            obj[i] = elements[i];
        }
        return obj;
    }

//MY
    @Override
    public <T> T[] toArray(T[] a) {
        T[] t = (T[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            t[i] = (T) elements[i];
        }
        return t;
    }

//MY
    @Override
    public boolean remove(Object o) {
        boolean result = false;
        Object[] obj = new Object[size()];
        for (int i = 0; i < size(); i++) {
            if (elements[i] == o) {
                for (int j = i; j < size(); j++) {
                    elements[j] = elements[j + 1];
                }
                result = true;
                break;
            }
        }
        return result;
    }

    
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E set(int index, E previous) {
        return null;
    }
//MY
    @Override
    public E remove(int index) {
        E result = (E) elements[index];;
        for (int i = index; i < size(); i++) {
            elements[i] = elements[i + 1];
        }
        return result;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = size - 1; i >= 0 ; i--) {
            if (elements[i] == o) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
//MY
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> list = new LimitedList<E>(toIndex - fromIndex + 1);
        for (int i = fromIndex; i < toIndex + 1; i++) {
            list.add((E) elements[i]);
        }
        return list;
    }

    //MY
    public void setSize(int size) {
        this.size = size;
    }
}
