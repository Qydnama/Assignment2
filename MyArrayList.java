public class MyArrayList<T> implements MyList<T>{
    private Object[] elements;
    private int size=0;
    public MyArrayList() {
        elements = new Object[5];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public void add(T t) {
        if (size == elements.length) {
            increaseArray();
        }
        elements[size++] = t;
    }

    @Override
    public void add(T item, int index) {
        for (int i = size+1;index<i;i--) {
            if (i == elements.length) {
                increaseArray();
            }
            elements[i]=elements[i-1];
        }
        elements[index] = item;
        size++;
    }
    
    private void increaseArray() {
        Object[] copy = new Object[(int) (elements.length*1.5)];
        for (int i = 0; i<size;i++) {
            copy[i] = elements[i];
        }
        elements = copy;

    }

    @Override
    public boolean remove(Object o) {
        for(int i = 0;i<size;i++) {
            if (elements[i]==o) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T remove(int index) {
        T oldValue = (T) elements[index];
        for (int i = index;i<size-1;i++) {
            elements[i]=elements[i+1];
        }
        size--;
        return oldValue;
    }

    @Override
    public void clear() {
        for(int i = 0;i < size; i++) {
            elements[i] = null;
        }
    }


    @Override
    public T get(int index) {
        return (T) elements[index];
    }
    
    
    @Override
    public int indexOf(Object o) {
        for(int i = 0;i<size;i++) {
            if (elements[i] == o)
                return i;
        }
        return -1;
    }
    

 @Override
    public int lastIndexOf(Object o) {
        int last=-1;
        for(int i = 0;i<size;i++) {
            if (elements[i]== o)
                last = i;
        }
        return last;
    }
    

    @Override
    public void sort() {
        for (int i = 1; i < size; i++) {
            T key = get(i);
            int j = i - 1;

            while (j >= 0 && ((Comparable<T>) get(j)).compareTo(key) > 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }
}

