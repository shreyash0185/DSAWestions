package CollectionsJava;

import java.util.Iterator;

public class OurGenericList<T> implements Iterable<T> {

    private T[] items;
    private int size;

    public OurGenericList() {
        items = (T[]) new Object[100]; // Initial capacity of 100
        size = 0;
    }

    //add method
    public void add(T item) {
        items[size++] = item;
    }

    //get method
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }


    private class OurGenericListIterator implements Iterator<T> {
        private int currentIndex = 0;
        private  OurGenericList<T> list;

        public OurGenericListIterator(OurGenericList<T> list) {
            this.list = list;
        }
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate.");
            }
            return items[currentIndex++];
        }
    }
}
