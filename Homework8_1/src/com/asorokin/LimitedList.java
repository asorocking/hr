package com.asorokin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import com.asorokin.OutOfBoundException;

public class LimitedList<E> extends ArrayList<E> {

    private int limit = 0;
    private int numbersOfElements = 0;
    Object[] elements = {};
    Object[] temp = {};

    public LimitedList(int limit) {
        this.elements = new Object[limit];
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public E get(int index) throws OutOfBoundException {
        if (index >= limit) {
            throw new OutOfBoundException();
        }
        return (E) elements[index];
    }

    @Override
    public boolean add(E element) throws OutOfBoundException {
        if (numbersOfElements >= limit) {
            throw new OutOfBoundException();
        }
        boolean result = false;
        elements[numbersOfElements] = element;
        numbersOfElements++;
        result = true;

        return result;
    }

    @Override
    public void add(int index, E element) {

        if (numbersOfElements <= limit) {
            try {
                elements[index] = element;
            } catch (OutOfBoundException e) {
                System.out.println("OutOfArrayBounfException");
            }
            numbersOfElements++;
        }
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < limit; i++) {
            if (elements[i] != null) {
                result++;
            }
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        for (int i = 0; i < limit; i++) {
            if (elements[i] != null) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public int indexOf(Object o) {
        int result = -1;
        for (int i = 0; i < limit; i++) {
            if (elements[i] == o) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for (int i = 0; i < limit; i++) {
            if (elements[i] == (o)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < limit && elements[currentIndex] != null;
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

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[size()];
        for (int i = 0; i < size(); i++) {
            obj[i] = elements[i];
        }
        return obj;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] t = (T[]) new Object[size()];
        for (int i = 0; i < size(); i++) {
            t[i] = (T) elements[i];
        }
        return t;
    }

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
                numbersOfElements--;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < limit; i++) {
            elements[i] = null;
        }
        numbersOfElements = 0;
    }

    @Override
    public E set(int index, E element) {
        Object oldElement = elements[index];
        elements[index] = element;
        return (E) oldElement;
    }

    @Override
    public E remove(int index) throws OutOfBoundException {
        if (index >= limit) {
            throw new OutOfBoundException();
        }
        E result = (E) elements[index];
        for (int i = index; i < size(); i++) {
            elements[i] = elements[i + 1];
        }
        numbersOfElements--;
        return result;
    }

    @Override
    public int lastIndexOf(Object o) {
        int result = -1;
        for (int i = limit - 1; i >= 0; i--) {
            if (elements[i] == o) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        List<E> list = new LimitedList<E>(toIndex - fromIndex + 1);
        for (int i = fromIndex; i < toIndex + 1; i++) {
            list.add((E) elements[i]);
        }
        return list;
    }

    /* Don't implements methods
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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
     */
}
